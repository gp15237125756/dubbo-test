package com.rbsn.tms.sdk.gateway.authentication.signature;


import com.rbsn.tms.sdk.gateway.authentication.exception.AuthenticationException;
import com.rbsn.tms.sdk.gateway.authentication.parameter.BaseAuthParam;

public interface SignatureContext<T> {

    String signature(BaseAuthParam<T> param) throws AuthenticationException;
}
