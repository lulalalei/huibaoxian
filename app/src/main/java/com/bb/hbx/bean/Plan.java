package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/14.
 */

public class Plan {


    /**
     * channelIds :
     * classNameList : []
     * planDesc :
     * planId : 158
     * planIntro : -
     * planName : 尊享全球计划
     * planPrice :
     * sortCode :
     */

    private String channelIds="";
    private String planDesc="";
    private int planId;
    private String planIntro="";
    private String planName="";
    private String planPrice="";
    private String sortCode="";
    private List<ClassName> classNameList;

    public String getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(String channelIds) {
        this.channelIds = channelIds;
    }

    public String getPlanDesc() {
        return planDesc;
    }

    public void setPlanDesc(String planDesc) {
        this.planDesc = planDesc;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getPlanIntro() {
        return planIntro;
    }

    public void setPlanIntro(String planIntro) {
        this.planIntro = planIntro;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(String planPrice) {
        this.planPrice = planPrice;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public List<ClassName> getClassNameList() {
        return classNameList;
    }

    public void setClassNameList(List<ClassName> classNameList) {
        this.classNameList = classNameList;
    }
}
