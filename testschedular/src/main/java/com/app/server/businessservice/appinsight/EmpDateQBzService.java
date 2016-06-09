package com.app.server.businessservice.appinsight;
import com.app.shared.appinsight.EmpDateQ;
import java.util.List;

public interface EmpDateQBzService {

    public List<EmpDateQ> executeQueryEmpDateQ() throws Exception;
}
