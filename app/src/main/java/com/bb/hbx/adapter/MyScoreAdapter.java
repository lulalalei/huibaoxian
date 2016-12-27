package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.MyScoreBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/27.
 */

public class MyScoreAdapter extends RecyclerView.Adapter<MyScoreAdapter.MyViewHolder>{

    ArrayList<MyScoreBean> list;
    Context mContext;
    LayoutInflater inflater;

    public MyScoreAdapter(ArrayList<MyScoreBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
        inflater=LayoutInflater.from(mContext);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.layout_score,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.id_tv.setText(list.get(position).getId());
        holder.time_tv.setText(list.get(position).getTime());
        holder.price_tv.setText(list.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.id_tv)
        TextView id_tv;
        @BindView(R.id.time_tv)
        TextView time_tv;
        @BindView(R.id.price_tv)
        TextView price_tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
