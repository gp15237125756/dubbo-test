package com.rbsn.tms.sdk.gateway.authentication.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

public class EncryptUtil {

    public static String hmacSign(Map<String, String> params, String secret) {
        if (params != null && !StringUtils.isEmpty(secret)) {
            String toSignString = getToSignString(params);
            try {
                SecretKeySpec e = new SecretKeySpec(secret.getBytes("utf-8"), "hmacsha1");
                Mac mac = Mac.getInstance(e.getAlgorithm());
                mac.init(e);
                byte[] data = mac.doFinal(toSignString.getBytes("utf-8"));
                return newStringByBase64(data);
            } catch (Exception var6) {
                var6.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    private static final String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);

        for (int i = 0; i < bArray.length; ++i) {
            String sTemp = Integer.toHexString(255 & bArray[i]);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    public static String newStringByBase64(byte[] bytes) throws UnsupportedEncodingException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        return new String(Base64.getEncoder().encode(bytes), "utf-8");
    }

    public static String getToSignString(Map<String, String> params) {
        try {
            String[] e = (String[]) params.keySet().toArray(new String[0]);
            Arrays.sort(e);
            StringBuilder canonicalizedQueryString = new StringBuilder();
            String[] arr$ = e;
            int len$ = e.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                String key = arr$[i$];
                if (!"sign".equalsIgnoreCase(key)) {
                    canonicalizedQueryString.append(key).append("=").append((String) params.get(key));
                    if (i$ != len$-1) {
                        canonicalizedQueryString.append("&");
                    }
                }
            }
            return canonicalizedQueryString.toString();
        } catch (Exception var7) {
            var7.printStackTrace();
            return null;
        }
    }
}
