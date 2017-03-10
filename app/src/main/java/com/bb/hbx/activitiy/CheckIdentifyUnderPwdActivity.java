package com.bb.hbx.activitiy;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

public class CheckIdentifyUnderPwdActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;

    @BindView(R.id.pwd_et)
    EditText pwd_et;

    @BindView(R.id.verify_tv)
    TextView verify_tv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_check_identify_under_pwd;
    }

    @Override
    public void initView() {

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
                String passWord = MyApplication.user.getLoginPwd();
                String pwd = pwd_et.getText().toString().trim();

                if (pwd != null ) {
                    Intent intent = new Intent(this, BindPhoneActivity.class);
                    intent.putExtra("pwd",pwd);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }
}
