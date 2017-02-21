package com.bb.hbx.activitiy;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

public class CountSecurityActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.pwdLogin_layout)
    RelativeLayout pwdLogin_layout;
    @BindView(R.id.pwdPay_layout)
    RelativeLayout pwdPay_layout;
    @BindView(R.id.checkPhone_layout)
    RelativeLayout checkPhone_layout;
    @Override
    public int getLayoutId() {
        return R.layout.activity_count_security;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        pwdLogin_layout.setOnClickListener(this);
        pwdPay_layout.setOnClickListener(this);
        checkPhone_layout.setOnClickListener(this);
    }

    @Override
    public void initdata() {

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            case R.id.pwdLogin_layout:
                //showTip("登录密码");
                String loginPwd = MyApplication.user.getLoginPwd();
                if ("1".equals(loginPwd))//设置过密码
                {

                    intent.setClass(this,FixPwdActivity.class);
                    startActivity(intent);
                }
                else
                {
                    intent.setClass(this,SetLoginPwdActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.pwdPay_layout:
                //showTip("支付密码");
                intent.setClass(this,PayPwdActivity.class);
                startActivity(intent);
                break;
            case R.id.checkPhone_layout:
                //showTip("手机验证");
                intent.setClass(this,ChangePhoneActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
