package com.app.shared.appinsight;
import com.athena.server.dataengine.bizService.DTOMapperInterface;

public class ToneQ implements DTOMapperInterface {

    private String tnm;

    private Integer tno;

    public ToneQ(Object[] aryObject) {
        if (aryObject != null) {
            tnm = (java.lang.String) aryObject[0];
            tno = (java.lang.Integer) aryObject[1];
        } else {
            tnm = null;
            tno = null;
        }
    }

    public String getTnm() {
        return tnm;
    }

    public Integer getTno() {
        return tno;
    }
}
