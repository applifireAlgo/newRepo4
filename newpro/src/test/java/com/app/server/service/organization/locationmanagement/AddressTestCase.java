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
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
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

    private Address createAddress(Boolean isSave) throws Exception {
        City city = new City();
        city.setCityName("uMOfnv9O971xopzUfeXUvEnBKUVpX1XHVhSASph2qGTCu0JuH2");
        city.setCityCode(3);
        city.setCityCodeChar2("F81ixIqXYRtsg9egsVgHb8JeLZTuEyjb");
        city.setCityLatitude(4);
        city.setCityDescription("PrTJAAVUAzogPNFoNWgBhZv9Hw9GxQMHfc6fP4EDIXGuzJ1i8w");
        State state = new State();
        state.setStateCapitalLatitude(10);
        state.setStateCodeChar2("an7XVDnPJ1TXaiYZ16mRTYh76rI4130w");
        state.setStateFlag("7gCSLs8WzcBClPkJA9tuelZ0cPLJB93BQLAxtNFAmwdhjWpqrH");
        state.setStateDescription("7nZmKn70mneeFrmCMW1kgGGqkbaPBaCu3jrleP9ePJoWYfAWJO");
        state.setStateCapital("P5b2ms1w8YUTwuzT1Arpn4Tqcp2Ys4iuPQoKfPRAHDea2uOZNT");
        state.setStateName("zOEZcY5Pra70kIjQBlBkvMNUwgEZKL7KsMLB1GBB0YRqUWYKG2");
        Country country = new Country();
        country.setIsoNumeric(878);
        country.setCapital("VKYK5igjruhgNLI1gGyBdnORbSQetrBa");
        country.setCapitalLongitude(9);
        country.setCountryCode1("Yk4");
        country.setCountryName("TQbkgvJjJzTyqzSWPVOV3UBqbE8Ibty62oWQJI0RymMmtJsnbA");
        country.setCountryCode2("fGF");
        country.setCurrencySymbol("uk8GM1R2KEcLn951rgWQ5mq3ZWyxuJmk");
        country.setCountryFlag("zzda7AEGfVnYW7RIEuwjCY39HMiKE2VOu1oz7oDFNylsaGJwDg");
        country.setCurrencyCode("6Pr");
        country.setCapitalLatitude(10);
        country.setCurrencyName("ekQ3tCAVCDqQ30xxdBm1KFD2TBVyXcUNcV3Il3Nt08MIJWYbhH");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCapitalLatitude(7);
        state.setStateCodeChar2("1yuEJcUZ47wy0D8qynPyKdXsnOjrUuDN");
        state.setStateFlag("T2MK6SdR1hYYMHVJTsLzBSvSm8aZft0VFW4wNQtPEABS0jhPhy");
        state.setStateDescription("XmAsEalxlAACpF7dCIPUzp1fadDejJPe1e1NfzLCdcAMemr1LS");
        state.setStateCapital("JajKPNQ8UzgN3javRCKlSukhTNInJRZaHMkb0SOkqFKE3VRAWr");
        state.setStateName("jQskTb3JVvkY5dAlD89qDfYJiWTDN1MuuCRqi9iKSI7iFhQeCi");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLongitude(1);
        state.setStateCodeChar3("YMZ9fqUrE7idCCWwcpG4D0EYium5VvxD");
        state.setStateCode(1);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("SaCRkHEjr4GkPWUe57uirmRriCyYNMG9giA7Sl2uqIYs0iQFaP");
        city.setCityCode(1);
        city.setCityCodeChar2("mBF5i39CndKx6jjbXm18C8kADreh8KPR");
        city.setCityLatitude(4);
        city.setCityDescription("NJVYgybTKC2mvcX3pXdteXfG8tVyKI0WhSzvMyovWdlPMGOIW3");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("6SYuOcjCb0TfUojxkYVMeMqPYKHRyOhsJTo5Lose3Ql3CHclfE");
        city.setCityLongitude(5);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("NVge4yD4YDuFmYY6p4lykhnXb7UUinFe1HSfUgHN49QMjBQcMU");
        addresstype.setAddressType("L1VWN8jbeXktuaNEi0Q0ldhdVedDT86GwrQrWYkyyd0XmeH2nY");
        addresstype.setAddressTypeIcon("JyEbttOKFzPVVGn8svyW0azVXu3ahvdA1oZPYzUNmNXW70Na1F");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Address address = new Address();
        address.setAddressLabel("ZvwW85IBGke");
        address.setAddress2("KRAzYjSQ4ftyYLtOXRlh3uAUiBvCE0uhUQDh8XdjMu7JmpUtYE");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("dG5u3J");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("a2qWeNTZ36HbOEFwFk1y0DJ8xFfFYr7j7IqjN6ICPwMICbZoka");
        address.setAddress3("9z88szGMN2tTmYrOGgHJsGefiwc7ne8coHkPjw6YgrwoIej9mz");
        address.setAddress1("LuZtD0ZWlbl6W3fBAcomgvNrH0C6qRrtbm6dPIgTidtpTMGcfN");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
        address.setLongitude("3pkExAIPSHjNvl2jG5fLW7zJ1HTelCAHmY8r9GIXfpWWIP3oAO");
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
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddressLabel("ORj2s4GUZD5");
            address.setAddress2("YmM90070nQ6KKS0hSgoYY9rLhNB3ND7Oj1CJklEK0szxl1lRph");
            address.setZipcode("Ye2rVL");
            address.setLatitude("n5ZzPNAl3sc7GtiCyaZIw83k7aNIjIH4Qx3Ibj2lry2iWWt6Sz");
            address.setAddress3("dmAvR3t8SGqodGQs3Xncj7Qm33SwpWEunT66BWx0xc8orO4QpS");
            address.setVersionId(1);
            address.setAddress1("FH0pWdmqGry9mcmvdxSLlnarAi5mfyePQGXQ0zMIYepGPGoQMb");
            address.setLongitude("0egDGvn09DVlpGB77hek7DAQlbiI2YWwYkP1zyQD2bvjZvlOhV");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (java.lang.Exception e) {
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "aj55D7iufG3u"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "dEozQcjKmDCqQVK7X3zBdvrLhLtJojS03o5FTq3mNkk18GduWlcqEHCdu"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "Ga55XiWeiW4z8zSUs2IDPxQOrTUICeMx8pbywVgSp1yj3GemjPXke3PaJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "GuvKtDs6Fx9Oq4DzkiH2bWWMNvKIdtmB3HhEcrlZk3JChMlUHuib9iFmn"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "TJQJlG9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "MowUQheQFhpT5gtGOD7oHZSvc7m8kN0RNscNktJlSqDWthVDN8S5QkMDQp0OPxVs2"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "D9GcEmXnJjv8hFcCC3N9vQivkrPLZ8QrmwNHQszo2fPowqU40dcTLvsrmVNR9bnnS"));
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
