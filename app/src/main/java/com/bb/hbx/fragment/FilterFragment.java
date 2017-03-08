package com.bb.hbx.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.base.m.Filter_itemModel;
import com.bb.hbx.base.p.Filter_itemPresenter;
import com.bb.hbx.base.v.Filter_ItemContract;
import com.bb.hbx.bean.Filter_tileItem;
import com.bb.hbx.bean.Insurer;
import com.bb.hbx.bean.TypeModel;
import com.bb.hbx.provide.Filter_titleItemProvide;
import com.bb.hbx.provide.InsuranceCompanyProvide;
import com.bb.hbx.utils.Constants;
import com.bb.hbx.widget.freshlayout.OnPullListener;
import com.bb.hbx.widget.freshlayout.RefreshLayout;
import com.bb.hbx.widget.multitype.MultiTypeAdapter;
import com.bb.hbx.widget.multitype.data.Item;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/22.
 */

public class FilterFragment extends BaseFragment<Filter_itemPresenter, Filter_itemModel> implements Filter_ItemContract.View {


    private final String TAG = RecommendFragment.class.getSimpleName();

    @BindView(R.id.rl_view)
    RecyclerView rl_view;
    @BindView(R.id.refresh)
    RefreshLayout refresh;
    private MultiTypeAdapter adapter;
    private int pageType;
    private TypeModel model;

    private Filter_titleItemProvide provide1;


    public FilterFragment() {

    }


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

        refresh.setNeedLoadMore(false);
        final GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 4);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Item item = mPresenter.getList().get(position);

                if (item instanceof Filter_tileItem) {
                    return 4;
                } else if (item instanceof Insurer) {
                    return 1;
                }
                return 4;
            }
        };
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        rl_view.setLayoutManager(layoutManager);
        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();
        provide1 = new Filter_titleItemProvide(mContext);
        adapter.register(Filter_tileItem.class, provide1);
        adapter.register(Insurer.class, new InsuranceCompanyProvide());
        rl_view.setAdapter(adapter);
        rl_view.addItemDecoration(new SpaceItemDecoration());
        refresh.setOnPullListener(new OnPullListener() {
            @Override
            public void onRefresh() {
                mPresenter.getInsurers(model, Constants.personInsurance);
            }

            @Override
            public void onLoadMore() {

            }
        });

        provide1.setListener(new Filter_titleItemProvide.FilterListener() {
            @Override
            public void onClick(int type) {
                if (type == Constants.MORE) {
                    mPresenter.openMore();
                } else {
                    mPresenter.closeMore();
                }
            }
        });

    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        adapter.setItems(mPresenter.getList());
        mPresenter.getInsurers(model, Constants.personInsurance);
    }

    @Override
    public void notfiy() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void stopRefresh() {
        refresh.stopRefresh(true);

    }


    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {


            int pos = parent.getChildAdapterPosition(view);

            if (mPresenter.getList().get(pos) instanceof Insurer) {
                outRect.top = 0;
                outRect.bottom = 0;

                outRect.right = 0;


                if (pos > 0 && (pos - 1) / 4 == 0) {
                    outRect.top = getResources().getDimensionPixelOffset(R.dimen.y26);
                }

                if (pos > 0 && (pos - 1) / 4 == 1) {
                    outRect.top = getResources().getDimensionPixelOffset(R.dimen.y26);
                    outRect.bottom = getResources().getDimensionPixelOffset(R.dimen.y36);
                }

                if (pos > 0 && (pos - 1) % 4 == 0) {
                    outRect.left = getResources().getDimensionPixelOffset(R.dimen.x36);

                } else {
                    outRect.left = getResources().getDimensionPixelOffset(R.dimen.x26);
                }

                if (pos > 0 && (pos - 1) % 4 == 3) {
                    outRect.right = getResources().getDimensionPixelOffset(R.dimen.x36);
                } else {

                }

                Log.i(TAG, "left:" + outRect.left);
                Log.i(TAG, "right:" + outRect.right);

            }


        }


    }

}
