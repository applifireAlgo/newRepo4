package com.app.shared.appinsight;
import com.athena.server.dataengine.bizService.DTOMapperInterface;

public class SQ implements DTOMapperInterface {

    private String categorynm;

    private String brandnm;

    public SQ(Object[] aryObject) {
        if (aryObject != null) {
            categorynm = (java.lang.String) aryObject[0];
            brandnm = (java.lang.String) aryObject[1];
        } else {
            categorynm = null;
            brandnm = null;
        }
    }

    public String getCategorynm() {
        return categorynm;
    }

    public String getBrandnm() {
        return brandnm;
    }
}
