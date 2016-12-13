package com.bb.hbx.provide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.BannerBean;
import com.bb.hbx.widget.banner.BGABanner;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fancl.
 */

public class BannerProvide extends ItemViewProvider<BannerBean,BannerProvide.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.layout_header, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BannerBean bannerBean) {
        holder.setData(bannerBean);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.banner)
        BGABanner bgaBanner;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);


        }


        void setData(@NonNull final BannerBean bannerBean) {
            bgaBanner.setAdapter(new BGABanner.Adapter() {
                @Override
                public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
                    ((ImageView)view).setImageResource((Integer) model);
                }
            });

            bgaBanner.setOnItemClickListener(new BGABanner.OnItemClickListener() {
                @Override
                public void onBannerItemClick(BGABanner banner, View view, Object model, int position) {
                   if(bgaBanner.getContext() instanceof BaseActivity){
                       ((BaseActivity) bgaBanner.getContext()).showTip("点击了第"+position+"张");
                   }
                }
            });
            bgaBanner.setData(bannerBean.getList(),null);
        }
    }


}
