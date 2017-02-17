package com.bb.hbx.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bb.hbx.R;
import com.bb.hbx.activitiy.FilterActivity;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.base.m.Filter_itemModel;
import com.bb.hbx.base.m.Mall_itemModel;
import com.bb.hbx.base.p.Filter_itemPresenter;
import com.bb.hbx.base.p.Mall_ItemPresenter;
import com.bb.hbx.base.v.Filter_ItemContract;
import com.bb.hbx.base.v.Mall_ItemContract;
import com.bb.hbx.bean.Filter_tileItem;
import com.bb.hbx.bean.Product;
import com.bb.hbx.bean.ProductListBean;
import com.bb.hbx.bean.TypeModel;
import com.bb.hbx.emus.DataLoadDirection;
import com.bb.hbx.provide.Filter_titleItemProvide;
import com.bb.hbx.provide.MallAllProvide;
import com.bb.hbx.provide.RecommendProvide;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.utils.Constants;
import com.bb.hbx.widget.ConditionLayout;
import com.bb.hbx.widget.DottedLineItemDecoration;
import com.bb.hbx.widget.freshlayout.OnPullListener;
import com.bb.hbx.widget.freshlayout.RefreshLayout;
import com.bb.hbx.widget.multitype.MultiTypeAdapter;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/22.
 */

public class FilterFragment extends BaseFragment<Filter_itemPresenter,Filter_itemModel> implements Filter_ItemContract.View {


    private final String TAG = RecommendFragment.class.getSimpleName();

    @BindView(R.id.rl_view)
    RecyclerView rl_view;

    @BindView(R.id.refresh)
    RefreshLayout refresh;

    private MultiTypeAdapter adapter;

    private int pageType;




    private TypeModel model;


    public FilterFragment(TypeModel model) {
        this.model = model;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle bundle = getArguments();
            pageType = bundle.getInt(Constants.TYPE);
            Log.i(TAG, "pageType:" + pageType);
            setRetainInstance(true);

        }
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_filter;
    }

    @Override
    public void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rl_view.setLayoutManager(manager);
        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();
        adapter.register(Filter_tileItem.class, new Filter_titleItemProvide(mContext));
        adapter.register(ProductListBean.class, new RecommendProvide(mContext));
        rl_view.setAdapter(adapter);
        rl_view.addItemDecoration(new DottedLineItemDecoration());
        refresh.setOnPullListener(new OnPullListener() {
            @Override
            public void onRefresh() {
                //mPresenter.getSpecialProductList(DataLoadDirection.Refresh);
            }

            @Override
            public void onLoadMore() {
                //mPresenter.getSpecialProductList(DataLoadDirection.LoadMore);
            }
        });

    }

    @Override
    protected void initdate(Bundle savedInstanceState) {

    }
}
