package com.bb.hbx.bean;

import com.bb.hbx.widget.multitype.data.Item;

/**
 * Created by Administrator on 2016/12/13.
 */

public class BKchildItem implements Item{



    private int redId;

    private String safe_name;

    private String safe_detail;

    private String safe_price;

    private String safe_add;

    private boolean isLine=true;

    public BKchildItem(){

    }


    public int getRedId() {
        return redId;
    }

    public void setRedId(int redId) {
        this.redId = redId;
    }

    public String getSafe_name() {
        return safe_name;
    }

    public void setSafe_name(String safe_name) {
        this.safe_name = safe_name;
    }

    public String getSafe_detail() {
        return safe_detail;
    }

    public void setSafe_detail(String safe_detail) {
        this.safe_detail = safe_detail;
    }

    public String getSafe_price() {
        return safe_price;
    }

    public void setSafe_price(String safe_price) {
        this.safe_price = safe_price;
    }

    public String getSafe_add() {
        return safe_add;
    }

    public void setSafe_add(String safe_add) {
        this.safe_add = safe_add;
    }

    public boolean isLine() {
        return isLine;
    }

    public void setLine(boolean line) {
        isLine = line;
    }
}
