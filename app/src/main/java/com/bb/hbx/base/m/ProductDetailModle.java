package com.bb.hbx.base.m;

import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.v.HomeContract;
import com.bb.hbx.base.v.ProductDetailContract;
import com.bb.hbx.bean.ProdectDetalRequest;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/9.
 */

public class ProductDetailModle implements ProductDetailContract.Model {


    private ApiService service;

    public ProductDetailModle() {
        service = RetrofitFactory.getINSTANCE().create(ApiService.class);
    }


    @Override
    public void getProductDetail(String productId, Callback callback) {
        Call call = service.getProductDetail(productId);
        call.enqueue(callback);

    }

    @Override
    public void applyTrade(ProdectDetalRequest request, Callback callback) {
        Call call = service.applyTrade(request);
        call.enqueue(callback);
    }
}
