package com.bb.hbx.utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fancl .
 * <p>
 * 开权限的工具类、
 * 简单的做了一些封装
 */

public class PermissionUtils {

    private final int SDK_PERMISSION_REQUEST = 150;

    public final static  int REQUEST_SETTING_CODE=1;

    private HashMap<String, Boolean> permissions = new HashMap<String, Boolean>();

    private Activity context;

    private boolean isNowGetP = true;//正在获得权限;

    public PermissionUtils(Context context) {

        this.context = (Activity) context;

    }

    //判断版本23
    public boolean isM() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean checkPermissions(String perS) {
        if (context.checkSelfPermission(perS) != PackageManager.PERMISSION_GRANTED) {
            permissions.put(perS, false);

            return false;
        } else {
            return true;
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void startPermission() {
        if (permissions.size() > 0 ) {
            context.requestPermissions(permissions.keySet().toArray(new String[permissions.size()]), SDK_PERMISSION_REQUEST);
            isNowGetP = false;
        }


    }


    //权限返回的结果
    public boolean onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


        if (requestCode == SDK_PERMISSION_REQUEST) {
            for (int i = 0; i < permissions.length; i++) {
                boolean granted = (grantResults[i] == PackageManager.PERMISSION_GRANTED);
                if (granted) {
                    if (this.permissions.containsKey(permissions[i])) {
                        this.permissions.put(permissions[i], true);

                    }
                }
            }
        }

        Collection<Boolean> values = this.permissions.values();

        //有失败的做跳转去设置
        for (boolean b : values) {
            if (!b) {
                showTipsDialog();
                return false;
            }
        }

        return true;
    }

    /**
     * 取value boo值,证明是否成功授权
     *
     * @param permission
     * @return
     */
    public boolean getPermissions(String permission) {
        if (permissions.containsKey(permission)) {
            return permissions.get(permission);
        } else
            return false;
    }


    /**
     * 显示提示对话框
     */
    private void showTipsDialog() {
        new AlertDialog.Builder(context)
                .setTitle("提示信息")
                .setCancelable(false)
                .setMessage("当前应用缺少必要权限，该功能暂时无法使用。如若需要，请单击【确定】按钮前往设置中心进行权限授权。")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startAppSettings();

                    }
                }).show();
    }

    /**
     * 启动当前应用设置页面
     */
    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        context.startActivityForResult(intent,REQUEST_SETTING_CODE);
    }


}
