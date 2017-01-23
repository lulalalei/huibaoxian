package com.bb.hbx.bean;

/**
 * Created by Administrator on 2017/1/21.
 */

public class Account {

    /**
     * output : {"accountScore":99,"acctBalance":2,"acctChecksum":"","acctFreezing":0,"acctId":1,"acctMonthSum":888,"acctName":"","acctSettSum":99,"acctSts":10,"acctSum":"","acctType":20,"bonusCount":"","cashCommMax":0,"cashCommMin":0,"cashCommPercent":0,"cashHold":0,"cashQuota":0,"userId":43}
     * respCode : 000000
     * respMsg : 获取用户账户信息成功
     * success : true
     */

        /**
         * accountScore : 99
         * acctBalance : 2
         * acctChecksum :
         * acctFreezing : 0
         * acctId : 1
         * acctMonthSum : 888
         * acctName :
         * acctSettSum : 99
         * acctSts : 10
         * acctSum :
         * acctType : 20
         * bonusCount :
         * cashCommMax : 0
         * cashCommMin : 0
         * cashCommPercent : 0
         * cashHold : 0
         * cashQuota : 0
         * serId : 43
         */

        private String accountScore;//用户可用积分
        private String acctBalance;
        private String acctChecksum;
        private String acctFreezing;
        private String acctId;
        private String acctMonthSum;
        private String acctName;
        private String acctSettSum;
        private String acctSts;
        private String acctSum;
        private String acctType;
        private String bonusCount;//红包
        private String cashCommMax;
        private String cashCommMin;
        private String cashCommPercent;
        private String cashHold;
        private String cashQuota;
        private String userId;

    public String getAccountScore() {
        return accountScore;
    }

    public void setAccountScore(String accountScore) {
        this.accountScore = accountScore;
    }

    public String getAcctBalance() {
        return acctBalance;
    }

    public void setAcctBalance(String acctBalance) {
        this.acctBalance = acctBalance;
    }

    public String getAcctChecksum() {
        return acctChecksum;
    }

    public void setAcctChecksum(String acctChecksum) {
        this.acctChecksum = acctChecksum;
    }

    public String getAcctFreezing() {
        return acctFreezing;
    }

    public void setAcctFreezing(String acctFreezing) {
        this.acctFreezing = acctFreezing;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getAcctMonthSum() {
        return acctMonthSum;
    }

    public void setAcctMonthSum(String acctMonthSum) {
        this.acctMonthSum = acctMonthSum;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getAcctSettSum() {
        return acctSettSum;
    }

    public void setAcctSettSum(String acctSettSum) {
        this.acctSettSum = acctSettSum;
    }

    public String getAcctSts() {
        return acctSts;
    }

    public void setAcctSts(String acctSts) {
        this.acctSts = acctSts;
    }

    public String getAcctSum() {
        return acctSum;
    }

    public void setAcctSum(String acctSum) {
        this.acctSum = acctSum;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getBonusCount() {
        return bonusCount;
    }

    public void setBonusCount(String bonusCount) {
        this.bonusCount = bonusCount;
    }

    public String getCashCommMax() {
        return cashCommMax;
    }

    public void setCashCommMax(String cashCommMax) {
        this.cashCommMax = cashCommMax;
    }

    public String getCashCommMin() {
        return cashCommMin;
    }

    public void setCashCommMin(String cashCommMin) {
        this.cashCommMin = cashCommMin;
    }

    public String getCashCommPercent() {
        return cashCommPercent;
    }

    public void setCashCommPercent(String cashCommPercent) {
        this.cashCommPercent = cashCommPercent;
    }

    public String getCashHold() {
        return cashHold;
    }

    public void setCashHold(String cashHold) {
        this.cashHold = cashHold;
    }

    public String getCashQuota() {
        return cashQuota;
    }

    public void setCashQuota(String cashQuota) {
        this.cashQuota = cashQuota;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
