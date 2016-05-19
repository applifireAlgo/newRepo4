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
        useraccessdomain.setDomainDescription("0LEWrKr4eWc3n45c47M7MlCSEW2gVtxFgULltYZHFk83mJwkAb");
        useraccessdomain.setDomainHelp("z7KIGB8wqfbPirHrVv0HP6NUOn9CW92p6XJ4wHAgXbVirScHxx");
        useraccessdomain.setDomainIcon("gjfSLqI9jLdMhJuKyPgKL75eBa21WvSVjlLFq55r0UzV8GTDPc");
        useraccessdomain.setDomainName("cYo1axajzoZt6uIIDSNQay9JttyvhvT49dTdcW8DoGWySBBYyT");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
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
            useraccessdomain.setDomainDescription("7B3OvBJMS6JB9hlwvOHk7sMXOMXl8t3M7MjN6vxGEZWVhZ3lJG");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainHelp("lgMWAFcLBV9tUFpiFwnj50VVbMlUXzdhQMVXUnfbDQGxfTM2Ts");
            useraccessdomain.setDomainIcon("WbgGm7JOIdJy3SufeYaho6sHs8u0v9QxwESfC9y4EbwbKoN9XV");
            useraccessdomain.setDomainName("YqJMCNtA3ldvXDNcnRSWoED2QkgZaoIksSxig7HBfr58oRxf4I");
            useraccessdomain.setUserAccessDomain(91664);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 134105));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "5rQ17tXnYlvJfgr9f9fXMTcsvLgLlnVMZMuwGSnZj1GNODpjgIHgYl1LETgHRcQHlD8AuTOYVQApih6ulb3E0kQvzcNadMOJwfEu2ZD5HDeWp4bs02qie6tmLIeMDTJwVZn9YkBAl471xAOmirfoldfupI9yFzZ15BuQyXZF97754B26gr0hQu4RUZo0ZCTeID4sE5cYoV952aLrfbS7SOE74smxJ03gzWnQwR3BRdY6wxRlOKQboXVRydK5wFjp1"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "zCJFa59QEytaK92bmyTqXz4BKHPGCFLlmWShDFqBm8laUObXjPq9JrK7EEirvCTqs3XYrXfqxX8qrLOhDbhhzgNVWRbdU5PlWOloll4DPstm37MycdZ4NQdvmShqSnqsyC61OiVWRfgZLZqrmBZvEZ7cAOnv0qPylxlxL05iAi4XaiqHMV8KR5rye4A0IsKIhUcM6R2nTUBGGeQOXlXS46H3ibpRYlBPGGu99CvMTeewlvk13Mr85lSws07WSKkIS"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "yF65vTByG1LK0HOvkYn1UkxKLJRh5TQUJMxQ65zh8kuR9671SGGSim4Nys21wrEQ0m9sUIZhBH2VWXCBXjfYk98HOMRuNxKxCEN3rE5gsswAXN0vpEmnAg0tULKhOsgQWqn7fi3GAv6urfOppPXPOmta05AdtxVwDv1o29rPQWIs7srOBqRVciETdIZpjUimUnnPQWYpzjWULZbV6tJVCg7w1aRyfGpi2BJ1DSY6fFTkUPCLzPN3O11u5eO4d4Vxm"));
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
