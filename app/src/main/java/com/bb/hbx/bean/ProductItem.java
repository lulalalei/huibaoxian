package com.bb.hbx.bean;

import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

/**
 * Created by Administrator on 2017/1/11.
 */

public class ProductItem implements Item{


    /**
     * id : 103124
     * logo :
     * name : 孕妇险
     * url : http://ebao.seaway.net.cn:18100/product.html#productType/103124
     * id	分类险ID	n	M	6
     name	分类险名称	ansc	M	10	最多三个汉字
     logo	分类险logo	ans	M	128	logo URL
     url	跳转URL	ans	M	128

     */

    private String insurerTypeId;
    private String insurerTypeLogo;
    private String insurerTypeName;
    private String insurerTypeUrl;

    private List<ProductItem> productType;


    public String getInsurerTypeId() {
        return insurerTypeId;
    }

    public void setInsurerTypeId(String insurerTypeId) {
        this.insurerTypeId = insurerTypeId;
    }

    public String getInsurerTypeLogo() {
        return insurerTypeLogo;
    }

    public void setInsurerTypeLogo(String insurerTypeLogo) {
        this.insurerTypeLogo = insurerTypeLogo;
    }

    public String getInsurerTypeName() {
        return insurerTypeName;
    }

    public void setInsurerTypeName(String insurerTypeName) {
        this.insurerTypeName = insurerTypeName;
    }

    public String getInsurerTypeUrl() {
        return insurerTypeUrl;
    }

    public void setInsurerTypeUrl(String insurerTypeUrl) {
        this.insurerTypeUrl = insurerTypeUrl;
    }

    public List<ProductItem> getProductType() {
        return productType;
    }

    public void setProductType(List<ProductItem> productType) {
        this.productType = productType;
    }
}
