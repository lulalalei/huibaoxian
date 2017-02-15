package com.bb.hbx.activitiy;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

public class CustomServiceActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.use_layout)
    RelativeLayout use_layout;
    @BindView(R.id.research_layout)
    RelativeLayout research_layout;
    @BindView(R.id.askPay_layout)
    RelativeLayout askPay_layout;
    @BindView(R.id.power_layout)
    RelativeLayout power_layout;
    @BindView(R.id.obtain_layout)
    RelativeLayout obtain_layout;
    @BindView(R.id.guide_tv)
    TextView guide_tv;
    @BindView(R.id.cash_tv)
    TextView cash_tv;
    @BindView(R.id.phone_tv)
    TextView phone_tv;
    @BindView(R.id.more_tv)
    TextView more_tv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_custom_service;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        guide_tv.setOnClickListener(this);
        cash_tv.setOnClickListener(this);
        phone_tv.setOnClickListener(this);
        more_tv.setOnClickListener(this);
        use_layout.setOnClickListener(this);
        research_layout.setOnClickListener(this);
        askPay_layout.setOnClickListener(this);
        power_layout.setOnClickListener(this);
        obtain_layout.setOnClickListener(this);
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
            case R.id.guide_tv:
                showTip("新手指导");
                break;
            case R.id.cash_tv:
                showTip("结算提现");
                break;
            case R.id.phone_tv:
                showTip("客服电话");
                break;
            case R.id.use_layout:
                //showTip("新手指导");
                intent.setClass(this,CustomServiceDetailActivity.class);
                intent.putExtra("title","如何快速上手");
                startActivity(intent);
                break;
            case R.id.research_layout:
                //showTip("新手指导");
                intent.setClass(this,CustomServiceDetailActivity.class);
                intent.putExtra("title","已经投保成功的保单如何进行查询");
                startActivity(intent);
                break;
            case R.id.askPay_layout:
                //showTip("新手指导");
                intent.setClass(this,CustomServiceDetailActivity.class);
                intent.putExtra("title","如何办理理赔");
                startActivity(intent);
                break;
            case R.id.power_layout:
                //showTip("新手指导");
                intent.setClass(this,CustomServiceDetailActivity.class);
                intent.putExtra("title","电子保单有效力吗");
                startActivity(intent);
                break;
            case R.id.obtain_layout:
                //showTip("新手指导");
                intent.setClass(this,CustomServiceDetailActivity.class);
                intent.putExtra("title","怎么领取赠险");
                startActivity(intent);
                break;
            case R.id.more_tv:
                showTip("查看更多问题");
                break;
            default:
                break;
        }
    }
}
