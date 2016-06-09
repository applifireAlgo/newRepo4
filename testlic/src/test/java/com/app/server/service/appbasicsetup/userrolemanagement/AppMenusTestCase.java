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
        appmenus.setMenuCommands("y3l6MpttRX4el3wLeTC5cIVeR6jeySbf2QzLP2QgUODlqnaBFM");
        appmenus.setMenuAccessRights(2);
        appmenus.setMenuIcon("7uRKk6aeStvk3B0ZwInkI49UKcBBU1t6zclrK2EnR9X7koPit6");
        appmenus.setMenuTreeId("MGHBEoAxOAmeDnL553ZjIUprzuwjcMjp5OXT4mJdgmOCHzTLo7");
        appmenus.setAutoSave(true);
        appmenus.setMenuLabel("fo8uGbIbE6pGsAkvBIvE9PfGXVkvvFj1VPgsRlN6sEiHdgO4hl");
        appmenus.setRefObjectId("KCTt4FOu9ZgQr1lb7JZwlvn7BMK0cxViqReJEAH1cUH3rnFB1b");
        appmenus.setMenuDisplay(true);
        appmenus.setUiType("mAm");
        appmenus.setAppType(2);
        appmenus.setAppId("uyjeXUyRUcxnMQUYLkC7LS5lrr2plErKaOYx98IokWHmzgSOD4");
        appmenus.setMenuAction("p1Qx2M8dkFoe3MpEyojCWybq6uOPJEctJlmlRai9dbhv5eP1m1");
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
            appmenus.setMenuCommands("UaDKidwTohlJo3rTGLx2LW7DXZGLAacEDvf7v747TEsMto0LNY");
            appmenus.setMenuAccessRights(10);
            appmenus.setMenuIcon("i4fSjrMNf488XSqammy2Oo5VglgA6poKjBkn89DKUTwCTsYPL2");
            appmenus.setMenuTreeId("jsSW8Xf67EI20NVGkRxttEGVoosoO3dOVEVkRWFsDFNSCKOUZZ");
            appmenus.setMenuLabel("cXjXW689DnRXPrtDxd0vUaOSTEeqWfc8oe6qKVwlcban3q97S9");
            appmenus.setVersionId(1);
            appmenus.setRefObjectId("2H6HIKUiFaG7zuO8PAXH8CJhjDD3byqXqkH9E18FGmMXCWSu6b");
            appmenus.setUiType("kTI");
            appmenus.setAppType(1);
            appmenus.setAppId("3YjlMtpVHe4RAlb019jkiZ6aSx6cPs4Vl0soTSYZys4fyCfD5k");
            appmenus.setMenuAction("4m1p9XWofMJVBXQVkAIONOLGAJVMk5NGSQZC3rd2fJUtT4Sl5x");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "lAqYt9ePFYSgdHbfN9sE4tp0nsgce1n1fayxlvQdcU6ywolq6f0ypduxS941YryXbBWlpQsHLg7qK4sOYgubeV6P1YCoSu87eOL6xV9rZFKxrq8iiNTvyFch7tMPnOZgMbovailChIq3vAtUonifrt5s5TYm8OpPbpugDJBglayia29HvExtPCrnWX51TBAoSbqT053gPltSEcCSV1TvT2ijm8bo4IbwGKPeXaItuwwdYjkGrFVpod9GNqvCqHKHa"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "eIjZWkQF6CYaHKM0RofQpxhGE8b3e67Eacj61wMQDJH8QIeeeaAX8Wn2tTBda7qOfYmGO033gXaGdtJqGrKTjaCzNl8t5M8fTS0SiCOqaXz3C58O9I5HHNtJZHcofpEIfjBcqA6TphaizNO6oUHaiSQr8KacRHYFALBYM4UWEjslXFapUeggsrI4FJAtxbzWe9IEiF9ckmvN2uqAYnp75r7gQPsOJnQMehTQapzkZKvIOTbCzHeWfGfYglex1fMaZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "2SCNBNVyAMQQOMZdsKq791xtAKB9zMkRpbjgoKtQtWGYVs3uH4vV0VLAfCUGVulhXq3CAF4WOmxe0k6LtZRVdScoFEQZNxyWx9yTJH2wA056T9mMPZ2QMCP3Ol0oPkxFoFzzDU23MiKPbqD5Jl78noNBBJrfleaUbuUMqbX0bgZQjny6OZd22dICoqNYRoq6ZExiuPmNooyohZtaEBYMbx7ustuzAMC43n6ybvBtiydtqdF6YnKMWbt77VrbFFC0i"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "ZTelAK38e5KbND7Ua4DFIcNWauNo67nJqmY8iT1BpJcewNhnKoos128cZuoeUUnHp"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "Xd4gqkHlpTqsoJIc8uxNMEQ67Cp0rzzOg3Jlr7nW3h7ZMkgYPKoolZz8zluEa0fJTVAYFutxp8We7uoQsxEfvbSLNzhFMpshIDhmpcoKG8fgDAhTnsvPSeeOPnlfAd2BZvXE1k4xfyVR21Sm618ZDzWuS0M002Hl1yc9jDewyvYEWl8JC8CaXKVPzTK4lR8saSVXMdkzt9OYuLi5UK3lLJOZYUDV8Kx6u1O1zgcqvJnAdAkOcZq1DVkdR5VqTy2jW"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "r9Od"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "Mv718pPd0B3wIWcNJlBqYmZoWCIVuooi6BptNqgq6zALVJnYN27EdSDoKUvpRDkq0oG92GT6HpKLIPDhoPna39Joh5PG7keQ49A5pJZzyRcmgUcp7zTgtXnowKVp4bwhxFvKugPhmOGPpK7Mpw3E550ic6ewKGIvQObx4t8DZIiRtLYwpnnGl9ALbCv91vwayWzgdpPYzKTsoFoiNPgxz4PaW0aJFcDp2YpJTg7u1QPS5YtXl9kAxGVhqMchNFH3m"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "KfPZSoJcfwxCM9TyNZFoo0RvhFFP4xiyODL7cxDBKYoNgHkbRJHsmtTa7vnVJsJntxDx81oiG3ylMJrtIg0XxuRwskoS7hDktgRGEKG6iPNoNLdD1L2aWQcj19WmkRC8f23IwiagTILIjayP4UczzeygI0sMz8g2xtklduHiu3phrzpa5duO9rrUq6AinhMkp5l2ayrnlaasPudDZgVqJUBzkqqAKdlVMeE9tFGuyL20lhCyT8tJTVAa9bNCzNRyO"));
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
