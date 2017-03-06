package com.bb.hbx.provide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.TradeDetailType;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fancl
 * 责任险种的表格
 */

public class OrderCarFormProvide extends ItemViewProvider<TradeDetailType.InsureListBean, OrderCarFormProvide.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.ordercarform_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull TradeDetailType.InsureListBean Insurer) {
        holder.setData(Insurer);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tv_key)
        TextView tv_key;

        @BindView(R.id.tv_value)
        TextView tv_value;
        @BindView(R.id.tv_premium)
        TextView tv_premium;
        @BindView(R.id.tv_other)
        TextView tv_other;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(@NonNull final TradeDetailType.InsureListBean bean) {

            tv_key.setText(bean.getInsureName());
            tv_value.setText(bean.getInsureAmount());
            if (bean.getExtraInsureList()!=null&&bean.getExtraInsureList().size()>0)
            {
                tv_premium.setText(bean.getExtraInsureList().get(0).getExtraInsureAmount());
                tv_other.setText(bean.getExtraInsureList().get(0).getExtraInsureName());//不计免赔??????
            }
        }

    }
}
