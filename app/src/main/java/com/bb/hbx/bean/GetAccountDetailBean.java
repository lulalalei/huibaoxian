package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */

public class GetAccountDetailBean {

    /**
     * output : {"accountDetailList":[{"acctBalance":55,"acctFreezing":0,"acctId":4,"logId":10,"logTime":1485157491000,"tradeAddr":"","tradeAmount":55,"tradeDesc":"","tradeId":"","tradeType":40},{"acctBalance":33,"acctFreezing":0,"acctId":4,"logId":9,"logTime":1485157477000,"tradeAddr":"","tradeAmount":33,"tradeDesc":"","tradeId":"","tradeType":31},{"acctBalance":11,"acctFreezing":0,"acctId":4,"logId":8,"logTime":1485157467000,"tradeAddr":"","tradeAmount":11,"tradeDesc":"","tradeId":"","tradeType":30},{"acctBalance":22,"acctFreezing":0,"acctId":1,"logId":7,"logTime":1485157453000,"tradeAddr":"","tradeAmount":333,"tradeDesc":"","tradeId":"","tradeType":30},{"acctBalance":333,"acctFreezing":0,"acctId":7,"logId":6,"logTime":1485157436000,"tradeAddr":"","tradeAmount":33,"tradeDesc":"","tradeId":"","tradeType":30},{"acctBalance":331,"acctFreezing":0,"acctId":7,"logId":5,"logTime":1485157421000,"tradeAddr":"","tradeAmount":232,"tradeDesc":"","tradeId":"","tradeType":30},{"acctBalance":1,"acctFreezing":0,"acctId":1,"logId":4,"logTime":1485157408000,"tradeAddr":"","tradeAmount":33,"tradeDesc":"","tradeId":"","tradeType":30},{"acctBalance":1,"acctFreezing":0,"acctId":1,"logId":3,"logTime":1485157387000,"tradeAddr":"","tradeAmount":2,"tradeDesc":"","tradeId":"","tradeType":31},{"acctBalance":1,"acctFreezing":0,"acctId":1,"logId":2,"logTime":1485157371000,"tradeAddr":"","tradeAmount":33,"tradeDesc":"","tradeId":"","tradeType":31},{"acctBalance":2,"acctFreezing":0,"acctId":1,"logId":1,"logTime":1485141466000,"tradeAddr":"","tradeAmount":99,"tradeDesc":"","tradeId":"","tradeType":31}],"pageIndex":"1","pageSize":"10","totalCount":"11"}
     * respCode : 000000
     * respMsg : 获取账户明信息成功
     * success : true
     */

        /**
         * accountDetailList : [{"acctBalance":55,"acctFreezing":0,"acctId":4,"logId":10,"logTime":1485157491000,"tradeAddr":"","tradeAmount":55,"tradeDesc":"","tradeId":"","tradeType":40},{"acctBalance":33,"acctFreezing":0,"acctId":4,"logId":9,"logTime":1485157477000,"tradeAddr":"","tradeAmount":33,"tradeDesc":"","tradeId":"","tradeType":31},{"acctBalance":11,"acctFreezing":0,"acctId":4,"logId":8,"logTime":1485157467000,"tradeAddr":"","tradeAmount":11,"tradeDesc":"","tradeId":"","tradeType":30},{"acctBalance":22,"acctFreezing":0,"acctId":1,"logId":7,"logTime":1485157453000,"tradeAddr":"","tradeAmount":333,"tradeDesc":"","tradeId":"","tradeType":30},{"acctBalance":333,"acctFreezing":0,"acctId":7,"logId":6,"logTime":1485157436000,"tradeAddr":"","tradeAmount":33,"tradeDesc":"","tradeId":"","tradeType":30},{"acctBalance":331,"acctFreezing":0,"acctId":7,"logId":5,"logTime":1485157421000,"tradeAddr":"","tradeAmount":232,"tradeDesc":"","tradeId":"","tradeType":30},{"acctBalance":1,"acctFreezing":0,"acctId":1,"logId":4,"logTime":1485157408000,"tradeAddr":"","tradeAmount":33,"tradeDesc":"","tradeId":"","tradeType":30},{"acctBalance":1,"acctFreezing":0,"acctId":1,"logId":3,"logTime":1485157387000,"tradeAddr":"","tradeAmount":2,"tradeDesc":"","tradeId":"","tradeType":31},{"acctBalance":1,"acctFreezing":0,"acctId":1,"logId":2,"logTime":1485157371000,"tradeAddr":"","tradeAmount":33,"tradeDesc":"","tradeId":"","tradeType":31},{"acctBalance":2,"acctFreezing":0,"acctId":1,"logId":1,"logTime":1485141466000,"tradeAddr":"","tradeAmount":99,"tradeDesc":"","tradeId":"","tradeType":31}]
         * pageIndex : 1
         * pageSize : 10
         * totalCount : 11
         */

        private String pageIndex;
        private String pageSize;
        private String totalCount;
        private List<AccountDetailListBean> accountDetailList;

        public String getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(String pageIndex) {
            this.pageIndex = pageIndex;
        }

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

        public List<AccountDetailListBean> getAccountDetailList() {
            return accountDetailList;
        }

        public void setAccountDetailList(List<AccountDetailListBean> accountDetailList) {
            this.accountDetailList = accountDetailList;
        }

        public static class AccountDetailListBean {
            /**
             * acctBalance : 55
             * acctFreezing : 0
             * acctId : 4
             * logId : 10
             * logTime : 1485157491000
             * tradeAddr :
             * tradeAmount : 55
             * tradeDesc :
             * tradeId :
             * tradeType : 40
             */

            private int acctBalance;
            private int acctFreezing;
            private int acctId;
            private int logId;
            private long logTime;
            private String tradeAddr;
            private int tradeAmount;
            private String tradeDesc;
            private String tradeId;
            private int tradeType;

            public int getAcctBalance() {
                return acctBalance;
            }

            public void setAcctBalance(int acctBalance) {
                this.acctBalance = acctBalance;
            }

            public int getAcctFreezing() {
                return acctFreezing;
            }

            public void setAcctFreezing(int acctFreezing) {
                this.acctFreezing = acctFreezing;
            }

            public int getAcctId() {
                return acctId;
            }

            public void setAcctId(int acctId) {
                this.acctId = acctId;
            }

            public int getLogId() {
                return logId;
            }

            public void setLogId(int logId) {
                this.logId = logId;
            }

            public long getLogTime() {
                return logTime;
            }

            public void setLogTime(long logTime) {
                this.logTime = logTime;
            }

            public String getTradeAddr() {
                return tradeAddr;
            }

            public void setTradeAddr(String tradeAddr) {
                this.tradeAddr = tradeAddr;
            }

            public int getTradeAmount() {
                return tradeAmount;
            }

            public void setTradeAmount(int tradeAmount) {
                this.tradeAmount = tradeAmount;
            }

            public String getTradeDesc() {
                return tradeDesc;
            }

            public void setTradeDesc(String tradeDesc) {
                this.tradeDesc = tradeDesc;
            }

            public String getTradeId() {
                return tradeId;
            }

            public void setTradeId(String tradeId) {
                this.tradeId = tradeId;
            }

            public int getTradeType() {
                return tradeType;
            }

            public void setTradeType(int tradeType) {
                this.tradeType = tradeType;
            }
        }
}
