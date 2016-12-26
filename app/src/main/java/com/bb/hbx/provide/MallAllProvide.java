package com.bb.hbx.provide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.AcitBean;
import com.bb.hbx.bean.MallAllBean;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/21.
 */

public class MallAllProvide extends ItemViewProvider<MallAllBean, MallAllProvide.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.fragment_mall_item_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull MallAllBean squareBean) {
        holder.setData(squareBean);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.img_pic)
        ImageView img_pic;

        @BindView(R.id.tv_pro)
        TextView tv_pro;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(@NonNull final MallAllBean squareBean) {
//            tv_title.setText(squareBean.getTitle());
//            tv_detail.setText(squareBean.getDetail());
//            tv_promotion.setText(squareBean.getPromotion());
//            tv_price.setText(squareBean.getPrice());

        }

    }

}
