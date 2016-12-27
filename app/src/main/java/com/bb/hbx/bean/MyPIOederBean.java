package com.bb.hbx.bean;

/**
 * Created by Administrator on 2016/12/26.
 */

public class MyPIOederBean {
    private String title;
    private String number;
    private String theInsured;
    private String insuranceHolder;
    private String time;
    private String state;

    public MyPIOederBean(String title, String number, String theInsured, String insuranceHolder, String time, String state) {
        this.title = title;
        this.number = number;
        this.theInsured = theInsured;
        this.insuranceHolder = insuranceHolder;
        this.time = time;
        this.state = state;
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

    public String getTheInsured() {
        return theInsured;
    }

    public void setTheInsured(String theInsured) {
        this.theInsured = theInsured;
    }

    public String getInsuranceHolder() {
        return insuranceHolder;
    }

    public void setInsuranceHolder(String insuranceHolder) {
        this.insuranceHolder = insuranceHolder;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
