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
import com.bb.hbx.bean.RecommendBean;
import com.bb.hbx.bean.Special;
import com.bb.hbx.bean.TopicBean;
import com.bb.hbx.utils.GlideUtil;
import com.bb.hbx.widget.RoundImageView;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/21.
 */

public class TopicListProvide extends ItemViewProvider<Special, TopicListProvide.ViewHolder> {


    private Context context;

    public TopicListProvide(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.activit_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Special squareBean) {
        holder.setData(squareBean);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.iv_pic)
        RoundImageView iv_pic;
        @BindView(R.id.tv_name)
        TextView tv_name;

        @BindView(R.id.tv_detail)
        TextView tv_detail;



        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(@NonNull final Special squareBean) {
            tv_name.setText(squareBean.getSpecialName());
            tv_detail.setText(squareBean.getSpecialIntro());
            GlideUtil.getInstance().loadImage(context,iv_pic,squareBean.getSpecialLogo(),true);

        }

    }

}
