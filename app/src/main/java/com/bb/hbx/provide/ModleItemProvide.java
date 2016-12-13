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
import com.bb.hbx.bean.ModleItem;
import com.bb.hbx.widget.banner.BGABanner;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fancl.
 */

public class ModleItemProvide extends ItemViewProvider<ModleItem, ModleItemProvide.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.layout_modle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ModleItem modleItem) {
        holder.setData(modleItem);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.title)
        TextView title;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


        void setData(@NonNull final ModleItem modleItem) {
            img.setImageResource(modleItem.getResId());
            title.setText(modleItem.getTitle());
        }
    }


}
