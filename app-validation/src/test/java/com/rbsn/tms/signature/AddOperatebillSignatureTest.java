package com.rbsn.tms.signature;

import com.rbsn.tms.sdk.gateway.authentication.parameter.AddOperatebillParam;
import com.rbsn.tms.sdk.gateway.authentication.parameter.BaseAuthParam;
import com.rbsn.tms.sdk.gateway.authentication.parameter.OperatebillParam;
import com.rbsn.tms.sdk.gateway.authentication.parameter.OperatebillTypeParam;
import com.rbsn.tms.sdk.gateway.authentication.signature.AddOperatebillSignature;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 接口名称：新增操作单
 * 接口编码：tms.operatebill.add
 * 接口说明：商城向终端管理平台发起新增操作单请求
 */
public class AddOperatebillSignatureTest {
    //测试appId  应用id
    public String appId = "2019012200000005";
    //测试appKey 应用密钥
    public String appKey = "296b70020dc34487b49d3dec236837f3";
    //测试timestamp 时间戳
    public String timestamp = "2019-03-18 10:10:10";

    @Test
    public void signature() {
        AddOperatebillSignature signature = new AddOperatebillSignature();
        List<OperatebillTypeParam> typeParamArrayList = new ArrayList<OperatebillTypeParam>();
        OperatebillTypeParam operatebillTypeParam = new OperatebillTypeParam();
        operatebillTypeParam.setType("12");
        operatebillTypeParam.setNumber(1);
        typeParamArrayList.add(operatebillTypeParam);
        List<OperatebillParam> operatebillParamArrayList = new ArrayList<OperatebillParam>();
        OperatebillParam operatebillParam = new OperatebillParam();
        operatebillParam.setType("2");
        operatebillParam.setItem(typeParamArrayList);
        operatebillParamArrayList.add(operatebillParam);
        AddOperatebillParam data = new AddOperatebillParam();
        data.setDataId("888888");
        data.setShopCode("S101");
        data.setOperate(operatebillParamArrayList);
        BaseAuthParam<AddOperatebillParam> param = new BaseAuthParam<AddOperatebillParam>(this.appId,this.appKey,data);
        param.setTimestamp(timestamp);
        String result = signature.signature(param);
        System.out.println("result: " + result);
    }
}