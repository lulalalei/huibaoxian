package com.bb.hbx.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.PermissionChecker;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.fragment.SquareFragment;
import com.bb.hbx.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.fragment;

/**
 * Created by fancl on 2016/12/21.
 */

public class SquarePageAdapter<T extends BaseFragment> extends FragmentStatePagerAdapter {


    public static final String TAG = SquarePageAdapter.class.getSimpleName();

    private List<String> listtitle;

    private List<BaseFragment> list = new ArrayList<>();


    public SquarePageAdapter(FragmentManager fm, List<String> listtitle) {
        super(fm);
        this.listtitle = listtitle;
    }


    public void addFragment(T fragment) {
        list.add(fragment);
    }


    public void removeFragment(T fragment) {
        list.remove(fragment);
    }

    public void clear() {
        for (BaseFragment fragment : list) {
            if (fragment != null && fragment.isAdded()) {
                fragment.onDestroy();
            }
        }
        list.clear();
    }


    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        Fragment squareFragment = list.get(position);
        bundle.putInt(Constants.TYPE, position);
        squareFragment.setArguments(bundle);
        return squareFragment;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d(TAG, "instantiateItem position = " + position);
        return super.instantiateItem(container, position);
    }

    @Override
    public int getCount() {
        return Constants.SQUARE_PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listtitle.get(position);
    }
}
