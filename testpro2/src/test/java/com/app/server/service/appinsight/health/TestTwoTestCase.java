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
import com.app.server.repository.appinsight.health.TestTwoRepository;
import com.app.shared.appinsight.health.TestTwo;
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
public class TestTwoTestCase extends EntityTestCriteria {

    @Autowired
    private TestTwoRepository<TestTwo> testtwoRepository;

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

    private TestTwo createTestTwo(Boolean isSave) throws Exception {
        TestTwo testtwo = new TestTwo();
        testtwo.setTno(2147483647);
        testtwo.setTpp(true);
        testtwo.setTnm("m15l6UmU34ovHjyE6EyL9VUg4dSQMM0OEKx9qnuii7A0D2zB11");
        testtwo.setEntityValidator(entityValidator);
        return testtwo;
    }

    @Test
    public void test1Save() {
        try {
            TestTwo testtwo = createTestTwo(true);
            testtwo.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            testtwo.isValid();
            testtwoRepository.save(testtwo);
            map.put("TestTwoPrimaryKey", testtwo._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestTwoPrimaryKey"));
            TestTwo testtwo = testtwoRepository.findById((java.lang.String) map.get("TestTwoPrimaryKey"));
            testtwo.setTno(2147483647);
            testtwo.setVersionId(1);
            testtwo.setTnm("O0Ba1Mrnfc8ngpAiiBlDXbv2jWXzIFXKBZKBZdq3qfRZJ7jJY2");
            testtwo.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testtwoRepository.update(testtwo);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestTwoPrimaryKey"));
            testtwoRepository.findById((java.lang.String) map.get("TestTwoPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestTwoPrimaryKey"));
            testtwoRepository.delete((java.lang.String) map.get("TestTwoPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTestTwo(EntityTestCriteria contraints, TestTwo testtwo) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            testtwo.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            testtwo.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            testtwo.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            testtwoRepository.save(testtwo);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "tnm", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "tnm", "zNeCZgtJeGf8nXKZYiEkdyUnCHEOyy2Mv8xS1nGGGyG4eR2xC4B1VKWoG9Za933GD4aLG7Tp84g7pXdQmbHGSKnGVOKbXZ5WBdmtrlKPtUYHvnMzaMYLzzi1rCdTLNJNtMBEu4DwNQwuw61r8hGETtnEVTDM8FEfjsdomodFpLo0B2LBEIPzNt49zS8PDHldsZARw45pjTW8vNPVXBDKy3g05lyIomCf3HLFh1uVWcQqRxlsD438mn6UFV4AA9EC4"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "tno", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "tpp", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                TestTwo testtwo = createTestTwo(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = testtwo.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(testtwo, null);
                        validateTestTwo(contraints, testtwo);
                        failureCount++;
                        break;
                    case 2:
                        testtwo.setTnm(contraints.getNegativeValue().toString());
                        validateTestTwo(contraints, testtwo);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(testtwo, null);
                        validateTestTwo(contraints, testtwo);
                        failureCount++;
                        break;
                    case 4:
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
