package com.rbsn.tms.signature;

import com.alibaba.fastjson.JSONObject;
import com.rbsn.tms.sdk.gateway.authentication.parameter.BaseAuthParam;
import com.rbsn.tms.sdk.gateway.authentication.parameter.OperatebillStatusParam;
import com.rbsn.tms.sdk.gateway.authentication.signature.OperatebillStatusSignature;
import org.junit.Test;

/**
 * 接口名称：反馈操作单状态
 * 接口编码：tms.operatebill.status
 * 接口说明：终端管理平台反馈操作单结果结果给商城
 **/
public class OperatebillStatusSignatureTest {
    //测试appId 应用id
    public String appId = "123456";
    //测试appKey 应用密钥
    public String appKey = "87b49d3dec236837f3296b70020dc345";
    //测试timestamp 时间戳
    public String timestamp = "2019-01-28 14:24:40";

    @Test
    public void signature() {
        OperatebillStatusSignature statusSignature = new OperatebillStatusSignature();
        OperatebillStatusParam operatebillStatusParam = new OperatebillStatusParam();
        operatebillStatusParam.setOperatebillNumber("123456");
        operatebillStatusParam.setOperatebillStatus("1");
        operatebillStatusParam.setOperatebillInfo("success");
        operatebillStatusParam.setDataId("8888");
        BaseAuthParam<OperatebillStatusParam> param = new BaseAuthParam<OperatebillStatusParam>(this.appId, this.appKey, operatebillStatusParam);
        param.setTimestamp(timestamp);
        String signature = statusSignature.signature(param);
        System.out.println("result : " + signature);
    }

}