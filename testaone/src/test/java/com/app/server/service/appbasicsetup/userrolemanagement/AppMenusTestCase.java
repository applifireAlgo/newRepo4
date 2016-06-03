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
        appmenus.setAppId("UQT3S69cEYDcAQDgB0lD87w7LmoV9e6NX5N3zvabcPTFzKUIL1");
        appmenus.setMenuAccessRights(3);
        appmenus.setRefObjectId("rqHelDtPtSmThYQFQOJtwQoah8AwW08ZkjpYsKfxhTsVXOnpyQ");
        appmenus.setMenuDisplay(true);
        appmenus.setAutoSave(true);
        appmenus.setMenuIcon("E1iS1sN7VCsoXasOwtC8NPDSBHhg9UK108syAY5UwCb1dsFjWG");
        appmenus.setMenuLabel("GWO3ptX4sR2SPTVY382UNatDDItSzyKYqxEXHuAWrtnEdR0wb4");
        appmenus.setUiType("0Ue");
        appmenus.setAppType(1);
        appmenus.setMenuTreeId("u685eqM1uW96vykKvckyZ5wIrL0raPVIyLvhUy42YtHdNM4obv");
        appmenus.setMenuCommands("dX6lXPA9UEiehnjgRXI8Epszf6UPca9hpriHcM4I2PN58umxHV");
        appmenus.setMenuAction("h42Nyzh19CZV6HtdA18HpF7rSFq8yEoBDNqrQlatvQo0Ni9pvc");
        appmenus.setMenuHead(true);
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
            appmenus.setAppId("Vj4mFs4Qz5zyLb3liBsM7Ue8Mgz6irPVyG9ji2S7rx71nisTzK");
            appmenus.setMenuAccessRights(1);
            appmenus.setVersionId(1);
            appmenus.setRefObjectId("11Mhe3BslK8BZNJqyq6XgwnMGC0fKNhQiE8HSE0VmgLJcnOJPo");
            appmenus.setMenuIcon("9iOWdj3odRuw6PRZKICIFc7UAVxrRx7S6JAwZZql7URu7g4anV");
            appmenus.setMenuLabel("Y28ymcvGKvAo2o3BshP0Rajei0uEhBQE4Gn9VL3x4QW3EqDVei");
            appmenus.setUiType("t0H");
            appmenus.setAppType(1);
            appmenus.setMenuTreeId("2uFv9IZ6WcNVfcqJlOCyg9QQfBfwomUGfiGDm3TA3z1GHYe6Xk");
            appmenus.setMenuCommands("FesjZwKcdLqATWtWY5udDdBKnuJpA9X5EpwyBAdPe1ftTS2mgn");
            appmenus.setMenuAction("oQrDxy4jXFKITeDOr8ca0YnIijsc4uCep3xvdU2MoGMJWJUnPu");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "kJZQwrGgS8xouRj2Ad4LLchbiw0VMdlAZ8Fd6rQfw1zsUc00R33VqFXKgz2JAXOK356ZVvlgrjjbwS9BEkYZis4y55GGy3hieUnEKjk99kiPkOIXtcUuj4UWZlMMO0769hAsIuhqIWwPRw9TSZ1bCJkv3lwi7lpy0ym6v9Xt4M4O93TvWQBxW6jYZ3xJa22DFPrQ8iMdqYZKVuUkMBa3mQFRXxbaGWrzkzHQJKI5hWBOY714OWw7zv4FKpr47Edw2"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "9UmGIcXhRlpuXXXYSiSBC1m08MknQtKW9s3C9w8LXDewHtjPXCP8an2qgkbxJ6xGnt1sFkf1sfSNW3Lszuz8Pl7jiip8WRi9VnhVCvCbFBejTXRdLYNEovKEsZ9uEntdIwaz9ic20LhE0ameF5HcaUNeytwj0iKiumv4oYeOJNVdRP7lfRoVdaf8tEUoCP3njPpTVWcQHHHNLtLZ7UdnG2tA3uqiQ34Ywrq9gVkjQbyi5VclNGNrseMEAjq8HjQgb"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "xHTo0wqMveGSdtHQtJcGxrIOb0MGvJqkhYdSliGE7OUS7m7bYXuVUK61KRomcrDXUntrkbueTkRMK1s2xCANKiGIHMFgsaMRqKwhW1LqPBZp7OzPN7GcH9Aw9zGY4cuCmMNJFAGZ4rxljBxsjjwHFrxlqyFgjmHQeXw8dqARWMI9EzhTJR79LT7vrxkli8DK3bHaLwrQyvQ87ESTeykVAV2UQ59DEYWKuK96DyMKQQnVT0WLBKyWiYFIvHscLua5J"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "ABn2MgTLz8s7NYfawJ6f5wOpT70qs3rE8D8JimipNG0LLmbR3Zg4zffQ7Vq1oFmTg"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "EFJgZCtvHuj3gREQc4YXU4Vttxjun6WpdA79Ef4BS2cnwThUSNs1h3AElk7ZzdxqEpKmIj8PmKRH5AidBE24OdftnX09P2QejLDl2ALMLNrLEaLoEdjcuXwGHDiYA4Sab4xLvkZ8zJlJF1XUtXFBHxjtFxShWDWxpu96Fc8eB0yvX6f0Rd2H5hyVrNNb5q8ll0OFVVPLwazJ0lTvrI7omkvSOc84FqJTqZJoVO1Jsn88A0y6fYqjNuidLvxTYsnuh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "UFMn"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "zIReb5UYUEZNy9i5NIjA4Squ0jqqdv22maWFrjrIbAHix310Fz0RUoAp0PNp1V8XbR3lS2GrtubbrvMTccPHycvp4sG55Skq9Yhyep5LTTTBHkx8937HGFmSB6Z7J83fn5GRwC4Orpo4MPhHn7dsJumiepDLA5fHONbVioFxJQ4CWlWd7I6w25PtkzZSTqmyGm0Wb5wnwmCcQrWCznH36eD4Js3CxdAcRpJIO8XkS3udLnrhb1i2DeRrEeu4Kmz4z"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 21));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "YomFQaMFHEX2orPpcau6I5n6z5tQYf9L7dTDSWoMYT6LCGACFd7Mz1Cxdlby0DH1mvhjDl6xE90ECde7RrdpXVGpSV8TF1SHxeLw6J5GnflTgaPJIWlm9n4QC23ckuE6cDE1KqXNnnj53fi6WX4tv9WupFZckRo41ZUQQQEYT9rslhLa689ZxtDWU8EdCvHjY30DBUbsV6uI9v0hBRGVowbO543WQMvjru6FuWRqKkwwjVpA1szWsEYDfeCyR8VTG"));
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
