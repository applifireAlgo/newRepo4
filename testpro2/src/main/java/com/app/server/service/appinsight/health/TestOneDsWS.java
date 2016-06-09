package com.app.server.service.appinsight.health;
import com.app.server.businessservice.appinsight.health.TestOneDs;
import com.app.shared.appinsight.health.ADto;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequestMapping("/TestOneDsWS")
public class TestOneDsWS {

    @Autowired
    private TestOneDs testoneds;

    @RequestMapping(value = "/proTestOneDs", consumes = "application/json", method = RequestMethod.POST)
    public HttpEntity<ResponseBean> proTestOneDs(@RequestBody ADto aa) throws Exception {
        com.athena.server.pluggable.utils.bean.ResponseBean responseBean = new com.athena.server.pluggable.utils.bean.ResponseBean();
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
        java.util.List<com.app.shared.appinsight.ToneQ> _ruleOutput = testoneds.proTestOneDs(aa);
        responseBean.add("success", true);
        responseBean.add("message", "Successfully executed ");
        responseBean.add("data", _ruleOutput);
        return new org.springframework.http.ResponseEntity<com.athena.server.pluggable.utils.bean.ResponseBean>(responseBean, httpStatus);
    }
}
