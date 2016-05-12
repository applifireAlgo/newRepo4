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
import com.app.server.repository.appinsight.health.ItemRepository;
import com.app.shared.appinsight.health.Item;
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
import com.app.shared.appinsight.health.Category;
import com.app.server.repository.appinsight.health.CategoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class ItemTestCase extends EntityTestCriteria {

    @Autowired
    private ItemRepository<Item> itemRepository;

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

    private Item createItem(Boolean isSave) throws Exception {
        Brands brands = new Brands();
        brands.setBrandNm("NaPxGQleeNBVizzkVJgHN1eovQiWQndoellQ0jfQKpuEWpu6jm");
        Brands BrandsTest = new Brands();
        if (isSave) {
            BrandsTest = brandsRepository.save(brands);
            map.put("BrandsPrimaryKey", brands._getPrimarykey());
        }
        Category category = new Category();
        category.setBrandnm((java.lang.String) BrandsTest._getPrimarykey()); /* ******Adding refrenced table data */
        category.setCategorynm("saziMzCoB9rFgANn5OfSrxQomfxTWH38uqdgqa4MJXcccsD3TU");
        Category CategoryTest = new Category();
        if (isSave) {
            CategoryTest = categoryRepository.save(category);
            map.put("CategoryPrimaryKey", category._getPrimarykey());
        }
        Item item = new Item();
        item.setBrandnm((java.lang.String) BrandsTest._getPrimarykey()); /* ******Adding refrenced table data */
        item.setCategorynm((java.lang.String) CategoryTest._getPrimarykey());
        item.setItemname("kHGJ1eSFjXSYUiOpgO6bULM5Kzklqg2Ui2U3YVhDQ5NC5pBEAC");
        item.setEntityValidator(entityValidator);
        return item;
    }

    @Test
    public void test1Save() {
        try {
            Item item = createItem(true);
            item.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            item.isValid();
            itemRepository.save(item);
            map.put("ItemPrimaryKey", item._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private BrandsRepository<Brands> brandsRepository;

    @Autowired
    private CategoryRepository<Category> categoryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("ItemPrimaryKey"));
            Item item = itemRepository.findById((java.lang.String) map.get("ItemPrimaryKey"));
            item.setVersionId(1);
            item.setItemname("kFvD27Lg95F4cKYdAPnlYzW29yApP687rZnc2Lxn75ADHxf3lW");
            item.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            itemRepository.update(item);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ItemPrimaryKey"));
            itemRepository.findById((java.lang.String) map.get("ItemPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBybrandnm() {
        try {
            java.util.List<Item> listofbrandnm = itemRepository.findByBrandnm((java.lang.String) map.get("BrandsPrimaryKey"));
            if (listofbrandnm.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycategorynm() {
        try {
            java.util.List<Item> listofcategorynm = itemRepository.findByCategorynm((java.lang.String) map.get("CategoryPrimaryKey"));
            if (listofcategorynm.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQNamedItemQ() {
        try {
            itemRepository.NamedItemQ();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ItemPrimaryKey"));
            itemRepository.delete((java.lang.String) map.get("ItemPrimaryKey")); /* Deleting refrenced data */
            categoryRepository.delete((java.lang.String) map.get("CategoryPrimaryKey")); /* Deleting refrenced data */
            brandsRepository.delete((java.lang.String) map.get("BrandsPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateItem(EntityTestCriteria contraints, Item item) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            item.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            item.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            item.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            itemRepository.save(item);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "itemname", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "itemname", "fOc2fXEVAcmPfVhfjBMn5B5dM7Rrpd0QAgbrGnxg2Z9QEzADXa0akry4WbLNDffsG55aLM3uWliFUog2n2H3gHaNSqdmorZvjHftvKFJWWTOTM4ZIQbgxoaFaGH6x7dUveFC9CqtkI5FIbxpGjgfjrrovTAarLfSnsoPTfKnKzAU4U8iE6Zz1gryO0OFctGsXR6mO8Q1TS2ngyHBTGmJMThUJpLf3EetT03ZDvfqdgXCNFVsiYFJs5CrZA069xKGr"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Item item = createItem(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = item.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(item, null);
                        validateItem(contraints, item);
                        failureCount++;
                        break;
                    case 2:
                        item.setItemname(contraints.getNegativeValue().toString());
                        validateItem(contraints, item);
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
