package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.adapter.ContactAdapter;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.ContactBean;
import com.bb.hbx.decoration.TitleItemDecoration;
import com.bb.hbx.widget.IndexBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/8.
 */

public class CustomersManagerFragment extends BaseFragment implements View.OnClickListener{

    private static final String TAG = "zxt";
    @BindView(R.id.rv)
    RecyclerView mRv;
    private ContactAdapter mAdapter;
    private LinearLayoutManager mManager;
    private List<ContactBean> mDatas;

    private TitleItemDecoration mDecoration;

    /**
     * 右侧边栏导航区域
     */
    @BindView(R.id.indexBar)
    IndexBar mIndexBar;

    /**
     * 显示指示器DialogText
     */
    @BindView(R.id.tvSideBarHint)
    TextView mTvSideBarHint;
    @BindView(R.id.fromContacts_tv)
    TextView fromContacts_tv;
    @BindView(R.id.fromManual_tv)
    TextView fromManual_tv;
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_custommanager_layout;
    }

    @Override
    public void initView() {
        fromContacts_tv.setOnClickListener(this);
        fromManual_tv.setOnClickListener(this);
    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        mRv.setLayoutManager(mManager = new LinearLayoutManager(mContext));
        //initDatas();
        initDatas(getResources().getStringArray(R.array.provinces));
        mRv.setAdapter(mAdapter = new ContactAdapter(mContext, mDatas));
        mRv.addItemDecoration(mDecoration = new TitleItemDecoration(mContext, mDatas));
        //如果add两个，那么按照先后顺序，依次渲染。
        //mRv.addItemDecoration(new TitleItemDecoration2(this,mDatas));
        //mRv.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL_LIST));

        //使用indexBar
        //mTvSideBarHint = (TextView) findViewById(R.id.tvSideBarHint);//HintTextView
        //mIndexBar = (IndexBar) findViewById(R.id.indexBar);//IndexBar
        mIndexBar.setmPressedShowTextView(mTvSideBarHint)//设置HintTextView
                .setNeedRealIndex(true)//设置需要真实的索引
                .setmLayoutManager(mManager)//设置RecyclerView的LayoutManager
                .setmSourceDatas(mDatas);//设置数据源
    }
    private void initDatas(String[] data) {
        mDatas = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            ContactBean contactBean = new ContactBean();
            contactBean.setCity(data[i]);//设置城市名称
            mDatas.add(contactBean);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.fromContacts_tv:
                //showTip("通讯录导入");
                Toast.makeText(mContext,"通讯录导入",Toast.LENGTH_SHORT).show();
                break;
            case R.id.fromManual_tv:
                //showTip("手动添加");
                Toast.makeText(mContext,"手动添加",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
