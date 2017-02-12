package com.bb.hbx.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.base.m.TopListModel;
import com.bb.hbx.base.p.ToplistPresenter;
import com.bb.hbx.base.v.TopicListContract;
import com.bb.hbx.bean.RecommendBean;
import com.bb.hbx.bean.TopicBean;
import com.bb.hbx.emus.DataLoadDirection;
import com.bb.hbx.provide.TopicListProvide;
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
 * 专题列表
 */

public class TopiclistFragment extends BaseFragment<ToplistPresenter, TopListModel>
        implements TopicListContract.View {


    private final String TAG = TopiclistFragment.class.getSimpleName();

    @BindView(R.id.rl_view)
    RecyclerView rl_view;

    @BindView(R.id.refresh)
    RefreshLayout refresh;


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
        adapter.register(TopicBean.class, new TopicListProvide(getActivity()));
        rl_view.setAdapter(adapter);
        rl_view.addItemDecoration(new DottedLineItemDecoration());

        refresh.setOnPullListener(new OnPullListener() {
            @Override
            public void onRefresh() {
                mPresenter.getSpecials(DataLoadDirection.Refresh);
            }

            @Override
            public void onLoadMore() {
                mPresenter.getSpecials(DataLoadDirection.LoadMore);
            }
        });
    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        adapter.setItems(mPresenter.getList());
        mPresenter.getSpecials(DataLoadDirection.Refresh);
    }

    @Override
    public void stopRefresh() {
        refresh.stopRefresh(true);
    }

    @Override
    public void stopLoadMore() {
        refresh.stopLoadMore(true);
    }
}
