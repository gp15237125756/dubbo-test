package com.rbsn.tms.sdk.gateway.authentication.util;


import com.rbsn.tms.sdk.gateway.authentication.exception.CheckException;

/**
 * 校验工具类
 *
 * @author Administrator
 * @date 2017/9/7
 */
public class CheckUtil {

    /**
     * 校验字符串是否为空，并抛出对应异常
     *
     * @param value
     * @param exceptionStr
     */
    public static void checkBlank(String value, String exceptionStr) {
        if (isBlank(value)) {
            throw new CheckException(exceptionStr);
        }
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    /**
     * 校验对象是否为空，并抛出对应异常
     *
     * @param value
     * @param exceptionStr
     */
    public static void checkNull(Object value, String exceptionStr) {
        if (value == null) {
            throw new CheckException(exceptionStr);
        }
    }

}
