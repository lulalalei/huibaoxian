package com.bb.hbx.base.m;

import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.v.ActivitContract;
import com.bb.hbx.base.v.CarInfomationContract;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/13.
 */

public class CarInfomationModel implements CarInfomationContract.Model {


    private ApiService service;


    public CarInfomationModel() {
        service = RetrofitFactory.getINSTANCE().create(ApiService.class);
    }


    @Override
    public void getAvaCarAreas(String companyCode, String areaCode, Callback callback) {
        Call call = service.getAvaCarAreas(companyCode, areaCode);
        call.enqueue(callback);
    }
}
