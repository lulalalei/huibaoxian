package com.bb.hbx.activitiy;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.widget.CountDownTextView;
import com.bb.hbx.widget.LoginPswEdit;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//修改登录密码
public class FixPwdActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.checkCode_et)
    EditText checkCode_et;
    @BindView(R.id.getcode_tv)
    CountDownTextView getcode_tv;
    @BindView(R.id.pwd_et)
    LoginPswEdit pwd_et;
    @BindView(R.id.warn_tv)
    TextView warn_tv;
    @BindView(R.id.verify_tv)
    TextView verify_tv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_fix_pwd;
    }

    @Override
    public void initView() {
        pwd_et.setHintString("新密码(6-20位数字、字母组合)");
        //pwd_et.invalidate();
        String mobile = MyApplication.user.getMobile();
        warn_tv.setText("验证码将发送已绑定手机号"+mobile);
    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        getcode_tv.setOnClickListener(this);
        verify_tv.setOnClickListener(this);
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
            case R.id.getcode_tv:
                getcode_tv.startTime();
                break;
            case R.id.verify_tv:
                showTip("确认");
                String code = checkCode_et.getText().toString();
                String pwd = pwd_et.getText().toString();
                if (!TextUtils.isEmpty(code)&&!TextUtils.isEmpty(pwd))
                {
                    ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
                    Call call=service.resetLoginPwd(MyApplication.user.getUserId(),pwd,"2",code);
                    call.enqueue(new Callback() {
                        @Override
                        public void onResponse(Call call, Response response) {

                        }

                        @Override
                        public void onFailure(Call call, Throwable t) {

                        }
                    });
                }
                break;
            default:
                break;
        }
    }
}
