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
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
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
import com.app.shared.organization.contactmanagement.CommunicationType;
import com.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;
import com.app.shared.organization.contactmanagement.CommunicationGroup;
import com.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;

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
        Gender gender = new Gender();
        gender.setGender("Sw6N2QLPWZ6ve1pVPyH2VhXlrIhqL50t4tpR8L3oB4rVRppgAf");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("ysmCAIdXIaOQfJDAKQQYKnQxKe4m69eavmEMCx0iP9NtGu9AON");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setLanguageType("Cn4XYajROQcPeuSBOaT2l3unJEjf4PF9");
        language.setAlpha4parentid(11);
        language.setAlpha2("Lz");
        language.setLanguageIcon("y5NuuSFzQQGpW4cRpw36dzVknXo9pOvuJa6GduYbrfRM4ykEa2");
        language.setAlpha3("byE");
        language.setLanguage("4qgh02E391H555l1IPzccT03CuCusNBEbJRgaiTqvbT0xBPSZE");
        language.setAlpha4("8YwG");
        language.setLanguageDescription("S9wEF4bsQCOyRyh3k5Fe1kuUhzfWDFCDwCGWqu3Q50k7jwrd64");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCities("s1tGTI2gmuAtGxSKWNK7W5nQy2tsvsslCWv82ZmckkPAovKYO6");
        timezone.setTimeZoneLabel("tLOIKCYuzBHU1eX78q64KssGXKstViokn8CiI2y9Ctotz3JLV8");
        timezone.setCountry("qjqTZ1Eti6V9SzCplLO3Y3FgjqyaEl0DBASx8KeOF9Mc22xY9N");
        timezone.setUtcdifference(6);
        timezone.setGmtLabel("2vXYE9XxMVQ3Aamc73jXnsE1xaUsD4j1K80jSJPZ4g5VPlgnWW");
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setMiddleName("rfkMeaBAhV2T5jQH3U0MqW4IPI1vfEXawTTdW847ijAG1pRZK7");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("25vDvBY1upROv47HW03sBIejDg9JsalQpIde8rLPE84kkSIuwr");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1465475219498l));
        corecontacts.setPhoneNumber("W5PWAmLcSKJZVlrnede3");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeMiddleName("xLcTnfsRacsNzZBv22tLV7xRbMSdFuoByCetlK7yx21eDymtHE");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("zt24420RstnS8aZztSZDlaJTuRrtwSiMjylGUPiwALj7KLgl4g");
        corecontacts.setNativeLastName("DmDi44SKAHcZqSeKzSvEErKcT3SdpAfmtjJohzDuyU8UYVJiLK");
        corecontacts.setLastName("DMA25v7mxdCiz7i6YCXw1xu3NVMaCyhaUISeCnwR8qhvvLrwpi");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setFirstName("3tW1ouK74EjQstOJdTw7MclY1El1BnbM6LQahNhzaZ70dDPgbI");
        corecontacts.setAge(7);
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1465475220028l));
        corecontacts.setNativeTitle("Wa9PzJnGh12ue9f6QyfUJIXfLjmn4De6S8q3gGm4AXlUMps38n");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setZipcode("LFRIHp");
        address.setAddressLabel("RajUFAIoTDs");
        address.setLongitude("zjBozbyjqTSQrEOqplsBFr3UyYO0iSOFBU0mzGru43fj3FoTGt");
        City city = new City();
        city.setCityCode(1);
        city.setCityCodeChar2("YC14RdthMVDFlJHfjgVyoN6d4USrsyy6");
        city.setCityName("Emo3m7Q3DxJTiIxVO9fpBXX9OJ4aznlM7cl7Us21D1uA9InVaC");
        State state = new State();
        Country country = new Country();
        country.setCapital("GLN7q9fHOw1OSwxjCdZTmGHZGyV7v3HA");
        country.setCountryName("yqNd1ICgfnlzdOb54Y0tXxv2jFhNV2TT7telB7HfF2lofv3CCq");
        country.setCountryCode2("LVs");
        country.setCapitalLongitude(4);
        country.setCountryCode1("0iE");
        country.setCurrencySymbol("fTkM9RV4p2Ia3skTKFl1BEfzZZft653H");
        country.setCapitalLatitude(7);
        country.setCountryFlag("wpRu7l6atiEzDjrkKvIxgNYEr2igWtnZ0PLNGN0a9rQwaOVysX");
        country.setIsoNumeric(550);
        country.setCurrencyName("ey6s59oDZmWcIIK9sytfoPRhhSTjSrbMIgKWHD36wbj96wr6fn");
        country.setCurrencyCode("9AD");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(4);
        state.setStateFlag("T6NOlUcshVGSNlUig0Wm9bpWH30Xi6AohrXDVZLMEqXhYRzdHF");
        state.setStateCapital("9Se7dVr0P4ao0WH6NJ5pQOrS1FZjEfpjvkHwE7HD6ZqzPXXp3R");
        state.setStateCodeChar3("qlHzKCJ3bt3JtbL8QkG23TzaSEBpByb3");
        state.setStateName("QAoWRLzea3tNOzfM0uY9vEAraKhPb8ozHOxcg9Nce1BD85faOK");
        state.setStateCodeChar2("dp26qqHKElgupdxNfgVUquShDaQUHc6s");
        state.setStateCode(2);
        state.setStateDescription("3NZ93nxfjFYa8vnqHnfZu9mBcjki8qdf0Ju0HCu5iqnMLqIY1k");
        state.setStateCapitalLongitude(3);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityCode(2);
        city.setCityCodeChar2("xXEVvdqGuadC5sHlt2buVosVp5Iu9U7h");
        city.setCityName("SVDLeh82nHKtwLjH6lJEeDSk7wr4t0IOtKlXowtIDWMweEv5FZ");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("Swt77S5j63TEe0tcakClvUIYp12XuXCWc5EY1maFsOJ6GFCuxj");
        city.setCityLatitude(11);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(3);
        city.setCityDescription("v2KscCQ6jEVLQSBwVUroCW0a2nud5V0HWTQuI7dbhUDO6FJduH");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("p821lvVKTUApF50p7RD7ndGRokIEopsTNBD737fdQVm8JgV4Tg");
        addresstype.setAddressType("2oCcZJgbOFE6H8KaZPOEBb14Ue3a2ju1m8rMANzaNJh31E7kXu");
        addresstype.setAddressTypeIcon("jtimTvphAzdYCfcWyyWh9k6uLiwL4TNnrGWjKu4odKkas08TjA");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setZipcode("9thLDp");
        address.setAddressLabel("NunyrhcwMRZ");
        address.setLongitude("mXpXjmnv7fUR3xghQBgVPj9lFSRuN04WAmuUT0kYgyN0YcRAKT");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("IDGnphz1RFMaLD5gfTz4swzK9GhMmwiMe9yqNtRjIbL9H55psQ");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("gzDb8yCFoYXRz6mHV541yvFSAy7PGy4hV8wBUzsWzgyBDtZSYn");
        address.setAddress1("212CVWTWPnc3dwDmJvtRHtRW11WSCyPkdyVWZ23gJlCcAdhgkh");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("hRExANNiU0LnUG2vdAQbW3nomZRU6iQ1Il6Z5NluU4CKZBeHIx");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("WbQ8IMN9GL9HsFrkWAwmHnmJx21rSztjmoijuZwYNK5GRZ542Z");
        communicationgroup.setCommGroupDescription("U1eH4vP4HjuU16cBPCRKqSut9Wx1LN6XRW7BC9foAFG379RWQ7");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("gUuvHj1xfGBsVai9vDacfnXh8ZUAvhOH7yjgLyXsQg5KP0PWCU");
        communicationtype.setCommTypeDescription("lkBDW8bxVFmz0jWF1n4OZcuYAJVOqxrkNLFyUBUVC5bm1ksyr6");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
        communicationdata.setCommData("682hg8Cxpt");
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
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

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
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setMiddleName("YkDwGm5RC7sNSvqV1Uy49PCqOyrbPsvd24sZyXsqse9gFblmnH");
            corecontacts.setNativeFirstName("v7oNADcFC4vV3zg2vS5OWGhEA0TRvhKSuuCFultAwUivVyN9RC");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1465475221997l));
            corecontacts.setPhoneNumber("MoP9hu872gQodxTZ81xH");
            corecontacts.setNativeMiddleName("KI9O8oUeEVj8bFOsQRFxKWSg3bFnUol9JYVnJo3Sy0XlDCP93R");
            corecontacts.setVersionId(1);
            corecontacts.setEmailId("8H2k1NYzHW9ICdnv3oiOyakAbyRme07cSTQ6ogF1LnYX95HP6N");
            corecontacts.setNativeLastName("1tQG9QAYWaCZaoqVmk1w38Z5g2QxUQvmctiJtd8dVx58mNCyR9");
            corecontacts.setLastName("irbCMnNqFVFE9Im2VRvAzEaG9DdNEV6kstE84EY7OrflQbgKZZ");
            corecontacts.setFirstName("hGDlep32crQ9JprUGoxnPdMTXzvBMImH31fxzC9d6GRJhW3wQP");
            corecontacts.setAge(34);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1465475222473l));
            corecontacts.setNativeTitle("VPar0h71NlF9UBjRSKHwdgTlVOCoUDHOSTPpBGKzadFlYPnIn7");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (java.lang.Exception e) {
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
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "vxK0PaY7unfNAB4upl9Rt4diWEEtz5GCQJyGIhJb5sZgwdzjyIZM8fb1pnCnIZqz2G1EZw1zg9qmBgLnrbMu6s0ZW3H0ldsJuG0T3sNzFo0HSYorr2StTbRZ2VvOAbXk4nDfg4ntwqpBlaO4Zf3QRTTM8O6MhtxYxEEyktmQJV7L8TJc4WzBWHMTnDPGFNGy3vjPivL80C79No1w0IWRcitNS2emEX6NlitOgogmEGbSIVnrWK7mYMZXDezJZl7qe"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "5EWJmKrLzl4YYeSacvQuxUsLp3RLUqKghGHAVYZsXO05vq1oA2N3wfpev0Rk4aHrFA71l7nmG6IoUqNcXZNUC7lG2UgRsl4CBQODHT7Sfv2yRgQFkNCYNKlD5OwU1EhhQoirZuUZ9geFJfFl5b6Q7P1OpY3R7zTi4xFckfXd2rKiqwDAS9pKwvOReSFHxtaZt95nPgZtMMw1PsjCrf1HwCow8ccD3n5ACAzLmNHVPcomzh0XtPqiL3iNc4aZBkgLD"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "DztIwCtSfG8ygJap2AuuVIiZePMjXisjUM11wl2YZyaegXgbm0ImdjYhyXzr87AjNWMPA4RdcqgCP2hJtQOZMSywxEt1pUzf19nUzQqDFwNHijMWQhhraEkXItri7ILFSUystNOnRu4hocuLx2Jq9CXaifcp1usfObQ9JmrytMADUi78ERMGu3MfSs2La5G6Gz3lw9MipreQIvC3EJGj4ozHBRSKhAsA2DVOI1bpInvwYckEJtjEWof7GYrciauDK"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "XxCioFVLpbaXNRa1fcxzWXFWq4ao6KhKvA4NbfleM1uQ17eblbVtNpvILaSEjWaq3"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "cy48LOzO4mK0asNpX9QQTYmWpFkrlWPNlJ3CBW1W58E3MgpNnZb4TGI7keQOJ88RvEE2chCRJmsNaGTN9wecbS5Wwld7NMzLzBhxnkkDqgTfuBgFux9sGELF433keUmBGIqCE2vSZzm48ehNDcWXIQ5YreEalTNjEuEuoRJ4SbjxGPFnhvGq1pdvRAogRBkId6aQEtDxlb3FzVKWdxseJ1ba1whY6C6TACGbeSJDo2B3joplAP53q5x1HdfbjE7Sj"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "TpYlDVGXohUHsBEl5rKTGlUfCov27BwOjNDNPirTeyyWCYEM7xTYQGhrLkfXnTbSzZZ5YwNkNrqFSyLOw0zlDBBxONESMHPjCmYcmUWTBw0t9xVG1EFSRcsUVTj45KNaudnJAEBzCGJALDZNeoMjhFlaKsDBLmzNE1gsIESgHaxte3tsyVDBg0M47fFwbrGfMAa0aD2TbpLWdHmNQTI2Q1GD9UOoEyYZkBRfRNz7oN63xMmXUtf833hjgFqqZ5fHl"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "C6LMMM5FQjQUg1xYwbHBA8XB3z9Ww5MkAXKTGZu482QmT5dBfOdzFsI7zKVelIRkmNOwpcjvyfFUa8ce825UAXL0h5XpGGfr8fuSsnvUoz1cdmatJqtG5hvzWAfzI1Lt5eM1cayB0De3gYUJSwQMfSzkP4jx8IcfazCaVjNOV8CRnoiVOlpuw0KtdtWD5ZF2ovo0pktGyjeAF33ffZBOOF4exImKqp8zBnIrkTyKaYWbcHmlDqLHXNu9rsK2wsao0"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 238));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "nFfM27XIvFXUG3ehL7vvTHs7yLRIOiNGY7su1qFO1suAhbbEkgfV4SoIRDztWgHvUkFyqHiYjgiy2rA1ZkjAqccvO6mz0V7KsO2MQTFdKg6Gc2IATFpA8jjT6NH0FBtGI9bF7TwYswkXCxcIBomRZgJdCanvidFtFhoTwrOiiRSrcqIskXtfli6tDNz251qYz9l5vDc8NPrOUckqBpEWpYJKE4NJ0lpUXtObr1wgeiadIK5zmHfP5j8PYpeLRoI1n"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "1WF8WX1JZPGw1YuYtpXZV"));
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
