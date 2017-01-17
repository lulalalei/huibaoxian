package com.bb.hbx.widget.freshlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2016/12/16.
 */

public abstract class InterceptLauyout extends DrawLayout {


    // 用于计算滑动距离的Y坐标中介
    public int lastYMove;

    // 用于判断是否拦截触摸事件的Y坐标中介
    public int lastYIntercept;

    //需不需要下拉加载
    public boolean isNeedLoadMore = true;


    public boolean isIng = false;



    public InterceptLauyout(Context context) {
        super(context);
    }

    public InterceptLauyout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //return super.onInterceptTouchEvent(ev);

        boolean intercept = false;
        // 记录此次触摸事件的y坐标
        int y = (int) ev.getY();

        // 判断触摸事件类型
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 记录下本次系列触摸事件的起始点Y坐标
                lastYMove = y;
                // 不拦截ACTION_DOWN，因为当ACTION_DOWN被拦截，后续所有触摸事件都会被拦截
                intercept = false;
                break;

            case MotionEvent.ACTION_MOVE:

                if (!isIng) {
                    if (y > lastYIntercept) {//下滑操作
                        // 获取最顶部的子视图
                        View child = getFirstVisiableChild();
                        if (child == null) {
                            intercept = false;
                        } else if (child instanceof AdapterView) {
                            intercept = avPullDownIntercept(child);
                        } else if (child instanceof ScrollView) {
                            intercept = svPullDownIntercept(child);
                        } else if (child instanceof RecyclerView) {
                            intercept = rlPullDownIntercept(child);
                        }


                    } else if (y < lastYIntercept && isNeedLoadMore) {// 上拉操作
                        // 获取最底部的子视图
                        View child = getLastVisiableChild();
                        if (child == null) {
                            intercept = false;
                        } else if (child instanceof AdapterView) {
                            intercept = avPullUpIntercept(child);
                        } else if (child instanceof ScrollView) {
                            intercept = svPullUpIntercept(child);
                        } else if (child instanceof RecyclerView) {
                            intercept = rvPullUpIntercept(child);
                        }
                    } else {
                        intercept = false;
                    }
                } else
                    intercept = false;
                break;

            case MotionEvent.ACTION_UP:
                intercept = false;
                break;
        }

        lastYIntercept = y;

        return intercept;
    }

    private boolean rvPullUpIntercept(View child) {

        RecyclerView recyclerChild = (RecyclerView) child;
        if (recyclerChild.computeVerticalScrollExtent() + recyclerChild.computeVerticalScrollOffset()
                >= recyclerChild.computeVerticalScrollRange()) {
            return true;

        }
        return false;

    }

    private boolean svPullUpIntercept(View child) {

        ScrollView view = (ScrollView) child;
        View scrollChild = view.getChildAt(0);
        if (view.getScrollY() >= (scrollChild.getHeight() - view.getHeight())) {
            return true;
        }
        return false;
    }

    private boolean avPullUpIntercept(View child) {

        AdapterView adapterChild = (AdapterView) child;

        if (adapterChild.getLastVisiblePosition() == adapterChild.getChildCount() - 1
                && adapterChild.getChildAt(adapterChild.getChildCount() - 1).getBottom() == getMeasuredHeight()) {
            return true;
        }
        return false;
    }

    private View getLastVisiableChild() {
        for (int i = lastChildIndex; i >= 0; i--) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            } else {
                return child;
            }

        }

        return null;
    }

    private boolean rlPullDownIntercept(View child) {

        RecyclerView view = (RecyclerView) child;
        if (view.computeVerticalScrollOffset() <= 0) {
            return true;
        }
        return false;
    }

    protected boolean svPullDownIntercept(View child) {

        ScrollView view = (ScrollView) child;
        if (view.getScrollY() <= 0) {
            return true;
        }
        return false;

    }

    protected boolean avPullDownIntercept(View child) {

        AdapterView adapterChild = (AdapterView) child;
        // 判断AbsListView是否已经到达内容最顶部
        if (adapterChild.getFirstVisiblePosition() == 0 || adapterChild.getChildAt(0).getTop() == 0) {
            return true;
        }
        return false;
    }

    public View getFirstVisiableChild() {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            } else
                return child;
        }

        return null;
    }


}
