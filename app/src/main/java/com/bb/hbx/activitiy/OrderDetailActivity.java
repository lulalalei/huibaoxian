package com.bb.hbx.activitiy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bb.hbx.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
* 保单详情页面  由点击 我的--个险订单 中的条目进入*/
public class OrderDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.back_iv)
    ImageView back_iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
        toolbar.setTitle("");
    }

    public void backMethod(View view) {
        finish();
    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.item_layout:
                Toast.makeText(this,"保障项目",Toast.LENGTH_SHORT).show();
                break;
            case R.id.send_bt:
                Toast.makeText(this,"发送电子保单",Toast.LENGTH_SHORT).show();
                break;
            case R.id.call_bt:
                Toast.makeText(this,"客服电话",Toast.LENGTH_SHORT).show();
                break;
            case R.id.askMoney_bt:
                Toast.makeText(this,"我要理赔",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
