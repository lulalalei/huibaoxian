package com.bb.hbx.activitiy;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

public class PersonInfoSettingActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.name_layout)
    RelativeLayout name_layout;
    @BindView(R.id.sex_layout)
    RelativeLayout sex_layout;
    @BindView(R.id.address_layout)
    RelativeLayout address_layout;
    @BindView(R.id.countSafe_layout)
    RelativeLayout countSafe_layout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_person_info_setting;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initListener() {
        name_layout.setOnClickListener(this);
        sex_layout.setOnClickListener(this);
        address_layout.setOnClickListener(this);
        countSafe_layout.setOnClickListener(this);
    }

    @Override
    public void initdata() {

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.name_layout:
                intent.setClass(PersonInfoSettingActivity.this,EditNameActivity.class);
                startActivity(intent);
                break;
            case R.id.sex_layout:
                intent.setClass(PersonInfoSettingActivity.this,SexActivity.class);
                startActivity(intent);
                break;
            case R.id.address_layout:
                intent.setClass(PersonInfoSettingActivity.this,AddressManagerActivity.class);
                startActivity(intent);
                break;
            case R.id.countSafe_layout:
                Toast.makeText(PersonInfoSettingActivity.this,"点击",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
