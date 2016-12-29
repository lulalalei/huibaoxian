package com.bb.hbx.interfaces;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.bb.hbx.R;
import com.bb.hbx.activitiy.login.LoginContract;
import com.bb.hbx.base.v.BaseView;


/**
 * Created by Administrator on 2016/12/29.
 */

public class LoginTextWatcher implements TextWatcher {


    private View view;

    private LoginContract.View impl;

    public LoginTextWatcher(View view, LoginContract.View impl) {

        this.view = view;
        this.impl = impl;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (impl.isverCode() && impl.isverpassword() && impl.isverTel() && impl.isCheckbx()) {
            view.setBackgroundResource(R.drawable.shape_btn_a1);
        } else {
            view.setBackgroundResource(R.drawable.shape_btn_a6);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
