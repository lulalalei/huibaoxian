package com.bb.hbx.activitiy;

import android.content.Intent;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

public class CustomServiceDetailActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.title_tv)
    TextView title_tv;
    @BindView(R.id.content_tv)
    TextView content_tv;
    @BindView(R.id.useful_tv)
    TextView useful_tv;
    @BindView(R.id.useless_tv)
    TextView useless_tv;
    @BindView(R.id.useful_iv)
    ImageView useful_iv;
    @BindView(R.id.useless_iv)
    ImageView useless_iv;

    String title;
    @Override
    public int getLayoutId() {
        return R.layout.activity_custom_service_detail;
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
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        title_tv.setText(title);
        TextPaint paint = title_tv.getPaint();
        paint.setFakeBoldText(true);
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
