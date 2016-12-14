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

import com.bb.hbx.bean.JxItem;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.BindViews;
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

//
        @BindView(R.id.img_kind_res)
        ImageView img_kind_res;

        @BindView(R.id.lin_add)
        LinearLayout lin_add;







        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


        void setData(@NonNull final JxItem jxItem) {
            img_kind_res.setImageResource(jxItem.getRes_Id());

            if (jxItem.getItems() != null && jxItem.getItems().size() > 0 && lin_add!=null) {
                lin_add.removeAllViews();
                for (int i = 0; i < jxItem.getItems().size(); i++) {
                    View view = View.inflate(itemView.getContext(), R.layout.layout_jx_item, null);

                    TextView tv_name= (TextView) view.findViewById(R.id.tv_name);
                    TextView tv_detail= (TextView) view.findViewById(R.id.tv_detail);
                    TextView tv_price= (TextView) view.findViewById(R.id.tv_price);
                    ImageView img_right= (ImageView) view.findViewById(R.id.img_right);

                    tv_name.setText(jxItem.getItems().get(i).getKind_name());
                    tv_detail.setText(jxItem.getItems().get(i).getKind_detail());
                    tv_price.setText(jxItem.getItems().get(i).getKind_price());
                    img_right.setImageResource(jxItem.getItems().get(i).getKind_resId());
                    lin_add.addView(view);
                }




            }
        }
    }




}
