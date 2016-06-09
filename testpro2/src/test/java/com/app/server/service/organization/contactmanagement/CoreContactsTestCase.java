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
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
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
        title.setTitles("7IfpQesAYo3tAEYBAhBTq073hlQdZmJrNON8FcgnV3wvhAzwbn");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("M6SBFaa5YySb3aWYXm5b8s1B78a7Yfuk8Wl17e6cHQDqDi6fzO");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCities("r8CgfNuP6vAebFkr8kKzMMT7w2c8vgbp1p1EbbVpaqmOpqufAQ");
        timezone.setGmtLabel("W5UvUTBxh3crfNIK12dLy54VhJEGDJFIRW9NYytpvzAoGJp6yD");
        timezone.setUtcdifference(8);
        timezone.setTimeZoneLabel("JYrv4ZVVSMW212NphsgVkAc8bkzig06mXVbkhDt18mK0E0A9Vy");
        timezone.setCountry("Lk0BXt0Qwkr9KhsRlyp7USj6iXhip5QiQ2zYqwA44qttkdVQmh");
        Language language = new Language();
        language.setAlpha2("no");
        language.setLanguage("WYokefvjKcDsg3HC7DAbaHv3iicND6rTsLl1HDYUExXQ4l8MIU");
        language.setLanguageIcon("KOF7VYZgwuDbzF61BWjlaj8rlCuZ2JP7E8dvNChZYVCL5Mq7Oe");
        language.setAlpha4("ebgY");
        language.setLanguageType("4a6LfqIXNYuPPGEwRXwANSRQvX0Q5qRi");
        language.setLanguageDescription("AIbYF57Kh1cicekoZbtWW1MzsLVAXn3PjrwK6LhThshWuD6Lxq");
        language.setAlpha4parentid(1);
        language.setAlpha3("Ccq");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setMiddleName("7fHeCcf41JmkYfcedznHjMje2tWqdxsC60ZutDmHr5K0hAgN8n");
        corecontacts.setFirstName("nngWQ0CuPo5oaPTLUcKyLwLYjjYmrJEnFVDRCVCTw5X3CrlyAN");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1463035423548l));
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("Odd76l8pY6NCca9cTcJjILMAWToWXcUAdpdFqo473zjJJa9GaC");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1463035423640l));
        corecontacts.setEmailId("T9kBlRHF4v40FEk1SrDFboCFGLlNAGFBrOqgUnU0j50DRMQ1HL");
        corecontacts.setAge(31);
        corecontacts.setLastName("OXyP95cmR6aaTeLVRqzMNNVUGEKmYY6udbycDlZkHd3pd8IQZx");
        corecontacts.setNativeMiddleName("X4CCbnaAyW3P32vBFqr4Dy7FUcERhjZtaQLLFAL4hnosu5oYlM");
        corecontacts.setPhoneNumber("5oY71PMk7Icyr2xR0sLu");
        corecontacts.setNativeTitle("cDkzoabYDpr2fXS4rHVptPdrtFjqGFLVbs1CjQlVpruJwFJHn5");
        corecontacts.setNativeFirstName("ePhwrQwg6VuymXAXptP5gOCrgu0Gfib9fhcmE18SAxbF1SPhR9");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("TEUx8poEircYvqQ30RuFtXopsPxvL1t1jXhuySrb6hyJNZWr1r");
        address.setAddressLabel("ZoJVziaOekK");
        address.setLatitude("lEKCSIIHYHj88KW26XZDsM23pDihuszDatWg51OnYhG8LH4Pdi");
        address.setAddress2("feP9FTV9dokoswehD3X0iviW0txpv5BVBnf0kRHHtVLcfky1qg");
        address.setLongitude("We05NgMsizv62PBNZRCtWLvRcFvkqAvsnh11r2DbnFvk6QWazl");
        address.setZipcode("Zb8d4p");
        Country country = new Country();
        country.setCountryFlag("5eTl3WRQY3GfoZKH3Sv1saVVtWVRXakOutsaXHOKvsr4opLIMA");
        country.setCapitalLatitude(1);
        country.setCapital("57D1hP6SY89ZnK8Lu0A2HQLOu4h5Cmt1");
        country.setCurrencyName("1lsAsjiGKQqZigBqhr0OLcgeSxo9nsUgr1cZ3YWJBBrb8aE948");
        country.setCapitalLongitude(11);
        country.setIsoNumeric(895);
        country.setCountryCode2("LT8");
        country.setCountryName("ZkclgWuw4YpZdZOxOjgYWmtOqkCymiNFMyAfR4vbhtaAzXfhAW");
        country.setCurrencyCode("LG1");
        country.setCurrencySymbol("ORYXe7lrTlVOZ3BzY6mpuaIYu0ZAL4rx");
        country.setCountryCode1("Oil");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCapitalLongitude(3);
        state.setStateCapitalLongitude(6);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateFlag("Wx7RSu0y2VkfVpdL5JbvC3wKhFBcB0lQiHPYlgePf9NbzOPqBz");
        state.setStateCodeChar2("u3Ceo9VWzW3FTjUXjGpWQzalUtXa7lmJ");
        state.setStateDescription("zqHWhuFkzSL8It0lj4smRt5ftW3ij0az8XnBVhSKdwZY03N9Ue");
        state.setStateName("7u5ZUCXud0o4lrMpNBEHZvzst23UnzUUomwkQGFhb3tpwa88qv");
        state.setStateCode(1);
        state.setStateCapital("OYgXyt7JnonpkH97f7rsH6DqmbWEkI8LasB5WPPce8AkcTYcbg");
        state.setStateCodeChar3("e1PfnIPbkWo3f69FxVDcxtbiyuUbPHUq");
        state.setStateCapitalLatitude(5);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityCodeChar2("jwAmnMpaVG77zUEjtFuCVd29SlRHCGzQ");
        city.setCityLongitude(11);
        city.setCityFlag("dMtRIg70mCLraIhebMgjwj202xSfbE3owz6l3rfIoUugqjQeZ4");
        city.setCityDescription("7v71Obynv2OvQVtcFhW2Afxv1zhjb5UbhYkSoO9PQ2XSosvtAi");
        city.setCityCodeChar2("6SjC78lwuVKl5tFRgWH7wGyHGg4tVweg");
        city.setCityLongitude(11);
        city.setCityFlag("D66AFvEh2iPO5W1hTvtKahd54HJLpd8L5GrlvmsGbhvAY4WJnZ");
        city.setCityDescription("wbylFyhAt3dTw7vNfFE5kESzYDhH9sKy6WzfnJKCOT5ku5xeV9");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(2);
        city.setCityName("sW7uDjZzkMHs9Z9bI7wRZeJGpdna0y1CQe2FLjHeK3JtWypiGy");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLatitude(10);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("yBPftRudd1akwFePsHC6QZxwaHgwzLke3lUSjCzbCkrpGfFBEO");
        addresstype.setAddressType("JfvEEUO4dy8k77w7woLYLUHxzMy8g8g281fxqLZ8l52feVpRfB");
        addresstype.setAddressTypeDesc("beHY7UG1BV8wwIxJMjIK3hAuxdXLkUEo6dKyajuvpTcoYmqX0h");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setAddress3("09unnRE0CrrkPJVjJJIRxLyzxk3YeJphCWctPZ8ZKak2NCcNzP");
        address.setAddressLabel("8BFuJBs0lUv");
        address.setLatitude("EYmNXFHkvsxAIfZpID8S0RuEpNdYyVCJaXFF6Jo01n7z7FwJi1");
        address.setAddress2("CdIkY2PbRJYziOKT3BRl0TspCOjinhTmLRffsx4NbwJQOAVRAX");
        address.setLongitude("S8fRVqkidsKhBX15F50VhShh8Hzpw61snpnFY5tI9GmB3vF6K6");
        address.setZipcode("uQomUz");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("jiju33no9TI16oTaaOWVBn52dGWcHioq8JUv21kOwDUTZ9bhCw");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("03gz3cUK8f");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("IadrMUxacYrJYvZ4BSGScb9BpYuV3mnkAPwvOKaP0oGJB1Bd4K");
        communicationgroup.setCommGroupDescription("eQPayfMRxDXSnZ3eakpH8GW0xPsRa1xY9lrapQV73XITqg5n4H");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("ziIyxPnWNdELaMUdgKIITlkL93LGCIVWxBJovKsQaQ4Gse9irw");
        communicationtype.setCommTypeDescription("7u2ANPFxon4V8kqepQaVBlPsA5eyt2PC3FzBUlNKElzDEJ503z");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("3ij01ZBeQu6XOLWQV0VNzmOwboQqH9to1aHvgWQaVgRRqh7aCD");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("edve0XXA8p");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
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
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CityRepository<City> cityRepository;

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
            corecontacts.setMiddleName("uMCwugDlRLPb6WyaYyyTLCLWar1vezkDQ2E5Ie5AOfKwGQhLAP");
            corecontacts.setFirstName("Tnwx6UIlSfGI8HvjhsuuOEOnRR8RH0t07oTK0iW3aDzwhcJwax");
            corecontacts.setVersionId(1);
            corecontacts.setDateofbirth(new java.sql.Timestamp(1463035424052l));
            corecontacts.setNativeLastName("a9v6ce9JYVOxwbgoCRh2xdrRBsjVlGz2OGkUuTCygN6Z5PvPH9");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1463035424112l));
            corecontacts.setEmailId("7XL7VpoDtGcDby2TWbnqbKAf6R44QZqbbCeQxWNLoE3OnZSJey");
            corecontacts.setAge(68);
            corecontacts.setLastName("jOwbCbFRCKLt5Os1RQklXzAoZFT3uDAYF1rTg3XObbHwaTI9hF");
            corecontacts.setNativeMiddleName("DEcYZ8PBtMJSKlxp7iSxfZy56Mg8xmUVRfubkBcIfM25TYUWhB");
            corecontacts.setPhoneNumber("KBYo0vaC4Er38QLiUXyM");
            corecontacts.setNativeTitle("5HAa9TkugWb5I42MIjDJW8AZMsdd1SPPJV1rxxhr9kdsipzOs7");
            corecontacts.setNativeFirstName("xUR1Sjl68RDHy12gklnviAIywOQ4sKMxi1982GMY8y3g0fVqvi");
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
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "V8uc1aUFw7mnP7BqcxH4LGbRmjJ1yEEs0FKrUOA3fDbG4HQ3tjvBHPxWcKFkYxw1SvQcaYCXrw9TUGJBGZYmycHJIzBt77WqXmhyqViS9z1TIEMnoA1O9zYpAdgX0HYAXHmhaLvURfSRWVukr9xeoFs5PmU8bfe7G8hahoV5IO3EyB2ipd7N2Yo0bjx0WY1lmra4nqJ5q1aYPWggwn7n2A6fP9EfmQoiPoKXtzTIPQVpw1LTEbxD5GsZXMGCpSvUv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "GwKK3xxBLPrWGJ1bKc94ApD7X6VDTyQK9vCLf94wzTHJNIKBZdYotRY9ECg9XTm4cvEwPJhsnqNIcXcViwTw2PvFrGuAsH8HTuiIPg5zlgxx1OBz4P6hIBuprf2sPHvrDJCcYhiBAVopVQieWp94wJH99eLTcBXZJiMHlvAkh6rOGwDqjRS4oVGzp9qG7ZIfZgTZ0d46rYvj33PxsyvAxzzN6EBRYKBsAwFuspiXH3Vh7yScsOv49gik3Hkcx86uf"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "iQHBHo8ohrR3GcdOnxRAvl09gS2kBT0Rf1MFGj0aF5uAx0N2Qi5An1MLRmhB9v6VevvvMHj8YoVmjA5Za91c42siBZO3WIWPFBmPpgMBGaX66yN4WUDYVyhGzwFOm0cm66z281re8zFwMAtIgtkxNuDcirauMY7h6SvV16AMLRGBtM58g09qf6lHI9soESuv8cAykdbrnhotpd9oKVxgmaOmDtTJ8CqvwKQPhz5q8C8FbStRv4EkDbq6HH97ymGSV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "dS1e0M25r8CPP3YMlmSDh5JNA9B5JiTByogneFO5olmV8VcChmZdOdEMZs9KsEG6P"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "dggh0jMebHy7fgGud1uLabPGFwngemYUBN60Vxfgn9oi6uUij2AWgsAAvIDlpax5jBitUN3OTUVo3VaMocCnTrHscIGMac1ArOZa2vIFtPI0MEG9DMoz9y20nnCEhp4m8LM6XDegwEYLOOdSTgA4Gu1RWDqfjfw8RgiTMd6zY5yRzaUbzO9QpZIuwYeDc2lhVbBXlPlvHd3Mkk4hviuHfyKreLrIMaUL3IAtSG79eG1eJvF5QMbOASEzxnJaGDFjI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "RhVoWIxC7QMlQFlqPsVt3QJlU0wWuNar1qP9gtGivy9Iu8cIHwiw0wFNZBN93NDJuMA2BBtXUxCmGOVE6Lo7QLkIPPhFdXyrqrGivvftkCRf9fzVO39nCcLLwItsBZvjRsRDt9MF4LWzqIIELTQU987LzmGwkaUpF2tqapBtje5Ol5cC7qPL61mlmGNlBLL00hLULexQPQkGb5eIqIM8OXMxKeut0w1axlwphPGOPgOHtHi5hV1HLPHhfbpPAc9TM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "yHnhRrueSEfBRugc3CQEs4hR92HKmJZtX6oo2ISGS6zkwqs154tyEHx1U2gXa6neIwCGoihyHYhyiVCLu5kV9443rv4uaSTVZiX0YzNH9EAr8aNX4coieyvbtr92jq3NK8tZht9Ry6Ypp607n3BJYandwTk3eZS0p8JsxSkqvbyIvPHYUim6tDgBopTuBIhGA22Eaptif5eNqMz6QQX4oEvhaVVuHY9Dwk2pnvfpg4XeT0em9XAA6xKKky1V7D1hD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 226));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "j8crjPgaZU4DZ10hn0iNpIGWEThVNOX3wcYSLMvKS9k6eUBzkDOBxdoRp21btlL9lSQNZdcQqcv3qsCNpIALdKr2sdxyMp51VjzvevNFRHyuqSl38mdGVuszjuMf3zxLJxZG4q8y10HqUxWsjv6q0uN8YFL6pzFnGZ3kjQg0q5bOU06AhIV2Wuv4TRYZMIQFEBM0Fsxm2cr4Ma5OiuqrpgUlfRSZ5aE5l5J9T6tFAzcOnmiPU7CX1ZUR5pGDh45IZ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "bth8XSScC7ZzXVHgPfmoY"));
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
