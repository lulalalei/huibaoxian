package com.bb.hbx.activitiy;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyScoreAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.MyScoreBean;

import java.util.ArrayList;

import butterknife.BindView;

public class ScoreActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.menu_iv)
    ImageView menu_iv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    GridLayoutManager manager;
    ArrayList<MyScoreBean> totalList=new ArrayList<>();
    MyScoreAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_score;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        menu_iv.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);
        for (int i = 0; i < 2; i++) {
            String id="购买保险(商品编号:"+i+")";
            String time="2016-12-08 12:23:5"+i;
            String price=2+100*i+"";
            MyScoreBean bean = new MyScoreBean(id, time, price);
            totalList.add(bean);
        }
        adapter = new MyScoreAdapter(totalList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            case R.id.menu_iv:
                Toast.makeText(this,"菜单",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
