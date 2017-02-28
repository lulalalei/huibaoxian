package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.GetTotalIncomeDetail;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/23.
 */

public class MySpecialMonthAdapter extends RecyclerView.Adapter<MySpecialMonthAdapter.MyViewHolder>{

    List<GetTotalIncomeDetail.TotalIncomeListBean> list;
    Context mContext;
    LayoutInflater inflater;

    public MySpecialMonthAdapter(List<GetTotalIncomeDetail.TotalIncomeListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_specialmonth, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String tradeTime = list.get(position).getTradeTime();
        String[] split = tradeTime.split("-");
        holder.time_tv.setText(split[1]+"/"+split[2]);
        String dayTotalAmount = list.get(position).getDayTotalAmount();
        int dayTotalAmountInt=0;
        if (!TextUtils.isEmpty(dayTotalAmount))
        {
            dayTotalAmountInt = Integer.parseInt(dayTotalAmount);
        }
        holder.price_tv.setText("+ "+(TextUtils.isEmpty(dayTotalAmount)?"0.00":(dayTotalAmountInt/100)+"."+(dayTotalAmountInt/10%10)+(dayTotalAmountInt%10)));
        holder.title_tv.setText(list.get(position).getProductName());
        holder.number_tv.setText(list.get(position).getTradeNo());
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
        @BindView(R.id.number_tv)
        TextView number_tv;
        @BindView(R.id.price_tv)
        TextView price_tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
