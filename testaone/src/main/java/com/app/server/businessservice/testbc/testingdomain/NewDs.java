package com.app.server.businessservice.testbc.testingdomain;
import com.app.server.businessservice.appinsight.EmpNewQBzService;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewDs {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EmpNewQBzService empNewQBzService;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    public void proNewDs() throws Exception {
        java.util.List<com.app.shared.appinsight.EmpNewQ> empNewQList = empNewQBzService.executeQueryEmpNewQ();
        for (com.app.shared.appinsight.EmpNewQ empNewQListElement : empNewQList) {
            com.app.shared.organization.contactmanagement.Gender gender = new com.app.shared.organization.contactmanagement.Gender();
            gender.setGender(java.lang.String.valueOf(empNewQListElement.getDtDay()));
            com.app.shared.organization.contactmanagement.Gender gender1 = genderRepository.save(gender);
        }
    }
}
