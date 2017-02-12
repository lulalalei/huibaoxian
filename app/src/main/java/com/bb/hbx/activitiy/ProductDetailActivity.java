package com.bb.hbx.activitiy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.DatePickerDialog;
import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.base.m.ProductDetailModle;
import com.bb.hbx.base.p.ProductDetailPresenter;
import com.bb.hbx.base.v.ProductDetailContract;
import com.bb.hbx.bean.ProductDetail;

import com.bb.hbx.widget.CardLayout;
import com.bb.hbx.widget.ItemLayout;
import com.bb.hbx.widget.ItemLayout2;
import com.bb.hbx.widget.PickerDialogOneWheel;
import com.bb.hbx.widget.ShareDailog;



import java.util.Arrays;

import butterknife.BindView;




/**
 * Created by fancl.
 * 详情页
 */

public class ProductDetailActivity extends BaseActivity<ProductDetailPresenter, ProductDetailModle> implements ProductDetailContract.View,
        View.OnClickListener {


    @BindView(R.id.sl)
    ScrollView sl;

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

    @BindView(R.id.iv_sub)
    ImageView iv_sub;

    @BindView(R.id.iv_add)
    ImageView iv_add;

    @BindView(R.id.tv_quantity)
    TextView tv_quantity;

    @BindView(R.id.tv_agree)
    TextView tv_agree;

    @BindView(R.id.il_up1)
    ItemLayout2 il_up1;

    @BindView(R.id.il_up2)
    ItemLayout2 il_up2;

    @BindView(R.id.il_up3)
    ItemLayout2 il_up3;

    @BindView(R.id.il_insurer1)
    ItemLayout il_insurer1;

    @BindView(R.id.il_insurer2)
    ItemLayout il_insurer2;

    @BindView(R.id.il_insurer3)
    ItemLayout il_insurer3;

    @BindView(R.id.il_insurer4)
    ItemLayout il_insurer4;


    @BindView(R.id.lin_share)
    LinearLayout lin_share;

    @BindView(R.id.clayout)
    CardLayout clayout;


    private String productId = "";

    private int count = 1;

    private PickerDialogOneWheel.OnTextListener textListener = new PickerDialogOneWheel.OnTextListener() {
        @Override
        public void onClick(View v, String value) {
            switch (v.getId()) {
                case R.id.il_up1:
                    il_up1.setText(value);
                    break;
                case R.id.il_up2:
                    il_up2.setText(value);
                    break;
            }
        }

        @Override
        public void dissmiss(View v) {
            switch (v.getId()) {
                case R.id.il_up1:
                    il_up1.setdownImageResource();
                    break;
                case R.id.il_up2:
                    il_up2.setdownImageResource();
                    break;
            }
        }
    };

    @Override
    public int getLayoutId() {
        initState();
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
        tv_morefeature.setOnClickListener(this);
        lin_share.setOnClickListener(this);
        il_up1.setListener(new ItemLayout2.OnUpListener() {
            @Override
            public void onClick() {
                String[] strings = {"1-7天", "1-3个月", "1-3年"};
                PickerDialogOneWheel wheel = new PickerDialogOneWheel(mContext, Arrays.asList(strings), il_up1);
                wheel.setListener(textListener);
                wheel.setDialogMode(PickerDialogOneWheel.DIALOG_MODE_BOTTOM);
                wheel.show();

            }
        });

        il_up2.setListener(new ItemLayout2.OnUpListener() {
            @Override
            public void onClick() {
                String[] strings = {"男", "女"};
                PickerDialogOneWheel wheel = new PickerDialogOneWheel(mContext, Arrays.asList(strings), il_up2);
                wheel.setListener(textListener);
                wheel.setDialogMode(PickerDialogOneWheel.DIALOG_MODE_BOTTOM);
                wheel.show();
            }
        });

        il_up3.setListener(new ItemLayout2.OnUpListener() {
            @Override
            public void onClick() {
                DatePickerDialog dialog = new DatePickerDialog(mContext);
                dialog.setDialogMode(DatePickerDialog.DIALOG_MODE_BOTTOM);
                dialog.show();
                dialog.setDatePickListener(new DatePickerDialog.OnDatePickListener() {
                    @Override
                    public void onClick(String year, String month, String day) {
                        il_up3.setText(year + "-" + month + "-" + day);
                    }

                    @Override
                    public void ondissmiss() {
                        il_up3.setdownImageResource();
                    }
                });
            }
        });

        clayout.setListener(new CardLayout.CardListener() {
            @Override
            public void onclick(int index) {
                showMsg("index:" + index);
            }
        });

    }

    @Override
    public void initdata() {
        mPresenter.getProductDetail(productId);
        tv_quantity.setText(count + "");
        clayout.setCount(3);
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
            case R.id.lin_share:
                ShareDailog shareDailog = new ShareDailog(this);
                shareDailog.show();
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
        //GlideUtil.getInstance().loadImage(this, iv_pic, detail.getProductLogo(), true);
        tv_matchall.setText(detail.getInsurerName() + " | 销量 " + detail.getTotalAmount());
        tv_name.setText(detail.getProductName());

        if (MyApplication.user.getIsBClient()) {
            tv_pro.setVisibility(View.VISIBLE);
        } else {
            tv_pro.setVisibility(View.GONE);
        }

    }

    //Span的点击事件
    static class ClickAble extends ClickableSpan {

        @Override
        public void onClick(View widget) {
//            Bundle bundle=new Bundle();
//            bundle.putString("","");
//            AppManager.getInstance().showActivity();
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setColor(Color.parseColor("#2dce8f"));
            ds.setTextSize(12);
        }
    }


}
