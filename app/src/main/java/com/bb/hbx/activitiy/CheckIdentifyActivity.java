package com.bb.hbx.activitiy;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.cans.Can;

import butterknife.BindView;

public class CheckIdentifyActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.pwd_et)
    EditText pwd_et;
    @BindView(R.id.nextStep_tv)
    TextView nextStep_tv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_check_identify;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        nextStep_tv.setOnClickListener(this);
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
            case R.id.nextStep_tv:
                //showTip("下一步");
                String pwd = pwd_et.getText().toString();
                if (!TextUtils.isEmpty(pwd))
                {
                    Intent intent = new Intent(this, FixPayPwdActivity.class);
                    intent.putExtra("flag", Can.FIX_PWD);
                    intent.putExtra("oldPwd",pwd);
                    startActivity(intent);

                }
                else
                {
                    showTip("信息不能为空");
                }
                break;
            default:
                break;
        }
    }
}
