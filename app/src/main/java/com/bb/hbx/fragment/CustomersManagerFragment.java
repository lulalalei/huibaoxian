package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;

/**
 * Created by Administrator on 2017/2/8.
 */

public class CustomersManagerFragment extends BaseFragment{

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

    }

    @Override
    protected void initdate(Bundle savedInstanceState) {

    }
}
