package com.bb.hbx.activitiy;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

public class MyBankCardActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.cardName_tv)
    TextView cardName_tv;
    @BindView(R.id.cardType_tv)
    TextView cardType_tv;
    @BindView(R.id.cardNo_tv)
    TextView cardNo_tv;
    @BindView(R.id.bankstatus_tv)
    TextView bankstatus_tv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_my_bank_card;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        String bankName = intent.getStringExtra("bankName");
        String lastDigits = intent.getStringExtra("lastDigits");
        String cardType = intent.getStringExtra("cardType");

        cardName_tv.setText(bankName);
        cardType_tv.setText(cardType);
        cardNo_tv.setText(lastDigits);
    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        bankstatus_tv.setOnClickListener(this);
    }

    @Override
    public void initdata() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            case R.id.bankstatus_tv:

                break;
            default:
                break;
        }
    }
}
