package com.bb.hbx.activitiy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.base.m.ConfimpaymentlModel;
import com.bb.hbx.base.p.ConfimpaymentPresenter;
import com.bb.hbx.base.v.ConfimpaymentContract;
import com.bb.hbx.bean.PayDetail;
import com.bb.hbx.observable.PriceObservable;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.utils.TimeUtils;
import com.bb.hbx.utils.Utils;
import com.bb.hbx.widget.FancyCountDownTextview;
import com.bb.hbx.widget.TextviewObserver;

import java.util.Observable;
import java.util.Observer;

import butterknife.BindView;

import static com.bb.hbx.R.drawable.on;
import static com.bb.hbx.R.id.ck_jf;


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
    TextviewObserver tv_needprice;//还需支付的金额
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

    @BindView(R.id.iv_back)
    ImageView iv_back;//积分

    @BindView(R.id.tv_pay)
    TextviewObserver tv_pay;//合计

    @BindView(R.id.lin_hb)
    LinearLayout lin_hb;//合计
    //

    @BindView(R.id.ck_jf)
    CheckBox ck_jf;//积分
    //

    @BindView(R.id.ck_ye)
    CheckBox ck_ye;//余额

    @BindView(R.id.ck_yhq)
    CheckBox ck_yhq;//优惠券

    //
    @BindView(R.id.tv_save)
    TextviewObserver tv_save;//节省


    @BindView(R.id.lin_Insurance)
    LinearLayout lin_Insurance;//险种

    private PayDetail detail;
    private PriceObservable priceObservable;

    private final static int REU_A = 0x111;


    @Override
    public int getLayoutId() {
        return R.layout.activit_confirmpayment;
    }

    @Override
    public void initView() {

//        tv_timedetail.startTime();
    }

    @Override
    public void initListener() {
        lin_Insurance.setOnClickListener(this);
        tv_confim.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        lin_hb.setOnClickListener(this);
        ck_jf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    priceObservable.setPrice_jf(detail.getDeductible());
                } else {
                    priceObservable.setPrice_jf("0");
                }
            }
        });
        ck_ye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    priceObservable.setPrice_ye(detail.getAcctBalanceYE());
                } else {
                    priceObservable.setPrice_ye("0");
                }
            }
        });
        ck_yhq.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    priceObservable.setPrice_yhq(detail.getAcctBalanceYE());
//                }else {
//                    priceObservable.setPrice_yhq("0");
//                }
            }
        });
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

        priceObservable = new PriceObservable();
        priceObservable.addObserver(tv_needprice);
        priceObservable.addObserver(tv_pay);
        priceObservable.addObserver(tv_save);

        priceObservable.setAllPrice(detail.getPayPrice());

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
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.lin_hb:
                AppManager.getInstance().showActivityForResult(RedPacketActivity.class, null, REU_A);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REU_A && resultCode == RESULT_OK) {

        }
    }
}
