package com.bb.hbx.widget.freshlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2016/12/16.
 */

public abstract class DrawLayout extends ViewGroup {


    public View HeadView;//

    public View FootView;//

    public int lastChildIndex;// 最后一个childview的index
    public int bottomScroll;// 当滚动到内容最底部时Y轴所需要的滑动值

    public DrawLayout(Context context) {
        super(context);
    }

    public DrawLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        lastChildIndex = getChildCount() - 1;

    }

    /**
     * 添加上拉刷新布局作为header
     */
    public void addHeader(View header) {
        this.HeadView = header;
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        addView(HeadView, layoutParams);


    }

    /**
     * 添加下拉加载布局作为footer
     */
    public void addFooter(View footer) {
        this.FootView = footer;
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        addView(FootView, layoutParams);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 遍历进行子视图的测量工作
        for (int i = 0; i < getChildCount(); i++) {
            // 通知子视图进行测量
            View view = getChildAt(i);
            if (view.getVisibility() == GONE) {
                continue;
            }

            measureChild(view, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // 重置(避免重复累加)
        int contentHeight = 0;
        // 遍历进行子视图的置位工作

        for (int i = 0; i < getChildCount(); i++) {

            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            // 头视图隐藏在ViewGroup的顶端

            if (child == HeadView) {
                child.layout(0, 0 - child.getMeasuredHeight(), child.getMeasuredWidth(), 0);
            } else if (child == FootView) {
                child.layout(0, contentHeight, child.getMeasuredWidth(), contentHeight + child.getMeasuredHeight());
            } else {
                child.layout(0, contentHeight, child.getMeasuredWidth(), contentHeight + child.getMeasuredHeight());
                if (i <= lastChildIndex) {
                    if (child instanceof ScrollView) {
                        contentHeight += getMeasuredHeight();
                        continue;
                    }
                }
                contentHeight += child.getMeasuredHeight();
            }

        }

        // 计算到达内容最底部时ViewGroup的滑动距离
        bottomScroll = contentHeight - getMeasuredHeight();
    }
}
