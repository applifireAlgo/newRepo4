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
import com.app.server.repository.appinsight.health.TestARepository;
import com.app.shared.appinsight.health.TestA;
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
public class TestATestCase extends EntityTestCriteria {

    @Autowired
    private TestARepository<TestA> testaRepository;

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

    private TestA createTestA(Boolean isSave) throws Exception {
        TestA testa = new TestA();
        testa.setAno1(2147483647);
        testa.setAno(2147483647);
        testa.setTotal(2147483647);
        testa.setAnm("8naIVjIOGY2jnsiePr9eTIWAVqR90VJnzlkZWG6ibGu10HNnBV");
        testa.setEntityValidator(entityValidator);
        return testa;
    }

    @Test
    public void test1Save() {
        try {
            TestA testa = createTestA(true);
            testa.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            testa.isValid();
            testaRepository.save(testa);
            map.put("TestAPrimaryKey", testa._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestAPrimaryKey"));
            TestA testa = testaRepository.findById((java.lang.String) map.get("TestAPrimaryKey"));
            testa.setAno1(2147483647);
            testa.setAno(2147483647);
            testa.setTotal(2147483647);
            testa.setVersionId(1);
            testa.setAnm("CqURL5JSw42SXUnu6Nn1tRS6CP3dmRm4xRbC4MxI8TOxrRkA6y");
            testa.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testaRepository.update(testa);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestAPrimaryKey"));
            testaRepository.findById((java.lang.String) map.get("TestAPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestAPrimaryKey"));
            testaRepository.delete((java.lang.String) map.get("TestAPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTestA(EntityTestCriteria contraints, TestA testa) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            testa.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            testa.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            testa.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            testaRepository.save(testa);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "anm", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "anm", "Z3SMhZUizYIBLZXXHsG8HiPD6jbNDUz0gyjAzgnnmSFr6CUP5e4PfOOqzfnCQz18jgBA8N3UPHEPOJyjkies5LLRqpMh9HWx78rZUmKwAFgcoJBbrczs5IQoj3A5OoGNdJkrA8eDHBTpndVtlEiMRRBWN43HhXstkOUhiVnPslYVa5dIAwOnautFN7UtRIWZb3rxw1k46Se5BRVUtUlOiYuLwCBg6fYmewNHoFrAnL78hoJSDtB8hDGE1ie37hVk2"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "ano", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "total", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "ano1", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                TestA testa = createTestA(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = testa.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(testa, null);
                        validateTestA(contraints, testa);
                        failureCount++;
                        break;
                    case 2:
                        testa.setAnm(contraints.getNegativeValue().toString());
                        validateTestA(contraints, testa);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(testa, null);
                        validateTestA(contraints, testa);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(testa, null);
                        validateTestA(contraints, testa);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(testa, null);
                        validateTestA(contraints, testa);
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
