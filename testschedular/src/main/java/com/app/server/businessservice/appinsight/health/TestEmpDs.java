package com.app.server.businessservice.appinsight.health;
import com.app.server.repository.appinsight.health.EmpRepository;
import com.app.shared.appinsight.health.Emp;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestEmpDs {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EmpRepository<Emp> empRepository;

    public void proTestEmpDs(Emp entity) throws Exception {
        entity.setEmpName("sona");
        empRepository.update(entity);
    }
}
