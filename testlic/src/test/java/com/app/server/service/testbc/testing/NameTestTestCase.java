package com.app.server.service.testbc.testing;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.testbc.testing.NameTestRepository;
import com.app.shared.testbc.testing.NameTest;
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
public class NameTestTestCase extends EntityTestCriteria {

    @Autowired
    private NameTestRepository<NameTest> nametestRepository;

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

    private NameTest createNameTest(Boolean isSave) throws Exception {
        NameTest nametest = new NameTest();
        nametest.setsNo(2147483647);
        nametest.setsName("G5oQRosnhQEIEP6A5n8GaNbx7AKmpE6RbEZAJ0Z1BXIjXaessK");
        nametest.setEntityValidator(entityValidator);
        return nametest;
    }

    @Test
    public void test1Save() {
        try {
            NameTest nametest = createNameTest(true);
            nametest.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            nametest.isValid();
            nametestRepository.save(nametest);
            map.put("NameTestPrimaryKey", nametest._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("NameTestPrimaryKey"));
            NameTest nametest = nametestRepository.findById((java.lang.String) map.get("NameTestPrimaryKey"));
            nametest.setVersionId(1);
            nametest.setsNo(2147483647);
            nametest.setsName("SzgwcgxU53LzXTh6ioBQxfd9lWiuZykMLOKlMlOMHpH97TXwZt");
            nametest.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            nametestRepository.update(nametest);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("NameTestPrimaryKey"));
            nametestRepository.findById((java.lang.String) map.get("NameTestPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("NameTestPrimaryKey"));
            nametestRepository.delete((java.lang.String) map.get("NameTestPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateNameTest(EntityTestCriteria contraints, NameTest nametest) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            nametest.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            nametest.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            nametest.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            nametestRepository.save(nametest);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "sName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "sName", "7mGLBhJlqmXNfrk2B89EFXrwTGYWXez9hlDI1xte2MOxt5VD1Z0NTWQKcpsmu0UcnJ4ikmCXVx0q7zxdofmwvKWHrO7NzoKARs7S95f6Y5n3oYy4VQxOpBgvu9nKklkPTK8rzSocAabx5ATAs129Ljmra0yd7SWthJOXwwhxY5skiGLdvgMms49HzN4LbkocnElpqars0aCeRrh6bRJ0JR8xp93XfXl5ZICtmDbyzjRdUFvTdpPgJgNtdVdfVewgB"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "sNo", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                NameTest nametest = createNameTest(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = nametest.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(nametest, null);
                        validateNameTest(contraints, nametest);
                        failureCount++;
                        break;
                    case 2:
                        nametest.setsName(contraints.getNegativeValue().toString());
                        validateNameTest(contraints, nametest);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(nametest, null);
                        validateNameTest(contraints, nametest);
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