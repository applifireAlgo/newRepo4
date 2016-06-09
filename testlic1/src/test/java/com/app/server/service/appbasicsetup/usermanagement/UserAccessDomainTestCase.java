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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws Exception {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("DwejeUeXOIG18nYtpnW7jmXlfZndxmdqQMVmXcvVIpN2Z34E5S");
        useraccessdomain.setDomainHelp("oBiOU3HVlLlkcElsfSPpfK9cKMPuv8FOFDN4lN33M9gFMHm6kl");
        useraccessdomain.setDomainName("SOrgXHpfid1B1fNEJXjWTpb8HSFklCboqCAiEsx95lIv3nHIGq");
        useraccessdomain.setDomainDescription("oCzoDz1ZKMe2RqRQUOCEBavBjvI25jswtV535uKNpklqParqCv");
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
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainIcon("lfKGj1mmuuujAvBGlAtzhnHdWOS2iWsReUP8sEv27kgdoGbrCQ");
            useraccessdomain.setDomainHelp("Qr3W7xrhbmEPB25xkpo2uLLpQuapezX7hZuN6tv1uUa2HRv9Cj");
            useraccessdomain.setDomainName("NkvqRfJtnbk9IXtmvd9v9lW0HIn5my1EaefPtHPwSS0ff21EJZ");
            useraccessdomain.setDomainDescription("s5hXKsfOqiGWDso3H4R95XZLgdMaXdQWo6Rs23pVgM37mZ8fvg");
            useraccessdomain.setUserAccessDomain(35980);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 171482));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "m37nRkmTVmaaTH3IAIkHXyxsH9yl3GjQASNtjjaC3IDuB9hAGEbfMHu0TKc1hz1cUuJobhFWCGARe7qJq1PuL49e6WUz9emcIu38oEDZMioj9n7V2hBeMQMtedr0EXmX3k8BpWqJ4nTMLY0MA8SSA9NUxVsPgpobS04yjiouSloM7EV4bmn68oWdV272LxWx0oMq79dOr653rKkqhxvOvTBEoOJYANC6ZsPfFBCZdGv2YWxOkNA6YpSvfQk79DVAL"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "Iwfd08AURBYLZ3kQaDmJwO7X4Erma6LX38H0PJ2gEH3Ys3mWVbQOV15uzdSnWjHlHZs9yK4xzqBYOvkIfO7Et1rrLpeGbrv1LiCTLoNQLVw3m0C2AFcXTM4FhN7xWY5GhuUvV10kL74qPHH9ZAe5gKGHtbsApTFkDaxPG4VdfJ1SMwbLrONybgJtEQGfrwVtmUPaHQvnW5m4Au6iipbz1CiNrRUICOjr270OKF6sdEHJ0XPk150LPE9hsrURj4NlW"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "eTP13aVJPOMYZ4lhRrkbAPj7KYGdxFHyqbQTTIoauPFj6HMcHrHisPY1LzesL63DPR1yncNOtSaYOTDBNEh2E2jq8EmJYHqzG1rmeJmpf9mIRwiNe3m601kZHFJhzL6901p48PZy8o5z8irrIW5BkOPz9ZeE9VZfpMSIRKs7pviF2TSavOcUfLnPGCQYP3tknidq3rUFi55oFmPrD8Y2g4D9YyeZ2Emp3vjXmlCfsXri3P0uhSl39kZOeAkDPxI2I"));
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
