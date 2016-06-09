package com.app.server.businessservice.testbc.testing;
import com.app.server.businessservice.appbasicsetup.usermanagement.NotificationDomainService;
import com.app.server.businessservice.testbc.NmQBzService;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.customexceptions.InvalidName;
import com.app.shared.testbc.testing.TestNmDto;

@Component
public class NameDs {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private NmQBzService nmQBzService;

    @Autowired
    private NotificationDomainService notificationDomainService;

    public void proNameDs(TestNmDto ss) throws InvalidName, Exception {
        java.util.List<com.app.shared.testbc.NmQ> nmQList = nmQBzService.executeQueryNmQ(ss.getaNo());
        for (com.app.shared.testbc.NmQ nmQListElement : nmQList) {
            if (!nmQListElement.getsName().equals(ss.getaName())) {
                throw new com.app.customexceptions.InvalidName("InvalidName", "AASAS227302406", null);
            }
            com.app.bean.EmailBean emailBean = new com.app.bean.EmailBean();
            emailBean.addRecipient("shweta.zagade@algorhythm.co.in");
            emailBean.setEmailBody("hello");
            emailBean.setEmailSubject("Hi");
            notificationDomainService.sendMail(emailBean);
        }
    }
}
