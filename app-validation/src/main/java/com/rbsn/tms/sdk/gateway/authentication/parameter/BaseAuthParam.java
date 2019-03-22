package com.rbsn.tms.sdk.gateway.authentication.parameter;

import com.rbsn.tms.sdk.gateway.authentication.util.CheckUtil;

import java.io.Serializable;
import java.util.Objects;

/**
 * encapsulate general properties for authentication
 */
public class BaseAuthParam<T> implements Serializable {
    private static final long serialVersionUID = 4732591508556032104L;
    /**
     * application id
     */
    private String appId;
    /**
     * application key
     */
    private String appKey;
    /**
     * api code derive from client
     */
    private String apiCode;
    /**
     * request timestamp
     */
    private String timestamp;
    /**
     *  the general data is not primitive type
     */
    private T data;

    public BaseAuthParam(){
        super();
    }

    public BaseAuthParam(String appId, String appKey, T data) {
        this.appId = appId;
        this.appKey = appKey;
        this.data = data;
    }

    public BaseAuthParam(String appId, String appKey, String apiCode, String timestamp, T data) {
        this.appId = appId;
        this.appKey = appKey;
        this.apiCode = apiCode;
        this.timestamp = timestamp;
        this.data = data;
    }

    public void validate() {
        CheckUtil.checkNull(appId, "appId must not be null！");
        CheckUtil.checkNull(appKey, "appKey must not be null！");
        CheckUtil.checkNull(apiCode, "apiCode must not be null！");
        CheckUtil.checkNull(timestamp, "timestamp must not be null！");
        Objects.requireNonNull(data, "data must not be null！");
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseAuthParam{" +
                "appId='" + appId + '\'' +
                ", appKey='" + appKey + '\'' +
                ", apiCode='" + apiCode + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", data=" + data +
                '}';
    }
}
