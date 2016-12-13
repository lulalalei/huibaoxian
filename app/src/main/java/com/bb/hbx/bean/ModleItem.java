package com.bb.hbx.bean;

import com.bb.hbx.widget.multitype.data.Item;

/**
 * Created by Administrator on 2016/12/13.
 */

public class ModleItem implements Item{

    private int resId;

    private String title;

    public  ModleItem(){

    }

    public ModleItem(int resId,String title){
        this.resId=resId;
        this.title=title;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
