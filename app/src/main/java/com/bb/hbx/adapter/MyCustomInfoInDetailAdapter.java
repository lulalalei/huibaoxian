package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.DatePickerDialog;
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
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        String type = list.get(position).getType();
        holder.title_tv.setText(list.get(position).getTitle());
        holder.content_tv.setText(list.get(position).getContent());
        if (type.equals("4"))
        {
            addItemIcon(holder.linear_layout);
            holder.linear_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"当前位置:"+position,Toast.LENGTH_SHORT).show();
                    //Log.e("====onBindViewHolder","========="+position);
                    if (holder.extra_layout.getVisibility()==View.GONE)
                    {
                        holder.extra_layout.setVisibility(View.VISIBLE);

                    }
                    else
                    {
                        holder.extra_layout.setVisibility(View.GONE);
                    }
                }
            });
        }
        if (type.equals("2"))
        {
            addItemIcon(holder.linear_layout);
            holder.linear_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"当前位置:"+position,Toast.LENGTH_SHORT).show();
                    showDateDialog();
                    //Log.e("====onBindViewHolder","========="+position);
                   /* if (holder.extra_layout.getVisibility()==View.GONE)
                    {
                        holder.extra_layout.setVisibility(View.VISIBLE);

                    }
                    else
                    {
                        holder.extra_layout.setVisibility(View.GONE);
                    }*/
                }
            });
        }
        if (type.equals("2"))//模拟出生日期
        {

        }
        if (type.equals("4"))//模拟男女
        {
            for (int i = 0; i < 2; i++) {
                TextView sexView = new TextView(mContext);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(330, 70);
                params.rightMargin=8;
                params.gravity=Gravity.CENTER_VERTICAL;
                sexView.setLayoutParams(params);
                sexView.setText("男");
                sexView.setTextSize(14);
                sexView.setGravity(Gravity.CENTER);
                sexView.setBackgroundResource(R.drawable.itembg_detail_shape);
                holder.content_layout.addView(sexView);
            }
        }
    }

    public void addItemIcon(ViewGroup parent)
    {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView view = new ImageView(mContext);
        view.setImageResource(R.drawable.xialaicon);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        lp.leftMargin=6;
        lp.gravity= Gravity.CENTER_VERTICAL;
        view.setLayoutParams(lp);
        parent.addView(view);
    }
    public void showDateDialog()
    {
        DatePickerDialog dialog = new DatePickerDialog(mContext);
        dialog.setMaxYear(2018);
        dialog.setMinYear(2000);
        dialog.setDialogMode(DatePickerDialog.DIALOG_MODE_BOTTOM);
        dialog.show();
        dialog.setDatePickListener(new DatePickerDialog.OnDatePickListener() {
            @Override
            public void onClick(String year, String month, String day) {
                Toast.makeText(mContext,
                        year + "-" + month + "-" + day,
                        Toast.LENGTH_LONG).show();
            }
        });
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
        @BindView(R.id.extra_layout)
        HorizontalScrollView extra_layout;
        @BindView(R.id.content_layout)
        LinearLayout content_layout;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
