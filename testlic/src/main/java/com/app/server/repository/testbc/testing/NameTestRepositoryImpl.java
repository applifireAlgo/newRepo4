package com.app.server.repository.testbc.testing;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.testbc.testing.NameTest;
import org.springframework.stereotype.Repository;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SourceCodeAuthorClass(createdBy = "shweta.zagade1209@gmail.com", updatedBy = "", versionNumber = "1", comments = "Repository for NameTest Master table Entity", complexity = Complexity.LOW)
public class NameTestRepositoryImpl extends SearchInterfaceImpl implements NameTestRepository<NameTest> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<NameTest> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.testbc.testing.NameTest> query = emanager.createQuery("select u from NameTest u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("AASAS324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "NameTestRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public NameTest save(NameTest entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("AASAS322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "NameTestRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<NameTest> save(List<NameTest> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.testbc.testing.NameTest obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("AASAS322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "NameTestRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.testbc.testing.NameTest s = emanager.find(com.app.shared.testbc.testing.NameTest.class, id);
        emanager.remove(s);
        Log.out.println("AASAS328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "NameTestRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(NameTest entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("AASAS321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "NameTestRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<NameTest> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.testbc.testing.NameTest obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("AASAS321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "NameTestRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public NameTest findById(String tsid) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("NameTest.findById");
        query.setParameter("tsid", tsid);
        com.app.shared.testbc.testing.NameTest listOfNameTest = (com.app.shared.testbc.testing.NameTest) query.getSingleResult();
        Log.out.println("AASAS324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "NameTestRepositoryImpl", "findById", "Total Records Fetched = " + listOfNameTest);
        return listOfNameTest;
    }
}
