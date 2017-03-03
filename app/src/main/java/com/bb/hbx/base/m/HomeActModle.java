package com.bb.hbx.base.m;

import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.v.HomeActContract;

import retrofit2.Call;
import retrofit2.Callback;


/**
 * Created by fancl
 */

public class HomeActModle implements HomeActContract.Model {


    private ApiService service;

    public HomeActModle() {
        service = RetrofitFactory.getINSTANCE().create(ApiService.class);
    }


    @Override
    public void hasUpgradeRight(String userId, Callback callback) {
        Call call = service.hasUpgradeRight(userId);
        call.enqueue(callback);

    }
}
