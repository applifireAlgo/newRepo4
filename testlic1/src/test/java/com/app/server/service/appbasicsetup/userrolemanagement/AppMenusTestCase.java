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

    private AppMenus createAppMenus(Boolean isSave) throws Exception {
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuAction("DK3TqYMrLwGRx6vS0CWpNFUqwk3PrYI6BcezYDDbDDPg3yYPy8");
        appmenus.setAppType(2);
        appmenus.setMenuHead(true);
        appmenus.setAppId("hbCMW37lf2YQrUclev9DVvELWYc4biaP4P0zb7iRCyHF9DHDYR");
        appmenus.setMenuTreeId("4m6E6qwFuFeEjbAjSC1U0KYFuDZ0iewIrbSd55s27eVXZKijDw");
        appmenus.setMenuCommands("CgnvyiSGStPq5t74zWz8ntVZrZ0UqK0pwQg7ZoK787OPKxF0hr");
        appmenus.setAutoSave(true);
        appmenus.setRefObjectId("QXqgpYq3j1rjbjyrRkGdQkkqHrem96Pr9aa1HeqXUxzSwTSRMK");
        appmenus.setMenuIcon("2eVbY01UM8cz5eTPfwjMzGNzbAJPrZELeN498093hMlGjp862x");
        appmenus.setMenuLabel("mJnik9lIbiWPLDnu4EHUEQeTvoZfi505lylnIEASi4oBbUld8p");
        appmenus.setUiType("ptP");
        appmenus.setMenuAccessRights(3);
        appmenus.setMenuDisplay(true);
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
            appmenus.setMenuAction("mXEsCZivkbFn5121Gvmwzyc8mNMcRpLlh7JNOG8NR8SleqwFXG");
            appmenus.setVersionId(1);
            appmenus.setAppType(2);
            appmenus.setAppId("jUuWy46S1K3o6xF5e1bGZ5S1k5I9tz0809l988fhX3acCmbLQS");
            appmenus.setMenuTreeId("FdcVjKlhsJtPvA7q2VWDNrHg7z9Q7octN53N9McsJNfx55ZbqQ");
            appmenus.setMenuCommands("aXPeoyH2MPWQ21xAK2qK5tvpFCLCF58bdGsjGIj9is9GsAM8zS");
            appmenus.setRefObjectId("3ErttyDUHR7rhIyMWLnmmy4RCgxpWwa8mEnbIaoLlX3D0GNrEH");
            appmenus.setMenuIcon("oHnrgYRSGZeoz0KOfn3DloHPKGNWwkeGDG1GrOc5DEWqdwJji2");
            appmenus.setMenuLabel("eocDJErBTeIqosRrBh0HZrLLpS8upCeHvGB2LDAPQe7auodNQc");
            appmenus.setUiType("Sdg");
            appmenus.setMenuAccessRights(6);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "Wd9ogYWwDiI1ZBJvNUyNZ0ekRNo0mMNLHBbyFGpJqeC6cE5f173GbpUW8mRKhVxiZj94nUsDcPquPyCvn1DCs4kGcw5uTGpRISJFQGxeNOG1aLKT4yKRm2bq7v6Rb0OXUF3Oo9R27Hz5oFO3XSsUzqACc4svPOcVmqGYXc9YMlOj9M8u4b4n7SEImeHlJY3TEGauhcgVFgvRR4to6hItp4je28bCjFOUmgXOBO2DQ6FtsnrYtMQ3j3F4ZeYRh9X07"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "8E3vC5nIedsyTUobuSAl76C40TFVqGFVYw9rGfaMxpwPC27H8sJPiwNT2eDX9FAPNWp2mFQrMOyt8jfI4Yb7zK5rO5OXvx9fgpbDwGeJlXctim46NEXmzHnniJpuSMpCvZMaDDgjMKLf01oGgamWGWdCJLJLCCO57OOGdErF9QfnAZvjh0JJaz2X55zp2eYeaXhp8KLviEdGPqxWsdDzQoIS1eASyO7SLcED7SJbBZq0vyacEGh0UPZu25E5SiFWl"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "prFvud7RlXqEGMGcpjoWZJg4JWgtN4T8IuDemTS6295W2xGyFoqn98F20INyhcmO8M2uaREPg9VXqlFJ6e2guM8WBrCBcN6gQsdYulUBUCoHgmGQfw0dCtoePhfonQWFvSnsXpDEadhHlCgXlauUNllcgPCmaX6vbmLWIzggq961HqcU1bqGL4GCFOoPLLBH9FbpLdCaf3RLqSB2lEp5tSGQplJ5Joy5CdOoTJtVOUqOhBbeMWVYl37hmyNF4b1UI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "aEtfWqesQBgWL3AZUMhz0CCjD5iMmtbwlz2cEydmMQDRrQPwdcgkMZ2PtooZWmkJU"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "lecAqsC4b6HdiH8ubaMjRPMDmZp4BApQUrJypypz744nRtey4ux6WRDxkkCce9PbHaxlz6ONohwtYSIIjwMPcN9v47sUf12SwHV1xitT0F0mVo57YyZam7H6gLiWPOSBvoxd4WmOkDsnpmwYrJExUEZBhABIgmQDbgr6JOEjtoA2fUVNgL4HnHedpGwksT71926GDWF710Wd3KHv637QXmDecSxm2y0m3yK30mlflBZfyVTwvxv1DGGFCN04jo1nC"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "qLVh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "BmqdkP5OuGD1BcMsxkIxrvyNHqP0loIlcClEROZf84UU8pB4tKkxC8bGF3j19b4XRzfEAz4PnYg0JYKYHWvshqslyz81CCTGkzjOcwXUJLrRitc1Olk32hzemOJ7vC7mEuMZwyADfHXGBlXin0EuO1dNH0ytdn6yc4VnWJoKqv9LZKGu69oBxRmS04QvEtRl3HZ88z1Y3ORmyW3Xz3tI5F5mVNjlsgtyhRSpIqKCoqtpEGWSmZYiby4FHQaHQ5Mgc"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 21));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "c59dM1PhIlqCq0tFj0vwqg4tMrAPatKXEwKyKzG6fbajqdS28QDSRdYrXhCc5WX37Pbv8SfUT6PlJ0jIvj8N6RU2DmQAr5TmqtASvW9Z3WbwX9yvKMwEfq2PnexSqN9vLiq2RdFLYL4Hy7I4uE8duCFYGCCImQ0eUwRYqtqqCcemm2j4slneHD1dzWI4sHYtQsCwxKHdWc5Xak0nVoNcWPgrjuhE8iWOyZuUiyG6lum9mhGeovPMKA6TMtsMKZcRD"));
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
