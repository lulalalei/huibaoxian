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
import com.bb.hbx.bean.HotSearchBean;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fancl on 2016/12/28.
 */

public class HotSearchProvide extends ItemViewProvider<HotSearchBean, HotSearchProvide.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.square_act_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull HotSearchBean hotSearchBean) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.img)
        ImageView img;

        @BindView(R.id.tv_title)
        TextView tv_title;

        @BindView(R.id.tv_detail)
        TextView tv_detail;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(@NonNull final HotSearchBean bean) {

        }

    }
}
