package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyCanReceiveInPresInsuAdapter;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/9.
 */

public class CanReceiveInPreInsuFragment extends BaseFragment{

    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Context mContext;
    GridLayoutManager manager;
    ArrayList<String> list=new ArrayList<>();
    MyCanReceiveInPresInsuAdapter adapter;
    private static CanReceiveInPreInsuFragment fragment;
    public static CanReceiveInPreInsuFragment getInstance()
    {
        if (fragment==null)
        {
            fragment=new CanReceiveInPreInsuFragment();
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
        return R.layout.fragment_canreceive_inpres_layout;
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
        adapter = new MyCanReceiveInPresInsuAdapter(list, mContext);
        recyclerView.setAdapter(adapter);
        if (list!=null&&list.size()>0)
        {
            list.clear();
        }
        for (int i = 0; i < 6; i++) {
            list.add("i:"+i);
        }
        adapter.notifyDataSetChanged();
        adapter.setOnPresentClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(int position) {
                Toast.makeText(mContext,"赠送客户:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnBuyClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(int position) {
                Toast.makeText(mContext,"立即投保:"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
