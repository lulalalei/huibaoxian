package com.bb.hbx.utils;

/**
 * Created by Administrator on 2016/12/22.
 */

public final class Constants {

    public static final String SUCCESS = "000000";//服务器返回成功
    public static final String OSNAME = "A";//操作系统

    public static final int SQUARE_PAGE_COUNT = 3;

    public static final int PAGE_BKTJ = 0;
    public static final int PAGE_YXHD = 1;
    public static final int PAGE_ZTLB = 2;


    public static final String TYPE = "type";


    /**
     * 1：短信验证码
     * 2：图形验证码
     */
    public static final String DXYZM = "1";
    public static final String TXYZM = "2";


    public static final String REGIST_bizType = "10";//注册
    public static final String LOGIN_bizType = "11";//登录
    public static final String FINDPWD_bizType = "12";//找回密码
    public static final String RECIVE_bizType = "13";//发送短信验证码


    public static final int BKTJ = 20;

    //C端用户
    public static final int CLIENTUSER = 10;
    //B端用户
    public static final int BOSSUSER = 20;

    public static final String BusInsurance = "20";

    public static final String personInsurance = "10";

    public static final String AllInsurance = "0";

    public static final int NOMORE = 0;//正常

    public static final int MORE = 1;//更多

    public static final String[] idTypes = {"身份证", "军官证", "护照", "驾驶证", "港澳台通行证", "回乡证"};
    public static final int[] idType_keys = {1, 2, 3, 4, 5, 6};//
}
