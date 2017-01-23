package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */

public class ProductBean {


    /**
     * getDefault : 0
     * pageSize : 1
     * productList : []
     * totalCount : 1
     * {"output":{"getDefault":"0","pageSize":"3","productList":[{"ageDesc":"不限","benefitList":"","classId":"103249","commisionType":"1","commisionValue1":"35","guarantee":"","insurerId":"1","insurerLogo":"http://ebao.seaway.net.cn:181002","insurerName":"人保财险","minPremium":"50","monthAmount":"0","perferWords":"","productId":"100","productIntro":"全面保障您的出行","productLogo":"http://ebao.seaway.net.cn:18100http://s1.dwstatic.com/duowancn/shouji/12/480_320_50_59621cb1e9aaa4e880c9f4dabcaf252a.png","productName":"航空意外保障","productPrice":"50","productProp":"","productTagUrls":"","specialPrice":"50","suitable":"","totalAmount":"0"},{"ageDesc":"不限","benefitList":"","classId":"103249","commisionType":"1","commisionValue1":"50","guarantee":"","insurerId":"2","insurerLogo":"http://ebao.seaway.net.cn:181002","insurerName":"太平洋保险","minPremium":"30","monthAmount":"0","perferWords":"","productId":"1001","productIntro":"全面保障您的出行","productLogo":"http://ebao.seaway.net.cn:18100http://article.joyme.com/article/uploads/allimg/140617/18-14061G600290-L.jpg","productName":"孕妇健康险","productPrice":"30","productProp":"","productTagUrls":"","specialPrice":"30","suitable":"","totalAmount":"0"},{"ageDesc":"不限","benefitList":"","classId":"103249","commisionType":"1","commisionValue1":"50","guarantee":"","insurerId":"2","insurerLogo":"http://ebao.seaway.net.cn:181002","insurerName":"太平洋保险","minPremium":"30","monthAmount":"20","perferWords":"","productId":"1002","productIntro":"全面保障您的婚姻","productLogo":"http://ebao.seaway.net.cn:18100http://article.joyme.com/article/uploads/allimg/140617/18-14061G600290-L.jpg","productName":"单身狗保障险","productPrice":"30","productProp":"","productTagUrls":"","specialPrice":"30","suitable":"","totalAmount":"20"}],"totalCount":"3"},
     * "respCode":"000000","respMsg":"","success":true}
     */

    private String getDefault;
    private int pageSize;
    private String totalCount;
    private List<Product> productList;

    public String getGetDefault() {
        return getDefault;
    }

    public void setGetDefault(String getDefault) {
        this.getDefault = getDefault;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
