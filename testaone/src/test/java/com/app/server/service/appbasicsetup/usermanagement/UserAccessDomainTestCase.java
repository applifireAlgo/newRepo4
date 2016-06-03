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
        useraccessdomain.setDomainDescription("m4uT2e3qcIBZK7kTP55E4b7WtnsrBP3NJ3fnq8HOthh3j8Au9u");
        useraccessdomain.setDomainName("aBQXTHFVSdAy8mN5LAEJbrXhIH3TlJc08k6QGENO6DcetiEUWY");
        useraccessdomain.setDomainHelp("zXMMewk3YQmBRND2J73I9j8vKp0XhscMhMz8e2LtplHJYuvdIm");
        useraccessdomain.setDomainIcon("zNPte71tpHQ2fMXjMqF7FqGjR2lwzko1bV3IDRVuS5XRY1ovRi");
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
            useraccessdomain.setDomainDescription("NGB5odBZsZMvfltr7yDbsaA1uJ8zHqVShS5WkBo6RlpK83MxJc");
            useraccessdomain.setDomainName("cDa791F6h43RmzxgS5CvguNMkZ8DnpO2PXuGVwB1bA6FeAJ5Y5");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainHelp("d41Pk1Due9UUM6Efz2h9GbglhA1yVaBJiNoCYtU1jKU6NGzXRv");
            useraccessdomain.setDomainIcon("KfQOMDCQRuNbgBYfhr14EIl3MWCHWOcn8FzmS2hQgvzywUEICx");
            useraccessdomain.setUserAccessDomain(67703);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 147443));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "B6aXP3glfsC106K1jlHSUDQIw48JT8TtmI5QRqFclFeQ0mZkd42HlfrDiQDgse2Oydj3py49QnQS7be2pG35T7VSn42ADXZYItYSN6xg0UgbrCEuknQMczKS3cm9DIYHoIUEdJr6pWywIMPH1HhL6rkZs7AIVNbsCGppCpzAwi2Hh9h4N4hgh5jqPdfhuWEa3omYkFP533M5SPX3ETTi2PRxkMKv1Gx9P1kbA6kix7HEmp4FFXQh1xOdBnEuCtg17"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "3a9Dc5HwMWwUQxFaaic7158ON80kirtXIqIfZ6mUl9rEv1yOzPj9N0FVmLNGGoqFAqHrYS2OuSP18mGiAHA2X7bMMtneNHj3wMXeaGssTjiePZHiPRpjIpBai209wp8k9lafZpRyTFgUDwC7t1QRARAtarEbPegIHcOPJgfSX0xkVG8O4Vzua0JvpK3RLyz6kIB7zjVSDwBVTyGtfWQ1LeJgrWyPG8i9BVli4Wdw5aT6uizcDKbH9GjK49t2p9PiN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "4A6yoYNH5ld1rIhymlgm9egVmij2eXMDd90y0Ysdu1oYkpFRVoq8u2bO99RiimEnNjlTUWPpsppElN6660am2c3MdJE5vdkvDL94ztQSPnnPMq5xMyqxKGP4rbTM2LK9inId8qUEiMRMm8pr7z4ubrLZDmViyHCjafd76HnVLiFCVHI00q4NbbDhCFZbQFfew9TkOt7SeSXZS1ecDwz5LBDf5gPlh2GXqeb5XSPVPiW4dP1HpfMGo4yCo8tdSrjQP"));
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
