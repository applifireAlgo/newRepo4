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
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.PassRecovery;
import com.app.shared.appbasicsetup.usermanagement.Question;
import com.app.server.repository.appbasicsetup.usermanagement.QuestionRepository;
import com.app.shared.appbasicsetup.usermanagement.UserData;
import com.app.shared.organization.contactmanagement.CoreContacts;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
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
        user.setChangePasswordNextLogin(1);
        user.setGenTempOneTimePassword(1);
        user.setUserAccessCode(24371);
        user.setAllowMultipleLogin(1);
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelDescription("Cbn3Q7s7g1yfQPyLIv1AugUeTXmqNqQS89S07416q2xvLUQQFu");
        useraccesslevel.setLevelName("XbH3WNFsQcI7B2pu3jf9arltd5yhS3fbVsGHzHpboSVpytQWAz");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("qB7CHTaUNyA6K2BtRcuE3JCUihtqzK3ZljRjJ4cMUMGH6i3hPv");
        useraccesslevel.setLevelHelp("rB7kCKfxfgq8baJtzB4qXQ8U9IKffV15JS3DOaUeOQm4rz2gSy");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("G2ZjckmVuNM0baGWew8olYnnYB9CTnhCdoeaUtF685X18AtgjL");
        useraccessdomain.setDomainName("stmcGntHyaAYo4TkEoKCMiHXSPdiout1A1KkAxssB46EzY7xFz");
        useraccessdomain.setDomainHelp("kjmfmmGFCoOtB08kjOtF8fStjvZTkrL8YdKRN8JRu4QyqMAkUe");
        useraccessdomain.setDomainIcon("IfrkWOcE2yGgFH4Hd0ix0WHazVaHXuCPAvCBjbC2ENxKeMfJD8");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        user.setChangePasswordNextLogin(1);
        user.setGenTempOneTimePassword(1);
        user.setUserAccessCode(20923);
        user.setAllowMultipleLogin(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordExpiryDate(new java.sql.Timestamp(1464961026220l));
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1464961026265l));
        user.setPasswordAlgo("rz7dzUuwsdDs3uYED6zLvk2CmM8JJsbmJW9BgskY6ZNzMJHcyO");
        user.setSessionTimeout(2579);
        user.setMultiFactorAuthEnabled(1);
        user.setIsDeleted(1);
        user.setIsLocked(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setLevelid(1);
        question.setQuestion("9nqfsuF7MGTd9YFVSNG68eS0De4Ri9flTml5hfkqeywisgf4QL");
        question.setQuestionDetails("T4PUr3Y851");
        question.setQuestionIcon("AfbdARA90bkFcNAeik9GDQgf2pTIYpTjreF74X8d2YKvHIKS8c");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        passrecovery.setAnswer("Y5zpqF5tHzKunmTGDrdJYcLwU9LYxHt29p6W4ETNWspL0ZJj6H");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setLast5Passwords("Zp1lP9sTXpJTQZobAW8bSXfcHScZrsgKK01iJIP3TAQAAFP99L");
        userdata.setOneTimePassword("UxZKhAAwNMz3Tex1C4yD3NlDlCaQi1zs");
        userdata.setOneTimePasswordExpiry(9);
        userdata.setPassword("UuCnpreyUv42mjmMNOB3ht56YeBN4paVtNEWRtXKoBwUhiWQnn");
        userdata.setLast5Passwords("9rI4v0qiwDm6FXeFX7PwnHze4JVhHoTru0dG9Mw2IKIu8x2fiz");
        userdata.setOneTimePassword("nUSScRzevoxhRbOWh8Dq0Z1TuLkTw5F2");
        userdata.setOneTimePasswordExpiry(2);
        userdata.setPassword("vI5kyBUaVJLQz4451kGnrwjyRk5icQ1UhWlyBc4jhjr48KRGtG");
        userdata.setUser(user);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1464961026492l));
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("z77LDhssL8EVTEDLigy6dYyWxB3i16KlDzugQzQiwjNlZ5zU5b");
        corecontacts.setMiddleName("Ofsh57HlMYlcDwUcphEbtFusZTmbNqFXZegXfH3sGnR6MNr705");
        corecontacts.setAge(119);
        corecontacts.setNativeFirstName("WtFFA2tu6PZiNfyhAMfxhDdv8IvUMBzhbDAHqg1IUH2Yc26q1s");
        Language language = new Language();
        language.setLanguageIcon("0He1ekPcwsEVLi7oNUYBACxqdKphHEpFOmKwQVj14uoiOMdOlW");
        language.setAlpha4("27po");
        language.setLanguageDescription("vGUFunlV1vCmcb3o0PEffLymDn7gNMiOAF70m8xE0wz7evchQq");
        language.setAlpha2("jH");
        language.setLanguage("XVKnJnUK8gfwwgVLDstoLMZuSI89KoHo1QeR7RcigR88wdTolY");
        language.setAlpha3("a6i");
        language.setLanguageType("iTrDc9QC11UHi5WoiBAvFtqRLGt4Uce7");
        language.setAlpha4parentid(3);
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("YTE57x0mcUXtAG6JGqVquHdJa1LLMG0jHtHxeRU1myNMry4mwG");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCities("savmAVfpSx6i8R1UhGE9U1RlsRjlQS2qYLgNw4PRSHRAwTV5RN");
        timezone.setUtcdifference(6);
        timezone.setGmtLabel("jVKyMgJcdjEmZ2cNDOgpcMp8IVChO0kzbQQx6DZmfURrDN1rb7");
        timezone.setCountry("EhEW5miul6mQgym8Q8ln4OUMhOqTYiNZBE7w9YmoHyZt1vJvP2");
        timezone.setTimeZoneLabel("GMVImUJEakgoDzPwMN2fF8PHHXTqZyrk1tqgA47NWzLxyWRhlN");
        Title title = new Title();
        title.setTitles("3PWw0zx1gUYu4iU6O4XQJ5MMMrHMFiux9vlwDYkpTuh4kwsDBU");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        corecontacts.setFirstName("jDJNDqJm0zTkBPyXGkcCugClAAGTfMagRjJNbhqfxp6lh6IqsD");
        corecontacts.setMiddleName("OvDfkWrVSJeH0yRl3sOxmisiJZpxNQQpgyE2TmJDxYeHiwGGNR");
        corecontacts.setAge(25);
        corecontacts.setNativeFirstName("rLD5HGydVaCVsXdaP5wDlwDDPgbYhE9CQ2yjdxZcnw19BYmqDs");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1464961026624l));
        corecontacts.setNativeLastName("74U03Udn3TTYP3JVE8cSyqJlH3gtP2JfKX19EUBQI0ycvwZBu0");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1464961026624l));
        corecontacts.setPhoneNumber("65DmlBJfcflEXjmQaKLJ");
        corecontacts.setEmailId("yHJa7hP30E57QeHJVKGFZNY78v7icqke59pqsANIru7jr6GS6k");
        corecontacts.setLastName("X6nud7qKpwvBALF0wOB6cmjOjBFJwoWF0Py5RkvKbllTjqxG3g");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeMiddleName("8LRDZAw87ZhBql5N88D6aG6HfeaVVb2b3nxKP1qszWLlwaKjtf");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("276HqomQyTnccWA5K7c1tcE05IR14GPm5NgDlmxWohD5VixFGU");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLongitude("2VKtC8snbhlQDDMtq8xKbsy4MjPQNn7tFBvIijzCnxOnLumBpa");
        address.setAddress3("2gH6y9DHnOPdxiyswnp2JkhlqGDpNf0Jf65VP5wIlGwzU2SqGA");
        State state = new State();
        state.setStateCode(2);
        state.setStateDescription("Q46Snf7Q5bcCWjZqRzTtu5n5fCFim0rJap07xjniYqts8j9iEq");
        state.setStateCodeChar3("XJmIkZFjL39YbivnBNozHEJdxNFdvNUC");
        state.setStateName("RH7lhAfbwRAdJhVWWD0xyziBfqwyvhvjzJ8CsiureZCLKi4q24");
        state.setStateFlag("TP7nwAFLm1lHw4ftci2IMhdhW4wqp6OykFEtRElvOqhBBfyUKV");
        state.setStateCapitalLongitude(8);
        Country country = new Country();
        country.setCapital("4VX2wHGLqZTKiD66tZ0EZY9kERX5GkMW");
        country.setCurrencySymbol("LMPJvgXr3NSC3xCgD5buCTPigvnf0ttU");
        country.setCapitalLongitude(6);
        country.setCurrencyName("cLJeTnFqOhsdixqdZxjYRQEwGOOypBBbQ7TM8U8QYsBfPBIpNl");
        country.setCapitalLatitude(5);
        country.setCountryFlag("L7i12sukVFHGlbeP2BzsrxWkZfD6nmkSGDawcgZfGwbIvS878S");
        country.setCountryCode2("0dx");
        country.setCountryCode1("vtf");
        country.setCountryName("BnYj7g9fSmEF9gpSt16B7Stsrjext0WUhAeikOoMAC6O7injf8");
        country.setCurrencyCode("hNX");
        country.setIsoNumeric(477);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCode(2);
        state.setStateDescription("qdCWI4tSdj0ro759UHhLELAdpPbgUMvYiq6oVmsW8AN3uX53Mo");
        state.setStateCodeChar3("mbKLNJFMxezQQkfsz5mLfgKQQ8m3BumJ");
        state.setStateName("qAVkUTTXSwOOthmObYJoJtiEdHDZSYhH0QwYwVjZRAbUfc7RPM");
        state.setStateFlag("9rekBUVoASeo8WeGBx0EdzyQEPvopGYxKpilDVTbuWMbgZ6ym1");
        state.setStateCapitalLongitude(2);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(8);
        state.setStateCodeChar2("JSnSxYn3uSgzG1X9iWv1BsVW4GfvVPd2");
        state.setStateCapital("lYWW4NWMLV9CIETGp37nS8d6KpfclmFGd2TTzek7760lqukldz");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityCodeChar2("FxuqGvuJLXbLL93EheynhSySKvI3OOQQ");
        city.setCityLatitude(2);
        city.setCityDescription("yUkfkqIUKo86QYKVT4YLnvdXn9ZTOWloiq1R0F6bQl4v8H3Cjm");
        city.setCityCodeChar2("wAdmh467jcXK0idO2AFysX8XovPISiSh");
        city.setCityLatitude(7);
        city.setCityDescription("bmKDkDVOuQTZimqBPyfMhpdtOySGW0N5msGjFRC2yeKhUja1ny");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("SJJwvc7xUH2WAciwxrYENWVEzZQCbpJ6qmLmEHvH7xK7ZzEtWP");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(11);
        city.setCityCode(1);
        city.setCityFlag("wcerkyasGwHUgW6v8I9av9VlETHCoyO2XoxxjeYaAu8m4Cn66H");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("6FeDMiSmHy36C5Ewoa9VFkRPqQImXdejq3rPLpyp64SakC9LkZ");
        addresstype.setAddressTypeIcon("llONwOQ44IXKNYmgAEYNucsytzDhRLR4s1k3Qq3yIEI3172SEY");
        addresstype.setAddressType("b9iJt89fFEeoKrczYTJ9q9s0PMgYgB6cztpk2LFybQcekYA1i4");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setLongitude("ea8ljLYiIiBggCw8wY2fBwXTkEVIhLzPtBpMvINP9DwSlZDGd9");
        address.setAddress3("QWaRw38dVZQQfOZZBFJnFpK23XSV42kvZvHfqXhCRdyH5lP9YX");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("X2H0HbYuZFrgTJOYdzAsIZCIqqZ45FGW0ETq2ZgCdc1iFzTdHI");
        address.setAddressLabel("sl1E8v9xKRC");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("8uI0z8");
        address.setLatitude("GKFVqnRDtTBeHalOys3IwvH69lFZB9iAknA0oGbzhIF2UfOYUn");
        address.setAddress1("Si4eaIeMqp3tQ1GXKYZZ97mpWmIj0jek5Ijd2qTVNUB6Uu6tCV");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("F5Epf1XabiRW7IyoyrrPl94e32skJLu5zOfU8GJsrmc5ha7sVW");
        communicationgroup.setCommGroupDescription("6pdjdMIa1JYOwyTlTJ4PKDDEeGNnsWVxJHjgN5MMJZdajbJaLw");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("KQvqHyZKQkAapwoqwpYDL3As7sLvlWaKq6UHhzFka8DgCSTWPy");
        communicationtype.setCommTypeDescription("WEljkUVukuFTufFJVPmbSSM01YQxidTNyNWizrVj8NjsihkAqc");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
        communicationdata.setCommData("GsWKPzCgbI");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        Login login = new Login();
        login.setLoginId("gKdrDIlRtPhBUnH8ZeMoscZ5JwJGZAL1ZvNw5EjvOfVeGHtL8D");
        user.setUserId(null);
        login.setUser(user);
        login.setServerAuthImage("ukhyjvUXo9YVd3PwiZerCRB12s1I48nN");
        login.setServerAuthText("k0HAjPNCBhiMivml");
        login.setIsAuthenticated(true);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setFailedLoginAttempts(2);
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
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setLoginId("4UDdToUwO0mcvw9TDpsAu8dO3tzYk6oyDmn9x1f7D1z4zlIABm");
            login.setServerAuthImage("FufoUZ2IJ793zzC5RA17qRRhH27pb5H2");
            login.setServerAuthText("3nzqF5FnSDMFu9Mx");
            login.setVersionId(1);
            login.setFailedLoginAttempts(6);
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
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "6Qj5iorhkF74z2FyyQesA71DqW1GSuZJvGT7b5PVls8PD7VPNwMHVL8p0vodResKNQBfXICmBG7U1il3I62kJ0GfVKsnndTc0UgmDEs40wDfdV1XV9tvioTtygGq2HPA3LQGu3zTdho1FwQ5HYDUWT9WqYiKOzKxfDFdUzBH12edqtavbavECaCVnFLdwU2vm6faYDsmS"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "fhZxgwFcf8acthybCbOZo6Ztp4aNpV2dD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "lZh0NjzQc2onP2fm8"));
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
