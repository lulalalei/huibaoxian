package com.bb.hbx.activitiy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyPerInsuOrderAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.cans.Can;
import com.bb.hbx.fragment.PIOrderContentFragment;

import java.util.ArrayList;

import butterknife.BindView;


/*
* 个险订单页面*/
public class PerInsuOrderActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    String [] titles=new String[]{"全部","待支付","有效","已终止"};
    ArrayList<PIOrderContentFragment> fragmentList=new ArrayList<>();
    MyPerInsuOrderAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_per_insu_order;
    }

    @Override
    public void initView() {
        back_layout.setOnClickListener(this);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initdata() {
        Can.pIOFragmentList=Can.getFragmentListInPIO();
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabTextColors(Color.BLACK,Color.GRAY);
        for (int i = 0; i < titles.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(titles[i]));
            PIOrderContentFragment fragment = new PIOrderContentFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position",i);
            fragment.setArguments(bundle);
            fragmentList.add(fragment);
        }
        adapter = new MyPerInsuOrderAdapter(getSupportFragmentManager(), fragmentList, titles);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            default:
                break;
        }
    }
}
