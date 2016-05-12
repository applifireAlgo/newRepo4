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
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
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
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws Exception {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("b2EDi1XHSzEHNLOwvVIxureJApTeiVl6ClzH2RQ9M6vqGSsTTD");
        useraccessdomain.setDomainIcon("CsnalZeHEIKTRrtOENEcPrbkx5d8CZaNpQslfm3BlkHeNwtpjG");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("h9VbBajlSwIJBJ06n3K8riR1shAeusUEIl92UTFA2g4mKo6Ijs");
        useraccessdomain.setDomainName("lRW0jn0qcIdF4PZAKjiz1Uw3f2hK5dSU594h1TC0RkPMlVaSJU");
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setDomainDescription("Nsuk9devXobMhJW49GNuJzPEcAaZQIeXBHz7KGJ7o9PO7q0mDs");
            useraccessdomain.setDomainIcon("8QEmlOVjE7y0qEiYdMMlMPZhkr93ehIP1gbJCzV8zJjDF0UYOe");
            useraccessdomain.setUserAccessDomain(77926);
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainHelp("36AtQt3qcDmA85I3RbmwyiSMhFt9vY417ekhpxcuBVf9bogUap");
            useraccessdomain.setDomainName("mUimLNBM33lYma0EEQkBnvfYLgXfq9L1GDXpyz1gBhEP1iUEwy");
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 136284));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "Pqr872YC6bwNsvQzt9peLsM3gDq3w47TqhXGiMzc9goVS4DeSnwnwNFnyMt635JRkY6PT6nvUWz1y071kuJROpTRUJqAi34rfqQmlkI7wmKW5TR2eu1eHcNEpdOTxWZZSeHyu6iDTMp6Mp1h5MbjYoWSpmggFymtvjcFpuaWwglCcU19b2k7u7L9jJYs27v2meTqeFuUlIvZoeQ81pevGSZWPnqb9l2CgODK4LhSqjV4DpP4xTdDLLnfd9vcmbbCp"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "jzWDj1xnnpgAsgAVO9s5isHxaqUK3CmYEFus0gyR1qlIpTOwHHaU7W0nv11ljYiQySZ29nn7WNw4yZICmQqLoZSlwfavq7F1q4Rc602l3Ccoz2pauvVoWOd7e9E1dTUyfQ1hBKkvatBEMpxMXL5VzNj5cnbWK7J8r4mwb01kkRVJaS6WnumL58tpTBc7M1spv5YKdfrf7fJhtzsENkMY2mmxMAIf3XhzLYzGUY2ANWzVfZzgdxFbyVYbV1yrZFqaT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "hRtryKKk8FgvZStYbcrHHAlRGenKDyO0qvRHeTJvOfWD00mSF0tVYHAEUczg2ePPRjEmTzLKTgaPx4Xytlj8voeYcLVJ0igVTN8pPwTpuPQ2DwKgLu36yiFKncr99HYZ98r6ecET8Fe2Ds7ik8zTHnDNBbHSPdkY9sNEIizbvDKCr4lQJcY2YdJdWTMPnPTlq0ZCrOnqgaocXbs88diXkepClUhInvA0p0zXSH7m4zTqbLl4EYKzBDtgOByzvGkn2"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
