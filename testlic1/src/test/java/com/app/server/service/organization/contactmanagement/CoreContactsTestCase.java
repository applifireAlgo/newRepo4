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
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
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
            String logManagerId = LogManagerFactory.createMultiLogManager(_path + "/");
            LogManager Log = LogManagerFactory.getInstance(logManagerId);
            System.setProperty("LOGGER_ID", logManagerId);
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
        Language language = new Language();
        language.setAlpha3("CAi");
        language.setAlpha4parentid(1);
        language.setAlpha4("o4S3");
        language.setLanguage("sPRp630ZHf5BzpkHRTtHlR3vdCX2PyRhknEvK0Kj4i3Bmdk79S");
        language.setAlpha2("Z3");
        language.setLanguageIcon("FCH3Lvn72i9pWcTrzTH0Onxw5RxZaj0aAVGWOAOF8FteLRU3Iv");
        language.setLanguageType("dWZuQQyugVG4zr8m5pBLHooNWVuXCdHO");
        language.setLanguageDescription("xSBNiS2cRZ2r4L7IfSgG4YkPkg3b4seCoFnpNan0dmrVJCxjQv");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCountry("CbLPqhnpILhdEQDRPScqeZeV5c4MoxFZWXrkHiOSwUIUp3Er0m");
        timezone.setCities("8MOFOYxD5hG2NMbuLGbVMSlLd6kk1GgLCRvdDPf7eGdox3ku44");
        timezone.setUtcdifference(4);
        timezone.setTimeZoneLabel("SOBI5igslkEgllKdQMTTtI82mkbzEJppWUZTddHtfCOYKgHw7C");
        timezone.setGmtLabel("egwhXZSNhMTrt9Wqtx96HtRjxId4zGQo9oxD3jfjBG5WhkjVtO");
        Title title = new Title();
        title.setTitles("qBpaI6wtomkw6ElQtIQFDHZvbztMacxUlzX8qbVZsyHQahzqWQ");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("Eis3lzAJB1AouDzRBNOCK4xoBZZ050VJ0NyPkgwBNOrHLIPGEb");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setEmailId("x0ByvMU1w0xwOPEeIbqNQUCJprwaUEiibqVoQGiaPFpSMNTWAq");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1462446058934l));
        corecontacts.setNativeMiddleName("8QLaNVCenIoH5eFHkMgfnvSqlxwZWo3iNZcwLRbkIi3DkCXkJY");
        corecontacts.setFirstName("GcdZSGhXo7T9vw6btDkjfqtiNibm8BRMja1Tx8zRoLQowoGZO8");
        corecontacts.setLastName("dJDnbAFWCLBc73qZK1iYa5sbdgKp8fVxSmhGp1t1BAGpscmR83");
        corecontacts.setNativeFirstName("E8fB3MYbP26IQPj9rdWBjKI4nnxXOIT637ThkinyspJGe1kyvz");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("MGKxAZZTffojZZNVuuWfhm7LLpGpa8ZPG67Jq0o358iOx41US5");
        corecontacts.setNativeTitle("b7xXHXbEx6PhTTGLi4DkRdhKP7VbGFY8Su7lSK63BP7brUPQk6");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1462446058967l));
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setPhoneNumber("FNQJuU3ButJNRSQZTAAr");
        corecontacts.setAge(74);
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setMiddleName("etk7oioFvZ6gJuGL6M4GuXRjETuJw4IYrlMg2TsrJYCALCY4Q8");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("oDLKm0HonTTvxVdkKAVvDxZYay2z2IASwBWfmtWQBF6mxvoDd2");
        Country country = new Country();
        country.setCurrencyCode("2ur");
        country.setCountryName("mD1nYvMKISbZKqiCBsfCfv2vw36rCV8x7N5yVKohwRlIIfKKDR");
        country.setCapitalLongitude(4);
        country.setCountryCode1("SJy");
        country.setCountryCode2("qni");
        country.setCountryFlag("1Vu1z7MtjN1ECr62SJYCweoyMS4q9WWLwbh2MjWPNezpcwbmc2");
        country.setCapital("o3KroUfyHYzhJGNcOtSZYtj0qcRgOXsb");
        country.setCapitalLatitude(4);
        country.setCurrencyName("JQdoFf56lfxM2junfRBHmIFwnKKxqJ6tTgSWViYXOzi5Gc1F32");
        country.setIsoNumeric(922);
        country.setCurrencySymbol("Mmg87ZKgr0GLCxHWEPx8eNjMfwTsWgnB");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityName("07pabSVkQFg6deuTriP6ZEjXABaBBCM4V0AddZ87wHW3kwPwk1");
        State state = new State();
        state.setStateCode(1);
        state.setStateFlag("ov0S6eGzlR3KU32SyBR3OGfCOaFCgWNZ4WfXqItdTBChso48oR");
        state.setStateName("7O6WtYEc3PsDkd5M1cjiG2Bxf4cNwXXJlTs6mas7x4UoQObaUw");
        state.setStateCapital("RJhSmwAkEBrpcRj0CMFIxhccjSJIijcy4CTkWAJXEIThRVb49X");
        state.setStateCapitalLongitude(10);
        state.setStateCodeChar3("kHOOZ3H1x15wUUmpn2K7URJTXVDZCfzO");
        state.setStateDescription("NTQosTR2JEm6iw77TjeFEcvLgNylo7YYh0yDdGwvuNTbsY7nt8");
        state.setStateCapitalLatitude(3);
        state.setStateCodeChar2("HHSO1iyQBaptm0VxG7dTuq8wd2Zli6iz");
        state.setStateCode(2);
        state.setStateFlag("OX5e1HHdLoFjgk5ZHXceptPikTaL4xtjuqItFyC0FTyxc1m8Jf");
        state.setStateName("ABVcIMTWzoNjWpsfZ45FYMEtaBFWVD7Z6t28G9IyOfLpvaBms8");
        state.setStateCapital("FsjMzc47DG6pXvv4iTstijgkI9V4Kz0gLHRJXNAmCOPpGxru5e");
        state.setStateCapitalLongitude(8);
        state.setStateCodeChar3("O7vYRlx0xkZh75TxV4eCOtAc5Ffa4Kpq");
        state.setStateDescription("YUEYhKij85zE3acysjPx1cCfRkJIIJoC7CmX1miWQh68DNQrcR");
        state.setStateCapitalLatitude(4);
        state.setStateCodeChar2("GsTZYITFZjuEzpW2CnO9QGbdJJ14KTS2");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("BOQHUBic7ct18TFTO3Vc5yutZyRmMOlzDdkfLfeffvsRwx5uDU");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("FbXYJJcCIKgCEEjqElrXH5UXs0ChwG5v");
        city.setCityDescription("h5OhgC5uJqKiXA3JoFCrX678gr5b4H1Xvj67kSDBTWhqj5Jm0Y");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("IrYs7MeU8j7JWf55XDI3sXGMo1rGq5vjvpV1UMRoT4lXWJiAmB");
        city.setCityCode(3);
        city.setCityLatitude(5);
        city.setCityLongitude(7);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("T6vj0vPrQkMlHn7VTKxyLBprC2hXu9omiDrG1GjqKHNRYlpukV");
        addresstype.setAddressTypeIcon("CGpBwIIufdp4sn5yiiKNc5PJkANm9NmMxfYcWITJW5rKpDLiIs");
        addresstype.setAddressTypeDesc("xh0E64yCaRNGrSxd819ZGR4xDcCeCMjCw9hRpem6g9JrOa3oI3");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setAddress3("CFDbdJ58tAae2YhGuTbtM2SZIMWQ9yFOIgIKG8Oci99AMHmm1Z");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("QmWBDGZ8r4Z1E80o01EW3rXS79NnLtVJST1Fj00HWgg1FJ6TLi");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("PpbJsaSaz9y");
        address.setAddress2("mJleMlFvDQyDvEqLSnz8Li54J6m7NZFHi6qTkEtIMZtZcx9Mpc");
        address.setLongitude("4c55Kre4tsAfdd2FnRfYVp95tWPxu3RJ8RbNIQKiZnbadlVx3Q");
        address.setLatitude("NufiZtO5S8DwMtbpz0fV92BNa6VkY8vL1dbf1FNUrS3hpBRNdo");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("NNvcKF");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("9oNXlq1yYe");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("JooAvKArMTNGIZUiPZXIHT39ek49w8iLunn9L9A12mKpNjR2D0");
        communicationgroup.setCommGroupName("UNdWDi1Yht9ipbmaw3POApdlsQ9HMz1tgSjg1apNFuQcPf9xAq");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("CmejxmOVUutznb5KsZ3Uggzyl4m1RpOD4oajJlHDWzK9feSFnU");
        communicationtype.setCommTypeDescription("XPBMUlDNFQ5Gwoa5zP5tjVPNHUYkLbnJmulBTIfxONVix0rs7Z");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("b8IJH5m9WJ");
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
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

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
            corecontacts.setEmailId("5y5mpRFezzfmepv2xsM0rj9sltZaNTCHoDOo24r1vVjsc66hfx");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1462446059469l));
            corecontacts.setNativeMiddleName("WR6a4Nobj8fUsxUbcFskuMay1xiJsYSMytBRRviS5IOG7HJYAG");
            corecontacts.setFirstName("IdutJAIQcICrFsF73SWffQVnuztrDRlsgAm0P7TTcicUuHGMYj");
            corecontacts.setLastName("YPUJO8kvMivHsTklwAyhnhsCpqBAaazr7NHBw9JVjyO6YxNiIQ");
            corecontacts.setNativeFirstName("26vVRreBaXfcxfzVUSsbOPirbme50Mqa9e2jyiPkjQQli6YY12");
            corecontacts.setNativeLastName("UtDWZu8JRSeZ8UdZ9AGYQDLlqDtlUfwNwRvqk2WnhZsQU6N7IG");
            corecontacts.setNativeTitle("xuJ2uW19lQOA6En5tXJDSdJgCmlntR0ocCC878wJ2vOXKR9mRO");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1462446059574l));
            corecontacts.setPhoneNumber("d78O4nSuBKE9QTw3cMeB");
            corecontacts.setAge(85);
            corecontacts.setVersionId(1);
            corecontacts.setMiddleName("vLnlSLaXVbA36mMID9ZPS9AIwkhtXUvIm3NLO9oFXAwIAlQs1B");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (java.lang.Exception e) {
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
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "Qo9L5HZeShziJFifGGpbWrqCI03Z4R8l6mJk80ZRMrm10WcVh6PfCSzIiQBUFzD1ugCsHCmVNIplauQqZUdVR9yM845cqRvNM3bAOifMgsi9BLqXzXqusq0kIm3Y9fX7LGmcR2RPsidNMIsP9KYfuRMFXXI3QciLf0P1a2OqhAgpV476WDxUAIrwIRfJFWwOZK5fGW6uyNde6TSqxsGpfFKfyIHYg0KZk1YSYQhWCYpFIqphk4R8seeSjfImaAfEG"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "xmVAWUgvAlsRGAQNgOCXFueP8t8PiAZtTdFsu0M2YdP5tZEljZy78wiXIANPCUUftV2Yxxh2Di3lnfsuGGCB553R3GvJ6B1K8O2c0F2cAeMBr1qw0BdPXSVLMk26ycGWG0uBjyJtOOFPytgfmdFXV7ShLsPVcESZ8McMvr9XcU4Ic3OfuCwrN59P3zQsDQi7LK3e9x6aIZnsPmIg6k1oe8JTNCx6ZX4KoilJtO9TRGLLF4gcdFQsSCr7i1YI7dysu"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "IaXOIfHNh2NR8vntfijt1LfrABqHT5bCLD00GCTjw3hCfUw1hhqU575LceWXtcrZFqBNib0ZAzbStJRDlnxNhFnRQHSeh2lMMirzPUSo5edkJI20hDKFhWLCy14i77nO6gNkqttodogYns4AdohSEeVPDppYNZPKTgHYnXk36zqkhmCehSDglt5b9SrlmlCtUCjFzdG6gedIf5Wzzblrh19l5RfxcIrD8kvbhA8pF6QUr9z64yPVvN0FVlNwkYoBJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "LjGKkRagpjsw6k84dYQvPgMYOJwR1S9Mm8AP97wJd06szKy53brEEtKvc4luiIIP9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "ld34RAz8MOMfqpEelslqmYuSo5mEdIL6e7BkEEJDFolCG44QHI5MCSHXDch820g5Xc1o0wKVxQs8KkbgqvHRLpZBLIcgbFxrmVQyoFYCLqQIp4mH97vRGMOAgX6AWa9VfKby3VRmT035SBHv0pWNsuaHhUdP4HZpPqELzSxmxEAr2h8aXrsJS25wRAkqW8eXWCeOBnutfUGb8xWNUkLLhzBJAp3vNaKKi0vxmUMzT3BOK5DWJrpKhCYhi4NyuoMBQ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "pxcWkTE95mSm6OQroaLsAqTfBYXhoGOkq3YgjdSLxT7DSEJzVbFFsqvrFSsbgyhz5kYluBI4LL2beXfmAMSaNQ13ecDdrCJZee8BBJtjuwS0lDFoGeEjGmwLx85XUm2kFRjZVHLn0kr4O75vKo1wBhYfa5PysNCOUdcwTCIMxbQyyRshNOBOx0TufLXMtJkvlpJ0Swj2524fILR7mr2gA3YGeqFkci84oQgmFfxneNJmNXbaNq9VBLQ4JFhtru9lt"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "EEZrVEzGTRrqpxtuSsNUMb2G23Zx56zU3GGbcAjPtp1AZOuDEELcLxmzyL6MuRisJQ1umZ6PCQHsO837t8uRILxI9w4fxksz7nH3FqjIQG3JWpaW0c058mQTMBJHiVACgWzUoGSRoUIWJzc7NpylmuMmkktTLvAfW1DcXT5pT17gtMn4BjlqYj6WD3bSMbC73cGfetKMYthTQG3c3i3XYlvN0NRJnXScsurwjTuPEKoGjtjTouZpMVyqkBRJFVtWV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 134));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "QqzaHqhINgGiKlB39W1MMZR42UvkyJVfy672VhaOJR0jNZGc5qSvk2vHkfK6kUt9XsAXCB57S1IAsbKojyCxbqq23SbHT9mFZSKhPquR8BPh0szEwLN4L8bweY9HLAko738cEkx8gebp6zpme3sbzexjiQItic7Xu8yD1XokdwrCQ9wDzda0u580fPZBWr5Fg8A8ncnEIMA3CwYR14uwYuWGbzibxv6PeD1yY6qLzspV8edlMUwumEZJl1y1pMGMI"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "oIifVJW8nL3nf53YOnkYh"));
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
