package com.app.server.businessservice.appinsight;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.appinsight.EmpDateQ;
import java.lang.Override;
import java.util.List;

@Component
public class EmpDateQBzServiceImpl implements EmpDateQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<EmpDateQ> executeQueryEmpDateQ() throws Exception {
        java.util.List<com.app.shared.appinsight.EmpDateQ> listDtoInterface = new java.util.ArrayList<com.app.shared.appinsight.EmpDateQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "6E4ED1C7-4C2B-425D-BCE8-88765639492F");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.appinsight.EmpDateQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
