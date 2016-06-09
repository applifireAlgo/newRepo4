package com.app.server.service.appbasicsetup.userrolemanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;
import com.app.shared.appbasicsetup.userrolemanagement.AppMenus;
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
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus(Boolean isSave) throws Exception {
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuHead(true);
        appmenus.setMenuDisplay(true);
        appmenus.setUiType("9nO");
        appmenus.setMenuAccessRights(8);
        appmenus.setMenuLabel("i6GNyvwzwh3WzxxQOTU24oWVMJBJGgsYXyzrMjP2kkfidDKwVe");
        appmenus.setMenuAction("K3Dp6R3ksoNYbu2Y6j0DlKzwecEh3vFPq31HO6GR2LBweikg3U");
        appmenus.setAutoSave(true);
        appmenus.setAppType(2);
        appmenus.setMenuCommands("aaSoCFUl0YSzuMLOaSS0kJF8DAofhj9kCHo56E2NTK94r0rMSj");
        appmenus.setMenuTreeId("gu3YHLfjM4loMIgDymZXqMwVpxI0qwzlyxAwJaA8CPD1oMaqJF");
        appmenus.setRefObjectId("6e5tZELzAYuSYdJvefLiy4XsI9sE29ctRhSylbJv2v6QYEohID");
        appmenus.setAppId("9KkUm3740rBljstuldp2grv0Xl7EAETpiZAkdomvsVZNI5KQu1");
        appmenus.setMenuIcon("F1r4oFJVo2RBqf9n2ltbQEWmBKY3Dx340zwHS7goDtTKsl6PyI");
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setUiType("QOu");
            appmenus.setMenuAccessRights(7);
            appmenus.setMenuLabel("qgiFAMiED94f0JQyXpQ8YLlolVMrJS8BksuimS92qX8M1XOKVf");
            appmenus.setMenuAction("agGbZ1HyEqDLkNqHom9iTTil2p9PokbK3jJgUO9ah3Mr8aOrUb");
            appmenus.setVersionId(1);
            appmenus.setAppType(1);
            appmenus.setMenuCommands("yiJqknK2dblH9g32mr4kF6eeNEdBZMrZiMdsO8mrX771dP0V8W");
            appmenus.setMenuTreeId("XH8sm1qR38YnrRRkAeGcreYY9YCO8caqb4Wka4fHThpW60W9D7");
            appmenus.setRefObjectId("YxrdA70zMK9PdzkpN51armA25x9uW6saso0F3XcQltZ2NfAYcc");
            appmenus.setAppId("ik4MwJFkWpQlkAUyn3uYLiv7Jrlzd4zLauH7grzxJWpSEayruH");
            appmenus.setMenuIcon("ISywHzaqos7B7UpLeJZQWARoV40Nn558HCXxNpMhntcFi1z3Mi");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "0euvWB36FNeLR8oDQqsT9L7GMPQpl1ItkAU3OvZR8PCZySuYXM3AB0UdFIND5D4tLxzLRWtXtdD8OecvQ26nyjf2BNGn863Wx4i2IJXc9gOZC3rUZnlCLUQ941h98oC2XNDZLAHHzeb5w16goor7heBKYbdSp1Ka8VJVsrQlJuKr0GZ7h2IPm5kgQwCK6L4z1BWMoBo4YoDwJsdSCsgPygxrlXcDIU44ROqYFsSb90Oxb7fc0dV3fY5sh5W8KqDdO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "HjiHBdI9n1TidyFcA9rJJQo5qIMbt1wBTjlxAFvVAPDViLek59ghZbZfFulQFeelUF9N79QlgmtWGMXTFXUl4tC0YkPw4aQ0SjWz6hPzCIaXzopv4Krd7VPDKs7PSvoitHrorV4cNhNizWqXhvI8ve0HZQtRBm4QjZWC6WgL8P5kj9b0IzOorg7B4GI3Ct5EbDRLft2bZ7BZR0hT0D5BuAChcp3AnDGK6CR7QWJa8r6tq9AuCzPMwfTloR8ULTSEb"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "Gh71MhZOdZZ8xrMPkIH5jVk7OTEYqv8qt1e50cvYJRjkjqQEq785fPVun03ZhXw3Rl5ihfEvLJdwuVgIvJIfBWhcR6aYQXy7qCG18BBFkxAHJTV6IQVp6CNwarX24uqkWWxCmYvXWIU2r9QfFYfMqLtBjLMcUHwRscYe30RDnIzTcODSr4p074WSkeLa3IkhgA0HyI5bFRQ0pSRsPff645FIzUD8gX2WWSiUmjoU6uP3jLbuXxPcn5SuBtMuv818s"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "zdmsHZYZn8CGJ5fpy2sXvBtmgSi1ezUGGZBf1aDwLThMi6u4cugw3NlNNgCxeGlzd"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "adBGT0pv5OAI9PIwtw4IQdbWQokrTy5IYgxUbyIh0v8GvLB3fmf20vxSetXg54oMvQ7t0Q7jeYtMyd7LjCq9fKIZTe6VYoC1OjfYoJsRa4gbp48qRGBmNSs9VjuAFDRk3jlAtZ6269wkpg4JpmRyeyaWkNgTPt5lSUblDrZPoMOZGmaIOKRYARSsjCnhpo5Ou6qdcjBwNFC3Xywni4aONY6DYXm3G7nisiqNr6I3vlhCTFm6DpWApA0F3mjQyAj9Y"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "9Y4P"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "reEIO4kSyOBGlkWuWHJok5kfoMEZf9rK0e2jKjX7cgAnbxSaVV6W971gjTSup3I3yIowHZlTqfLSFOSi8tfpZibkGkFmp3BCNKsNUw8u2hYk4Kf8gavvuzCktqzrziOAxGqX3YPRE2d1O4nIQVjJkHY7bh8XSnryxQ7w56JpbUmPwHHr1tJP5gAHlPROIxyie2i4WZawB5TkHzmoBaCVhLGjm7PkgdaFN7Po4bMBO1V9DfCLHLqIW1XBTjeKM4tgl"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 12));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "haoqY5xTTseOwGLBO9q2H68vYMFYYqwTcBa225D0rEjYq0ry7EFrUNtVX1vsiA6kerSL0KB6tWj9CKyqLzaZyDmwtAEg97y1LJ7LjVuzwH6faOV2QbdV0fddz6wS7tIBC73iRHL1NpZKosWsr7sdDBuJZttmVr9XNFmL22uxCIGHhEFox09uafdbUNyFxwIyoQlK3Yo9YShFEf7VyVvG0aM9eHNnuJEM586qIbpXfWcuLOF6AJjAO2jUTUuBGEaSH"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
