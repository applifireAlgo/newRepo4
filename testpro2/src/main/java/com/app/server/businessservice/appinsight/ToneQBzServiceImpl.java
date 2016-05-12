package com.app.server.businessservice.appinsight;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.appinsight.ToneQ;
import java.lang.Override;
import java.util.List;

@Component
public class ToneQBzServiceImpl implements ToneQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<ToneQ> executeQueryToneQ(Integer tno1) throws Exception {
        java.util.List<com.app.shared.appinsight.ToneQ> listDtoInterface = new java.util.ArrayList<com.app.shared.appinsight.ToneQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "8896606B-3E9B-49AA-8F54-3D487D5B8E95");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            atg.taglib.json.util.JSONObject jsonObjectTno1 = new atg.taglib.json.util.JSONObject();
            jsonObjectTno1.put("name", "tno");
            jsonObjectTno1.put("value", tno1);
            jsonObjectTno1.put("datatype", "NUMBER");
            jsonObjectTno1.put("index", 1);
            jsonArray.add(jsonObjectTno1);
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.appinsight.ToneQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
