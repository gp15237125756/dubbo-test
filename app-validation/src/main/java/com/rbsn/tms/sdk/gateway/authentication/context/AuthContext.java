package com.rbsn.tms.sdk.gateway.authentication.context;


import com.rbsn.tms.sdk.gateway.authentication.exception.AuthenticationException;
import com.rbsn.tms.sdk.gateway.authentication.parameter.BaseAuthParam;

/**
 * define the authenticate context
 */
public interface AuthContext {

    <T> String signature(BaseAuthParam<T> param, Class<T> beanClass) throws AuthenticationException;

}
