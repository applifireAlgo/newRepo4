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
import com.athena.server.pluggable.utils.AppLoggerConstant;
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

    private City createCity(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCapital("YUMJyrEJeh0LqqhRpODsW1tbKvrwW9gC");
        country.setCurrencySymbol("QhVeWz0TjCw7luPOO7z5D6n8a1Tp3AlI");
        country.setCapitalLongitude(9);
        country.setCurrencyName("eVQSGPOWKYJlsxC6pXa42coIPvtsTgXZAIwivbBXZyiQ1DUcLC");
        country.setCapitalLatitude(3);
        country.setCountryFlag("TAn2weQcCx52kkqgPc9m7QxC83rFKWzDHkIwNcSLctNlulGyEd");
        country.setCountryCode2("83C");
        country.setCountryCode1("fjz");
        country.setCountryName("9Rl6Ek0fcoThKoB1pfZCCrftW1zYbCmOzxyCC8eUHgSdU41mSk");
        country.setCurrencyCode("5UB");
        country.setIsoNumeric(106);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCode(1);
        state.setStateDescription("ct6xPQcponDA5GVCO69rMrL5Dfa8NafohXoZpocfxuNQaoLKW4");
        state.setStateCodeChar3("jacfHjHBIPo2TMFcPUE0ZI3cS72ZqV9i");
        state.setStateName("Fk01pOJI0fKotBxDQKkKasWs7HBkkNofEvfRbPwfPS5KRO1sSo");
        state.setStateFlag("YtX3Ughc40Zt2MNen7IqxJ8g2U2488Ok4h32d0HMxovPF7luWf");
        state.setStateCapitalLongitude(1);
        state.setStateCode(1);
        state.setStateDescription("1qwE6aUfWMPMl65IsixsGGg6RM8ZubPJYtZRrmxdcHAgwe7ZPv");
        state.setStateCodeChar3("T1l8qoMudljdiO8jrrtYFMIhiJZMOk8v");
        state.setStateName("BfgUMkIsvCIb6rnepUj6wdcvpw8c3EIFmeMxmX8dT8MsgMneTV");
        state.setStateFlag("GwPqPdVIG78Lpjj19g2mLbNLj43NWK2ZbRtHpH57YToXFK2tO5");
        state.setStateCapitalLongitude(9);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(10);
        state.setStateCodeChar2("3ETNuRSIco3uT2Jb8b7v232cI1c9OTJR");
        state.setStateCapital("bFpVuXmYOfYTGPEWC6JNl22qsv0W0qTK4DX3vR4xS9egTxUYnw");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityCodeChar2("YAHA2LSrPxh6FsHOExSfpXs7sBYQRV5Q");
        city.setCityLatitude(7);
        city.setCityDescription("t1ukJuVyDxzdHxT19qTBpdUZvRuZOGAp5BjL6WJpo4XLPE4X0L");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("g0ZbjLzOrXrvPXDFzYqZvMes2kMynnmzsJNfSeF48pzNgwfJjL");
        city.setStateId((java.lang.String) StateTest._getPrimarykey());
        city.setCityLongitude(3);
        city.setCityCode(1);
        city.setCityFlag("woAfppsBX0mU3YhOlnkLMzLiXaH1MBs3a8RucyiZ1aOeccLdH5");
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
            city.setCityCodeChar2("yiot28G4Rxu5aMj6L1Q1ddWtHrrW2O5G");
            city.setCityLatitude(4);
            city.setCityDescription("l31mZiR4FbxLXIVXpT1sou2MsdbXorf0ii22jyLlyHZtOs6Y4T");
            city.setCityName("yb7hJcrl5yZ9x84YMTrZQK9clp3CsQ0AwmyPziElQm6kDFpeWW");
            city.setCityLongitude(11);
            city.setCityCode(1);
            city.setCityFlag("EF6gOW50kxjfBiYx9URekgvu88PqIlmZ1a74hH2huszq8k0Xda");
            city.setVersionId(1);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (java.lang.Exception e) {
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "cityName", "HlyNDYXJbMVAIyPFs7VcaM7BCSxz7iHdU6rqzPRq3b0xRTxPn5f6XWWabZZ3tkf88Fr9JbtblEndiCqXJj38ktbf5g3TlOe8obYcoY0EJOEWax3E208miH2gu1p4MhGcOKxFUooywhPFxE0hTO9lKzUYHJk3vt7S5lzYAUdXkCNzqUy9mTCQT72gC4AC3jEyGSwngw9KIZlsQJLaXi55f2YaG2g7IfTsdfAKntzLTXNFAJPw8bvtYnwaHUDr4uJle"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "cityCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "cityCodeChar2", "VTZgiqsTS7ngV5MF5TZXABAAMViUwADbg"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "cityCode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cityCode", 6));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "cityDescription", "n5IWQfB3zvaEDu0PROvxHUXTwACw2GWQu0C2jykJ9nfIaJHzMwVRxZeZ15Q3yZTcx0LK8oEeVMb6pBYsKOjuRPzKp539XwchHKGVwOzzoZoWqS1PlU68ZIAISGdQDVwvD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "cityFlag", "DCHXolXdIeF1zB5Pn2VYRfeHkhuuJMOcxkGJYQ32KtXGgble2SNg1Y660uP5UwL3jN6qeauXKgPcVVOQLOYevLTMpPKSs5MHMIo5M3sIefah86fooLtHJkS4wET3OzhQt"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "cityLatitude", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "cityLongitude", 22));
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
