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
import com.app.server.repository.appinsight.health.CategoryRepository;
import com.app.shared.appinsight.health.Category;
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
import com.app.shared.appinsight.health.Brands;
import com.app.server.repository.appinsight.health.BrandsRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CategoryTestCase extends EntityTestCriteria {

    @Autowired
    private CategoryRepository<Category> categoryRepository;

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

    private Category createCategory(Boolean isSave) throws Exception {
        Brands brands = new Brands();
        brands.setBrandNm("WCsxKT6eaOrardrqF6EGd0OaD7tJxgWHE76IAJbVYv4l8la2w6");
        Brands BrandsTest = new Brands();
        if (isSave) {
            BrandsTest = brandsRepository.save(brands);
            map.put("BrandsPrimaryKey", brands._getPrimarykey());
        }
        Category category = new Category();
        category.setBrandnm((java.lang.String) BrandsTest._getPrimarykey());
        category.setCategorynm("FkHQvuJnbPKtmwI4rJzdxCexqkPf4SzNFeGr7wEIboyDdPvj3L");
        category.setEntityValidator(entityValidator);
        return category;
    }

    @Test
    public void test1Save() {
        try {
            Category category = createCategory(true);
            category.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            category.isValid();
            categoryRepository.save(category);
            map.put("CategoryPrimaryKey", category._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private BrandsRepository<Brands> brandsRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CategoryPrimaryKey"));
            Category category = categoryRepository.findById((java.lang.String) map.get("CategoryPrimaryKey"));
            category.setCategorynm("bkNPK2dpC5a1Fa9JQQrdXLzhiDxGXP9MAC81SJQqGhRi3WjaTy");
            category.setVersionId(1);
            category.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            categoryRepository.update(category);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBybrandnm() {
        try {
            java.util.List<Category> listofbrandnm = categoryRepository.findByBrandnm((java.lang.String) map.get("BrandsPrimaryKey"));
            if (listofbrandnm.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CategoryPrimaryKey"));
            categoryRepository.findById((java.lang.String) map.get("CategoryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CategoryPrimaryKey"));
            categoryRepository.delete((java.lang.String) map.get("CategoryPrimaryKey")); /* Deleting refrenced data */
            brandsRepository.delete((java.lang.String) map.get("BrandsPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCategory(EntityTestCriteria contraints, Category category) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            category.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            category.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            category.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            categoryRepository.save(category);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "categorynm", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "categorynm", "O3G97k8TwUbLD5CaojBrwIgpD84SU4q7HhkI31q14Q2u2uSiE9K3JqDMDpOQFiVGZOPrdcJjKMaMvFwpznqj5svPyVRGGBmVWUiOZe37AfsOnnM3eRK7xMyfNx89D3sordQIsuUx3QZKbrFWoLOWjtivtkDJLdXnDa3magHLIZ0vx3jAV3t5t1CTClQKk3J2DwXTRK6Xggx8Sf6De2Urpgnv7Mr1qj2jsn2RB79NeA1CAQdfoZhT928bfpZShCv2O"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Category category = createCategory(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = category.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(category, null);
                        validateCategory(contraints, category);
                        failureCount++;
                        break;
                    case 2:
                        category.setCategorynm(contraints.getNegativeValue().toString());
                        validateCategory(contraints, category);
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
