package com.bb.hbx.activitiy;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.fragment.CustomersManagerFragment;
import com.bb.hbx.fragment.RemindingFragment;

import butterknife.BindView;

public class CustomerManagerActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.content_layout)
    RelativeLayout content_layout;
    @BindView(R.id.search_iv)
    ImageView search_iv;
    @BindView(R.id.customers_tv)
    TextView customers_tv;
    @BindView(R.id.reminding_tv)
    TextView reminding_tv;


    FragmentManager fragmentManager;
    CustomersManagerFragment customersManagerFragment;
    RemindingFragment remindingFragment;
    @Override
    public int getLayoutId() {
        return R.layout.activity_customer_manager;
    }

    @Override
    public void initView() {
        fragmentManager = getSupportFragmentManager();
        customersManagerFragment = new CustomersManagerFragment();
        remindingFragment = new RemindingFragment();

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        search_iv.setOnClickListener(this);
        customers_tv.setOnClickListener(this);
        reminding_tv.setOnClickListener(this);

    }

    @Override
    public void initdata() {
        fragmentManager.beginTransaction().add(R.id.content_layout,customersManagerFragment).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            case R.id.search_iv:
                showTip("搜索");
                break;
            case R.id.customers_tv:
                //showTip("客户管理");
                if (customersManagerFragment.isAdded())
                {
                    fragmentManager.beginTransaction().hide(remindingFragment).show(customersManagerFragment).commit();
                }
                else
                {
                    fragmentManager.beginTransaction().add(R.id.content_layout,customersManagerFragment).commit();
                }
                break;
            case R.id.reminding_tv:
                //showTip("事件提醒");
                if (remindingFragment.isAdded())
                {
                    fragmentManager.beginTransaction().hide(customersManagerFragment).show(remindingFragment).commit();
                }
                else
                {
                    fragmentManager.beginTransaction().add(R.id.content_layout,remindingFragment).commit();
                }
                break;
            default:
                break;
        }
    }
}
