package com.bb.hbx.provide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bb.hbx.R;
import com.bb.hbx.bean.SearchTitleBean;
import com.bb.hbx.bean.SearchTitleBean2;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fancl
 * 历史搜索标题item
 */

public class SearchTitleProvide2 extends ItemViewProvider<SearchTitleBean2, SearchTitleProvide2.ViewHolder> {


    public interface DeleteAllSearchListener {

        void deleteAll();
    }


    private DeleteAllSearchListener listener;

    public DeleteAllSearchListener getListener() {
        return listener;
    }

    public void setListener(DeleteAllSearchListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.search_title_item_other, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull SearchTitleBean2 bean) {
        holder.setData(bean);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.lin_delete)
        LinearLayout delete;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        void setData(@NonNull final SearchTitleBean2 bean) {

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.deleteAll();
                }
            });
        }

    }

}
