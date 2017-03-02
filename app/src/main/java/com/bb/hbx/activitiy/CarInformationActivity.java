package com.bb.hbx.activitiy;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by fancl
 * 车险
 */

public class CarInformationActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_title)
    TextView tv_title;


    @BindView(R.id.tv_city)
    TextView tv_city;


    @BindView(R.id.et_carid)
    EditText et_carid;

    @BindView(R.id.cb_wei)
    CheckBox cb_wei;

    @BindView(R.id.tv_lishi)
    TextView tv_lishi;

    @BindView(R.id.tv_search)
    TextView tv_search;

    @BindView(R.id.iv_banner)
    ImageView iv_banner;


    @Override
    public int getLayoutId() {
        return R.layout.activit_carinfo;
    }

    @Override
    public void initView() {


    }

    @Override
    public void initListener() {
        tv_search.setOnClickListener(this);
        tv_lishi.setOnClickListener(this);
        tv_city.setOnClickListener(this);
    }

    @Override
    public void initdata() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}
