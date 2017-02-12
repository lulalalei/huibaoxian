package com.bb.hbx.base.m;

import android.util.Log;

import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.v.HomeContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/1/9.
 */

public class HomeModle implements HomeContract.Model {


    private ApiService service;

    public HomeModle() {
        service = RetrofitFactory.getINSTANCE().create(ApiService.class);
    }


    @Override
    public void getMsgs(String userId, String msgType, String sts, int pageIndex, int pageSize, Callback callback) {
        Call call = service.getMsgs(userId, msgType, sts, pageIndex, pageSize);
        call.enqueue(callback);
    }

    @Override
    public void getBannerInfo(Callback callback) {
        Call call = service.getBannerInfo();
        call.enqueue(callback);
    }

    @Override
    public void getXhbMessageInfo(Callback callback) {
        Call call = service.getXhbMessageInfo();
        call.enqueue(callback);
    }

    @Override
    public void getHomePageProductType(Callback callback) {
        Call call = service.getHomePageProductType();
        call.enqueue(callback);
    }

    @Override
    public void getHomePageProductList(Callback callback) {
        Call call = service.getHomePageProductList();
        call.enqueue(callback);
    }

    @Override
    public void getUnReadMessageCount(String userId, Callback callback) {
        Call call = service.getUnReadMessageCount(userId);
        call.enqueue(callback);
    }


}
