package com.bb.hbx.provide;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bb.hbx.R;
import com.bb.hbx.bean.CarModels;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bb.hbx.R.drawable.holder;

/**
 * Created by Administrator on 2016/12/21.
 */

public class SelectCarProvide extends ItemViewProvider<CarModels, SelectCarProvide.ViewHolder> {


    private Context context;

    private int layoutPosition = -1;

    private int currentPos = 0;

    public SelectCarProvide(Context context) {
        this.context = context;
    }

    public interface OnitemClick {
        void onItemClick(CarModels data, int position);
    }

    private OnitemClick mOnItemClickListener;

    public void setmOnItemClickListener(OnitemClick mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.activit_select_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull CarModels squareBean) {
        holder.setData(squareBean);

    }

    @Override
    protected void getCurrentPositon(int position) {
        super.getCurrentPositon(position);
        currentPos = position;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {


//        @BindView(R.id.tv_price)
//        TextView tv_price;
//

//
//
//        @BindView(R.id.tv_pro)
//        TextView tv_pro;
//
//
//
//        @BindView(R.id.tv_sales)
//        TextView tv_sales;

        @BindView(R.id.iv_select)
        ImageView iv_select;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(@NonNull final CarModels squareBean) {
            if (currentPos == layoutPosition) {
                iv_select.setVisibility(View.VISIBLE);
            } else {
                iv_select.setVisibility(View.GONE);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //获取当前点击的位置
                    layoutPosition = ViewHolder.this.getLayoutPosition();
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(squareBean, currentPos);
                    }
                }
            });
        }

    }

}
