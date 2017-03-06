package com.bb.hbx.activitiy;

import android.view.View;
import android.widget.RelativeLayout;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

public class SettingsActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.personInfo_layout)
    RelativeLayout personInfo_layout;
    @BindView(R.id.income_layout)
    RelativeLayout income_layout;
    @BindView(R.id.clearCache_layout)
    RelativeLayout clearCache_layout;
    @BindView(R.id.evaluation_layout)
    RelativeLayout evaluation_layout;
    @BindView(R.id.feedback_layout)
    RelativeLayout feedback_layout;
    @BindView(R.id.aboutUs_layout)
    RelativeLayout aboutUs_layout;
    @BindView(R.id.exits_layout)
    RelativeLayout exits_layout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_settings;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        personInfo_layout.setOnClickListener(this);
        income_layout.setOnClickListener(this);
        clearCache_layout.setOnClickListener(this);
        evaluation_layout.setOnClickListener(this);
        feedback_layout.setOnClickListener(this);
        aboutUs_layout.setOnClickListener(this);
        exits_layout.setOnClickListener(this);
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
            case R.id.personInfo_layout:
                showTip("个人资料");
                break;
            case R.id.income_layout:
                showTip("推广费显示");
                break;
            case R.id.clearCache_layout:
                showTip("清除缓存");
                break;
            case R.id.evaluation_layout:
                showTip("赐予好评");
                break;
            case R.id.feedback_layout:
                showTip("意见反馈");
                break;
            case R.id.aboutUs_layout:
                showTip("关于汇保险");
                break;
            case R.id.exits_layout:
                showTip("退出登录");
                break;
            default:
                break;
        }
    }
}
