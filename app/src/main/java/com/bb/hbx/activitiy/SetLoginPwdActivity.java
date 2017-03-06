package com.bb.hbx.activitiy;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.activitiy.login.LoginContract;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.db.DatabaseImpl;
import com.bb.hbx.interfaces.LoginTextWatcher;
import com.bb.hbx.widget.LoginPswEdit;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetLoginPwdActivity extends BaseActivity implements View.OnClickListener,LoginContract.View{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.pwd_et)
    LoginPswEdit pwd_et;
    @BindView(R.id.verify_tv)
    TextView verify_tv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_set_login_pwd;
    }

    @Override
    public void initView() {
        pwd_et.setHintString("密码(6-20位数字、字母组合)");

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        verify_tv.setOnClickListener(this);
        pwd_et.addTextChangedListener(new LoginTextWatcher(verify_tv, this));
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
            case R.id.verify_tv:
                //showTip("确认");
                String pwd = pwd_et.getText().toString().trim();
                //int length = pwd.length();
                if (isverpassword())
                {
                    ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
                    Call call=service.resetLoginPwdFirst(MyApplication.user.getUserId(),pwd,"1");
                    call.enqueue(new Callback() {
                        @Override
                        public void onResponse(Call call, Response response) {
                            Result_Api body = (Result_Api) response.body();
                            if (body!=null)
                            {
                                showTip(body.getRespMsg());
                                if (body.isSuccess())
                                {
                                    SQLiteDatabase db = DatabaseImpl.getInstance().getReadableDatabase();
                                    //更新表数据
                                    db.execSQL("update userstb set pwd=? where currentUser=currentUser ",
                                            new String[]{"1"});
                                    db.close();
                                    MyApplication.user.setLoginPwd("1");//1表示已经设置过登录密码
                                    finish();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call call, Throwable t) {

                        }
                    });
                }
                else
                {
                    showTip("请输入有效密码");
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public boolean isverTel() {
        return true;
    }

    @Override
    public boolean isverCode() {
        return true;
    }

    @Override
    public boolean isverpassword() {
        if (!TextUtils.isEmpty(pwd_et.getText()) && pwd_et.getText().toString().trim().length() >= 6
                && pwd_et.getText().toString().trim().length() <= 20) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCheckbx() {
        return true;
    }
}
