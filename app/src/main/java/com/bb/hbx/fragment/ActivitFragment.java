package com.bb.hbx.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.base.m.ActivitModel;
import com.bb.hbx.base.p.ActivitPresenter;
import com.bb.hbx.base.v.ActivitContract;
import com.bb.hbx.bean.ActivitBean;


import com.bb.hbx.emus.DataLoadDirection;
import com.bb.hbx.provide.ActivitProvide;
import com.bb.hbx.widget.DottedLineItemDecoration;
import com.bb.hbx.widget.freshlayout.OnPullListener;
import com.bb.hbx.widget.freshlayout.RefreshLayout;
import com.bb.hbx.widget.multitype.MultiTypeAdapter;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by fancl
 * 优选活动.
 */

public class ActivitFragment extends BaseFragment<ActivitPresenter, ActivitModel> implements ActivitContract.View {


    private final String TAG = ActivitFragment.class.getSimpleName();

    @BindView(R.id.rl_view)
    RecyclerView rl_view;

    @BindView(R.id.refresh)
    RefreshLayout refresh;

    private MultiTypeAdapter adapter;





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
        refresh.setOnPullListener(new OnPullListener() {
            @Override
            public void onRefresh() {
                mPresenter.getAdsList(DataLoadDirection.Refresh);
            }

            @Override
            public void onLoadMore() {
                mPresenter.getAdsList(DataLoadDirection.LoadMore);
            }
        });
    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        adapter.setItems(mPresenter.getList());
        mPresenter.getAdsList(DataLoadDirection.Refresh);
    }

    @Override
    public void stopRefresh() {
        refresh.stopRefresh(true);
    }

    @Override
    public void stopLoadMore() {
        refresh.stopLoadMore(true);
    }

    @Override
    public void notfiy() {
        adapter.notifyDataSetChanged();
    }
}
