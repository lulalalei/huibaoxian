package com.bb.hbx.widget;


import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.utils.AppManager;


/**
 * Created by Administrator on 2017/2/21.
 */

public class FormLayout extends LinearLayout {


    private int line = 4;

    private Context mContext;


    public FormLayout(Context context) {
        super(context);
    }

    public FormLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FormLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void initdate() {
        setOrientation(VERTICAL);

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, (int) AppManager.getInstance().dp2px(mContext, 39));
        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(HORIZONTAL);

        TextView textView = new TextView(mContext);
        LayoutParams lp = new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, Gravity.CENTER);
        lp.weight = 2.0f;
        textView.setLayoutParams(lp);
        textView.setTextAppearance(mContext, R.style.TextAppear_Theme_A4_Size12);
        textView.setText("保险责任");
        linearLayout.addView(textView);




    }
}
