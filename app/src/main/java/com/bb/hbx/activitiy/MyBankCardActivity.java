package com.bb.hbx.activitiy;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.GetBankCardList;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.widget.PasswordDailog;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyBankCardActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.content_layout)
    RelativeLayout content_layout;
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
        /*Intent intent = getIntent();
        String bankName = intent.getStringExtra("bankName");
        String lastDigits = intent.getStringExtra("lastDigits");
        String cardType = intent.getStringExtra("cardType");*/
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getBankCardList(MyApplication.user.getUserId());
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Result_Api body = (Result_Api) response.body();
                if (body!=null)
                {
                    GetBankCardList cardBean = (GetBankCardList) body.getOutput();
                    if (cardBean!=null)
                    {
                        String bankName = cardBean.getBankName();
                        String lastDigits = cardBean.getLastDigits();
                        String cardType = cardBean.getCardType();
                        cardName_tv.setText(bankName);
                        cardType_tv.setText(cardType);
                        cardNo_tv.setText(lastDigits);
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });

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
                final PasswordDailog dialog = new PasswordDailog(this);
                dialog.setListener(new PasswordDailog.GetPasswordListener() {
                    @Override
                    public void getPassword(String password) {
                        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
                        Call call=service.verifyPayPwd(MyApplication.user.getUserId(),password);
                        call.enqueue(new Callback() {
                            @Override
                            public void onResponse(Call call, Response response) {
                                Result_Api body = (Result_Api) response.body();
                                if (body!=null)
                                {
                                    if (body.isSuccess())
                                    {
                                        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
                                        Call callRealse=service.releaseBankCard(MyApplication.user.getUserId());
                                        callRealse.enqueue(new Callback() {
                                            @Override
                                            public void onResponse(Call call, Response response) {
                                                Result_Api body = (Result_Api) response.body();
                                                if (body!=null)
                                                {
                                                    if (body.isSuccess())
                                                    {

                                                        content_layout.setVisibility(View.GONE);
                                                        finish();
                                                        AppManager.getInstance().finishParticularActivity(WithdrawActivity.class);

                                                    }
                                                    showTip(body.getRespMsg());
                                                }
                                                dialog.dismiss();
                                            }

                                            @Override
                                            public void onFailure(Call call, Throwable t) {

                                            }
                                        });

                                    }
                                    else
                                    {
                                        showTip(body.getRespMsg());
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call call, Throwable t) {

                            }
                        });
                    }
                });
                dialog.show();
                break;
            default:
                break;
        }
    }
}
