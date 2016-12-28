package com.bb.hbx.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

import com.bb.hbx.R;

/**
 * Created by Administrator on 2016/12/28.
 */

public class MyRelativeLayout extends RelativeLayout{

    Paint paint;

    public MyRelativeLayout(Context context) {
        super(context);
        init();
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {


        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.A6));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);

    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        Log.e("====onDraw=====","===========");
//        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);
//        canvas.save();
//        canvas.translate(10,0);
//
//        super.onDraw(canvas);
//        canvas.restore();
//    }

    @Override
    protected void dispatchDraw(Canvas canvas) {

        Log.e("====dispatchDraw=====","===========");
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);
        canvas.save();
        canvas.translate(10,0);

        super.dispatchDraw(canvas);
        canvas.restore();
    }
}
