package com.bb.hbx.activitiy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.widget.IncomesTableView;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
* 点击 我的--我的资产 显示的 我的资产 页面*/
public class MyAssertActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.income_itv)
    IncomesTableView income_itv;
    //设置横坐标显示的月份
    String [] xValues=new String[7];
    //设置纵坐标显示的金额
    int [] yValues=new int[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_assert);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        for (int i = 0; i < xValues.length; i++) {
            xValues[i]= i+"";
        }
        income_itv.setXValues(xValues);
        for (int i = 0; i < yValues.length; i++) {
            yValues[i]= 1+i*100;
        }
        income_itv.setYValues(yValues);
    }

    public void backMethod(View view) {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_assert,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.detail_menu:
                Toast.makeText(this,"明细",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId())
        {
            case R.id.cash_layout:
                intent.setClass(this,CashActivity.class);
                break;
            case R.id.settlement_layout:
                intent.setClass(this,SettlementActivity.class);
                break;
            case R.id.allIncome_layout:
                intent.setClass(this,AllIncomeActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
