package com.bb.hbx.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.utils.Constants;

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
        Bundle bundle = new Bundle();
        BaseFragment squareFragment = (BaseFragment) list.get(position);
        bundle.putInt(Constants.TYPE, position);
        squareFragment.setArguments(bundle);
        return squareFragment;
    }
}
