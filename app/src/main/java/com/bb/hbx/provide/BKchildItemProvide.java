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
import com.bb.hbx.bean.ProductListBean;
import com.bb.hbx.utils.Constants;
import com.bb.hbx.utils.GlideUtil;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by fancl.
 * 爆款推荐的列表
 */

public class BKchildItemProvide extends ItemViewProvider<ProductListBean, BKchildItemProvide.ViewHolder> {


    private Context context;

    public BKchildItemProvide(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.layout_bk_child, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ProductListBean bKchildItem) {

        holder.setData(bKchildItem);
    }


    class ViewHolder extends RecyclerView.ViewHolder {


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


        void setData(@NonNull final ProductListBean bKchildItem) {


            tv_name.setText(bKchildItem.getProductName());
            tv_detail.setText(bKchildItem.getProductIntro());
            tv_price_start.setText(context.getString(R.string.howPrice, bKchildItem.getMinPremium()));
            tv_added.setText(bKchildItem.getCommisionValue1());
            if (MyApplication.user.getUserType() == Constants.CLIENTUSER) {
                tv_added.setVisibility(View.INVISIBLE);
            } else if (MyApplication.user.getUserType() == Constants.BOSSUSER) {
                tv_added.setVisibility(View.VISIBLE);
            } else {
                tv_added.setVisibility(View.INVISIBLE);
            }

            GlideUtil.getInstance().loadImage(MyApplication.getAppContext(),
                    img, bKchildItem.getProductLogo(), true);
            if (!bKchildItem.isLine()) {
                v_xx.setVisibility(View.INVISIBLE);
            } else {
                v_xx.setVisibility(View.VISIBLE);

            }


        }
    }


}
