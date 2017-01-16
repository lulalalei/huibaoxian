package com.bb.hbx.bean;



/**
 * Created by Administrator on 2017/1/14.
 */

public class RequestProduct {

    private int pageIndex;

    private int pageSize;

    private int specialId;//专题编号

    private int productType;//分类编号

    private String key;//产品关键字

    private int tagId;//产品标签编号

    private int getDefault;//是否返回系统默认产品列表

    private int defaultNum;//默认产品记录数

    private int sortCode;//排序码

    private int benefitNum;//保障利益数
}
