package com.bb.hbx.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */

public class PayDetail implements Serializable {


    /**
     * acctBalanceJF : 1000000
     * acctBalanceYE : 1000000
     * couponList : []
     * payPrice : 64700
     * payments : []
     * tradeId : 20170223102154132209
     */

    private int acctBalanceJF;
    private int acctBalanceYE;
    private String payPrice;
    private String tradeId;
    private List<GetUserCouponsListBean.CouponListBean> couponList;
    private List<Payment> payments;


    private String productName;//

    private String tips;//

    private String payDeadline;//

    private String deductible;//

    public int getAcctBalanceJF() {
        return acctBalanceJF;
    }

    public void setAcctBalanceJF(int acctBalanceJF) {
        this.acctBalanceJF = acctBalanceJF;
    }

    public int getAcctBalanceYE() {
        return acctBalanceYE;
    }

    public void setAcctBalanceYE(int acctBalanceYE) {
        this.acctBalanceYE = acctBalanceYE;
    }

    public String getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(String payPrice) {
        this.payPrice = payPrice;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public List<GetUserCouponsListBean.CouponListBean> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<GetUserCouponsListBean.CouponListBean> couponList) {
        this.couponList = couponList;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDeductible() {
        return deductible;
    }

    public void setDeductible(String deductible) {
        this.deductible = deductible;
    }

    public String getPayDeadline() {
        return payDeadline;
    }

    public void setPayDeadline(String payDeadline) {
        this.payDeadline = payDeadline;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }


    public static class Payment {
        private String paymentId;//支付方式编号
        private String quotaUsage;//限额方式

        private String quota;//支付限额

        public String getPaymentId() {
            return paymentId;
        }

        public void setPaymentId(String paymentId) {
            this.paymentId = paymentId;
        }

        public String getQuota() {
            return quota;
        }

        public void setQuota(String quota) {
            this.quota = quota;
        }

        public String getQuotaUsage() {
            return quotaUsage;
        }

        public void setQuotaUsage(String quotaUsage) {
            this.quotaUsage = quotaUsage;
        }
    }
}
