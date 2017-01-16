package com.bb.hbx.bean;

import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 */

public class Special  implements Item{



    private List<ProductListBean> productList;


    /**
     * endTime :
     * productCount :
     * specialContent :
     * specialId : 2
     * specialIntro :  关爱女性介绍
     * specialLogo : http://pic12.nipic.com/20110104/1984213_110016002109_2.jpg
     * specialName :  精选专题
     * specialType : 10
     * specialUrl :
     * startTime :
     *
     * specialId	专题编号	n	M	6
     specialName	专题名称	ansc	M	32
     specialType	专题类型	n	M	128	10：普通专题；20：爆款
     specialLogo1	专题宣传小图	ans	M	128	专题宣传小图URL地址，通常用于logo类图片
     specialLogo2	专题中图片	ans	M	128	专题宣传中图URL地址，通常用于列表显示图片
     specialLogo3	专题大图片	ans	M	128	专题宣传大图URL地址，通常用于广告类图片
     specialUrl	专题页面地址	ans	M	128	存放专题页面url地址
     specialIntro	专题简介	ansc	O	256	专题简介，字数控制在100以内
     specialDesc	专题详情	ansc	O	1024	专题详情，不超过500字

     */

    private String endTime;
    private String productCount;
    private String specialContent;
    private String specialId;
    private String specialIntro;
    private String specialLogo;
    private String specialName;
    private int specialType;
    private String specialUrl;
    private String startTime;

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

    public int getSpecialType() {
        return specialType;
    }

    public void setSpecialType(int specialType) {
        this.specialType = specialType;
    }

    public String getSpecialUrl() {
        return specialUrl;
    }

    public void setSpecialUrl(String specialUrl) {
        this.specialUrl = specialUrl;
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
