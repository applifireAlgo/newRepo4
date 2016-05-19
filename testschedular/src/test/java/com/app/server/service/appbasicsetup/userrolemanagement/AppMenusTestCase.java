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
        appmenus.setAppType(2);
        appmenus.setMenuHead(true);
        appmenus.setAutoSave(true);
        appmenus.setUiType("fSe");
        appmenus.setMenuIcon("6nFLoEgtuelSKhWJtulRPkBeT9Nex2ZKM8qpYk3KrbffaR4NZy");
        appmenus.setMenuAccessRights(6);
        appmenus.setMenuLabel("NAhlHkQO42u4oM3eyBN8Xm1L1I00IdFIHujCBvhB6CGPyJMImY");
        appmenus.setMenuDisplay(true);
        appmenus.setAppId("CXtmBa3QzLpfbq8VtVa3ILpiPGdEZmCfDW1qY3I0lzeMVwAkHX");
        appmenus.setRefObjectId("95McaGvfYZKGZFGZ6uXNM82eI2IEEK8nH0Qcvwyqh3Mrfy6v6y");
        appmenus.setMenuTreeId("Pulh3lD7ivnXSzFxqE5VQzzG2JzRy5cabFHK3HfZQNfuUe4Xmk");
        appmenus.setMenuAction("WhIHpw2GBLJivSeXeKiXFutDFjx5iMi5ihsT4gOztoVsYr3ViO");
        appmenus.setMenuCommands("A9Uiap8gNfGxF5sSJQ7u9kj34uwJkJnCHnBwUFKB5o6scq8HoO");
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
            appmenus.setAppType(2);
            appmenus.setVersionId(1);
            appmenus.setUiType("71f");
            appmenus.setMenuIcon("HVpffes89hhpZ4e2I7mXtFpXsJPDETEZ5nfX9ZqKfhKg0sWMIx");
            appmenus.setMenuAccessRights(4);
            appmenus.setMenuLabel("Q1jpRQbXSPTUg2EjYyjo1R2LkXE4qo5cfncHuXaGFo1Dk961Tw");
            appmenus.setAppId("pgQ9uIoLRXGwXvofb4znvwI0sVmFN7duoyPk3uqw0PtqEt0tb9");
            appmenus.setRefObjectId("NzbWlFd7TX4xEtgnU00hJ0QcTgtc8YFd8h0MAvmL5bkZvN3JVX");
            appmenus.setMenuTreeId("tcY9IRcijLtNTXME6p8a1QaH2E9zXB4IsX6PV94fiJNvXQMeCg");
            appmenus.setMenuAction("TDyWiH0irUdJ2La566XFPJquB6INcP4jzFDYbFsm6mCQxfrz7l");
            appmenus.setMenuCommands("YAKcvXiIZpUcmXb5wSkhoCIS5kHapXBYzLjxteDhjVcXoVC3IX");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "VB1Z4qg4uoFnJovd80Lit8Ta8hwV29s8UOahn2KDOU5ryyjY3fNHiMxbcOTZYyiAoYyGwEpcQeNjJqSIaWF0diwpdg4VtONMSpDYoukQ4XJJJvs2wfuVx1FKL2z1uur54lhUNssmCkg7OGywTgKaZLQNI56We3t05pS9MRRTapb4LR9xHEw38YYkeF7PUtsGHIS5CjVyYwHlR2nzQngw8sMETOUQrjuYUuAOod2UqtOI30ghupIJ2MU1QTssNJuf6"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "etdfq8wJFT6OonH1C7W1FnORI0KdupwM0uL2UHRrkhSZOq8U9A42GOEyl9IQUAEeq5QLYHvsvqOwuFtHTqjUd7u9f5voqseQf8DlVQGQ3ij49mZd0WY8QxjODc1Ljf4IoRPzHQdTzNdOufbLRFvON38JPM8yFL3m1vc7EPC6kTgexe40mEeNqbKPVear7ztre5hrPo0jjr6b5vJSj3y0b6MoYH03nurjSqwabQSImGRnVYFDl6Zihd7Il6gT5Phz9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "Aw4GviRlejjTcpBEYmWusUPsB7jMT8uDD9uqwvi5QoVRZ9QFeScPMM7VQh8zAnjl1MTihDhvRKV0lpuNKFLB87LWZilr1BPUChgBjR7vQnYntAZCNXSSRaDGw7Ro5rckjiRcV26xhFIseCMoyU6venlwaerCuwLfzllb858JIKwKOiX1KGquX5zksCqOOVaPsgMiu7MuvKCCyPoSD1VZYktCi3PTEZdb4hEiqhXprHgWRbvZX1DqQVvAUJCkgtVkX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "Sjo5i98KnPwEP6RMenHwKeFsikTYG5izhM9ZsXh0lrPrBmRLgsAvrck07kaUltOja"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "FBDGzTuvv6LaFkiG9qWPZpVYcMoOScHsAsMsdwISlxBBfdLt9mTbacN2xGYccefxY77biYONI5d10lXrUnoOyEEyzgibIXQMoCiFQtfaXfAL4Cw3bni3lsJ84ow06rqHamVR2TzGoHn0sI8EdwLzAiaFfXqdRtUnXYP9n8agkBexsO96y8R7XypGVKwVsxmewUuC9enCwAUjOZ6OL4InBorHo7g19je5ntESQMKwbTQhIvQ6uNp90BfAiTLQ2WUHi"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "vLu1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "7pcuGiRUu4WCk7SfyYPFNRBKz8MV16bIcWm44XsvWuOBmjEbXMCGRG5EexcMn2MVeKUWjyYFCQ62hnwqkgiAx9j8fK3jaUCmw0OOXug5hym2TUIYmA69yfGlVtrxnIk1iv7PoFEqpNQB4t15mhG3XM7e8IaVqrPo4nysMwvLqq6yLgD7of1Okfz1mlGneoGI3fHHtQClzQ6mFMDJOM6pAVHz8Etv3pu9QWntuhwQWd2aXSIhI9nrwjG8b69uVF7P5"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 14));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "cclgwZB1p49j8bzB2pU6EvTbZTWvt4IQpf8kuZGzW3ddrmPIfaE2IWlq028ahn68HCzSdJrzYfhHIHG388chHmFx5YpN858zMu36oiJzGdj1X4eY2aQ4apT4smP2vUQ9vRxtufutJ1vTHtDM1iJb6ywV9eBZXnSJj7lkhpBql6bObNLnHD4linoWcM62YrIYGAopEq6RoolKSJYVrhTMXDrJd7x58T4qjStyuuPgIuOUso16DITJ1JDqgbrCLxtPT"));
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
