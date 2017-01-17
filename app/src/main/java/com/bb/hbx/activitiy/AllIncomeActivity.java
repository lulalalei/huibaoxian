package com.bb.hbx.activitiy;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyAllIncomeAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.MyAllIncomeBean;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;

public class AllIncomeActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_iv)
    ImageView back_iv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    GridLayoutManager manager;

    ArrayList<MyAllIncomeBean> totalList=new ArrayList<>();
    MyAllIncomeAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_all_income;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_iv.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);
        for (int i = 3; i < 9; i++) {
            String date="2016年"+i+"月";
            String money=100*i+"";
            MyAllIncomeBean bean = new MyAllIncomeBean(date, money);
            totalList.add(bean);
        }
        adapter=new MyAllIncomeAdapter(totalList,this);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(int position) {
                Toast.makeText(AllIncomeActivity.this,"点击事件:"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_iv:
                finish();
                break;
            default:
                break;
        }
    }
}
