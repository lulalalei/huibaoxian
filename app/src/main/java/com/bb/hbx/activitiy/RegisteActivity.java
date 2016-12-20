package com.bb.hbx.activitiy;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.base.m.RegistModel;
import com.bb.hbx.base.p.RegistPresenter;
import com.bb.hbx.base.v.RegistContract;
import com.bb.hbx.widget.LoginTelEdit;

import butterknife.BindView;

import static com.bb.hbx.R.id.tv_getcode;
import static com.bb.hbx.R.id.tv_gologin;
import static com.bb.hbx.R.id.tv_regist;

/**
 * Created by fancl on 2016/12/20.
 */

public class RegisteActivity extends BaseActivity<RegistPresenter, RegistModel> implements RegistContract.View, View.OnClickListener {


    @BindView(R.id.et_tel)
    LoginTelEdit et_tel;

    @BindView(R.id.et_code)
    EditText et_code;

    @BindView(R.id.et_password)
    LoginTelEdit et_password;


    @BindView(R.id.tv_regist)
    TextView tv_regist;
    @BindView(R.id.tv_getcode)
    TextView tv_getcode;


    @BindView(R.id.tv_gologin)
    TextView tv_gologin;


    @Override
    public int getLayoutId() {
        return R.layout.activity_regist;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        tv_getcode.setOnClickListener(this);
        tv_gologin.setOnClickListener(this);
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
    public void showMsg(String msg) {

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
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.cancelTime();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_getcode:
                if (isverTel()) {
                    startTime();
                    mPresenter.startTime();
                } else
                    showTip("请输入正确的手机号码");
                break;

            case R.id.tv_gologin:
                finish();
                break;
            case R.id.tv_regist:
                if (!isverTel()) {
                    showTip("手机号码不正确");
                    return;
                }
                if (!isverCode()) {
                    showTip("验证码不正确");
                    return;
                }

                if (!isverpassword()) {
                    showTip("密码不正确");
                    return;
                }
                mPresenter.regist(et_tel.getText().toString().trim(), et_password.getText().toString().trim(),
                        et_code.getText().toString().trim());
                break;

        }
    }

    private boolean isverTel() {
        if (!TextUtils.isEmpty(et_tel.getText()) && et_tel.getText().toString().trim().length() == 11) {
            return true;
        }
        return false;
    }


    private boolean isverCode() {
        if (!TextUtils.isEmpty(et_code.getText()) && et_tel.getText().toString().trim().length() == 6) {
            return true;
        }
        return false;
    }

    private boolean isverpassword() {
        if (!TextUtils.isEmpty(et_password.getText()) && et_password.getText().toString().trim().length() >= 6
                && et_password.getText().toString().trim().length() <= 20) {
            return true;
        }
        return false;
    }

}
