package com.bb.hbx.base.m;

import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.v.Mall_ItemContract;
import com.bb.hbx.base.v.TopicListContract;
import com.bb.hbx.bean.RequestProduct;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/13.
 */

public class TopListModel implements TopicListContract.Model {


    private ApiService service;


    public TopListModel() {
        service = RetrofitFactory.getINSTANCE().create(ApiService.class);
    }


    @Override
    public void getSpecials(int pageIndex,Callback callback) {
        Call call = service.getSpecials(pageIndex);
        call.enqueue(callback);
    }
}
