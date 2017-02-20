package com.bb.hbx.adapter;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.TypeModel;
import com.bb.hbx.fragment.FilterFragment;
import com.bb.hbx.fragment.Mall_ItemFragment;
import com.bb.hbx.utils.Constants;

import java.util.List;

/**
 * Created by Administrator on 2016/12/23.
 */

public class FilterPageAdapter extends BasePageAdapter<FilterFragment,TypeModel> {


    public FilterPageAdapter(FragmentManager fm, List<TypeModel> listtitle) {
        super(fm, listtitle);
    }

    @Override
    public void addFragment(FilterFragment fragment) {
        if (list.size() < listtitle.size()) {
            list.add(fragment);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ((TypeModel)listtitle.get(position)).getTypeName();
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
