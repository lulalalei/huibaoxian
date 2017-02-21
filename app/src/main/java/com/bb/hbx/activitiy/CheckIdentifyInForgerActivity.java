package com.bb.hbx.activitiy;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.widget.CountDownTextView;

import butterknife.BindView;

public class CheckIdentifyInForgerActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.phone_tv)
    TextView phone_tv;
    @BindView(R.id.getcode_tv)
    CountDownTextView getcode_tv;
    @BindView(R.id.nextStep_tv)
    TextView nextStep_tv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_check_identify_in_forger;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        getcode_tv.setOnClickListener(this);
        nextStep_tv.setOnClickListener(this);
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
            case R.id.getcode_tv:
                getcode_tv.startTime();
                break;
            case R.id.nextStep_tv:
                Intent intent = new Intent(this, FixPayPwdActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
