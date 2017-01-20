package com.bb.hbx.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.ActivitBean;


import com.bb.hbx.provide.ActivitProvide;
import com.bb.hbx.widget.DottedLineItemDecoration;
import com.bb.hbx.widget.multitype.MultiTypeAdapter;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by fancl
 * 优选活动.
 */

public class ActivitFragment extends BaseFragment {


    private final String TAG = ActivitFragment.class.getSimpleName();

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
        adapter.register(ActivitBean.class, new ActivitProvide(getActivity()));
        rl_view.setAdapter(adapter);
        rl_view.addItemDecoration(new DottedLineItemDecoration());
    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            items.add(new ActivitBean());
        }
        adapter.setItems(items);
    }
}
