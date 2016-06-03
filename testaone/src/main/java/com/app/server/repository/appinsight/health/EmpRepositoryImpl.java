package com.app.server.repository.appinsight.health;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.appinsight.health.Emp;
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
@SourceCodeAuthorClass(createdBy = "shweta.zagade@algorhythm.co.in", updatedBy = "shweta.zagade@algorhythm.co.in", versionNumber = "2", comments = "Repository for Emp Master table Entity", complexity = Complexity.LOW)
public class EmpRepositoryImpl extends SearchInterfaceImpl implements EmpRepository<Emp> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<Emp> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.appinsight.health.Emp> query = emanager.createQuery("select u from Emp u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("AISHI324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EmpRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public Emp save(Emp entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("AISHI322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EmpRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<Emp> save(List<Emp> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.appinsight.health.Emp obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("AISHI322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EmpRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.appinsight.health.Emp s = emanager.find(com.app.shared.appinsight.health.Emp.class, id);
        emanager.remove(s);
        Log.out.println("AISHI328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EmpRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(Emp entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("AISHI321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EmpRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<Emp> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.appinsight.health.Emp obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("AISHI321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EmpRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public Emp findById(String empId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Emp.findById");
        query.setParameter("empId", empId);
        com.app.shared.appinsight.health.Emp listOfEmp = (com.app.shared.appinsight.health.Emp) query.getSingleResult();
        Log.out.println("AISHI324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EmpRepositoryImpl", "findById", "Total Records Fetched = " + listOfEmp);
        return listOfEmp;
    }
}
