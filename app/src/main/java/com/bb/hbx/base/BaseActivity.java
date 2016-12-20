package com.bb.hbx.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.bb.hbx.MainActivity;
import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.base.v.BaseView;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.utils.InstanceUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2016/12/5.
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {


    public P mPresenter;
    public Context mContext;
    private Unbinder unbinder;


    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
        this.setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        mContext = this;
        mPresenter = InstanceUtil.getInstance(this, 0);
        this.initView();
        this.initListener();
        if (this instanceof BaseView && mPresenter != null)
            mPresenter.setVM(this, InstanceUtil.getInstance(this, 1));
        this.initdata();


    }

    @Override
    protected void onStart() {
        super.onStart();
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


}
