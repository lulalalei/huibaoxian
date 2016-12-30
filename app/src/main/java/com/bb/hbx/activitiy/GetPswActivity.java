package com.bb.hbx.activitiy;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.activitiy.login.LoginContract;
import com.bb.hbx.activitiy.login.LoginModel;
import com.bb.hbx.activitiy.login.LoginPresenter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.interfaces.LoginTextWatcher;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.widget.CountDownTextView;
import com.bb.hbx.widget.LoginTelEdit;

import butterknife.BindView;


/**
 * Created by fancl on 2016/12/30.
 * 找回密码
 */

public class GetPswActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View, View.OnClickListener {


    @BindView(R.id.back_iv)
    ImageView back_iv;

    @BindView(R.id.et_phone)
    LoginTelEdit et_phone;

    @BindView(R.id.et_pwd)
    EditText et_pwd;

    @BindView(R.id.tv_getcode)
    CountDownTextView tv_getcode;


    @BindView(R.id.tv_next)
    TextView tv_next;


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.tv_getcode:
                if (isverTel()) {
                    tv_getcode.startTime();

                } else
                    showTip("请输入正确的手机号码");
                break;

            case R.id.tv_next:
                if (isverTel() && isverCode()) {
                    mPresenter.getPsw(et_phone.getText().toString().trim(), et_pwd.getText().toString().trim());
                    AppManager.getInstance().showActivity(ResetPswActivity.class, null);
                } else
                    showTip("手机号码或验证码有误");
                break;
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_getpsw;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        tv_getcode.setOnClickListener(this);
        tv_next.setOnClickListener(this);
        et_phone.addTextChangedListener(new LoginTextWatcher(tv_next, this));
        et_pwd.addTextChangedListener(new LoginTextWatcher(tv_next, this));
    }

    @Override
    public void initdata() {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public boolean isverTel() {
        if (!TextUtils.isEmpty(et_phone.getText()) && et_phone.getText().toString().trim().length() == 11) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isverCode() {
        if (!TextUtils.isEmpty(et_pwd.getText())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isverpassword() {
        return true;
    }

    @Override
    public boolean isCheckbx() {
        return true;
    }

    @Override
    public void showMsg(String msg) {

    }
}
