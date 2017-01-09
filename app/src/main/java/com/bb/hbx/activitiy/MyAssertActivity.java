package com.bb.hbx.activitiy;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.widget.IncomesTableView;

import butterknife.BindView;

/*
* 点击 我的--我的资产 显示的 我的资产 页面*/
public class MyAssertActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_iv)
    ImageView back_iv;
    @BindView(R.id.detail_tv)
    TextView detail_tv;
    @BindView(R.id.cash_layout)
    RelativeLayout cash_layout;
    @BindView(R.id.income_layout)
    RelativeLayout income_layout;
    @BindView(R.id.settlement_layout)
    RelativeLayout settlement_layout;
    @BindView(R.id.allIncome_layout)
    RelativeLayout allIncome_layout;
    @BindView(R.id.income_itv)
    IncomesTableView income_itv;
    //设置横坐标显示的月份
    String [] xValues=new String[7];
    //设置纵坐标显示的金额
    int [] yValues=new int[7];

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_assert;
    }

    @Override
    public void initView() {
        for (int i = 0; i < xValues.length; i++) {
            xValues[i]= i+"";
        }
        income_itv.setXValues(xValues);
        for (int i = 0; i < yValues.length; i++) {
            yValues[i]= 1+i*100;
        }
        income_itv.setYValues(yValues);
    }

    @Override
    public void initListener() {
        back_iv.setOnClickListener(this);
        detail_tv.setOnClickListener(this);
        cash_layout.setOnClickListener(this);
        income_layout.setOnClickListener(this);
        settlement_layout.setOnClickListener(this);
        allIncome_layout.setOnClickListener(this);
    }

    @Override
    public void initdata() {

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId())
        {
            case R.id.back_iv:
                finish();
                break;
            case R.id.detail_tv:
                Toast.makeText(this,"明细",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cash_layout:
                intent.setClass(this,CashActivity.class);
                startActivity(intent);
                break;
            case R.id.settlement_layout:
                intent.setClass(this,SettlementActivity.class);
                startActivity(intent);
                break;
            case R.id.allIncome_layout:
                intent.setClass(this,AllIncomeActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
