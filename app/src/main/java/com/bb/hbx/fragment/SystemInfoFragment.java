package com.bb.hbx.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MySystemInfoAdapter;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.GetMsgsBean;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/17.
 */

public class SystemInfoFragment extends BaseFragment{

    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Context mContext;
    ArrayList<GetMsgsBean> list=new ArrayList<>();
    GridLayoutManager manager;
    MySystemInfoAdapter adapter;
    SystemInfoReceiver systemInfoReceiver;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_systeminfo_layout;
    }

    @Override
    public void initView() {
        initReceiver();
    }

    private void initReceiver() {
        systemInfoReceiver = new SystemInfoReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.myinfo");
        mContext.registerReceiver(systemInfoReceiver,filter);
    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        manager = new GridLayoutManager(mContext, 1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        adapter = new MySystemInfoAdapter(mContext, list);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        for (int i = 0; i < 2; i++) {
            GetMsgsBean msgsBean = new GetMsgsBean("1");
            list.add(msgsBean);
        }
        adapter.notifyDataSetChanged();
        adapter.setOnMyItemClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(int position) {
                Toast.makeText(mContext,"position:"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mContext.unregisterReceiver(systemInfoReceiver);
    }

    class SystemInfoReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setSts("0");
            }
            adapter.notifyDataSetChanged();
        }
    }
}
