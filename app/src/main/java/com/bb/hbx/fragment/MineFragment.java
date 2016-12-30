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
import com.bb.hbx.activitiy.PersonInfoSettingActivity;
import com.bb.hbx.activitiy.RedPacketActivity;
import com.bb.hbx.activitiy.ScoreActivity;
import com.bb.hbx.activitiy.login.LoginActivity;
import com.bb.hbx.base.BaseFragment;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2016/12/20.
 */

public class MineFragment extends BaseFragment implements View.OnClickListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.userIcon_civ)
    CircleImageView userIcon_civ;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.pInsurance_layout)
    RelativeLayout pInsurance_layout;
    @BindView(R.id.myAsset_tv)
    TextView myAsset_tv;
    @BindView(R.id.score_layout)
    RelativeLayout score_layout;
    @BindView(R.id.redPacket_layout)
    RelativeLayout redPacket_layout;
    @BindView(R.id.hasLogin)
    RelativeLayout hasLogin;
    @BindView(R.id.userName)
    TextView userName;
    @BindView(R.id.identify_tv)
    TextView identify_tv;
    @BindView(R.id.notLogin_tv)
    TextView notLogin_tv;
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
        toolbar.inflateMenu(R.menu.menu_host);

        userIcon_civ.setOnClickListener(this);
        pInsurance_layout.setOnClickListener(this);
        myAsset_tv.setOnClickListener(this);
        score_layout.setOnClickListener(this);
        redPacket_layout.setOnClickListener(this);
        notLogin_tv.setOnClickListener(this);

        toolbar.setNavigationIcon(R.drawable.message);
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
            case android.R.id.home:
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
                startActivity(intent);
                break;
            case R.id.userIcon_civ:
                intent.setClass(mContext,PersonInfoSettingActivity.class);
                startActivity(intent);
                break;
            case R.id.myAsset_tv:
                intent.setClass(mContext,MyAssertActivity.class);
                startActivity(intent);
                break;
            case R.id.score_layout:
                intent.setClass(mContext, ScoreActivity.class);
                startActivity(intent);
                break;
            case R.id.redPacket_layout:
                intent.setClass(mContext, RedPacketActivity.class);
                startActivity(intent);
                break;
            case R.id.notLogin_tv:

                intent.setClass(mContext, LoginActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_from_bottom,R.anim.activity_stay);
                break;
            default:
                break;
        }
    }
}
