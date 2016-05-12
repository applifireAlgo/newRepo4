package com.app.server.businessservice.appinsight;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.appinsight.SQ;
import java.lang.Override;
import java.util.List;

@Component
public class SQBzServiceImpl implements SQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<SQ> executeQuerySQ() throws Exception {
        java.util.List<com.app.shared.appinsight.SQ> listDtoInterface = new java.util.ArrayList<com.app.shared.appinsight.SQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "69018BFF-08B8-4C55-BBDD-43FFACF7911B");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.appinsight.SQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
