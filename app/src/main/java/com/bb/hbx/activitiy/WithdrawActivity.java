package com.bb.hbx.activitiy;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.interfaces.PointTextWatcher;
import com.bb.hbx.widget.LoginTelEdit;

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

    @BindView(R.id.iv_bankicon)
    ImageView iv_bankicon;

    @BindView(R.id.tv_banktitle)
    TextView tv_banktitle;

    @BindView(R.id.tv_bankstatus)
    TextView tv_bankstatus;

    @BindView(R.id.tv_cardNo)
    TextView tv_cardNo;

    @BindView(R.id.tv_withdraw)
    TextView tv_withdraw;

    @BindView(R.id.et_price)
    LoginTelEdit et_price;


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
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        et_price.addTextChangedListener(new PointTextWatcher(et_price, tv_withdraw));
    }

    @Override
    public void initdata() {

    }
}
