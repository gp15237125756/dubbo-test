package com.rbsn.tms.sdk.gateway.authentication.context;

import com.alibaba.fastjson.JSONObject;
import com.rbsn.tms.sdk.gateway.authentication.exception.AuthenticationException;
import com.rbsn.tms.sdk.gateway.authentication.parameter.BaseAuthParam;
import com.rbsn.tms.sdk.gateway.authentication.util.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DefaultAuthContext implements AuthContext {

    public DefaultAuthContext() {

    }

    @Override
    public <T> String signature(BaseAuthParam<T> param, Class<T> beanClass) throws AuthenticationException {
        try {
            param.validate();
            RequestParametersHolder requestHolder = new RequestParametersHolder();
            AuthParamsHashMap authMustParams = new AuthParamsHashMap();
            //设置应用id
            authMustParams.put("appId", param.getAppId());
            //设置接口唯一code
            authMustParams.put("appCode", param.getApiCode());
            //设置秘钥
            authMustParams.put("appKey", param.getAppKey());
            //设置客户端设置的时间戳
            authMustParams.put("timestamp", param.getTimestamp());
            requestHolder.setMustParams(authMustParams);
            //put data
            AuthParamsHashMap authDataParams = new AuthParamsHashMap();
            //取出data中所有属性 转换object类型的value
            T data = (T) param.getData();
            this.setAuthDataParams(authDataParams, beanClass, data);
            //JSONWriter jsonWriter = new JSONWriter();
            //String jsonData = jsonWriter.write(data, false);
            requestHolder.setOptParams(authDataParams);
            String signatureContent = SignatureUtil.getSignatureContent(requestHolder, param.getAppKey());
            return signatureContent;
        } catch (Exception ex) {
            throw new AuthenticationException("signature fail," + ex.getLocalizedMessage(), ex);
        }
    }

    private <T> void setAuthDataParams(final AuthParamsHashMap authDataParams, Class<T> beanClass, T instance) throws Exception {
        Objects.requireNonNull(beanClass, "传入Class对象不能为空！");
        //获取所有属性名与读方法映射
        Map<String, Method> beanPropertyReadMethods = ReflectUtil.getBeanPropertyReadMethods(beanClass);
        if (beanPropertyReadMethods != null && beanPropertyReadMethods.size() > 0) {
            Set<Map.Entry<String, Method>> entries = beanPropertyReadMethods.entrySet();
            for (Map.Entry<String, Method> entry : entries) {
                String propName = entry.getKey();
                Method propGetMethodName = entry.getValue();
                Object value = propGetMethodName.invoke(instance, (Object[]) null);
                //忽略属性值为Null的属性
                if (value != null) {
                    //对象转json字符串后 排序
                    if (isPrimitive(propGetMethodName.getReturnType())) {
                        authDataParams.put(propName, value);
                    } else {
                        String jsonValue = JSONObject.toJSONString(value);
                        CheckUtil.checkBlank(jsonValue, "对象类型属性值不能为空！");
                        char[] chars = jsonValue.toCharArray();
                        Arrays.sort(chars);
                        String sortedValue = String.valueOf(chars);
                        authDataParams.put(propName, sortedValue);
                    }
                }
            }
        }

    }

    private boolean isPrimitive(Class<?> type) {
        return type.isPrimitive() || type == String.class || type == Character.class || type == Boolean.class || type == Byte.class || type == Short.class || type == Integer.class || type == Long.class || type == Float.class || type == Double.class;
    }

}
