package com.bb.hbx.activitiy;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.widget.LoginPswEdit;

import butterknife.BindView;

public class SetLoginPwdActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.pwd_et)
    LoginPswEdit pwd_et;
    @BindView(R.id.verify_tv)
    TextView verify_tv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_set_login_pwd;
    }

    @Override
    public void initView() {
        pwd_et.setHintString("密码(6-20位数字、字母组合)");

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        verify_tv.setOnClickListener(this);
    }

    @Override
    public void initdata() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            case R.id.verify_tv:
                showTip("确认");
                break;
            default:
                break;
        }
    }
}
