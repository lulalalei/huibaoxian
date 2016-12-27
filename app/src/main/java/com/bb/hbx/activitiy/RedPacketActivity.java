package com.bb.hbx.activitiy;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.bb.hbx.R;
import com.bb.hbx.fragment.RedPacketContentFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class RedPacketActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tablayout)
    TabLayout tablayout;

    ArrayList<RedPacketContentFragment> fragmentList=new ArrayList<>();

    String []title=new String[]{"未使用(3)","使用记录(3)","已过期(5)"};
    //MyRedPacketAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_packet);
    }
}
