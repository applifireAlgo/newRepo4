package com.app.shared.testbc;
import com.athena.server.dataengine.bizService.DTOMapperInterface;

public class NmQ implements DTOMapperInterface {

    private String sName;

    private Integer sNo;

    public NmQ(Object[] aryObject) {
        if (aryObject != null) {
            sName = (java.lang.String) aryObject[0];
            sNo = (aryObject[1] == null ? null : new Integer(aryObject[1].toString()));
        } else {
            sName = null;
            sNo = null;
        }
    }

    public String getsName() {
        return sName;
    }

    public Integer getsNo() {
        return sNo;
    }
}
