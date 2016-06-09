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
        useraccesslevel.setLevelHelp("w89rwoGRFMIC8NgffKnmxhEVFGx4AkwQUraav1SPEyhcRym7KQ");
        useraccesslevel.setLevelIcon("2r3lrrcxIffpyeWglbG8IBd5A7dePwOss6EvDFbNzR4hHHKNCa");
        useraccesslevel.setLevelName("p4i0zqgnvvR3V9raZLMc3UwAf61geoaKM2o6gE3A3PObs5pdfQ");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelDescription("aMXRJBamd7nAYS1U6NDPhXrploeYRy0vstWQwRbAlEvciVh8nr");
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
            useraccesslevel.setLevelHelp("CtJUGxO3VvbB3hON7k3OzZJgtRleym3s48CgSdBIYzjfc3I4qE");
            useraccesslevel.setLevelIcon("iugV4VGH42sLMd4KriX1tW62CYpA4gywwEEWMy2O4YKgnWwRjP");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelName("ZruzuqfNWphVo4NZFLboefPEbVSI98arwhZuTC8Z6JWdpHB0XK");
            useraccesslevel.setUserAccessLevel(38442);
            useraccesslevel.setLevelDescription("r7OTfIt7hIhZtO0b0DWDQn9R2qO6F3oHxhIcqlNGd0KVtfMTmu");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 107115));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "a28A139SVx6LzbxgY8hLXwajWHaB4rI7xXp3SSpzDzE4Gx5A80WLD4K5pzUpgdNCeYA3CNUrxnMfXtsnvhlllIi6oMMgIv3BUgrLipNoShf4dH2JNeREWZ2yf5Sy8uaIdikKfLdKj7O8FgG6bj9CIyYPHqC3R4R3y4cfPcxkcWF2vWwwYii8R93cldiGpBUB1SETl1LQQ31ReymSDCrpp8DtctQkqgTKTQD0OZLr0MLh0zEjZ62WIlMvcqKuwqPPe"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "UkZY3FQtiL8duy5aUbcDLpfwlymrNEqWARiMNp38GYt2s5R9e9oK4gjyJaVVviVA92oRCC5zwpF9YK9lwyxpcJfquiOicDHMk81Ve1dPCLGD59STewGkbwdCFye5pwYLUjEkJvzGNkuhMdCKYDOF1NofYIlQBxXjj3uKiIrK6EsNoTU8hclqchV7ITsHAs1ifscxR8fLLqPXLaCuomixLrZrQzF9U06JIBL85PLVApoAqoiJnw1beLx7CC5esJkqd"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "i5zqKUezIzMwtZiFJuLOTlFDxOErGa6S4GTQWi0t40NOXVTLxxKqRsVzZBKMTpYFnehOLpQ2yTblZVq4SRuml0eanH1qluVhn9AwmwThByKUhAFVOP6RqsSJW7fQoWQs32iStfMtB8y0M61tgxkDp0rbcz91ogOipYd05ftIPps1iKxpthXeER7B9EoZiJcXBlENmIwRnWHfSNvMwRnhasT5oxQgDJuL4rYzTh216nvksNFgc1aaBdkWJGTmVgXIU"));
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
