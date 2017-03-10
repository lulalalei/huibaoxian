package com.bb.hbx.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;

import com.bb.hbx.activitiy.ProductDetailActivity;
import com.bb.hbx.utils.AppManager;

/**
 * Created by fancl
 * 详情页的 文字跳转span
 */

public class ClickAble extends ClickableSpan {

    private int index;
    private Context context;

    public ClickAble(int index, Context context) {
        this.index = index;
        this.context = context;
    }



    @Override
    public void onClick(View widget) {
//            Bundle bundle=new Bundle();
//            bundle.putString("","");
//            AppManager.getInstance().showActivity();



    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setColor(Color.parseColor("#2dce8f"));
        ds.setTextSize(AppManager.getInstance().sp2px(context, 12));
        ds.setUnderlineText(false);

    }

}
