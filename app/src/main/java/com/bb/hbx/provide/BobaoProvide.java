package com.bb.hbx.provide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bb.hbx.R;
import com.bb.hbx.adapter.ListAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.BannerBean;
import com.bb.hbx.bean.BobaoItem;
import com.bb.hbx.widget.TitleListview;
import com.bb.hbx.widget.banner.BGABanner;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fancl.
 */

public class BobaoProvide extends ItemViewProvider<BobaoItem,BobaoProvide.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.layout_bobao, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BobaoItem bobaoItem) {
        holder.setData(bobaoItem);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tl)
        TitleListview tl;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);


        }


        void setData(@NonNull final BobaoItem bannerBean) {
            tl.setAdapter(new ListAdapter(tl.getContext(),bannerBean.getList()));
        }
    }


}
