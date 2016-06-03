package com.app.server.repository.testbc.testingdomain;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.testbc.testingdomain.Stud;
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
@SourceCodeAuthorClass(createdBy = "shweta.zagade@algorhythm.co.in", updatedBy = "shweta.zagade@algorhythm.co.in", versionNumber = "2", comments = "Repository for Stud Master table Entity", complexity = Complexity.LOW)
public class StudRepositoryImpl extends SearchInterfaceImpl implements StudRepository<Stud> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<Stud> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.testbc.testingdomain.Stud> query = emanager.createQuery("select u from Stud u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("ASSSS324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "StudRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public Stud save(Stud entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("ASSSS322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "StudRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<Stud> save(List<Stud> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.testbc.testingdomain.Stud obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("ASSSS322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "StudRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.testbc.testingdomain.Stud s = emanager.find(com.app.shared.testbc.testingdomain.Stud.class, id);
        emanager.remove(s);
        Log.out.println("ASSSS328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "StudRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(Stud entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("ASSSS321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "StudRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<Stud> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.testbc.testingdomain.Stud obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("ASSSS321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "StudRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public Stud findById(String sid) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Stud.findById");
        query.setParameter("sid", sid);
        com.app.shared.testbc.testingdomain.Stud listOfStud = (com.app.shared.testbc.testingdomain.Stud) query.getSingleResult();
        Log.out.println("ASSSS324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "StudRepositoryImpl", "findById", "Total Records Fetched = " + listOfStud);
        return listOfStud;
    }
}
