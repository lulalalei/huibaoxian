package com.bb.hbx.cans;

import android.os.Environment;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.bb.hbx.MyApplication;
import com.bb.hbx.fragment.AllInCarInsuFragment;
import com.bb.hbx.fragment.AllInMyOrderFragment;
import com.bb.hbx.fragment.AllInPIOFragment;
import com.bb.hbx.fragment.HadPaiedInPIOFragment;
import com.bb.hbx.fragment.HadSentInCarInsuFragment;
import com.bb.hbx.fragment.HadStopInCarInsuFragment;
import com.bb.hbx.fragment.HasFinishedInMyOrderFragment;
import com.bb.hbx.fragment.RecordInRedPaFragment;
import com.bb.hbx.fragment.UnEfficientInPIOFragment;
import com.bb.hbx.fragment.UnEfficientInRedPaFragment;
import com.bb.hbx.fragment.UnPayInPIOFragment;
import com.bb.hbx.fragment.UnUsedInRedPaFragment;
import com.bb.hbx.fragment.UnderPayInMyOrderFragment;
import com.bb.hbx.fragment.UnderSendInCarInsuFragment;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/26.
 */

public class Can {

    //记录用户登录状态
    public static boolean hasLogined;
    //记录用户名
    public static String userName;
    //记录用户手机号
    public static String userPhone;
    //记录用户密码
    public static String userPwd;
    //用户头像
    public static String userIcon;
    //用户默认头像
    public static String userIconDefault="http://pic61.nipic.com/file/20150304/20245617_095937129615_2.jpg";

    //存储头像的文件名
    public static String getDefaultUsersIconFile()
    {
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + File.separator
                + "huibx";
        return path;
    }

    //判断用户是否登录
    public static boolean hasLoginedMethod()
    {
        boolean hasLogin=false;
        if (MyApplication.user==null)
        {
            hasLogin=false;
        }
        else
        {
            String userId = MyApplication.user.getUserId();
            if (TextUtils.isEmpty(userId))
            {
                hasLogin=false;
            }
            else if ("0".equals(userId))
            {
                hasLogin=false;
            }
            else
            {
                hasLogin=true;
            }
        }
        return hasLogin;
    }

    //修改用户名成功后的响应码
    public static final int RESULT_NAME=200;

    //修改邮箱地址成功后的响应码
    public static final int RESULT_EMAIL=201;

    //结束短信登录Activity
    public static final int FINISH_LOGIN=300;

    //结束找回密码Activity
    public static final int FINISH_GETPSW=301;

    //在 我的--个险--个险订单 页面中记录上一个fragment的位置,用于hide,show上一个fragment
    public static int preFragmentPositionInPIO;
    //在 我的--红包--我的红包 页面中记录上一个fragment的位置,用于hide,show上一个fragment
    public static int preFragmentPositionInRedP;
    //在 我的--我的订单 页面中记录上一个fragment的位置,用于hide,show上一个fragment
    public static int preFragmentPositionInMyOrder;
    //在 我的--车险订单 页面中记录上一个fragment的位置,用于hide,show上一个fragment
    public static int preFragmentPositionInCIO;
    //容纳 我的--个险--个险订单 页面中的四个fragment,
    public static ArrayList<Fragment> pIOFragmentList;
    //容纳 我的--红包--我的红包 页面中的三个fragment,
    public static ArrayList<Fragment> redPFragmentList;
    //容纳 我的--我的订单 页面中的三个fragment,
    public static ArrayList<Fragment> myOrderFragmentList;
    //容纳 我的--车险订单 页面中的四个fragment,
    public static ArrayList<Fragment> carIOFragmentList;

    public static ArrayList<Fragment> getFragmentListInPIO()
    {
        ArrayList<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(AllInPIOFragment.getInstance());
        fragmentList.add(UnPayInPIOFragment.getInstance());
        fragmentList.add(HadPaiedInPIOFragment.getInstance());
        fragmentList.add(UnEfficientInPIOFragment.getInstance());
        return fragmentList;
    }
    public static ArrayList<Fragment> getFragmentListInRedP()
    {
        ArrayList<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(UnUsedInRedPaFragment.getInstance());
        fragmentList.add(RecordInRedPaFragment.getInstance());
        fragmentList.add(UnEfficientInRedPaFragment.getInstance());
        return fragmentList;
    }
    public static ArrayList<Fragment> getFragmentListInMyOrder()
    {
        ArrayList<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(AllInMyOrderFragment.getInstance());
        fragmentList.add(UnderPayInMyOrderFragment.getInstance());
        fragmentList.add(HasFinishedInMyOrderFragment.getInstance());
        return fragmentList;
    }
    public static ArrayList<Fragment> getFragmentListInCIO()
    {
        ArrayList<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(AllInCarInsuFragment.getInstance());
        fragmentList.add(UnderSendInCarInsuFragment.getInstance());
        fragmentList.add(HadSentInCarInsuFragment.getInstance());
        fragmentList.add(HadStopInCarInsuFragment.getInstance());
        return fragmentList;
    }
}
