package com.bb.hbx.bean;

/**
 * Created by Administrator on 2016/12/27.
 */

public class MyScoreBean {
    String id;
    String time;
    String price;

    public MyScoreBean(String id, String time, String price) {
        this.id = id;
        this.time = time;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
