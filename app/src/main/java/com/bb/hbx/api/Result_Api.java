package com.bb.hbx.api;

/**
 * Created by hp on 2016/8/9.
 */
public class Result_Api<T> {

    private String respCode;//返回code字段

    private String respMsg;//返回msg

    private boolean success;//

    private T output;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getOutput() {
        return output;
    }

    public void setOutput(T output) {
        this.output = output;
    }
}
