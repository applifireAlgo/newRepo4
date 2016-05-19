package com.app.shared.appinsight;
import com.athena.server.dataengine.bizService.DTOMapperInterface;

public class EmpDateQ implements DTOMapperInterface {

    private String dAY;

    private String mONTH;

    private String yEAR;

    public EmpDateQ(Object[] aryObject) {
        if (aryObject != null) {
            dAY = (java.lang.String) aryObject[0];
            mONTH = (java.lang.String) aryObject[1];
            yEAR = (java.lang.String) aryObject[2];
        } else {
            dAY = null;
            mONTH = null;
            yEAR = null;
        }
    }

    public String getdAY() {
        return dAY;
    }

    public String getmONTH() {
        return mONTH;
    }

    public String getyEAR() {
        return yEAR;
    }
}
