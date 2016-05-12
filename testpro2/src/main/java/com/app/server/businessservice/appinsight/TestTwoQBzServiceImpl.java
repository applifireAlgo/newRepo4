package com.app.server.businessservice.appinsight;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.appinsight.TestTwoQ;
import java.lang.Override;
import java.util.List;

@Component
public class TestTwoQBzServiceImpl implements TestTwoQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<TestTwoQ> executeQueryTestTwoQ() throws Exception {
        java.util.List<com.app.shared.appinsight.TestTwoQ> listDtoInterface = new java.util.ArrayList<com.app.shared.appinsight.TestTwoQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "EE8E07ED-81F9-48C2-8DC9-7374A502E73B");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.appinsight.TestTwoQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
