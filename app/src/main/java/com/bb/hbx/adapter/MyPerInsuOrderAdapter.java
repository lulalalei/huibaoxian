package com.bb.hbx.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.bb.hbx.fragment.PIOrderContentFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/26.
 */

public class MyPerInsuOrderAdapter extends FragmentStatePagerAdapter{

    private ArrayList<PIOrderContentFragment> list;
    private String [] titles;

    public MyPerInsuOrderAdapter(FragmentManager fm, ArrayList<PIOrderContentFragment> list, String[] titles) {
        super(fm);
        this.list = list;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.e("wyc","======MyPerInsuOrderAdapter======");
        return titles[position];
    }
}
