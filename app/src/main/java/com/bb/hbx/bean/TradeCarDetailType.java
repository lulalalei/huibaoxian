package com.bb.hbx.bean;

import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */

public class TradeCarDetailType {


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
        private List<ExtraInsureListBean> extraInsureList;
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

        public List<ExtraInsureListBean> getExtraInsureList() {
            return extraInsureList;
        }

        public void setExtraInsureList(List<ExtraInsureListBean> extraInsureList) {
            this.extraInsureList = extraInsureList;
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

    public static class ExtraInsureListBean implements Item{
        private String extraInsureName;
        private String extraInsureAmount;
        private String extraDesc;

        public String getExtraInsureName() {
            return extraInsureName;
        }

        public void setExtraInsureName(String extraInsureName) {
            this.extraInsureName = extraInsureName;
        }

        public String getExtraInsureAmount() {
            return extraInsureAmount;
        }

        public void setExtraInsureAmount(String extraInsureAmount) {
            this.extraInsureAmount = extraInsureAmount;
        }

        public String getExtraDesc() {
            return extraDesc;
        }

        public void setExtraDesc(String extraDesc) {
            this.extraDesc = extraDesc;
        }
    }
}
