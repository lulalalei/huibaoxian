package com.bb.hbx.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.activitiy.MyAssertActivity;
import com.bb.hbx.activitiy.PerInsuOrderActivity;
import com.bb.hbx.activitiy.ScoreActivity;
import com.bb.hbx.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/20.
 */

public class MineFragment extends BaseFragment implements View.OnClickListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.pInsurance_layout)
    RelativeLayout pInsurance_layout;
    @BindView(R.id.myAsset_layout)
    RelativeLayout myAsset_layout;
    @BindView(R.id.score_layout)
    RelativeLayout score_layout;
    @BindView(R.id.redPacket_layout)
    RelativeLayout redPacket_layout;
    @BindView(R.id.pCount_tv)
    TextView pCount_tv;

    Context mContext;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_host;
    }

    @Override
    public void initView() {
        toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        pInsurance_layout.setOnClickListener(this);
        myAsset_layout.setOnClickListener(this);
        score_layout.setOnClickListener(this);
    }

    @Override
    protected void initdate(Bundle savedInstanceState) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        //menu.clear();
        inflater.inflate(R.menu.menu_host,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.notification_menu:
                Toast.makeText(mContext,"通知",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting_menu:
                Toast.makeText(mContext,"设置",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.pInsurance_layout:
                intent.setClass(mContext,PerInsuOrderActivity.class);
                break;
            case R.id.myAsset_layout:
                intent.setClass(mContext,MyAssertActivity.class);
                break;
            case R.id.score_layout:
                intent.setClass(mContext, ScoreActivity.class);
                break;
            case R.id.redPacket_layout:
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
