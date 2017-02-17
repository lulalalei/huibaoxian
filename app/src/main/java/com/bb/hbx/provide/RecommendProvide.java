package com.bb.hbx.provide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.bean.Product;
import com.bb.hbx.bean.ProductListBean;
import com.bb.hbx.bean.RecommendBean;
import com.bb.hbx.utils.GlideUtil;
import com.bb.hbx.widget.RoundImageView;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import butterknife.BindView;
import butterknife.ButterKnife;



/**
 * Created by Administrator on 2016/12/21.
 */

public class RecommendProvide extends ItemViewProvider<ProductListBean, RecommendProvide.ViewHolder> {


    private Context context;

    public RecommendProvide(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.recommend_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ProductListBean squareBean) {
        holder.setData(squareBean);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.iv_pic)
        RoundImageView iv_pic;

        @BindView(R.id.tv_price)
        TextView tv_price;

        @BindView(R.id.tv_name)
        TextView tv_name;


        @BindView(R.id.tv_detail)
        TextView tv_detail;


        @BindView(R.id.tv_pro)
        TextView tv_pro;


        @BindView(R.id.tv_sales)
        TextView tv_sales;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(@NonNull final ProductListBean squareBean) {
            GlideUtil.getInstance().loadImage(context, iv_pic, squareBean.getProductLogo(), true);
            tv_name.setText(squareBean.getProductName());
            tv_detail.setText(squareBean.getProductIntro());
            tv_price.setText(squareBean.getProductPrice());
            tv_pro.setText(squareBean.getCommisionValue1() + "%推广费");
            tv_sales.setText(squareBean.getTotalAmount());
            if (MyApplication.user.getIsBClient()) {
                tv_pro.setVisibility(View.VISIBLE);
            } else {
                tv_pro.setVisibility(View.GONE);
            }

        }

    }

}
