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
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.City;
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
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase extends EntityTestCriteria {

    @Autowired
    private CityRepository<City> cityRepository;

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

    private City createCity(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCurrencyCode("cRk");
        country.setCountryName("BHKdfVkqduXPeIVOgcxzbWK49hlrQlye0AzbF0pXouuQVIjOif");
        country.setCapitalLongitude(1);
        country.setCountryCode1("GSy");
        country.setCountryCode2("VAo");
        country.setCountryFlag("ohefCjEfINhnUalMbJhHIY265RIX9qMM2byM0cGgHYvscyVEeS");
        country.setCapital("UyaTdn7NmFytlP6eVXIFb9r2fUZHrh4J");
        country.setCapitalLatitude(4);
        country.setCurrencyName("uk6WjQUUCwVIUEUpt8hbdJmDiKuJ5CPmfiu3hWLpQf5PTEuWaM");
        country.setIsoNumeric(595);
        country.setCurrencySymbol("gody1yzWdcMtPcP41oW0QL2sVCnCaVsS");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCode(1);
        state.setStateFlag("Cdlak8w5hDUIWWZILi7GJECVBpC5n8Nk7jnwfdeb0B3Q30uTOJ");
        state.setStateName("fGAESTGLedQKcdWccO7cnv0Ev8aXMTYkwSbhXkvmogS17sf7ay");
        state.setStateCapital("xpALNqCZTYmWJ4Ozv3x4wl4VxEFOfoHXr0lnHAb2WTgSDCPBBo");
        state.setStateCapitalLongitude(1);
        state.setStateCodeChar3("pyy3cfqntX5CbCF7BtUwILyL1DlTHpjp");
        state.setStateDescription("KV22NMvplhOH8ZPAGk4oJin9QPe87nBVW7Kjha5dubwbQsFZPq");
        state.setStateCapitalLatitude(5);
        state.setStateCodeChar2("fxCvttyEJ5RR8aIlds8Ao5giSXIoEphU");
        state.setStateCode(2);
        state.setStateFlag("vvhNBwYho1sYCmFz4i874Kn3BMibtmSf2Os11Ish0QRmO76SPW");
        state.setStateName("r9Bc56ZV8BeX3LWhNbKNlYG73oEy69hBqaN54PZJZ9xmF1JHyH");
        state.setStateCapital("oYMy8eSFQ9YSXJhF9H9pSFJo0O1uszGmP5Udl6TfJCgfgFqmJY");
        state.setStateCapitalLongitude(11);
        state.setStateCodeChar3("yjMe4YfveGjmrISzyDK5egn0bD6EB32T");
        state.setStateDescription("AxGe0dxMNXyGNLB61CwpKQ4vGZTfivCyOTZv5KiUNOAG1UoMop");
        state.setStateCapitalLatitude(5);
        state.setStateCodeChar2("vNskuU2tJ3H0FXTuGQLT1VKWQgPSD9v2");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityName("SxNe27HZgcLaqedozwyZvfIvNorndyLqvBAoZx1m3xiLtdxR75");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("smyPgJo3R9co06FUIKM1R1mi3l17ccwk");
        city.setCityDescription("y5fS7Cjd0bdy2K3Ac8ugYgohVpdTYink2jKce8BoUOnLKOjyOa");
        city.setStateId((java.lang.String) StateTest._getPrimarykey());
        city.setCityFlag("FMapbDwELx7yuqEpv4Q8Uf7rcDJh4XtSVPbVasSGVUefZ67miO");
        city.setCityCode(3);
        city.setCityLatitude(4);
        city.setCityLongitude(1);
        city.setEntityValidator(entityValidator);
        return city;
    }

    @Test
    public void test1Save() {
        try {
            City city = createCity(true);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityName("6rXoP1jH7DSJpM3LOCghHA7tu3iNjGdy4KTy2FmrvN4DBuhxpQ");
            city.setCityCodeChar2("uISRwhJYZL18r1dycpViKZVYrAKzJcus");
            city.setCityDescription("79M5LzBRJkOG0mqO4ZMSyi7uPwNbKMn98GEx72LoCmXea2FjbA");
            city.setVersionId(1);
            city.setCityFlag("BMIMYxUf7q3vI1U7b1XLlHCGyRW7FqNGHnWaiCMadCfKSO0g7D");
            city.setCityCode(2);
            city.setCityLatitude(3);
            city.setCityLongitude(3);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<City> listofcountryId = cityRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<City> listofstateId = cityRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCity(EntityTestCriteria contraints, City city) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            city.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            city.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            city.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            cityRepository.save(city);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "cityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "cityName", "DtzUoomenbMHZWBh7j1vcrWjQ4zdu0Jv3op6Cnbl21W4kNDrpgQUTjbL3INtOji9u9rsOGn7QWXcGh4peKU8SN8BrGCeJA7PVKuABdM0NPvzn951IyfKvVmqgtt0vJ149SgFnJYfdhDZ56bVYxwUiQmrdbmZmR2jNT3NGLCn5gL5S47pB2X8hn7ylOX21avif2rafZGG202vVOeniK6iZ0klQv66InJxwM8927bHJYHnwoaujlwbMHn1fwhJLtziF"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "cityCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "cityCodeChar2", "ilpDR8ST9BpZG0756ZsAG5EHvUDRM0fEk"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "cityCode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cityCode", 5));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "cityDescription", "ioAH9hGMcxjGC2bdMVoFHHjfRH4kMAa0pKUhBlr5FZumyPlDicmDUlvRZKkfQWWPq4BrtnZDIjDgCMeAEuYFdwuygiw9xa8iDIjYSNII2OeacVCNBynh4B9zAn4y2KpfG"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "cityFlag", "gVp7eCpcTNKL4cQFRrA8gwUaT0M8sUierBSDzUsqhnilsooRCgXiGQdEh93ZKtGncoAJeCIHFiAcBU9NmbY51blJGBV4ylkJ7qnl0IG2SwMsYoUdJ8yQI0AGiaHNe9VCK"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "cityLatitude", 12));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "cityLongitude", 19));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                City city = createCity(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = city.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 2:
                        city.setCityName(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 4:
                        city.setCityCodeChar2(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 6:
                        city.setCityCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 7:
                        city.setCityDescription(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 8:
                        city.setCityFlag(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 9:
                        city.setCityLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 10:
                        city.setCityLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
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
