package com.bb.hbx.base.p;

import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.ActivitContract;
import com.bb.hbx.base.v.CarInfomationContract;
import com.bb.hbx.bean.ActivitInfo;
import com.bb.hbx.bean.Output_AreaBean;
import com.bb.hbx.emus.DataLoadDirection;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

import static android.nfc.tech.MifareUltralight.PAGE_SIZE;

/**
 * Created by fancl.
 */

public class CarInfomationPresenter extends CarInfomationContract.Presenter {


    private boolean isProvinces = true;//true 为省份请求，false 为 城市请求；

    private PostCallback postCallback;


    @Override
    public void onAttached() {
        postCallback = new PostCallback<CarInfomationContract.View>(mView) {

            @Override
            public void successCallback(Result_Api api) {
                if (api.getOutput() instanceof Output_AreaBean) {
                    Output_AreaBean areaBean = (Output_AreaBean) api.getOutput();
                    if (isProvinces)
                        mView.getProvices(areaBean.getAreaList());
                    else
                        mView.getCities(areaBean.getAreaList());


                }

            }

            @Override
            public void failCallback() {

            }
        };

    }

    @Override
    public void getProvicesCarAreas(String companyCode) {
        isProvinces = true;
        mModel.getAvaCarAreas(companyCode, "0", postCallback);
    }

    @Override
    public void getcitiesCarAreas(String companyCode, String areaCode) {
        isProvinces = false;
        mModel.getAvaCarAreas(companyCode, areaCode, postCallback);
    }


}
