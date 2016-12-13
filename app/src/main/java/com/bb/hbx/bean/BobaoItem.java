package com.bb.hbx.bean;

import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */

public class BobaoItem implements Item{


    List<String>list;

    public BobaoItem(){

    }

    public BobaoItem(List<String>list){
       this.list=list;
    }


    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
