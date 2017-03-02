package com.bb.hbx.bean;

/**
 * Created by Administrator on 2017/2/22.
 */

public class GetMyPageInfoBean {


    /**
     * output : {"acctBalance":9993,"acctSum":54645,"carPolicyCount":1,"couponCount":0,"nickName":"好去","policyCount":0,"realNameStatus":0,"score":9999,"userId":"","userLogo":"http://img.51hbx.com/resource/images/user/logo/43.jpg"}
     * respCode : 000000
     * respMsg : 用户首页信息取得成功
     * success : true
     */

        /**
         * acctBalance : 9993
         * acctSum : 54645
         * carPolicyCount : 1
         * couponCount : 0
         * nickName : 好去
         * policyCount : 0
         * realNameStatus : 0
         * score : 9999
         * userId :
         * userLogo : http://img.51hbx.com/resource/images/user/logo/43.jpg
         */

        private int acctBalance;
        private int acctSum;
        private int carPolicyCount;
        private int couponCount;
        private String nickName;
        private int policyCount;
        private int realNameStatus;
        private int score;
        private String userId;
        private String userLogo;

        public int getAcctBalance() {
            return acctBalance;
        }

        public void setAcctBalance(int acctBalance) {
            this.acctBalance = acctBalance;
        }

        public int getAcctSum() {
            return acctSum;
        }

        public void setAcctSum(int acctSum) {
            this.acctSum = acctSum;
        }

        public int getCarPolicyCount() {
            return carPolicyCount;
        }

        public void setCarPolicyCount(int carPolicyCount) {
            this.carPolicyCount = carPolicyCount;
        }

        public int getCouponCount() {
            return couponCount;
        }

        public void setCouponCount(int couponCount) {
            this.couponCount = couponCount;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getPolicyCount() {
            return policyCount;
        }

        public void setPolicyCount(int policyCount) {
            this.policyCount = policyCount;
        }

        public int getRealNameStatus() {
            return realNameStatus;
        }

        public void setRealNameStatus(int realNameStatus) {
            this.realNameStatus = realNameStatus;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserLogo() {
            return userLogo;
        }

        public void setUserLogo(String userLogo) {
            this.userLogo = userLogo;
        }
}
