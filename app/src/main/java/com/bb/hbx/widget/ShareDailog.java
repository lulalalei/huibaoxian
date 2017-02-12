package com.bb.hbx.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;

import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.bb.hbx.BaseDialog;
import com.bb.hbx.R;


/**
 * Created by fancl.
 */

public class ShareDailog extends BaseDialog implements
        View.OnClickListener{


    private LinearLayout lin_wxshare;

    private LinearLayout lin_pyqshare;

    private LinearLayout lin_qqshare;

    private LinearLayout lin_cancl;

    private Context mContext;
    /**
     * @param context    上下文
     *
     */
    public ShareDailog(Context context) {
        super(context, R.layout.share);
        mContext=context;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();


    }

    private void init() {
        setAnimation(R.style.AnimationBottomDialog);
        setGravity(Gravity.BOTTOM);
        lin_wxshare= (LinearLayout) findViewById(R.id.lin_wxshare);
        lin_pyqshare= (LinearLayout) findViewById(R.id.lin_pyqshare);
        lin_qqshare= (LinearLayout) findViewById(R.id.lin_qqshare);
        lin_cancl= (LinearLayout) findViewById(R.id.lin_cancl);
        lin_cancl.setOnClickListener(this);
        lin_wxshare.setOnClickListener(this);
        lin_pyqshare.setOnClickListener(this);
        lin_qqshare.setOnClickListener(this);
    }

    @Override
    protected int dialogWidth() {
        DisplayMetrics metric = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay()
                .getMetrics(metric);
        return metric.widthPixels;
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lin_wxshare:
                Toast.makeText(mContext,"wx",Toast.LENGTH_LONG).show();
                break;
            case R.id.lin_pyqshare:
                Toast.makeText(mContext,"pyq",Toast.LENGTH_LONG).show();
                break;
            case R.id.lin_qqshare:
                Toast.makeText(mContext,"qq",Toast.LENGTH_LONG).show();
                break;
            case R.id.lin_cancl:
                this.dismiss();
                break;
        }
    }
}
