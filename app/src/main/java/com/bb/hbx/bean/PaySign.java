package com.bb.hbx.bean;

/**
 * Created by Administrator on 2017/2/25.
 */

public class PaySign {

    /**
     * inputcharset	编码格式
     * subject	商品名称
     * body	商品描述
     * notifyurl	通知回调地址
     * outtradeno	商户订单号
     * partner	合作伙伴编号
     * paymenttype	支付方式
     * sellerid	卖家支付宝账号
     * service	接口名称
     * sign	签名
     * signtype	签名方式
     * totalfee	支付金额
     * itbpay	支付超时时间
     **/

    private String inputcharset;

    private String subject;

    private String body;

    private String notifyurl;


    private String outtradeno;

    private String partner;

    private String paymenttype;

    private String sellerid;

    private String service;

    private String sign;

    private String signtype;

    private String totalfee;

    private String itbpay;

    public String getInputcharset() {
        return inputcharset;
    }

    public void setInputcharset(String inputcharset) {
        this.inputcharset = inputcharset;
    }

    public String getItbpay() {
        return itbpay;
    }

    public void setItbpay(String itbpay) {
        this.itbpay = itbpay;
    }

    public String getNotifyurl() {
        return notifyurl;
    }

    public void setNotifyurl(String notifyurl) {
        this.notifyurl = notifyurl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOuttradeno() {
        return outtradeno;
    }

    public void setOuttradeno(String outtradeno) {
        this.outtradeno = outtradeno;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSigntype() {
        return signtype;
    }

    public void setSigntype(String signtype) {
        this.signtype = signtype;
    }

    public String getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(String totalfee) {
        this.totalfee = totalfee;
    }
}
