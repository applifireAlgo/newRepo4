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
import com.app.shared.organization.contactmanagement.CoreContacts;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
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
import com.app.shared.appbasicsetup.usermanagement.User;
import com.app.server.repository.appbasicsetup.usermanagement.UserRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.PassRecovery;
import com.app.shared.appbasicsetup.usermanagement.Question;
import com.app.server.repository.appbasicsetup.usermanagement.QuestionRepository;
import com.app.shared.appbasicsetup.usermanagement.UserData;

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
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("lUEYWL0W4mahLrkMo2mA1mu3loQg5Mt3eA8LIzsQ46Muq1YQs5");
        corecontacts.setEmailId("3MZ8p6Qs3Ftha4fzQQyWvzCTQqKHqOtqUGovJ8PJk7ASixGvLK");
        Title title = new Title();
        title.setTitles("YKsDiG73weHpKm23tW89biiMV1V8IqXisuX3hdXgqyDIlNT58t");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setLanguageType("0ewX7c1btmYUDGuaU2hjSpdUFn4Yo6bt");
        language.setAlpha2("5X");
        language.setLanguageIcon("XtheTZ8Xfkm6gYFLXRijiTcR4HQHtEqPKpFzW8pqW5QLkvdpUW");
        language.setLanguageDescription("WVKe6ugvT913XdiT48WHN0E5T5n6Tez36xtEqoufosvbkpBa38");
        language.setAlpha4parentid(5);
        language.setLanguage("lVoVosIF7NM1EqHnFmsB5YG93AiUcIUwLlW2W38J0EasqbBCqz");
        language.setAlpha4("5iWA");
        language.setAlpha3("jwj");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("5tTIDPmwffMNc15SEikVaseMwuJEO3F1oQhcR0GCCJfd5JvLkE");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCities("b0tr3d0bDQfoxIyrL8FTSWnUlHOtTH5O1k5rDZywVWzMcsde1O");
        timezone.setTimeZoneLabel("sf94dVmMVL1JyjWKc1xWJJvteFsUgF0yc68NMRtkEtoQPIF9hE");
        timezone.setUtcdifference(11);
        timezone.setGmtLabel("0YvRP4TMoBwH4QTHRfEIZOU7pyrtTKeZAV8XGlpI5UWVF0hWfC");
        timezone.setCountry("2XeRMpjUvPmPbwxt5QvAF95E3AB5rsUCbStbAoNNXkZgVenApP");
        corecontacts.setFirstName("EKiEj6Dt19eOWJlFItz1okc8NeDLYqGLPynLImUeC5KTkdE73G");
        corecontacts.setEmailId("XOp0ANqPTAtscKKxbtRJyvoI1Kwvm1FnYyVsQC7ZyztDi0HFUg");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1463048457373l));
        corecontacts.setLastName("doA8cXEO7TVyAp0XeiuINmIbJy0QIBa0FTvAOIRAvrtrixTq4f");
        corecontacts.setPhoneNumber("Bv1pgTYsHubnrjXd5IJp");
        corecontacts.setAge(62);
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("koPrn2qP2meGDhRKMtaIMTTgA9YJT1oujF6qEiIDPfGbGZH7Rk");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeTitle("4WGeLLa7vbpSqJ1OKYjqcD3RNjQG6LdJYWrrejPVpKdGontnSQ");
        corecontacts.setNativeMiddleName("Q4EzWMWv6StmO5i8vZDtDvnGV6pjKmCGvVCRJeyTgmoIAseqbu");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1463048457498l));
        corecontacts.setMiddleName("bNFMf31cTLbRC9YvpnZNJVwQCYXXmHblsc9Iq9uM4Y8pAVEpQR");
        corecontacts.setNativeFirstName("jqXJaYWkQL619EJpHlM9L6O3bjtOHqqpj0r7qsQfhhExEFPo0y");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddressLabel("oxmGQ0U0aBL");
        address.setAddress2("CPdeUZaPmTo4ZprI6Noe1p9HQ7JBhNvqlqsdRr9cgu1pyjLEn8");
        City city = new City();
        city.setCityName("GJIRUHHFTeZJp0xF4GHDkGkNWudmU8RKq64U2eiLyR0QIVw28b");
        city.setCityCode(2);
        city.setCityCodeChar2("Yz4NQnorG6c1mbCj05vMZWwzrkMKuUrK");
        city.setCityLatitude(9);
        city.setCityDescription("Mz1rL5J57U6EjldI6Q3o8cWEzqUwsV3qVcclKznyR1DKa0SuKX");
        State state = new State();
        state.setStateCapitalLatitude(10);
        state.setStateCodeChar2("nBqDUKGQAAQpEBQu3XkbC8rMAUGvI5nk");
        state.setStateFlag("AYqk138ltlgMvSxr1CarPioQFduaQK2fpmjVlWXiRYVl1PfdEE");
        state.setStateDescription("Y0WZKoQLjgeFMpqZU9HubpSZeGFMkxBXPvBdyxDiuPWKeCVDOQ");
        state.setStateCapital("zmpRBCkHBc4t0dHGaROB88Ii1xQqrCS0iFLEz916fOncf75QpN");
        state.setStateName("vDiNy7MD4y3v5gBilxycY3ifz6wTru7OI9ZhTMcufOmW2JjSVV");
        Country country = new Country();
        country.setIsoNumeric(531);
        country.setCapital("ANxR13iMmmbRKIWkdYIrFmKaSEodJeQG");
        country.setCapitalLongitude(3);
        country.setCountryCode1("rb3");
        country.setCountryName("RtwO9JYtwL59qYrsQN8Sf8uUJ3DN5SbRwCLUKA2Sleby5WedRc");
        country.setCountryCode2("esh");
        country.setCurrencySymbol("CTHsckuC9pmTr7UowYCL77FiRT5p1rgM");
        country.setCountryFlag("85EwLFOlm9Hmh4mFG8aPDieErqeTtQ0McOJswjtbJ9NiUPHSas");
        country.setCurrencyCode("RZa");
        country.setCapitalLatitude(6);
        country.setCurrencyName("EqYNvrvngJA77kMyYok5rJljgfHaosUl4VjR2jtDqJam7abCGB");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCapitalLatitude(10);
        state.setStateCodeChar2("mbAPbe9FIUg6ACoVFyRn4XnLlqn6kw9U");
        state.setStateFlag("dU5ttFx2BahCax8s8eZqMbp9Jfrf1WQgBH8sNKg0j1aROGauA4");
        state.setStateDescription("wPub0kdn9IhHarpKp8vkpzPCEcdjNIIF9zjUWWcVHEU5pC77qZ");
        state.setStateCapital("P8jvBNmt6szo9NHzMnrb8zMi9nVbDfYAUd37thr15YgqBXuYmF");
        state.setStateName("Oin24YTnM6UamvTLBT01IT5o1xK8zmyzJMOlgMKMGPQFeNrl47");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLongitude(10);
        state.setStateCodeChar3("oqXHbrGuSgM2GDEZmFXSqDrmmHSnk8fC");
        state.setStateCode(2);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("MlzpaW8LPvdtXzGoHxY4CM1yLsBg7FjMEkNWxEVhqY4JJssbRI");
        city.setCityCode(1);
        city.setCityCodeChar2("zgE6ERVFUKE4hRlMkShWgpC9LH5z7it6");
        city.setCityLatitude(1);
        city.setCityDescription("OnmmvdwmiNBpn4suXWW7E755rByXAUG2pQwvu5sVHxK9kkhl1b");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("FgTY6wxqCJ8xZSTlMEdmhp4avz8xnFBSxKNLSOQ10GOuiYDHq2");
        city.setCityLongitude(8);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("rlbNG17QrIEzehYkkvMfb0Kun5tUXhYhgHPVRFiRvzK6ytNHGZ");
        addresstype.setAddressType("Aw68PCfWBJR96DzAMs9aNPKcHx8jmm9TCFSeAWuCi6nuzDzxak");
        addresstype.setAddressTypeIcon("ELXWA05ARTTK9jA55RRY7VExqDdftrGUgYU3ppQohhOG5ODmX0");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setAddressLabel("nvpkwSyLLxl");
        address.setAddress2("TO0pbOcMZyomyKzXq4ymYVR7SYlti9lXRQWk2Q6Uya9HEw3hEe");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("VYYUOv");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("WLQgHGhf0sqQzchRceySabxhaJZUKuM1Eo9jIdPdsdgiZsXfg5");
        address.setAddress3("iOeZOH5MUogBqTOwnmgRN4P54T2MnlLTEfaMpNHDsvWQHLodzs");
        address.setAddress1("Kt4YVYgHQsWXhqUMEvRxSGlFCYlDo98Yl9KFmiTBc8Rr24fD0o");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("MFZ7WoG47OWm6Ov0ZECjfG7RTrko3ouI8i3y6JzKqdIpooLO9F");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("XdrqD1pJFyAKkwIhfO8xp0qx0mVBoZuo0XA8BawMBdC45qsPaC");
        communicationgroup.setCommGroupName("hrCTWI0z4vWmg6wQmeDIFArfvQLxdGcCYaicaH3Ilcbm4k0xgS");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("Up8Szg9kajbV6zSUBZW1oPFFeuDzF920JjA4EFtdqGrmk4T4L7");
        communicationtype.setCommTypeName("47sihMiCxYLDqmCvJS6ToQgLCSDJVhz7Phndpg0BRJvO8NWV0Z");
        communicationtype.setCommTypeDescription("7psSALD7fbAiHkDIkLJHve6uYHRtsAuTiL1pDqOfhaRPMcWWjx");
        communicationtype.setCommTypeName("CwsOeFmU75qXEWJpmK49T1wiwZjqttoYWeNUsozRPiLO1Mseyn");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("XKT0CCjkwO");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        User user = new User();
        user.setPasswordExpiryDate(new java.sql.Timestamp(1463048457858l));
        user.setSessionTimeout(363);
        user.setChangePasswordNextLogin(1);
        user.setIsLocked(1);
        user.setUserAccessCode(42464);
        user.setAllowMultipleLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1463048457858l));
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelDescription("M3Xn4EDF3qiIgvK0jjHaK4qa5bdbytrvgGjwhQl4QuU5uObQjz");
        useraccesslevel.setLevelName("ZsH2kXdOoOn7HlM5N4xyG94hf6iP2wrBww5KgRq4fXaTrYMwGE");
        useraccesslevel.setLevelIcon("JOvTYuSRlSLQevZfI10IgsT3q3CPMOJnWeMB8ZHeFS7nH237iw");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("mEJ73DMgiPmNtLSGdhovdebFWBGv2awdcQckYDKYLqMJN53BF2");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("3Xsd7b1viiVSt0SH8nZ6kRpNN42VeR5aMQxPLMESr2sv1XKJXW");
        useraccessdomain.setDomainIcon("PupSmVU0BkVkLjWCCSSPh6JoAJykXcbXXLXZWDP5rYQPsTlQiO");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("RWa0HC76hUgj0jCnGghoyTTAga7il1BR01afcnkr8T9A0sTdVQ");
        useraccessdomain.setDomainName("ZiAuEVKq8B7ZH0RZVgxGUoAhNZbO0zpTEsW4J5IpIay51LPaEC");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        user.setPasswordExpiryDate(new java.sql.Timestamp(1463048457883l));
        user.setSessionTimeout(1196);
        user.setChangePasswordNextLogin(1);
        user.setIsLocked(1);
        user.setUserAccessCode(46624);
        user.setAllowMultipleLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1463048457883l));
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setIsDeleted(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordAlgo("MfqzHvUCGQQhajJtTjv4GL78FMNSOkXTdblYVzt6xRjrAsfc1F");
        user.setGenTempOneTimePassword(1);
        user.setMultiFactorAuthEnabled(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setLevelid(2);
        question.setQuestion("C9IgW6YuL14GgAe1IItcEx7yyXwpiiSaldxCn5FaRGe4Qr9hAP");
        question.setQuestionDetails("ceEAfgv4da");
        question.setQuestionIcon("biJcSKa2F6mZlMr4h2MOYXIljk917Oa10rV5RTjQ4ZKDCZx3Qb");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setAnswer("Uxt0rw1iil6C2vlNS2Hksvmzl9abUXRaxmeG25ywLRqnwCDtZL");
        passrecovery.setUser(user);
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordExpiry(11);
        userdata.setOneTimePasswordExpiry(10);
        userdata.setUser(user);
        userdata.setLast5Passwords("66S5nJnKbEni9ay6EgFeih0W4AIAWsuEIlsWfQaIwik0ULOK7X");
        userdata.setOneTimePassword("iF5ZpTKc2uHWfqq4ytO7LOwhnmcyBPc7");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1463048458227l));
        userdata.setPassword("Y8L8LdiLkyMaMQ3KaSS4gBq0LgpSCaJFmA4wlsDsaC9ObzalSr");
        user.setUserData(userdata);
        Login login = new Login();
        login.setLoginId("6K9OdfzU6yGPmTpdsPV9DnGxSk0JOf5WQGtae1ma5F4x4Wgc7X");
        login.setIsAuthenticated(true);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setServerAuthText("M7nkuRA4aZ0h0ScY");
        login.setFailedLoginAttempts(9);
        login.setServerAuthImage("40GhMtFGxEQFssZpL29wNT0fcpSUXp83");
        user.setUserId(null);
        login.setUser(user);
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
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setLoginId("fWcoGVbAPdFPxvIE4NLJoTMNsCUPWL54ImVdzGfbOiye0Isxec");
            login.setServerAuthText("bPFEWNJcuj6bEeZZ");
            login.setFailedLoginAttempts(8);
            login.setVersionId(1);
            login.setServerAuthImage("sfsjzfOtVsZk2fUhwWWATScC6cdbFHL4");
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
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "WREuA5XpAk6M9oTbfX0ElPVBFIdbsbcnBfRu6tHABvlT2qjBtBNia4jXVqRx2HvXE8dLU7Bsvylc79dgcKzP9ve5oJ1rINOVdYv5tXoUZTCgzXBccpRdRx9kDlCJqxC0ciyqWPiKESa3WMCKgf3xiMy52H8dSuCDsR7A8s0eIuPOE592POs7Smy1e0yS4C8OsuvIsSYnT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "YBVWMISipkO9LlSk2KMzF5Opi9SPOZ0sv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "7Cwj14bHWHG5qhWOH"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 16));
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
