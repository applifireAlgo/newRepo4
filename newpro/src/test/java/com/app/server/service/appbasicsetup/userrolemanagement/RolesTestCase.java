package com.app.server.service.appbasicsetup.userrolemanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.userrolemanagement.RolesRepository;
import com.app.shared.appbasicsetup.userrolemanagement.Roles;
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
import com.app.shared.appbasicsetup.userrolemanagement.RoleMenuBridge;
import com.app.shared.appbasicsetup.userrolemanagement.AppMenus;
import com.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase extends EntityTestCriteria {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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

    private Roles createRoles(Boolean isSave) throws Exception {
        Roles roles = new Roles();
        roles.setRoleIcon("O6edrl0KXfDroVWgjuWUp6e6faAUq057WiBQXn35lnKMAQaZlM");
        roles.setRoleDescription("aYTsF1ICGH0nAFfeJisay5ngITihF5yN6Oncx4mGiqtOKrFFxE");
        roles.setRoleHelp("5Klex8vTNGrSWZkXgG6ZklDWZ0RvNmkyq4VUuwhyu5B5kfwqvM");
        roles.setRoleName("Lw8nBsxO5eEzdd8Hg9kXWPE5VW2aYVfPsm3PCLNKp3US8qzBYI");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuHead(true);
        appmenus.setMenuDisplay(true);
        appmenus.setUiType("tpY");
        appmenus.setMenuAccessRights(10);
        appmenus.setMenuLabel("VqszBj3svXhu9B6oP03mHA8PWafoZxknlvfm13dzHN0mhun3o1");
        appmenus.setMenuAction("h0GSVmxreFXUOINo4msFRJkBmKp0KZhB4Ea6E31Og5uQUGZtZS");
        appmenus.setAutoSave(true);
        appmenus.setAppType(2);
        appmenus.setMenuCommands("8AiFYMN6vrc3JOyYNqaUIGSuEfvrlwYYtWIATXyWjdJHdqpOQD");
        appmenus.setMenuTreeId("gOHwIZcLn7J4cKGcWuL1x3SipqAoaDHZyJCZlWo6q6Uf7yKXBs");
        appmenus.setRefObjectId("BmMU4wGDq97nmH94BO52c6aEfJiqInD4jvxtlVeScUo9SFpG90");
        appmenus.setAppId("iFS9qLGsBGQap6H4um6OkW9GlwBpgXjAfbHLFUAxuSdZp4abQD");
        appmenus.setMenuIcon("JRQjn96d5geV6cAThwJQxyAGItXIzN3jyDjYBTm3MAUJvmvuaz");
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setRoles(roles);
        rolemenubridge.setIsRead(true);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsWrite(true);
        listOfRoleMenuBridge.add(rolemenubridge);
        roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
        roles.setEntityValidator(entityValidator);
        return roles;
    }

    @Test
    public void test1Save() {
        try {
            Roles roles = createRoles(true);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleIcon("k7GfrcrAB8tEXVzEGqu7nrRk8my5iqXkunKnr0CSbX9YiDJ1Gi");
            roles.setVersionId(1);
            roles.setRoleDescription("a8Z8A0aR1AhF00suUf8Y5BIa74w17gC78Lw3DSvwL2ygRWRstm");
            roles.setRoleHelp("AHSGAwJZGaQGuRp2Mxd0ENdlo9xund77TtUvQ7wiZrSURI70Vs");
            roles.setRoleName("SN1vMQDhst4q6d5egjBpw212DKyI5rAtX1ilXIA84whzrdLrqg");
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoles(EntityTestCriteria contraints, Roles roles) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            roles.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roles.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            roles.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            rolesRepository.save(roles);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "RoleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "2FznhJlDziE9jxW59n8Q4m0BYLbylWwBkj13gn3eLSY9ePtsbtYW8iY6qXjJpTgsXKLr4ICjStsXlqKAZ96BgAatytyOAcQve5oFQ2B8NahLS5zJ57SNPlUwswaqh3PmWQVdRQKi6V52e535zjpHvo9Ad5ebkkJL8S00pj1q3eFzjzRDRaWOiov2HeRgeHgu9nWMKtEK9OArJWdmkLv4w8Qk6JvBBTrDy3o6Hw7vSCjTsyb9zI09A3n46XH56pNWp"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "JYSzpnUPu4V8w11MxFM6p68jhU7vadZfQhKi4wrYlElZWLs9F3JXEE74z6Yn1DW5LGVd3S5yVQOS2OOH7WYr0hr5DyqNJGH3G7jGrIkuhEQ5fmVo6pU4tB8dE9J1GPCnn9Iud2RSiNLYMgKlQyl9Zk719pel3AU8mTpZ9nAD6q4iNYfxlssGy4YkgPWsidrUR9LkBnGAwDrkkIRAeIHwtCmhiYy1NeuyyY404QzKyLngqBqPWedFY6bM4QtuV907U"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "hWD1pdi6TvnzF9NbtQ1jFHwuyLw2JP3PxiPbnWKjh6vJeI3EQr0nP8i4Fiv1aKvMo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "2nxjGv8OmYZKRanVJ3H2AzpvFoZd0vEzqrGI3D0fxh4Vq9kNdAJZTEulszKAjbpXRwuTBknLMuqkzBldGqf6dJsEYzshzn6YfnxTUGP02qjm6mq0LufXuNfADz59ShDZ9h9VOdhjcqVmb77pFxYcPfZeot6OEisezTIuHG2nNXXY615iP93eu8FhFvVelI7EAtS22Bv25suyZBjnWXy7sdNOF8wn1kIkCQ1HZXeFCXIYmk8XzvNv5CGi3ylXcrzfs"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Roles roles = createRoles(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = roles.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 2:
                        roles.setRoleName(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 4:
                        roles.setRoleDescription(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 5:
                        roles.setRoleIcon(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 6:
                        roles.setRoleHelp(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
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
