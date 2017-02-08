package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.MyPIOederBean;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/26.
 */

public class MyUnPayInPIOAdapter extends RecyclerView.Adapter<MyUnPayInPIOAdapter.MyViewHolder>{
//convertView=inflater.inflate(R.layout.unpay_pio_item,parent,false);
    ArrayList<MyPIOederBean> list;
    Context mContext;
    LayoutInflater inflater;
    OnItemClickListener onMyItemClickListener;

    public MyUnPayInPIOAdapter(ArrayList<MyPIOederBean> list, Context mContext) {
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

        @BindView(R.id.title_tv)
        TextView title_tv;
        @BindView(R.id.number_tv)
        TextView number_tv;
        @BindView(R.id.theInsured_tv)
        TextView theInsured_tv;
        @BindView(R.id.insuranceHolder_tv)
        TextView insuranceHolder_tv;
        @BindView(R.id.time_tv)
        TextView time_tv;
        @BindView(R.id.price_tv)
        TextView price_tv;
        @BindView(R.id.income_tv)
        TextView income_tv;
        @BindView(R.id.state_iv)
        ImageView state_iv;
       public MyViewHolder(View itemView) {
           super(itemView);
           ButterKnife.bind(this,itemView);
       }
   }
}
