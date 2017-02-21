package com.bb.hbx.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyInfoAdapter;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.GetMsgsBean;
import com.bb.hbx.interfaces.OnItemChangeStateClickListener;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/17.
 */

public class MyInfoFragment extends BaseFragment{

    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Context mContext;
    ArrayList<GetMsgsBean> list=new ArrayList<>();
    GridLayoutManager manager;
    MyInfoAdapter adapter;
    MyInfoReceiver myInfoReceiver;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_myinfo_layout;
    }


    @Override
    public void initView() {
        scrollView.scrollTo(0,0);
        initReceiver();
    }

    //注册广播接收者
    private void initReceiver() {
        myInfoReceiver = new MyInfoReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.myinfo");
        mContext.registerReceiver(myInfoReceiver,filter);
    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        manager = new GridLayoutManager(mContext, 1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        adapter = new MyInfoAdapter(mContext, list);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        for (int i = 0; i < 16; i++) {
            GetMsgsBean msgsBean = new GetMsgsBean("1");
            list.add(msgsBean);
        }
        adapter.notifyDataSetChanged();
        scrollView.scrollTo(0,0);
        adapter.setOnMyItemClickListener(new OnItemChangeStateClickListener() {
            @Override
            public void onMyItemChangeStateClickListener(int position, View view) {
                if (((Integer)position)==view.getTag())
                {
                    //view.setVisibility(View.GONE);
                    view.setBackgroundResource(R.drawable.shape_circle_white);
                    list.get(position).setSts("0");
                    adapter.notifyItemChanged(position);
                }
            }
        });
        adapter.setOnDeleteItemClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(final int position) {
                //Toast.makeText(mContext,"长按删除:"+position,Toast.LENGTH_SHORT).show();
                AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
                dialog.setTitle("确认要删除本条信息吗");
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(mContext,"删除:"+position,Toast.LENGTH_SHORT).show();
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                        for (int i = 0; i < list.size(); i++) {
                            Log.e("===AA==="+list.size(),"========="+list.get(i).getSts());
                        }
                    }
                });
                dialog.setNegativeButton("取消",null);
                dialog.show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mContext.unregisterReceiver(myInfoReceiver);
    }

    class MyInfoReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setSts("0");
            }
            adapter.notifyDataSetChanged();
        }
    }
}
