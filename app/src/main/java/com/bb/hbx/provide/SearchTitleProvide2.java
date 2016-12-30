package com.bb.hbx.provide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bb.hbx.R;
import com.bb.hbx.bean.SearchTitleBean;
import com.bb.hbx.widget.multitype.ItemViewProvider;

/**
 * Created by fancl
 * 历史搜索标题item
 */

public class SearchTitleProvide2 extends ItemViewProvider<SearchTitleBean, SearchTitleProvide2.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.search_title_item_other, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull SearchTitleBean bean) {
        holder.setData(bean);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);

        }

        void setData(@NonNull final SearchTitleBean bean) {


        }

    }

}
