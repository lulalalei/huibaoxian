package com.bb.hbx.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/11.
 */

public class HomePageInfo implements Serializable {


    /**
     * ads : []
     * loop : 1
     * productType : []
     * showTime : 5
     * userLogo :
     */

    private String loop;
    private String showTime;
    private String userLogo;
    private List<AdBean> ads;
    private List<ProductItem> productType;

    public String getLoop() {
        return loop;
    }

    public void setLoop(String loop) {
        this.loop = loop;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getUserLogo() {
        return userLogo;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo;
    }

    public List<AdBean> getAds() {
        return ads;
    }

    public void setAds(List<AdBean> ads) {
        this.ads = ads;
    }

    public List<ProductItem> getProductType() {
        return productType;
    }

    public void setProductType(List<ProductItem> productType) {
        this.productType = productType;
    }
}
