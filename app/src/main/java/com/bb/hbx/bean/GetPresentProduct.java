package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */

public class GetPresentProduct {

    /**
     * output : [{"ageDesc":"","buyCount":10,"endTime":null,"expTime":1489247999000,"guaranteePeriod":"1次_1_5","insurerLogo":"http://img.51hbx.com/resource/images/product/1486538972745.jpeg","maxAge":"90_4;","maxPremium":0,"minAge":"18_4;","minPremium":0,"productDesc":"","productLogo":"http://img.51hbx.com/resource/images/product/1487987948443.jpeg","productName":"延乐保（境外版）-安联境外航延险计划zz","productTagUrls":"","sumInsured":0},{"ageDesc":"","buyCount":10,"endTime":null,"expTime":1489766399000,"guaranteePeriod":"1个月_1_3;5个月_5_3","insurerLogo":"http://img.51hbx.com/resource/images/product/1484969135100.jpeg","maxAge":"8_4;","maxPremium":0,"minAge":"8_1;","minPremium":0,"productDesc":"","productLogo":"http://img.51hbx.com/resource/images/product/1489147902228.jpeg","productName":"test产品名称","productTagUrls":"","sumInsured":0}]
     * respCode : 000000
     * respMsg : 获取赠险产品成功
     * success : true
     */

    private List<OutputBean> outputList;

    public List<OutputBean> getOutput() {
        return outputList;
    }

    public void setOutput(List<OutputBean> outputList) {
        this.outputList = outputList;
    }

    public static class OutputBean {
        /**
         * ageDesc :
         * buyCount : 10
         * endTime : null
         * expTime : 1489247999000
         * guaranteePeriod : 1次_1_5
         * insurerLogo : http://img.51hbx.com/resource/images/product/1486538972745.jpeg
         * maxAge : 90_4;
         * maxPremium : 0
         * minAge : 18_4;
         * minPremium : 0
         * productDesc :
         * productLogo : http://img.51hbx.com/resource/images/product/1487987948443.jpeg
         * productName : 延乐保（境外版）-安联境外航延险计划zz
         * productTagUrls :
         * sumInsured : 0
         */

        private String ageDesc;
        private int buyCount;
        private Object endTime;
        private long expTime;
        private String guaranteePeriod;
        private String insurerLogo;
        private String maxAge;
        private int maxPremium;
        private String minAge;
        private int minPremium;
        private String productDesc;
        private String productLogo;
        private String productName;
        private String productTagUrls;
        private int sumInsured;

        public String getAgeDesc() {
            return ageDesc;
        }

        public void setAgeDesc(String ageDesc) {
            this.ageDesc = ageDesc;
        }

        public int getBuyCount() {
            return buyCount;
        }

        public void setBuyCount(int buyCount) {
            this.buyCount = buyCount;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public long getExpTime() {
            return expTime;
        }

        public void setExpTime(long expTime) {
            this.expTime = expTime;
        }

        public String getGuaranteePeriod() {
            return guaranteePeriod;
        }

        public void setGuaranteePeriod(String guaranteePeriod) {
            this.guaranteePeriod = guaranteePeriod;
        }

        public String getInsurerLogo() {
            return insurerLogo;
        }

        public void setInsurerLogo(String insurerLogo) {
            this.insurerLogo = insurerLogo;
        }

        public String getMaxAge() {
            return maxAge;
        }

        public void setMaxAge(String maxAge) {
            this.maxAge = maxAge;
        }

        public int getMaxPremium() {
            return maxPremium;
        }

        public void setMaxPremium(int maxPremium) {
            this.maxPremium = maxPremium;
        }

        public String getMinAge() {
            return minAge;
        }

        public void setMinAge(String minAge) {
            this.minAge = minAge;
        }

        public int getMinPremium() {
            return minPremium;
        }

        public void setMinPremium(int minPremium) {
            this.minPremium = minPremium;
        }

        public String getProductDesc() {
            return productDesc;
        }

        public void setProductDesc(String productDesc) {
            this.productDesc = productDesc;
        }

        public String getProductLogo() {
            return productLogo;
        }

        public void setProductLogo(String productLogo) {
            this.productLogo = productLogo;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductTagUrls() {
            return productTagUrls;
        }

        public void setProductTagUrls(String productTagUrls) {
            this.productTagUrls = productTagUrls;
        }

        public int getSumInsured() {
            return sumInsured;
        }

        public void setSumInsured(int sumInsured) {
            this.sumInsured = sumInsured;
        }
    }
}
