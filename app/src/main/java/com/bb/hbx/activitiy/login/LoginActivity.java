package com.bb.hbx.activitiy.login;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.activitiy.HomeActivity;
import com.bb.hbx.activitiy.RegisteActivity;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.widget.LoginTelEdit;

import org.w3c.dom.Text;

import butterknife.BindView;

/**
 * 登录
 * Created by fancl
 */

public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View, View.OnClickListener {


    @BindView(R.id.et_tel)
    LoginTelEdit et_tel;

    @BindView(R.id.et_code)
    EditText et_code;

    @BindView(R.id.tv_getcode)
    TextView tv_getcode;

    @BindView(R.id.ck_agree)
    CheckBox ck_agree;

    @BindView(R.id.tv_login)
    TextView tv_login;

    @BindView(R.id.tv_regist)
    TextView tv_regist;

    @BindView(R.id.tv_passwordlogin)
    TextView tv_passwordlogin;


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {


    }

    @Override
    public void initListener() {

        tv_getcode.setOnClickListener(this);
        tv_login.setOnClickListener(this);
        tv_regist.setOnClickListener(this);
        tv_passwordlogin.setOnClickListener(this);
        tv_regist.setOnClickListener(this);

        et_tel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    et_tel.setCompoundDrawables(null, null, null, null);
                } else {
                    et_tel.setCompoundDrawables(null, null, et_tel.getEdit_endDrawable(), null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void initdata() {

    }

    @Override
    public void loginSuccess() {

    }


    public void startTime() {
        tv_getcode.setEnabled(false);


    }

    @Override
    public void processTime(int time) {
        if (tv_getcode != null) {
            tv_getcode.setText(getString(R.string.processTime, time + ""));
        }
    }


    @Override
    public void endTime() {
        if (tv_getcode != null) {
            tv_getcode.setEnabled(true);
            tv_getcode.setText(getString(R.string.getVerificationCode));
        }
    }

    @Override
    public void showMsg(String msg) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login:
                if (isverTel() && isverCode()) {
                    mPresenter.login(et_tel.getText().toString().trim(), et_code.getText().toString().trim());
                    AppManager.getInstance().showActivity(HomeActivity.class,null);
                }
                else
                    showTip("手机号码或验证码有误");
                break;
            case R.id.tv_getcode:
                if (isverTel()) {
                    startTime();
                    mPresenter.startTime();
                } else
                    showTip("请输入正确的手机号码");
                break;

            case R.id.tv_regist:
                AppManager.getInstance().showActivity(RegisteActivity.class, null);
                break;

            case R.id.tv_passwordlogin:
                break;

        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.cancelTime();
    }

    private boolean isverTel() {
        if (!TextUtils.isEmpty(et_tel.getText()) && et_tel.getText().toString().trim().length() == 11) {
            return true;
        }
        return false;
    }


    private boolean isverCode() {
        if (!TextUtils.isEmpty(et_code.getText()) && et_code.getText().toString().trim().length() == 6) {
            return true;
        }
        return false;
    }

}
