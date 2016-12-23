package com.bb.hbx.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.utils.Constants;
import com.bb.hbx.widget.multitype.MultiTypeAdapter;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/22.
 */

public class Mall_ItemFragment extends BaseFragment {




    private final String TAG = Mall_ItemFragment.class.getSimpleName();

    @BindView(R.id.rl_view)
    RecyclerView rl_view;

    private MultiTypeAdapter adapter;

    private int pageType;


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
        return R.layout.fragment_mall_item;
    }

    @Override
    public void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rl_view.setLayoutManager(manager);
        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();

        rl_view.setAdapter(adapter);

    }

    @Override
    protected void initdate(Bundle savedInstanceState) {

    }
}
