package com.bb.hbx.activitiy;

import android.view.View;
import android.widget.RelativeLayout;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

public class RecommendRewardActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_invite_friend;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
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
            default:
                break;
        }
    }
}
