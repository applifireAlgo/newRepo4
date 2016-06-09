package com.app.server.businessservice.appinsight.health;
import com.app.server.businessservice.appinsight.ToneQBzService;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.appinsight.ToneQ;
import com.app.shared.appinsight.health.ADto;
import com.spartan.pluggable.exception.layers.ds.BusinessRuleUnableToProceedException;
import java.util.List;

@Component
public class TestOneDs {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private ToneQBzService toneQBzService;

    public List<ToneQ> proTestOneDs(ADto aa) throws BusinessRuleUnableToProceedException, Exception {
        java.util.List<com.app.shared.appinsight.ToneQ> toneQList = toneQBzService.executeQueryToneQ(aa.getTno());
        for (com.app.shared.appinsight.ToneQ toneQListElement : toneQList) {
            return toneQList;
        }
        throw new com.spartan.pluggable.exception.layers.ds.BusinessRuleUnableToProceedException();
    }
}
