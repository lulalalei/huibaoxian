package com.bb.hbx.bean;

import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */

public class JxItem  implements Item{

    private int res_Id;

    private List<SafeKind_Item> items;


    public JxItem(int res_Id, List<SafeKind_Item> items) {
        this.res_Id = res_Id;
        this.items = items;
    }

    public int getRes_Id() {
        return res_Id;
    }

    public void setRes_Id(int res_Id) {
        this.res_Id = res_Id;
    }

    public List<SafeKind_Item> getItems() {
        return items;
    }

    public void setItems(List<SafeKind_Item> items) {
        this.items = items;
    }
}
