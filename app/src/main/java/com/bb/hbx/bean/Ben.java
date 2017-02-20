package com.bb.hbx.bean;

/**
 * Created by Administrator on 2017/2/17.
 */

public class Ben {

    private String benId;//受益人ID

    private String relation;//与被保险人关系

    private String benRate;//受益比例

    public String getBenId() {
        return benId;
    }

    public void setBenId(String benId) {
        this.benId = benId;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getBenRate() {
        return benRate;
    }

    public void setBenRate(String benRate) {
        this.benRate = benRate;
    }
}
