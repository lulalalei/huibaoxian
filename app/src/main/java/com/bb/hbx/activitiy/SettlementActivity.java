package com.bb.hbx.activitiy;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MySettlementAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.MySettlementBean;

import java.util.ArrayList;

import butterknife.BindView;

/*
* 点击 我的--我的资产--结算中 显示的页面*/
public class SettlementActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_iv)
    ImageView back_iv;
    @BindView(R.id.menu_iv)
    ImageView menu_iv;

    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    GridLayoutManager manager;

    ArrayList<MySettlementBean> totalList=new ArrayList<>();
    MySettlementAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_settlement;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_iv.setOnClickListener(this);
        menu_iv.setOnClickListener(this);
    }

    @Override
    public void initdata() {
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

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_iv:
                finish();
                break;
            case R.id.menu_iv:
                Toast.makeText(this,"菜单",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
