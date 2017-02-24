package com.bb.hbx.activitiy;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MySpecialMonthAdapter;
import com.bb.hbx.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

public class SpecialMonthActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    GridLayoutManager manager;

    ArrayList<String> list=new ArrayList<>();
    MySpecialMonthAdapter adapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_special_month;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        manager = new GridLayoutManager(this, 1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(manager);
        adapter = new MySpecialMonthAdapter(list, this);
        recyclerView.setAdapter(adapter);
        for (int i = 0; i < 4; i++) {
            list.add("i");
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            default:
                break;
        }
    }
}
