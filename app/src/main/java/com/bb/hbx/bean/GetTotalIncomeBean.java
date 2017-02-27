package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/27.
 */

public class GetTotalIncomeBean {

    /**
     * output : {"pageSize":"2","totalAmount":"800","totalCount":"2","totalIncomeList":[{"monthTotalAmount":"500","tradeTime":"2017年2月"},{"monthTotalAmount":"300","tradeTime":"2017年1月"}]}
     * respCode : 000000
     * respMsg :
     * success : true
     */

        /**
         * pageSize : 2
         * totalAmount : 800
         * totalCount : 2
         * totalIncomeList : [{"monthTotalAmount":"500","tradeTime":"2017年2月"},{"monthTotalAmount":"300","tradeTime":"2017年1月"}]
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
             * monthTotalAmount : 500
             * tradeTime : 2017年2月
             */

            private String monthTotalAmount;
            private String tradeTime;

            public String getMonthTotalAmount() {
                return monthTotalAmount;
            }

            public void setMonthTotalAmount(String monthTotalAmount) {
                this.monthTotalAmount = monthTotalAmount;
            }

            public String getTradeTime() {
                return tradeTime;
            }

            public void setTradeTime(String tradeTime) {
                this.tradeTime = tradeTime;
            }
        }
}
