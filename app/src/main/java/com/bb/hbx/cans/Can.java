package com.bb.hbx.cans;

import android.support.v4.app.Fragment;

import com.bb.hbx.fragment.AllInPIOFragment;
import com.bb.hbx.fragment.HadPaiedInPIOFragment;
import com.bb.hbx.fragment.UnEfficientInPIOFragment;
import com.bb.hbx.fragment.UnPayInPIOFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/26.
 */

public class Can {
    //在 我的--个险--个险订单 页面中记录上一个fragment的位置,用于hide,show上一个fragment
    public static int preFragmentPositionInPIO;
    //在 我的--红包--我的红包 页面中记录上一个fragment的位置,用于hide,show上一个fragment
    public static int preFragmentPositionInRedP;
    //容纳 我的--个险--个险订单 页面中的四个fragment,
    public static ArrayList<Fragment> pIOFragmentList;
    //容纳 我的--红包--我的红包 页面中的三个fragment,
    public static ArrayList<Fragment> redPFragmentList;
    public static ArrayList<Fragment> getFragmentListInPIO()
    {
        ArrayList<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(AllInPIOFragment.getInstance());
        fragmentList.add(UnPayInPIOFragment.getInstance());
        fragmentList.add(HadPaiedInPIOFragment.getInstance());
        fragmentList.add(UnEfficientInPIOFragment.getInstance());
        return fragmentList;
    }
}
