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
        country.setCountryFlag("3WZwl7nlvgRP29Y4fTG6YoVB2ZKfUMNqyWDsfSYVzQWANRe9N0");
        country.setCapitalLatitude(3);
        country.setCapital("IULY4NNc6fvPNylOcDdVuZ2uWUAOqq5i");
        country.setCurrencyName("jvvI1FGEa27mriCFC2GQtfRYBrA5TC5fOQiZxIRyq5uS6ozcYw");
        country.setCapitalLongitude(6);
        country.setIsoNumeric(905);
        country.setCountryCode2("pwh");
        country.setCountryName("H9FJimmBA74Jz9LdTWuWMPfFl9HUbHHA0wFpBYR7xKvasd2lzA");
        country.setCurrencyCode("0pw");
        country.setCurrencySymbol("kV17hoMcg0QO9e197hOAdYjuDh0hhEV3");
        country.setCountryCode1("OMm");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCapitalLongitude(11);
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateFlag("5ZWJXjEbiwVLYNvM4YCYjCx5Mdryn0Ua5CFrPWhYpn37YfhIWE");
        state.setStateCodeChar2("8AKrtGywQRyqn6m4ZWMBOzGq8oFxPzFH");
        state.setStateDescription("wZ41rmA6xqylOPvvhiJJrWvSoLlVYPUwKiDIDoicxDziNMtGub");
        state.setStateName("KpFYiVItoUXRLL5d9huN3keX5mX6r7eGrhpImjumMSmo9jlQkp");
        state.setStateCode(1);
        state.setStateCapital("xV0Oe8cmzBkL5qWINX0Gfl1Q6zm502i45lAIMkkbJmh5W1nH9X");
        state.setStateCodeChar3("dobVS0CIrX9Bpvmk5Wcgyg0MVo9ZMPSi");
        state.setStateCapitalLatitude(9);
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
            state.setStateCapitalLongitude(3);
            state.setStateFlag("Y4aEdAul47JtPuq2e1tAoPiTVbSsPrvYZFNyptue6UUAcbOAEb");
            state.setStateCodeChar2("wQnztK6cOwMIYC81jmmNrUswQMkkypY0");
            state.setStateDescription("27RdvATQyIcS46UB0GMXSVPHRWetbMfMKPDhyLCBSwxiXhukeS");
            state.setStateName("Sp93y9ufzHaV6bLQt46WGRGsk3uvTS6yY433i2wxlYN2yg3X04");
            state.setStateCode(1);
            state.setStateCapital("IQPCNHpkwhvk4QE9skkoPeRTN28DKXBBXfKXP9Cu9e7LXvUMZD");
            state.setStateCodeChar3("l7J4ZFM4XA6JuEw4DEDyOVtEYFl97anD");
            state.setStateCapitalLatitude(1);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "owbRwPHlaBdsAovGdC7bn6tIJCYaqQ82wNCYAmVKQah1WhOlPmj1OKQXOkfn9tENoMYUqAKhYDgVuh0wgzQni48YDZiHO8SNGcFs2U6JLqvhwiJyMYL7x9qNVesUTibihoHegxYnXeav9tOdZf0EXpLVVXO5WyBmbQT20IpBz1trIpcSM1V5izdHUKVROwjovJQumcToVN5F7mfaa6NqewCljBSV6DZSHrUhuYL9Yhc7kySY34ywRtN8R54tCak2I"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "gXic4T22hwahrpTlnY2nBzVJS33jPN0kv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "WY4LquWmkCfetxPCkvY028RpvHSn6dfM3"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "HcUpWtiZdaSeawRv9q9j8DFqApm2eYpkpI92Yi56GzFVffet8AxQkuP62ZynwBaCgBGabEbmdyplRwxMs0J0sKeJNcL1RmtCGvQTUajnJ2vQFm0rgNI2DuyDKQR0wfcUIxXzT9brIHPdfvWXz1Dco0OTrhtcGMHW3FsjrmECwNMW8qr3Gbdq3fivwP5j28RvUQkwzGm2OCTtxD1cPzuv9bsl1GOeCvM6HKTJ1qHeQu4vU5yJjLTs1VgArcRywpUHk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "WiyAdOsC1s1c5a2bqf3ec75TXjmEpBiXdJRFNbysVseymVBvAcL3r9GaXpw6Eicbpa9DvOBWED6tBhitm5gOtyL8KPu9L3xdM3NxD1WlQQZBfNxtuujppkW8U0a8c47Um"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "QUTo89kH4wvl7CPOBnh2p0nrljZGdJmlEkx2tKiXIosSJJK6ua9TW4xrpMXQw23BlRIiGa9bYUqRMZ4KrlO7FyiuTkQX0EvsQKnDYdPH90ohfoAl9q4tNeNJFMpP4DNxY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 20));
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
