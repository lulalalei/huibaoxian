package com.bb.hbx.bean;

/**
 * Created by Administrator on 2016/12/13.
 */

public class SafeKind_Item {

    private String kind_name;

    private String kind_detail;

    private String kind_price;

    private int kind_resId;


    public SafeKind_Item(String kind_name, String kind_detail, String kind_price, int kind_resId) {
        this.kind_name = kind_name;
        this.kind_detail = kind_detail;
        this.kind_price = kind_price;
        this.kind_resId = kind_resId;
    }

    public String getKind_name() {
        return kind_name;
    }

    public void setKind_name(String kind_name) {
        this.kind_name = kind_name;
    }

    public int getKind_resId() {
        return kind_resId;
    }

    public void setKind_resId(int kind_resId) {
        this.kind_resId = kind_resId;
    }

    public String getKind_price() {
        return kind_price;
    }

    public void setKind_price(String kind_price) {
        this.kind_price = kind_price;
    }

    public String getKind_detail() {
        return kind_detail;
    }

    public void setKind_detail(String kind_detail) {
        this.kind_detail = kind_detail;
    }
}
