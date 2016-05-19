package com.app.server.service.organization.locationmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.locationmanagement.Language;
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
public class LanguageTestCase extends EntityTestCriteria {

    @Autowired
    private LanguageRepository<Language> languageRepository;

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

    private Language createLanguage(Boolean isSave) throws Exception {
        Language language = new Language();
        language.setAlpha3("yZ6");
        language.setAlpha4("jB5a");
        language.setAlpha4parentid(6);
        language.setLanguageIcon("xAXHtD6JA2nFxkQGEAqTuAIe6Pe9kYt0IrtO8SFyyohLEi6yEY");
        language.setAlpha2("S9");
        language.setLanguage("tZvAojk7L65jW4I2fRJtGcEFmMo3m5VJvXFupzZmyjRb1onp1H");
        language.setLanguageType("yPpHpR5Gk45nBwQsN3hCSpEKUSAAXPzc");
        language.setLanguageDescription("NqalJ7YYYBB7Jc9WlxQJBfZ4fpUHLFfrIa1Ar7RYzArwcMWmU3");
        language.setEntityValidator(entityValidator);
        return language;
    }

    @Test
    public void test1Save() {
        try {
            Language language = createLanguage(true);
            language.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            language.isValid();
            languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LanguagePrimaryKey"));
            Language language = languageRepository.findById((java.lang.String) map.get("LanguagePrimaryKey"));
            language.setAlpha3("fkb");
            language.setAlpha4("wZ0E");
            language.setVersionId(1);
            language.setAlpha4parentid(3);
            language.setLanguageIcon("IpfHvtEUkOUaDzfo0h1yG3hwq1Oq2DuBaRR890prsCMaPYxPBG");
            language.setAlpha2("Sz");
            language.setLanguage("wzWVHg2hwYM6mLlo8ENif45XeOE8z7pWDpLlvvITWQDlo6Ak3u");
            language.setLanguageType("A7V2YCgsfEPAOwBFxdw5tzOh3gRpP7Oe");
            language.setLanguageDescription("c2sIBtFPkECfqaQleETQayCGKNCQe8kAth2Nn1JFzEulHtymRM");
            language.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            languageRepository.update(language);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LanguagePrimaryKey"));
            languageRepository.findById((java.lang.String) map.get("LanguagePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LanguagePrimaryKey"));
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLanguage(EntityTestCriteria contraints, Language language) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            language.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            language.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            language.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            languageRepository.save(language);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "language", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "language", "rOHpQhMxyJaFXHCo0Y7zuU6gLPNwFe8tZoqhiuzvi3yDtMRt6wLlj1YkAx9wjhnygROdZ87XRldDT1CU5lWoMCqLvS0NeYBWCXdUjqmYkJJkpIySG7vqXq5vextbFUWNolIeoaP47BppLwFLSDssqxHbow2fQn82btTce2TBJQ8XjRJY7uEFDP8NBzm7VJVKCBgGtG1gBxS7LxHlAoqaIt2GovE6i9KlqXIBQR0Ja8eertb6oSQ6YTGw1bQojFeck"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "languageType", "neXpMa9xafnjilcIRLipGnFZRfqnNQvfd"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "languageDescription", "4rqlZqcQhLACsLdN6LxFUnZrcu0tsnbz7qlCVeEa7xspus6iGF6iDutA6n8xFEd7WVuckRSZeaBo9UwjXSW1oY81tMhNYp2lFoz6kR1XT7xDHZZx6NS6JR79BoX3Z2O8PRVa92ASgW1cZrI22yUu39zE18VBuNGY9lG2AIDkNWNuiqE87nmIsanaRpphFKPoifQqJTZ3Oblgp2vYcR40AMithcXnqzszvuIBgRvZUY1mGNCjbM8aCTfBrYTRkMgFO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "languageIcon", "dNwihsDPP1K4XRvzZPaKykgqGfAvj6xrKjhGfjczfExkCS1Nf31AtsfbHkqeKrlBxToxekkXPnVcUYuYjpmo7GQpgGbl9f7pjxyfgQf6AOzAKGEdGi3LgGMsvpkcHhVed"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "alpha2", "3uV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "alpha3", "CUcv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "alpha4", "5U7Kf"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "alpha4parentid", 22));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Language language = createLanguage(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = language.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(language, null);
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 2:
                        language.setLanguage(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 3:
                        language.setLanguageType(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 4:
                        language.setLanguageDescription(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 5:
                        language.setLanguageIcon(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 6:
                        language.setAlpha2(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 7:
                        language.setAlpha3(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 8:
                        language.setAlpha4(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 9:
                        language.setAlpha4parentid(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLanguage(contraints, language);
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
