package com.app.server.businessservice.appinsight;
import com.app.shared.appinsight.ToneQ;
import java.util.List;

public interface ToneQBzService {

    public List<ToneQ> executeQueryToneQ(Integer tno1) throws Exception;
}
