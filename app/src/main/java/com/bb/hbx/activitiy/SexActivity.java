package com.bb.hbx.activitiy;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

public class SexActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_iv)
    ImageView back_iv;
    @BindView(R.id.boy_layout)
    RelativeLayout boy_layout;
    @BindView(R.id.girl_layout)
    RelativeLayout girl_layout;
    @BindView(R.id.boy_iv)
    ImageView boy_iv;
    @BindView(R.id.girl_iv)
    ImageView girl_iv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_sex;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_iv.setOnClickListener(this);
        boy_layout.setOnClickListener(this);
        girl_layout.setOnClickListener(this);
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
            case R.id.boy_layout:
                boy_iv.setImageResource(R.drawable.check);
                girl_iv.setImageBitmap(null);
                break;
            case R.id.girl_layout:
                girl_iv.setImageResource(R.drawable.check);
                boy_iv.setImageBitmap(null);
                break;
            default:
                break;
        }
    }
}
