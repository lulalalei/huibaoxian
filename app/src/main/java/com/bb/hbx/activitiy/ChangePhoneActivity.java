package com.bb.hbx.activitiy;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.widget.CountDownTextView;

import butterknife.BindView;

public class ChangePhoneActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.code_et)
    EditText code_et;
    @BindView(R.id.getcode_tv)
    CountDownTextView getcode_tv;
    @BindView(R.id.verify_tv)
    TextView verify_tv;
    @BindView(R.id.info_tv)
    TextView info_tv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_change_phone;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        getcode_tv.setOnClickListener(this);
        verify_tv.setOnClickListener(this);
        info_tv.setOnClickListener(this);
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
            case R.id.getcode_tv:
                getcode_tv.startTime();
                break;
            case R.id.verify_tv:
                //showTip("确定");
                intent.setClass(this,BindPhoneActivity.class);
                startActivity(intent);
                break;
            case R.id.info_tv:
                //showTip("提示");
                intent.setClass(this,CheckIdentifyUnderPwdActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
