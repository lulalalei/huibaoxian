package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.GetMsgsBean;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/17.
 */

public class MySystemInfoAdapter extends RecyclerView.Adapter<MySystemInfoAdapter.MyViewHodler>{

    Context mContext;
    ArrayList<GetMsgsBean> list;
    LayoutInflater inflater;
    OnItemClickListener onMyItemClickListener;

    public MySystemInfoAdapter(Context mContext, ArrayList<GetMsgsBean> list) {
        this.mContext = mContext;
        this.list = list;
        inflater=LayoutInflater.from(mContext);
    }

    public void setOnMyItemClickListener(OnItemClickListener onMyItemClickListener) {
        this.onMyItemClickListener = onMyItemClickListener;
    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_systeminfo, parent, false);
        return new MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, final int position) {
        GetMsgsBean bean = list.get(position);
        if ("0".equals(bean.getSts()))
        {
            holder.circle_tv.setBackgroundResource(R.drawable.shape_circle_white);
        }
        else
        {
            holder.circle_tv.setBackgroundResource(R.drawable.shape_circle_a1);
        }
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

    class MyViewHodler extends RecyclerView.ViewHolder{

        @BindView(R.id.circle_tv)
        TextView circle_tv;
        @BindView(R.id.title_tv)
        TextView title_tv;
        @BindView(R.id.content_tv)
        TextView content_tv;
        @BindView(R.id.time_tv)
        TextView time_tv;
        public MyViewHodler(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
