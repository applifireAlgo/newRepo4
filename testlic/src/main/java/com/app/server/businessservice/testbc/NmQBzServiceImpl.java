package com.app.server.businessservice.testbc;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.testbc.NmQ;
import java.lang.Override;
import java.util.List;

@Component
public class NmQBzServiceImpl implements NmQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<NmQ> executeQueryNmQ(Integer sNo1) throws Exception {
        java.util.List<com.app.shared.testbc.NmQ> listDtoInterface = new java.util.ArrayList<com.app.shared.testbc.NmQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "0ACD1156-DC29-4FF0-A614-0A00AD0D7F31");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            atg.taglib.json.util.JSONObject jsonObjectSNo1 = new atg.taglib.json.util.JSONObject();
            jsonObjectSNo1.put("name", "sNo");
            jsonObjectSNo1.put("value", sNo1);
            jsonObjectSNo1.put("datatype", "INT");
            jsonObjectSNo1.put("index", 1);
            jsonArray.add(jsonObjectSNo1);
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.testbc.NmQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
