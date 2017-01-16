package com.bb.hbx.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.MallAllBean;
import com.bb.hbx.bean.TypeModel;
import com.bb.hbx.provide.MallAllProvide;
import com.bb.hbx.utils.Constants;
import com.bb.hbx.widget.ConditionLayout;
import com.bb.hbx.widget.multitype.MultiTypeAdapter;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

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


    private int conditType;//筛选条件


    private ConditionLayout.STATE state = ConditionLayout.STATE.DEFAULT;

    @BindView(R.id.cl_condit)
    ConditionLayout cl_condit;


    private TypeModel model;

    public Mall_ItemFragment(TypeModel model) {
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
        return R.layout.fragment_mall_item;
    }

    @Override
    public void initView() {
        cl_condit.setSate(state);
        cl_condit.setListener(new ConditionLayout.ConditionListener() {
            @Override
            public void priceListener(ConditionLayout.STATE operat) {
                state = operat;
            }

            @Override
            public void saleListener(ConditionLayout.STATE operat) {
                state = operat;
            }

            @Override
            public void filterListener(ConditionLayout.STATE operat) {

            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rl_view.setLayoutManager(manager);
        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();
        adapter.register(MallAllBean.class, new MallAllProvide());
        rl_view.setAdapter(adapter);


    }

    @Override
    protected void initdate(Bundle savedInstanceState) {

        Log.i(TAG, "initdate,pageType" + pageType);


        List<Item> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            MallAllBean bean = new MallAllBean();
            list.add(bean);
        }

        adapter.setItems(list);


    }
}
