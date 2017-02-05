package com.bb.hbx.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bb.hbx.fragment.CarInsuContentFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/23.
 */

public class MyCarInsuAdapter extends FragmentStatePagerAdapter {

    ArrayList<CarInsuContentFragment> list;
    String []title;

    public MyCarInsuAdapter(FragmentManager fm, ArrayList<CarInsuContentFragment> list, String[] title) {
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
