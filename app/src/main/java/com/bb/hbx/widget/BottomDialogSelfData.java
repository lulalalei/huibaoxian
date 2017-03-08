package com.bb.hbx.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.bb.hbx.R;
import com.bb.hbx.bean.Area;
import com.bb.hbx.interfaces.OnAreaSelectedListener;
import com.bb.hbx.utils.Dev;


import java.util.List;


/**
 * Created by smartTop on 2016/10/19.
 */

public class BottomDialogSelfData extends Dialog {


    private AddressSelectorSelf selector;

    public BottomDialogSelfData(Context context) {
        super(context, R.style.bottom_dialog);
        init(context);
    }

    public BottomDialogSelfData(Context context, int themeResId) {
        super(context, themeResId);
        init(context);
    }

    public BottomDialogSelfData(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }

    /**
     * 初始化
     *
     * @param context
     */
    private void init(Context context) {
        selector = new AddressSelectorSelf(context);
        setContentView(selector.getView());

        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = Dev.dp2px(context, 256);
        window.setAttributes(params);
        window.setGravity(Gravity.BOTTOM);
        selector.loadprogressBar();

    }

    public void getProvinces(List<Area> provinces) {
        selector.retrieveProvinces(provinces);
    }

    public void getCitylist(List<Area> cities) {
        selector.getCitylist(cities);
    }


    public void setOnAreaSelectedListener(OnAreaSelectedListener listener) {
        this.selector.setListener(listener);
    }

    public static BottomDialogSelfData show(Context context) {
        return show(context, null);
    }

    public static BottomDialogSelfData show(Context context, OnAreaSelectedListener listener) {
        BottomDialogSelfData dialog = new BottomDialogSelfData(context, R.style.bottom_dialog);
        dialog.selector.setListener(listener);
        dialog.show();

        return dialog;
    }

    public void setDialogDismisListener(AddressSelectorSelf.OnDialogCloseListener listener) {
        this.selector.setOnDialogCloseListener(listener);
    }

    /**
     * 设置字体选中的颜色
     */
    public void setTextSelectedColor(int selectedColor) {
        this.selector.setTextSelectedColor(selectedColor);
    }

    /**
     * 设置字体没有选中的颜色
     */
    public void setTextUnSelectedColor(int unSelectedColor) {
        this.selector.setTextUnSelectedColor(unSelectedColor);
    }

    /**
     * 设置字体的大小
     */
    public void setTextSize(float dp) {
        this.selector.setTextSize(dp);
    }

    /**
     * 设置字体的背景
     */
    public void setBackgroundColor(int colorId) {
        this.selector.setBackgroundColor(colorId);
    }

    /**
     * 设置指示器的背景
     */
    public void setIndicatorBackgroundColor(int colorId) {
        this.selector.setIndicatorBackgroundColor(colorId);
    }

    /**
     * 设置指示器的背景
     */
    public void setIndicatorBackgroundColor(String color) {
        this.selector.setIndicatorBackgroundColor(color);
    }
}
