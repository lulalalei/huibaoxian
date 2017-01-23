package com.bb.hbx.activitiy;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.base.m.ProductDetailModle;
import com.bb.hbx.base.p.ProductDetailPresenter;
import com.bb.hbx.base.v.ProductDetailContract;
import com.bb.hbx.bean.ProductDetail;
import com.bb.hbx.utils.GlideUtil;

import butterknife.BindView;


/**
 * Created by Administrator on 2016/12/21.
 */

public class ProductDetailActivity extends BaseActivity<ProductDetailPresenter, ProductDetailModle> implements ProductDetailContract.View,
        View.OnClickListener {


    @BindView(R.id.iv_pic)
    ImageView iv_pic;

    @BindView(R.id.tv_name)
    TextView tv_name;

    @BindView(R.id.tv_pro)
    TextView tv_pro;

    @BindView(R.id.tv_matchall)
    TextView tv_matchall;


    @BindView(R.id.tv_morefeature)
    TextView tv_morefeature;


    private String productId = "";


    @BindView(R.id.iv_sub)
    ImageView iv_sub;

    @BindView(R.id.iv_add)
    ImageView iv_add;

    @BindView(R.id.tv_quantity)
    TextView tv_quantity;

    @BindView(R.id.tv_agree)
    TextView tv_agree;


    private int count = 1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_productdetail;
    }

    @Override
    public void initView() {
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            if (bundle.containsKey("productId")) {
                productId = bundle.getString("productId");
            }
        }
        SpannableString hintSp = new SpannableString(getResources().getString(R.string.agreement2));
        hintSp.setSpan(new TextAppearanceSpan(
                this, R.style.TextAppear_Theme_A3_Size12), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        hintSp.setSpan(new TextAppearanceSpan(
                this, R.style.TextAppear_Theme_A1_Size12), 4, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        hintSp.setSpan(new TextAppearanceSpan(
                this, R.style.TextAppear_Theme_A3_Size12), 22, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv_agree.setText(hintSp);
    }

    @Override
    public void initListener() {
        iv_add.setOnClickListener(this);
        iv_sub.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        mPresenter.getProductDetail(productId);
        tv_quantity.setText(count + "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_add:
                addCount();
                break;
            case R.id.iv_sub:
                subCount();
                break;

        }
    }

    public void addCount() {

        if (count == 1) {
            iv_sub.setVisibility(View.VISIBLE);
        } else if (count == 9) {
            iv_add.setVisibility(View.INVISIBLE);
        }
        count++;
        tv_quantity.setText(count + "");
    }

    public void subCount() {
        if (count == 2) {
            iv_sub.setVisibility(View.INVISIBLE);
        } else if (count == 8) {
            iv_add.setVisibility(View.VISIBLE);
        }
        count--;
        tv_quantity.setText(count + "");
    }

    @Override
    public void setProductDetail(ProductDetail detail) {
        GlideUtil.getInstance().loadImage(this, iv_pic, detail.getProductLogo(), true);
        tv_matchall.setText(detail.getInsurerName() + " | 销量 " + detail.getTotalAmount());
        tv_name.setText(detail.getProductName());

        if (MyApplication.user.getIsBClient()) {
            tv_pro.setVisibility(View.VISIBLE);
        } else {
            tv_pro.setVisibility(View.GONE);
        }

    }
}
