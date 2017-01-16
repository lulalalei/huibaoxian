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
    public void getHomePageInfo(String userId, Callback callback) {
        Call call = service.getHomePageInfo(userId);
        call.enqueue(callback);

    }


}
