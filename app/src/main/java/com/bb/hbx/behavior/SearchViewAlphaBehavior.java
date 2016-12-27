package com.bb.hbx.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.bb.hbx.R;

import java.lang.ref.WeakReference;

import static android.R.attr.dependency;

/**
 * Created by Administrator on 2016/12/26.
 */

public class SearchViewAlphaBehavior extends CoordinatorLayout.Behavior<RecyclerView> {

    private static final String TAG = SearchViewAlphaBehavior.class.getSimpleName();

    private Context context;

    private int endOffset = 0;

    private int offset = 0;


    private WeakReference<View> dependentView;

    public SearchViewAlphaBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, RecyclerView child, View dependency) {
        if (dependency != null && dependency.getId() == R.id.lin_bg) {
            dependentView = new WeakReference<>(dependency);
            return true;
        }
        return false;
    }


    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, RecyclerView child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }



    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, RecyclerView child, View target, int dx, int dy, int[] consumed) {

        if(offset<endOffset&& offset>=0) {
            offset += dy;
        }

        endOffset = context.getResources().getDimensionPixelOffset(R.dimen.y500) - dependentView.get().getHeight();

        Log.i(TAG,"offset:"+offset);
        if (offset > 0 && offset < endOffset) {
            final float progress = Math.abs(offset / endOffset);

            dependentView.get().getBackground().setAlpha((int) progress);
        } else {
            if (offset > endOffset) {
                dependentView.get().getBackground().setAlpha(255);
            } else if (offset < 0) {
                dependentView.get().getBackground().setAlpha(0);
            }
        }
    }
}
