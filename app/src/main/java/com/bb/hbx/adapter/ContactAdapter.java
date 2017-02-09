package com.bb.hbx.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.bean.ContactBean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/2.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder>{

    private Context mContext;
    private List<ContactBean> mDatas;
    private LayoutInflater mInflater;

    public ContactAdapter(Context mContext, List<ContactBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_city, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final ContactBean cityBean = mDatas.get(position);
        holder.tyCity.setText(cityBean.getCity());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "pos:"+position, Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(mContext, "长按pos:"+position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tyCity;
        public MyViewHolder(View itemView) {
            super(itemView);
            tyCity= (TextView) itemView.findViewById(R.id.tyCity);
        }
    }
}
