package com.bb.hbx.activitiy;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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


    @BindView(R.id.menu_iv)
    ImageView menu_iv;


    @BindView(R.id.back_layout)
    RelativeLayout back_layout;

    @BindView(R.id.iv_bankicon)
    ImageView iv_bankicon;

    @BindView(R.id.tv_banktitle)
    TextView tv_banktitle;

    @BindView(R.id.tv_bankstatus)
    TextView tv_bankstatus;

    @BindView(R.id.tv_cardType)
    TextView tv_cardType;
    @BindView(R.id.tv_cardNo)
    TextView tv_cardNo;

    @BindView(R.id.tv_withdraw)
    TextView tv_withdraw;

    @BindView(R.id.et_price)
    LoginTelEdit et_price;

    String bankName="";
    String lastDigits="";
    String cardType="";
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.back_layout:
                finish();
                break;
            case R.id.menu_iv:

                break;
            case R.id.tv_bankstatus:
                Intent intent = new Intent(this, MyBankCardActivity.class);
                intent.putExtra("bankName",bankName);
                intent.putExtra("lastDigits",lastDigits);
                intent.putExtra("cardType",cardType);
                startActivity(intent);
                break;
            case R.id.tv_withdraw:
                String price = et_price.getText().toString().trim();
                if (!TextUtils.isEmpty(price))
                {
                    /*ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
                    Call call=service.withdraw(MyApplication.user.getUserId(),price,"阿亮","工商银行","1");
                    call.enqueue(new Callback() {
                        @Override
                        public void onResponse(Call call, Response response) {
                            showTip("提现成功");
                        }

                        @Override
                        public void onFailure(Call call, Throwable t) {
                            showTip("提现失败");
                        }
                    });*/
                }
                break;
            default:
                break;
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_withdraw;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        bankName = intent.getStringExtra("bankName");
        lastDigits = intent.getStringExtra("lastDigits");
        cardType = intent.getStringExtra("cardType");

        tv_banktitle.setText(bankName);
        tv_cardNo.setText(lastDigits);
        tv_cardType.setText(cardType);


    }

    @Override
    public void initListener() {
        menu_iv.setOnClickListener(this);
        tv_withdraw.setOnClickListener(this);
        back_layout.setOnClickListener(this);
        tv_bankstatus.setOnClickListener(this);

        et_price.addTextChangedListener(new PointTextWatcher(et_price, tv_withdraw));
    }

    @Override
    public void initdata() {

    }
}
