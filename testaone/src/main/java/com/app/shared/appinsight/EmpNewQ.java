package com.app.shared.appinsight;
import com.athena.server.dataengine.bizService.DTOMapperInterface;

public class EmpNewQ implements DTOMapperInterface {

    private Long dtDay;

    private Long dtMonth;

    private Long dtYear;

    public EmpNewQ(Object[] aryObject) {
        if (aryObject != null) {
            dtDay = (aryObject[0] == null ? null : new Long(aryObject[0].toString()));
            dtMonth = (aryObject[1] == null ? null : new Long(aryObject[1].toString()));
            dtYear = (aryObject[2] == null ? null : new Long(aryObject[2].toString()));
        } else {
            dtDay = null;
            dtMonth = null;
            dtYear = null;
        }
    }

    public Long getDtDay() {
        return dtDay;
    }

    public Long getDtMonth() {
        return dtMonth;
    }

    public Long getDtYear() {
        return dtYear;
    }
}
