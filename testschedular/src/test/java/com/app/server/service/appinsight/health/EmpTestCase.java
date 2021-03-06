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
import com.app.server.repository.appinsight.health.EmpRepository;
import com.app.shared.appinsight.health.Emp;
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
public class EmpTestCase extends EntityTestCriteria {

    @Autowired
    private EmpRepository<Emp> empRepository;

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

    private Emp createEmp(Boolean isSave) throws Exception {
        Emp emp = new Emp();
        emp.setEmpName("sX5xJ5Gkb3FbJCs0fpusdWQQur31FbN11H0ydLMi7BtoXSJ8ou");
        emp.setDob(new java.sql.Timestamp(1463642663854l));
        emp.setEntityValidator(entityValidator);
        return emp;
    }

    @Test
    public void test1Save() {
        try {
            Emp emp = createEmp(true);
            emp.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            emp.isValid();
            empRepository.save(emp);
            map.put("EmpPrimaryKey", emp._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("EmpPrimaryKey"));
            Emp emp = empRepository.findById((java.lang.String) map.get("EmpPrimaryKey"));
            emp.setEmpName("ClaocZkOj5YavPfUThIzZ7iLF1LbflDmH2lzHY7BzCzAreTsBu");
            emp.setVersionId(1);
            emp.setDob(new java.sql.Timestamp(1463642663876l));
            emp.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            empRepository.update(emp);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("EmpPrimaryKey"));
            empRepository.findById((java.lang.String) map.get("EmpPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("EmpPrimaryKey"));
            empRepository.delete((java.lang.String) map.get("EmpPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateEmp(EntityTestCriteria contraints, Emp emp) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            emp.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            emp.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            emp.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            empRepository.save(emp);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "empName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "empName", "rXH4R0voZSax0jHyizRdTNixvWgeKsYyIlbBqKcF9dKtDF9pS3bz9AwbKnJAvIob8kYjnHZDXOTyS0vFDCymWcyg5hYchZlrsdkpqtO0YpNDQl4n2GBndSgxNkWLEvTdvMiIJ9LvgSWdRTWXnOtmw8AIOB8zLuNRamfjxwmu0Vdr49JAf2EEkq7MvbPRQ9ZcTy3OAcLoD7yMCgWYJmHLnlnxX6tqNPmwJ4V12fJHHS9IMvt9RBwCDCo6RPu7AUiVp"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "dob", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Emp emp = createEmp(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = emp.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(emp, null);
                        validateEmp(contraints, emp);
                        failureCount++;
                        break;
                    case 2:
                        emp.setEmpName(contraints.getNegativeValue().toString());
                        validateEmp(contraints, emp);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(emp, null);
                        validateEmp(contraints, emp);
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
