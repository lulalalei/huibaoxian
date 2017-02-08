package com.bb.hbx.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;

import com.bb.hbx.R;
import com.bb.hbx.activitiy.PerOrderDetailActivity;
import com.bb.hbx.adapter.MyAllInPIOAdapter;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.MyPIOederBean;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/26.
 */

public class AllInPIOFragment extends BaseFragment{

    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    GridLayoutManager manager;
    ArrayList<MyPIOederBean> totalList=new ArrayList<>();
    Context mContext;
    MyAllInPIOAdapter myAllInPIOAdapter;
    private static AllInPIOFragment fragment;
    public static AllInPIOFragment getInstance()
    {
        if (fragment==null)
        {
            fragment=new AllInPIOFragment();
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
        return R.layout.fragment_all_inpio_layout;
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
            String state="全部";
            MyPIOederBean bean = new MyPIOederBean(title, number, theInsured, insuranceHolder, time, state);
            totalList.add(bean);
        }
        myAllInPIOAdapter = new MyAllInPIOAdapter(totalList, mContext);
        recyclerView.setAdapter(myAllInPIOAdapter);
        myAllInPIOAdapter.setOnMyItemClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(int position) {
                //showTip("position:"+position);
                Intent intent = new Intent(mContext, PerOrderDetailActivity.class);
                startActivity(intent);
            }
        });
        //listView.setAdapter(myAllInPIOAdapter);

        //跳转页面已经写好
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Toast.makeText(mContext,"当前条目位置:"+position,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, PerOrderDetailActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
