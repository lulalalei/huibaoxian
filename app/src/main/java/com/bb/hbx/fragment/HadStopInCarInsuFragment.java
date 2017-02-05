package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyHadStopInCarInsuAdapter;
import com.bb.hbx.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/1/23.
 */

public class HadStopInCarInsuFragment extends BaseFragment{

    Context mContext;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    String path="https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
    ArrayList<String> list=new ArrayList<>();
    GridLayoutManager manager;
    MyHadStopInCarInsuAdapter adapter;
    private static HadStopInCarInsuFragment fragment;
    public static HadStopInCarInsuFragment getInstance()
    {
        if (fragment==null)
        {
            fragment=new HadStopInCarInsuFragment();
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
        return R.layout.fragment_hadstop_incarinsu_layout;
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
        for (int i = 0; i < 10; i++) {
            list.add(path);
        }
        adapter = new MyHadStopInCarInsuAdapter(mContext, list);
        recyclerView.setAdapter(adapter);
    }
}
