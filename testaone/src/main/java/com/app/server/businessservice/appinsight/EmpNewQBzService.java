package com.app.server.businessservice.appinsight;
import com.app.shared.appinsight.EmpNewQ;
import java.util.List;

public interface EmpNewQBzService {

    public List<EmpNewQ> executeQueryEmpNewQ() throws Exception;
}
