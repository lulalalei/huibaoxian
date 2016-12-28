package com.bb.hbx.activitiy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyRedPacketAdapter;
import com.bb.hbx.cans.Can;
import com.bb.hbx.fragment.RedPacketContentFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RedPacketActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tablayout)
    TabLayout tablayout;

    ArrayList<RedPacketContentFragment> fragmentList=new ArrayList<>();

    String []title=new String[]{"未使用(3)","使用记录(3)","已过期(5)"};
    MyRedPacketAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_packet);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        Can.redPFragmentList=Can.getFragmentListInRedP();
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.setTabTextColors(Color.BLACK,Color.GRAY);
        for (int i = 0; i < title.length; i++) {
            tablayout.addTab(tablayout.newTab().setText(title[i]));
            RedPacketContentFragment fragment = new RedPacketContentFragment();
            Bundle bundle=new Bundle();
            bundle.putInt("position",i);
            fragment.setArguments(bundle);
            fragmentList.add(fragment);
        }
        adapter = new MyRedPacketAdapter(getSupportFragmentManager(), fragmentList, title);
        //加这句代码比不加这句更减小内存消耗,,,,,,fragment会同时加载,且在结合hide,show之后,尽管页卡来回切换,但初始化只会执行一次
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);
    }

    public void backMethod(View view) {
        finish();
    }

    public void menuMethod(View view) {
        Toast.makeText(this,"菜单",Toast.LENGTH_SHORT).show();
    }
}
