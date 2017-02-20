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
import com.bb.hbx.bean.Filter_tileItem;
import com.bb.hbx.bean.ProductListBean;
import com.bb.hbx.utils.Constants;
import com.bb.hbx.utils.GlideUtil;
import com.bb.hbx.widget.RoundImageView;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.onClick;
import static com.bb.hbx.R.drawable.on;
import static com.bb.hbx.R.id.tv_detail;
import static com.bb.hbx.R.id.tv_pro;


/**
 * Created by Administrator on 2016/12/21.
 */

public class Filter_titleItemProvide extends ItemViewProvider<Filter_tileItem, Filter_titleItemProvide.ViewHolder> {


    private Context context;

    public Filter_titleItemProvide(Context context) {
        this.context = context;
    }

    public interface FilterListener {

        void onClick(int type);
    }

    private FilterListener listener;

    private boolean isLoadMore = false;


    public void setListener(FilterListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_filter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Filter_tileItem squareBean) {
        holder.setData(squareBean);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tv_name)
        TextView tv_name;


        @BindView(R.id.tv_comm)
        TextView tv_comm;


        @BindView(R.id.iv_last)
        ImageView iv_last;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(@NonNull final Filter_tileItem squareBean) {

            tv_name.setText(squareBean.getName());
            if (squareBean.isVisiber()) {
                tv_comm.setVisibility(View.VISIBLE);
                iv_last.setVisibility(View.VISIBLE);
            } else {
                tv_comm.setVisibility(View.GONE);
                iv_last.setVisibility(View.GONE);
            }

            iv_last.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener != null) {
                        isLoadMore = !isLoadMore;
                        listener.onClick(isLoadMore ? Constants.MORE : Constants.NOMORE);
                        iv_last.setImageResource(isLoadMore ? R.drawable.xialaicon_xiangshang : R.drawable.xialaicon);
                    }
                }
            });

            tv_comm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener != null) {
                        isLoadMore = !isLoadMore;
                        listener.onClick(isLoadMore ? Constants.MORE : Constants.NOMORE);
                        iv_last.setImageResource(isLoadMore ? R.drawable.xialaicon_xiangshang : R.drawable.xialaicon);
                    }
                }
            });


        }

    }

}
