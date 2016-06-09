package com.app.server.businessservice.testbc.testingdomain;
import com.app.server.businessservice.appbasicsetup.usermanagement.NotificationDomainService;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.customexceptions.NameInvalid;
import com.app.shared.testbc.testingdomain.Stud;

@Component
public class StudDs {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private NotificationDomainService notificationDomainService;

    public void proStudDs(Stud entity) throws NameInvalid, Exception {
        if (!entity.getStudName().equals("shweta")) {
            throw new com.app.customexceptions.NameInvalid("NameInvalid", "ASSSS227302406", null);
        }
        com.app.bean.EmailBean emailBean = new com.app.bean.EmailBean();
        emailBean.addRecipient("shweta.zagade@algorhythm.co.in");
        emailBean.setEmailSubject("hi");
        com.app.bean.EmailTemplate emailTemplate1 = new com.app.bean.EmailTemplate();
        emailTemplate1.setTemplateId("6F314A82-F241-4FEB-AB20-2686A1DDF395");
        emailTemplate1.addReference("name", entity.getStudName());
        notificationDomainService.sendMail(emailBean, emailTemplate1);
    }
}
