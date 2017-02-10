package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/9.
 */

public class MyCanReceiveInPresInsuAdapter extends RecyclerView.Adapter<MyCanReceiveInPresInsuAdapter.MyViewHolder>{

    ArrayList<String> list;
    Context mContext;
    LayoutInflater inflater;
    OnItemClickListener onPresentClickListener;
    OnItemClickListener onBuyClickListener;

    public MyCanReceiveInPresInsuAdapter(ArrayList<String> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
        inflater=LayoutInflater.from(mContext);
    }

    public void setOnBuyClickListener(OnItemClickListener onBuyClickListener) {
        this.onBuyClickListener = onBuyClickListener;
    }

    public void setOnPresentClickListener(OnItemClickListener onPresentClickListener) {
        this.onPresentClickListener = onPresentClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.canreceive_present_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.present_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPresentClickListener.onMyItemClickListener(position);
            }
        });
        holder.buy_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBuyClickListener.onMyItemClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.present_tv)
        TextView present_tv;
        @BindView(R.id.buy_tv)
        TextView buy_tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
