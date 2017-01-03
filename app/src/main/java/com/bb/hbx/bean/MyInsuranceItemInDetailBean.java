package com.bb.hbx.bean;

/**
 * Created by Administrator on 2017/1/3.
 */

public class MyInsuranceItemInDetailBean {

    String title;
    String price;

    public MyInsuranceItemInDetailBean(String title, String price) {
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
