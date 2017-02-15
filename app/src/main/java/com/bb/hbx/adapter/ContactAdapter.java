package com.bb.hbx.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.bean.BaseIndexTagBean;
import com.bb.hbx.bean.ContactBean;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/2.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder>{

    private Context mContext;
    private List<ContactBean> mDatas;
    private LayoutInflater mInflater;
    OnItemClickListener onMyItemClickListener;

    private List<? extends BaseIndexTagBean> mDatasTag;

    public ContactAdapter(Context mContext, List<ContactBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mInflater=LayoutInflater.from(mContext);
        mDatasTag=mDatas;
    }

    public void setOnMyItemClickListener(OnItemClickListener onMyItemClickListener) {
        this.onMyItemClickListener = onMyItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_city, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if (position>-1)
        {
            if (position==0)//等于0肯定要有title
            {
                //drawTitleArea(c,left,right,child,params,position);
                holder.letter_tv.setText(mDatasTag.get(position).getTag());
            }
            else
            {
                if (null!=mDatas.get(position).getTag()&&!mDatas.get(position).getTag().equals(mDatas.get(position-1).getTag()))
                {
                    //不为空,且跟前一个tag不一样,说明是新的分类,也要title
                    //drawTitleArea(c,left,right,child,params,position);
                    holder.letter_tv.setText(mDatasTag.get(position).getTag());
                }
                else
                {
                    holder.letter_tv.setText("");
                }
            }
        }

        final ContactBean cityBean = mDatas.get(position);
        holder.tyCity.setText(cityBean.getCity());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext, "pos:"+position, Toast.LENGTH_SHORT).show();
                onMyItemClickListener.onMyItemClickListener(position);
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

        @BindView(R.id.letter_tv)
        TextView letter_tv;
        @BindView(R.id.tyCity)
        TextView tyCity;
        public MyViewHolder(View itemView) {
            super(itemView);
            //tyCity= (TextView) itemView.findViewById(R.id.tyCity);
            ButterKnife.bind(this,itemView);
        }
    }
}
