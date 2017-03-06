package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */

public class Hotkey {

    private List<HotSearchBean> keyList;

    private int pageSize;

    private int totalCount;

    public List<HotSearchBean> getKeyList() {
        return keyList;
    }

    public void setKeyList(List<HotSearchBean> keyList) {
        this.keyList = keyList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
