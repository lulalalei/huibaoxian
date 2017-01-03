package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.AddressBean;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/30.
 */

public class MyAddressManagerAdapter extends RecyclerView.Adapter<MyAddressManagerAdapter.MyViewHolder>{

    ArrayList<AddressBean> list;
    Context mContext;
    HashMap<Integer,Boolean> map;
    LayoutInflater inflater;
    Boolean isSelected;
    int prePosition;

    public MyAddressManagerAdapter(ArrayList<AddressBean> list, Context mContext, HashMap<Integer, Boolean> map) {
        this.list = list;
        this.mContext = mContext;
        this.map = map;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_address, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name_tv.setText(list.get(position).getName());
        holder.phone_tv.setText(list.get(position).getPhone());
        holder.address_tv.setText(list.get(position).getAddress());
        holder.select_iv.setTag(position);
        isSelected=map.get(position);
        Log.e("===position=====","=========="+position);
        final MyViewHolder finalHolder=holder;
        finalHolder.select_iv.setSelected(isSelected);
        holder.select_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalHolder.select_iv.getTag()!=null&&(int)finalHolder.select_iv.getTag()==position)
                {
                    isSelected=map.get(position);
                    if (isSelected)
                    {
                        finalHolder.select_iv.setSelected(false);
                        map.put(position,false);
                        notifyDataSetChanged();
                    }
                    else
                    {
                        finalHolder.select_iv.setSelected(true);
                        map.put(prePosition,false);
                        map.put(position,true);
                        prePosition=position;
                        notifyDataSetChanged();
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.name_tv)
        TextView name_tv;
        @BindView(R.id.phone_tv)
        TextView phone_tv;
        @BindView(R.id.address_tv)
        TextView address_tv;
        @BindView(R.id.select_iv)
        ImageView select_iv;
        @BindView(R.id.address_layout)
        RelativeLayout address_layout;
        @BindView(R.id.delete_layout)
        RelativeLayout delete_layout;
        @BindView(R.id.edit_layout)
        RelativeLayout edit_layout;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
