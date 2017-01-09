package com.bb.hbx.activitiy;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by fancl on 2017/1/9.
 * 提现
 */

public class WithdrawActivity extends BaseActivity implements View.OnClickListener {




    @BindView(R.id.iv_question)
    ImageView iv_question;


    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.iv_question:

                break;

        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_withdraw;
    }

    @Override
    public void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");

    }

    @Override
    public void initListener() {
        iv_question.setOnClickListener(this);
    }

    @Override
    public void initdata() {

    }
}
