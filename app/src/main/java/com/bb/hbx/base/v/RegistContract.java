package com.bb.hbx.base.v;

import com.bb.hbx.activitiy.login.LoginContract;
import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.base.v.BaseView;

/**
 * Created by Administrator on 2016/12/20.
 */

public interface RegistContract {


    interface Model extends BaseModel {

        void regist(String tel, String pass, String code);
    }

    interface View extends BaseView {

        void processTime(int time);

        void endTime();


    }

    abstract class Presenter extends BasePresenter<Model, View> {

        public abstract void regist(String tel, String pass, String code);

        public abstract void startTime();

        public abstract void cancelTime();

    }
}
