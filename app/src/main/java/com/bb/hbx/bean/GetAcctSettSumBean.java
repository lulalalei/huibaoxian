package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/21.
 */

public class GetAcctSettSumBean {

    /**
     * output : {"pageSize":"1","settSumList":[{"policyNo":"","productName":"个险","settSum":"5","tradeId":"20170112194801001","tradeTime":"2017-01-12 20:17:49"}],"totalAmount":"5","totalCount":"1"}
     * respCode : 000000
     * respMsg :
     * success : true
     */

        /**
         * pageSize : 1
         * settSumList : [{"policyNo":"","productName":"个险","settSum":"5","tradeId":"20170112194801001","tradeTime":"2017-01-12 20:17:49"}]
         * totalAmount : 5
         * totalCount : 1
         */

        private String pageSize;
        private String totalAmount;
        private String totalCount;
        private List<SettSumListBean> settSumList;

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public String getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public List<SettSumListBean> getSettSumList() {
            return settSumList;
        }

        public void setSettSumList(List<SettSumListBean> settSumList) {
            this.settSumList = settSumList;
        }

        public static class SettSumListBean {
            /**
             * policyNo :
             * productName : 个险
             * settSum : 5
             * tradeId : 20170112194801001
             * tradeTime : 2017-01-12 20:17:49
             */

            private String policyNo;
            private String productName;
            private String settSum;
            private String tradeId;
            private String tradeTime;

            public String getPolicyNo() {
                return policyNo;
            }

            public void setPolicyNo(String policyNo) {
                this.policyNo = policyNo;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getSettSum() {
                return settSum;
            }

            public void setSettSum(String settSum) {
                this.settSum = settSum;
            }

            public String getTradeId() {
                return tradeId;
            }

            public void setTradeId(String tradeId) {
                this.tradeId = tradeId;
            }

            public String getTradeTime() {
                return tradeTime;
            }

            public void setTradeTime(String tradeTime) {
                this.tradeTime = tradeTime;
            }
        }
}
