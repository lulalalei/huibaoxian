package com.bb.hbx.bean;

import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */

public class TradeDetailType {


    /**
     * insureList : [{"amountUnit":"元","desc":"","insureAmount":"10000","insureName":"意外医疗"},{"amountUnit":"元","desc":"","insureAmount":"100","insureName":"测试"}]
     * sumInsureAmount : 10100
     * typeId : 0
     * typeName : 意外险
     */

    private String sumInsureAmount;
    private int typeId;
    private String typeName;
    private List<InsureListBean> insureList;

    public String getSumInsureAmount() {
        return sumInsureAmount;
    }

    public void setSumInsureAmount(String sumInsureAmount) {
        this.sumInsureAmount = sumInsureAmount;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<InsureListBean> getInsureList() {
        return insureList;
    }

    public void setInsureList(List<InsureListBean> insureList) {
        this.insureList = insureList;
    }

    public static class InsureListBean implements Item{
        /**
         * amountUnit : 元
         * desc :
         * insureAmount : 10000
         * insureName : 意外医疗
         */

        private String amountUnit;
        private String desc;
        private String insureAmount;
        private String insureName;

        public String getAmountUnit() {
            return amountUnit;
        }

        public void setAmountUnit(String amountUnit) {
            this.amountUnit = amountUnit;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getInsureAmount() {
            return insureAmount;
        }

        public void setInsureAmount(String insureAmount) {
            this.insureAmount = insureAmount;
        }

        public String getInsureName() {
            return insureName;
        }

        public void setInsureName(String insureName) {
            this.insureName = insureName;
        }
    }
}
