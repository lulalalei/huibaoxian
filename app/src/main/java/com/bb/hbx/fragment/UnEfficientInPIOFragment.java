package com.bb.hbx.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bb.hbx.R;
import com.bb.hbx.activitiy.PerOrderDetailActivity;
import com.bb.hbx.adapter.MyUnEfficientInPIOAdapter;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.MyPIOederBean;
import com.bb.hbx.interfaces.OnItemClickListener;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/26.
 */

public class UnEfficientInPIOFragment extends BaseFragment{

    @BindView(R.id.scrollView)
    PullToRefreshScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    GridLayoutManager manager;
    ArrayList<MyPIOederBean> totalList=new ArrayList<>();
    Context mContext;
    MyUnEfficientInPIOAdapter myUnEfficientInPIOAdapter;
    private static UnEfficientInPIOFragment fragment;
    public static UnEfficientInPIOFragment getInstance()
    {
        if (fragment==null)
        {
            fragment=new UnEfficientInPIOFragment();
        }
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_unefficient_inpio_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        manager = new GridLayoutManager(mContext, 1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(manager);
        if (totalList!=null&&totalList.size()>0)
        {
            totalList.clear();
        }
        for (int i = 0; i < 16; i++) {
            String title="户外运动保险计划:"+i;
            String number="订单号:"+i;
            String theInsured="被保险人:android,"+i;
            String insuranceHolder="投保人:ios,"+i;
            String time="保险期间:"+i;
            String state="待支付";
            MyPIOederBean bean = new MyPIOederBean(title, number, theInsured, insuranceHolder, time, state);
            totalList.add(bean);
        }
        myUnEfficientInPIOAdapter = new MyUnEfficientInPIOAdapter(totalList, mContext);
        recyclerView.setAdapter(myUnEfficientInPIOAdapter);
        myUnEfficientInPIOAdapter.setOnMyItemClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(int position) {
                Intent intent = new Intent(mContext, PerOrderDetailActivity.class);
                startActivity(intent);
            }
        });
        //listView.setAdapter(myUnEfficientInPIOAdapter);
    }
}
