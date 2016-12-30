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


        boolean isverTel();

        boolean isverCode();

        boolean isverpassword();

        boolean isCheckbx();


    }

    abstract class Presenter extends BasePresenter<Model, View> {


        public abstract void login(String name, String pass);



        public void regist(String tel,String code,String psw){

        }

        //找回密码
        public  void getPsw(String tel,String code){

        }

        @Override
        public void onAttached() {}
    }
}
