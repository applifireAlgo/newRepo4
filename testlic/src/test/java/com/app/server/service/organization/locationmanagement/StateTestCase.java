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
        country.setCapital("4SexSIglBkdnZdyMHrws4Lwc0Y16Qh1a");
        country.setCountryName("DwUz3hcEIFhqDHe62ZU5xTmeHKVPW3aAebOkK5rrdBaJcpFA6L");
        country.setCountryCode2("koH");
        country.setCapitalLongitude(11);
        country.setCountryCode1("zyE");
        country.setCurrencySymbol("2wgE8tP1Fq5kWv7OPdiuhDcrTkt9yF8R");
        country.setCapitalLatitude(6);
        country.setCountryFlag("FdQuvt6NwglolUSCyI6imlAPjQ1d9eNRz5bvt7N6IfvVzshhYT");
        country.setIsoNumeric(905);
        country.setCurrencyName("lOIUDunIlTT8HA6a6qI2nnvQp3HeNNX57OIYXZkFsaTeiuO6jG");
        country.setCurrencyCode("rGr");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCapitalLatitude(3);
        state.setStateFlag("SolTf3sQZ2IsLzcYCoKiHDBiOSbDNzFhv3dbcPkW9z70W7gPD4");
        state.setStateCapital("AkajoPLIy9iDdXjcglLoTGrNb5FYc39L3cbk3eSJZFK5mQtdWn");
        state.setStateCodeChar3("O4x0OB6zfMIuGBGmtPRq5AT37cs2CrcA");
        state.setStateName("XalVMD2p9JDasZu8Y4KuC3ngip8azEujZ4c7x1e1RuuKor6Uyv");
        state.setStateCodeChar2("zf9s8DYfYgtpuYGULuQNa22gvROdhE3J");
        state.setStateCode(2);
        state.setStateDescription("znnb7dPWyY7FzlK9ZFDrBrbGCPucPNiJaK2wmOw1cB0gam5VKY");
        state.setStateCapitalLongitude(7);
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
            state.setStateCapitalLatitude(5);
            state.setStateFlag("yHUKTJXwHYFEMydTCpMK4ccWs4rZIox8NtJEGi0s52S9sOP2YI");
            state.setStateCapital("gMHgRv3bQ8odeQbZtCYLmsQU54MwC9aH7LQsHefG62Ux9TYtJM");
            state.setStateCodeChar3("Upj9WuR1hMQiqo0voHwE44DMYRW84y2q");
            state.setStateName("qiNfKyaYgFc432dYeC6V5wbIJGlWcHnvsqwawiv7tHJKxa3Inl");
            state.setStateCodeChar2("v1RTEemoRXyOh66GDJAeBBJnF6c0xn1B");
            state.setStateCode(1);
            state.setVersionId(1);
            state.setStateDescription("y1VRdo7CIPYKltik8aXV3Uf6rbHDWZAUjU3wqC1i04bEjQYSk5");
            state.setStateCapitalLongitude(3);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "bDw3PJrPWFTb3LyA7SEyPxd03YysKLsJ4nV7MlIeR88lhFDb7WgfTkN5ID1W2kfvXPI4JpeTgfUuTTkU0CpxK03nRhFkMeAHY12BwcCFcgHpAtk3jLd5zPnXi0dp267VBc8Jozh8T2Heq8IMXdzazaTRNSJIeTvenuzYu9H2b5QuLrq3wJZ4KmPtZR0R4iYRSO8knzWAf5Eu8P7q4ZhWgUjqcrvIKRqISHNsfql6jgw0CFSH3xl7bh82estQM5TbV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "N5Jwgs2huEok8JejJRzaKITGqvovwYV86"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "tHgKsvWZFrduHpBVCG5rK3otv0fBvscSy"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "okc7gIjUWj7HMo14HWiJkeloj2gtk4pTzOnVHrN1z91Zb2BYu8JsYe0vQZ0f2G9nhyrCsytNGCiLur9VyA0cyPcdVx9UdZkmkxpFkXGs28df0pni0P8Vg1wJcaMDvUIvT0XdZEkc0yjpLe9s2I8KGqAlGhjcOHtHbQzeBbJ3VvhijffbTPVLHztag5tKwQwcii6AhjSr3hOGnmNoNYbOjQSJ2PZFA56H1KKfSR3fGdJNq5b2hAxYE5BLx2AlXCPwQ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "bTv2oP77og3g9SAc6xV9ZVbGe7P5o8QH9ZPriJm1o69LoG1QBgo9g5HvBPFQ0rVGxejSCJ1OE09HzWh1uIQgkTuaQpm7sLJpKrB1z7DUVrfPgpD4nQyCg5kyLDbRPk3CQ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "OrN3BlBtr3MtBKqxCFqmfRywoTQENPKUdfj6DDtlcPe4fbpVOLHS19eHMHC4sumrPoWB3cUg36FPEPm3pBnSBetzCDvVBGYixOqBTZ34iVuNeSWsSlU7v3zHL2eJWcuLW"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 17));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 15));
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
