package com.bb.hbx.bean;

import com.bb.hbx.widget.multitype.data.Item;

/**
 * Created by Administrator on 2016/12/28.
 */

public class LishiSearchBean implements Item {

    private String name;

    public LishiSearchBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
