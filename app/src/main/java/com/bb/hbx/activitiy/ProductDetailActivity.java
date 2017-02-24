package com.bb.hbx.activitiy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.base.m.ProductDetailModle;
import com.bb.hbx.base.p.ProductDetailPresenter;
import com.bb.hbx.base.v.ProductDetailContract;
import com.bb.hbx.bean.Benefit;
import com.bb.hbx.bean.Entry;
import com.bb.hbx.bean.Insured;
import com.bb.hbx.bean.KeyBean;
import com.bb.hbx.bean.Plan;
import com.bb.hbx.bean.PriceTag;
import com.bb.hbx.bean.ProdectDetalRequest;
import com.bb.hbx.bean.ProductParamDetail;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.widget.CardLayout;
import com.bb.hbx.widget.ClickAble;
import com.bb.hbx.widget.ItemLayout;
import com.bb.hbx.widget.ItemLayout2;
import com.bb.hbx.widget.PickerDialogOneWheel;
import com.bb.hbx.widget.ShareDailog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;


import static com.bb.hbx.utils.Constants.idType_keys;
import static com.bb.hbx.utils.Constants.idTypes;


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

    @BindView(R.id.tv_description1)
    TextView tv_description1;

    @BindView(R.id.tv_description2)
    TextView tv_description2;

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


    @BindView(R.id.il_insurer1)
    ItemLayout il_insurer1;

    @BindView(R.id.il_insurer2)
    ItemLayout il_insurer2;

    @BindView(R.id.il_beinsurer2)
    ItemLayout il_beinsurer2;


    @BindView(R.id.il_beinsurer4)
    ItemLayout il_beinsurer4;

    @BindView(R.id.il_insurer3)
    ItemLayout il_insurer3;

    @BindView(R.id.il_insurer4)
    ItemLayout il_insurer4;

    @BindView(R.id.il_beinsurer3)
    ItemLayout il_beinsurer3;


    @BindView(R.id.lin_share)
    LinearLayout lin_share;

    @BindView(R.id.clayout)
    CardLayout clayout;


    @BindView(R.id.lin_additem)
    LinearLayout lin_additem;

    @BindView(R.id.ll_add)
    LinearLayout ll_add;

    @BindView(R.id.tv_price)
    TextView tv_price;

    @BindView(R.id.tv_buy)
    TextView tv_buy;

    @BindView(R.id.il_beinsurer1)
    ItemLayout il_beinsurer1;

    @BindView(R.id.layout_tab2)
    View layout_tab2;//起保时间

    @BindView(R.id.lin_count)
    LinearLayout lin_count;//购买的份数


    //

    private String[] perids;//保障期限的列表

    private String selectPerids;//当前的选中的保障期限

    private String productId = "";

    private int count = 1;//当前的投保份数

    private int max_Quto;//投保最大份数

    private double singlePrice;//机甲因子的求出的保额价格


    private KeyBean keyBean;//价格因子生成的字符串

    private Plan cruentPlan = new Plan();

    private PickerDialogOneWheel wheel_data;

    private ProductParamDetail productParamDetail;


    private String[] beinsurer1_listvalue = {"父母", "子女", "配偶", "其他关系"};//关系

    private int[] beinsurer1_listkey = {1, 2, 3, 9};//关系键

    private int beinsurer1key = 1;


    private int insureridType = 1;//投保人的idtype

    private int beinsureridType = 1;//被保人的idtype;


    private PickerDialogOneWheel.OnTextListener textListener = new PickerDialogOneWheel.OnTextListener() {
        @Override
        public void onClick(View v, String value, int index) {
            if (v instanceof ItemLayout2) {
                ((ItemLayout2) v).setText(value);
                if ((int) (v.getTag()) == 0) {
                    selectPerids = perids[index];
                    keyBean.set(keyBean.size() - 1, perids[index]);
                } else {
                    keyBean.set((Integer) v.getTag(), value);
                }
                setTextPrice();
            } else if (v instanceof ItemLayout) {
                if ((int) (v.getTag()) == 11) {
                    il_beinsurer1.setText(beinsurer1_listvalue[index]);
                    beinsurer1key = beinsurer1_listkey[index];
                } else if ((int) (v.getTag()) == 12) {
                    il_insurer2.setText(idTypes[index]);
                    insureridType = idType_keys[index];
                } else if ((int) v.getTag() == 13) {
                    il_beinsurer3.setText(idTypes[index]);
                    beinsureridType = idType_keys[index];
                }
            }
        }

        @Override
        public void dissmiss(View v) {
            if (v instanceof ItemLayout2) {
                ((ItemLayout2) v).setdownImageResource();
            } else if (v instanceof ItemLayout) {
                ((ItemLayout) v).setdownImageResource();
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
        hintSp.setSpan(new ClickAble(4, mContext), 4, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        hintSp.setSpan(new ClickAble(10, mContext), 10, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        hintSp.setSpan(new ClickAble(16, mContext), 16, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        hintSp.setSpan(new TextAppearanceSpan(
                this, R.style.TextAppear_Theme_A3_Size12), 22, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_agree.setText(hintSp);
        tv_agree.setMovementMethod(LinkMovementMethod.getInstance());//不设置 没有点击事件
    }

    @Override
    public void initListener() {
        tv_buy.setOnClickListener(this);
        iv_add.setOnClickListener(this);
        iv_sub.setOnClickListener(this);
        tv_morefeature.setOnClickListener(this);
        lin_share.setOnClickListener(this);
        il_up1.setTag(0);
        il_up1.setListener(new ItemLayout2.OnUpListener() {
            @Override
            public void onClick() {
                if (perids != null && perids.length > 1) {
                    String[] ps = new String[perids.length];
                    for (int i = 0; i < ps.length; i++) {
                        ps[i] = perids[i].substring(0, perids[i].indexOf("_"));
                    }
                    if (wheel_data == null) {
                        wheel_data = new PickerDialogOneWheel(mContext, Arrays.asList(ps), il_up1);
                        wheel_data.setListener(textListener);
                        wheel_data.setDialogMode(PickerDialogOneWheel.DIALOG_MODE_BOTTOM);
                    }
                    wheel_data.show();

                }


            }
        });

        clayout.setListener(new CardLayout.CardListener() {
            @Override
            public void onclick(int index) {
                if (productParamDetail != null && !productParamDetail.getPlanList().isEmpty()) {
                    //index>=1;
                    cruentPlan = productParamDetail.getPlanList().get(index - 1);
                    List<Benefit> benefits = cruentPlan.getClassNameList().get(0).getBenefitList();
                    keyBean.set(0, cruentPlan.getPlanName().trim());
                    setTextPrice();
                    //----------------------------------
                    lin_additem.removeAllViews();
                    if (benefits != null && benefits.size() > 0) {

                        for (int i = 0; i < benefits.size(); i++) {
                            if (i > 3) {
                                break;
                            }
                            Benefit benefit = benefits.get(i);
                            View view = LayoutInflater.from(mContext).inflate(R.layout.cardlayout_item, null, false);
                            lin_additem.addView(view);
                            TextView tv_appendKey = (TextView) view.findViewById(R.id.tv_appendKey);
                            TextView tv_appendValue = (TextView) view.findViewById(R.id.tv_appendValue);
                            tv_appendKey.setText(benefit.getBenefitName());
                            tv_appendValue.setText(benefit.getInsuredAmount());
                        }
                    }
                }
            }
        });


        il_beinsurer1.setListener(new ItemLayout.OnBtnListener() {

            @Override
            public void onClick() {
                il_beinsurer1.setTag(11);
                PickerDialogOneWheel wheel = new PickerDialogOneWheel(mContext, Arrays.asList(beinsurer1_listvalue), il_beinsurer1);
                wheel.setListener(textListener);
                wheel.setDialogMode(PickerDialogOneWheel.DIALOG_MODE_BOTTOM);
                wheel.show();
            }
        });


        il_insurer2.setTag(12);
        il_insurer2.setListener(new ItemLayout.OnBtnListener() {
            @Override
            public void onClick() {
                if (idTypes != null && idTypes.length > 1) {
                    PickerDialogOneWheel wheel_data = new PickerDialogOneWheel(mContext, Arrays.asList(idTypes), il_insurer2);
                    wheel_data.setListener(textListener);
                    wheel_data.setDialogMode(PickerDialogOneWheel.DIALOG_MODE_BOTTOM);
                    wheel_data.show();

                }
            }
        });

        il_beinsurer3.setTag(13);
        il_beinsurer3.setListener(new ItemLayout.OnBtnListener() {
            @Override
            public void onClick() {
                if (idTypes != null && idTypes.length > 1) {
                    PickerDialogOneWheel wheel_data = new PickerDialogOneWheel(mContext, Arrays.asList(idTypes), il_beinsurer3);
                    wheel_data.setListener(textListener);
                    wheel_data.setDialogMode(PickerDialogOneWheel.DIALOG_MODE_BOTTOM);
                    wheel_data.show();

                }
            }
        });

    }

    @Override
    public void initdata() {
        mPresenter.getProductDetail(productId);
        tv_quantity.setText(count + "");
        keyBean = new KeyBean();
        keyBean.add(" ");


        il_beinsurer1.setText(beinsurer1_listvalue[0]);
        beinsurer1key = beinsurer1_listkey[0];

        il_insurer2.setText(idTypes[0]);
        insureridType = idType_keys[0];

        il_beinsurer3.setText(idTypes[0]);
        beinsureridType = idType_keys[0];

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
            case R.id.tv_buy:
                if (singlePrice > 0) {
                    ProdectDetalRequest request = new ProdectDetalRequest();
                    request.setUserId(MyApplication.user.getUserId());
                    request.setProductId(productParamDetail.getProductId());
                    request.setPriceKeyword(keyBean.toString());
                    request.setPlanId(cruentPlan.getPlanId());
                    request.setPeriod(selectPerids);
//                    request.setStartTime("20161205122222");
//                    request.setEndTime("20161210122222");
                    request.setIsExpress("0");

                    List<Insured> insuredList = new ArrayList<>();
                    Insured insured = new Insured();
                    //insured.setInsuredId();
                    insured.setNum(count);
                    insured.setOccupation(productParamDetail.getOccupation());
                    insured.setRelationType(beinsurer1key + "");
                    insured.setIdNo(il_beinsurer4.getEtValue());
                    insured.setIdType(beinsureridType);
                    insured.setInsuredName(il_beinsurer2.getEtValue());
                    insuredList.add(insured);
                    request.setInsuredList(insuredList);
                    request.setIdNo(il_insurer3.getEtValue());
                    request.setMobile(il_insurer4.getEtValue());
                    request.setIdType(insureridType);
                    request.setApplicant(il_insurer1.getEtValue());
                    mPresenter.applyTrade(request);
                } else {
                    showMsg("请把信息填写完整。。。");
                }

                //AppManager.getInstance().showActivity(ConfirmpaymentActivity.class, null);
                break;

        }
    }

    public void addCount() {

        if (count == 1) {
            iv_sub.setVisibility(View.VISIBLE);
        } else if (count == max_Quto - 1) {
            iv_add.setVisibility(View.INVISIBLE);
        }
        count++;
        tv_quantity.setText(count + "");
        setTextPrice();
    }

    public void subCount() {


        if (count <= max_Quto) {
            iv_add.setVisibility(View.VISIBLE);
        }

        if (count <= 2) {
            iv_sub.setVisibility(View.INVISIBLE);
        }

        count--;
        tv_quantity.setText(count + "");
        setTextPrice();
    }

    @Override
    public void setProductDetail(ProductParamDetail detail) {
        productParamDetail = detail;
        //GlideUtil.getInstance().loadImage(this, iv_pic, detail.getProductLogo(), true);
        tv_matchall.setText(detail.getInsurerName() + " | 销量 " + detail.getTotalAmount());
        tv_name.setText(detail.getProductName());

        tv_description1.setText(detail.getProductFeature());
        tv_description2.setText(detail.getPerferWords());
        if (detail.getQuota() == 0) {
            max_Quto = Integer.MAX_VALUE;
        } else if (detail.getQuota() == 1) {
            max_Quto = 1;
            iv_add.setVisibility(View.INVISIBLE);
        } else {
            max_Quto = detail.getQuota();
        }

        if (max_Quto == 1) {//购买份数一份 隐藏
            lin_count.setVisibility(View.GONE);
        }

        ItemLayout2 layout2 = (ItemLayout2) layout_tab2.findViewById(R.id.il_up1);
        LinearLayout line = (LinearLayout) layout_tab2.findViewById(R.id.lin_line);
        layout2.setLeft_name(getString(R.string.qbsj2));
        if (detail.getEffectiveType() == 1) {
            layout2.setText(detail.getEffectDate());
            layout2.setButtonGone();
        } else {
            //
        }


        if (max_Quto == 1) {//隐藏横线
            line.setVisibility(View.GONE);
        }


        if (MyApplication.user.getIsBClient()) {
            tv_pro.setVisibility(View.VISIBLE);
            tv_pro.setText(detail.getCommisionValue1() + "%推广费");
        } else {
            tv_pro.setVisibility(View.GONE);
        }
        if (detail.getPlanList() != null) {
            clayout.setPlanList(detail.getPlanList());
            clayout.setCount(detail.getPlanList().size());
        }

        String perid = productParamDetail.getGuaranteePeriod();
        if (perid != null && perid.indexOf(";") > -1) {
            perids = perid.split(";");
        } else {
            perid = "";
            perids = new String[]{perid};
            il_up1.setEnable(false);
        }
        il_up1.setText(perids[0].substring(0, perids[0].indexOf("_")));
        selectPerids = perids[0];


        if (detail.getPriceElements() != null) {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(detail.getPriceElements());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (jsonObject.has("price_element")) {
                JSONArray jaList = jsonObject.optJSONArray("price_element");
                List<Entry> list = new ArrayList<>();
                for (int i = 0; i < jaList.length(); i++) {
                    JSONObject obj = jaList.optJSONObject(i);
                    final Entry entry = new Entry();
                    if (obj.has("name"))
                        entry.setName(obj.optString("name"));
                    if (obj.has("option")) {
                        String opt = obj.optString("option");
                        if (opt.indexOf(",") > -1) {
                            String[] opts = opt.split(",");
                            entry.setOption(Arrays.asList(opts));
                        } else {
                            String[] opts = {opt};
                            entry.setOption(Arrays.asList(opts));
                        }


                    }
                    list.add(entry);
                    keyBean.add(entry.getOption().get(0));
                    View view = LayoutInflater.from(mContext).inflate(R.layout.item_insured_up2, null);
                    ll_add.addView(view);
                    final ItemLayout2 up = (ItemLayout2) view.findViewById(R.id.il_up1);
                    up.setTag(i + 1);
                    up.setLeft_name(entry.getName());
                    if (entry.getOption() != null && !entry.getOption().isEmpty()) {
                        if (entry.getOption().size() > 1) {
                            up.setText(entry.getOption().get(0));
                            up.setListener(new ItemLayout2.OnUpListener() {
                                @Override
                                public void onClick() {
                                    PickerDialogOneWheel wheel = new PickerDialogOneWheel(mContext, entry.getOption(), up);
                                    wheel.setListener(textListener);
                                    wheel.setDialogMode(PickerDialogOneWheel.DIALOG_MODE_BOTTOM);
                                    wheel.show();
                                }
                            });
                        } else {
                            up.setText(entry.getOption().get(0));
                            up.setEnabled(false);
                        }

                    }

                }

                detail.setEntries(list);
            }


        }

        keyBean.add(perids[0]);
        setTextPrice();

    }

    private void setTextPrice() {
        singlePrice = ischeckPrice();
        tv_price.setText("￥" + singlePrice * count);
    }


    public double ischeckPrice() {
        if (productParamDetail.getPriceList() != null && !productParamDetail.getPriceList().isEmpty()) {

            for (PriceTag tag : productParamDetail.getPriceList()) {
                if (keyBean.toString().trim().equalsIgnoreCase(tag.getPriceKeyword().trim())) {
                    return Double.valueOf(tag.getProductPremium());
                }
            }
        }
        return 0;
    }


}
