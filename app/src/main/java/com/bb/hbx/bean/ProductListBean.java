package com.bb.hbx.bean;

import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 */

public class ProductListBean implements Item {


    /**
     * ageDesc :
     * benefitList :
     * classId :
     * commisionType :
     * commisionValue1 :
     * guarantee :
     * insurerId :
     * insurerLogo :
     * insurerName :
     * minPremium : 0
     * monthAmount : 50
     * productId : 1001
     * productIntro : 全面保障您的出行
     * productLogo :
     * productName : 孕妇健康险
     * productPrice :
     * productProp :
     * productTagUrls :
     * specialPrice :
     * suitable :
     * totalAmount : 100
     * <p>
     * <p>
     * productId	产品编号	n	M	5
     * productName	产品名称	ansc	M	64
     * productLogo	产品图片	ans	M	128	产品图片URL
     * productIntro	产品简介	ansc	O	128
     * insurerId	保险公司编号	n	M	5	保险公司编号
     * insurerName	保险公司名称	ansc	M	64	保险公司名称
     * insurerLogo	保险公司Logo	ans	M	128	保险公司Logo
     * productProp	产品属性	n	M	10	位标识，定义暂缓，待明确
     * ageDesc	承保年龄	ans 	M	32	如：0~80周岁
     * guarantee	保障期限	ansc	M	32	如：1~30天/6个月/12个月
     * suitable	适用人群	ansc	M	32	如：热爱户外运动的人士
     * totalAmount	总销量	n	O	10	该产品一共销售数量
     * monthAmount	月销量	n	M	10	最近30天销量
     * productPrice	市场价	d	M	10	单位：分，起价。当有多个价格时取最低价
     * specialPrice	活动价	d	O	10	单位：分，起价。当有多个价格时取最低价
     * commisionType	推广费类型	N	M	1	存放本产品的分销推广费用类型，0：无推广费；1：按比例提取；2：按固定值提取，默认为1
     * commisionValue1	一级分销费率	n	M	12	一级分销推广费率值，与commision_type配合使用。commision_type=1，则一级分销佣金=产品支付价格 * commision_value1 / 100；commision_type=1，则一级分销佣金= commision_value1 ，单位：分；
     */

    private String ageDesc;

    private List<Benefit>benefitList;

    private String classId;
    private String commisionType;
    private String commisionValue1;
    private String guarantee;
    private String insurerId;
    private String insurerLogo;
    private String insurerName;
    private String minPremium;
    private String monthAmount;
    private String productId;
    private String productIntro;
    private String productLogo;
    private String productName;
    private String productPrice;
    private String productProp;
    private String productTagUrls;
    private String specialPrice;
    private String suitable;
    private String totalAmount;

    private String perferWords;

    //------------自己需求添加的参数
    private boolean isLine = true;

    public String getAgeDesc() {
        return ageDesc;
    }

    public void setAgeDesc(String ageDesc) {
        this.ageDesc = ageDesc;
    }



    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getCommisionType() {
        return commisionType;
    }

    public void setCommisionType(String commisionType) {
        this.commisionType = commisionType;
    }

    public String getCommisionValue1() {
        return commisionValue1;
    }

    public void setCommisionValue1(String commisionValue1) {
        this.commisionValue1 = commisionValue1;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
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

    public String getMinPremium() {
        return minPremium;
    }

    public void setMinPremium(String minPremium) {
        this.minPremium = minPremium;
    }

    public String getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(String monthAmount) {
        this.monthAmount = monthAmount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductIntro() {
        return productIntro;
    }

    public void setProductIntro(String productIntro) {
        this.productIntro = productIntro;
    }

    public String getProductLogo() {
        return productLogo;
    }

    public void setProductLogo(String productLogo) {
        this.productLogo = productLogo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductProp() {
        return productProp;
    }

    public void setProductProp(String productProp) {
        this.productProp = productProp;
    }

    public String getProductTagUrls() {
        return productTagUrls;
    }

    public void setProductTagUrls(String productTagUrls) {
        this.productTagUrls = productTagUrls;
    }

    public String getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(String specialPrice) {
        this.specialPrice = specialPrice;
    }

    public String getSuitable() {
        return suitable;
    }

    public void setSuitable(String suitable) {
        this.suitable = suitable;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isLine() {
        return isLine;
    }

    public void setLine(boolean line) {
        isLine = line;
    }

    public String getPerferWords() {
        return perferWords;
    }

    public void setPerferWords(String perferWords) {
        this.perferWords = perferWords;
    }

    public List<Benefit> getBenefitList() {
        return benefitList;
    }

    public void setBenefitList(List<Benefit> benefitList) {
        this.benefitList = benefitList;
    }
}
