package com.bb.hbx.base.m;

import android.util.Log;

import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.v.RegistContract;
import com.bb.hbx.bean.MessageCodeBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Administrator on 2016/12/5.
 */

public class RegistModel implements RegistContract.Model {


    private ApiService service;

    public RegistModel() {
        service = RetrofitFactory.getINSTANCE().create(ApiService.class);
    }

    @Override
    public void regist(String tel, String pass, String code) {

    }


    @Override
    public void getVerifyCode(String codeType, String mobile, String bizType, Callback  mAbsCallback) {
        Call call = service.getVerifyCode(codeType, mobile, bizType);
        call.enqueue(mAbsCallback);
    }


}
