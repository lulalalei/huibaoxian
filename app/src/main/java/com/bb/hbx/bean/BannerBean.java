package com.bb.hbx.bean;

import android.support.annotation.NonNull;

import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */

public class BannerBean implements Item {

    private List<Integer>list;

    public BannerBean() {

    }


    public BannerBean(@NonNull final List<Integer>list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
