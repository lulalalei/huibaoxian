package com.bb.hbx.base.m;

import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.v.MallContract;
import com.bb.hbx.base.v.Mall_ItemContract;
import com.bb.hbx.bean.RequestProduct;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/13.
 */

public class Mall_itemModel implements Mall_ItemContract.Model {


    private ApiService service;


    public Mall_itemModel() {
        service = RetrofitFactory.getINSTANCE().create(ApiService.class);
    }


    @Override
    public void getProducts(RequestProduct product, Callback callback) {
        Call call = service.getProducts(product);
        call.enqueue(callback);
    }
}
