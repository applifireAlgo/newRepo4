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
        useraccessdomain.setDomainDescription("ego8ZAZ2sTdgruKluUX8hc7ylh2NWzj0yAFqWSj6312zNm9R89");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("YOvZauX40AikX92NSOgfIZ0Lvw40gvROlJQxq4jvDm2DN5N50U");
        useraccessdomain.setDomainIcon("fqVsuVm0QiEPXrjcSvDryck3QlQveMWhwgKqAl3FXlf2t3E7rR");
        useraccessdomain.setDomainHelp("zLf1elGHdgER8RhAtyDP1s3is18cGuZ8ntx7VWgLVPwoUcNFpq");
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
            useraccessdomain.setDomainDescription("3uEn8wo7bM0t5nHezKsvw08iTzb1E1bc6ytANir38zw9PUiuNq");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setUserAccessDomain(65057);
            useraccessdomain.setDomainName("1gUVAhRiIifzDWZl6ppxTTbZeDmCVIcfM9h9PThPfrSu8Z8J1M");
            useraccessdomain.setDomainIcon("4Fbkjnrgnp4hCfefPPu3xfqVucgBJ2ZS1R2K1tJgO0P5KSZOLM");
            useraccessdomain.setDomainHelp("rgeenGuRNBuFTq6Ue0VPaEEFtDGx0zzyCdIEjOcg5PB2jG1tah");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 184168));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "nb2l0s98ZCrcaujewnH0YbfuVn5H1RL1CXXjyKhQsVY9W7vO97NwuVqrCQKAiWhbbDL4g1wOK46CmCWs2BhEKPdmwHcGBZg2rxniYj17trfjv8j025Da4ZNgiHElqRRVu27H2tk9HnyP1xkdSh0XWsyQ2HgzfXlM7e3ePiZFFiuN48lIrj9JBvV1lNCk48qwYraU2kXoKuF5WJe3IFIao3qBBTTXtGpgaCitlBLFMvPEB4wzKjWpHxChhtxcW0FQD"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "xlD5CR3LxOrCDLHuZjgNQyOty55zEIfoPPUvj8qsHhfUknNxCvlRRqM4AShiSGeYMuKDod8wJRKNOG0uOjd7YXA3eoawsWjI2qYgIGwwuY4J7FR0TTEQiFVlmbCPqpvBDSqoTpNqz6U40nEPa68SyuFvsvYed5veCQfvmXoRhS6B2NM2vYkHDKJQtlwv3ToAl2tGXd8Bn6gID78Rs329K12tWW8Jl7WKPqiXrRdVHs2KuB0KDEEPLr8zv4pi2t3h2"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "V13ihjjPw235crWZ9WiXbYX51Z6dt0pMoS3Jf4LtNjFQDmp2lRW1U6y23g8Nlo57ByOuov2XLZA6RQSeEPpeGd0F9jDHhwLMtf22fZmYRgQBBsw6VSORCn0ck1AhL3xQ8JBxRPgmzFonNfXeYhTKppEN98Q5mXTiOo3VGsKRPQgl5QHpdc5irlCSXCXbxv5sJbyh7vKHU7oE8KfbsYru7gE0eHAGNjrSHC1mrNATy8Ma7amSvvyMmsIKWhFMrKPHB"));
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
