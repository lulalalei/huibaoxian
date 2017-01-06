package com.bb.hbx.api;

/**
 * Created by hp on 2016/8/9.
 */
public class Result_Api<T> {

     private int code;//返回code字段

     private String msg;//返回msg

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
