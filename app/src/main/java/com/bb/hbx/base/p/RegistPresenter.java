package com.bb.hbx.base.p;

import android.util.Log;

import com.bb.hbx.MyApplication;
import com.bb.hbx.activitiy.login.LoginContract;
import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.RegistContract;
import com.bb.hbx.bean.MessageCodeBean;
import com.bb.hbx.bean.User;
import com.bb.hbx.utils.Constants;

/**
 * Created by fancl.
 */

public class RegistPresenter extends RegistContract.Presenter {


    private PostCallback postCallback;


    @Override
    public void onAttached() {
        initVerifyCodeCallback();
    }


    private void initVerifyCodeCallback() {
        postCallback = new PostCallback<LoginContract.View>(mView) {

            @Override
            public void successCallback(Result_Api api) {
                if (api.getOutput() != null) {
                    MessageCodeBean mcBean = (MessageCodeBean) api.getOutput();
                    Log.i("fancl",mcBean.getSmsCode());
                    return;
                }

                mView.showMsg("数据获取异常");
            }


            @Override
            public void failCallback() {

            }
        };
    }


    @Override
    public void regist(String tel, String pass, String code) {

    }


    @Override
    public void getVerifyCode(String mobile) {
        mModel.getVerifyCode(Constants.DXYZM, mobile, Constants.RECIVE_bizType, postCallback);
    }


}
