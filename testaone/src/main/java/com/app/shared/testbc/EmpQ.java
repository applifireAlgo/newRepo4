package com.app.shared.testbc;
import com.athena.server.dataengine.bizService.DTOMapperInterface;
import java.sql.Timestamp;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class EmpQ implements DTOMapperInterface {

    private String countryId;

    private String countryName;

    private String countryCode1;

    private String countryCode2;

    private String countryFlag;

    private String capital;

    private String currencyCode;

    private String currencyName;

    private String currencySymbol;

    private Integer capitalLatitude;

    private Integer capitalLongitude;

    private Integer isoNumeric;

    private String createdBy;

    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp createdDate;

    private String updatedBy;

    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp updatedDate;

    private Integer versionId;

    private Integer activeStatus;

    private Integer txnAccessCode;

    public EmpQ(Object[] aryObject) {
        if (aryObject != null) {
            countryId = (java.lang.String) aryObject[0];
            countryName = (java.lang.String) aryObject[1];
            countryCode1 = (java.lang.String) aryObject[2];
            countryCode2 = (java.lang.String) aryObject[3];
            countryFlag = (java.lang.String) aryObject[4];
            capital = (java.lang.String) aryObject[5];
            currencyCode = (java.lang.String) aryObject[6];
            currencyName = (java.lang.String) aryObject[7];
            currencySymbol = (java.lang.String) aryObject[8];
            capitalLatitude = (aryObject[9] == null ? null : new Integer(aryObject[9].toString()));
            capitalLongitude = (aryObject[10] == null ? null : new Integer(aryObject[10].toString()));
            isoNumeric = (aryObject[11] == null ? null : new Integer(aryObject[11].toString()));
            createdBy = (java.lang.String) aryObject[12];
            createdDate = (java.sql.Timestamp) aryObject[13];
            updatedBy = (java.lang.String) aryObject[14];
            updatedDate = (java.sql.Timestamp) aryObject[15];
            versionId = (aryObject[16] == null ? null : new Integer(aryObject[16].toString()));
            activeStatus = (aryObject[17] == null ? null : new Integer(aryObject[17].toString()));
            txnAccessCode = (aryObject[18] == null ? null : new Integer(aryObject[18].toString()));
        } else {
            countryId = null;
            countryName = null;
            countryCode1 = null;
            countryCode2 = null;
            countryFlag = null;
            capital = null;
            currencyCode = null;
            currencyName = null;
            currencySymbol = null;
            capitalLatitude = null;
            capitalLongitude = null;
            isoNumeric = null;
            createdBy = null;
            createdDate = null;
            updatedBy = null;
            updatedDate = null;
            versionId = null;
            activeStatus = null;
            txnAccessCode = null;
        }
    }

    public String getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode1() {
        return countryCode1;
    }

    public String getCountryCode2() {
        return countryCode2;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public String getCapital() {
        return capital;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public Integer getCapitalLatitude() {
        return capitalLatitude;
    }

    public Integer getCapitalLongitude() {
        return capitalLongitude;
    }

    public Integer getIsoNumeric() {
        return isoNumeric;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public Integer getActiveStatus() {
        return activeStatus;
    }

    public Integer getTxnAccessCode() {
        return txnAccessCode;
    }
}
