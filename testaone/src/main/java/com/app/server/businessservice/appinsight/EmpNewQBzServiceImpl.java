package com.app.server.businessservice.appinsight;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.appinsight.EmpNewQ;
import java.lang.Override;
import java.util.List;

@Component
public class EmpNewQBzServiceImpl implements EmpNewQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<EmpNewQ> executeQueryEmpNewQ() throws Exception {
        java.util.List<com.app.shared.appinsight.EmpNewQ> listDtoInterface = new java.util.ArrayList<com.app.shared.appinsight.EmpNewQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "71C474C0-EBAB-4846-AB01-6BB58D32626C");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.appinsight.EmpNewQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
