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
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.State;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase extends EntityTestCriteria {

    @Autowired
    private StateRepository<State> stateRepository;

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

    private State createState(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCountryCode2("wch");
        country.setCapitalLongitude(3);
        country.setCountryFlag("Tlyy6iyH5kSMECWEZ0MdxmnXeHkmbs4PJS8B0Ra1oVa6mvQjiP");
        country.setCountryName("QzSrGe1LMvHocWSPbtIZbCkyEMXsKWWx3Ax1c6VzRxVDdmbyN5");
        country.setCurrencyCode("ddf");
        country.setCurrencyName("4YYOaR9QLm3K1S8LWsF67XHlDCwIjQXhRGKUj9CurY39dEHQgV");
        country.setCountryCode1("OfL");
        country.setIsoNumeric(465);
        country.setCapital("yUYEHxFwkLLa0T06RhOSckqmAKSkHeEE");
        country.setCurrencySymbol("S87dIVb56ZX6L75V9yTkWQe1xLHQkPnT");
        country.setCapitalLatitude(7);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateDescription("pyLsRmtomHcA1PycY7GI0f5pCPzVP3Xht8ui3BbzxYQWjMJVpC");
        state.setStateCapitalLatitude(2);
        state.setStateFlag("CRjQPVitjgucTqQ0bWp7NnD7LfERCZ2EHx53gmLIilNfzP04lY");
        state.setStateCapitalLongitude(3);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCapital("ChFSfsNBM7bhNh4ayXwH2I13lrJgaa0MZIQDOeu0HgfspOvS9h");
        state.setStateCodeChar2("JNkqSV46JNLvZF2HQTLOUkRAJQ7daLXs");
        state.setStateName("0faIqhRuuwNpZ5MSkZkiwIh5mslFDnWUmvh3JLrjoTy0xgQlgk");
        state.setStateCode(2);
        state.setStateCodeChar3("5Ve2hNGl9iKY9ewqMHeryDBiubDElP8Y");
        state.setEntityValidator(entityValidator);
        return state;
    }

    @Test
    public void test1Save() {
        try {
            State state = createState(true);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateDescription("PgfOSun05T1EBogk3PDqYy7P9LFNAaDCvxQYuUFwbjdfLrAVVp");
            state.setStateCapitalLatitude(2);
            state.setStateFlag("TuUyTYpqPfwXajFDHM1qxFOd4xV1o84awtLsG4K7Xgz7HraqvI");
            state.setStateCapitalLongitude(3);
            state.setStateCapital("MaU3gCDE9eZxF3oKiIkF6NRHeDUiilQECUicm5t8Uco64kzKRi");
            state.setStateCodeChar2("9uwpIhZ0DE1MCmmmOyoLQ1LOlhyEem5c");
            state.setStateName("kvMiAcBA3FH9nKZWAkMK5f94IZLqXpg2xoZb8DAWPeLD3E6BSL");
            state.setVersionId(1);
            state.setStateCode(1);
            state.setStateCodeChar3("B1h95v8AnnYlTPWUBetEP8xyhQqCGFNb");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateState(EntityTestCriteria contraints, State state) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            state.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            state.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            state.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            stateRepository.save(state);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "stateName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "jrqvDpzc04x483i6jW9mIi1zwijm32Lw50CvZKJa2VH9wO0HvejYJmaw4izcdYXUWvm8sXXIXrJv8QAubd9Oj97cndDG9LMFAZpFFgsTPyMBldCwby6FD368RXffUrW6nn3YFVGLCo84K0nUBdH0mQBYBsX55PDRLIKwuGJqw59os3JfDJLG9E6AVKxaWdnCw3dKZX8Ov5gwC8PATDzoXZYoOqaHEplEGzlzMoCFhN6rJPGR7i3cR0KVY9R7sjH9X"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 3));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "KuMxlFICtAbusWOLZ3AzsaJ5Xv0BpRRz7"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "DxDDpV1m81C4RthjpDTBcglmBt1Sl5qFN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "UC0JleRKEulHr544EY4VfPTq54UJRrBi0sMZC4PLYYPZ1TXGuxuIqnovTxVVp3Ypm8FXEKpRaXefAdBsgfT3FmLxybj84agQfpD8uK35jvK9QClN0A2cdFOiuTOugNOfOqJgyfUEx5vhZushj7c1ugInng13bs34PEFfCgD23j0ljICkbX3ZAzhlayucwkGPPVvJUVmI4olFzNs5Fn3zSqCap1hnNlucvf18QUEs89uoDl1liXWnQBAE8A6quObWz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "5uWBPjfafxeFtYMKWMncSIa9OV70jgK8DyAA8moXF2lkqy3Csq3ipglfIDq76GQjlig791jXYg2iojB1cUgJ2BURi8bXrKiAghwaYWazBVxlT8MGfARaV1tSZApmCb0ZC"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "6VBeYEGrfawB8UDzGwu5moAXFIJ1PEZAAH8I5otvKU1ggKvAVSpVeqadzwYQRsM8BSYqmgP2g6ocfd59FvCFtEvtoATlMluuOIodHJ0xIisBv3zYFvommatgmWRKjRLXb"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 22));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = state.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 2:
                        state.setStateName(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 3:
                        state.setStateCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 5:
                        state.setStateCodeChar2(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 6:
                        state.setStateCodeChar3(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 7:
                        state.setStateDescription(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 8:
                        state.setStateFlag(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 9:
                        state.setStateCapital(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 10:
                        state.setStateCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 11:
                        state.setStateCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
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
