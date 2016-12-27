package com.bb.hbx.activitiy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MySettlementAdapter;
import com.bb.hbx.bean.MySettlementBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
* 点击 我的--我的资产--结算中 显示的页面*/
public class SettlementActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    GridLayoutManager manager;

    ArrayList<MySettlementBean> totalList=new ArrayList<>();
    MySettlementAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settlement);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        //scrollView.scrollTo(30,30);
        manager = new GridLayoutManager(this, 1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(manager);
        for (int i = 0; i < 16; i++) {
            String date="今天:"+i;
            String time="12.:"+i/10+i%10;
            String title="驾乘人员意外伤害保险:"+i;
            String number="保单号:"+i;
            String price=20+i+"";
            MySettlementBean bean = new MySettlementBean(date, time, title, number, price);
            totalList.add(bean);
        }
        adapter = new MySettlementAdapter(totalList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        scrollView.scrollTo(0,0);
    }

    public void backMethod(View view) {
        finish();
    }

    public void menuMethod(View view) {
        Toast.makeText(this,"菜单",Toast.LENGTH_SHORT).show();
    }
}
