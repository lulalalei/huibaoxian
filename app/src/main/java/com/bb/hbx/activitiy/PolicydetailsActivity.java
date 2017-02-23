package com.bb.hbx.activitiy;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.base.m.PolicydetailModel;
import com.bb.hbx.base.p.PolicydetailPresenter;
import com.bb.hbx.base.v.PolicydetailsContract;
import com.bb.hbx.bean.TradeDetail;
import com.bb.hbx.bean.TradeDetailType;
import com.bb.hbx.provide.PolicyFormProvide;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.utils.TimeUtils;
import com.bb.hbx.utils.Utils;
import com.bb.hbx.widget.RecycleViewDivider;
import com.bb.hbx.widget.multitype.MultiTypeAdapter;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/17.
 */

public class PolicydetailsActivity extends BaseActivity<PolicydetailPresenter, PolicydetailModel>
        implements PolicydetailsContract.View {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.tv_tradeid)
    TextView tv_tradeid;

    @BindView(R.id.tv_startTime)
    TextView tv_startTime;

    @BindView(R.id.tv_endTime)
    TextView tv_endTime;
    @BindView(R.id.tv_name)
    TextView tv_name;

    @BindView(R.id.tv_idtype)
    TextView tv_idtype;

    @BindView(R.id.tv_idNo)
    TextView tv_idNo;

    @BindView(R.id.tv_tel)
    TextView tv_tel;

    @BindView(R.id.tv_productName)
    TextView tv_productName;


    @BindView(R.id.tv_price)
    TextView tv_price;

    @BindView(R.id.tv_realprice)
    TextView tv_realprice;

    @BindView(R.id.tv_tip)
    TextView tv_tip;
    //

    private MultiTypeAdapter adapter;

    private List<Item> items;

    private String tradeId = "";//订单号


    @Override
    public int getLayoutId() {
        return R.layout.activity_policydetails;
    }

    @Override
    public void initView() {

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();
        adapter.register(TradeDetailType.InsureListBean.class, new PolicyFormProvide());
        recyclerView.setAdapter(adapter);
        RecycleViewDivider divider = new RecycleViewDivider(this, LinearLayoutManager.VERTICAL,
                AppManager.getInstance().dp2px(this, 0.5), R.color.A6);

        recyclerView.addItemDecoration(divider);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initdata() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.containsKey("content")) {
                tradeId = bundle.getString("tradeId");
            }
        }

        if (!tradeId.isEmpty()) {
            mPresenter.getTradeDetail(tradeId, "");
        }

        items = new ArrayList<>();
        TradeDetailType.InsureListBean bean = new TradeDetailType.InsureListBean();
        bean.setInsureName(getString(R.string.bxzr));
        bean.setInsureAmount(getString(R.string.be));
        items.add(bean);
        adapter.setItems(items);


    }

    @Override
    public void getTradeDetail(TradeDetail detail) {
        tv_tradeid.setText(tradeId);
        tv_startTime.setText(TimeUtils.formatDate(detail.getStartTime()));
        tv_endTime.setText(TimeUtils.formatDate(detail.getEndTime()));
        tv_name.setText(detail.getApplicant());
        //tv_idtype.setText(StringUtils.idTostring(detail.get));
        tv_idNo.setText(detail.getApplicantMobile());
        tv_productName.setText(detail.getProductName());
        tv_price.setText(getString(R.string.howPrice, Utils.fromFenToYuan(detail.getSumPremium())));
        tv_realprice.setText(getString(R.string.howPrice, Utils.fromFenToYuan(detail.getPayAmount())));
        if (detail.getTypeList() != null) {
            items.addAll(detail.getTypeList().get(0).getInsureList());
            adapter.notifyDataSetChanged();
        }

        //tv_tip.setText();

    }
}
