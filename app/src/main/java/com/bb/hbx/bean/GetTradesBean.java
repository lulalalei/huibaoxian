package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */

public class GetTradesBean {


    /**
     * output : {"pageSize":"3","totalCount":"3","tradeList":[{"attachId":0,"auditSts":0,"classId":"103249","insuredList":[{"insuredId":"156","insuredMobile":"","insuredName":"222"}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/1092","payAmount":"64700","policyHolderMobile":"111111","policyHolderName":"1111","productId":"1092","productName":"车险测试产品","productProp":528,"spxSts":"10","sts":"10","tradeDate":"20170227193252","tradeId":"20170227193252677649"},{"attachId":0,"auditSts":0,"classId":"310022","insuredList":[{"insuredId":"142","insuredMobile":"","insuredName":"123"}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/1049","payAmount":"64700","policyHolderMobile":"13656714459","policyHolderName":"456","productId":"1049","productName":"安联国际旅行保险","productProp":1040,"spxSts":"10","sts":"10","tradeDate":"20170227103315","tradeId":"20170227103315836882"},{"attachId":0,"auditSts":0,"classId":"210001","insuredList":[],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/100","payAmount":"2000","policyHolderMobile":"13989857704","policyHolderName":"猪八戒","productId":"100","productName":"航空意外保障","productProp":0,"spxSts":"35","sts":"20","tradeDate":"20170112201749","tradeId":"20170112194801001"}]}
     * respCode : 000000
     * respMsg : 获取订单列表成功
     * success : true
     */

        /**
         * pageSize : 3
         * totalCount : 3
         * tradeList : [{"attachId":0,"auditSts":0,"classId":"103249","insuredList":[{"insuredId":"156","insuredMobile":"","insuredName":"222"}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/1092","payAmount":"64700","policyHolderMobile":"111111","policyHolderName":"1111","productId":"1092","productName":"车险测试产品","productProp":528,"spxSts":"10","sts":"10","tradeDate":"20170227193252","tradeId":"20170227193252677649"},{"attachId":0,"auditSts":0,"classId":"310022","insuredList":[{"insuredId":"142","insuredMobile":"","insuredName":"123"}],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/1049","payAmount":"64700","policyHolderMobile":"13656714459","policyHolderName":"456","productId":"1049","productName":"安联国际旅行保险","productProp":1040,"spxSts":"10","sts":"10","tradeDate":"20170227103315","tradeId":"20170227103315836882"},{"attachId":0,"auditSts":0,"classId":"210001","insuredList":[],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/100","payAmount":"2000","policyHolderMobile":"13989857704","policyHolderName":"猪八戒","productId":"100","productName":"航空意外保障","productProp":0,"spxSts":"35","sts":"20","tradeDate":"20170112201749","tradeId":"20170112194801001"}]
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
             * insuredList : [{"insuredId":"156","insuredMobile":"","insuredName":"222"}]
             * insurerId : 1
             * insurerLogo :
             * insurerName : 人保财险
             * orderURL : http://ebao.seaway.net.cn:18100/product_details.html#productDetails/1092
             * payAmount : 64700
             * policyHolderMobile : 111111
             * policyHolderName : 1111
             * productId : 1092
             * productName : 车险测试产品
             * productProp : 528
             * spxSts : 10
             * sts : 10
             * tradeDate : 20170227193252
             * tradeId : 20170227193252677649
             */

            private int attachId;
            private int auditSts;
            private String classId;
            private String insurerId;
            private String insurerLogo;
            private String insurerName;
            private String orderURL;
            private String payAmount;
            private String policyHolderMobile;
            private String policyHolderName;
            private String productId;
            private String productName;
            private int productProp;
            private String spxSts;
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
                 */

                private String insuredId;
                private String insuredMobile;
                private String insuredName;

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
            }
        }
}
