package com.bb.hbx.activitiy;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.activitiy.login.LoginContract;
import com.bb.hbx.activitiy.login.LoginModel;
import com.bb.hbx.activitiy.login.LoginPresenter;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.MessageCodeBean;
import com.bb.hbx.cans.Can;
import com.bb.hbx.interfaces.LoginTextWatcher;
import com.bb.hbx.widget.CountDownTextView;
import com.bb.hbx.widget.LoginTelEdit;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by fancl on 2016/12/30.
 * 找回密码
 */

public class GetPswActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View, View.OnClickListener {


    @BindView(R.id.back_iv)
    ImageView back_iv;

    @BindView(R.id.et_phone)
    LoginTelEdit et_phone;

    @BindView(R.id.et_pwd)
    EditText et_pwd;

    @BindView(R.id.tv_getcode)
    CountDownTextView tv_getcode;


    @BindView(R.id.tv_next)
    TextView tv_next;

    //接收验证码
    String smsCode;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.tv_getcode:
                if (isverTel()) {
                    tv_getcode.startTime();
                    getCheckCode();
                } else
                    showTip("请输入正确的手机号码");
                break;

            case R.id.tv_next:
                if (isverTel() && isverCode()) {
                    //mPresenter.getPsw(et_phone.getText().toString().trim(), et_pwd.getText().toString().trim());
                    Intent intent = new Intent(this, ResetPswActivity.class);
                    intent.putExtra("smsCode",et_pwd.getText().toString().trim());
                    intent.putExtra("mobile",et_phone.getText().toString().trim());
                    startActivityForResult(intent,100);
                    //nextMethod();
                    //AppManager.getInstance().showActivity(ResetPswActivity.class, null);
                } else
                    showTip("手机号码或验证码有误");
                break;
        }
    }

   /* //下一步...判断输入的验证码是
    private void nextMethod() {
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.verifyCode("1",et_pwd.getText().toString().trim(),"12");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                AppManager.getInstance().showActivity(ResetPswActivity.class, null);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                showTip("验证码错误");
            }
        });
    }*/

    @Override
    public int getLayoutId() {
        return R.layout.activity_getpsw;
    }

    @Override
    public void initView() {
        back_iv.setOnClickListener(this);
    }

    @Override
    public void initListener() {
        tv_getcode.setOnClickListener(this);
        tv_next.setOnClickListener(this);
        et_phone.addTextChangedListener(new LoginTextWatcher(tv_next, this));
        et_pwd.addTextChangedListener(new LoginTextWatcher(tv_next, this));
    }

    @Override
    public void initdata() {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public boolean isverTel() {
        if (!TextUtils.isEmpty(et_phone.getText()) && et_phone.getText().toString().trim().length() == 11) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isverCode() {
        if (!TextUtils.isEmpty(et_pwd.getText())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isverpassword() {
        return true;
    }

    @Override
    public boolean isCheckbx() {
        return true;
    }

    @Override
    public void showMsg(String msg) {

    }

    //获取短信验证码
    public String getCheckCode() {
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getVerifyCode("1",et_phone.getText().toString().trim(),"12");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Result_Api body = (Result_Api) response.body();
                MessageCodeBean bean = (MessageCodeBean) body.getOutput();
                smsCode= bean.getSmsCode();
                Toast.makeText(GetPswActivity.this,"smsCode:"+smsCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                showTip("获取验证码失败");
            }
        });
        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100)
        {
            if (resultCode== Can.FINISH_GETPSW)
            {
                finish();
            }
        }
    }
}
