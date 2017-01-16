package com.bb.hbx.base.m;

import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.v.MallContract;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/13.
 */

public class MallModel implements MallContract.Model {


    private ApiService service;



    public MallModel() {
        service = RetrofitFactory.getINSTANCE().create(ApiService.class);
    }

    @Override
    public void getProductType(String parentId, Callback callback) {
        Call call = service.getProductType(parentId);
        call.enqueue(callback);
    }
}
