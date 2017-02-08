package com.bb.hbx.activitiy;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyPerInsuOrderAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.cans.Can;
import com.bb.hbx.fragment.PIOrderContentFragment;

import java.lang.reflect.Field;
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

    String [] titles=new String[]{"全部","待出单","已出单","已终止"};
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
        tabLayout.setTabTextColors(Color.GRAY,Color.BLACK);
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
        tabLayout.setupWithViewPager(viewPager);
        setIndicator(this,tabLayout,20,20);
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

    public static void setIndicator(Context context, TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout ll_tab = null;
        try {
            ll_tab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) (getDisplayMetrics(context).density * leftDip);
        int right = (int) (getDisplayMetrics(context).density * rightDip);

        for (int i = 0; i < ll_tab.getChildCount(); i++) {
            View child = ll_tab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics metric = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric;
    }
}
