package com.bb.hbx.base.m;

import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.v.FilterContract;
import com.bb.hbx.base.v.Filter_ItemContract;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/13.
 */

public class Filter_itemModel implements Filter_ItemContract.Model {


    private ApiService service;



    public Filter_itemModel() {
        service = RetrofitFactory.getINSTANCE().create(ApiService.class);
    }


}
