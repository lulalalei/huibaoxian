package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.GetTotalIncomeBean;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/27.
 */

public class MyAllIncomeAdapter extends RecyclerView.Adapter<MyAllIncomeAdapter.MyViewHolder>{

    List<GetTotalIncomeBean.TotalIncomeListBean> list;
    Context mContext;
    LayoutInflater inflater;
    OnItemClickListener onItemClickListener;
    int monthTotalAmountInt=0;

    public MyAllIncomeAdapter(List<GetTotalIncomeBean.TotalIncomeListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
        inflater=LayoutInflater.from(mContext);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.layout_allincome,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.date_tv.setText(list.get(position).getTradeTime());
        String monthTotalAmount = list.get(position).getMonthTotalAmount();
        //int monthTotalAmountInt=0;
        if (!TextUtils.isEmpty(monthTotalAmount))
        {
            monthTotalAmountInt = Integer.parseInt(monthTotalAmount);
        }
        holder.money_tv.setText(TextUtils.isEmpty(monthTotalAmount)?"0.00":(monthTotalAmountInt/100)+"."+(monthTotalAmountInt/10%10)+(monthTotalAmountInt%10));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onMyItemClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.date_tv)
        TextView date_tv;
        @BindView(R.id.money_tv)
        TextView money_tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
