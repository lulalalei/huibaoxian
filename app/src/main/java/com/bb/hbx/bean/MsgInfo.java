package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/23.
 */

public class MsgInfo {


    /**
     * msgList : []
     * pageSize : 2
     * totalCount : 2
     */

    private int pageSize;
    private int totalCount;
    private List<Message> msgList;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Message> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<Message> msgList) {
        this.msgList = msgList;
    }
}
