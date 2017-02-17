package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/12.
 */

public class ActivitInfo {

    private List<ActivitBean> adsList;

    private int totalCount;

    public List<ActivitBean> getAdsList() {
        return adsList;
    }

    public void setAdsList(List<ActivitBean> adsList) {
        this.adsList = adsList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
