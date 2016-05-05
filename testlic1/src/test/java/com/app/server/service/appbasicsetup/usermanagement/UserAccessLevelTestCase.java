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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws Exception {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("2kdY7VHrp8yD4Tge9OGpErOpR4sEPRrV5erd8RWCFyKJzmRUNv");
        useraccesslevel.setLevelHelp("0EAnzALEpqgfBX5cLNe5JJvflggYVX1PELOUalGOUAqBvhuhOB");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("FGSQvpEo47UodxYxypMAkYBqbV9gxFjVQxvej52A2KO5K9lLWL");
        useraccesslevel.setLevelDescription("Wr7c4GOatzkui70wGLV4SFwhmlvgQXgtJEofEfJBXmApmamu9c");
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
            useraccesslevel.setLevelName("i8Hi7dGkOOxn0MilJrHMIXQDpucdXZbqdwMhcAhgbndGOBVyCx");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelHelp("2KGlw7hQrST4Fb1WgEbha4GvK28rZJ4MyR0fLfJHMTgV99AVP0");
            useraccesslevel.setUserAccessLevel(32777);
            useraccesslevel.setLevelIcon("jQIBDI4UpasYJErvYHNfJ5sTPhqakd8yppcXzsaf5Q8phiwJTy");
            useraccesslevel.setLevelDescription("k7tiTXAB1ZHTGLuXaGUdDZ4s9I0Faikv1lPMYIZEAm8VbluaFz");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 152386));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "GF7r9zOybZAiQLgIjf0kENsgBJKYZyXgWWwZVojHT6dJzER4urSnAhUAS3g11Ho28gOoCJKHr2CgCho8ZDd1SfwhmPKFn5uhBhgeljRD7do28gvtdJbKB82uhRTY7HRxBHfcZVgEyHj4RhP6wwLkr9L4dvakntwjg3p7NKsiDwkgYRySgcuA1Xuxwtkue5FWj54N30ifi6gIUmWg5TFICFxLRSnjBsOmn2LXAXmh9JQPdSLmGOTJOzPBYg6rnN9RL"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "PsD1eLBT6FagCdIYtfwY68EN6yXhRoeoGaAIwkwXVpx0f7TYZHJfiQU5AoAjQmlrWsA88N6ZxJ41WBMURGu7ss12wnGKLDa1KYXGBHHHyA7qev3GPFaD0STlRVTJUfiEuJbxXIMBv9W8ElcurviITGDEXtoWDkEM0AWTotMfe1HGHpNfZLw4eOy9xGopxee0GiW6Flt1VK5UhDhPRLl6aAGXkfHVoooWYyLj9dXFkxZLxrHod0A3Qt99W7mAEWPh4"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "j0WxJl45KG1TLChzM5jJH3Vz74pmWl9xlwK2vRlyR9gmhfJbjvy8JgaaCP8qdMNw5H3ulMQfdB96ailXxkm4OJa2Uk9SSxDwudjf2MLMT7JFQQ47hVInyKvGAsTUYuw8kRYpXEcuxDeEjHLs1qj9fFblvWnjZpvenSNSap37wAHrXTyPxSsTkN67tAsfNqi1WSmcJhII9HBsIvYZIW0tigT9lNgCxD6EgyTkTEjKowLHuhTZ1eqB30homg4Qzzzsb"));
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
