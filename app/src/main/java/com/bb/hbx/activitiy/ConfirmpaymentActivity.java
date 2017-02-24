package com.bb.hbx.activitiy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.base.m.ConfimpaymentlModel;
import com.bb.hbx.base.p.ConfimpaymentPresenter;
import com.bb.hbx.base.v.ConfimpaymentContract;
import com.bb.hbx.bean.PayDetail;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.utils.TimeUtils;
import com.bb.hbx.utils.Utils;
import com.bb.hbx.widget.FancyCountDownTextview;

import butterknife.BindView;


/**
 * 确认订单
 */

public class ConfirmpaymentActivity extends BaseActivity<ConfimpaymentPresenter, ConfimpaymentlModel>
        implements View.OnClickListener, ConfimpaymentContract.View {


    @BindView(R.id.tv_timedetail)
    FancyCountDownTextview tv_timedetail;//自定义时间倒计时

    @BindView(R.id.tv_price)
    TextView tv_price;//总支付的金额

    @BindView(R.id.tv_insuranceName)
    TextView tv_insuranceName;//险种名字

    @BindView(R.id.tv_redenvelopes)
    TextView tv_redenvelopes;//红包抵扣

    @BindView(R.id.tv_needprice)
    TextView tv_needprice;//还需支付的金额
    //
    @BindView(R.id.tv_confim)
    TextView tv_confim;//确认支付

    @BindView(R.id.tv_tip)
    TextView tv_tip;//确认支付
    //
    @BindView(R.id.tv_jf)
    TextView tv_jf;//积分

    @BindView(R.id.tv_ye)
    TextView tv_ye;//积分
    //


    @BindView(R.id.lin_Insurance)
    LinearLayout lin_Insurance;//险种

    private PayDetail detail;


    @Override
    public int getLayoutId() {
        return R.layout.activit_confirmpayment;
    }

    @Override
    public void initView() {

        tv_timedetail.startTime();
    }

    @Override
    public void initListener() {
        lin_Insurance.setOnClickListener(this);
        tv_confim.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            if (bundle.containsKey("content")) {
                detail = (PayDetail) bundle.getSerializable("content");
            }
        }
        if (detail == null)
            detail = new PayDetail();

        tv_price.setText(getString(R.string.howPrice, Utils.fromFenToYuan(detail.getPayPrice())));
        tv_insuranceName.setText(detail.getProductName());
        tv_tip.setText(detail.getTips());
        tv_jf.setText(getString(R.string.format_jf, detail.getAcctBalanceJF(), Utils.fromFenToYuan(detail.getDeductible())));
        long last = TimeUtils.divlong(detail.getPayDeadline());//与当前时间差的长整形
        if (last <= 0) {
            tv_timedetail.setText("订单已经失效");
        } else {
            tv_timedetail.setTime(last);
            tv_timedetail.startTime();
        }

        tv_ye.setText(getString(R.string.format_ye, Utils.fromFenToYuan(detail.getAcctBalanceYE())));


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lin_Insurance:
                Bundle bundle = new Bundle();
                bundle.putString("tradeId", detail.getTradeId());
                AppManager.getInstance().showActivity(PolicydetailsActivity.class, bundle);
                break;
            case R.id.tv_confim:
                detail.setPaymentId("10");
                mPresenter.getPaySign(detail);
                break;
        }
    }
}
