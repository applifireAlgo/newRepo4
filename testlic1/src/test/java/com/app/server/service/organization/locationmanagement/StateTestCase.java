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

    private State createState(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCurrencyCode("uXe");
        country.setCountryName("dV0hPOryGXy6TJt3RNDddzuBNYFkytgAdrNtNAX0YsZzbSzdLY");
        country.setCapitalLongitude(7);
        country.setCountryCode1("3nd");
        country.setCountryCode2("7lC");
        country.setCountryFlag("1tkUtotx0Iac72c2CV6paUzD3biX3V4KGjw4L1M2cOa364VdCE");
        country.setCapital("K1Jp6OhQNaTaFDDS5txh1F12AqRUVW9b");
        country.setCapitalLatitude(6);
        country.setCurrencyName("64PQZ6OUXzc3lbxHEChGZ4HbgzEYodnXktDT1b2ZXO9Qe3aRIk");
        country.setIsoNumeric(883);
        country.setCurrencySymbol("hez0ne2auF1jrIBYOwX48I54X8JZYTrU");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCode(1);
        state.setStateFlag("sUwWhUuzHY9tpRNmsTukXfIv021d7oywT3oShbHdjnYHjwi61r");
        state.setStateName("HjqrZFu6AZU3jGKASY0cy2Ch2ONX90fRyx510UHdPm8fN6xs3b");
        state.setStateCapital("XuI5GG1IqiL3bg75feSlHAtMte4rz9iHr7CXZobZrn31X6qBsm");
        state.setStateCapitalLongitude(7);
        state.setStateCodeChar3("ldkaOBmbzME54h4jxLZQ7zNHMh8RqPxk");
        state.setStateDescription("8Hch1XB19EAwyEn1HmwaRG6doplK0hjCiosPr2ETgALtBwyQD4");
        state.setStateCapitalLatitude(1);
        state.setStateCodeChar2("PWhCNaEI6kOk03n3Kmz6aTdM4pigd4uS");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
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
            state.setVersionId(1);
            state.setStateCode(2);
            state.setStateFlag("2LbRBMNT5fAX1H9TGNI9GZPS1JuXpOyqn7OFYG8YGUZiDV1FOc");
            state.setStateName("H8jp9KEBduEknbzRANjej11CzKJfMeOIM4qlINv15mRgIkjmXe");
            state.setStateCapital("Udqa1AizisiUBhIRFXTilh7fTpdnMSMdJQAFkerlYMnHR6Rlzu");
            state.setStateCapitalLongitude(2);
            state.setStateCodeChar3("Xjj0hisEeqbTX1iia2xUmXsGeAJe5xb3");
            state.setStateDescription("YJkJndv2FWylJnKs6dW2P9TjoekubHpLiFB9m2oJVJzV6iYSDn");
            state.setStateCapitalLatitude(2);
            state.setStateCodeChar2("KSp5FI7AnOHPjf2cGFus5gr7hxiLlhgS");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (java.lang.Exception e) {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "mK42o44qOAurt2r4G1WZkoHk66EeGs12pobiMXq3ZT3YPGyd56KTby5zj2x9n0W2qpVdXEF2bC4ksKt8I06YSXvdC5PQgMg1A72U7grHvanNzUQzNnjnZ5Rn6gAJfAG3E42zEYH59c2GaSY0l3fYcxDTNwpdLHm9fJncQxg5Daq1e2YF6kdlHG26Wzo810lQegOkjqKPMdC3ElOw5PgFM9klE46UhmEFPE4fxpYEnHseUMabUImS5bQ2QHHI8Cx7z"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 3));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "sd1InS1DoYmzoz4uhTiQnxYEBxoskAG8Q"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "t6H3HgGv8XXUKnqSzsSezQA6rNl1mOXmR"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "dgVKydwDhWtY0DNvyTqP189J1FM8wwZF88xrU4d0bIGpBMxs4URA3ir2k2IOLmFZJZWCw8GB5FvfSJ8kZUrMWRuhTfQL0pWobCes7zL861ZF9kG9bb1BEEAoIYdhM4ydcPgC4eqQ8KFKOMvUYcFeScmtHeHCRlJsKc5cuMjMR062lJBzyGaCaMoWuufyQjh3eJcn5cF4oP3FBlqOsHDbAxoWx2zP7nkJkQlxq9SGVJAHe9ZkWDd95JuirJ1txOdFC"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "9LXaQUyY8oQETcsaGBT8HmIjfLiTTi3TcCwLSzf3UmS8e9oZysWMYEQca0kZYPHJD6AosJQHF1mfY7qnLc4BLqQnapXlfXaWu3ApJ7bMpCHbLtrfNMmAOnVnH3wTJyOlt"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "MiLBPGqxDJJCFtP8lLYs3uvE3NLQfxSUF2qY7S8fLuClKDFSGRNJkTM9wbfcw83PK6EtD3S6HO3iulbyodMokkS3BrB4Rj36eQ5A9No1uFfuRdPgXDi2VQBlaj5Y0UaOQ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 21));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 18));
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
