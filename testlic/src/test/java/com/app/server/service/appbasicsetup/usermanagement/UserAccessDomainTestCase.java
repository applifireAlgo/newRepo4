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
        useraccessdomain.setDomainDescription("ZJ8DP2io4eNcLA4sZzSdx7vSqFlZvXJaER2Uol0vNmJXvnD7UF");
        useraccessdomain.setDomainName("U5OE0EwVUy5MDVfKvyXWHl4puyAbf1RhzHYHpJlHVVFIaYwOLN");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("fCHB6YGFxGUwNEJLX6GgAMaX03bEt5UmjZ5XSCQWAMVfkay6fU");
        useraccessdomain.setDomainIcon("BlGO7Z7PdzcmwXJCztCTex2xMSaNezu9u9FGffx8acdfC6o6VE");
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
            useraccessdomain.setDomainDescription("8WMbvNASOaSjXAOXXb8zkOaj5bkcln8LPFkj2wQomImHlX9gCo");
            useraccessdomain.setDomainName("OlOUnpV2leBvxtYJQZu5uA8SCpmCWjTMNAPm0zzdKG2CY8MQEH");
            useraccessdomain.setUserAccessDomain(32529);
            useraccessdomain.setDomainHelp("IIjlsv2vg16QkRjjKRev2wcUGEOqZbY5iSD3jj4adUWn3Zni45");
            useraccessdomain.setDomainIcon("J3C88FlMOq0lfyOD2yiIlmF0vi9JNtuAH4iR2LcTNgipFjnLTU");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 132355));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "6Rjd33DwfLXRQTRfXtp1XvM5VZQkXbFv1feyxA1nMbTDs8jcANvz4J2ISzprA58l4bW2Hh8mzKFwu6VCeUGJqMjX8wv5za1penD3MyqQSeWvKmdjlTLGJok761UZoDBG9QXvmmmBmEUxLCGX7p619MGYmBj9vennwWVOSxcp4aTEuYoAPC20WEWlUd09oTMgQ59l0S7RMNlbS2ErooKRJTXjPhRCFY1HWaL7ISNASHIGv8RJLQDJJT7mFvBe1NElG"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "dXQslAapvRFtKOnVTUe35Vsg0OP1wQsAkJwycSqLOaU8y3Oisn9xJ8kIs9Y3RIxSMgKFYA5yr1yNs7qz9XErRDBM0nmr4vL32SSqb2FWhS6N0OAn9UDvfLfLWH5BB6kRxNefrhcDdnI9UG8swi94BujAZ8HfVPfGO3ag2yvNimrhamV1ZZnXxVJxj8PyBrm3ToyPYCJqsYzf1X6DenzDpI4jLkLlZzcLNUOWirggXV4frPZi6hHu89Jf6YBhKUd18"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "uO6jELRtASqSODTpUgJuc8OHM9kVurrj6dDtPxReTi29gR28OfjEG86YHWIXQx2xhVFFl3PE2JDsOTdXaQJ83EwuWcKBZ9mTKyDw7KtmiyF4iF1Nwtomfb50hp9XigtbnxL6R7qUIXk6NRL0Wgq6T1Vxhb1Ex80wep8mr6nGI2qwmZb1hsysSbuD4jUhbrrIASUzcamkEpP19lzLVp1W3XFAgtKqbC9b4EGyb6QuhDjCIcYrPr3Hm0ed89DWNhXhc"));
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
