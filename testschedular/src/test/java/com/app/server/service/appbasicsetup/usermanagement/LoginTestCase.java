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
        user.setAllowMultipleLogin(1);
        user.setPasswordAlgo("NWWLtITCsYt4mnjCJqWgsnHS9ZQu75111aeYgP0pbC7ExdhH99");
        user.setIsLocked(1);
        user.setMultiFactorAuthEnabled(1);
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("JEg1QsW4X9NGyFmkFZZkQFKXZzHUAVKuLN4xLFK0qRO84oIIZK");
        useraccesslevel.setLevelIcon("TBnnwIIHB41iq69BHIl1VjdUqzvurPEvrWQnoXO6cvzO0Q18CZ");
        useraccesslevel.setLevelName("RpbwCjfePrilTgQtO6qvZ6huiHaIQ59OTTex66wbwNXkjQHO3M");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelDescription("w0bJrZgoa9YVlM5hcRE0iQgjM4LloqijOtxY0vk3hbm3VdxlfC");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("3oI626aNh7AGiaOCrw9Liuhb5n1qRGS1m2Wfme7TK7AP8P3Kom");
        useraccessdomain.setDomainHelp("nEy0sXVVu0bfRulgtpC5k7L0m3r3YxroUnOU1ZBdhMf4XCjfWH");
        useraccessdomain.setDomainIcon("p6TxwPlr5CZTpSZfAXibuTqXdb2hC8rdY2OwDsGNZmy3Ntnbr0");
        useraccessdomain.setDomainName("Fct5GYG5YTwvHorY4YvHFi1ExrbgIiZTVm3Ag24ez2N9ZhjDlq");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        user.setAllowMultipleLogin(1);
        user.setPasswordAlgo("xr0hO8MSNLiqZir37E5sYdajsSbJRMLSnlLTzsP3pUF1orMxDE");
        user.setIsLocked(1);
        user.setMultiFactorAuthEnabled(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordExpiryDate(new java.sql.Timestamp(1463642657870l));
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setGenTempOneTimePassword(1);
        user.setUserAccessCode(34289);
        user.setSessionTimeout(583);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1463642657904l));
        user.setIsDeleted(1);
        user.setChangePasswordNextLogin(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionDetails("mR16H92ooN");
        question.setQuestion("LLEegcxgYNl4NQLY6tksF8Nrb0qtwYhuPAqH4HborxqL5lL6yU");
        question.setLevelid(6);
        question.setQuestionIcon("a34W3m6Tu0z5heKc7wVfQBQpTFQLXfxYkawG229yozTTrKBH1o");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        passrecovery.setUser(user);
        passrecovery.setAnswer("2eyjEfSS8c8RCy0N8YfjyE7Ct9dkp2LBzIXlyZjOzcLklVlw3Y");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePassword("0Ixg9AXJWJ0JntQ1pZsag3916kEy6j5g");
        userdata.setPassword("8CT7szMKP8v3lVCrTRgGBt4tsvjc9WU0PhPYVvCSfHTwNU5cbz");
        userdata.setOneTimePasswordExpiry(3);
        userdata.setOneTimePassword("tIQkh7ZDDtc6QM3pycID1JLO3Pd6c8xv");
        userdata.setPassword("2NMMODXNBtut7qfD48BKpFfa4Ow5zTXLYy7SS6Y9cjVdIiDc2z");
        userdata.setOneTimePasswordExpiry(3);
        userdata.setUser(user);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1463642658162l));
        userdata.setLast5Passwords("YAUVyaiS4TeEZIIEjAhIm0OMjVVMn6rNtZxTh2jM3x9cqpsu74");
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        Timezone timezone = new Timezone();
        timezone.setUtcdifference(4);
        timezone.setCities("BmuvoDuo0YDczNO8hUtTI7ZEOpcRaPWT1QOUnYkCE9zhJnjFe3");
        timezone.setCountry("394SoEKAyo7mYYpJXr1KHlvh0VyKV664xOCcB3rPFG34MTjIoZ");
        timezone.setGmtLabel("bx0P4dMWDACKz78CNsUqYvQHoK8SpR6nCpfzDY63AcQQXIW2H7");
        timezone.setTimeZoneLabel("fgD2YeczgpI86HFzq4mkHNWRqw3FH1YGKrIDdqsGXBoZgaaLb6");
        Gender gender = new Gender();
        gender.setGender("GZkGvKSdT4zeSkDMdH9DkO0797mg0EsF8lNSASHenhYHlHzpy6");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("OaI2sxFd82dHC1GAiRIN8TAeHMz1A4GfnvCnGSj6Z7RTavdYqc");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setAlpha3("wym");
        language.setAlpha4("4tX7");
        language.setAlpha4parentid(1);
        language.setLanguageIcon("kSqKOmhqDoJ7PAryvLIKQFDVFbNhOsW9qpNtDxHJ3vIzFks96r");
        language.setAlpha2("Y6");
        language.setLanguage("pztvCfJodvrD9j40W4cLpSsUqT5M78pkCfm4Pd0yH7TB8Eq9t8");
        language.setLanguageType("NtWa7fgnKvP1PFANP7wzcNMDV2mNv0EP");
        language.setLanguageDescription("k8bDJG7U3SkWCiJxkIORYhqhTnu64zbOLJd98wntPyN1D1fyjT");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1463642658300l));
        corecontacts.setMiddleName("T0OIG6XC5o9UTnnZOKE6ZQnHhCRzXpsV2pYtKiltkr2SEvfwRr");
        corecontacts.setNativeMiddleName("4Z0Tt5QT2w6ck00VGDEyPTIabtf2GLxKO9jUollUs4kzdkYw0K");
        corecontacts.setNativeLastName("Rhb0J5kmaxIDwNdUVLNSS4eVFnBAgGXY9IH2admto2Zu7AWgjX");
        corecontacts.setPhoneNumber("3P7Y8D7jKzNFSaiAgxih");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("WvoFkmiL73bEjMvd95AiPVh4f5qKDyC7wIiTL5uxbHt2gMTGzR");
        corecontacts.setLastName("24I5ZDIVtiVtWqQC0SlNtilLaVW6qQWKW8y4hSkqAEvZ2dFpgW");
        corecontacts.setAge(111);
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1463642658370l));
        corecontacts.setEmailId("O0AlhEvWRJ6Nf8BmlCUuivWXiQlS7gQpS3vVbX2dc5Dj8SdkWw");
        corecontacts.setNativeFirstName("Ou3ege4AhSC3hR5dK2I7RHqo0vb9n5GFFEENqGPyv2CyR8lOIj");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("tKzNJYtZnjJRQUnUUZf3sJdvGGhUq4U9gCNldeM2thehrH3HcP");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("Gt72sXAtMP");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("99cxpZWmMX4VrkmU7piXwd4T6a8JPFDsZRbxCcFvi98BKccXSA");
        communicationgroup.setCommGroupName("RkPl3G07uNgw6YcGrIqzS1JQ0FA8aSfZhA8SZucsK0r8Z3AjPC");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("SpQuMtLZMRSm6PgdkbzHTQRPBpQGullijYvYhgHBYnHvok1n7I");
        communicationtype.setCommTypeDescription("XE7LqyDawCfe0MXeMcz1daF8sVsEpHcncySArd95UoDTfdLzjS");
        communicationtype.setCommTypeName("flf0X2tfDc8bBKAkSAyUpH2zep9SgyBpTg0lgpE3b1qV6p65Yp");
        communicationtype.setCommTypeDescription("ETDuUQaewllLcRkymEFGjYmK67eUaH1mcWEuAhDRXC1Ok26JKO");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("cmJFGsoPtH");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("DtO3BavZhNWZCypoJnWPl5wc94BHGU1laVvilzgE7jkKmyXJ6B");
        addresstype.setAddressType("qFjX4kkdsw0IQok0SM1uXrvGmHjQPPrFE8CJSyH12ODs0tmI7D");
        addresstype.setAddressTypeIcon("TKleSRoRXrb4J2dXCwD1NbhDEuel6mS3T96rIOM6sUkylIqg9z");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        State state = new State();
        state.setStateDescription("mmyXbcnwTETT2YLLyKbfiKQvPQCUZNBZK4a3Ac2xTXBNZ3dzcn");
        state.setStateCapitalLatitude(6);
        state.setStateFlag("p6qc5CGkb09I1V1u589Kj2w4nDm2e9pBB1EkG5C1fyzfrHZZk6");
        state.setStateCapitalLongitude(3);
        Country country = new Country();
        country.setCountryCode2("tnE");
        country.setCapitalLongitude(11);
        country.setCountryFlag("KwZiG0QAr2uuSoThxrzTeqLgrfCgSBeyMLyBQE7kIxZmS9xxGW");
        country.setCountryName("jMJ2SRv10XjYcj77LyETL7n7m1VvT1PGyuqMFBi3KONoOxYyDW");
        country.setCurrencyCode("SN7");
        country.setCurrencyName("FupHxNOAMOMhbvMkIFEjfBHUesNCdisQjaFu0iQN7UFQpQacn2");
        country.setCountryCode1("JBi");
        country.setIsoNumeric(39);
        country.setCapital("5CJEzg7o1ULNSsDNS1QAiAJEUSoLQu8Q");
        country.setCurrencySymbol("JRctCgA591dl1igi97w4Lcobhav481JK");
        country.setCapitalLatitude(8);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateDescription("nj5YRUMJ8WZ1FwTcPvttVAu7t5X9RKFH4DjmmAWLybnB9rzm8p");
        state.setStateCapitalLatitude(6);
        state.setStateFlag("rDBwcnsAsdHfInFHvzUKpfBoQBpXSuoOaccnle9UoeChYMzth6");
        state.setStateCapitalLongitude(4);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapital("sbuAsnD2wjaV7qqSGIp5NNbjJE8mVJ0K1SsgOYFGM4XdRq5gTz");
        state.setStateCodeChar2("X9VNlEjEyOyDfMLyCHsRs7luZleUyMLI");
        state.setStateName("J4IBaYBuTD9m4nyKXZHNywoDpEEBcwEYUQu2O8JROdGWBK1e6Q");
        state.setStateCode(1);
        state.setStateCodeChar3("OXRTES69wtkoGSozmr5j6Fg5As4rBz84");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityCodeChar2("zU1cj00F5iIjIesg7kjZw54khWps0kyJ");
        city.setCityLatitude(7);
        city.setCityFlag("19OoZlSqWqtBgPXwFAsmnlxqZnRhzJQ6zh8G6cZUDL7qaIQmjy");
        city.setCityCodeChar2("ezPk9leJiNDQFLLJ4CIn6hcQNoc3WMOz");
        city.setCityLatitude(3);
        city.setCityFlag("2swOJkpD6R5J31k7SayYAaqtc3Dmg08HfrPAyA5Na5X0YZxhUH");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(2);
        city.setCityDescription("9bVEFykXFpOpWMgvRJLVLDUTHJyf62rP2bC67oknYIRtNTRYIP");
        city.setCityLongitude(8);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("bGXgPLYat4isOzHeSTeIdhbFcn2Yrbmw8qAXtiohMxGPlLZrYR");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("8TkzNkDX9QCfaa2TyGrBYpfZe0Di9yLIp3V77EncTVtGYy7HgY");
        address.setAddress2("MGc7XVOy3fFEGcPxkGanibaDKUG2GnYHyfENnbDULcLJKTyibO");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("3pzBsSY4Tn6dT0FzV3L19aBOFgXBpqJKx7U0pmciKkYqzTZByz");
        address.setZipcode("sGZpnJ");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        address.setLongitude("z70mTFjQvFlC2IkcjbBUZLFzAnwQky1PjnRiVHhGBWVxSqRKrT");
        address.setAddressLabel("HFcGg2IDIJ2");
        address.setLatitude("yaiqr8sY847elu1URqRW6WiJS4g6OZFZHcFug0pcjV6D61S88a");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        Login login = new Login();
        login.setLoginId("zAMKoNdS8tkjIk2v5opxSriKaSn5GiLIL01wC4EO2gHOTboUTR");
        user.setUserId(null);
        login.setUser(user);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setFailedLoginAttempts(2);
        login.setServerAuthText("NScV2slUG3lDN0sW");
        login.setServerAuthImage("r29kJ98HXobkuQXEzKYYVF0kzQt2p6HC");
        login.setIsAuthenticated(true);
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
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setVersionId(1);
            login.setLoginId("gJjkaJ1ysO5kZM93KtppJUYufF89UuFWX7ZMa2OFvSnz6SyZIe");
            login.setFailedLoginAttempts(9);
            login.setServerAuthText("OtZyNQqBxWe1cIgl");
            login.setServerAuthImage("Y5mz08OBaqei4ZYgdp72o2tpMo3Dg1CA");
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
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "HCDTxzBbbGuFfeAp35lVJFR1itAGph4Iltv3ESf0WXhGjKcFNeIPkXcAphY4lA4GhTkRM9gaPfIZOhZRYYr0SLCnQslBgPavkQUrjjlOHhrwwiuC7bEmRQqN0LrFQX51ftGVWIz4lbXRFlWPhuNcUKbyi01ERkI3kGZwyJuU26El7HRng3xG32Y3tOTNbyRWaO5H3rDte"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "wGk8LrCKXzg6qdroIMqs9xzRkZR7RekEF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "8i2H31PZdj9GaIUPI"));
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
