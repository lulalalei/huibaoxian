package com.bb.hbx.activitiy;

import com.bb.hbx.R;
import com.bb.hbx.activitiy.login.LoginContract;
import com.bb.hbx.base.BaseActivity;



public class PwdLoginActivity<LoginPresenter, LoginModel> extends BaseActivity
        implements LoginContract.View {


    @Override
    public void loginSuccess() {

    }


    @Override
    public boolean isverTel() {
        return false;
    }

    @Override
    public boolean isverCode() {
        return false;
    }

    @Override
    public boolean isverpassword() {
        return false;
    }

    @Override
    public boolean isCheckbx() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_pwd_login;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initdata() {

    }

    @Override
    public void showMsg(String msg) {

    }
}
