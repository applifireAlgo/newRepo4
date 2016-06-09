package com.app.server.businessservice.appinsight.health;
import com.app.server.businessservice.appbasicsetup.usermanagement.NotificationDomainService;
import com.app.server.businessservice.appinsight.EmpNewQBzService;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.appinsight.health.EmpDto;
import com.spartan.pluggable.exception.layers.ds.BusinessRuleInterruptedException;

@Component
public class EmpScDs {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private NotificationDomainService notificationDomainService;

    @Autowired
    private EmpNewQBzService empNewQBzService;

    public void proEmpScDs(EmpDto ss) throws BusinessRuleInterruptedException, Exception {
        java.util.List<com.app.shared.appinsight.EmpNewQ> empNewQList = empNewQBzService.executeQueryEmpNewQ();
        for (com.app.shared.appinsight.EmpNewQ empNewQListElement1 : empNewQList) {
            if (!ss.getAday().equals(empNewQListElement1.getDtDay()) && !ss.getaMonth().equals(empNewQListElement1.getDtMonth()) && !ss.getaYear().equals(empNewQListElement1.getDtYear())) {
                throw new com.spartan.pluggable.exception.layers.ds.BusinessRuleInterruptedException();
            }
            com.app.bean.EmailBean emailBean = new com.app.bean.EmailBean();
            emailBean.addRecipient("shweta.zagade@algorhythm.co.in");
            emailBean.setEmailBody("sss");
            emailBean.setEmailSubject("Hiiiiiiii");
            notificationDomainService.sendMail(emailBean);
        }
    }
}
