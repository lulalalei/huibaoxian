package com.bb.hbx.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.RecommendBean;
import com.bb.hbx.provide.RecommendProvide;
import com.bb.hbx.widget.DottedLineItemDecoration;
import com.bb.hbx.widget.multitype.MultiTypeAdapter;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by fancl
 * 爆款推荐的页面
 */

public class RecommendFragment extends BaseFragment {

    private final String TAG = RecommendFragment.class.getSimpleName();

    @BindView(R.id.rl_view)
    RecyclerView rl_view;

    private MultiTypeAdapter adapter;


    private List<Item> items;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rl_view.setLayoutManager(manager);
        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();
        adapter.register(RecommendBean.class, new RecommendProvide(getActivity()));
        rl_view.setAdapter(adapter);
        rl_view.addItemDecoration(new DottedLineItemDecoration());
    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            items.add(new RecommendBean());
        }
        adapter.setItems(items);
    }
}
