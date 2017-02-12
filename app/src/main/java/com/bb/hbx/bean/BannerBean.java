package com.bb.hbx.bean;

import android.support.annotation.NonNull;

import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */

public class BannerBean implements Item {

    private  List<AdBean> ads;

    public BannerBean() {

    }


    public BannerBean(@NonNull final List<AdBean>ads) {
        this.ads = ads;
    }

    public List<AdBean> getAds() {
        return ads;
    }

    public void setAds(List<AdBean> ads) {
        this.ads = ads;
    }
}
