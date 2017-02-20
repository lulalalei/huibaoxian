package com.bb.hbx.bean;

import com.bb.hbx.widget.multitype.data.Item;

/**
 * Created by Administrator on 2017/2/15.
 */

public class Filter_tileItem implements Item {

    private String name;

    private boolean isVisiber;

    public Filter_tileItem() {

    }

    public Filter_tileItem(String name, boolean isVisiber) {
        this.name = name;
        this.isVisiber = isVisiber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisiber() {
        return isVisiber;
    }

    public void setVisiber(boolean visiber) {
        isVisiber = visiber;
    }
}
