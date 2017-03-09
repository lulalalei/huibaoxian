package com.bb.hbx.bean;

import java.util.List;

/**
 * 作者：Created by Administrator on 2017/3/9 10:18
 * 邮箱：
 * 描述：邀请好友信息类
 */
public class IniviteFriendsBean {

    /**
     * acctSum : 54645
     * count : 0
     * userAccountDetailRecord : [{"acctBalance":0,"acctFreezing":0,"acctId":0,"acctName":"","acctSum":54645,"logId":0,"tradeAddr":"","tradeAmount":0,"tradeDesc":"","tradeId":"","tradeType":0,"userLogo":"http://img.51hbx.com/resource/images/user/logo/43.jpg","userNickname":"好去"}]
     */

    private int acctSum;
    private int count;
    /**
     * acctBalance : 0
     * acctFreezing : 0
     * acctId : 0
     * acctName :
     * acctSum : 54645
     * logId : 0
     * tradeAddr :
     * tradeAmount : 0
     * tradeDesc :
     * tradeId :
     * tradeType : 0
     * userLogo : http://img.51hbx.com/resource/images/user/logo/43.jpg
     * userNickname : 好去
     */

    private List<UserAccountDetailRecordBean> userAccountDetailRecord;

    public int getAcctSum() {
        return acctSum;
    }

    public void setAcctSum(int acctSum) {
        this.acctSum = acctSum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<UserAccountDetailRecordBean> getUserAccountDetailRecord() {
        return userAccountDetailRecord;
    }

    public void setUserAccountDetailRecord(List<UserAccountDetailRecordBean> userAccountDetailRecord) {
        this.userAccountDetailRecord = userAccountDetailRecord;
    }

    public static class UserAccountDetailRecordBean {
        private int acctBalance;
        private int acctFreezing;
        private int acctId;
        private String acctName;
        private int acctSum;
        private int logId;
        private String tradeAddr;
        private int tradeAmount;
        private String tradeDesc;
        private String tradeId;
        private int tradeType;
        private String userLogo;
        private String userNickname;

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

        public String getAcctName() {
            return acctName;
        }

        public void setAcctName(String acctName) {
            this.acctName = acctName;
        }

        public int getAcctSum() {
            return acctSum;
        }

        public void setAcctSum(int acctSum) {
            this.acctSum = acctSum;
        }

        public int getLogId() {
            return logId;
        }

        public void setLogId(int logId) {
            this.logId = logId;
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

        public String getUserLogo() {
            return userLogo;
        }

        public void setUserLogo(String userLogo) {
            this.userLogo = userLogo;
        }

        public String getUserNickname() {
            return userNickname;
        }

        public void setUserNickname(String userNickname) {
            this.userNickname = userNickname;
        }
    }
}
