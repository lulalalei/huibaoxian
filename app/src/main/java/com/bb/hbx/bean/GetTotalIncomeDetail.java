package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/27.
 */

public class GetTotalIncomeDetail {

    /**
     * output : {"pageSize":"4","totalAmount":"467","totalCount":"4","totalIncomeList":[{"dayTotalAmount":"99","productName":"产生积分2","tradeNo":"","tradeTime":"2017-02-25"},{"dayTotalAmount":"2","productName":"","tradeNo":"","tradeTime":"2017-02-23"},{"dayTotalAmount":"333","productName":"","tradeNo":"","tradeTime":"2017-02-21"},{"dayTotalAmount":"33","productName":"","tradeNo":"","tradeTime":"2017-02-20"}]}
     * respCode : 000000
     * respMsg :
     * success : true
     */

        /**
         * pageSize : 4
         * totalAmount : 467
         * totalCount : 4
         * totalIncomeList : [{"dayTotalAmount":"99","productName":"产生积分2","tradeNo":"","tradeTime":"2017-02-25"},{"dayTotalAmount":"2","productName":"","tradeNo":"","tradeTime":"2017-02-23"},{"dayTotalAmount":"333","productName":"","tradeNo":"","tradeTime":"2017-02-21"},{"dayTotalAmount":"33","productName":"","tradeNo":"","tradeTime":"2017-02-20"}]
         */

        private String pageSize;
        private String totalAmount;
        private String totalCount;
        private List<TotalIncomeListBean> totalIncomeList;

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

        public List<TotalIncomeListBean> getTotalIncomeList() {
            return totalIncomeList;
        }

        public void setTotalIncomeList(List<TotalIncomeListBean> totalIncomeList) {
            this.totalIncomeList = totalIncomeList;
        }

        public static class TotalIncomeListBean {
            /**
             * dayTotalAmount : 99
             * productName : 产生积分2
             * tradeNo :
             * tradeTime : 2017-02-25
             */

            private String dayTotalAmount;
            private String productName;
            private String tradeNo;
            private String tradeTime;

            public String getDayTotalAmount() {
                return dayTotalAmount;
            }

            public void setDayTotalAmount(String dayTotalAmount) {
                this.dayTotalAmount = dayTotalAmount;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getTradeNo() {
                return tradeNo;
            }

            public void setTradeNo(String tradeNo) {
                this.tradeNo = tradeNo;
            }

            public String getTradeTime() {
                return tradeTime;
            }

            public void setTradeTime(String tradeTime) {
                this.tradeTime = tradeTime;
            }
        }
}
