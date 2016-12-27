package com.bb.hbx.bean;

import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */

public class BKItem implements Item{


    private int  img_Id;


    public BKItem(int img_Id ){
        this.img_Id=img_Id;
    }

    public int getImg_Id() {
        return img_Id;
    }

    public void setImg_Id(int img_Id) {
        this.img_Id = img_Id;
    }
}
