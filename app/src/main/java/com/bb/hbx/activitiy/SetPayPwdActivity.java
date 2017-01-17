package com.bb.hbx.activitiy;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

/*
* 设置支付密码 页面*/
public class SetPayPwdActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_iv)
    ImageView back_iv;
    @BindView(R.id.getCode_tv)
    TextView getCode_tv;
    @BindView(R.id.verify_tv)
    TextView verify_tv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_set_pay_pwd;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_iv.setOnClickListener(this);
        getCode_tv.setOnClickListener(this);
        verify_tv.setOnClickListener(this);
    }

    @Override
    public void initdata() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_iv:
                finish();
                break;
            case R.id.getCode_tv:
                Toast.makeText(this,"获取验证码",Toast.LENGTH_SHORT).show();
                break;
            case R.id.verify_tv:
                Toast.makeText(this,"确认!",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
