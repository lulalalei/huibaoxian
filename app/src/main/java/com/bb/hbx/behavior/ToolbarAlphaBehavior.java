package com.bb.hbx.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.bb.hbx.R;

import java.lang.ref.WeakReference;


/**
 * Created by Administrator on 2016/12/26.
 */

public class ToolbarAlphaBehavior extends CoordinatorLayout.Behavior<RelativeLayout> {

    private static final String TAG = ToolbarAlphaBehavior.class.getSimpleName();

    private float offset = 0;
    private float startOffset = 0;
    private float endOffset = 0;
    private Context context;

    private WeakReference<RecyclerView> dependentView;

    private RecyclerView.LayoutManager manager;


    public ToolbarAlphaBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        if (dependency != null && dependency.getId() == R.id.list) {
            dependentView = new WeakReference<>((RecyclerView) dependency);
            manager = ((RecyclerView) dependency).getLayoutManager();

            return true;
        }
        return false;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, RelativeLayout child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, RelativeLayout child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        startOffset = 0;
        endOffset = context.getResources().getDimensionPixelOffset(R.dimen.y500) - child.getHeight();
        Log.i(TAG, "dyConsumed:" + dyConsumed + "");

        Log.i(TAG, "TOP:" + getScollYDistance() + "");


        if (offset > endOffset) {
            Log.i(TAG, "进去了");
            if (dyConsumed < 0 && getScollYDistance() <= endOffset) {

                offset += dyConsumed;
            }

        } else {
            offset += dyConsumed;
        }

        if (offset <= startOffset || getScollYDistance() == 0) {
            child.getBackground().setAlpha(0);
            offset = 0;
        } else if (offset > startOffset && offset < endOffset) {
            float precent = (offset - startOffset) / endOffset;
            int alpha = Math.round(precent * 255);
            Log.i(TAG, "alpha:" + alpha + "");
            child.getBackground().setAlpha(alpha);
        } else if (offset >= endOffset) {
            child.getBackground().setAlpha(255);
        }
    }

    public int getScollYDistance() {
        LinearLayoutManager layoutManager = (LinearLayoutManager) dependentView.get().getLayoutManager();
        int position = layoutManager.findFirstVisibleItemPosition();
        View firstVisiableChildView = layoutManager.findViewByPosition(position);
        int itemHeight = firstVisiableChildView.getHeight();
        return (position) * itemHeight - firstVisiableChildView.getTop();
    }


}
