package com.bb.hbx.bean;

/**
 * Created by Administrator on 2017/2/14.
 */

public class PriceTag {

    /**
     * defaultPrice : 0
     * priceId : 322
     * priceKeyword : 乐享全球计划;已成年;11天至14天
     * productPremium : 26000
     */

    private String defaultPrice;
    private String priceId;
    private String priceKeyword;
    private String productPremium;

    public String getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(String defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    public String getPriceKeyword() {
        return priceKeyword;
    }

    public void setPriceKeyword(String priceKeyword) {
        this.priceKeyword = priceKeyword;
    }

    public String getProductPremium() {
        return productPremium;
    }

    public void setProductPremium(String productPremium) {
        this.productPremium = productPremium;
    }
}
