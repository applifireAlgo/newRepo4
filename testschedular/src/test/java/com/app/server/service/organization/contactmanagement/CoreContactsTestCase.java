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
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.contactmanagement.CommunicationData;
import com.app.shared.organization.contactmanagement.CommunicationGroup;
import com.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;
import com.app.shared.organization.contactmanagement.CommunicationType;
import com.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;

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
        Timezone timezone = new Timezone();
        timezone.setUtcdifference(4);
        timezone.setCities("kjBe3spFTEOnThvHp9i2fUIFoDCbrkww30SlmBh7gZk4wYM42P");
        timezone.setCountry("h0qwkPrf6y6eNplXoqZBWImzaAZAlgFXIefTDeA4V85JEkC1g0");
        timezone.setGmtLabel("DhW2wK8km4Xt9ZXdFQI2PwJ6lLIJ6IK3zrCnFHYaVd2vAZs2cu");
        timezone.setTimeZoneLabel("qT5SsX3UmCCe831WeND48wiWNhA2cffggtea66ncH4XyYi47L6");
        Gender gender = new Gender();
        gender.setGender("7orrAElwchOfpJC5k4SnDw4HVr3rhtEN8DeBh2lq6Ie6OBHYNu");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("wsoVm2MayuqiYgfk4bdU8UheNmJ0AZ611CF3Z5H3UwyiPY4g87");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setAlpha3("7WR");
        language.setAlpha4("mB61");
        language.setAlpha4parentid(3);
        language.setLanguageIcon("y31sJHIVBAPS7dH1AyzNIng5KlBU9BabEixZ4RMUp2gByewxEX");
        language.setAlpha2("sl");
        language.setLanguage("4Bg9Sg0erlOANs77Ic2p554HJKqn956GEPazftAN61i2cEgGqQ");
        language.setLanguageType("mB60lhelOVUJtUSHgUwq2FL4VMouMriR");
        language.setLanguageDescription("OcQIztGMpQvzrgaoCsE1rMmQsUq61IgETjE0FqabJHoiyZPCdG");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1463642650129l));
        corecontacts.setMiddleName("KRMNFhghM4EjM0lGDKcETLqjdU3ab5D8R1EH1VBi0fMN45Fqy5");
        corecontacts.setNativeMiddleName("ByHzkW4WzswAR6z7GPexfKt6Jafo2g5BZy7E7kBn5S6nLU6qkC");
        corecontacts.setNativeLastName("dBU1PHBV2bNeLYMhFgG68XDHNb2UUdsGZKKFo0plEvcaGWGmIb");
        corecontacts.setPhoneNumber("3pygkmq0Le9JzeKFGt1P");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("25RhePRE7MV8OqkDbgafmKjqHaXtWbrS9q9nz5Nowi8YkS96on");
        corecontacts.setLastName("NliN75XUifIpMtYzHs9mkQuXxZUmVsekb0xnvSHQKF8OygYJ2o");
        corecontacts.setAge(32);
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1463642650194l));
        corecontacts.setEmailId("haKhE2007Q2j9HPMxHlkT8LTbTN1fGndVWBE2NPomoyvuFAOTE");
        corecontacts.setNativeFirstName("wcEXcBZwKhD3ZvFjUiaDnGc1lzNTeh8g3uXaDEADf31sE5L9vR");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("RDQBleQs1xDnpm7yLzWS9V32B8ElFgiJMaZUbYwtX8ydxfPV0k");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("UTB5at4yPS");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("UCwfb9qGse9iWmPbxHGgM8cDOUpk4h0KpOzGmfYzjDdSSRgN1z");
        communicationgroup.setCommGroupName("9pTU6XpViKohOPnh3EP5MePw03qlqZpz7CeL8ZhZWVFtgeaPFZ");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("warSYgtBJKTzxuBUln0yxSOkZ5c9g00ZfwkhHWZpF4j78j0l08");
        communicationtype.setCommTypeDescription("D6pDoen484f0MF5mnWDsUZf8ALVQClIPT5ZpF2RvxEo7aRQsGX");
        communicationtype.setCommTypeName("VYCGS3XBNnuPLTQV5IgDxyVMNInCMmbueQdWTRfhhzredcu64o");
        communicationtype.setCommTypeDescription("FqRfAe3RhudxrnbK9aZ4O2rXkSO4w4pyVwuqbZdFMQ3BBO4qEo");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("A8RBUZ3YUi");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("whS3EvjtCbNF0F15A2gG7NzEOFmSslAphsNG1gQYgC5jbljH1L");
        addresstype.setAddressType("HF2n4BS4KNshr1kpNY73Hyu8wkvrEj11bH4dFoM8vc6R9plDTR");
        addresstype.setAddressTypeIcon("p8JaobInMF9Niqs024WsqPvvkQ6WazL2ubqOE1DpFyMDKKqb6f");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        State state = new State();
        state.setStateDescription("om4F3qoXtWZaOTZ4sjbHLL8ebrs8CQqHGhoASoi4GdWCg2dLRp");
        state.setStateCapitalLatitude(8);
        state.setStateFlag("NhmIiwDurHdBtbLbY70ETlR3vOv19KNK87CJXk60hxrELJvuYL");
        state.setStateCapitalLongitude(4);
        Country country = new Country();
        country.setCountryCode2("Nj6");
        country.setCapitalLongitude(3);
        country.setCountryFlag("XYRyNSeVHZmhHW5UVgx3OAEtFiHislXDpXDB5o9d9Um5IIE2v5");
        country.setCountryName("AUOi2ldwWQ2NfDY1NsSpmhpsJjzXIzuu2nRZrnTqmMNE2yrboN");
        country.setCurrencyCode("wF9");
        country.setCurrencyName("e14ezazVruNKhdUf6M84nSmErOh5Ftnz89e4PqbsVhbNqvlVfm");
        country.setCountryCode1("lZ1");
        country.setIsoNumeric(119);
        country.setCapital("PIsHOdAUk8SmtGFrnRX33DAyfgwF6Uck");
        country.setCurrencySymbol("43eegtaK1DbLh5mxVlnrOjG3FQWo4kuH");
        country.setCapitalLatitude(3);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateDescription("8wzODy8dY1dvBhHg0eWI79WQhNecxqMEcBR6SMutIj21bsheEw");
        state.setStateCapitalLatitude(1);
        state.setStateFlag("Wyw1Ss6FnkFlDepFHxYNw8vKt1v5GqgstuJGrD4SmQZN4aC7RO");
        state.setStateCapitalLongitude(11);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapital("WqvvYhRJQiqNrMLDISNrA6YtALqVyqiGCz2XA1qwFT7jKypU4g");
        state.setStateCodeChar2("pI6b5DHfCtu259E23LRpbHoErbtmC4hl");
        state.setStateName("qewNkhuTrnWBEqatSOIfbGhUaCX25z3SPqTOwEVJPMOI4LOL9z");
        state.setStateCode(2);
        state.setStateCodeChar3("qfDHhQXMonQImLgxkKA3Lx9gPdMwrKIg");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityCodeChar2("dq4625bXeEjCWa9ulceVEcTw0YhKoehU");
        city.setCityLatitude(6);
        city.setCityFlag("pcY4eVUkxr9Ldt4p7RdAlkFZP2fJP0omflH0aMCnkjb0RxTFL0");
        city.setCityCodeChar2("3tcxJQm3rPSuNdgkooMErf0lK9VkLEBo");
        city.setCityLatitude(6);
        city.setCityFlag("d8VTZu1VRuMoo06OYLgdPAGfftNYN2JrVMH3plqo56It05Fbph");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(3);
        city.setCityDescription("xS4dkGIKFszrQ66Sb1n6dOei4JuT3m9hELelEPdvGseDP8eOdB");
        city.setCityLongitude(3);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("hF1rKg82ihMUj7saMqa6jZV6r5sT9vPWfIgZX0aDheeC8ekUh1");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("RSWFsi5mQVe1MZOxyB4nI8DjCU7988SvMXn1DCBkRBtpajqH8t");
        address.setAddress2("757zQKemw4UwvAns72ttpTqTaMtG5Z730VSsBETcXvIlLgyU2W");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("iG7gk9C97OQOIs43nI283qRxOlBtufpdkucKxvqK7eIjyb2SXW");
        address.setZipcode("00YLFd");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        address.setLongitude("spoKGunzFsiUPAfZ9NKQhomASAMCRGTYZwYlGRW0Pjopi3NL9o");
        address.setAddressLabel("rkut81pPtNA");
        address.setLatitude("m6HqbnxmGkJtSU7Q6If4Qq26esKfrkpEXWVn3Y85k6MKTN3KZW");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
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
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1463642650657l));
            corecontacts.setVersionId(1);
            corecontacts.setMiddleName("FrzY6Ja9I2jiQhBDyp570r1qqIxpVZt5MEgLddf3BuZkeJ9pCR");
            corecontacts.setNativeMiddleName("OBBMBOuKrdOVMDJHMJ3HZsWIcX9sNCI54vtZiRF7PGqEI85tpz");
            corecontacts.setNativeLastName("ttAk6l730G3autaW4h2JelaB8hOsLlGc3HXq4T7BvpM17gxftQ");
            corecontacts.setPhoneNumber("QF9Urnns89dZqzQQO9jk");
            corecontacts.setFirstName("4fwJEjSbXLUeVJF9VHXIqt8Yyc9xZXeX2e7ADixQghIsdPD8FK");
            corecontacts.setLastName("CfcaFvKEkoZgA1ricSMfBDBOQEqZiKRRrhvq9SDyPLi0Fxgg1D");
            corecontacts.setAge(54);
            corecontacts.setDateofbirth(new java.sql.Timestamp(1463642650821l));
            corecontacts.setEmailId("lWWTgnluGOdIfPiL3TxJkrRlLd6vXtt3qeA7tX5XLuhasFx2Gg");
            corecontacts.setNativeFirstName("h5Nfsy0WmfEqKhrxYgQHyqoYuBnGwMpzIJBQqXF2YyQmER78XC");
            corecontacts.setNativeTitle("hbQx1YXD7Ypja731b7dSgbP3vWKXYnnbi4bW6OlffsmMbtDq15");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (java.lang.Exception e) {
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
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "NdbsR4Bznq4LHeJgJ6qa9KhgbjHZ3FSb8PhRxJwOrv4PWSiAMZtrU0idrica42L8qjcJmo9mpimVFNZseY6FghwFeWgvg7aqkLNIR19EDf76reyRO7vtA8sxSQYA4tChUnidxOrlE6df7MF24Q4gnCli40GxLJiue6NI6sPaOegUhAkS4aFKit7JRKKgzl5qNa9p7Km2UION2N0kVU0pm4slRjEjs25QuEySZot5ZqnjtaUhfqorbkCNhPNuzUEoL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "Gmz7oWOdwqFJ2OmUIAnMzBYXYHP8fhpf2PyCMstsLeZN6r2iV2aCdibYVy7aBEPeNGZW4uvs4TzDsZY3fFDQhAHeJl9sYH3yKnkk6QENZzPomdVDd4LD66xgE6DJ2wzSzE3nzhpwiSSF0o4gZ4yBax27ovWUxFWQyo6KYsNDzmWTN32PTvkRiRm5y989heD825zwFFH4RwAfiVuYuT9V0M2kESjXGz3KHBuYCzuJp0aCwYufi1ChXu4NPKSZPKVyD"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "lsIIhxDVZ10PUXCuTHR4FltOMb3kFU2r1rvslvsLpbk3KxXf3D3Bt3W7sFQmaRGcfmUvARAo64BuDt9TfkEf4nbqsYQE37RkYlXHJsXsuoSAeRG8t1Kq9lJXzCZm6ZJ9IxkqIzPfZtatiIw6oaGcoO8b1bM0dlwWziwh0RXeABt83zLw1NrkR8jsWzMjCQ1nYeTp2isCOsYdUPUgsKRN7uSctC5MkgS0zjIGxfGXVm67xbRMrlLf396pOqZrtiiOm"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "J2epgyR1z4xZabm2OrZXsL3hhsp5Ak0tIs6fKr3wdlbRLbCjVBsyMbwkZTtrtkUo4"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "jfebBaUejOBPXEDKaA9mROfXzFA50MXldyskRs8tpqPvVflbrIvdDezTKruv3XGB5TqaTJY0pkDcOlbgmaXrh5RGIYGhjHA4A2pa2EpwNPtXG4EPoi51bSPqwXZETL46Wsf8BfzBxoM8zzhs0Go598VIsGgxkon0kybyLokCeyXMFv7lBgaAb6VaTW43RjYb0yQTGktBYFFHkkMVyQwojMFTQpLhbhSB1Is6NpsgLZTaCMoKI9dcWTO0j6Ps0LIB1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "ou2UFZbvutV8PFj56R2UPl5tYNR5Q1lMqjiPOe9AhXZeo6BuihdHOYyP5h7s1SZ7kcOCYW3TEL7wmR0wH4V2THDeaJB5TF9wd14F1dZkALMgfcb6tz95fcIpxtNC8aoCkt71mdJ00jLOzS1JSCeDsj5d8GYlxu4pzTDgXVOYizDZZFK5vE16ajKgOfQr9JONGlDAUlHZGQjjkFw1Vs5uIYut6PAgJCmYlgBL6tWQJwqCitbfRYRfassLhSuqlNW7u"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "DUdzNhJiRb0tfxXRf4WqemNptJZRYfSrqsZZAOrN2DJTX4NjqmLzWF4wx06tBtI1wctkhSivC301AkLtLTzgs4s3eq7tevwFurfwcB8OiQ5CaOc77OqLjdixlPHA6TzXuunFjuvBSngWhh4V7psmRlHMlDzaQdPnBYVUgR7jpyHLFNEUL0Mj8oer6lCccl7OUgXdzlhWUeWrl3BcyewvpKAX1wFOm4mljf4YqqhpJ76zTSzELB9FWtmZ9y0cAGTnn"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 176));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "wCH6izob7OutCrR66XvlbQQYJqN6C7EZmbx8JPP9jo8s6wL2uEDRV3uLyDxfn5uBuHtstWLizTuMczB2q0Ge3Q1z2Z1NPW0aPmbgC6Fy1AqziFszig18D0Z4uKKvngx3MVYS8wYVkfKwidaa6IeuT8dfgzhJcId92GKZ1BoQrZJvm0R5pXnqycdPFM5dGX6pf5NvjalHd53C6YcCysQ2IbW2juZqRPhhcIw26kW6Jx124aCYimi2BaCRJ2zQ5TJTS"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "tv3KVmrKjurw5ZcAzGW3u"));
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
