package com.bb.hbx.activitiy;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by fancl
 */

public class SelectCarActivity extends BaseActivity {


    @BindView(R.id.rl_view)
    RecyclerView rl_view;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_confim)
    TextView tv_confim;


    @Override
    public int getLayoutId() {
        return R.layout.activit_select;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initdata() {

    }
}
