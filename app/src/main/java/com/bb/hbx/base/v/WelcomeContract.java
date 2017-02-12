package com.bb.hbx.base.v;

import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.bean.ProductDetail;
import com.bb.hbx.bean.User;
import com.bb.hbx.bean.VersionInfo;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/9.
 */

public interface WelcomeContract {


    interface Model extends BaseModel {

        void getClientCtlInfo(String userId, Callback callback);

        User settingUser();

    }


    interface View extends BaseView {

        void settingUser(User user);

        void setVersionInfo(VersionInfo info);

    }

    abstract class Presenter extends BasePresenter<WelcomeContract.Model, WelcomeContract.View> {

        public abstract void settingUser();

        public abstract void getClientCtlInfo(String userId);
    }
}
