package com.bb.hbx.activitiy;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.widget.CountDownTextView;
import com.bb.hbx.widget.LoginPswEdit;
import com.bb.hbx.widget.LoginTelEdit;

import org.w3c.dom.Text;

import butterknife.BindView;

/**
 * Created by fancl on 2016/12/30.
 * 重置密码
 */

public class ResetPswActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.back_iv)
    ImageView back_iv;


    @BindView(R.id.et_psw)
    LoginPswEdit et_psw;


    @BindView(R.id.tv_complete)
    TextView tv_complete;


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.tv_complete:
                if (isverpassword()) {
                    AppManager.getInstance().showActivity(PwdLoginActivity.class, null);
                } else {
                    showTip("请正确填写密码");
                }
                break;
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_resetpsw;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_iv.setOnClickListener(this);
        tv_complete.setOnClickListener(this);
        et_psw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (!TextUtils.isEmpty(s) && s.length() >= 6) {
                    tv_complete.setBackgroundResource(R.drawable.shape_btn_a1);
                } else {
                    tv_complete.setBackgroundResource(R.drawable.shape_btn_a6);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    public boolean isverpassword() {
        if (!TextUtils.isEmpty(et_psw.getText()) && et_psw.getText().toString().trim().length() >= 6
                && et_psw.getText().toString().trim().length() <= 20) {
            return true;
        }
        return false;
    }

    @Override
    public void initdata() {

    }
}
