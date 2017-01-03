package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.MyInsuranceItemInDetailBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/3.
 */

public class MyInsuranceItemInDetailAdapter extends RecyclerView.Adapter<MyInsuranceItemInDetailAdapter.MyViewHolder>{

    ArrayList<MyInsuranceItemInDetailBean> list;
    Context mContext;
    LayoutInflater inflater;

    public MyInsuranceItemInDetailAdapter(ArrayList<MyInsuranceItemInDetailBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.insuranceitem_indetail_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.insuranceItem_tv.setText(list.get(position).getTitle());
        holder.price_tv.setText(list.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.insuranceItem_tv)
        TextView insuranceItem_tv;
        @BindView(R.id.price_tv)
        TextView price_tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
