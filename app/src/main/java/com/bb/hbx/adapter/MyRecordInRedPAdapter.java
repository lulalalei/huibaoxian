package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.GetUserCouponsListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/27.
 */

public class MyRecordInRedPAdapter extends RecyclerView.Adapter<MyRecordInRedPAdapter.MyViewHolder>{

    Context mContext;
    List<GetUserCouponsListBean.CouponListBean> list;
    LayoutInflater inflater;

    public MyRecordInRedPAdapter(Context mContext, List<GetUserCouponsListBean.CouponListBean> list) {
        this.mContext = mContext;
        this.list = list;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.record_redp_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //Glide.with(mContext).load(list.get(position)).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.pic_iv);
        holder.price_tv.setText("¥"+list.get(position).getCouponValue());
        holder.title_tv.setText(list.get(position).getCouponName());
        holder.time_tv.setText("有效期:"+list.get(position).getEffTime()+"-"+list.get(position).getExpTime());
        holder.condtion_tv.setText(list.get(position).getCouponDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.divider_iv)
        ImageView divider_iv;
        @BindView(R.id.deadLine_iv)
        ImageView deadLine_iv;
        @BindView(R.id.state_iv)
        ImageView state_iv;
        @BindView(R.id.price_tv)
        TextView price_tv;
        @BindView(R.id.title_tv)
        TextView title_tv;
        @BindView(R.id.time_tv)
        TextView time_tv;
        @BindView(R.id.condtion_tv)
        TextView condtion_tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
