package com.bb.hbx.provide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.BKchildItem;
import com.bb.hbx.widget.multitype.ItemViewProvider;
import com.bb.hbx.widget.multitype.MultiTypeAdapter;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;




/**
 * Created by fancl.
 */

public class BKchildItemProvide extends ItemViewProvider<BKchildItem, BKchildItemProvide.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.layout_bk_child, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BKchildItem bKchildItem) {

        holder.setData(bKchildItem);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.img)
        ImageView img;

        @BindView(R.id.tv_name)
        TextView tv_name;


        @BindView(R.id.tv_detail)
        TextView tv_detail;

        @BindView(R.id.tv_price_start)
        TextView tv_price_start;


        @BindView(R.id.tv_added)
        TextView tv_added;


        @BindView(R.id.v_xx)
        View v_xx;




        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


        void setData(@NonNull final BKchildItem bKchildItem) {

            img.setImageResource(bKchildItem.getRedId());
            tv_name.setText(bKchildItem.getSafe_name());
            tv_detail.setText(bKchildItem.getSafe_detail());
            tv_price_start.setText(bKchildItem.getSafe_price());
            tv_added.setText(bKchildItem.getSafe_add());
            if (!bKchildItem.isLine()) {
                v_xx.setVisibility(View.GONE);
            } else {
                v_xx.setVisibility(View.VISIBLE);

            }
        }
    }


}
