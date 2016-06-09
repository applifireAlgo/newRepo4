package com.app.server.businessservice.appinsight.health;
import com.app.server.businessservice.appbasicsetup.usermanagement.NotificationDomainService;
import com.app.server.businessservice.appinsight.EmpDateQBzService;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.appinsight.health.ADto;

@Component
public class TestSchduleEs {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EmpDateQBzService empDateQBzService;

    @Autowired
    private NotificationDomainService notificationDomainService;

    public void proTestSchduleEs(ADto aa) throws Exception {
        java.util.List<com.app.shared.appinsight.EmpDateQ> empDateQList = empDateQBzService.executeQueryEmpDateQ();
        for (com.app.shared.appinsight.EmpDateQ empDateQListElement : empDateQList) {
            if (aa.getaDay().equals(empDateQListElement.getdAY()) && aa.getaMonth().equals(empDateQListElement.getmONTH()) && aa.getaYear().equals(empDateQListElement.getyEAR())) {
                com.app.bean.EmailBean emailBean = new com.app.bean.EmailBean();
                emailBean.addRecipient("shweta.zagade@algorhythm.co.in");
                emailBean.setEmailBody("ddd");
                emailBean.setEmailSubject("Testing");
                notificationDomainService.sendMail(emailBean);
            }
        }
    }
}
