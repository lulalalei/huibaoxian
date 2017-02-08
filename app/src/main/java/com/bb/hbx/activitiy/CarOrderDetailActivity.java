package com.bb.hbx.activitiy;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyCarOrderDetailAdapter;
import com.bb.hbx.adapter.MyExtraCarOrderDetailAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;


public class CarOrderDetailActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.call_layout)
    RelativeLayout call_layout;
    @BindView(R.id.order_layout)
    RelativeLayout order_layout;
    @BindView(R.id.askMoney_layout)
    RelativeLayout askMoney_layout;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.extraRecyclerView)
    RecyclerView extraRecyclerView;

    @BindView(R.id.insureInfo_tv)
    TextView insureInfo_tv;
    @BindView(R.id.insureItem_tv)
    TextView insureItem_tv;

    GridLayoutManager manager;
    GridLayoutManager extraManager;
    ArrayList<String> list=new ArrayList<>();
    ArrayList<String> extraList=new ArrayList<>();
    ArrayList<String> extraTotalList=new ArrayList<>();
    MyCarOrderDetailAdapter myCarOrderDetailAdapter;
    MyExtraCarOrderDetailAdapter myExtraCarOrderDetailAdapter;

    boolean moreOrLess=true;
    @Override
    public int getLayoutId() {
        return R.layout.activity_car_order_detail;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
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
        extraManager = new GridLayoutManager(this, 1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        extraRecyclerView.setLayoutManager(extraManager);
        recyclerView.setLayoutManager(this.manager);
        myExtraCarOrderDetailAdapter = new MyExtraCarOrderDetailAdapter(extraTotalList, this);
        extraRecyclerView.setAdapter(myExtraCarOrderDetailAdapter);
        for (int i = 0; i < 4; i++) {
            list.add("i:"+i);
        }
        for (int i = 0; i < 3; i++) {
            extraList.add("i:"+i);
        }
        //extraTotalList.addAll(extraList);
        myCarOrderDetailAdapter = new MyCarOrderDetailAdapter(list, this);

        recyclerView.setAdapter(myCarOrderDetailAdapter);
        myCarOrderDetailAdapter.setOnMyItemClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(int position) {
                //showTip("position:"+position);
                if (moreOrLess)
                {
                    extraTotalList.addAll(extraList);
                }
                else
                {
                    extraTotalList.clear();
                }
                moreOrLess=!moreOrLess;
                myExtraCarOrderDetailAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            case R.id.insureInfo_tv:
                showTip("投保须知");
                break;
            case R.id.insureItem_tv:
                showTip("保险条款");
                break;
            case R.id.call_layout:
                showTip("联系客服");
                break;
            case R.id.order_layout:
                showTip("电子保单");
                break;
            case R.id.askMoney_layout:
                showTip("我要理赔");
                break;
            default:
                break;
        }
    }
}
