package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/23.
 */

public class MyAllInMyOrderAdapter extends RecyclerView.Adapter<MyAllInMyOrderAdapter.MyViewHolder>{

    Context mContext;
    ArrayList<String> list;
    LayoutInflater inflater;

    public MyAllInMyOrderAdapter(Context mContext, ArrayList<String> list) {
        this.mContext = mContext;
        this.list = list;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.all_myorder_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.state_tv)
        TextView state_tv;
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
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
