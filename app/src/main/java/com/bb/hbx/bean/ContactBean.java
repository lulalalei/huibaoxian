package com.bb.hbx.bean;

/**
 * Created by Administrator on 2016/12/2.
 */

public class ContactBean extends BaseIndexPinyinBean{

    private String city;

    public ContactBean() {
    }

    public ContactBean(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getTarget() {
        return city;
    }
}
