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
        appmenus.setAppId("ihqmcEmESihyHOXVYK9DuCpmQqClzkguYux85Iyj3CPQzqurbm");
        appmenus.setMenuTreeId("jAbnxE2kE3OFWP5fiDyb5Cs5P1XG8hf8NBUQzW80t03Sh9ts0Y");
        appmenus.setMenuDisplay(true);
        appmenus.setAutoSave(true);
        appmenus.setAppType(1);
        appmenus.setRefObjectId("vJCVcrbXf2Nf39ZZsZH297elF9zo5mCIs3u4gvv3ERlFj5wcur");
        appmenus.setMenuAccessRights(6);
        appmenus.setMenuLabel("rVIUojyXooIgUEdJKtFzKXaBdXLbJrLNT0zhl3qiZnXUHL6pYj");
        appmenus.setUiType("047");
        appmenus.setMenuIcon("AUAlpOuIrtt07XYU0e4jFReQKsa2f4zt4sPZFIqenX5gpldQqw");
        appmenus.setMenuAction("0BZY9bqZniZGIIRtq4UYfENXhX7c9eZBdvI3gTb96vyQLxwmti");
        appmenus.setMenuCommands("OLs2RtqUB1VNE2TdU6opMI31KXfR3RlPgh0H41z36UWn3TURa3");
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
            appmenus.setAppId("jkXopotYXOCKp2a93wLgENUCwMzczuDIdkxyAlY62bq8h3WQKL");
            appmenus.setMenuTreeId("XABsHbV5MWqHffnj2oO4VqEPkE92r1Xx5aJUldvdtzZVBZA5xQ");
            appmenus.setAppType(2);
            appmenus.setRefObjectId("y7nylqoK2ALrTdsZgEYUmHSrYonuwYqQvMs7W59DnDBjzUF8CY");
            appmenus.setMenuAccessRights(9);
            appmenus.setMenuLabel("woSciUn4JZSDTylGkEq3vd61OhRsWiPyvcOCC2ujbRoNtKMcPK");
            appmenus.setUiType("rsR");
            appmenus.setVersionId(1);
            appmenus.setMenuIcon("J5QcOVU9ffI7e0sFV9O1YUKqvN5hw7RU3fDrNSjNamUsNpBefm");
            appmenus.setMenuAction("rFL6FCpc5WOcRbqSxBBpPQPEnMKeJe31OJ2CqmmovPvqnKHmtI");
            appmenus.setMenuCommands("TONLIfkFPp4MVwklRW2XcR0WQbw42KRQBkgMu9GfBHZxjHjNb9");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "q1Fxe0KUUUFlnxK9Ys5iiOIy2Kojhhrwd6E5xfwCRDRFJ5xq4rWA53u1twSwGFx26BfYwDmjI50YygzgZ0gyyMD7Eg8uBlXhTUWe5ZfDIfMQNttNdILuyuztnC2EBlL1CtjZwvWiiXpG5tMtvIhkXR7I212hFBLFGtYO9oGWIUbHXiyVgvP1ZuNydNOnriBZf6Qjqt0dbpOtxtc0paJc750pAnJGMoQ2rjRK0oaciYIU77xe2OrN7oVRdzX8XQiTq"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "i94JkXXlFcV7Gs89MNmHtTdW4REMmKih526Fy1ZhRCzvpcJdZnTacN5xrXRlRP0bREERAQJ1CGOts75YnbfIrXsbN9VnT6L7yyMCw07oO7c5j6uKXu1dy67QYiSVK4SPqQXWX7wYKAjaiGT5t0jo3piE4IXUMy9AS0p2MA9Bcjciz21uonFV2TxuUJs77Qxrl6chTj6IxRKyCjwcwlY8LdT1Z5ZDXlRY6W5Eg9LJjKb6RInM26hQA5jVbAangEP6w"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "C1FzvvmjEhwmznu638VSm3pAWDpIFYsdRaIHB1hbCj0HJcVjQzjHLOW3hkJL4kmhlUdegx4OKJUaRkiRTWjGBIt1mRSs2J394WgniLPB7DJtp8fDuIBB1kFRFNqytQ8La0I8laC7W72Zj9FwJa7V77KHSX4TIoF5hXuq8lt1opn8UHp1WSPMuDE4Xu8AUIL86IIt6UQaeVklyzm1SAUKQLESUfIuB0bql38l7YFbAx9WqxqPJ9chnDhSaXtbWK9Ii"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "qQCdKAzNFKibqjENLfV1FQKZENqG8cX5TcmqsV7NjY5nV366IauaWEHXxSzMCfU0b"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "XNAy2c0dxM7OX2G51iz51iswSmDoZoZyxRfpLXIR6E5h3QOj0ro1qI0LhlgVaGZW8Iuex8OKZzHZN5awQ9IqvgurCEmrLGeD1A3tsqEGahv1gTIKtAIe1pegERthP4qn67ZTovW1CYhxddmGFAGUX6edSs28IoqoQ5gZuSu4jCI0Lj8zNH5fFAu6h3807ARwnKYJ9j0KnBAGw8JVnXFC3GyLKIpXXNdILHhHF9hhS1yyhunKbXi5hXzjStAk6GJTN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "qbiD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "XkPAvv9FCvhybGyhoF9WgbaN0FCMwYbMuzOYkGxAru8AgXQ958bcRzk5lhYLdFK7jFDDoWGNmzR7uCcBxIbg58u8yISZIpYDLtJLgfrFufTPWRgHGF0za86fvs8NVGIYPtUI7QhTYOs4u1YdxRkRZ491L85C7AKZ2Qkw12wdVLsMmtR3GTmcyoInkPzItS4M7Pe5zcJCYSzhGSUnmz0Fy95Vdb479yFANKvaZhXqoqlWQ3XN4TIT1pGiWcZYLdWeb"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 16));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "pHTvRmgDBIImel35vnfY2zenJSvLklUduk4j5s1vg9IwCb6HTA7Yv24D4OdnnBzAbSk9uU1JoceKQLFKcryLKNtVfouMB2c2VMlZZNs7vfM8R7KaoiC9YV7YmUuVmeykgl6dxzwfR76OQmSJBSwCdf4ZjqoiCTNWUxh9O19JkcS2dfZMrPeeSHWs88iwvbypTCMnDSja4irHrg0qg6kVCTfheBCaHggHa7iJ160sodV1hImItPFpz07jTyew5iD8L"));
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
