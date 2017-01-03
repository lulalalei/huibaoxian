package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.bean.MyCustomInfoInDetailBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/3.
 */

public class MyCustomInfoInDetailAdapter extends RecyclerView.Adapter<MyCustomInfoInDetailAdapter.MyViewHolder>{

    ArrayList<MyCustomInfoInDetailBean> list;
    Context mContext;
    LayoutInflater inflater;

    public MyCustomInfoInDetailAdapter(ArrayList<MyCustomInfoInDetailBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custominfo_indetail_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        String type = list.get(position).getType();
        holder.title_tv.setText(list.get(position).getTitle());
        holder.content_tv.setText(list.get(position).getContent());
        if (type.equals("3")||type.equals("4"))
        {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            ImageView view = new ImageView(mContext);
            view.setImageResource(R.drawable.xialaicon);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            lp.leftMargin=6;
            lp.gravity= Gravity.CENTER_VERTICAL;
            view.setLayoutParams(lp);
            holder.linear_layout.addView(view);
            holder.linear_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"当前位置:"+position,Toast.LENGTH_SHORT).show();
                    //Log.e("====onBindViewHolder","========="+position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.linear_layout)
        LinearLayout linear_layout;
        @BindView(R.id.title_tv)
        TextView title_tv;
        @BindView(R.id.content_tv)
        TextView content_tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
