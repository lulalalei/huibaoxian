package com.bb.hbx.bean;

/**
 * Created by Administrator on 2016/12/30.
 */

public class AddressBean {

    boolean isSelected;
    String name;
    String phone;
    String address;

    public AddressBean(boolean isSelected, String name, String phone, String address) {
        this.isSelected = isSelected;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
