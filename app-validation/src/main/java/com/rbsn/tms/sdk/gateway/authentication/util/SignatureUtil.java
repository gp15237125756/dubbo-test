package com.rbsn.tms.sdk.gateway.authentication.util;

import java.util.*;

/**
 * covert RequestParametersHolder into signature
 */
public class SignatureUtil {

    public SignatureUtil(){}

    /**
     *
     * @param requestHolder
     * @param appSerect
     * @return
     */
    public static String getSignatureContent(RequestParametersHolder requestHolder, String appSerect) {
        return EncryptUtil.hmacSign(getSortedMap(requestHolder),appSerect);
    }

    /**
     * if not specify the sort method for TreeMap,sort by key naturally
     * @param requestHolder
     * @return Map<String, String>
     */
    public static Map<String, String> getSortedMap(RequestParametersHolder requestHolder) {
        Map<String, String> sortedParams = new TreeMap();
        AuthParamsHashMap mustParams = requestHolder.getMustParams();
        if (mustParams != null && mustParams.size() > 0) {
            sortedParams.putAll(mustParams);
        }
        AuthParamsHashMap optParams = requestHolder.getOptParams();
        if (optParams != null && optParams.size() > 0) {
            sortedParams.putAll(optParams);
        }
        return sortedParams;
    }

    public static String getSignContent(Map<String, String> sortedParams) {
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for(int i = 0; i < keys.size(); ++i) {
            String key = (String)keys.get(i);
            String value = (String)sortedParams.get(key);
            if (StringUtils.areNotEmpty(new String[]{key, value})) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                ++index;
            }
        }
        return content.toString();
    }
}
