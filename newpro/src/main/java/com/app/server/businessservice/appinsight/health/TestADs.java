package com.app.server.businessservice.appinsight.health;
import com.app.server.repository.appinsight.health.TestARepository;
import com.app.shared.appinsight.health.TestA;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestADs {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private TestARepository<TestA> testARepository;

    public void proTestADs(TestA entity) throws Exception {
        entity.setaDate(new java.sql.Timestamp(java.lang.System.currentTimeMillis()));
        entity.setAnm("SS");
        entity.setAno(4);
        testARepository.update(entity);
    }
}
