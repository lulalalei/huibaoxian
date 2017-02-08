package com.bb.hbx.activitiy;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyPerOrderDetailAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.MyPerOrderDetailBean;

import java.util.ArrayList;

import butterknife.BindView;

/*
* 保单详情页面  由点击 我的--个险订单 中的条目进入*/
public class PerOrderDetailActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;

    @BindView(R.id.buy_tv)
    TextView buy_tv;
    @BindView(R.id.insureInfo_tv)
    TextView insureInfo_tv;
    @BindView(R.id.insureItem_tv)
    TextView insureItem_tv;

    @BindView(R.id.call_layout)
    RelativeLayout call_layout;
    @BindView(R.id.order_layout)
    RelativeLayout order_layout;
    @BindView(R.id.askMoney_layout)
    RelativeLayout askMoney_layout;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    GridLayoutManager manager;
    MyPerOrderDetailAdapter adapter;

    ArrayList<MyPerOrderDetailBean> totalList=new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        buy_tv.setOnClickListener(this);
        insureInfo_tv.setOnClickListener(this);
        insureItem_tv.setOnClickListener(this);
        call_layout.setOnClickListener(this);
        order_layout.setOnClickListener(this);
        askMoney_layout.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        manager = new GridLayoutManager(this, 1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(manager);
        for (int i = 0; i < 4; i++) {
            String title="人身意外伤害";
            String price=(i+1)*10+"";
            MyPerOrderDetailBean detailBean = new MyPerOrderDetailBean(title, price);
            totalList.add(detailBean);
        }
        adapter = new MyPerOrderDetailAdapter(totalList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            case R.id.buy_tv:
                showTip("再次购买");
                break;
            case R.id.insureInfo_tv:
                Toast.makeText(this,"投保须知",Toast.LENGTH_SHORT).show();
                break;
            case R.id.insureItem_tv:
                Toast.makeText(this,"保险条款",Toast.LENGTH_SHORT).show();
                break;
            case R.id.call_layout:
                Toast.makeText(this,"客服电话",Toast.LENGTH_SHORT).show();
                break;
            case R.id.order_layout:
                Toast.makeText(this,"电子保单",Toast.LENGTH_SHORT).show();
                break;
            case R.id.askMoney_layout:
                Toast.makeText(this,"我要理赔",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}
