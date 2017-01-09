package com.bb.hbx.bean;

/**
 * Created by Administrator on 2017/1/6.
 */

public class MyPerOrderDetailBean {

    String title;
    String price;

    public MyPerOrderDetailBean(String title, String price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
