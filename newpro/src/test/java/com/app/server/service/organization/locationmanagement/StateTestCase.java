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
        country.setIsoNumeric(469);
        country.setCapital("apRBiP2a0jZef0ydmd1xs51b0km8arEB");
        country.setCapitalLongitude(9);
        country.setCountryCode1("MAx");
        country.setCountryName("VYFhgwfBbzzl1CcS4x4ZR6uD8GvlwU3iCDggVQxwewHt4shsfF");
        country.setCountryCode2("4DE");
        country.setCurrencySymbol("bjjRbFzPWt4uh2wyhE2qksisMg71wsiC");
        country.setCountryFlag("fkebsADbLAxiz8seBo7rt3JxHOQS10GynCweQSJNVsy1gF5EzJ");
        country.setCurrencyCode("lhB");
        country.setCapitalLatitude(7);
        country.setCurrencyName("0PO1avrI2egRr6HZJkurtvT3DEsqlfB0206SwOIKEJ4pPiEANT");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCapitalLatitude(3);
        state.setStateCodeChar2("wEtMXnAAS3Zqz1L7K9fuFZyGuWBlQp5C");
        state.setStateFlag("nNXJGGlniC11BAshxJWRyhfccCY01LpgM4VUJsTJJESamQnWTG");
        state.setStateDescription("PfaeVMfbgJRuY07Cy0lGhBJ3g6o7E1IxLI7Y9PjBzWVcF4i5wz");
        state.setStateCapital("xXgGWKRpEkW14w3wCtDhItBf6Eor39r94zk5yO5WryAgmKWnDL");
        state.setStateName("J8MKbpnbuxzr0inkScgDJEKzhVw3XDjGtFwEzwlnyEQlpngwBC");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCapitalLongitude(1);
        state.setStateCodeChar3("y1swljBP49EAbNS1CECmr1sQdqbwOYw0");
        state.setStateCode(2);
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
            state.setStateCapitalLatitude(2);
            state.setStateCodeChar2("bJQqMWbGvQr3qKmVuPBE0ng53o1Tk9mI");
            state.setStateFlag("BTjlepncCsNY9GW2DNLFkd7yz6mZK12CqeJZWZjRr515UCpV2H");
            state.setStateDescription("rWZX8gL3ieudIWjZRFQJNb4CE2XN2DShVeEnxDXgVpiXBTzcYx");
            state.setStateCapital("8yR60GOyIaOU9bfQ048FKQK4qa843DOJdqMdsfJ9Xjr72vcR3r");
            state.setStateName("ZcqjPDkzTaYE5KBIvxv06nQRnp5HrtDukH903aSIdDLV1EvVAv");
            state.setStateCapitalLongitude(5);
            state.setStateCodeChar3("dwfjJfnSJAGWq3Vva7rom61jUTVPt0nH");
            state.setStateCode(2);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "jlKfeSat1MpaBzDlI80lIWd9y0SzzIq8ZTFx1Rk3Czx9bSt7y5tvJhZhhGoRlHp7UtDkLulT9dOMXSty7Sz1YaKf7Zj5LiOKyQvs3UzuAymyGhFdT0ojzAZNtgoPRQGqIId7d0IcYlcuC2dAfLQvD4GHbtzS6kdAt2My8XgZrCDCRX3shZZ2101BNRQoeN240Ce3qEgQ8XjiL5BosmjidHfNAp2lksOPM5fw5VwWUEKKftG0vsuhsgB5XUEGANpWk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "FgVAz1KyJP7dOwtlwoAEetnhV8jihcPvX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "UvRoiBIB0ka2IiC6Exto4nBAioLBcRKyZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "sbeDT3rFoeq5YBkmaTaPbs63ylU77AaRmk3Hy4HkleC3jJOQ4kXOvR967jHB68R1y6jVbsMVPambrd0xDCMR1EZRvi2DKf0bsXjhZKBM2uyO2ihvHZ4hreAyA0QCb1rPK7B5jde5MM44zH9If3SjmzjG1ZyyxHRMnAKmSJM8w0lZuiF85ekraeWv13LNpl2bd6J7aWulDYt4dRKdrAzgblifDiyOnGEQUWa8sWkAPkTNV0z9XJ0fmNAPxOwwzWRNV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "YcvtJ6hsCWVR5NjyJWKyyHygVb1QMWLg3JRrQS52QT9UJab6zodBTqylvQEtY2cPDxbD6I4HCTf1jJ9nz8N4mz5o0CkNGJsY4mGOOJkAsy0ESAkKcHNKSXhNbvfnV3A8R"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "yUoZnGRSfk1a5QNxUPCI2tGzssX70tUQEZGqkTeOBefYrvIIasHpGmjqJ3cO2nzsuKn7krS5LlRkQog6WR5qeAjHDQqqEaD8p8fpwMTBQHERJAx8480gwZpm4n4HOHlSO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 13));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 20));
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
