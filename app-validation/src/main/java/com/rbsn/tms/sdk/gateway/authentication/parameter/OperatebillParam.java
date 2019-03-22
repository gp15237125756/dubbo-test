package com.rbsn.tms.sdk.gateway.authentication.parameter;

import com.rbsn.tms.sdk.gateway.authentication.exception.CheckException;
import com.rbsn.tms.sdk.gateway.authentication.util.CheckUtil;

import java.util.List;
import java.util.Objects;

/**
 * add operate bill params
 * code: tms.operatebill.add
 */
public class OperatebillParam implements BaseParam{
    private static final long serialVersionUID = 8922941969959780162L;

    private String type;

    private List<OperatebillTypeParam> item;

    @Override
    public void validate() {
        CheckUtil.checkBlank(type, "咖啡单类型不能为空！");
        if(Objects.isNull(item) || item.size() <= 0){
            throw new CheckException("操作单物品不能为空！");
        }
        if(item.size() != 1){
            throw new CheckException("操作单物品类型不能大于一种！");
        }
    }

    public OperatebillParam() {
    }

    public OperatebillParam(String type, List<OperatebillTypeParam> item) {
        this.type = type;
        this.item = item;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<OperatebillTypeParam> getItem() {
        return item;
    }

    public void setItem(List<OperatebillTypeParam> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "OperatebillParam{" +
                "type='" + type + '\'' +
                ", item=" + item +
                '}';
    }

}
