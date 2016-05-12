package com.app.server.service.appbasicsetup.usermanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws Exception {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelDescription("vRbFCe7LWZNMfDI90RCmU0lMA4MnHVaP8V1kIo7Rx0zmFyNVtc");
        useraccesslevel.setLevelName("UN3z5FRpu5yRvKg9ytrXA9vcgXu1JRfSYNAnwbM15E9gmznohJ");
        useraccesslevel.setLevelIcon("e9gZcK0kPWs8oIrM2Gdmi3K4Ng361PuK5GWjTN287CUeAHoQbH");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("B1Hqwsb28dgwzzFNd4683aZzqLzQPAXwVyr75o0S0JiQDBbev3");
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setLevelDescription("1qcYo2I8DXQJ52aBuxybQUQMRm3yOI4kqtJKdYlPErdrjCbXQd");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelName("fY8sYAXcPYjoa1X0MTferrzldtAqgJnA2YXoM0CJ1CFMwDOaW6");
            useraccesslevel.setLevelIcon("zD2sQmVsmShmjAVW4lBeJ0uspUhbXT828j30MtMfRpkfsyYonD");
            useraccesslevel.setUserAccessLevel(47021);
            useraccesslevel.setLevelHelp("zGqeb2VRvVOcF8E9sphST4uPbdsRd6vyuwG8oUUbSwt71MVfQv");
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 196169));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "5mOgXu4rA2L74IPpJViEcKV7NEKwIXqNxlhySursfK14zlrWY6eucK3BAw4J3smGh7gCKXn613wqLyc8PvWA27u836cSyM6ccWiPIVSVxKca3iY12rVut76saU4QdEeV1YGsYiqxberUS5wmbDXEnxzRmI4oHfLXcK77MpsY06zpwP8wNuEQL98KxIeAAuKYZ6pJR2qtKvX4pkHrJ9GYNBWj87zDQqhVcVYnldQ2SdIJa7xrNqJ1cxbeGUlOwdymp"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "m7VoGsj2f1uXYuxJKjxhVb65jLtzY8eWRDSZfm7G87GAsTkQmROpIvRxmF9edt3pNFjM5wcsPIjQHPeP3eBRYcF6cle6OrjHz5pcAkdwdwDZPEhQKm5AJqX4njVmTLL3kLsxst0sEf2sXuZH1PGlbl3XNQDBF4HfFsDkPMjARc4q8EakRDpb03v3VgyaeKFa9XdlAk0UJWNYMSusloHvhx4UzDOid7jph8MxN6vQLCFKKVTd0ydnm2COwtqvtk3Qf"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "UYvTImGgotojZAVBX4HlysBwxWvCCLpzAL9XDoeSJfuAMJSRamxuTCSB96qodEw7Hgrv6CCM0PUHEZqc96eReiv22aUZYCaHUg5KvKRg1IkuborhOEljLrIZdIWlBawskmgByn8cR9BqjAhM6x2dTpeMU3OFkcK1nzuqmNK5rLnBsTqo4yK2CNX22z8CPbtqIWDtrXETFKMpy3etHsb9ulA28d5i3Xixc9x0PMEPeaz8wWyv9xd6R90dHEx9s4MbD"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
