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
import com.app.server.repository.appinsight.health.TestOneRepository;
import com.app.shared.appinsight.health.TestOne;
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
import com.app.shared.appinsight.health.TestA;
import com.app.server.repository.appinsight.health.TestARepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TestOneTestCase extends EntityTestCriteria {

    @Autowired
    private TestOneRepository<TestOne> testoneRepository;

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

    private TestOne createTestOne(Boolean isSave) throws Exception {
        TestA testa = new TestA();
        testa.setAnm("u6BnuHkrQUYtLXSjXNxuGUjzB0CWkEsdKoAlcHqOFTqG2tTn2x");
        testa.setaDate(new java.sql.Timestamp(1463050321561l));
        testa.setAno(2147483647);
        TestA TestATest = new TestA();
        if (isSave) {
            TestATest = testaRepository.save(testa);
            map.put("TestAPrimaryKey", testa._getPrimarykey());
        }
        TestOne testone = new TestOne();
        testone.setAaa((java.lang.String) TestATest._getPrimarykey());
        testone.setTnm("8v8HPWZjQQZZMTD0VGmBNrTeK4esFnxagF4yCJMDmRs3YapxYV");
        testone.setTno("V6r13ZBfhEcEztmqh2WmacZWplLxq4sVnzaoN4NahMWiIauwma");
        testone.setEntityValidator(entityValidator);
        return testone;
    }

    @Test
    public void test1Save() {
        try {
            TestOne testone = createTestOne(true);
            testone.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            testone.isValid();
            testoneRepository.save(testone);
            map.put("TestOnePrimaryKey", testone._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private TestARepository<TestA> testaRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestOnePrimaryKey"));
            TestOne testone = testoneRepository.findById((java.lang.String) map.get("TestOnePrimaryKey"));
            testone.setVersionId(1);
            testone.setTnm("BWMhCBv5hxl52Y3rQwvN77ApNfJoNHnHtGd9X6J9Pag1eiMqtW");
            testone.setTno("GWz00SYLv2GH105JOMMdDSMGJzju258KSVv3h1TY962of1FiXw");
            testone.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testoneRepository.update(testone);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestOnePrimaryKey"));
            testoneRepository.findById((java.lang.String) map.get("TestOnePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaaa() {
        try {
            java.util.List<TestOne> listofaaa = testoneRepository.findByAaa((java.lang.String) map.get("TestAPrimaryKey"));
            if (listofaaa.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQTOneNamtiveQ() {
        try {
            testoneRepository.TOneNamtiveQ(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestOnePrimaryKey"));
            testoneRepository.delete((java.lang.String) map.get("TestOnePrimaryKey")); /* Deleting refrenced data */
            testaRepository.delete((java.lang.String) map.get("TestAPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTestOne(EntityTestCriteria contraints, TestOne testone) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            testone.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            testone.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            testone.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            testoneRepository.save(testone);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "tnm", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "tnm", "2cIpKY7LL3yoD0pgXH9KEQB9aHn3DjYFLNzlFUy4WcXCM771rbO0NGTjyH0uVOVKUle0iZyOTDv8T28NKqju3OZMdwtrDBzqCQwVeeSHH2N3ajZmeztv6UKi5egmwafl9PmYTOElasYgaEdpWEgWgkjOCM8ck8GWUNjYiWU4rx0XxARqJyNl5B5SETwDX5MNamtfVpNkpmeih4ZOZfumTUEP3CE8lht8kTwAlkNd5ORMGMHNnga8RRFxGRfhg5BpR"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "tno", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "tno", "qIqwqcbMnz3eSdTb0sOIf3KZMeFagX6UBww5uVMnwRJnXmULlKZc66J1GydzKhNQsOBRus4UPI3cHfcHwrjcYsgLApqSrpe51aIiH3haFGdrEFjtb6nr6taXk0pVS6FSEZkYeORWDQMANstuT673gzJ8DeZIP28SRWwiS7wTz9UH9KUav4TPVNps71D8aJ99oGPgtFUM3YXMk3gaSUmnO7o5E4dsYXq67CpcL1kscW8GgujtbE8gFCTbejqCAFBh3"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                TestOne testone = createTestOne(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = testone.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(testone, null);
                        validateTestOne(contraints, testone);
                        failureCount++;
                        break;
                    case 2:
                        testone.setTnm(contraints.getNegativeValue().toString());
                        validateTestOne(contraints, testone);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(testone, null);
                        validateTestOne(contraints, testone);
                        failureCount++;
                        break;
                    case 4:
                        testone.setTno(contraints.getNegativeValue().toString());
                        validateTestOne(contraints, testone);
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
