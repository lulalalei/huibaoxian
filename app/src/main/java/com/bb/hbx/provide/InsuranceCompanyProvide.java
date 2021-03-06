package com.bb.hbx.provide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.Insurer;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fancl
 * 保险公司列表
 */

public class InsuranceCompanyProvide extends ItemViewProvider<Insurer, InsuranceCompanyProvide.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.filter_item2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Insurer Insurer) {
        holder.setData(Insurer);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tv_name)
        TextView tv_title;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(@NonNull final Insurer bean) {
            tv_title.setText(bean.getInsurerName());

        }

    }
}
