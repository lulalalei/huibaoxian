package com.bb.hbx.activitiy;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

public class RealNameIdentifyActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_iv)
    ImageView back_iv;
    @BindView(R.id.front_layout)
    RelativeLayout front_layout;
    @BindView(R.id.reverse_layout)
    RelativeLayout reverse_layout;
    @BindView(R.id.next_tv)
    TextView next_tv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_real_name_identify;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_iv.setOnClickListener(this);
        front_layout.setOnClickListener(this);
        reverse_layout.setOnClickListener(this);
        next_tv.setOnClickListener(this);
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
            case R.id.front_layout:
                Toast.makeText(this,"拍摄身份证正面",Toast.LENGTH_SHORT).show();
                break;
            case R.id.reverse_layout:
                Toast.makeText(this,"拍摄身份证反面",Toast.LENGTH_SHORT).show();
                break;
            case R.id.next_tv:
                Intent intent = new Intent(this, RealNameCommitActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
