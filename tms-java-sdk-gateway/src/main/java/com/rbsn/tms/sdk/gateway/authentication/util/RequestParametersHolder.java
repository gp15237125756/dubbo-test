package com.rbsn.tms.sdk.gateway.authentication.util;

/**
 *  the holder withhold and classify input parameters
 */
public class RequestParametersHolder {
    /**
     * mandatory parameters
     */
    private AuthParamsHashMap mustParams;
    /**
     * optional parameters
     */
    private AuthParamsHashMap optParams;

    public AuthParamsHashMap getMustParams() {
        return mustParams;
    }

    public void setMustParams(AuthParamsHashMap mustParams) {
        this.mustParams = mustParams;
    }

    public AuthParamsHashMap getOptParams() {
        return optParams;
    }

    public void setOptParams(AuthParamsHashMap optParams) {
        this.optParams = optParams;
    }

    @Override
    public String toString() {
        return "RequestParametersHolder{" +
                "mustParams=" + mustParams +
                ", optParams=" + optParams +
                '}';
    }
}
