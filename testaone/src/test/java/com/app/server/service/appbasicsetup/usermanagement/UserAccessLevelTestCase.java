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
        useraccesslevel.setLevelDescription("Zy3QX9CfklambmOIte3GK0IufBeaC22ok7h0SEqQLWWXO7XALO");
        useraccesslevel.setLevelName("0YwtuKuvjSlvhbVwCOJk4ZBff7OqSIejJ6O5m0tku8sEfeCtlh");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("AL5RRaiB7dpiDJVWkUFcP2wnjofFUFhmANp06PNEEhpaQqQnfJ");
        useraccesslevel.setLevelHelp("XakMeJDCA2yB7SnXeG649Rd22MaODhzOc6avApOprwVq52jd4V");
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
            useraccesslevel.setLevelDescription("Kkd3CAoEjAJrufGUihL5CMXYiXcvyDj93M1pr1kF78Yj07sAmn");
            useraccesslevel.setLevelName("YESqfcTmtWGicaKGCATvcIipBef6Ao3CTEDGYJfZk63NyYi2T6");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setUserAccessLevel(86751);
            useraccesslevel.setLevelIcon("gxM9GCQnBtoejA9czOWIVcQIZK8TCbKxpSY7E1Q1NpxSnhXFZL");
            useraccesslevel.setLevelHelp("RDaazDdjaB1EC8vn2omZyi9Mbq2khC3TylDKWINN83744PHLlf");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 145130));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "5EocBy0LociamkpefLOvfd8yIJ8Ckc0Ws2KKj1jdynZU4XNuWzyVnPz8uFRc2oraWn8BVCubJGK1UDi7z6VePRyQWdKP6Gq32xshmE1lYJGU3eUuTClc68Woq29QaU1puewASv58URmKFguTy9LawIbEniNQi8CkbvV9LT2eo1oeKsXLcVzon1PIo2R8CPSAwNTjhRoEJ7vDxee6IDgGjikzAiiWtRrtK4S7KdbBJxWzA6YYG5ZvqEGjgmAidEjXg"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "YzjehUxncAQD7SarSk0ZvyVPwOjySlGEVtYwkius5B98wfUGliaC7nZho78yrls9BKCcny0UuQG9XMJDOwElDPzLiBLtNSDooNCowYPqGGAQuyNzA5zWT6vgLnwu7i68VTucLPTy9r6JM3m4N1KRLqfOedeuxtTOB1dATy24KU4LxdCOKjbJMRKosy85pVB84rOza7dpUAU0Tqi4EGMCdwYAperirGkfKE0JRsfepX7G1pud8yE64zc8H7Jk2DxY1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "3AvAZNVMvd30rx2qJKuAwNGwzZM3XNdti6ULcltDksS4OUNZAUwaHPXeacto9X23Z7QjVvefRiRC9e5X6bZVV01JFyRM1Afktn58skkVXAykfx8vLDQrp88KiVWvva4tBx2q63syPsDyZ9gcUXYjm2f5qPqRFu6O45Dm5VfumW2zdl98Pp6nK9D733iRz94ZtlMlaePaSXCt1nnCbpxDoy01umAfxmaiW87cprS1qvioXUyFni4ONSnBIofWRWS0q"));
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
