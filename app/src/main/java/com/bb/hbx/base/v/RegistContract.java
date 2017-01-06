package com.bb.hbx.base.v;

import com.bb.hbx.activitiy.login.LoginContract;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.base.v.BaseView;
import com.bb.hbx.bean.MessageCodeBean;

import retrofit2.Callback;

/**
 * Created by Administrator on 2016/12/20.
 */

public interface RegistContract {


    interface Model extends BaseModel {

        void regist(String tel, String pass, String code);

        void getVerifyCode(String codeType,String mobile,String bizType, Callback<Result_Api<MessageCodeBean>> mAbsCallback);
    }

//    interface View extends BaseView {
//
//
//        boolean isverTel();
//
//        boolean isverCode();
//
//        boolean isverpassword();
//
//        boolean isCheckbx();
//
//
//    }

    abstract class Presenter extends BasePresenter<Model, LoginContract.View> {

        public abstract void regist(String tel, String pass, String code);

        public abstract void getVerifyCode(String mobile);

    }
}
