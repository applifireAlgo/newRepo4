package com.app.server.service.appinsight.health;
import com.app.server.businessservice.appinsight.health.TestSchduleEs;
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
@RequestMapping("/TestSchduleEsWS")
public class TestSchduleEsWS {

    @Autowired
    private TestSchduleEs testschdulees;

    @RequestMapping(value = "/proTestSchduleEs", consumes = "application/json", method = RequestMethod.POST)
    public HttpEntity<ResponseBean> proTestSchduleEs(@RequestBody ADto aa) throws Exception {
        com.athena.server.pluggable.utils.bean.ResponseBean responseBean = new com.athena.server.pluggable.utils.bean.ResponseBean();
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
        testschdulees.proTestSchduleEs(aa);
        responseBean.add("success", true);
        responseBean.add("message", "Successfully executed ");
        return new org.springframework.http.ResponseEntity<com.athena.server.pluggable.utils.bean.ResponseBean>(responseBean, httpStatus);
    }
}
