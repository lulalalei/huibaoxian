package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.GetTradesBean;
import com.bb.hbx.utils.TimeUtils;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/23.
 */

public class MyAllInMyOrderAdapter extends RecyclerView.Adapter<MyAllInMyOrderAdapter.MyViewHolder>{

    Context mContext;
    List<GetTradesBean.TradeListBean> list;
    LayoutInflater inflater;
    int payAmountInt=0;

    public MyAllInMyOrderAdapter(Context mContext, List<GetTradesBean.TradeListBean> list) {
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
        String tradeDate = list.get(position).getTradeDate();
        long logTime = TimeUtils.getStringToDateNoSpace(tradeDate);
        String time = TimeUtils.getDateToString(logTime);
        holder.time_tv.setText(time);
        holder.itemO_tv.setText(list.get(position).getProductName());
        holder.orderNumber_tv.setText(list.get(position).getTradeId());
        holder.itemTw_tv.setText(list.get(position).getInsuredList().get(0).getInsuredName());//投保人
        holder.itemTh_tv.setText("字段空缺: 被保人");
        holder.itemF_tv.setText("字段空缺: 保险期限");
        String payAmount = list.get(position).getPayAmount();
        if (!TextUtils.isEmpty(payAmount))
        {
            payAmountInt = Integer.parseInt(payAmount);
        }
        holder.price_tv.setText(TextUtils.isEmpty(payAmount)?"0.00":(payAmountInt/100)+"."+(payAmountInt/10%10)+(payAmountInt%10));
        holder.income_tv.setText("字段空缺: 推广费");
        Glide.with(mContext).load(list.get(position).getInsurerLogo()).placeholder(R.drawable.shangcheng).into(holder.logo_iv);

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
