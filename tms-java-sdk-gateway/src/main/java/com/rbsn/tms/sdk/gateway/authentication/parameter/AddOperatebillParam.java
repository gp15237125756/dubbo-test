package com.rbsn.tms.sdk.gateway.authentication.parameter;

import com.rbsn.tms.sdk.gateway.authentication.exception.CheckException;
import com.rbsn.tms.sdk.gateway.authentication.util.CheckUtil;

import java.util.List;
import java.util.Objects;

/**
 * add operate bill params
 * code: tms.operatebill.add
 */
public class AddOperatebillParam implements BaseParam {
    /**
     * 终端管理平台向控制器发起新增操作单请求使用此字段
     */
    private String actionId;

    private String dataId;

    private String shopCode;

    private List<OperatebillParam> operate;

    @Override
    public void validate() {
        CheckUtil.checkBlank(dataId, "数据id不能为空！");
        CheckUtil.checkBlank(shopCode, "商铺编号不能为空！");
        if (Objects.isNull(operate) || operate.size() <= 0) {
            throw new CheckException("操作单不能为空！");
        }
        if (operate.size() != 1) {
            throw new CheckException("操作单类型不能大于一种！");
        }
    }

    public AddOperatebillParam() {
    }

    public AddOperatebillParam(String dataId, String shopCode, List<OperatebillParam> operate) {
        this.dataId = dataId;
        this.shopCode = shopCode;
        this.operate = operate;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public List<OperatebillParam> getOperate() {
        return operate;
    }

    public void setOperate(List<OperatebillParam> operate) {
        this.operate = operate;
    }

    @Override
    public String toString() {
        return "AddOperatebillParam{" +
                "actionId='" + actionId + '\'' +
                ", dataId='" + dataId + '\'' +
                ", shopCode='" + shopCode + '\'' +
                ", operate=" + operate +
                '}';
    }
}
