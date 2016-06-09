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
import com.app.server.repository.appinsight.health.TtwoRepository;
import com.app.shared.appinsight.health.Ttwo;
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
import com.app.shared.appinsight.health.Tone;
import com.app.server.repository.appinsight.health.ToneRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TtwoTestCase extends EntityTestCriteria {

    @Autowired
    private TtwoRepository<Ttwo> ttwoRepository;

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

    private Ttwo createTtwo(Boolean isSave) throws Exception {
        Tone tone = new Tone();
        tone.setTonenm("1b9ol85AfSZNOJciD3kEgBo8EdP8wAOw0dc7D6B2BwZTdKAgGa");
        Tone ToneTest = new Tone();
        if (isSave) {
            ToneTest = toneRepository.save(tone);
            map.put("TonePrimaryKey", tone._getPrimarykey());
        }
        Ttwo ttwo = new Ttwo();
        ttwo.setTonenm((java.lang.String) ToneTest._getPrimarykey());
        ttwo.setTwonm("YNct1xWMo9iCiLjC4Fl45aknLhdudiiiwg1CNHVoBfrdOa8bIz");
        ttwo.setEntityValidator(entityValidator);
        return ttwo;
    }

    @Test
    public void test1Save() {
        try {
            Ttwo ttwo = createTtwo(true);
            ttwo.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            ttwo.isValid();
            ttwoRepository.save(ttwo);
            map.put("TtwoPrimaryKey", ttwo._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private ToneRepository<Tone> toneRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TtwoPrimaryKey"));
            Ttwo ttwo = ttwoRepository.findById((java.lang.String) map.get("TtwoPrimaryKey"));
            ttwo.setVersionId(1);
            ttwo.setTwonm("GqtEiRgvtqmjeziZdTf8XZzMsqjuepMfHzvLFwjXtETLU5Fw4A");
            ttwo.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            ttwoRepository.update(ttwo);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TtwoPrimaryKey"));
            ttwoRepository.findById((java.lang.String) map.get("TtwoPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytonenm() {
        try {
            java.util.List<Ttwo> listoftonenm = ttwoRepository.findByTonenm((java.lang.String) map.get("TonePrimaryKey"));
            if (listoftonenm.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TtwoPrimaryKey"));
            ttwoRepository.delete((java.lang.String) map.get("TtwoPrimaryKey")); /* Deleting refrenced data */
            toneRepository.delete((java.lang.String) map.get("TonePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTtwo(EntityTestCriteria contraints, Ttwo ttwo) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            ttwo.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            ttwo.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            ttwo.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            ttwoRepository.save(ttwo);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "twonm", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "twonm", "uuQ3bcskeIhowKkIPhibdt0Fln1z32NC8sZJA7bfn6UWypsFsUhWch3eZsxoIP7PBdIEAroCN8QhTkTr1NWlMVAVRBYlZKGA2EVEZPeDFH0DjEVmJUThj0FTU1e1CpOyIzgpdPKFb1DYoZuuqXYv9YbIXregAPQxMrTQVCtd0ZBK9tulFQx95SK4gOAObKIiQsH84uEP9FjGaWKhlL4pygfQWzHTRSXpBfgmrk8fUA7MXKS65VAujtTdM5tP996ko"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Ttwo ttwo = createTtwo(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = ttwo.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(ttwo, null);
                        validateTtwo(contraints, ttwo);
                        failureCount++;
                        break;
                    case 2:
                        ttwo.setTwonm(contraints.getNegativeValue().toString());
                        validateTtwo(contraints, ttwo);
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
