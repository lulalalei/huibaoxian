package com.bb.hbx.activitiy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyScoreAdapter;
import com.bb.hbx.bean.MyScoreBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScoreActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    GridLayoutManager manager;
    ArrayList<MyScoreBean> totalList=new ArrayList<>();
    MyScoreAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
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
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        scrollView.scrollTo(0,0);
    }

    public void backMethod(View view) {
        finish();
    }

    public void menuMethod(View view) {
        Toast.makeText(this,"菜单",Toast.LENGTH_SHORT).show();
    }
}
