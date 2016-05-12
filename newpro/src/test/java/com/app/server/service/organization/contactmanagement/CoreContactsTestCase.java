package com.app.server.service.organization.contactmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import com.app.shared.organization.contactmanagement.CoreContacts;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import com.app.shared.organization.contactmanagement.CommunicationData;
import com.app.shared.organization.contactmanagement.CommunicationGroup;
import com.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;
import com.app.shared.organization.contactmanagement.CommunicationType;
import com.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private CoreContacts createCoreContacts(Boolean isSave) throws Exception {
        Title title = new Title();
        title.setTitles("PVWkoHjIQjmdYTZNwii7kkhc4gzT42hNSHoWjBoG6bLbaa8ha8");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setLanguageType("XSZaDLB98FrMbdwyOi60I9sArNwobu6u");
        language.setAlpha2("Ii");
        language.setLanguageIcon("35G5AzM6syeMlw0yQs8ZEdXvTtiZHb8B5qqMfNacVzQNTH6xgG");
        language.setLanguageDescription("izMRFx366geb6CPwrIYUxpOyWVeRuhck4tpcnEfjBNeAdnxwKh");
        language.setAlpha4parentid(10);
        language.setLanguage("xsTdMgZPeecNqNtuS6wysBNMUV1GCkxFhvfnmtIgzKzljqEm7Z");
        language.setAlpha4("KUKv");
        language.setAlpha3("HX0");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("EB3ZTHVAgB0AKMxoUTk8vIuUyboff1ZOTXgq845ubEMPc8Aqxz");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCities("z7d3H7Jha6fNsiVl32QxQa7GY1KgoYW3nVLJ9RsJChj9g2jd8f");
        timezone.setTimeZoneLabel("bXMfziMCh3fGSI4NisDCYwEBkBFdeudm0WqblOisodDqbIK3Az");
        timezone.setUtcdifference(3);
        timezone.setGmtLabel("YiMGeIZ3QLv85UG6Ma0XFcSY3GQHieGGE1s58XY2r9PXP7qVvc");
        timezone.setCountry("xax586xABG59nyBRtDKERZ2KvmBqtca1ZVFkWAJqIwlnsvFzEw");
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("gDTC3HWckYtmoVVaYHczuQhJ0hfba1FPmTeJXOLYMnnOqi4TO4");
        corecontacts.setEmailId("r9Y8G8zRSJxT7Oo4WL9VuUV2g4EzzXpnEn2lmUmDMtHUkdlzdq");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1463048449775l));
        corecontacts.setLastName("layqGhwAvVchxzbt2qjEHuQjA87kYDaDF23p8szLHjGY1zsMk7");
        corecontacts.setPhoneNumber("oCD9eX1X6CyZaZO2EDvP");
        corecontacts.setAge(113);
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("fGvEh6GXVu24LNgSu7ZrVwyoGmRd6xX9ZzZExr4U4MVtxvrW3T");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeTitle("tAms647CfmAWVJRO8MeKwQ8dZphBhj0Rtlx5btAUQmF9eu5kit");
        corecontacts.setNativeMiddleName("CIfYUXmTjJsA0YoOpnLANkpQNfjJAGLRW3Y6cpgJSbz6b6FbFe");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1463048449910l));
        corecontacts.setMiddleName("jOpm7Dq90sbDUnRkeALOc0VgUwf4B9RdVzjJHbG3KSwBlKD5cR");
        corecontacts.setNativeFirstName("EId9RPP8DQj98YrUwoV9bTpVkcU9o6fb8c9nmcERi9U26fwEGX");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddressLabel("Rypu9kzf3Qq");
        address.setAddress2("uXNgPZgpdn4UKgbO7mfkW8vVJ7XMdWmWliJBp6bbWbXhnPtGHX");
        City city = new City();
        city.setCityName("SVxUyt1oFuE9ynDjC8weSfitPASJLCwP2O4ujTx2XabPPXdd2a");
        city.setCityCode(1);
        city.setCityCodeChar2("GF1wtVzwz7rO76i8Kn4t0qKwfmNMMXzY");
        city.setCityLatitude(3);
        city.setCityDescription("vlVBwEPbHtzNt8Qc7GofFWKcQxrLyEcELkVVQG53rzOrzTLU3D");
        State state = new State();
        state.setStateCapitalLatitude(2);
        state.setStateCodeChar2("6izmBxApsLtSRD7wYKGYjunA2QxTbXyG");
        state.setStateFlag("LvF6asZsazURbhdlnIKeQemS1Q84FORVMZ3PiVFsMQmuusM1mw");
        state.setStateDescription("V3qjDPsh8DxNv7tNLlTFejG2jEz0mQopDxyO8mrHAWMb1DYP5s");
        state.setStateCapital("O0EG6Us3zHsFlsBk71n8W5K7QFzwU9Uox4SfPcnGKgQi6Gtc0H");
        state.setStateName("UbW4YBScgB1JSxtj7NTQmRJiQ4HmZ1LT1rrUHW9kLvdolmVHat");
        Country country = new Country();
        country.setIsoNumeric(484);
        country.setCapital("HeiblYyDoGRck76LjKBXk2V1thjVqdjp");
        country.setCapitalLongitude(1);
        country.setCountryCode1("8Ai");
        country.setCountryName("NIIfj8pdT4WS7dtLA2VhSSFiUJRdmaNi35J6PAtTFlrJXyiEr6");
        country.setCountryCode2("6Jd");
        country.setCurrencySymbol("i0nGMz1iyWYbVgi6fn9fiP8awFmSRgb3");
        country.setCountryFlag("p5WbW5UD1UG41vGUnkL2WplvLkzUD17RfZOiVVvwlEGjaTkLON");
        country.setCurrencyCode("RyP");
        country.setCapitalLatitude(11);
        country.setCurrencyName("1WN2Eken2VJw8PPJBE1bq4O5j9OfN0s6JcH1f9eL8jU4O34fS7");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCapitalLatitude(4);
        state.setStateCodeChar2("KKWRDRPJa9HxDFj7hh3BDDx1JfS77q4w");
        state.setStateFlag("UYzKJbo0luI8PVAcwSIvPMCfyq55WLVwNAkNI35mj6nGQk8hGD");
        state.setStateDescription("Su3EQHA2IjYIIH7ulgd25aAYljHXe8r2g6jNxEwV0HR6A8ZU5T");
        state.setStateCapital("J53x8AIhOI72uee1vhagKvtsngJQpMBKcUumjT0agUR9HC8FLD");
        state.setStateName("9aQvr8yuxmxUa7FdBKnSjuAwReIsZySQMeI3PBrTFvH4gUHn8Y");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLongitude(4);
        state.setStateCodeChar3("VGHBWStMYw1jiaBZAEbE6Hjp39h2EdFd");
        state.setStateCode(2);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("cNYTX0VcA92znsmCbKXrzSY4ECOyh24gvrCrrF4fuVJL9frbqw");
        city.setCityCode(1);
        city.setCityCodeChar2("V9fJhhb0WlqVvZL1Ib0gIWvfLRwLmDfs");
        city.setCityLatitude(7);
        city.setCityDescription("mUi96alR3bKquwP7cWTbBe05FNHKDqynC7syjCIXCP9dLpjGRD");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("I07GMmtKlWAmLy9597gXSHUL1YiX5Mv0HHaYWjgxxUXWb3Nopw");
        city.setCityLongitude(7);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("8SV9cqEJQyXUdz6GqUVqGTpZeCNEtUpwlHyJx6Y77be2rsZVND");
        addresstype.setAddressType("I4qtq4Ox7lX4hv4w3hrlJxcgDr9gd5EMBpRtvFFl3z1CJvO4tY");
        addresstype.setAddressTypeIcon("GYmnkEPLtXCQ8Dt8ulzhic99F1RB6KmyGwHJgq0ZafiVSPTY9Y");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setAddressLabel("2l1r3pmvyv3");
        address.setAddress2("Y78seKXOzLiqRp4y8vRnGbMU54fd1Ve5XPulO0PRSTAY4ph48c");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("2sDgpr");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("0fUEg2mGr9phAZdPrubUPzShmpdqCWRQ9y3vuz6ZpiKZA6WJsw");
        address.setAddress3("MBplf7TasWs2jS4kllx2zwQheaGAP6h7tbRcid86jGwwVlKzBA");
        address.setAddress1("7rsgroEHhMFV8p8s3VnfehCOyyJMYRVUghWqzBk9G2PxUgneRF");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("SIW5D3gl54K4hPR9dtiHfpe8kHez2IiiQ6eB2HQi0HmlbLxvkC");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("CL3FDictfTUvLdSYIUtPfhQMFKr5fMIGHyTBHgROe48N5cUjiD");
        communicationgroup.setCommGroupName("LXkqocCrs3GvZ4wlTdj2J8df6XD7XBRfbk63WQEHZ6JNIpnzi6");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("70nKMq7LLHPf38DTrcAV14A7x6o2xTJLuwjL1zn2JgVCS1NFXh");
        communicationtype.setCommTypeName("2UjHiHhuUrVxwTsLs7Ed3AR7HuXg1fYRA6z9c0k8rjECH5ln0i");
        communicationtype.setCommTypeDescription("8UVMIrO2iPExuc5oWfENk6VE3sG6lXWbni7oglYFqQsJeODlQZ");
        communicationtype.setCommTypeName("Ps6VAz3BdWwpcLKshCbuNRJnT6oj4n94JR4pZWVDiZi0HVBgdS");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("YkrGetOPrC");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setFirstName("X9CB2K6t7bWKfPJpw5hqm8EvoOzT3yaKYtk7d5FU5Pj94k7oYO");
            corecontacts.setEmailId("sC1LajipTIGe30m6wkTgV12Fj4vHRu8DEZpu66HPi9T01QFJ8F");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1463048450282l));
            corecontacts.setLastName("ACbAMWTDFhg3PLGSMVibzWMympvjUHyhdFu7qFNKHClMdIb7ji");
            corecontacts.setPhoneNumber("hWG6S6W19WOlRLdzHnGp");
            corecontacts.setAge(87);
            corecontacts.setVersionId(1);
            corecontacts.setNativeLastName("SrwgqAPrnOmHnfVSGLGqdmrGI9Drp4tRrutNV8HlToACIMEraU");
            corecontacts.setNativeTitle("Dk04YY9QCCZwKnIpGrVYtROGbnkhmDDfSt4PaAk2h6wcFmRwMM");
            corecontacts.setNativeMiddleName("MmIE4Fc3V3CGi40IRuRph61udwdJTtcX3cMWvCZchvkZcN0Rom");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1463048450413l));
            corecontacts.setMiddleName("QzezzKzWjydwZU3Hm8OlzuKseaddgeJcfr1F6IozJ6hvTD761r");
            corecontacts.setNativeFirstName("M14MlA8CPzLzK4orlkCncHFPkEUUPWfKZfhLBz4KUaLsn6fare");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "JBS8l6dUdrdJxiQFnJVdq8IUnCYR4y5PuJA3NtoKSNFji5Y8j1MTYD3pa3HTfGTIfQu0Q0vONKv4ES9fQNLWnJCmxBifa1V0erfZ7KdxeaqEnMl6HbYvYCfvC067HlVSlFXTaVLl5DMIFQ1i5CJ8p49SI8InIxxiTiCmy853dTYYgDYYR8xz9vtXcjlx3aQJkdJck7K68x0Qj7CUGfBIzSLoB9Q5ardisQbICxp1SladfZIv2RDUDHivIdOCPbUnG"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "VS4xzexmxXVMM3mqUbl2JE8oFNPC0nptc2IXv1QndEPn9Bx6EsLIP5zcXK4kh3TmWWKQKPKf9bHJ5kRTHi5BkLAjoRNbQ92kXLhktVmRk8T2lzZBg5FHjQJgEGwuxs04kRlYPFxNnIYR6T1JXsj40iwS5mLLUQZH6EQsz6YtmtI8gK83GOFbGabs55dnjpd02zR9trA8Wlv96YdZCdIwULkL2yK6pEru7oAXKEZPo3LAVqxonzjZT2D2IY1CQyxh3"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "hHi6dfzSKcJDzwzK39Mo1HfVQ4TTzBynXBMPlX7X4dqv2x1oxOyvCCXUvv35X0dBRqEldt42hjTT9dpxGCdZDS6J8hIHP7rRFMu03xX9fegD0oEx453XFQv2nAsXWTQA1o53rPBQNWLZu5nL9u4qjrGBuGJaxgtWSkf4Q1Hsa7gVcycta6UvojisNpBgILJYM6CanTgoU7TGi2fJMiCQetgIOsgDbDBpzxLOYFtcJXEUrD9JRIq2Ju99l1gvXgUTM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "9W1wIQVgPBKKpV5hSzwn5sRskMR5Bl2iEWiYfAnGXydYYWLZGC5ILq0oaD9XVB1jH"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "clspBYRIwWGhwxRK1M2UgWztxb1RzKnYKzrvWX7mR65v0udnvV2GvKxBHUTNOLHXhpVfFUYuc96RrkKp3pLa4ohWfddVHapmYzeJjzPqJOgdohrQtcX00BJjVs9iPRKjpyYL6KnOHMVD92M9dYY8q8jNj1OO1OVd4GZ1q7QcW6dmH8DXntfuA2BtoR5dAwVbBK7ZetykCPqgyvFcJDtXqdtXcwENefVH8uJhPTIrFl3r7kiTpFZs9en1KGR4KJUFu"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "uuGQF76zBvNpxobZJJMNRCJIkmK8OXZO3yOsKLpECj2kbCxSoFlvy88ycjzl0V5sh93GY0vAD2CWCrdf3O4ktdbiXwydaVOxXFaNCkNJt756H7jYUXeMN1NvtCwdMTi8jM230sqjh1Rit2V0CG3Eeb6b5kgOWMHTW0OWPHMPmx0eehexbHSQ1mUbW8v7Ew85ZscjERRCmzq9sD4aY1k9cQNN0MFvEnLyeFLotcxW9glbYOhlffxEhghvUfMrEyFC2"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "pmse3VqFzl3f2sjABSMP8PgFQIQDCMUM81tYSc1zOBF1OXSc0mcf2wWYYNZ5Hi27TZwNHJ9Lx6cZcG4RXrgpVBceZORWF2DWNHJRLsNKvMuDg5t9Ss0uFsUMdMbCnsT9ZgHAXOPr1uy6Tnnly01fPxlrL1kxJqe3fUXaRwn3KsnU3ZkMN9FgEsH7qsCWHywK7XEjDOpV0d8q2gA41qKwM2yZCDcNGiPGo81kYwVqRmAhWc5XYI13FaqKRXekHdGDJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 216));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "NJDjAjQCKazvYHBGP44Hdtok11niGltWajgeqxMgR1e3lET1yExf53oMKxWTkX1spqxDJtFHSgxnhzc8opYTOEoUXZ474sv1HtORWVlJmW4N4uesCpO6GE20GUDuLKOJRtc4jPtbbWTRFCbt9Bn3IjdO5DEeM6DSynt4pBVioJU34Z6N1pt3OGY554iss29so7L6TTBmaDVyjMHzqv6T88ZEbZ0fvLflMA6QOmA6GTc503wYHaGMzXxtINWjdgtMb"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "EIc2qJJuzvItBDd3HBGfO"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
