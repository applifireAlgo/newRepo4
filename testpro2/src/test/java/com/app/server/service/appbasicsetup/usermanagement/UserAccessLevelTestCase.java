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
        useraccesslevel.setLevelName("vsf7SXMrOw9Zae2tuwySxbXR82ATftX2aCqA3JbVIlX6NhZoWp");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("8Gpt0So4enuH377ws4fdQN1Hi3E85pVPTknbcnYvAQ8toUqFXs");
        useraccesslevel.setLevelDescription("0M28qMI47tGylSei15hqLYP1oImiKRO2bRJIA2jGlGgL4grOhQ");
        useraccesslevel.setLevelIcon("vhNmvqCVcSkaQA3WVg4rVgRkxqfvgDLo0lHDwz9Nfk38LJKpz9");
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
            useraccesslevel.setLevelName("fn5JRLWzcfCNInDsJcMJEVkXOfdbn6uUsrKVMhaMei76WqTCKq");
            useraccesslevel.setUserAccessLevel(59632);
            useraccesslevel.setLevelHelp("vG7ydEwgkKioWpslRyjQAH1f4Kk3BnMDfWg2UHMbtNIimY6t8A");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelDescription("QKCerKxEhyYeMNW81UsxRnk47qXMbTkSfkUVzZMEhqmIPiAkIj");
            useraccesslevel.setLevelIcon("iBYnzR6EvZQuEdg2tN5wEwPglS82FSbwyCxarl7MOZyaBu1zNc");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 170889));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "rxKJ4mbsSAZKYg7wJ6Bey3lUZYgVQEPOCPArcIXdgYexpjJYsamWrWF9uxeiH0oU7eiCPtq0veZRWCh4nI5FQJK7j3KhxUMLFKRTvz1jkkoaayo5KGIZHEVzV8TKNmsFxZJI8U5fIFbHmUaYkIfZ6o51894AdJY1PRtJQU47UNBGwhZfkfQevRaersRHslO41ihXZKcJvbjChaAq7Rb0YeYh5HdJ9mZXqFJ6GcpaX8tlOXQlzXnPhoiDF0kPWyg7W"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "O84Yn4rCV9Pnd7IUFmFLZX80BE1ChYsvzaLrMEs5xyubb05fJVL4IHODayGr2OkYjwiukuEouWimXHUFq0hFIKB3cha7rTqdjx9J1umUX926gd3NlnzUI7bFB358uirjZp6p8igQ2gc9Y92GcLGoFFsSDoG6lEyJksAmpJNuDUdZS1rmUO63uJiVfxVRDzmoKmVZGAuVqxdmGzgvw3B8Nd8nsumLEU1WDatYR8UP0xI8KaDOEpJOX3quuL3GXO4zO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "onNAHOTgXKmd9wVcLJX73qZDPIZynKi41iuQX9R2GS2oHS7gIkDf3cznBxZOJeehRrwmhUc0BRQ3RDhT6Cbn8wLRAVUaHVo4vQZZAwoZo7uvN2vW7hkSoMebuyvQFzMrbbx5Dy6Io2wBCxLCbBiAGrGfyYwVmh8sn2awflgPp7lsyZEz8wwWQFCut06AtOR65tpJFy8UZYlP8JvdiQFRd3HrDU4vrpPiZvglBGAyFA3JBuwA4g4NJ8x6XNodYxWa7"));
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
