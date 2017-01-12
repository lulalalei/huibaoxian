package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 */

public class Special  {


    /**
     * endTime : 20170111182316
     * productCount :
     * productList : [{"classId":"","coverage":"","guarantee":"","insurerId":"","insurerLogo":"","insurerName":"","monthAmount":"","perferwords":"周伟亮测试1","productId":"1","productIntro":"","productLogo":"","productName":"周伟亮测试1","productPrice":"","productProp":"","productTagUrls":"","specialPrice":"50","suitable":"","totalAmount":"","typeList":""}]
     * specialContent : 关爱女性描述
     * specialId : 2
     * specialIntro :  关爱女性介绍
     * specialLogo :
     * specialName :  关爱女性
     * startTime : 20150529044826
     */

    private String endTime;
    private String productCount;
    private String specialContent;
    private String specialId;
    private String specialIntro;
    private String specialLogo;
    private String specialName;
    private String startTime;
    private List<ProductListBean> productList;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }

    public String getSpecialContent() {
        return specialContent;
    }

    public void setSpecialContent(String specialContent) {
        this.specialContent = specialContent;
    }

    public String getSpecialId() {
        return specialId;
    }

    public void setSpecialId(String specialId) {
        this.specialId = specialId;
    }

    public String getSpecialIntro() {
        return specialIntro;
    }

    public void setSpecialIntro(String specialIntro) {
        this.specialIntro = specialIntro;
    }

    public String getSpecialLogo() {
        return specialLogo;
    }

    public void setSpecialLogo(String specialLogo) {
        this.specialLogo = specialLogo;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public List<ProductListBean> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductListBean> productList) {
        this.productList = productList;
    }


}
