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
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organization.contactmanagement.CoreContacts;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
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

    private Login createLogin(Boolean isSave) throws Exception {
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setEmailId("N8Y8xYOJccBnD3aveG2PBpnGo7wHTCybyLpM6bE7GVHMk3N1wQ");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1462446066145l));
        corecontacts.setNativeMiddleName("TA7yt5VKEJnvfcy60N58MKwsUlYXakflO41B8zgXP18615PGMh");
        corecontacts.setFirstName("04uvw9rhWFoDNrpyYsq3KxnA1dddMVeI84oKiOtxlg26ppI6ic");
        corecontacts.setLastName("h2u3Hm4HrZBEiRMdW6KfBulWslteYkJvPgwnaodSbmM1cP6bsO");
        corecontacts.setNativeFirstName("ZMR8FHaBZ44Wn8BPW5E4mGxoaoa92NObOtS5we59yb2AjiZ59l");
        Language language = new Language();
        language.setAlpha3("8rv");
        language.setAlpha4parentid(5);
        language.setAlpha4("J3vA");
        language.setLanguage("sPhRh4lhPNaSQ8oCzyZR90yWZ5vcpkjIvTXcNyl0aQHzAQTXn1");
        language.setAlpha2("GU");
        language.setLanguageIcon("XD1Y2DIDsKu4xpgfzougn8fUR2jabgsNI5V3rFIMnEmRsa9L6S");
        language.setLanguageType("7Cuxx4h5QTBUCnIxioBEIDc3x1eIzKoV");
        language.setLanguageDescription("VTkUkFeYaSiOsKpZ5VEEtYgd746Incf7S0P9u9ftASrqngVsIi");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCountry("7EPIy64R7JisEQQXretCLZFbTqSHBVMpwpSVzGvuOCHtx1BV34");
        timezone.setCities("LZ3wYLLpFgQqFuKcwKjqGJgtB4OrHfh6wLvKqDPNcaEzwcRo1K");
        timezone.setUtcdifference(5);
        timezone.setTimeZoneLabel("LHRBC5cMJPW50AmRGHgtykdeadxkKX3FayxXTJkUaXCKsQ3Z3u");
        timezone.setGmtLabel("rCKzqppzyKr73TJqnFW7HNzFOgbaOPnwSwlYVbpZwcTl97GJyc");
        Title title = new Title();
        title.setTitles("cbIqZFiF973sKZTgjSAwSxPCKYnFohPe1wt0Z9XSyTT7YDJTQv");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("A4DO5K8as2DwRtS6dZpAkfc4v29cUASnqXbrl57TVMnqyryN7V");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        corecontacts.setEmailId("NQEGDaDFVqbdRY325o8oYXs3cIigj4tpGNSMqyLkKM7i5Si1Dc");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1462446066170l));
        corecontacts.setNativeMiddleName("wADbroxVZrJXw6vmdTiEu5dhaKooZCzhpppSAupL8cZq2DxvBH");
        corecontacts.setFirstName("BPdKw7M4hBQLtBIx0c7zAnWoVJjAvvdfhMwPqXDUkQwX2kBWRW");
        corecontacts.setLastName("GhyYqNj5LwmNOf0vb4TWbXU5CcKU15AW8I2uCZWRerpHuUxYPb");
        corecontacts.setNativeFirstName("HN0lldvdjvtpCQdQOCRV2xVukCQN4AmaWqgxlyJKtkZtif7HP9");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("emiRX6CnBXI38sDpeJQRcUFr4DgPbXXpERNG9IyhS1jtLGrX2Z");
        corecontacts.setNativeTitle("OF9XkEdi0t3KMQRHwcJR9mtvSX2e073KBJVS2A7KcVqpLWUFGH");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1462446066216l));
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setPhoneNumber("FvNMRUbDsjdtgHBVSlKv");
        corecontacts.setAge(112);
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setMiddleName("DsuKuHcprliI5pdyloXnHgcQONLaMX4aQVayfJPV72Igxmglv8");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("RQUwyATuN1U1LevGwqHq9nbXGD1JGCEBEH0nk2BBg1na6xmhSz");
        Country country = new Country();
        country.setCurrencyCode("7Iw");
        country.setCountryName("WPQ5cZXHj2ydM0mLH4A7ezakk7C3rcV0hEE1cJcgRzthSS81yd");
        country.setCapitalLongitude(2);
        country.setCountryCode1("5AO");
        country.setCountryCode2("Tkq");
        country.setCountryFlag("gRNSYX9btG4G88tap2Sziav1kLdg5nSF8XIVGJa3HdHRCD2OwF");
        country.setCapital("MT9YZeQgYdUtjlbhZoEMo2Vt28PnPdWK");
        country.setCapitalLatitude(10);
        country.setCurrencyName("q6gr0Z5uBgnaLBZ2xPuu78Hcu4abjxcZpZM1WnIEY23O7pwv2c");
        country.setIsoNumeric(168);
        country.setCurrencySymbol("68vqsuJHBnkS17PO5IGjdSlyZhJwleA4");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityName("aYzqPiiyVp71d5F7TSZjsIROR20mhLTrYuLMROpGYWE933MREb");
        State state = new State();
        state.setStateCode(2);
        state.setStateFlag("IljSMexyc4YfaaXXpZm7TjUL6kxX3I805qL3059z8yjwIaKwWZ");
        state.setStateName("zDSfcVs9T7kWjaDXaQCJ7FgJfRmLBqMBCykXZQXwb6dkUJHREB");
        state.setStateCapital("w2rSYg3ZaNuufND1l3A3LOYAUacwUrfvEyo2OFpzD6bWeEA8RU");
        state.setStateCapitalLongitude(11);
        state.setStateCodeChar3("6cRgXs46AYK8dZk41xXpdTjkneCYCPok");
        state.setStateDescription("hyaRf1lUtnoLWmn4rizVvtyPqgp87K3rUBCkXqR8af0V3GFZ3k");
        state.setStateCapitalLatitude(7);
        state.setStateCodeChar2("yWXfk0vEmRWkAV11r2nSMqMFDhS5KHtt");
        state.setStateCode(2);
        state.setStateFlag("3w2br8B4Wyu20NQcoOYaHUTqRqDLvswVrHa5GBfL86Tw1FNsTu");
        state.setStateName("gqbessMiAew5nWXwPHcGEWEcPTPapRONlmtrCQo8FVD4JuM23O");
        state.setStateCapital("NAUQwbH9lj04L1NOJfuTiiZEHU7XYWsKFNSz1E1SJqCU6VYGPJ");
        state.setStateCapitalLongitude(11);
        state.setStateCodeChar3("ddJdCgweM6xtfpo4F9IeRBfQ2A7DvWZd");
        state.setStateDescription("VvC78ZU4sX0EOcs5mGIuts1MD05QwqUutfNf1puiQfikpP4tA5");
        state.setStateCapitalLatitude(6);
        state.setStateCodeChar2("69HwvkpE71VptKCd7KDDY6XxanqiikRl");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("RDTz0YNWtqVkqCiwLFauiDkH621ODIrqLJAujMH32rV2Yt3M9b");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("JqE6Yp3xxiChyTlSIFc3jUCbdnBDttFb");
        city.setCityDescription("3j8md5NyjnxkOLGCTpgDPGzQcg8qwDumwPKOsHlUyjIqxdGG8X");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("EU3FeMTJxHF5xRvDATNBwMQtxF1LITclxSq1vSMf4jhqY9bvFj");
        city.setCityCode(1);
        city.setCityLatitude(9);
        city.setCityLongitude(7);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("EuFPLMgWBANMuyZo7HDqxQJblNmNF2KkHwzExB9ti55lVBTR0i");
        addresstype.setAddressTypeIcon("pV1f5DDk1qpuixMfhfJY0YIREzoYns2SYzvnXd8tugYvPPgZwV");
        addresstype.setAddressTypeDesc("afUQd7n1bikh4REAUSz7VCOwqvoGoSGXNIo2yeinsgDkcd7Rca");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setAddress3("Q4dhJCCpUo86WZbOLK7eaM53l7Z49aAeIUdngd47ZU9jj4xExO");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("GzJT2iQVrdq7FedF8BOAd2AUxUJ8U0hkRubHnb4ntcZagQaV6t");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("fsu8IE3RBKB");
        address.setAddress2("cIasxuVCmfpIE7KybQvLR9Z1Iv1JHUhrVkaFg5gdPr6WbmOTgf");
        address.setLongitude("o68z0EjaMkAoLR69f9Vv4O4puLjOB7KJSyjtBigAzaAJOb7bZH");
        address.setLatitude("x4DTLiY7ftznpx2dRHMNPmhTU1g36JfTYlKH9sOLCl5GMuPtpe");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("AzMgr8");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("DYlxrqHzAj");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("wnnSKS2C12gWSdlMAahEm40dUCDfMhJzlIp08hMwpZBFoZD1zX");
        communicationgroup.setCommGroupName("OWI7q6ytwZAcyDYd3iO2m2ehdphmxIMtCCO5KOFBHN1BF0zm8A");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("h4h5q8srDpQXMVVOaWUt2RrLaLhECTGhMbwguibi3ocKUexU74");
        communicationtype.setCommTypeDescription("U3CvUswfqoFa7YkuuOdpYbMQyQQjufwmpW9oQ5z8P0Fdioj4gZ");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("VpTtpo1UTy");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        User user = new User();
        user.setChangePasswordNextLogin(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("3SRg3MzDcoip3tJtZlPNirsCntTcTfRyc2SQs9cVYjxh5NDMGj");
        useraccessdomain.setDomainHelp("hvVccg9FXJjn4ZQjt77Tkv1IZbDrGbjEGC2pj4RBAcWXwiiZ2T");
        useraccessdomain.setDomainName("11ykcsqrJKUUk4eyRPGOthyvlZqa5wJejgrGRvCMT9ERQLP4AR");
        useraccessdomain.setDomainDescription("73wLth0F7KJCe74CLc6V0We6uJksp3rEWVTBWhzz8yhIF2oST0");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("Ps9ztZdKozIA8BPFUVOKW3smirS199FNrc1HupSpfbvRMvw0va");
        useraccesslevel.setLevelHelp("ivC9XDM6eNWy1ofZhjFnCjkT3mOfGudRgS73t9rcHkMF7PUq49");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("wygv6yleCGlH7NMr0PfcHXNyw43gr09bA5QJFB1FHqHiZtzzel");
        useraccesslevel.setLevelDescription("yjPSTfYSrG47C7oCuPg4ohjbpLfAs3MLU3pZk8wF44hPacRVvL");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setChangePasswordNextLogin(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1462446066796l));
        user.setAllowMultipleLogin(1);
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1462446066796l));
        user.setPasswordAlgo("u98MlKfqBBLo3N0QqsJTVvhX9gRPj1hkJjXG0oEsoWM2rM67tc");
        user.setSessionTimeout(911);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setIsDeleted(1);
        user.setIsLocked(1);
        user.setUserAccessCode(46951);
        user.setGenTempOneTimePassword(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionIcon("cHayZueG5RnbIZzp7Vr4X6fPg6oUOJAlhse1G9RLHDdCX0HLvU");
        question.setLevelid(9);
        question.setQuestionDetails("9encqPJFax");
        question.setQuestion("ubp4TJ6ZpsZDXD8RR0Ld99EoZ7vxNjySmVOfgYTL1TvbZ5Apf8");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setAnswer("4f1Dyhh7z5LILkpgIS2SwhvMfmY8B6Hh24LIvOcYzIzOkfsh5N");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setUser(user);
        userdata.setOneTimePassword("7AHcuhLc3Rr1cipzVhAniiBekPvCe27C");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1462446067105l));
        userdata.setPassword("hyTTlJ6SEGE3RaiRtfWdO03DTofmA0zN4wwoNmNbKwxObzdAhB");
        userdata.setLast5Passwords("8vTSpMEEvwvjU7u3UuO0UrbWvR4GImL8cLEiQ5ElJRmi6OANsm");
        userdata.setOneTimePasswordExpiry(9);
        user.setUserData(userdata);
        Login login = new Login();
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setIsAuthenticated(true);
        login.setFailedLoginAttempts(5);
        user.setUserId(null);
        login.setUser(user);
        login.setServerAuthText("VLjecZzNWHEBc0Y2");
        login.setLoginId("H8pIpHHXVQDXFZvWuNRy3ORi6yQjgiETUPsLphUevsoOhAezAd");
        login.setServerAuthImage("cxZC5p9WyTQG0etxhHZJLNwazBhWXQHb");
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
            login.setFailedLoginAttempts(3);
            login.setServerAuthText("GaOCKviFWqcS2M0y");
            login.setVersionId(1);
            login.setLoginId("VKnUIvD5a4Fg2q2TYc4Cvc2mfoxKHokSuKknMfKh39JNDbsxdv");
            login.setServerAuthImage("lNQ59HwXPqDFslWCAubGqaQUMMMhyxDy");
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
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "jUhn9y15LvPB7sPKzqsq2E7B2qFGWcseGCtqdPO0iFI9cedBRuwuJNAvO0prWsxIAuRn3D6nE3WYGXWjy9f68AHFopygfMQ0HcjDmkV2fiQqJ8E5fKBhwpMBq9Pzyt8OpXWrQtH9vZIWocxuESvEcUdBmdh5yeHGcQLzu8xxM6e8GbR50s0RRXAmmEkjAWxv5gQyYNw6u"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "qSLOAAI5yQeGIcv4Xo0sx5RQWXp1NUwRH"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "sUi5kdJJIXh4jqWUU"));
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
