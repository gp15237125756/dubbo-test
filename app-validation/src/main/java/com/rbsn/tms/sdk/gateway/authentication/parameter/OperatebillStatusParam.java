package com.rbsn.tms.sdk.gateway.authentication.parameter;

public class OperatebillStatusParam {

    private String dataId;

    private String operatebillNumber;

    private String operatebillStatus;

    private String operatebillInfo;

    public OperatebillStatusParam() {
    }

    public OperatebillStatusParam(String dataId, String operatebillNumber, String operatebillStatus, String operatebillInfo) {
        this.dataId = dataId;
        this.operatebillNumber = operatebillNumber;
        this.operatebillStatus = operatebillStatus;
        this.operatebillInfo = operatebillInfo;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getOperatebillNumber() {
        return operatebillNumber;
    }

    public void setOperatebillNumber(String operatebillNumber) {
        this.operatebillNumber = operatebillNumber;
    }

    public String getOperatebillStatus() {
        return operatebillStatus;
    }

    public void setOperatebillStatus(String operatebillStatus) {
        this.operatebillStatus = operatebillStatus;
    }

    public String getOperatebillInfo() {
        return operatebillInfo;
    }

    public void setOperatebillInfo(String operatebillInfo) {
        this.operatebillInfo = operatebillInfo;
    }

    @Override
    public String toString() {
        return "OperatebillStatusParam{" +
                "dataId='" + dataId + '\'' +
                ", operatebillNumber='" + operatebillNumber + '\'' +
                ", operatebillStatus='" + operatebillStatus + '\'' +
                ", operatebillInfo='" + operatebillInfo + '\'' +
                '}';
    }
}
