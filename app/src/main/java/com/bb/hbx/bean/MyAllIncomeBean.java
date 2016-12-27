package com.bb.hbx.bean;

/**
 * Created by Administrator on 2016/12/27.
 */

public class MyAllIncomeBean {
    String date;
    String money;

    public MyAllIncomeBean(String date, String money) {
        this.date = date;
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
