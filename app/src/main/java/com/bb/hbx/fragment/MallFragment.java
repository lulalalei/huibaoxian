package com.bb.hbx.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;



import com.bb.hbx.R;
import com.bb.hbx.adapter.BasePageAdapter;
import com.bb.hbx.adapter.MallPageAdapter;
import com.bb.hbx.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Administrator on 2016/12/20.
 */

public class MallFragment extends BaseFragment {


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

    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        tabsTitle = new ArrayList<>();
        tabsTitle.add("全部");
        tabsTitle.add("车险");
        tabsTitle.add("人寿保险");
        tabsTitle.add("意外保险");
        tabsTitle.add("理财保险");
        tabsTitle.add("健康保险");
        tabsTitle.add("旅游保险");
        adapter = new MallPageAdapter(getActivity().getSupportFragmentManager(), tabsTitle);
        for (int i = 0; i < tabsTitle.size(); i++) {
            adapter.addFragment(new Mall_ItemFragment());
        }
        viewpager.setAdapter(adapter);
        tabs.setupWithViewPager(viewpager);

    }
}
