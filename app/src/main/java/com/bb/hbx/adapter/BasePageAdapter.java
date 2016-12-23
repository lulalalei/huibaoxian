package com.bb.hbx.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.bb.hbx.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fancl on 2016/12/21.
 */

public abstract class BasePageAdapter<T extends BaseFragment> extends FragmentStatePagerAdapter {


    public static final String TAG = BasePageAdapter.class.getSimpleName();

    private List<String> listtitle;

    private List<BaseFragment> list = new ArrayList<>();


    public BasePageAdapter(FragmentManager fm, List<String> listtitle) {
        super(fm);
        this.listtitle = listtitle;
    }


    public void addFragment(T fragment) {
        if (list.size() < listtitle.size()) {
            list.add(fragment);
        }
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
//        Bundle bundle = new Bundle();
//        Fragment itemFragment = list.get(position);
//        bundle.putInt(Constants.TYPE, position);
//        itemFragment.setArguments(bundle);
        return getFragement(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d(TAG, "instantiateItem position = " + position);
        return super.instantiateItem(container, position);
    }

    @Override
    public int getCount() {
        if (listtitle == null)
            return 0;
        else
            return listtitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listtitle.get(position);
    }

    public abstract BaseFragment getFragement(int position);
}
