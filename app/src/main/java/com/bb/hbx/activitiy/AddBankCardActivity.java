package com.bb.hbx.activitiy;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

public class AddBankCardActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_iv)
    ImageView back_iv;
    @BindView(R.id.nameInfo_iv)
    ImageView nameInfo_iv;

    @BindView(R.id.choseBank_layout)
    RelativeLayout choseBank_layout;
    @BindView(R.id.verify_tv)
    TextView verify_tv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_add_bank_card;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_iv.setOnClickListener(this);
        nameInfo_iv.setOnClickListener(this);
        choseBank_layout.setOnClickListener(this);
        verify_tv.setOnClickListener(this);
    }

    @Override
    public void initdata() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_iv:
                finish();
                break;
            case R.id.nameInfo_iv:
                Toast.makeText(this,"请输入真实姓名",Toast.LENGTH_SHORT).show();
                break;
            case R.id.choseBank_layout:
                Toast.makeText(this,"选择银行",Toast.LENGTH_SHORT).show();
                break;
            case R.id.verify_tv:
                Toast.makeText(this,"确认",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}
