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
        country.setCapital("SaakT6qNfPk9gW9OBvYawrMDcIBYkeTg");
        country.setCurrencySymbol("M29ubVm1EtwqqUkwCz5XYdbGTFwR8GFl");
        country.setCapitalLongitude(1);
        country.setCurrencyName("NmuFsOf7X9ZItjwGIePvXevR2gwCsRfNPuZbXojIoSts480uya");
        country.setCapitalLatitude(1);
        country.setCountryFlag("cPCF1XgMjG7ckNvkQJtifLKQOQOX6N0IOx3A1lLLYa9NjLpBo4");
        country.setCountryCode2("Nyy");
        country.setCountryCode1("GR8");
        country.setCountryName("TLI1HtjfhG34lUAuMYXWqbyDXrgtiHCRnaN0okzfDZZLBSHj1R");
        country.setCurrencyCode("Vvr");
        country.setIsoNumeric(221);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCode(1);
        state.setStateDescription("1oSmDTknfRONNrzQNL5eqD16YgSlMXxOjnLo2QyzbnrYn8ZCcQ");
        state.setStateCodeChar3("QyxEh1B7Nn8twVuzU3EfQLMwhEcOEH3p");
        state.setStateName("RgGHLrXAMslPcMBD2atdhH8Ad4EYewKXXK9EUfWLA2ulBV8BvR");
        state.setStateFlag("6sugpAfmZidLfNZrzbPKAcm2BM4FQiGPPgFJvXx7q4MEiF6RdC");
        state.setStateCapitalLongitude(9);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCapitalLatitude(3);
        state.setStateCodeChar2("j2yCyyNRfQplMSoD5g4ArmZ3f8IswgU7");
        state.setStateCapital("Cd3w9ncen7njKEKMG2vlAMqIzcZ5gu3X9zrLm8WVRiPNgR2fmL");
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
            state.setStateCode(1);
            state.setStateDescription("YAWH2zKxUdjsFBpogw7LYqkYbeymAxXbKy4SuvVM4vvPUlmkeR");
            state.setStateCodeChar3("hzUcTxcxV7ChsOSEQI0hjJN2KkePq0R3");
            state.setStateName("pWXoRtzxUdSnwnu0YiWXewutZaHorOi1tJ6Iqu2Ss2AjcUXRur");
            state.setStateFlag("yfOdqayrxTG7QjG2GUKwcI9vQN46pRpjmAbwqr1Pb8K97jiWy7");
            state.setStateCapitalLongitude(11);
            state.setVersionId(1);
            state.setStateCapitalLatitude(3);
            state.setStateCodeChar2("58SoG7j2YRGqK6XetqhwPVzZCwVQM7GP");
            state.setStateCapital("ujjcw9d9H1D0GhXHHvPIB5nPohVdRT1PltMxDlWOvjFFrLaahG");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "9f2tBVMYVqGfbDyVI8sRlFeTGLEdMqvHoE9Ol2monUCsIjOCjvY675t6t9mTtrKuGsOSCLowhVnXZcD0IfepAh6VbAZwdjwyIrC4GdzKOTzhipNO2QeZL9daN5yOhmix4BaSF6AAeYHEACkyW9c5qZedmYynpLkmVl2Z1762U9AySnVbbPth1izannUy3BuIH4MrWohUHdVon19xPSrRlk9l2TCRRMGJEQL9bhpKuT3lIeVl3wQ0ep3KeGc4ji0gy"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 3));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "ErMmk8ynO2yZphNIamwPe99arYAa2HySX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "KtnOjcdInXNkpnDfQchCLcZXxk2mEr0TQ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "tOyH8gudTS9ndhlXgHFxrgQrnNOJTPCrL1S7EI4YWEvmryvCNulnh9z22PAQ40dr2Q59w0L9lxBjp3BBj8Z43JIVV8sbCGpiCMZPbJcnYlZp7qgl5mlbPHkvhWkaiHuM19EJ7dHUqt5eSdnjg69jC2HfY6KSHehtCNh6bdR74z2Ic8Kf9egYgPL55UVpFKCpnYQMZYglPZadOfGU7Atsbz02dUqgToPYUcg5CVwuOZN1Q3t15f8VCOxlpTgdaN4sE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "YxoEDfxC1mNCkNxyz7EHDqSLKUOYgsv10r19pJf8oCg1bXq5E18NPJM8NL5OEWj4qF4rL8ejc7ojdYW1oxe0JICh5V44RNJKiixOEFD8rxtxqFTdV6uM6K1dq3auMWxMa"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "srU3vx7tnxmtki2lvmX4g9IGZqwCz3MIPN9xDaLCBymXdVhMXKf4nmegxsmHDaqxmgrvvrAiFL5LNijDesKljTMGY0c0ElzjrGoblbzIIi9qHo0WyVoSMaDBwwQ8pRC4r"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 17));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 19));
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
