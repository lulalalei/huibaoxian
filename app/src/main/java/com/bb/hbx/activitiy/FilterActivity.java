package com.bb.hbx.activitiy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.bb.hbx.R;
import com.bb.hbx.adapter.BasePageAdapter;
import com.bb.hbx.adapter.FilterPageAdapter;
import com.bb.hbx.adapter.MallPageAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.base.m.FilterModel;
import com.bb.hbx.base.p.FilterPresenter;
import com.bb.hbx.base.v.FilterContract;
import com.bb.hbx.bean.TypeModel;
import com.bb.hbx.fragment.FilterFragment;
import com.bb.hbx.fragment.Mall_ItemFragment;

import java.util.List;

import butterknife.BindView;

/**
 * Created by fancl on 2017/2/14.
 * 筛选
 */

public class FilterActivity extends BaseActivity<FilterPresenter, FilterModel> implements FilterContract.View {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tabs)
    TabLayout tabs;

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private List<String> tabsTitle;

    private BasePageAdapter adapter;


    private TypeModel model;

    @Override
    public int getLayoutId() {

        return R.layout.activit_filter;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null)
            model = (TypeModel) bundle.getSerializable("title");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    public void initListener() {

    }

    @Override
    public void initdata() {

    }

    @Override
    public void initTitle(List<TypeModel> models) {
        adapter = new FilterPageAdapter(getSupportFragmentManager(), models);

        for (int i = 0; i < models.size(); i++) {
            adapter.addFragment(new FilterFragment(models.get(i)));

        }
        viewpager.setAdapter(adapter);
        tabs.setupWithViewPager(viewpager);
    }
}
