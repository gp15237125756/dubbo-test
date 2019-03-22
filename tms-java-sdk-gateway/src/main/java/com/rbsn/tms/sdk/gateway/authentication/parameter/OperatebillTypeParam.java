package com.rbsn.tms.sdk.gateway.authentication.parameter;

import com.rbsn.tms.sdk.gateway.authentication.util.CheckUtil;

/**
 * add operate bill params
 * code: tms.operatebill.add
 */
public class OperatebillTypeParam implements BaseParam{
    private static final long serialVersionUID = 8922941969959780162L;

    private String type;

    private Integer number;

    @Override
    public void validate() {
        CheckUtil.checkBlank(type,"物品类型不能为空！");
        CheckUtil.checkNull(number,"物品数量不能为空！");
    }

    public OperatebillTypeParam() {
    }

    public OperatebillTypeParam(String type, Integer number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "OperatebillTypeParam{" +
                "type='" + type + '\'' +
                ", number=" + number +
                '}';
    }
}
