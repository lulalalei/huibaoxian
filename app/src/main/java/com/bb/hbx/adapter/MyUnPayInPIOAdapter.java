package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.GetPolicies;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/26.
 */

public class MyUnPayInPIOAdapter extends RecyclerView.Adapter<MyUnPayInPIOAdapter.MyViewHolder>{
//convertView=inflater.inflate(R.layout.unpay_pio_item,parent,false);
    List<GetPolicies.PolicyListBean> list;
    Context mContext;
    LayoutInflater inflater;
    OnItemClickListener onMyItemClickListener;
    int payAmountInt=0;
    int classType=1;//1表示车险,2表示个险
    String sts="";

    public MyUnPayInPIOAdapter(List<GetPolicies.PolicyListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
        inflater=LayoutInflater.from(mContext);
    }

    public void setOnMyItemClickListener(OnItemClickListener onMyItemClickListener) {
        this.onMyItemClickListener = onMyItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.unpay_pio_item,parent,false);
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
        @BindView(R.id.title_tv)
        TextView title_tv;
        @BindView(R.id.orderNumber_tv)
        TextView orderNumber_tv;
        @BindView(R.id.insured_tv)
        TextView insured_tv;
        @BindView(R.id.holder_tv)
        TextView holder_tv;
        @BindView(R.id.timeLimit_tv)
        TextView timeLimit_tv;
        @BindView(R.id.price_tv)
        TextView price_tv;
        @BindView(R.id.income_tv)
        TextView income_tv;
        @BindView(R.id.state_iv)
        ImageView state_iv;
        @BindView(R.id.logo_iv)
        ImageView logo_iv;
       public MyViewHolder(View itemView) {
           super(itemView);
           ButterKnife.bind(this,itemView);
       }
   }
}
