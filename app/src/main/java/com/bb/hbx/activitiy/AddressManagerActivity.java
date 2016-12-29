package com.bb.hbx.activitiy;

import android.view.View;
import android.widget.ImageView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

public class AddressManagerActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_iv)
    ImageView back_iv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_address_manager;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

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
            default:
                break;
        }
    }
}
