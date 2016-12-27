package com.bb.hbx.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.MyPIOederBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/26.
 */

public class MyAllInPIOAdapter extends BaseAdapter{

    ArrayList<MyPIOederBean> list;
    Context mContext;
    LayoutInflater inflater;

    public MyAllInPIOAdapter(ArrayList<MyPIOederBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        Log.e("============","======MyAllInPIOAdapter=====");
        if (convertView==null)
        {
            convertView=inflater.inflate(R.layout.all_pio_item,parent,false);
            holder=new MyViewHolder();
            ButterKnife.bind(holder,convertView);
            convertView.setTag(holder);
        }
        else
        {
            holder= (MyViewHolder) convertView.getTag();
        }
        holder.title_tv.setText(list.get(position).getTitle());
        holder.number_tv.setText(list.get(position).getNumber());
        holder.theInsured.setText(list.get(position).getTheInsured());
        holder.insuranceHolder_tv.setText(list.get(position).getInsuranceHolder());
        holder.time_tv.setText(list.get(position).getTime());
        holder.state_tv.setText(list.get(position).getState());
        return convertView;
    }

    static class MyViewHolder{
        @BindView(R.id.title_tv)
        TextView title_tv;
        @BindView(R.id.number_tv)
        TextView number_tv;
        @BindView(R.id.theInsured)
        TextView theInsured;
        @BindView(R.id.insuranceHolder_tv)
        TextView insuranceHolder_tv;
        @BindView(R.id.time_tv)
        TextView time_tv;
        @BindView(R.id.state_tv)
        TextView state_tv;

    }
}
