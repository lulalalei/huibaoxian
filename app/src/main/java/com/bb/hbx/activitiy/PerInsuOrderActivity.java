package com.bb.hbx.activitiy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyPerInsuOrderAdapter;
import com.bb.hbx.cans.Can;
import com.bb.hbx.fragment.PIOrderContentFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/*
* 个险订单页面*/
public class PerInsuOrderActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    String [] titles=new String[]{"全部","待支付","有效","已终止"};
    ArrayList<PIOrderContentFragment> fragmentList=new ArrayList<>();
    MyPerInsuOrderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per_insu_order);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

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

    //对返回图标的监听
    public void backMethod(View view) {
        finish();
    }
}
