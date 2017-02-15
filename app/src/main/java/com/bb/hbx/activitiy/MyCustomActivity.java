package com.bb.hbx.activitiy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyCustomAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.InsuredInfolBean;
import com.bb.hbx.cans.Can;
import com.bb.hbx.fragment.MyCustomContentFragment;
import com.bb.hbx.widget.MoreDailogInCustom;

import java.lang.reflect.Field;
import java.util.ArrayList;

import butterknife.BindView;

public class MyCustomActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.more_layout)
    RelativeLayout more_layout;
    @BindView(R.id.phone_iv)
    ImageView phone_iv;

    String [] title=new String[]{"保单记录","赠险记录","客户资料"};
    ArrayList<MyCustomContentFragment> fragmentList=new ArrayList<>();
    MyCustomAdapter adapter;

    public static InsuredInfolBean insuredInfolBean;
    @Override
    public int getLayoutId() {
        return R.layout.activity_my_custom;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        more_layout.setOnClickListener(this);
        phone_iv.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        Intent intent = getIntent();
        Bundle bundleBean = intent.getBundleExtra("insuredInfolBean");
        insuredInfolBean = bundleBean.getParcelable("insuredInfolBean");
        Can.myCustomFragmentList=Can.getFragmentListInMyCustom();
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.setTabTextColors(Color.GRAY,Color.BLACK);
        for (int i = 0; i < title.length; i++) {
            MyCustomContentFragment fragment = new MyCustomContentFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position",i);
            fragment.setArguments(bundle);
            fragmentList.add(fragment);
        }
        adapter = new MyCustomAdapter(getSupportFragmentManager(), fragmentList, title);
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
            case R.id.more_layout:
                MoreDailogInCustom moreDialog = new MoreDailogInCustom(this);
                moreDialog.show();
                break;
            case R.id.phone_iv:
                showTip("拨打电话");
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
