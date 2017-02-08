package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/23.
 */

public class MyHadSentInCarInsuAdapter extends RecyclerView.Adapter<MyHadSentInCarInsuAdapter.MyViewHolder>{

    Context mContext;
    ArrayList<String> list;
    LayoutInflater inflater;
    OnItemClickListener onMyItemClickListener;

    public MyHadSentInCarInsuAdapter(Context mContext, ArrayList<String> list) {
        this.mContext = mContext;
        this.list = list;
        inflater=LayoutInflater.from(mContext);
    }

    public void setOnMyItemClickListener(OnItemClickListener onMyItemClickListener) {
        this.onMyItemClickListener = onMyItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.hadsent_carinsu_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMyItemClickListener.onMyItemClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.time_tv)
        TextView time_tv;
        @BindView(R.id.orderNumber_tv)
        TextView orderNumber_tv;
        @BindView(R.id.itemO_tv)
        TextView itemO_tv;
        @BindView(R.id.itemTw_tv)
        TextView itemTw_tv;
        @BindView(R.id.itemTh_tv)
        TextView itemTh_tv;
        @BindView(R.id.itemF_tv)
        TextView itemF_tv;
        @BindView(R.id.price_tv)
        TextView price_tv;
        @BindView(R.id.income_tv)
        TextView income_tv;
        @BindView(R.id.logo_iv)
        ImageView logo_iv;
        @BindView(R.id.state_iv)
        ImageView state_iv;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
