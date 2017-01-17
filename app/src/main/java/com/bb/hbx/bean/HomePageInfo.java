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

    private List<AdBean> ads;
    private List<XhbMsg> xhbMsgList;
    private List<ProductItem> productType;

    private List<Special> specialList;

    private boolean isBClient;


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

    public List<XhbMsg> getXhbMsgList() {
        return xhbMsgList;
    }

    public void setXhbMsgList(List<XhbMsg> xhbMsgList) {
        this.xhbMsgList = xhbMsgList;
    }

    public List<Special> getSpecialList() {
        return specialList;
    }

    public void setSpecialList(List<Special> specialList) {
        this.specialList = specialList;
    }

    public boolean getIsBClient() {
        return isBClient;
    }

    public void setIsBClient(boolean isBClient) {
        this.isBClient = isBClient;
    }
}
