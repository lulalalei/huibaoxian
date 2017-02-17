package com.bb.hbx.base.m;

import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.v.ActivitContract;
import com.bb.hbx.base.v.RecommendContract;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/13.
 */

public class RecommendModel implements RecommendContract.Model {


    private ApiService service;


    public RecommendModel() {
        service = RetrofitFactory.getINSTANCE().create(ApiService.class);
    }


    @Override
    public void getSpecialProductList(int pageIndex,Callback callback) {
        Call call = service.getSpecialProductList(pageIndex);
        call.enqueue(callback);

    }
}
