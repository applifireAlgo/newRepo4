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
        corecontacts.setMiddleName("OjTpoPS02lDfZKinORfAzfvIzg52NfOzUBMFsXtnUxa0zPvIE0");
        Gender gender = new Gender();
        gender.setGender("J1GDdPEflOoy5618b6HzFTYAm6vKZed0fM5hx48TOpkJoOv9X4");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("GQUANl0TgOD7lKSzE0Dwx64xc4FPw7QbJuOqcCOGmFYg9XWY4T");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setLanguageType("VJSzfFdjr0Ka1D2wmoz35W1nwaTK6da7");
        language.setAlpha4parentid(11);
        language.setAlpha2("VW");
        language.setLanguageIcon("Sc6hc6KQ1oP4cpMCxI22Y3YEy6Q454hkbwOGoSMO62GwRdGePb");
        language.setAlpha3("d39");
        language.setLanguage("kPP7O1g9eVpSBWc0QXISdyhFzE0Zwo4wg8yk8MSuMFynnOg5b1");
        language.setAlpha4("F0uK");
        language.setLanguageDescription("cAAP14BMeONMF5uLBengUeTL3hDZYG7nxMOXz18Lh1knme7hEq");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCities("ZHGoxc6GRuihvXezf4P7tPaFQyDJjE0JfdW1B0mM74FwuoB61E");
        timezone.setTimeZoneLabel("psPCpzRWmBHymidlfLzbDIcfkhll7dcdMF2xQtSBxOuXdbq5q8");
        timezone.setCountry("AzQJJfsagmW1AniWJEs2snaAUZ0y7lJ7rOX1M2davd1LEsvA8m");
        timezone.setUtcdifference(6);
        timezone.setGmtLabel("IrcY7KT8NCBJC44nlPo6NiCRx9KZUfQhGzQsk3OZSW8gqlm9z6");
        corecontacts.setMiddleName("tzLUFSMc0TzqwWmvaU8nl5ntTbsfvbj4c5u9RMnfCOdrlF5seB");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("79SCnsvv6NXCDRDnf9mRHulpks7SfbQKicMYjke7QHFHjXcrOk");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1465475256475l));
        corecontacts.setPhoneNumber("uIVgEHcPmCC6FbWCSLIk");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeMiddleName("4H9q87IoIpdhcBCTwS4IO8mICXA54WFHokQsn4gWSHPRLpyyvh");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("ts3d0qArET9fo5J8DyvIcxqK6dlSe5eIQVEIyRmz9TkC2zQW56");
        corecontacts.setNativeLastName("v5kmAcHyNtcbsHtd51SoN1wpLhYkwrplWILhI37aDAPCbqjhY7");
        corecontacts.setLastName("ZynveOVrIYWAaocqZviDpGD0LHOLs02v57nDXULUZK6mQsf0iv");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setFirstName("GZZLJs2Q2eRzWIDcSI7Rsqb0Tq0EA4BSl0JpfgIppNRb0G8s9E");
        corecontacts.setAge(95);
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1465475256956l));
        corecontacts.setNativeTitle("cmdoCjEVkHqZjsJ9rakraujOslFgJo9OM6q3fgav0PXVMFqcjQ");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setZipcode("nyNs6f");
        address.setAddressLabel("ihlCwhOSkpk");
        address.setLongitude("Ct5cgsZzlnHJXFTCBxOP2kviLwOf6VnXMiviHfkgKf3hK1K7XE");
        City city = new City();
        city.setCityCode(3);
        city.setCityCodeChar2("W90WF3SObyzbGci88tBcE8atj81ALsWY");
        city.setCityName("TcXYbBpIi1ucTrhjyQaivrh2XAdet4sIMthhpmFLtRLpRvlx8I");
        State state = new State();
        Country country = new Country();
        country.setCapital("zcVXBFUFYBzVE985R5AbjinyfSZkVxYT");
        country.setCountryName("mlZuQIhUA0HDDVG9dCt2OB0zYO1mXprGmf8fDGM6T534Us7ghz");
        country.setCountryCode2("87K");
        country.setCapitalLongitude(8);
        country.setCountryCode1("LMl");
        country.setCurrencySymbol("qp2zelrZjSuhgDHwy8UWT8zBGoK8jipT");
        country.setCapitalLatitude(10);
        country.setCountryFlag("EosdMBwZYZdvS3EDnshic3hSm8ZGLX9GlEur9ZDTpVyrYnH5Jp");
        country.setIsoNumeric(516);
        country.setCurrencyName("18w3dsNN5PQODFz79eMSymtASwyg9hyPgsAPwgJJDvZvmfIsIb");
        country.setCurrencyCode("UW0");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(4);
        state.setStateFlag("pDHswazkABYddYSH7K3koTnCclCUu3dQGTJYo1UJnJZupaQWAw");
        state.setStateCapital("onaSMoFHUKql0GiDg1wtGQX6r4NG7UM4n3osgiNIMnHNzRG0Dr");
        state.setStateCodeChar3("nXgWYofBy5HS54Ha2GaFJpKeSvnoLt9i");
        state.setStateName("gnQV18Zqvw2Q01gqibarMrl6ACs76rALNlqo1XJsJVTYy2hQE9");
        state.setStateCodeChar2("0PkG9XtKsUfM38Oi9ShRC0aWe80Nfv2G");
        state.setStateCode(2);
        state.setStateDescription("L5m6IOQv5lViVjWFybY1g8zhymvHgi9yBrVAwraeHshqEZhGE5");
        state.setStateCapitalLongitude(1);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityCode(3);
        city.setCityCodeChar2("8pBZW69se6NeA2PMwdQFSl6JOyYmZki7");
        city.setCityName("LWohbLeWeWgovOX0tc2jb6Wl5KSx2daCpLE23qQWp9PxdaZl4N");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("uincCPdEnRITHaiD2JV3HQNkUbj7GHccWAhGN1P8BlqxWt8jqf");
        city.setCityLatitude(4);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(11);
        city.setCityDescription("FijrAobfpoddhoR9q625flKB2OqRsrrp6VtP8I207VI66fy0gD");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("MeVwmHwPLXFj1gx9VUpxDCY7tSt4ggl4SG5Brzp9PBPoZWA18E");
        addresstype.setAddressType("zkokJLX51fZA5HwEhfMBA7prdwlzeAM66D1mE74EULbMuyNdiI");
        addresstype.setAddressTypeIcon("ALYWiahx6TD9KnYBvTAqjUQnapTkacqMZpda40LlD0tuC4FrSL");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setZipcode("RFKJWe");
        address.setAddressLabel("igQ2LWvQpfL");
        address.setLongitude("hyoVSFQo5WBm5lhf6ZRGQCq7cb0g1ah33N7jj60MSzpYSKrgcZ");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("74oSr0iBzU2Jw0OsIf9nOgLuB7XLwaZyX2rHbLWCBxM3XoHeqh");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("NocRIPHkO6tDLWYlBvvyl8E5Jd0NTtC2yxfj1zp38WmsKoEsrG");
        address.setAddress1("7PGwN3tBL0WO445FK9GEn9zyUSeRdVuBSJU1sIgkE0m4txUqnd");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("h1vVV3cxJ4Dgj7b28ls2B9vM3lALJqgBcWUiOB4EGEX532uiUK");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("ufCoMXolMpCrfc3hTLnVlmbcjTiaUCBgZM4fkboNM8oncgqFAB");
        communicationgroup.setCommGroupDescription("BQZpFfCdplaSuVaKGC0qBRv9YkbtnHodbH0e30amU5vy2M0SJM");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("8UnOscqwQVcwIngEg10nqLR8v0IqfXEHLXFjviQW8a2MJSzBxf");
        communicationtype.setCommTypeDescription("emjrmt6CZ1qeVZlGCufp0zhSt5MUWYY2Qih4BdcGoc8wTZUlKH");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("imkrOdmoNt");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        User user = new User();
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("SPrZx7oc1DTFgGKqGNs8AkN5GToCeDAK4yxkY2GDgW3fHZCTmg");
        useraccessdomain.setDomainName("avh5dLY5Ol8IXDx8HvUFBVuIj2eGCmev5XNBiMvotL8vhtdAzG");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("xHYzttmmpkMHq5a2blN0ZEXVtOU8O6kNi9vpEoZmhEsYEXEtsc");
        useraccessdomain.setDomainIcon("OU3QxcBcwOSGhv8Nh5VddzHf0m37w9wyzVy3Wce1BGCc5zcrxk");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelIcon("T9SMJNP6kKt2enl65xqDJvVV4lVfFz6AuJLyNebYgkvrMYlhD7");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("q684GcqrjQeTyu1QiRfzUpMFecKcQu0GvzOgvFwLYSywoFXd3S");
        useraccesslevel.setLevelHelp("Zi729lMB7Zj5kvLnXB0WYz7qd0pZ705Y2BRpYW0Ha5es2DaOSs");
        useraccesslevel.setLevelDescription("cazRechxKOGnjmmdVtK2lV95D3NeM13H0y2ryfEkgPF65ByU2L");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordAlgo("ma8NpMmLvjGPg0c95ZV3qAh0sCpJfuIoqPnSVAPLUhNAnW78It");
        user.setIsDeleted(1);
        user.setUserAccessCode(23252);
        user.setChangePasswordNextLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1465475259094l));
        user.setPasswordExpiryDate(new java.sql.Timestamp(1465475259094l));
        user.setGenTempOneTimePassword(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setAllowMultipleLogin(1);
        user.setSessionTimeout(787);
        user.setIsLocked(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        passrecovery.setAnswer("prDMRUvEqY1TuQyw60Sj9cbnEd2tZQ97mj791wKnegHpV8M5i1");
        Question question = new Question();
        question.setQuestionDetails("v1UOiNe3na");
        question.setQuestion("awVA4jVzVtwB66LQ07NSGYsZAdvIVZTWaD0aJuDdx4KoCA8vgf");
        question.setLevelid(9);
        question.setQuestionIcon("8m3DZIiC4NKdapJkoV3irbbf3wNcxcJn1ubDgSTlgtN0w6IWuH");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setAnswer("sd2HJwcqND6JR6wEqzDFYUgD6iMOSxqRBmrZ09eeEZmnB8kZET");
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordExpiry(10);
        userdata.setOneTimePassword("jgyS1crhZ42FXjruzRO1pX4NKbisFvf0");
        userdata.setLast5Passwords("Brwh01HuMevpU4HWSozF6sapWVpsc3Ph2MhSDKSwMrVjKGYtaN");
        userdata.setPassword("C76SJz8yB7PUFKdAa3E6WN0DmJlsFAS8JqulCaqJnnXssO31tv");
        userdata.setOneTimePasswordExpiry(1);
        userdata.setOneTimePassword("VvupcWkDMWSfJsfo56a3FADUkqXkedHY");
        userdata.setLast5Passwords("sY63u1PLLxE9b3jmOOEn6YBw6sdKlw3JZ9z8JlRwQxQZpcJehz");
        userdata.setPassword("hs8NbNmbADxkYpB9LqMwFjKsZv0RP8VRDmgGe3klJBKKzsswUD");
        userdata.setUser(user);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1465475260316l));
        user.setUserData(userdata);
        Login login = new Login();
        login.setServerAuthText("idjoEAz6Wt1CV91h");
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setIsAuthenticated(true);
        login.setFailedLoginAttempts(4);
        login.setServerAuthImage("OyvcBQ18J6z5KbljO0aF9hdVLk1M0i4G");
        login.setLoginId("5CLOaJKMyowtz4CypmdQQtXHfZMWIl46Rq0AohMP2OJ3sxgvb1");
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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setVersionId(1);
            login.setServerAuthText("kxea6SSRJBqVdZx8");
            login.setFailedLoginAttempts(11);
            login.setServerAuthImage("wWKSYqn3UPQyfFvEiik19AZCznOpV0aF");
            login.setLoginId("u2lz0Np4QEWXwOSay0oL1eDl6wVFlKZdBFT23YQVGwJYxz5l8O");
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
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "zi5vjGSZnDCeYQJIAdP8T9msT3nulGRXBOqV0uaFqDBjUfu7JJYE8qiUsoyPJm8Tjf4TNN1T4qSfpVQkYtR6402vdBoXZr6VGNkFnyI0dDFnTKoJfHQlwPzSU4Lu0P6PQ8jPHeE1Yaud0vdsW54ohmrIMbqTlbUnbUCLffNPzdrfLD2IVR5v8JmPUd5xpoDmjTnnj6JdO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "lsEiOP8uWHYRnB1xWGwXmQEwNk9TJD020"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "1SSQltrNKNfzDHMgQ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 21));
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
