package com.app.server.service.appbasicsetup.usermanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.usermanagement.LoginRepository;
import com.app.shared.appbasicsetup.usermanagement.Login;
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
import com.app.shared.appbasicsetup.usermanagement.User;
import com.app.server.repository.appbasicsetup.usermanagement.UserRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.PassRecovery;
import com.app.shared.appbasicsetup.usermanagement.Question;
import com.app.server.repository.appbasicsetup.usermanagement.QuestionRepository;
import com.app.shared.appbasicsetup.usermanagement.UserData;
import com.app.shared.organization.contactmanagement.CoreContacts;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
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
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

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

    private Login createLogin(Boolean isSave) throws Exception {
        User user = new User();
        user.setPasswordExpiryDate(new java.sql.Timestamp(1463035430411l));
        user.setIsDeleted(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("uS0mLWiymZNycA41jF5Z1WzPw4Xpu6MIAsEKTuqGpLtIPS9kWC");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("Ur9u8GRImSpxq1R421MSwGt1pfRpcFIIbqF0X2wdI3f9RkrnDE");
        useraccessdomain.setDomainIcon("HaeqYmbSvpyDJudKBQqkZx3nto53M8M9X5lP2VzW4rxCDRSkL5");
        useraccessdomain.setDomainHelp("OmQdFLsUQjux3Hdvf0nN7nSjRcyWkcmsDcnX9SvjudN73ppD00");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("MaRPG5POnkNVHfycGNUOotCqeBvjYQmBhVsddvTzfEzUysR0cN");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("z6lf945ARmSy3Kw5QcExc4qkQWcRP3hmFbeMTYgyW0qGNQWp2T");
        useraccesslevel.setLevelDescription("hZrKpXKX7W5HnrK1f0pP6hsXCMa8ZWCV1PIaMucjifwFOozQQT");
        useraccesslevel.setLevelIcon("XCosGjWihDGLbvnfQL8GA845gbHwfP4IiRWq4aT1My4q5lrD8m");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setPasswordExpiryDate(new java.sql.Timestamp(1463035430437l));
        user.setIsDeleted(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordAlgo("brXIw3XxiaSERruvgLQ1NBVgUN9D0Br5620H7OYv6DzqwWvDDy");
        user.setChangePasswordNextLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1463035430478l));
        user.setUserAccessCode(38373);
        user.setIsLocked(1);
        user.setMultiFactorAuthEnabled(1);
        user.setAllowMultipleLogin(1);
        user.setGenTempOneTimePassword(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setSessionTimeout(995);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionDetails("y92ivcqUzU");
        question.setLevelid(5);
        question.setQuestion("xSoL7lyxDtlNzsFo3Q4eWgAbe9hmsGqIYxyuKLLcNSHFjPSZpi");
        question.setQuestionIcon("Slb1Q58wBHtr1kq8MLyI68zsu14AhS4JP7CoVCVliEfSNv8RE8");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        passrecovery.setAnswer("AHXQrUnRPw8ySlCG10onZYOANRWDMyri0mhYgzI19ENVoyigaw");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePassword("jlC0H7ZzOgJTCUCyt050TBcVW3R3LR33");
        userdata.setLast5Passwords("fK9IzZ14C2e1Pav6j0FPImuMx2u4D2chy18Mh2bndY4ecAaNpV");
        userdata.setPassword("ZpFN9vdu0TZIQba7U3Y4D7lJdaGy1Uk1iOnSrP6p46DieKXmBh");
        userdata.setOneTimePasswordExpiry(7);
        userdata.setOneTimePassword("EXh89iy2qoXZnEN86dqtDJlcf8455hOJ");
        userdata.setLast5Passwords("7IfpQ1gGJBFt8hzYjCy9PemJoSt3oLPZSSTvEHqgSaVxYzpSen");
        userdata.setPassword("UzsYSXbsAjRox6Il3VjJQGYOQ4k6tZzDP6xfBaCFRjPC7fPZx4");
        userdata.setOneTimePasswordExpiry(6);
        userdata.setUser(user);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1463035430763l));
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setMiddleName("G10SfDel2FcuH6R2jlI6vjnyBcWsr88Ygo7k4fyQktA7SPjKmK");
        corecontacts.setFirstName("Rr2cEnVk5RYMsSrJOCZiWgBJGgD6Cj0s390nasNA95ZosnuHqY");
        Title title = new Title();
        title.setTitles("g4ye96eZ85rgruIBLHbav6kNK6rjjVhvunVUozt73HRUeOfWTY");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("7cYzGztD6o0Tjuhks5y7TFf2Y4T7d45r1cYESBqYGrSzs0e7N3");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCities("Tuc8ax0Fj3g9DZ4zVgLydCLSTBb3MdhYkeQrDYxonlluxJpA3X");
        timezone.setGmtLabel("8qRH5I702ZeG0xKuPPWXpJJLv23EXznFPXXkjTaol556U1PYir");
        timezone.setUtcdifference(4);
        timezone.setTimeZoneLabel("a55Ip6Ru8Ou0oJPY5bxaVNxMI9VhglsIVW332DRNISK1uTyn86");
        timezone.setCountry("8rOmdsKJSngeP29wv3SVKxf4o8sOaXPDXyiRrH6e9VVTTenkZA");
        Language language = new Language();
        language.setAlpha2("9E");
        language.setLanguage("Di296k3pPZ1k5RG28veWwv36BVexb7CVkc7chGr2yWAFnSB9mD");
        language.setLanguageIcon("hO6Z6PKBm8kk9YCq4aklUxrNxBTuPfAtvUA8gSHlwiQkBLmU2Y");
        language.setAlpha4("ELY0");
        language.setLanguageType("qnfWPVKsE0qMAOzjXkjAL2ISsmmzIv85");
        language.setLanguageDescription("TgmQVa62dpQD4JiT8gxyy7kv9HWrx3nZ2xKrkFFiXHXtBAyA2c");
        language.setAlpha4parentid(4);
        language.setAlpha3("UpB");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        corecontacts.setMiddleName("wnZOoA4uN54pqBCduud8gf59TF0uRaC59zxrNkPvE9aVDbpZ2J");
        corecontacts.setFirstName("jzjCIbETFMSeMKf3E4JMzF65ww7DEjY0kqe9hyCglWjngKltI0");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1463035430897l));
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("dfdo1pCrS78N1Jkrp5HiZU7URO64SJhB7wXeHD1JJE6SEuKypS");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1463035430954l));
        corecontacts.setEmailId("IJV3wmXL8gowb6kNQ9C45iccuK9rstoScP22FIlpCtUrGPZomh");
        corecontacts.setAge(104);
        corecontacts.setLastName("UKa9EaFtymrnuEGuPw11euDwdFJfs4hbyWKBQlZDuFBznoAHF6");
        corecontacts.setNativeMiddleName("O5MSlR02gqk2ICPLgLMCQFsU7jdznP7rLd2KpTBFbUw1vxxlxH");
        corecontacts.setPhoneNumber("IV5RVwu3sNifEbQX92KC");
        corecontacts.setNativeTitle("XvdEWNaNr0elxeKDLDogu8z7Y7MPjGSEcBo5aKfflfdfhUdDcN");
        corecontacts.setNativeFirstName("GisQKiRUE2m7aKRr8jY4CO7y95ZT4wBQ84M5cTkxNGhnPA6kS3");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("HcDV2nfnqXsdF0XGe9gLfqFNth6FdnoPcmcJap8e5eSEuJ2fXe");
        address.setAddressLabel("idD7qyed7ei");
        address.setLatitude("j3rdpcreuG1JI6kLR0C3NCKuT7XxxGUSl7MBTsKjSCrHwYvlRl");
        address.setAddress2("WmVxi9hdw2bv5Rvb8myCAQlflBrqcffxfyt3rdTuaetyWEJ9Il");
        address.setLongitude("z4fVrlcIDVhGrX13ac77oMoHGur9aKRUJ4B9fbmc2nDnbobLJf");
        address.setZipcode("aWJqfR");
        Country country = new Country();
        country.setCountryFlag("S8iczmqCl5OkzTr7jIOzdi2WVnRWgrFcsfM5Kp7kQOvNMg93Xn");
        country.setCapitalLatitude(4);
        country.setCapital("ZGppFuvcefcV4nZRabmUPJVn3xzU1Q1r");
        country.setCurrencyName("5zgpq4pwVDdgQpBkDGfcU26gdK3DlEv9xSVrSexC50CNjSgROW");
        country.setCapitalLongitude(3);
        country.setIsoNumeric(551);
        country.setCountryCode2("iAq");
        country.setCountryName("fcdEN4u5krfWJQIokV70RgRsZRCNqgINifvpVfzzCJ0NLM1yzc");
        country.setCurrencyCode("Zpz");
        country.setCurrencySymbol("YPr3AmtVfBvDd4vQHJkuAbrhkLDEF1FS");
        country.setCountryCode1("4oA");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCapitalLongitude(9);
        state.setStateCapitalLongitude(2);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateFlag("zBKpVQhVAoxQ1taAhPQlOm2oZiBVPjzfOQu0YeeXXHszUftF8r");
        state.setStateCodeChar2("DJsH87e2fQLaVYWjGnyhbxfM2VRU3Qbk");
        state.setStateDescription("wYH60KOabem36xLpIoXSe7ij5dShVS2mltfCp37vESCYFxkdK2");
        state.setStateName("hybZEBRgLMFLGFI2Q5gCaLexCgIqHLqOXuBgW4wWA0jIFoBES3");
        state.setStateCode(1);
        state.setStateCapital("pkLcGi3V4o4tqtuiXIqMuiut2jvyBk65jr2Cggn3BNVpxMRqmv");
        state.setStateCodeChar3("gBJxXQb7qSZlovCvco2uZqohBxypoex7");
        state.setStateCapitalLatitude(8);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityCodeChar2("7U7K8YywWG1MdDNyQK0AMy7VPKLFtB4a");
        city.setCityLongitude(6);
        city.setCityFlag("UgEIO77dNSc2QlcmyK9XQ91pHfvtwj71oVGHtrzLhwXU7xOQih");
        city.setCityDescription("pwrt2N2faO4Gn6iBqo23JyyjqQE5A2XtXRc6vt0ML5AnqA0S3i");
        city.setCityCodeChar2("cJmq81y7un3ERP3kuwhp1OM6bL0ci0JW");
        city.setCityLongitude(3);
        city.setCityFlag("tzUodSDqsni6MnXQHTbFEX60Jx0X8k3vnustvPx13Ti0l0m3i1");
        city.setCityDescription("44WsbqSUawmgIYD1eB3iy9FTQf79KQPNnGJU3rc43jfQusKgRf");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(3);
        city.setCityName("VtRc8nJNGTgasTzhjeGoTfi1hDYPOEH5N0sHXXW8U6ZjRxUpXQ");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLatitude(11);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("Qc7EmoovMeQSzWae2o9pF6WovK8K7yF2ponu3hhGcuCuIYQGVx");
        addresstype.setAddressType("I3BzUUHd7zyRtY3QNuRiHzuZIBfcLfOP4qcoOcuiOiyI66kLuD");
        addresstype.setAddressTypeDesc("pUUa66UMF3xxnerYxT3e21p6C1thCOR96msjCtw6Jn8a3T3BYd");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setAddress3("vJYUTHUWSxWFUONTCiIrtsx5mqoek6VqkWvnjf4nWmeQnAeZ4u");
        address.setAddressLabel("Scb0fgqWrSP");
        address.setLatitude("EGIJ5GS4B4iMCD1Aw2n9cNrxcQ27PtrbWRYpwl2KPPMyTnSdhE");
        address.setAddress2("RTEN7ZzYMvke6BjbCT56dkHOVv986RoOLn4yixgI2nyKiDetoR");
        address.setLongitude("wrINeApTSG6cyx7xrYXMeSpXuHvJo0wTSeml5e32rWpUxklP7v");
        address.setZipcode("wu0nFQ");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("yJv00WXsgeHpYzJeg3oQ4wm0Ug4W4CCd9YHawvHdt5NR8w9Se6");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("SZ1QLv2iKF");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("nl7ebD7QUoIQWAmCXU2bx339kVq682SjKiY7hYNsAKrZ8U8BY9");
        communicationgroup.setCommGroupDescription("4Wc2wwdWB7bKIQhFywwtMd0LoigHvQuSLh1VUC9Sik4c7CNHOw");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("496JvNtu0gNI0jLsrSHS17dMA5bfHzpvOZ3NQU2odOpKMqIb8k");
        communicationtype.setCommTypeDescription("1ji5YJHxPTqpvb4t3IrcSSH274gnV8R0SD3HlNil2g76cvTiEi");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("ZQfCjno3uJLMQYnh31G2x28Pvij9mX4ERe2ax1rZrcm8ppANNk");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("VgnacwMpVG");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        Login login = new Login();
        user.setUserId(null);
        login.setUser(user);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setLoginId("SoqX0rz0kJNBSFKbppEDCPrwmrUuYCxF44wZz9Ov2Iy7cR6wo4");
        login.setFailedLoginAttempts(3);
        login.setIsAuthenticated(true);
        login.setServerAuthText("qweg44cPDesHLmdK");
        login.setServerAuthImage("f8XnlZrG7pRJUOqkqJpOlCV0aea2IRvu");
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setLoginId("gLYynlJraQNEOuQLD9U7DFHqh59owR7nx3LPeqTgDprg78UD1m");
            login.setFailedLoginAttempts(5);
            login.setVersionId(1);
            login.setServerAuthText("XlfZeaUGISHk7HIH");
            login.setServerAuthImage("ZCZ2CHQjKy8TKOAf1qqOBRH35pGkHbLm");
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLogin(EntityTestCriteria contraints, Login login) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "CrQXE6OnaDi5Lo6TBDXc8457ib5pMH4GDdYQtGudyc2qHK57lVn6jNdhEx9R5ZtgPALE8NkOmAEvDG92aV3IXyfleaPukd4Ts049NlZPdThazsGj4b2hDNYGUY2dTntigiqMB3vDjJjQHtbO5yaXJ3ImUOeGPN126padIN9HPzLqGR1ksDu0JCAPX55zotkkBPrz6FlrW"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "aqCyxIy8FIx7IKD0VA0wcPblPEumfYAy5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "Ps2BlzKk7COQ5cFTc"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 17));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
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
