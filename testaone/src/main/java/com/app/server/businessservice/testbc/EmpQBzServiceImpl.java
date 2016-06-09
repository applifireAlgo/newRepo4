package com.app.server.businessservice.testbc;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.testbc.EmpQ;
import java.lang.Override;
import java.util.List;

@Component
public class EmpQBzServiceImpl implements EmpQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<EmpQ> executeQueryEmpQ() throws Exception {
        java.util.List<com.app.shared.testbc.EmpQ> listDtoInterface = new java.util.ArrayList<com.app.shared.testbc.EmpQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "5047B005-3E44-483A-A4E7-23D3C298C534");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.testbc.EmpQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
