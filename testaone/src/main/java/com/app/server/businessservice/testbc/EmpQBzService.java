package com.app.server.businessservice.testbc;
import com.app.shared.testbc.EmpQ;
import java.util.List;

public interface EmpQBzService {

    public List<EmpQ> executeQueryEmpQ() throws Exception;
}
