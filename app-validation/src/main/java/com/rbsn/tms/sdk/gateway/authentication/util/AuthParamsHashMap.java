package com.rbsn.tms.sdk.gateway.authentication.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * construct a Map to load all parameters
 */
public class AuthParamsHashMap extends HashMap<String,String> {
    private static final long serialVersionUID = 6167799903597100175L;

    public AuthParamsHashMap(){

    }

    public AuthParamsHashMap(Map<? extends String, ? extends String> m){
        super(m);
    }

    /**
     * utility for put k-v pairs
     * @param key
     * @param value
     * @return transform value to {@code String}
     */
    public String put(String key, Object value) {
        String strValue;
        if (value == null) {
            strValue = null;
        } else if (value instanceof String) {
            strValue = (String)value;
        } else if (value instanceof Integer) {
            strValue = ((Integer)value).toString();
        } else if (value instanceof Long) {
            strValue = ((Long)value).toString();
        } else if (value instanceof Float) {
            strValue = ((Float)value).toString();
        } else if (value instanceof Double) {
            strValue = ((Double)value).toString();
        } else if (value instanceof Boolean) {
            strValue = ((Boolean)value).toString();
        } else if (value instanceof Date) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            strValue = format.format((Date)value);
        } else {
            //if the value if not primitive type,invoke toString method for input object
            strValue = value.toString();
        }
        return this.put(key, strValue);
    }

    /**
     *
     * @param key
     * @param value
     * @return V
     */
    public String put(String key, String value) {
        return StringUtils.areNotEmpty(new String[]{key}) ? (String)super.put(key, value) : null;
    }
}
