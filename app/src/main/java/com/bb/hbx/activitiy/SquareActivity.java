package com.bb.hbx.activitiy;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;


import com.bb.hbx.R;
import com.bb.hbx.adapter.SquarePageAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.fragment.SquareFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/21.
 */

public class SquareActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tabs)
    TabLayout tabs;

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private SquarePageAdapter adapter;


    List<String> list;

    @Override
    public int getLayoutId() {
        return R.layout.activity_square;
    }

    @Override
    public void initView() {
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        list = new ArrayList<>();
        tabs.addTab(tabs.newTab().setText(getString(R.string.recommend)));
        list.add(getString(R.string.recommend));
        tabs.addTab(tabs.newTab().setText(getString(R.string.activit)));
        list.add(getString(R.string.activit));
        tabs.addTab(tabs.newTab().setText(getString(R.string.topiclist)));
        list.add(getString(R.string.topiclist));


    }

    @Override
    public void initListener() {

    }

    @Override
    public void initdata() {
        adapter = new SquarePageAdapter(getSupportFragmentManager(), list);
        adapter.addFragment(new SquareFragment());
        adapter.addFragment(new SquareFragment());
        adapter.addFragment(new SquareFragment());
        viewpager.setAdapter(adapter);
        tabs.setupWithViewPager(viewpager);
    }
}
