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
    public void getTopicList(int pageIndex, int pageSize, Callback callback) {
        Call<String> call = service.getSpecials(pageIndex, pageSize);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("fancl", response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }

}
