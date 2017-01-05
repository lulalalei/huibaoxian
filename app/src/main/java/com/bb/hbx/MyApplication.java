package com.bb.hbx;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2016/12/6.
 */

public class MyApplication extends Application {

    private static MyApplication INSTANCE = null;

    private static Context context;

    public static String DUID = "";// 设备唯一码
    public static int widthPixels = 321;// 屏幕宽度
    public static int heightPixels= 481;//屏幕高度

    //public static User user;// 用户信息

    public static final Context getAppContext(){
        return context;
    };
    public static MyApplication getInstance() {
        return INSTANCE;
    }


    public static int dp2px(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5);
    }

    public static int dp2px(Context context, double dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        INSTANCE = this;
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(context);

    }
}
