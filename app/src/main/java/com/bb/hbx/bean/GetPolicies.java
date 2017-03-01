package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */

public class GetPolicies {


    /**
     * output : {"pageSize":"3","policyList":[{"applicant":"456","classId":"310022","classType":2,"detailId":"144","endTime":"20180222133409","extraInfos":"","insureCountDetail":1,"insurePremiumDetail":64700,"insuredList":[{"insuredId":"1","insuredMobile":"","insuredName":"123","licenseNo":""}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","isClaims":"","jqxEndTime":"","jqxStartTime":"","payAmount":64700,"policyHolderMobile":"13656714459","policyId":"","policyURL":"","productId":"1049","productName":"安联国际旅行保险","productProp":1040,"startTime":"20170227133409","sts":"10","tradeDate":"20170227133309","tradeId":"20170227133309455272"},{"applicant":"456","classId":"310022","classType":2,"detailId":"143","endTime":"20180222104041","extraInfos":"","insureCountDetail":1,"insurePremiumDetail":64700,"insuredList":[{"insuredId":"1","insuredMobile":"","insuredName":"123","licenseNo":""}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","isClaims":"","jqxEndTime":"","jqxStartTime":"","payAmount":64700,"policyHolderMobile":"13656714459","policyId":"","policyURL":"","productId":"1049","productName":"安联国际旅行保险","productProp":1040,"startTime":"20170227104041","sts":"10","tradeDate":"20170227103941","tradeId":"20170227103941584210"},{"applicant":"456","classId":"310022","classType":2,"detailId":"142","endTime":"20180222103415","extraInfos":"","insureCountDetail":1,"insurePremiumDetail":64700,"insuredList":[{"insuredId":"1","insuredMobile":"","insuredName":"123","licenseNo":""}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","isClaims":"","jqxEndTime":"","jqxStartTime":"","payAmount":64700,"policyHolderMobile":"13656714459","policyId":"","policyURL":"","productId":"1049","productName":"安联国际旅行保险","productProp":1040,"startTime":"20170227103415","sts":"10","tradeDate":"20170227103315","tradeId":"20170227103315836882"}],"totalCount":"3"}
     * respCode : 000000
     * respMsg : 获取保单列表成功
     * success : true
     */

        /**
         * pageSize : 3
         * policyList : [{"applicant":"456","classId":"310022","classType":2,"detailId":"144","endTime":"20180222133409","extraInfos":"","insureCountDetail":1,"insurePremiumDetail":64700,"insuredList":[{"insuredId":"1","insuredMobile":"","insuredName":"123","licenseNo":""}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","isClaims":"","jqxEndTime":"","jqxStartTime":"","payAmount":64700,"policyHolderMobile":"13656714459","policyId":"","policyURL":"","productId":"1049","productName":"安联国际旅行保险","productProp":1040,"startTime":"20170227133409","sts":"10","tradeDate":"20170227133309","tradeId":"20170227133309455272"},{"applicant":"456","classId":"310022","classType":2,"detailId":"143","endTime":"20180222104041","extraInfos":"","insureCountDetail":1,"insurePremiumDetail":64700,"insuredList":[{"insuredId":"1","insuredMobile":"","insuredName":"123","licenseNo":""}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","isClaims":"","jqxEndTime":"","jqxStartTime":"","payAmount":64700,"policyHolderMobile":"13656714459","policyId":"","policyURL":"","productId":"1049","productName":"安联国际旅行保险","productProp":1040,"startTime":"20170227104041","sts":"10","tradeDate":"20170227103941","tradeId":"20170227103941584210"},{"applicant":"456","classId":"310022","classType":2,"detailId":"142","endTime":"20180222103415","extraInfos":"","insureCountDetail":1,"insurePremiumDetail":64700,"insuredList":[{"insuredId":"1","insuredMobile":"","insuredName":"123","licenseNo":""}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","isClaims":"","jqxEndTime":"","jqxStartTime":"","payAmount":64700,"policyHolderMobile":"13656714459","policyId":"","policyURL":"","productId":"1049","productName":"安联国际旅行保险","productProp":1040,"startTime":"20170227103415","sts":"10","tradeDate":"20170227103315","tradeId":"20170227103315836882"}]
         * totalCount : 3
         */

        private String pageSize;
        private String totalCount;
        private List<PolicyListBean> policyList;

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public List<PolicyListBean> getPolicyList() {
            return policyList;
        }

        public void setPolicyList(List<PolicyListBean> policyList) {
            this.policyList = policyList;
        }

        public static class PolicyListBean {
            /**
             * applicant : 456
             * classId : 310022
             * classType : 2
             * detailId : 144
             * endTime : 20180222133409
             * extraInfos :
             * insureCountDetail : 1
             * insurePremiumDetail : 64700
             * insuredList : [{"insuredId":"1","insuredMobile":"","insuredName":"123","licenseNo":""}]
             * insurerId : 1
             * insurerLogo :
             * insurerName : 人保财险
             * isClaims :
             * jqxEndTime :
             * jqxStartTime :
             * payAmount : 64700
             * policyHolderMobile : 13656714459
             * policyId :
             * policyURL :
             * productId : 1049
             * productName : 安联国际旅行保险
             * productProp : 1040
             * startTime : 20170227133409
             * sts : 10
             * tradeDate : 20170227133309
             * tradeId : 20170227133309455272
             */

            private String applicant;
            private String classId;
            private int classType;
            private String detailId;
            private String endTime;
            private String extraInfos;
            private int insureCountDetail;
            private int insurePremiumDetail;
            private String insurerId;
            private String insurerLogo;
            private String insurerName;
            private String isClaims;
            private String jqxEndTime;
            private String jqxStartTime;
            private int payAmount;
            private String policyHolderMobile;
            private String policyId;
            private String policyURL;
            private String productId;
            private String productName;
            private int productProp;
            private String startTime;
            private String sts;
            private String tradeDate;
            private String tradeId;
            private List<InsuredListBean> insuredList;

            public String getApplicant() {
                return applicant;
            }

            public void setApplicant(String applicant) {
                this.applicant = applicant;
            }

            public String getClassId() {
                return classId;
            }

            public void setClassId(String classId) {
                this.classId = classId;
            }

            public int getClassType() {
                return classType;
            }

            public void setClassType(int classType) {
                this.classType = classType;
            }

            public String getDetailId() {
                return detailId;
            }

            public void setDetailId(String detailId) {
                this.detailId = detailId;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public String getExtraInfos() {
                return extraInfos;
            }

            public void setExtraInfos(String extraInfos) {
                this.extraInfos = extraInfos;
            }

            public int getInsureCountDetail() {
                return insureCountDetail;
            }

            public void setInsureCountDetail(int insureCountDetail) {
                this.insureCountDetail = insureCountDetail;
            }

            public int getInsurePremiumDetail() {
                return insurePremiumDetail;
            }

            public void setInsurePremiumDetail(int insurePremiumDetail) {
                this.insurePremiumDetail = insurePremiumDetail;
            }

            public String getInsurerId() {
                return insurerId;
            }

            public void setInsurerId(String insurerId) {
                this.insurerId = insurerId;
            }

            public String getInsurerLogo() {
                return insurerLogo;
            }

            public void setInsurerLogo(String insurerLogo) {
                this.insurerLogo = insurerLogo;
            }

            public String getInsurerName() {
                return insurerName;
            }

            public void setInsurerName(String insurerName) {
                this.insurerName = insurerName;
            }

            public String getIsClaims() {
                return isClaims;
            }

            public void setIsClaims(String isClaims) {
                this.isClaims = isClaims;
            }

            public String getJqxEndTime() {
                return jqxEndTime;
            }

            public void setJqxEndTime(String jqxEndTime) {
                this.jqxEndTime = jqxEndTime;
            }

            public String getJqxStartTime() {
                return jqxStartTime;
            }

            public void setJqxStartTime(String jqxStartTime) {
                this.jqxStartTime = jqxStartTime;
            }

            public int getPayAmount() {
                return payAmount;
            }

            public void setPayAmount(int payAmount) {
                this.payAmount = payAmount;
            }

            public String getPolicyHolderMobile() {
                return policyHolderMobile;
            }

            public void setPolicyHolderMobile(String policyHolderMobile) {
                this.policyHolderMobile = policyHolderMobile;
            }

            public String getPolicyId() {
                return policyId;
            }

            public void setPolicyId(String policyId) {
                this.policyId = policyId;
            }

            public String getPolicyURL() {
                return policyURL;
            }

            public void setPolicyURL(String policyURL) {
                this.policyURL = policyURL;
            }

            public String getProductId() {
                return productId;
            }

            public void setProductId(String productId) {
                this.productId = productId;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public int getProductProp() {
                return productProp;
            }

            public void setProductProp(int productProp) {
                this.productProp = productProp;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getSts() {
                return sts;
            }

            public void setSts(String sts) {
                this.sts = sts;
            }

            public String getTradeDate() {
                return tradeDate;
            }

            public void setTradeDate(String tradeDate) {
                this.tradeDate = tradeDate;
            }

            public String getTradeId() {
                return tradeId;
            }

            public void setTradeId(String tradeId) {
                this.tradeId = tradeId;
            }

            public List<InsuredListBean> getInsuredList() {
                return insuredList;
            }

            public void setInsuredList(List<InsuredListBean> insuredList) {
                this.insuredList = insuredList;
            }

            public static class InsuredListBean {
                /**
                 * insuredId : 1
                 * insuredMobile :
                 * insuredName : 123
                 * licenseNo :
                 */

                private String insuredId;
                private String insuredMobile;
                private String insuredName;
                private String licenseNo;

                public String getInsuredId() {
                    return insuredId;
                }

                public void setInsuredId(String insuredId) {
                    this.insuredId = insuredId;
                }

                public String getInsuredMobile() {
                    return insuredMobile;
                }

                public void setInsuredMobile(String insuredMobile) {
                    this.insuredMobile = insuredMobile;
                }

                public String getInsuredName() {
                    return insuredName;
                }

                public void setInsuredName(String insuredName) {
                    this.insuredName = insuredName;
                }

                public String getLicenseNo() {
                    return licenseNo;
                }

                public void setLicenseNo(String licenseNo) {
                    this.licenseNo = licenseNo;
                }
            }
        }
}
