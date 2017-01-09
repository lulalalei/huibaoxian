package com.bb.hbx.activitiy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.utils.AppManager;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
* 点击 我的--我的资产--可提现 显示的页面*/
public class CashActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    public void backMethod(View view) {
        finish();
    }

    public void menuMethod(View view) {
        Toast.makeText(this, "我是菜单", Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.immediate_layout:
                AppManager.getInstance().showActivity(WithdrawActivity.class, null);
                break;
            case R.id.bankCard_layout:
                intent.setClass(this, AddBankCardActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
