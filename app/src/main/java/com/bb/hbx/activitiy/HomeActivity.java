package com.bb.hbx.activitiy;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.fragment.ClassFragment;
import com.bb.hbx.fragment.HomeFragment;
import com.bb.hbx.fragment.MallFragment;
import com.bb.hbx.fragment.MineFragment;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.widget.BottomBar;

import butterknife.BindView;

import static android.R.attr.fragment;
import static android.view.Window.FEATURE_NO_TITLE;

/**
 * Created by Administrator on 2016/12/20.
 */

public class HomeActivity extends BaseActivity {


    @BindView(R.id.bb)
    BottomBar bb;

    private HomeFragment homeFragment;
    private MallFragment mallFragment;
    private ClassFragment classFragment;
    private MineFragment mineFragment;


    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        MyApplication.widthPixels = dm.widthPixels;
    }

    @Override
    public void initListener() {
        bb.setListener(new BottomBar.ChangeListener() {
            @Override
            public void changeTab2(int tab) {
                // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
                FragmentTransaction transaction = obtainFragmentTransaction();
                hideFragments(transaction);
                switch (tab) {
                    case 0:

                        if (homeFragment == null) {


                            // 如果MessageFragment为空，则创建一个并添加到界面上
                            homeFragment = new HomeFragment();
//                            exfs.add(todayFragment);
                            transaction.add(R.id.tab_content, homeFragment, HomeFragment.class.getName());
                        } else {
                            // 如果MessageFragment不为空，则直接将它显示出来
                            transaction.show(homeFragment);
                        }
                        break;
                    case 1:
                        // 当点击了消息tab时，改变控件的图片和文字颜色
                        if (mallFragment == null) {
                            // 如果MessageFragment为空，则创建一个并添加到界面上
                            mallFragment = new MallFragment();
                            //exfs.add(mcsFragment);
                            transaction.add(R.id.tab_content, mallFragment, MallFragment.class.getName());
                        } else {
                            // 如果MessageFragment不为空，则直接将它显示出来
                            transaction.show(mallFragment);
                        }
                        break;

                    case 2:
                        // 当点击了消息tab时，改变控件的图片和文字颜色
                        if (classFragment == null) {
                            // 如果MessageFragment为空，则创建一个并添加到界面上
                            classFragment = new ClassFragment();
                            //exfs.add(mineFragment);
                            transaction.add(R.id.tab_content, classFragment, ClassFragment.class.getName());
                        } else {
                            // 如果MessageFragment不为空，则直接将它显示出来
                            transaction.show(classFragment);
                        }
                        break;

                    case 3:
                        // 当点击了消息tab时，改变控件的图片和文字颜色
                        if (classFragment == null) {
                            // 如果MessageFragment为空，则创建一个并添加到界面上
                            classFragment = new ClassFragment();
                            //exfs.add(mineFragment);
                            transaction.add(R.id.tab_content, classFragment, ClassFragment.class.getName());
                        } else {
                            // 如果MessageFragment不为空，则直接将它显示出来
                            transaction.show(classFragment);
                        }
                        break;
                    case 4:
                        // 当点击了消息tab时，改变控件的图片和文字颜色
                        if (mineFragment == null) {
                            // 如果MessageFragment为空，则创建一个并添加到界面上
                            mineFragment = new MineFragment();
                            //exfs.add(mineFragment);
                            transaction.add(R.id.tab_content, mineFragment, MineFragment.class.getName());
                        } else {
                            // 如果MessageFragment不为空，则直接将它显示出来
                            transaction.show(mineFragment);
                        }
                        break;


                }
                transaction.commit();
            }
        });
    }

    @Override
    public void initdata() {
        bb.changeTab(0);
    }

    private FragmentTransaction obtainFragmentTransaction() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // 设置切换动画
//        if (index > currentTab) {
//            ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out2);
//        } else {
//            ft.setCustomAnimations(R.anim.slide_right_in2, R.anim.slide_right_out);
//        }
        return ft;
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (classFragment != null) {
            transaction.hide(classFragment);
        }
        if (mallFragment != null) {
            transaction.hide(mallFragment);
        }

        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }


    }

    /**
     * 实现再按一次退出提醒
     */
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 3000) {
                showTip(getString(R.string.snack_exit_once_more));
                exitTime = System.currentTimeMillis();
            } else {
                AppManager.getInstance().AppExit(this);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }


}
