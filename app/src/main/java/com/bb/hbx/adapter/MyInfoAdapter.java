package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.GetMsgsBean;
import com.bb.hbx.interfaces.OnItemChangeStateClickListener;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/17.
 */

public class MyInfoAdapter extends RecyclerView.Adapter<MyInfoAdapter.MyViewHolder>{

    Context mContext;
    ArrayList<GetMsgsBean> list;
    LayoutInflater inflater;
    OnItemChangeStateClickListener onMyItemClickListener;
    OnItemClickListener onDeleteItemClickListener;

    public MyInfoAdapter(Context mContext, ArrayList<GetMsgsBean> list) {
        this.mContext = mContext;
        this.list = list;
        inflater=LayoutInflater.from(mContext);
    }

    public void setOnMyItemClickListener(OnItemChangeStateClickListener onMyItemClickListener) {
        this.onMyItemClickListener = onMyItemClickListener;
    }

    public void setOnDeleteItemClickListener(OnItemClickListener onDeleteItemClickListener) {
        this.onDeleteItemClickListener = onDeleteItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_myinfo, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        GetMsgsBean bean = list.get(position);
        if ("0".equals(bean.getSts()))
        {
            holder.circle_tv.setBackgroundResource(R.drawable.shape_circle_white);
        }
        else
        {
            holder.circle_tv.setBackgroundResource(R.drawable.shape_circle_a1);
        }
        final MyViewHolder finalHolder=holder;
        finalHolder.circle_tv.setTag(position);
        finalHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMyItemClickListener.onMyItemChangeStateClickListener(position,finalHolder.circle_tv);
            }
        });
        //长按删除的监听
        finalHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onDeleteItemClickListener.onMyItemClickListener(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.circle_tv)
        TextView circle_tv;
        @BindView(R.id.title_tv)
        TextView title_tv;
        @BindView(R.id.content_tv)
        TextView content_tv;
        @BindView(R.id.time_tv)
        TextView time_tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
