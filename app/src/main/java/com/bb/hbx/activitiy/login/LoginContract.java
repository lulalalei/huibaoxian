package com.bb.hbx.activitiy.login;

import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.base.v.BaseView;

/**
 * Created by Administrator on 2016/12/5.
 */

public interface LoginContract {


    interface Model extends BaseModel {
        void login(String name, String pass);

    }


    interface View  extends BaseView{

        void loginSuccess();

        void processTime(int time);

        void endTime();

    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void login(String name, String pass);

        public abstract void startTime();

        public abstract void cancelTime();

        @Override
        public void onAttached() {}
    }
}