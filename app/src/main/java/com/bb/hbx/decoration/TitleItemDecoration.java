package com.bb.hbx.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;

import com.bb.hbx.bean.BaseIndexTagBean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/1.
 */

public class TitleItemDecoration extends RecyclerView.ItemDecoration{

    private List<? extends BaseIndexTagBean> mDatas;
    private Paint mPaint;
    private Rect mBounds;//用于存放测量文字Rect

    private LayoutInflater mInflater;

    private int mTitleHeight;//title的高
    private static int COLOR_TITLE_BG = Color.parseColor("#FFDFDFDF");
    private static int COLOR_TITLE_FONT = Color.parseColor("#FF000000");
    private static int mTitleFontSize;//title字体大小

    //新添了这
    private Paint topPaint;

    public TitleItemDecoration(Context context, List<? extends BaseIndexTagBean> mDatas) {
        this.mDatas = mDatas;
        mPaint = new Paint();
        mBounds = new Rect();
        mTitleHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, context.getResources().getDisplayMetrics());
        mTitleFontSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, context.getResources().getDisplayMetrics());
        mPaint.setTextSize(mTitleFontSize);
        mPaint.setAntiAlias(true);
        mInflater = LayoutInflater.from(context);

        //新添了这
        topPaint=new Paint();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int position = params.getViewLayoutPosition();
            //Rv的item position在重置时可能为-1,,,,在此判断一下
            if (position>-1)
            {
                if (position==0)//等于0肯定要有title
                {
                    drawTitleArea(c,left,right,child,params,position);
                }
                else
                {
                    if (null!=mDatas.get(position).getTag()&&!mDatas.get(position).getTag().equals(mDatas.get(position-1).getTag()))
                    {
                        //不为空,且跟前一个tag不一样,说明是新的分类,也要title
                        drawTitleArea(c,left,right,child,params,position);
                    }
                    else
                    {

                    }
                }
            }
        }
    }

    /*
    * 绘制Title区域背景和文字的方法*/
    private void drawTitleArea(Canvas c, int left, int right, View child, RecyclerView.LayoutParams params, int position) {
        mPaint.setAntiAlias(true);
        mPaint.setColor(COLOR_TITLE_BG);
        //新添了这
        topPaint.setAntiAlias(true);
        topPaint.setColor(Color.WHITE);
        //改了这
        //c.drawRect(left,child.getTop()-params.topMargin-mTitleHeight,right,child.getTop()-params.topMargin,mPaint);
        c.drawRect(left,child.getTop()-params.topMargin-(mTitleHeight/2)-1,right,child.getTop()-params.topMargin-(mTitleHeight/2)+1,mPaint);
        mPaint.setColor(COLOR_TITLE_FONT);
        mPaint.getTextBounds(mDatas.get(position).getTag(),0,mDatas.get(position).getTag().length(),mBounds);
        c.drawText(mDatas.get(position).getTag(),child.getPaddingLeft(),child.getTop()-params.topMargin- (mTitleHeight / 2 - mBounds.height() / 2),mPaint);

    }

    /*//最后调用,绘制在最上层
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int pos = ((LinearLayoutManager) parent.getLayoutManager()).findFirstVisibleItemPosition();
        String tag = mDatas.get(pos).getTag();
        //避免child为空,所以用此方法替换parent.getChildAt(pos)
        View child = parent.findViewHolderForLayoutPosition(pos).itemView;
        boolean flag=false;//Canvas是否移位过的标志
        if ((pos+1)<mDatas.size())//判断数组越界
        {
            if (null!=tag&&!tag.equals(mDatas.get(pos+1).getTag()))
            {
                Log.e("AAA","======onDrawOver====="+mDatas.get(pos+1).getTag());
                if (child.getHeight()+child.getTop()<mTitleHeight)
                {
                    c.save();
                    flag=true;
                    c.translate(0,child.getHeight()+child.getTop()-mTitleHeight);
                }
            }
        }
        mPaint.setColor(COLOR_TITLE_BG);
        //改了这
        //c.drawRect(parent.getPaddingLeft(),parent.getPaddingTop(),parent.getRight()-parent.getPaddingRight(),parent.getPaddingTop()+mTitleHeight,mPaint);
        c.drawRect(parent.getPaddingLeft(),parent.getPaddingTop(),parent.getRight()-parent.getPaddingRight(),parent.getPaddingTop()+mTitleHeight,topPaint);
        mPaint.setColor(COLOR_TITLE_FONT);
        mPaint.getTextBounds(tag, 0, tag.length(), mBounds);
        c.drawText(tag, child.getPaddingLeft(),
                parent.getPaddingTop() + mTitleHeight - (mTitleHeight / 2 - mBounds.height() / 2),
                mPaint);
        if (flag)
        {
            c.restore();//恢复画布到之前保存的状态
        }
    }*/

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        if (position>-1)
        {
            if (position==0)
            {
                outRect.set(0,mTitleHeight,0,0);
            }
            else
            {
                if (null != mDatas.get(position).getTag() && !mDatas.get(position).getTag().equals(mDatas.get(position - 1).getTag()))
                {
                    outRect.set(0,mTitleHeight,0,0);
                }
                else
                {
                    outRect.set(0,0,0,0);
                }
            }
        }
    }
}
