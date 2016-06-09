package com.app.shared.appinsight;
import com.athena.server.dataengine.bizService.DTOMapperInterface;

public class TestTwoQ implements DTOMapperInterface {

    private String tnm;

    private Integer tno;

    private Boolean tpp;

    public TestTwoQ(Object[] aryObject) {
        if (aryObject != null) {
            tnm = (java.lang.String) aryObject[0];
            tno = (java.lang.Integer) aryObject[1];
            tpp = (java.lang.Boolean) aryObject[2];
        } else {
            tnm = null;
            tno = null;
            tpp = null;
        }
    }

    public String getTnm() {
        return tnm;
    }

    public Integer getTno() {
        return tno;
    }

    public Boolean getTpp() {
        return tpp;
    }
}
