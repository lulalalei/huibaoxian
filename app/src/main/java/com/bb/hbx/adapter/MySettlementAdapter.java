package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.GetAcctSettSumBean;
import com.bb.hbx.utils.TimeUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/26.
 */

public class MySettlementAdapter extends RecyclerView.Adapter<MySettlementAdapter.MyViewHolder>{

    List<GetAcctSettSumBean.SettSumListBean> list;
    Context mContext;
    LayoutInflater inflater;
    long currentLogTime=0;
    String flagMonth;//记录唯一当前月
    boolean isOnce=true;

    public MySettlementAdapter(List<GetAcctSettSumBean.SettSumListBean> list, Context mContext,long currentLogTime,String flagMonth) {
        this.list = list;
        this.mContext = mContext;
        this.currentLogTime=currentLogTime;
        this.flagMonth=flagMonth;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.layout_settlement,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String dateTime = list.get(position).getTradeTime();
        //String dateTime = "2015-12-28 12:12:12";
        long logTime = TimeUtils.getStringToDateHaveSecondAndSpace(dateTime);
        String[] split = dateTime.split("[- :]");//2017,02,24,12,00,00
        if (position==0)
        {
            holder.divider_tv.setVisibility(View.VISIBLE);
            if (split[1].equals(flagMonth))
            {
                holder.divider_tv.setText("本月");
            }
            else
            {
                holder.divider_tv.setText("上个月");
                isOnce=false;
            }
        }
        else
        {
            if (split[1].equals(flagMonth))
            {
                holder.divider_tv.setVisibility(View.GONE);
            }
            else
            {
                if (isOnce)
                {
                    holder.divider_tv.setVisibility(View.VISIBLE);
                    holder.divider_tv.setText("上个月");
                    isOnce=false;
                }
                else
                {
                    holder.divider_tv.setVisibility(View.GONE);
                }
            }
        }
        holder.date_tv.setText(TimeUtils.week(dateTime));
        holder.time_tv.setText(split[1]+"-"+split[2]);
        if (logTime-currentLogTime<=86400000&&logTime-currentLogTime>=0)
        {
            holder.date_tv.setText("今天");
            holder.time_tv.setText(split[3]+":"+split[4]);
        }
        else if (currentLogTime-logTime<=86400000&&currentLogTime-logTime>=0)
        {
            holder.date_tv.setText("昨天");
            holder.time_tv.setText(split[3]+":"+split[4]);
        }
        /*holder.date_tv.setText(list.get(position).getDate());
        holder.time_tv.setText(list.get(position).getTime());*/
        holder.title_tv.setText(list.get(position).getProductName());
        holder.number_tv.setText("保单号:"+list.get(position).getPolicyNo());
        String settSum = list.get(position).getSettSum();
        int settSumInt=0;
        if (!TextUtils.isEmpty(settSum))
        {
            settSumInt = Integer.parseInt(settSum);
        }
        holder.price_tv.setText("+"+(TextUtils.isEmpty(settSum)?"0.00":(settSumInt/100)+"."+(settSumInt/10%10)+(settSumInt%10)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.divider_tv)
        TextView divider_tv;
        @BindView(R.id.date_tv)
        TextView date_tv;
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
