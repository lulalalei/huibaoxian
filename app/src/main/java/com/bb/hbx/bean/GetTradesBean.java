package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */

public class GetTradesBean {


    /**
     * output : {"pageSize":"4","totalCount":"4","tradeList":[{"attachId":0,"auditSts":0,"classId":"103249","classType":1,"commisionValue1":0,"endTime":"20180222193352","extraInfos":"","insuredList":[{"insuredId":"156","insuredMobile":"","insuredName":"222","licenseNo":"浙12345"},{"insuredId":"180","insuredMobile":"","insuredName":"222","licenseNo":"浙12345"}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","jqxEndTime":"20170302093723","jqxStartTime":"20170302093723","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/1092","payAmount":"64700","policyHolderMobile":"111111","policyHolderName":"1111","productId":"1092","productName":"车险测试产品","productProp":528,"spxSts":"10","startTime":"20170227193352","sts":"10","tradeDate":"20170227193252","tradeId":"20170227193252677649"},{"attachId":0,"auditSts":0,"classId":"310022","classType":2,"commisionValue1":0,"endTime":"20180222133409","extraInfos":"","insuredList":[{"insuredId":"144","insuredMobile":"","insuredName":"123","licenseNo":""}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","jqxEndTime":"","jqxStartTime":"","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/1049","payAmount":"64700","policyHolderMobile":"13656714459","policyHolderName":"456","productId":"1049","productName":"安联国际旅行保险","productProp":1040,"spxSts":"10","startTime":"20170227133409","sts":"10","tradeDate":"20170227133309","tradeId":"20170227133309455272"},{"attachId":0,"auditSts":0,"classId":"310022","classType":2,"commisionValue1":0,"endTime":"20180222104041","extraInfos":"","insuredList":[{"insuredId":"143","insuredMobile":"","insuredName":"123","licenseNo":""}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","jqxEndTime":"","jqxStartTime":"","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/1049","payAmount":"64700","policyHolderMobile":"13656714459","policyHolderName":"456","productId":"1049","productName":"安联国际旅行保险","productProp":1040,"spxSts":"10","startTime":"20170227104041","sts":"10","tradeDate":"20170227103941","tradeId":"20170227103941584210"},{"attachId":0,"auditSts":0,"classId":"310022","classType":2,"commisionValue1":0,"endTime":"20180222103415","extraInfos":"","insuredList":[{"insuredId":"142","insuredMobile":"","insuredName":"123","licenseNo":""}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","jqxEndTime":"","jqxStartTime":"","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/1049","payAmount":"64700","policyHolderMobile":"13656714459","policyHolderName":"456","productId":"1049","productName":"安联国际旅行保险","productProp":1040,"spxSts":"10","startTime":"20170227103415","sts":"10","tradeDate":"20170227103315","tradeId":"20170227103315836882"}]}
     * respCode : 000000
     * respMsg : 获取订单列表成功
     * success : true
     */

        /**
         * pageSize : 4
         * totalCount : 4
         * tradeList : [{"attachId":0,"auditSts":0,"classId":"103249","classType":1,"commisionValue1":0,"endTime":"20180222193352","extraInfos":"","insuredList":[{"insuredId":"156","insuredMobile":"","insuredName":"222","licenseNo":"浙12345"},{"insuredId":"180","insuredMobile":"","insuredName":"222","licenseNo":"浙12345"}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","jqxEndTime":"20170302093723","jqxStartTime":"20170302093723","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/1092","payAmount":"64700","policyHolderMobile":"111111","policyHolderName":"1111","productId":"1092","productName":"车险测试产品","productProp":528,"spxSts":"10","startTime":"20170227193352","sts":"10","tradeDate":"20170227193252","tradeId":"20170227193252677649"},{"attachId":0,"auditSts":0,"classId":"310022","classType":2,"commisionValue1":0,"endTime":"20180222133409","extraInfos":"","insuredList":[{"insuredId":"144","insuredMobile":"","insuredName":"123","licenseNo":""}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","jqxEndTime":"","jqxStartTime":"","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/1049","payAmount":"64700","policyHolderMobile":"13656714459","policyHolderName":"456","productId":"1049","productName":"安联国际旅行保险","productProp":1040,"spxSts":"10","startTime":"20170227133409","sts":"10","tradeDate":"20170227133309","tradeId":"20170227133309455272"},{"attachId":0,"auditSts":0,"classId":"310022","classType":2,"commisionValue1":0,"endTime":"20180222104041","extraInfos":"","insuredList":[{"insuredId":"143","insuredMobile":"","insuredName":"123","licenseNo":""}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","jqxEndTime":"","jqxStartTime":"","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/1049","payAmount":"64700","policyHolderMobile":"13656714459","policyHolderName":"456","productId":"1049","productName":"安联国际旅行保险","productProp":1040,"spxSts":"10","startTime":"20170227104041","sts":"10","tradeDate":"20170227103941","tradeId":"20170227103941584210"},{"attachId":0,"auditSts":0,"classId":"310022","classType":2,"commisionValue1":0,"endTime":"20180222103415","extraInfos":"","insuredList":[{"insuredId":"142","insuredMobile":"","insuredName":"123","licenseNo":""}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","jqxEndTime":"","jqxStartTime":"","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/1049","payAmount":"64700","policyHolderMobile":"13656714459","policyHolderName":"456","productId":"1049","productName":"安联国际旅行保险","productProp":1040,"spxSts":"10","startTime":"20170227103415","sts":"10","tradeDate":"20170227103315","tradeId":"20170227103315836882"}]
         */

        private String pageSize;
        private String totalCount;
        private List<TradeListBean> tradeList;

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

        public List<TradeListBean> getTradeList() {
            return tradeList;
        }

        public void setTradeList(List<TradeListBean> tradeList) {
            this.tradeList = tradeList;
        }

        public static class TradeListBean {
            /**
             * attachId : 0
             * auditSts : 0
             * classId : 103249
             * classType : 1
             * commisionValue1 : 0
             * endTime : 20180222193352
             * extraInfos :
             * insuredList : [{"insuredId":"156","insuredMobile":"","insuredName":"222","licenseNo":"浙12345"},{"insuredId":"180","insuredMobile":"","insuredName":"222","licenseNo":"浙12345"}]
             * insurerId : 1
             * insurerLogo :
             * insurerName : 人保财险
             * jqxEndTime : 20170302093723
             * jqxStartTime : 20170302093723
             * orderURL : http://ebao.seaway.net.cn:18100/product_details.html#productDetails/1092
             * payAmount : 64700
             * policyHolderMobile : 111111
             * policyHolderName : 1111
             * productId : 1092
             * productName : 车险测试产品
             * productProp : 528
             * spxSts : 10
             * startTime : 20170227193352
             * sts : 10
             * tradeDate : 20170227193252
             * tradeId : 20170227193252677649
             */

            private int attachId;
            private int auditSts;
            private String classId;
            private int classType;
            private int commisionValue1;
            private String endTime;
            private String extraInfos;
            private String insurerId;
            private String insurerLogo;
            private String insurerName;
            private String jqxEndTime;
            private String jqxStartTime;
            private String orderURL;
            private String payAmount;
            private String policyHolderMobile;
            private String policyHolderName;
            private String productId;
            private String productName;
            private int productProp;
            private String spxSts;
            private String startTime;
            private String sts;
            private String tradeDate;
            private String tradeId;
            private List<InsuredListBean> insuredList;

            public int getAttachId() {
                return attachId;
            }

            public void setAttachId(int attachId) {
                this.attachId = attachId;
            }

            public int getAuditSts() {
                return auditSts;
            }

            public void setAuditSts(int auditSts) {
                this.auditSts = auditSts;
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

            public int getCommisionValue1() {
                return commisionValue1;
            }

            public void setCommisionValue1(int commisionValue1) {
                this.commisionValue1 = commisionValue1;
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

            public String getOrderURL() {
                return orderURL;
            }

            public void setOrderURL(String orderURL) {
                this.orderURL = orderURL;
            }

            public String getPayAmount() {
                return payAmount;
            }

            public void setPayAmount(String payAmount) {
                this.payAmount = payAmount;
            }

            public String getPolicyHolderMobile() {
                return policyHolderMobile;
            }

            public void setPolicyHolderMobile(String policyHolderMobile) {
                this.policyHolderMobile = policyHolderMobile;
            }

            public String getPolicyHolderName() {
                return policyHolderName;
            }

            public void setPolicyHolderName(String policyHolderName) {
                this.policyHolderName = policyHolderName;
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

            public String getSpxSts() {
                return spxSts;
            }

            public void setSpxSts(String spxSts) {
                this.spxSts = spxSts;
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
                 * insuredId : 156
                 * insuredMobile :
                 * insuredName : 222
                 * licenseNo : 浙12345
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
