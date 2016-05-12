package com.app.server.businessservice.appinsight;
import com.app.shared.appinsight.SQ;
import java.util.List;

public interface SQBzService {

    public List<SQ> executeQuerySQ() throws Exception;
}
