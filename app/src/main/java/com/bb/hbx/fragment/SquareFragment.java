package com.bb.hbx.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.base.m.SquareModel;
import com.bb.hbx.base.p.SquarePresenter;
import com.bb.hbx.base.v.SquareContract;
import com.bb.hbx.bean.AcitBean;
import com.bb.hbx.bean.SquareBean;
import com.bb.hbx.provide.ActivProvide;
import com.bb.hbx.provide.SquareProvide;
import com.bb.hbx.utils.Constants;
import com.bb.hbx.widget.multitype.MultiTypeAdapter;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.bb.hbx.R.id.rl_view;

/**
 * Created by Administrator on 2016/12/21.
 */

public class SquareFragment extends BaseFragment<SquarePresenter, SquareModel> implements SquareContract.View {


    private final String TAG = SquareFragment.class.getSimpleName();

    @BindView(R.id.rl_view)
    RecyclerView rl_view;

    private MultiTypeAdapter adapter;

    private int pageType;


    public static SquareFragment newInstance() {
        SquareFragment squareFragment = new SquareFragment();
        return squareFragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
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
        return R.layout.fragment_square;
    }

    @Override
    public void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rl_view.setLayoutManager(manager);
        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();
    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        if (pageType == Constants.PAGE_BKTJ)
            adapter.register(SquareBean.class, new SquareProvide());
        else if (pageType == Constants.PAGE_YXHD)
            adapter.register(AcitBean.class, new ActivProvide());
        else if (pageType == Constants.PAGE_ZTLB)
            adapter.register(SquareBean.class, new SquareProvide());
        else
            adapter.register(SquareBean.class, new SquareProvide());


        rl_view.setAdapter(adapter);
        mPresenter.setDate(pageType);


    }


    @Override
    public void showMsg(String msg) {

    }

    @Override
    public <T> void setList(T t) {

        adapter.setItems((List<? extends Item>) t);
    }

    @Override
    public <T> void addList(T t) {
        adapter.setItems((List<? extends Item>) t);
    }

}
