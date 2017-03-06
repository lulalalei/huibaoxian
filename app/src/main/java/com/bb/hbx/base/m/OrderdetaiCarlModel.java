package com.bb.hbx.base.m;


import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.v.OrderdetailsCarContract;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Administrator on 2017/2/23.
 */

public class OrderdetaiCarlModel implements OrderdetailsCarContract.Model {


    private ApiService service;


    public OrderdetaiCarlModel() {
        service = RetrofitFactory.getINSTANCE().create(ApiService.class);
    }


    @Override
    public void getTradeDetail(String userId, String tradeId, String detailId, String classType,Callback callback) {
        Call call = service.getTradeDetail(userId, tradeId, detailId,classType);
        call.enqueue(callback);
    }
}
