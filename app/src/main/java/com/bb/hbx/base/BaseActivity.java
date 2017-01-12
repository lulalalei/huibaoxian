package com.bb.hbx.base;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.bb.hbx.MainActivity;
import com.bb.hbx.MyApplication;
import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.base.v.BaseView;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.utils.DeviceUtils;
import com.bb.hbx.utils.InstanceUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2016/12/5.
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity
        implements BaseView {


    public P mPresenter;
    public Context mContext;
    private Unbinder unbinder;

    private boolean isCheck = true;//检测是否第一次


    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
        this.setContentView(getLayoutId());
        setDisplayMetrics();
        unbinder = ButterKnife.bind(this);
        mContext = this;
        mPresenter = InstanceUtil.getInstance(this, 0);
        this.initView();
        this.initListener();
        if (this instanceof BaseView && mPresenter != null)
            mPresenter.setVM(this, InstanceUtil.getInstance(this, 1));

        //保证手机唯一码不被销毁
        if (MyApplication.DUID.isEmpty()) {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                isCheckReadPhone();
            } else {
                DeviceUtils.getDeviceIdentification(this);
                this.initdata();
            }
        } else {
            this.initdata();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();

        if (!isCheck) {
            //保证手机唯一码不被销毁
            if (MyApplication.DUID.isEmpty()) {
                if (android.os.Build.VERSION.SDK_INT >= 23) {
                    isCheckReadPhone();
                } else {
                    DeviceUtils.getDeviceIdentification(this);
                    this.initdata();
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDetached();
        if (unbinder != null)
            unbinder.unbind();
        AppManager.getInstance().finishActivity();

    }

    /**
     * 提示信息
     *
     * @param aFormatMsg
     * @param aMsgArgs
     */
    public void showTip(String aFormatMsg, Object... aMsgArgs) {
        String outString = String.format(aFormatMsg, aMsgArgs);
        int duration = (outString.length() > 10) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT;
        Toast.makeText(mContext, outString, duration).show();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //// TODO: 2016/11/25  填写 你需要在底栈的页面
            return (AppManager.getInstance().processBackKey(MainActivity.class) ?
                    true : super.onKeyDown(keyCode, event));

        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    //求屏幕尺寸
    public void setDisplayMetrics() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        MyApplication.widthPixels = dm.widthPixels;
        MyApplication.heightPixels = dm.heightPixels;
    }

    private static final int REQUEST_PERMISSION_READ_PHONE_STATE_CODE = 1;


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void isCheckReadPhone() {
        if (!(checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED)) {
            requestCameraPermission();
        } else {
            DeviceUtils.getDeviceIdentification(this);
            initdata();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void requestCameraPermission() {
        requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_PERMISSION_READ_PHONE_STATE_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_READ_PHONE_STATE_CODE) {
            boolean granted = (grantResults[0] == PackageManager.PERMISSION_GRANTED);
            if (!granted) {
                showTipsDialog();
            } else {
                DeviceUtils.getDeviceIdentification(this);
                initdata();
            }
        }
    }


    /**
     * 显示提示对话框
     */
    private void showTipsDialog() {
        new AlertDialog.Builder(this)
                .setTitle("提示信息")
                .setMessage("当前应用缺少必要权限，该功能暂时无法使用。如若需要，请单击【确定】按钮前往设置中心进行权限授权。")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startAppSettings();
                        isCheck = false;
                    }
                }).show();
    }

    /**
     * 启动当前应用设置页面
     */
    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }


    /**
     * 布局加载
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化控件
     */
    public abstract void initView();


    public abstract void initListener();

    /**
     * 初始数据
     */
    public abstract void initdata();


    @Override
    public void showMsg(String msg) {
        showTip(msg);
    }

    @Override
    public void initLoading() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dissmissLoading() {

    }

    @Override
    public void updateLoading() {

    }
}
