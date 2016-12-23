package com.bb.hbx.adapter;

import android.support.v4.app.FragmentManager;

import com.bb.hbx.base.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2016/12/23.
 */

public class MallPageAdapter extends BasePageAdapter {




    public MallPageAdapter(FragmentManager fm, List<String> listtitle) {
        super(fm, listtitle);
    }

    @Override
    public BaseFragment getFragement(int position) {

        return null;
    }
}
