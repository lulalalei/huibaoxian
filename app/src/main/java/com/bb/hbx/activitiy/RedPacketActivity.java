package com.bb.hbx.activitiy;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyRedPacketAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.cans.Can;
import com.bb.hbx.fragment.RedPacketContentFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;

import butterknife.BindView;

public class RedPacketActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.menu_iv)
    ImageView menu_iv;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tablayout)
    TabLayout tablayout;

    ArrayList<RedPacketContentFragment> fragmentList=new ArrayList<>();

    String []title=new String[]{"未使用(3)","使用记录(3)","已过期(5)"};
    MyRedPacketAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_red_packet;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        menu_iv.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        Can.redPFragmentList=Can.getFragmentListInRedP();
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.setTabTextColors(Color.GRAY,Color.BLACK);
        for (int i = 0; i < title.length; i++) {
            tablayout.addTab(tablayout.newTab().setText(title[i]));
            RedPacketContentFragment fragment = new RedPacketContentFragment();
            Bundle bundle=new Bundle();
            bundle.putInt("position",i);
            fragment.setArguments(bundle);
            fragmentList.add(fragment);
        }
        adapter = new MyRedPacketAdapter(getSupportFragmentManager(), fragmentList, title);
        //加这句代码比不加这句更减小内存消耗,,,,,,fragment会同时加载,且在结合hide,show之后,尽管页卡来回切换,但初始化只会执行一次
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);
        setIndicator(this,tablayout,28,28);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            case R.id.menu_iv:
                Toast.makeText(this,"菜单",Toast.LENGTH_SHORT).show();
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

   /* @Override
    protected void onDestroy() {
        super.onDestroy();
        Can.redPFragmentList.clear();
        *//*for (int i = 0; i < Can.redPFragmentList.size(); i++) {
            Can.redPFragmentList.get(i).onDestroy();
        }*//*
    }*/
}
