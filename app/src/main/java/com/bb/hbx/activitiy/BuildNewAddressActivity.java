package com.bb.hbx.activitiy;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

public class BuildNewAddressActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_iv)
    ImageView back_iv;
    @BindView(R.id.isNormalAddress_iv)
    ImageView isNormalAddress_iv;
    @BindView(R.id.isNormalAddress_layout)
    RelativeLayout isNormalAddress_layout;

    boolean isNormalAddress;
    @Override
    public int getLayoutId() {
        return R.layout.activity_build_new_address;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_iv.setOnClickListener(this);
        isNormalAddress_layout.setOnClickListener(this);
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
            case R.id.isNormalAddress_layout:
                if (isNormalAddress)
                {
                    isNormalAddress_iv.setSelected(false);
                    isNormalAddress=false;
                }
                else
                {
                    isNormalAddress_iv.setSelected(true);
                    isNormalAddress=true;
                }
                break;
            default:
                break;
        }
    }
}
