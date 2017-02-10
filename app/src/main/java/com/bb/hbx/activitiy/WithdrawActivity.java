package com.bb.hbx.activitiy;

import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.interfaces.PointTextWatcher;
import com.bb.hbx.widget.LoginTelEdit;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
            case R.id.tv_withdraw:
                String price = et_price.getText().toString().trim();
                if (!TextUtils.isEmpty(price))
                {
                    ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
                    Call call=service.applyCash(MyApplication.user.getUserId(),price,"阿亮","工商银行","1");
                    call.enqueue(new Callback() {
                        @Override
                        public void onResponse(Call call, Response response) {
                            showTip("提现成功");
                        }

                        @Override
                        public void onFailure(Call call, Throwable t) {
                            showTip("提现失败");
                        }
                    });
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
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");


    }

    @Override
    public void initListener() {
        iv_question.setOnClickListener(this);
        tv_withdraw.setOnClickListener(this);
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
