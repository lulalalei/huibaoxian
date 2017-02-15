package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyOrderRecordInMyCustomAdapter;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/12.
 */

public class OrderRecordInMyCustomFragment extends BaseFragment{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Context mContext;
    ArrayList<String> list=new ArrayList<>();
    GridLayoutManager manager;
    MyOrderRecordInMyCustomAdapter adapter;
    private static OrderRecordInMyCustomFragment fragment;
    public static OrderRecordInMyCustomFragment getInstance()
    {
        if (fragment==null)
        {
            fragment=new OrderRecordInMyCustomFragment();
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
        return R.layout.fragment_orderrecord_inmycustom_layout;
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
        adapter = new MyOrderRecordInMyCustomAdapter(list, mContext);
        recyclerView.setAdapter(adapter);
        for (int i = 0; i < 6; i++) {
            list.add("i:"+i);
        }
        adapter.notifyDataSetChanged();
        adapter.setOnMyItemClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(int position) {
                Toast.makeText(mContext,"position:"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
