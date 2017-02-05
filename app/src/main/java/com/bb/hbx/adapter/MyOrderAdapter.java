package com.bb.hbx.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bb.hbx.fragment.MyOrderContentFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/23.
 */

public class MyOrderAdapter extends FragmentStatePagerAdapter {

    ArrayList<MyOrderContentFragment> list;
    String []title;

    public MyOrderAdapter(FragmentManager fm, ArrayList<MyOrderContentFragment> list, String[] title) {
        super(fm);
        this.list = list;
        this.title = title;
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
        return title[position];
    }
}
