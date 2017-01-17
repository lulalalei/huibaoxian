package com.bb.hbx.bean;


/**
 * Created by Administrator on 2017/1/14.
 */

public class RequestProduct {

    private int pageIndex;

    private int pageSize;

    private String specialId="";//专题编号

    private int productType;//分类编号

    private String key = "";//产品关键字

    private String tagId="";//产品标签编号

    private int getDefault;//是否返回系统默认产品列表

    private int defaultNum;//默认产品记录数

    private int sortCode;//排序码

    private int benefitNum;//保障利益数

    public int getBenefitNum() {
        return benefitNum;
    }

    public void setBenefitNum(int benefitNum) {
        this.benefitNum = benefitNum;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public int getDefaultNum() {
        return defaultNum;
    }

    public void setDefaultNum(int defaultNum) {
        this.defaultNum = defaultNum;
    }

    public int getGetDefault() {
        return getDefault;
    }

    public void setGetDefault(int getDefault) {
        this.getDefault = getDefault;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public String getSpecialId() {
        return specialId;
    }

    public void setSpecialId(String specialId) {
        this.specialId = specialId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }


    //-----------

}
