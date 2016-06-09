package com.app.server.service.appinsight.health;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appinsight.health.TestBRepository;
import com.app.shared.appinsight.health.TestB;
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
public class TestBTestCase extends EntityTestCriteria {

    @Autowired
    private TestBRepository<TestB> testbRepository;

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

    private TestB createTestB(Boolean isSave) throws Exception {
        TestB testb = new TestB();
        testb.setAnm("FJBfN3fAjMnLkqsZ4s1QWpWZ6tyoYlRBmuEvnAueWdnh5MwvVo");
        testb.setAno(2147483647);
        testb.setEntityValidator(entityValidator);
        return testb;
    }

    @Test
    public void test1Save() {
        try {
            TestB testb = createTestB(true);
            testb.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            testb.isValid();
            testbRepository.save(testb);
            map.put("TestBPrimaryKey", testb._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestBPrimaryKey"));
            TestB testb = testbRepository.findById((java.lang.String) map.get("TestBPrimaryKey"));
            testb.setAnm("K7IqHUsfg4QcXuLbM5GKAMZIaIRGr54cgOy6tZ5cu08uiUSndD");
            testb.setVersionId(1);
            testb.setAno(2147483647);
            testb.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testbRepository.update(testb);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestBPrimaryKey"));
            testbRepository.findById((java.lang.String) map.get("TestBPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestBPrimaryKey"));
            testbRepository.delete((java.lang.String) map.get("TestBPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTestB(EntityTestCriteria contraints, TestB testb) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            testb.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            testb.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            testb.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            testbRepository.save(testb);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "anm", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "anm", "aEjbxcv70VD7M8rLpjBQiGiKHQtE6xuKBrkP1AsxVEVrX3DcbcXyOO1sHEKsCoT7DDqUvTV5wbRCktb7PfNcC3vNYw0Yy9xsuj2xIaWT7yzN6p3clVzCAWKSpA43fy7n93DuHmdQPpggp3RevMQH5zLv2ufIC29jfbtKiCQv8Euio0hT7UdJsOrEFWu7ordIVLdECnL3i970Q5Hz9FkZBKoCoucR7Su137aa9x1FsyIWgFIx2CZNrptl2EgamvUO7"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "ano", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                TestB testb = createTestB(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = testb.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(testb, null);
                        validateTestB(contraints, testb);
                        failureCount++;
                        break;
                    case 2:
                        testb.setAnm(contraints.getNegativeValue().toString());
                        validateTestB(contraints, testb);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(testb, null);
                        validateTestB(contraints, testb);
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
