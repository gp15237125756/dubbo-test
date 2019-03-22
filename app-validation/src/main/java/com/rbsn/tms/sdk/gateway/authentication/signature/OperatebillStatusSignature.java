package com.rbsn.tms.sdk.gateway.authentication.signature;

import com.rbsn.tms.sdk.gateway.authentication.constant.Constant;
import com.rbsn.tms.sdk.gateway.authentication.context.AuthContext;
import com.rbsn.tms.sdk.gateway.authentication.context.DefaultAuthContext;
import com.rbsn.tms.sdk.gateway.authentication.exception.AuthenticationException;
import com.rbsn.tms.sdk.gateway.authentication.parameter.BaseAuthParam;
import com.rbsn.tms.sdk.gateway.authentication.parameter.OperatebillStatusParam;
import com.rbsn.tms.sdk.gateway.authentication.util.CheckUtil;

/**
 * add operate bill implement
 */
public class OperatebillStatusSignature implements SignatureContext<OperatebillStatusParam> {

    @Override
    public String signature(BaseAuthParam<OperatebillStatusParam> param) throws AuthenticationException {
        try {
            if (CheckUtil.isBlank(param.getApiCode())) {
                param.setApiCode(Constant.OPERATE_BILL_STATUS_API_CODE);
            }
            param.validate();
            AuthContext context = new DefaultAuthContext();
            return context.signature(param, OperatebillStatusParam.class);
        } catch (AuthenticationException e) {
            throw new AuthenticationException("feedback operate bill status signature fail," + e.getLocalizedMessage(), e);
        }
    }
}
