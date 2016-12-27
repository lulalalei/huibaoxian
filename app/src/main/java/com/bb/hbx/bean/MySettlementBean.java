package com.bb.hbx.bean;

/**
 * Created by Administrator on 2016/12/26.
 */

public class MySettlementBean {

    String date;
    String time;
    String title;
    String number;
    String price;

    public MySettlementBean(String date, String time, String title, String number, String price) {
        this.date = date;
        this.time = time;
        this.title = title;
        this.number = number;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
