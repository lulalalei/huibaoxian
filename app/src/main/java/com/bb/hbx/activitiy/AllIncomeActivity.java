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
import com.bb.hbx.adapter.MyAllIncomeAdapter;
import com.bb.hbx.bean.MyAllIncomeBean;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllIncomeActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    GridLayoutManager manager;

    ArrayList<MyAllIncomeBean> totalList=new ArrayList<>();
    MyAllIncomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_income);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        //scrollView.scrollTo(30,30);
        manager = new GridLayoutManager(this, 1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
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
    public void backMethod(View view) {
        finish();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        scrollView.scrollTo(0,0);
    }
}
