package com.bb.hbx.bean;

import com.bb.hbx.interfaces.IIndexTargetInterface;

/**
 * 索引类的汉语拼音的接口
 * Created by Administrator on 2016/12/1.
 */

public abstract class BaseIndexPinyinBean extends BaseIndexTagBean implements IIndexTargetInterface {

    //城市的拼音
    public String pyCity;

    public String getPyCity() {
        return pyCity;
    }

    public void setPyCity(String pyCity) {
        this.pyCity = pyCity;
    }
}
