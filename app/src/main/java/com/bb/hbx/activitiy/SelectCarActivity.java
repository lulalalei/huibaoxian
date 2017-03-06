package com.bb.hbx.activitiy;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.CarModels;
import com.bb.hbx.bean.NomatchCarModels;
import com.bb.hbx.provide.NomatchCarProvide;
import com.bb.hbx.provide.SelectCarProvide;
import com.bb.hbx.widget.multitype.MultiTypeAdapter;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by fancl
 */

public class SelectCarActivity extends BaseActivity {


    @BindView(R.id.rl_view)
    RecyclerView rl_view;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_confim)
    TextView tv_confim;

    private List<Item> items;


    private MultiTypeAdapter adapter;

    private SelectCarProvide provide;


    @Override
    public int getLayoutId() {
        return R.layout.activit_select;
    }

    @Override
    public void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rl_view.setLayoutManager(manager);
        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();
        provide = new SelectCarProvide(this);
        provide.setmOnItemClickListener(new SelectCarProvide.OnitemClick() {
            @Override
            public void onItemClick(CarModels data, int position) {
                adapter.notifyDataSetChanged();
            }
        });
        adapter.register(CarModels.class, provide);
        adapter.register(NomatchCarModels.class, new NomatchCarProvide(this));
        rl_view.setAdapter(adapter);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initdata() {
        items = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            items.add(new CarModels());
        }
        items.add(new NomatchCarModels());
        adapter.setItems(items);

    }
}
