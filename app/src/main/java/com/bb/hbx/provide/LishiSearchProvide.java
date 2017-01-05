package com.bb.hbx.provide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.HotSearchBean;
import com.bb.hbx.bean.LishiSearchBean;
import com.bb.hbx.widget.multitype.ItemViewProvider;
import com.bb.hbx.widget.multitype.MultiTypeAdapter;


import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by fancl on 2016/12/28.
 * 历史搜索的item
 */

public class LishiSearchProvide extends ItemViewProvider<LishiSearchBean, LishiSearchProvide.ViewHolder> {


    public interface LishiSearchListener {

        void selectItem(LishiSearchBean bean);

        void deleteItem(LishiSearchBean bean);
    }


    private MultiTypeAdapter adapter;

    public LishiSearchProvide(MultiTypeAdapter adapter) {
        this.adapter = adapter;
    }


    private LishiSearchListener listener;


    public LishiSearchListener getListener() {
        return listener;
    }

    public void setListener(LishiSearchListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.layout_search_lishi_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull LishiSearchBean hotSearchBean) {
        holder.setData(hotSearchBean);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.iv_delet)
        ImageView iv_delet;

        @BindView(R.id.tv_confim)
        TextView tv_confim;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }

        void setData(@NonNull final LishiSearchBean bean) {

            tv_confim.setText(bean.getName());

            iv_delet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    adapter.getItems().remove(getPosition());
                    adapter.notifyItemRemoved(getPosition());
                    adapter.notifyItemRangeChanged(getPosition(), adapter.getItemCount());
                    listener.deleteItem(bean);

                }
            });

            tv_confim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.selectItem(bean);
                }
            });
        }

    }
}
