package com.app.server.service.organization.locationmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.Address;
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
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase extends EntityTestCriteria {

    @Autowired
    private AddressRepository<Address> addressRepository;

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

    private Address createAddress(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCurrencyCode("lFS");
        country.setCountryName("qoc47Yxypw4CkKG9RVTiIfZ0P31Ia7zcmggAJ5BAAK432GgqDo");
        country.setCapitalLongitude(1);
        country.setCountryCode1("Rl0");
        country.setCountryCode2("fhO");
        country.setCountryFlag("6LNfdmcM9a9icciJG1nqhyV9NuzZpKtOnZdxw4kZyAI0Ebiuka");
        country.setCapital("4bJKZTJskIJOTpdDen2baU6ZEbd2j5so");
        country.setCapitalLatitude(2);
        country.setCurrencyName("0CsgXpWK7EuHmYTFLEY28L9wojudwtH8IPD95AGpLUQGMUvHpN");
        country.setIsoNumeric(78);
        country.setCurrencySymbol("83uhIbDV2zz8KJk5IsOmu6uc8rzK4JxC");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityName("0U7P3cUKaByvRLkpBBhW2bPQ8PhRSQhzQwl1BQPpS0nN2VzBO4");
        State state = new State();
        state.setStateCode(2);
        state.setStateFlag("mCc0WeyY6P8fxxglvblcnQpwtLOsKncVdd4QfbXYV0iUtBR5jw");
        state.setStateName("RGkiuZumVB9gKMnQ5zrFQAPIez7YzGD2TEPDN4qvRWSbsWMnjF");
        state.setStateCapital("7xSiwfAfhXbvjvdIvewn5iEOIvqfC0IGuamF48Yykq8EEOkLvS");
        state.setStateCapitalLongitude(8);
        state.setStateCodeChar3("a15RtvHFF9CyPSMWJvMTEteVw1kLx8X6");
        state.setStateDescription("wWfAL4CPTy1OUKLwO2ZiW3GHAZXk2U0tva0tWBF8ii9V8WmvR4");
        state.setStateCapitalLatitude(1);
        state.setStateCodeChar2("XYJfNZSoCGauJTAmap51aa2gcL2fc39U");
        state.setStateCode(1);
        state.setStateFlag("85DuPopjGzsEKwOQ3HoATUFO7HIQLHTa6aZM6Frnlfon5LmHgr");
        state.setStateName("AuSvkIiSkS3EAmOTamVENLFhonV6IO00heTvhgeSai2gESBOUZ");
        state.setStateCapital("3uFsbzAw3fn6x1gOrr4mEfwMkejqFV4GoWbQuluUHqHyHTP7BE");
        state.setStateCapitalLongitude(5);
        state.setStateCodeChar3("oHZwe9fJmZOqlGtqKyUZubww10Esy75V");
        state.setStateDescription("4v78CWAzXMvuNP3Zvc1oMky8athwXF1STIkke8eXmBEEiOScf2");
        state.setStateCapitalLatitude(2);
        state.setStateCodeChar2("MOmpTljVn56At8d8AR0yMA7pRCueSLxk");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("no1sTYnBBNY3gUkqeqq1Z17aP34CWMq0slrZdYHxH1tEj8AoAb");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("t3sRtChSfNcnBEmj3HEB8kkA7o6yiTR6");
        city.setCityDescription("WpwPIAtAao1nHXnx165jc3xe2KXVU7MFLi1NAzmbrq7b0yqJyo");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("xbGB1rYCMYfCR2LVfoDuUNyeIEZwmlJH4M5BGb4eYSAg1AGUgu");
        city.setCityCode(1);
        city.setCityLatitude(6);
        city.setCityLongitude(3);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("ttYsAedjzfePo13GwoXpY2tTxzn0dJ02j7ZSzJpedOCOpuFKhw");
        addresstype.setAddressTypeIcon("Iai4V6AYIZ4Rd3YsRYXLTeYOaWyJPPjOgGLGGkt67aiUtBWCVi");
        addresstype.setAddressTypeDesc("6MFP8L7JrRqPIMaMDUk9oxlTmVEqVDPxCnLAYXecQ6KwCy5vqK");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Address address = new Address();
        address.setAddress3("pjFve7XUjPXvZNFJWiThvDFyjd6lyjPFdccLCt8RsRJAQEFB3T");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("22xxunygLcHoHfd1XW88pK30ceH2z3UMrmlWBHeSZMKFXQoXYv");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("s9EWQx1eTbh");
        address.setAddress2("rDdkdoxw4MNokhhYbRzVxbcwGBUI2KjLXkRQKncsm1mIQEyAGu");
        address.setLongitude("ql9jiD0zSEfxZPq5AK8jUZe6tWr1i4bT54BAm2u5inxX2b3rVU");
        address.setLatitude("t8twjWaIqHNttHSO5Ii8tvgrHSZmU8Xk9gAJFslQrYETLtLi42");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("nWeQR3");
        address.setStateId((java.lang.String) StateTest._getPrimarykey());
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress(true);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress3("PY60ykgSdq3VhlOaAsN6Vzlq2yEcFEVr9zxR7bzeXNM63IbUB0");
            address.setAddress1("arcoHz7jrlwrFKBlANtHDO7v1tz87PNyNXptAJqR61EvqOBnwo");
            address.setAddressLabel("7HUPT0DWv8C");
            address.setVersionId(1);
            address.setAddress2("eaq6ltL6wlqkCDJXY333bZlzi4Fxr3Zz2eN3r6f89KXFy8CzmN");
            address.setLongitude("xBsS8VeFoJ8lh2yaaBYY9FKW3RvRCskWKPSIeycPnjjlbtNfVm");
            address.setLatitude("8jBKkIgWlJEZdascZbDdPMnh2s1NSHEcrZ2MY80YBiNLjv1CVz");
            address.setZipcode("pLO8XS");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "dUf96Po8uMrJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "N5dKEYTOKhGETsYKF1hngmB2RG6IXh6P8LEZEi1FJo0Zdb89VDfBgFpLo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "i06jl0RYO2Zy0XVNrtkEGxDeUUe9ct6rwW7H0V2sDlEnyBXhgZ9t4hE7c"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "wUAeWIPjkTz0W7PEVYj1vX6jv8mCMRgrcHPBbCuNHwha8PmuPLZc7p66r"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "5TD7zou"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "CkHamI3gYV7ej2c0UY1ZRABHMjIwEWbFqHIwiarytwcXcDiGsjr8EYmoM0BF89PkP"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "6tuWXx12vtedwM27E3pNztPhYepH39oEuHJ77E0m8TJasZ3POlfAT4Dogl5UuKlZJ"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = address.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        address.setAddressLabel(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 2:
                        address.setAddress1(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 3:
                        address.setAddress2(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 4:
                        address.setAddress3(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(address, null);
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 6:
                        address.setZipcode(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 7:
                        address.setLatitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 8:
                        address.setLongitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
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
