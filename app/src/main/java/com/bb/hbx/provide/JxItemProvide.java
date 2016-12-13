package com.bb.hbx.provide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.BKchildItem;
import com.bb.hbx.bean.JxItem;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fancl.
 */

public class JxItemProvide extends ItemViewProvider<JxItem, JxItemProvide.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.layout_jx, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull JxItem jxItem) {
        holder.setData(jxItem);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {






        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


        void setData(@NonNull final JxItem jxItem) {

        }
    }


}
