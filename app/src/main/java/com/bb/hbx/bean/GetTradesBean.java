package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */

public class GetTradesBean {

    /**
     * output : {"pageSize":"2","totalCount":"2","tradeList":[{"attachId":0,"auditSts":0,"classId":"210001","insuredList":[],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/100","payAmount":"2000","policyHolderMobile":"234235235235","policyHolderName":"孙悟空","productId":"100","productName":"航空意外保障","productProp":0,"spxSts":"20","sts":"20","tradeDate":"20170113201749","tradeId":"20170112194801002"},{"attachId":0,"auditSts":0,"classId":"210001","insuredList":[],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/100","payAmount":"2000","policyHolderMobile":"13989857704","policyHolderName":"猪八戒","productId":"100","productName":"航空意外保障","productProp":0,"spxSts":"35","sts":"20","tradeDate":"20170112201749","tradeId":"20170112194801001"}]}
     * respCode : 000000
     * respMsg : 获取订单列表成功
     * success : true
     */

    private OutputBean output;
    private String respCode;
    private String respMsg;
    private boolean success;

    public OutputBean getOutput() {
        return output;
    }

    public void setOutput(OutputBean output) {
        this.output = output;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class OutputBean {
        /**
         * pageSize : 2
         * totalCount : 2
         * tradeList : [{"attachId":0,"auditSts":0,"classId":"210001","insuredList":[],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/100","payAmount":"2000","policyHolderMobile":"234235235235","policyHolderName":"孙悟空","productId":"100","productName":"航空意外保障","productProp":0,"spxSts":"20","sts":"20","tradeDate":"20170113201749","tradeId":"20170112194801002"},{"attachId":0,"auditSts":0,"classId":"210001","insuredList":[],"insurerId":"1","insurerLogo":"","insurerName":"人保财险","orderURL":"http://ebao.seaway.net.cn:18100/product_details.html#productDetails/100","payAmount":"2000","policyHolderMobile":"13989857704","policyHolderName":"猪八戒","productId":"100","productName":"航空意外保障","productProp":0,"spxSts":"35","sts":"20","tradeDate":"20170112201749","tradeId":"20170112194801001"}]
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
             * classId : 210001
             * insuredList : []
             * insurerId : 1
             * insurerLogo :
             * insurerName : 人保财险
             * orderURL : http://ebao.seaway.net.cn:18100/product_details.html#productDetails/100
             * payAmount : 2000
             * policyHolderMobile : 234235235235
             * policyHolderName : 孙悟空
             * productId : 100
             * productName : 航空意外保障
             * productProp : 0
             * spxSts : 20
             * sts : 20
             * tradeDate : 20170113201749
             * tradeId : 20170112194801002
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
            private List<?> insuredList;

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

            public List<?> getInsuredList() {
                return insuredList;
            }

            public void setInsuredList(List<?> insuredList) {
                this.insuredList = insuredList;
            }
        }
    }
}
