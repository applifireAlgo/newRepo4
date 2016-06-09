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
        useraccesslevel.setLevelIcon("p4mbAygcn6L64BT17VkKo7nC6oxWy2UnwCiRsSvGOYR2hqOVHT");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("fAtN0YEaFW9KmN36MMCwEokcsoLrKAWoNlMHFKvQKJ7fC3a26C");
        useraccesslevel.setLevelHelp("iqPtts6kfdv52dBzC1uggeH5BrnThf7TvvOi5r8Oukm15sp8R3");
        useraccesslevel.setLevelDescription("m5nkCtqdPNIUlPmQsWv9f8YvjJL63qKN75qYVORdTkNtsu5vGo");
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
            useraccesslevel.setLevelIcon("BFrGMRTOQrv6lQsTTDXn7cXGc8z0JPpHl9gEBinZT158y3onC0");
            useraccesslevel.setUserAccessLevel(80063);
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelName("ezM3UY1TqzzzVMEN4EOm6vTHY9PtsEE4dSvBT1BLh2gNPWTYXo");
            useraccesslevel.setLevelHelp("CEfkkATn9ygJguQ2xdN6K7YfRVaGyrUGJD02V0azKehVSoZHwt");
            useraccesslevel.setLevelDescription("L4qJmjr46k8mJPcSps1BLpFnCoj0c2l3hg7PN2hEQDPZwdCbhE");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 197813));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "Qi4EH9XI8tHkM9ezRqZZzK9zKN4LLigwlzVvdG9UThhHWWn49txIsR7FBs9Fyq2SVadKvV9v1aQwh0KAJYRtZJpPxR0SzoZB4edaOFLDXvRRXClI5NMeV36MjDpE1AMx06FODcAinAsyNWbdzM6JPxI5FLMa4GE2LOROJSfNhht6pBWMkalcLQUR79vfkU0B9E5w5ImBLPBz20U0wAX1AjR34j8fGiCJfnHK6zK35Pc4ARJZYsOgR6WYrF8qmw35j"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "qiGFWa5m8YPR16snsfT3XBlMlQszr4MxO8j0lNOMrBQYCIrINb6NxYJ2cgVtuBRJIXKKEl69HoBTngBUQ4Pl1lPuadDPD1t4NK3QGRDX3pApSaW9NAp0R1ckOKSiy5jMPb3IGSShwoYQ1NFCYxshwc1Z6EyKariCeAK1cmvXnOxZsE1rp3t5NoXjijLSQs8xSIP5OK0Qp3oTqvZw9TqLyGNBtdyfProW5FY0tZgV0h7KgtIL7D6RXnfEjssetiWSl"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "NcgWJU9rw7DcXAna1QpqcM6Krntb2jLZKQ9yyn66pXsCKDLRHiDb5JlM8EcF7mxzozhpXX9yi151vPzQj9N9prtzfl0qLV5TlWQVu2xYpa7qU4AihNUBSQgpAzF6Qm0KJoVHZOrWZi4XFyxPc6RPLGAEZrot9mJSm2find1oUEzdfWIMC3gGOr6GAuf1fRntMjOWKfTMsWFF5HsUNUpPYBTOVHSJRqDK1GxEYgqjxwMxEVdfaMTH0aXsuLtTKSNBz"));
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
