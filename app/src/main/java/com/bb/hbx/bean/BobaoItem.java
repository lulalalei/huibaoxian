package com.bb.hbx.bean;

import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */

public class BobaoItem implements Item {


    private List<XhbMsg> msgList;

    public BobaoItem() {

    }

    public BobaoItem(List<XhbMsg> list) {
        this.msgList = list;
    }

    public List<XhbMsg> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<XhbMsg> msgList) {
        this.msgList = msgList;
    }
}
