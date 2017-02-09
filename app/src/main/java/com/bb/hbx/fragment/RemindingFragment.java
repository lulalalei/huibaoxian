package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bb.hbx.R;
import com.bb.hbx.adapter.RemindingAdapter;
import com.bb.hbx.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/8.
 */

public class RemindingFragment extends BaseFragment{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private Context mContext;

    ArrayList<String> list=new ArrayList<>();
    GridLayoutManager manager;
    RemindingAdapter adapter;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_reminding_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        manager = new GridLayoutManager(mContext, 1);
        recyclerView.setLayoutManager(manager);
        for (int i = 0; i < 10; i++) {
            list.add("i:"+i);
        }
        adapter = new RemindingAdapter(list, mContext);
        recyclerView.setAdapter(adapter);
    }
}
