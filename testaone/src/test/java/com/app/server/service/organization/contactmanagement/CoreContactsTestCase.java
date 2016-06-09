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
        Language language = new Language();
        language.setLanguageIcon("7LHxcLJtZc8atLJbunkvo77FhRsETV1r2kRUG9bh98kKwpXPQa");
        language.setAlpha4("Ak1x");
        language.setLanguageDescription("2WDYoiW2nGZkDKhW9zOUrbb72XKXpvjxRrkwzP9DqyIzjtvHAz");
        language.setAlpha2("mW");
        language.setLanguage("ssPdllL0P38MhnKbqsm7b3NtSBt1E4EWMqc92lQIeWf6EqzkmS");
        language.setAlpha3("xiT");
        language.setLanguageType("BCHvaKHudOr7pVWV4fZ24xloRI6B31ii");
        language.setAlpha4parentid(11);
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("WZkG9J9cXg88s8lUXQZ8POHeEsCiSvXoWS03lDhkzy68N42Ncm");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCities("gzCajGL91yCrGNVVNTlA43D1P2pDyU1C2rNJ9pIr7728Tbf3Mw");
        timezone.setUtcdifference(11);
        timezone.setGmtLabel("5TasUt6zLkmPh7X76hZljC8pQ9cogCwi1bG8isebg6ZZFYRfNa");
        timezone.setCountry("xOE4IWrbpkDWq16MDxoH4IaI13JasZa1cAIMMaqd2cp5zEBiWw");
        timezone.setTimeZoneLabel("Q29GY1aK2C9WokFdpp64jyFJGBS1WjTx7l01Y67YceQOaTskOz");
        Title title = new Title();
        title.setTitles("x2YOsWG2JcKN3sxqWk4GjIHZbpcridwECVkNzisCYHvfCdkQ8v");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("jG5nJ6TzmnGMdTWtD3aFHmkaP1rhS3XsZtx9p36f3z0a9jazU4");
        corecontacts.setMiddleName("5IL4I9X71JQewW18hLP4gyJcGyn3qiylSh6nUVaddwtqRUXWYP");
        corecontacts.setAge(93);
        corecontacts.setNativeFirstName("yPYQ7YOXn3CgiszNnNLiqCkfjpOsIGlgSkc5N9hu40GpPFxaa6");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1464961014580l));
        corecontacts.setNativeLastName("18d3i8bIyADuz73cseEEvNCD9GFu7NOC8vy0V22P1Lhw3NxVZp");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1464961014580l));
        corecontacts.setPhoneNumber("h5hEafBTg9BOroYlKXqZ");
        corecontacts.setEmailId("SKjDRwlvEPvMZnESoiQx6VSDuqXfu2sPcV2qVz8zpa803i9tPy");
        corecontacts.setLastName("f4nsO6Kk2Tkva3kTBgqv3AFaKerfA81ABweS4Y32XKImEgzp2B");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeMiddleName("BuZGFpEVBAyJNsJNll3BWKd2oLTkyuPfSotJG3AMHzWGTn3Ze1");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("Zo2L4gtXAMjVvliurPaLjn6K9Ryli5k87bDiyh0yviLjSAwYUU");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLongitude("1ONvxtNcwoeJjPvBvqChXb3GiixJR6D55bVkFP4uQzszRu6zuu");
        address.setAddress3("iHmeY8BNztyEubUqn7Y8aDHRQZZwYcJHgegBR2QgNteRKt159w");
        State state = new State();
        state.setStateCode(2);
        state.setStateDescription("B6krR68jqkVbSYSJ0SxExsa2Z0LRBb0GHXfTVOYhliP1PfwkLt");
        state.setStateCodeChar3("CLdcXTgwvYXDAEu1h6eUntCSBB2Bn5CJ");
        state.setStateName("wNPSyhGrZPZ9cJjglH70xMBskoe1Dwy18VEUyQHOo7hfq94tSp");
        state.setStateFlag("Nuva8oeru6I9VEGcuwQCRvshaz3bWipeJyABI6F9HwzZPpKh6j");
        state.setStateCapitalLongitude(2);
        Country country = new Country();
        country.setCapital("L5GWwlvuHcLJVV6XhIaScLegRviaG2v9");
        country.setCurrencySymbol("kE1lWfT0mrNLpc5KKtuvpdFFlftQb1DD");
        country.setCapitalLongitude(4);
        country.setCurrencyName("PA64UK0ndQ3vqr73UJXT8IMyvrJMt9C21BjZ8U9tKxvbQQK29I");
        country.setCapitalLatitude(6);
        country.setCountryFlag("raPGUXMnW7STilLy6kmtoBW6l4A9KA0hEqQMULDZoWgi2eObuP");
        country.setCountryCode2("kFz");
        country.setCountryCode1("z9T");
        country.setCountryName("pSk7oInpv0DAGIP4uuJeDWLs3xijnNxn9jQFFiRSFqISe1ji9W");
        country.setCurrencyCode("QQn");
        country.setIsoNumeric(279);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCode(2);
        state.setStateDescription("HnZVwx6Sl15YM4hNQdNfm5cqMZoejtQi6su03pCOuWngzMfhfV");
        state.setStateCodeChar3("OHuLGKwNXwYwPHB9WmJm5jbA9x1uqE28");
        state.setStateName("zvvNVGaFOy3eWnomgYgZ0M3R7U5GouwHmqk66L4DKFjG2h6I54");
        state.setStateFlag("jvmKCMiVJylJPMvHSTLHUpWkFFq1vxPmXpcVkvNBPGW51yFxZj");
        state.setStateCapitalLongitude(2);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(2);
        state.setStateCodeChar2("oJPLuQrt1zGXxKn5oGYeMNJHZUxPX25Y");
        state.setStateCapital("ezolo9MK2lkg9y1h39hiSzRSInzIcaQTBwxmCknMxUTjTUG6DI");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityCodeChar2("RAL9L1BduQxFufO11o27wvVNV5zCciaC");
        city.setCityLatitude(9);
        city.setCityDescription("9qEV1hNX5oWlasFDe7G16s6jVhSxs5cZjbj86T948DIIchbVAi");
        city.setCityCodeChar2("n91CTxTa0VzIXW7RayXLEt2rXoZHHgXh");
        city.setCityLatitude(8);
        city.setCityDescription("TrkqRgtmhvpcccN6FrwlEWaycK6qfmbTmuFMmYXcwDffzAaBOG");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("OMruZZTwiyoC9hNwuM3NnKrPYyMNgojbsToXuKcZo876z0w1ep");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(6);
        city.setCityCode(1);
        city.setCityFlag("hfysWInlGoZYb79ukP9P6JgPAAt3jr10ugYV4cHYCmVAZUImqN");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("FHjKRutKBL2LegbAKSHEOsjGHkR7Wr1csfiAVm5cj7HixYfCsz");
        addresstype.setAddressTypeIcon("vti7emiMHW5eyeYc7WkGZMbYPK0iaZoF28VaOtFTWXsc0vNUPi");
        addresstype.setAddressType("KZl1bOrH2uKnjvecvvXrqcvplhmPdnBqAfz7le22SONjaWQGzf");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setLongitude("0cfHNDsBrNjYyTFsLstrWgj50pRl7qPZy5ICgbrPwNnbznUdYD");
        address.setAddress3("o9ti1YGIOHqmDDyP5B08q6TSbthQUR2wEID1katQdjR5ltib4r");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("thdv7TGNx5nAxD7xpFnkVnMhiMH2hzRfkprbeQKbJJwYVat5Tr");
        address.setAddressLabel("1v2wzkDW5ff");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("fNaWgk");
        address.setLatitude("aWw5scAo32rc2sjAlU9e5qaP3uCZLTOZh9t7u3Xm5MjupeVRS9");
        address.setAddress1("Hwm3VMr7aLq8t6P4r2qIe0ujZWrpimc2XhyMgrbStA2GWGfvwv");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("6ZYpaGpI8sRFOR2u662fxfKR3rAKTdRpb61NirvaE8Cmf60lgi");
        communicationgroup.setCommGroupDescription("oSXyayTMQzA02tqlcEiCfrAwcKCfWQz6jWolREzK1rEwY7BM6w");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("2W82Subdrw62TVwuAR8mWvuFFKMMyFhEe1YZ7lcCzwQpL6qQVe");
        communicationtype.setCommTypeDescription("1Deuw1gsKHkI0SaxsC0mj48cMuED0p67taeg4pvJSUivnRQL7D");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
        communicationdata.setCommData("FXLqsWc1Yt");
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setFirstName("rCncc6noBdlJAUow0U9IFlj2sN66SraNaNcTVNxEMBkUI7LE8K");
            corecontacts.setMiddleName("nzFD4UDnAqENSkYQZbwE0Fq0CYMIA5WcUQUxJRr9X4mn0kAU6S");
            corecontacts.setAge(75);
            corecontacts.setNativeFirstName("nR7KZggH2n7lBQIW8L8RBPejaUxMEFV46YvJ8zBic4hNSvSFHN");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1464961015106l));
            corecontacts.setNativeLastName("6uC7pZ8aauVB1rFdkjRfBAk6E6CDXwdGsuNNUgmLVrCE2CweXJ");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1464961015120l));
            corecontacts.setPhoneNumber("sEwV7FgoqshrIX2r1Ph7");
            corecontacts.setEmailId("pbjyC8oBL9tt69T4OGBstZ1ksobDlalo0e7JZXT0oluCL0qAVH");
            corecontacts.setLastName("NTYGDUlHz8cwFzh53WaSISNPwJFF5yLtQ4ParDyn446BvZrWSF");
            corecontacts.setNativeMiddleName("FZS7KfEeHuJsYDROSYQ9aoFFo9Hsw2s81u5Ze9du0dlkd5EdO8");
            corecontacts.setVersionId(1);
            corecontacts.setNativeTitle("pwJpxDCoxwqOFfFVaVdItiF2n4iK8vlIQvQb7S1niYSzbU06Xf");
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
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "QsNefAfL4piHgLrdionYTEB0Qy477GUffizR3JmI35YwSvLL9x5hBHQyFZYW17ispfnU4zL83NBdhoa38E88P25X1p45hniuyTvJdAQ5ULulEqI4jR9FNxHhKd1ENQeHFjdZhkhW2GnOdLEPQmruunPwSyGbIYUrTHPx2MGS5kSzbh5ivpykvwJJNXZvGl3Bg1han6Yp1DI6bgfpSboGFJdSVckEc47YiUhHi205wXKi0jm4n44rtpLHTQRsGjuRl"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "HBUkKqOKcIoxsp5QNl5c9YYlQf2d21E7QwnDEsIyJm4hnsTttRZbAb32JTvpDdKUqMNoZ0ykwNE7XJmUhM0uYChmuuCASysqSu1iL3w3MkiJCBV901AVWzJBn7ZJCMSqZHksmKNjcw8UV9QcyjodG1DYvAQm9NkVktRD8Hjd5Ry24rppSCPFW2X3XbHxxUup0oouR2GzClkej77bFrEA5ARtegxLQ2APlzRqgydEdN4umYOaBTp4VftjZcwVIVpug"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "5B29EORROijauGNZiwEJDKVlWjEw5iuYQdHvIfUxcKNnsn4tOENos90C3aVCt3KytqWjGox7F6DumcmOAigT2u3hpgKA4W8zLNi4cwGmB8DjI1f83hXHgBuvuSYag3wncISNJfzkQou0VWA9W0HUvOPKdWpcXkk9gelgMpAMolRUsEMhLhElaFzkjH8VlKMuKyzC91vcK2xLNVfbyXDu4DVudMcbRhGJL2lbmV4qvZnvivv7oLR7kA5g9o9Kmc4Jt"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "rpxKpx5x9Ume1QehTMY4et7V7oIMfKofwKREhHXsYBUNTWhg4IUC2TOUUVTBm0psZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "k0QY9H4t9x5RE7mR27rKGS3oOjUFOSCLCCgfRpLpXJXgHM3OwaQmsNyT68XkQ3vFfWgbkmvPDrqOJDiE6WzFKsDCKX8Ee0QNEuJQCj7rwX8dMDSAPO0X47x2nO4iifEIe9kGgk86elbHWnxK5voyvkbZmRK4BzDTe7ZLmc0PufQx24VrHDnblXQuubMaxUaqVZsoPGXOaVt3WJr0bPD2Ur42aCoIFd1eeuIkv99CtYc7JC462hvNKun7lsVg7X6cI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "Y9wyqsc7chCTWkZEpabTqas638bAMh3AnH22NQTDFSGXhHh4JmqDgy4i3Vl8hwNJ66ILD8b3BR3vzKiRipSQrV58uAbt3TkvJiqhM8w8KSqNQKVe2CsOrXc8cWHlxM0FCZPqWR5JhtNlDMSklp8vQwOHClZV8zidLZbKZ461Qo031y5QLzI9WSopAxesn2UYEmo9ZFdHBb0dpMtDG2SCWHEFmbeMNwKkROJ0FdW808tlUZzuHmkwTiUnsKDxolXIE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "VM9LaZPVe3T1wcKpU1MzMKuCOzsDaY3KxLnAOkKJ7LTRYtOwvAsINLtVhw4n40mvxuMvjXQALzRK36hflPhJLF37LbJRj6hvz05Nn11oRdkHZV35uCvawCBG91aeJAsML9WPwnE7IMwXfTZgX5R8KBmwoy2oxIiI0hMjzenX8y6xX5BDk2rahTDLSqf0ERWa3pIQhGZu1RuyYO8772OouFvwDJwB8LHCaz0vFOgtxTPkXr2YleFjj4ZLS7hmAECa3"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 216));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "yMZtTV8JGXqcUEQLOKU7ouMClukv0fWuKacLCAjADXP06RdfoXorCxD1hA53GyhGXkBYzi081yE3aU5tI6qZ4ks55rcmBIHGREyE8AdbqSSM2yrkqhAspCIokYQXmbvcQMXctFHsSRl5hODMFT1t25HVUzaHDse8rIC7TSKjrJiZIRZXPvB41agvCi98Rxe1Ro95eKOYhg2pnqpCIpeHa5YOgv5Nz5NOYRfZO4bF3yKNXG2IZe55rhg6cEzv1mqdh"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "UEFCttWINxM7qqT0LFZys"));
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
