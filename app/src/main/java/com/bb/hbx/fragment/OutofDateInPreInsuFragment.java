package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;

/**
 * Created by Administrator on 2017/2/9.
 */

public class OutofDateInPreInsuFragment extends BaseFragment{

    Context mContext;
    private static OutofDateInPreInsuFragment fragment;
    public static OutofDateInPreInsuFragment getInstance()
    {
        if (fragment==null)
        {
            fragment=new OutofDateInPreInsuFragment();
        }
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_outofdate_inpres_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void initdate(Bundle savedInstanceState) {

    }
}
