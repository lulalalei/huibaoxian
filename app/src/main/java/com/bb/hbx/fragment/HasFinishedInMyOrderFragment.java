package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyHasFinishedInMyOrderAdapter;
import com.bb.hbx.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/1/23.
 */

public class HasFinishedInMyOrderFragment extends BaseFragment{

    Context mContext;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    String path="https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
    ArrayList<String> list=new ArrayList<>();
    GridLayoutManager manager;
    MyHasFinishedInMyOrderAdapter adapter;
    private static HasFinishedInMyOrderFragment fragment;
    public static HasFinishedInMyOrderFragment getInstance()
    {
        if (fragment==null)
        {
            fragment=new HasFinishedInMyOrderFragment();
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
        return R.layout.fragment_hasfinished_inmyorder_layout;
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
        if (list!=null&&list.size()>0)
        {
            list.clear();
        }
        for (int i = 0; i < 10; i++) {
            list.add(path);
        }
        adapter = new MyHasFinishedInMyOrderAdapter(mContext, list);
        recyclerView.setAdapter(adapter);
    }
}
