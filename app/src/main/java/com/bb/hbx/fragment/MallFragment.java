package com.bb.hbx.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.bb.hbx.R;
import com.bb.hbx.adapter.BasePageAdapter;
import com.bb.hbx.adapter.MallPageAdapter;
import com.bb.hbx.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/20.
 */

public class MallFragment extends BaseFragment {


    private final static String TAG=MallFragment.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tabs)
    TabLayout tabs;

    @BindView(R.id.viewpager)
    ViewPager viewpager;


    private List<String> tabsTitle;

    private BasePageAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mall;
    }

    @Override
    public void initView() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"haha");
            }
        });

    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        tabsTitle = new ArrayList<>();
        tabsTitle.add("车险");
        tabsTitle.add("理财险");
        tabsTitle.add("意外险");
        tabsTitle.add("健康险");
        tabsTitle.add("旅游险");
        adapter = new MallPageAdapter(getActivity().getSupportFragmentManager(), tabsTitle);
        for (int i = 0; i < tabsTitle.size(); i++) {
            adapter.addFragment(new Mall_ItemFragment());
        }
        viewpager.setAdapter(adapter);
        tabs.setupWithViewPager(viewpager);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.i(TAG,"haha");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
