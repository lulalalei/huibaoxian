package com.bb.hbx.base.m;

import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.v.ActivitContract;
import com.bb.hbx.base.v.TopicListContract;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/13.
 */

public class ActivitModel implements ActivitContract.Model {


    private ApiService service;


    public ActivitModel() {
        service = RetrofitFactory.getINSTANCE().create(ApiService.class);
    }


    @Override
    public void getAdsList(int pageIndex, int pageSize, Callback callback) {
        Call call = service.getAdsList(pageIndex, pageSize);
        call.enqueue(callback);

    }
}
