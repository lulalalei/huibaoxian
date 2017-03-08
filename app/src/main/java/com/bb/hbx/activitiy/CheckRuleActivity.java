package com.bb.hbx.activitiy;

import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

/**
 * 作者：Created by Administrator on 2017/3/8 11:36
 * 邮箱：
 * 描述：邀请好友的查看规则页面
 */
public class CheckRuleActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.back_layout)
    RelativeLayout back_layout;

    @BindView(R.id.webview_checkrule)
    WebView webview_checkrule;

    @Override
    public int getLayoutId() {
        return R.layout.activity_checkrule;
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
        switch(v.getId()) {
            case R.id.back_layout:
                finish();
                break;
            default:
                break;
        }
    }
}
