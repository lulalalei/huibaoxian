package com.bb.hbx.widget.freshlayout;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import static com.bb.hbx.widget.freshlayout.PullStatus.DEFAULT;
import static com.bb.hbx.widget.freshlayout.PullStatus.DOWN_AFTER;
import static com.bb.hbx.widget.freshlayout.PullStatus.DOWN_BEFORE;
import static com.bb.hbx.widget.freshlayout.PullStatus.LOADMORE_CANCEL_SCROLLING;
import static com.bb.hbx.widget.freshlayout.PullStatus.LOADMORE_DOING;
import static com.bb.hbx.widget.freshlayout.PullStatus.LOADMORE_SCROLLING;
import static com.bb.hbx.widget.freshlayout.PullStatus.REFRESH_CANCEL_SCROLLING;
import static com.bb.hbx.widget.freshlayout.PullStatus.REFRESH_COMPLETE_SCROLLING;
import static com.bb.hbx.widget.freshlayout.PullStatus.REFRESH_DOING;
import static com.bb.hbx.widget.freshlayout.PullStatus.REFRESH_SCROLLING;
import static com.bb.hbx.widget.freshlayout.PullStatus.UP_AFTER;
import static com.bb.hbx.widget.freshlayout.PullStatus.UP_BEFORE;


/**
 * Created by Administrator on 2016/12/16.
 */

public abstract class PullLayout extends InterceptLauyout {


    public PullHeader pullHeader;
    public PullFooter pullFooter;

    //恢复动画的执行时间
    public int SCROLL_TIME = 300;



    //是否刷新完成
    private boolean isRefreshSuccess = false;
    //是否加载完成
    private boolean isLoadSuccess = false;


    //阻尼系数
    private float damp = 0.5f;

    // 事件监听接口
    private OnPullListener listener;

    // Layout状态
    private PullStatus status = DEFAULT;

    public void setOnPullListener(OnPullListener listener) {
        this.listener = listener;
    }


    public PullLayout(Context context) {
        super(context);
    }

    public PullLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {


            case MotionEvent.ACTION_MOVE:
                // 计算本次滑动的Y轴增量(距离)
                int dy = y - lastYMove;


                if (getScrollY() < 0) {
                    if (HeadView != null) {
                        setGone();
                        performScroll(dy);
                        if (Math.abs(getScrollY()) > HeadView.getMeasuredHeight()) {
                            updateStatus(DOWN_AFTER);
                        } else {
                            updateStatus(DOWN_BEFORE);
                        }
                    }
                } // 如果getScrollY>=0，即上拉操作
                else {
                    if (FootView != null) {
                        // 进行Y轴上的滑动
                        performScroll(dy);
                        if (getScrollY() >= bottomScroll + FootView.getMeasuredHeight()) {
                            updateStatus(UP_AFTER);
                        } else {
                            updateStatus(UP_BEFORE);
                        }
                    }
                }
                // 记录y坐标
                lastYMove = y;
                break;

            case MotionEvent.ACTION_CANCEL:
                break;

            case MotionEvent.ACTION_UP:

                isIng = true;
                // 判断本次触摸系列事件结束时,Layout的状态
                switch (status) {
                    //下拉刷新
                    case DOWN_BEFORE:
                        scrolltoDefaultStatus(REFRESH_CANCEL_SCROLLING);
                        break;
                    case DOWN_AFTER:
                        scrolltoRefreshStatus();
                        break;
                    //上拉加载更多
                    case UP_BEFORE:
                        scrolltoDefaultStatus(LOADMORE_CANCEL_SCROLLING);
                        break;
                    case UP_AFTER:
                        scrolltoLoadStatus();
                        break;
                    default:

                        break;
                }

                break;
        }


        return super.onTouchEvent(event);
    }

    //执行滑动
    public void performScroll(int dy) {
        scrollBy(0, (int) (-dy * damp));
    }


    //滚动到加载状态
    private void scrolltoLoadStatus() {
        int start = getScrollY();
        int end = FootView.getMeasuredHeight() + bottomScroll;
        performAnim(start, end, new AnimListener() {
            @Override
            public void onDoing() {
                updateStatus(LOADMORE_SCROLLING);
            }

            @Override
            public void onEnd() {
                updateStatus(LOADMORE_DOING);
            }
        });
    }


    //滚动到刷新状态
    private void scrolltoRefreshStatus() {
        int start = getScrollY();
        int end = -HeadView.getMeasuredHeight();
        performAnim(start, end, new AnimListener() {
            @Override
            public void onDoing() {
                updateStatus(REFRESH_SCROLLING);
            }

            @Override
            public void onEnd() {
                updateStatus(REFRESH_DOING);

            }
        });
    }


    //自动滚动到刷新状态
    public void scrolltoRefreshauto() {

        postDelayed(new Runnable() {
            @Override
            public void run() {
                int start = 0;
                int end = -HeadView.getMeasuredHeight();
                performAnim(start, end, new AnimListener() {
                    @Override
                    public void onDoing() {
                        updateStatus(REFRESH_SCROLLING);
                    }

                    @Override
                    public void onEnd() {
                        updateStatus(REFRESH_DOING);
                    }
                });
            }
        }, 1000);

    }


    //刷新状态
    private void updateStatus(PullStatus status) {
        this.status = status;
        int scrollY = getScrollY();
        // 判断本次触摸系列事件结束时,Layout的状态
        switch (status) {
            //默认状态
            case DEFAULT:
                onDefault();
                break;
            //下拉刷新
            case DOWN_BEFORE:
                if (pullHeader != null)
                    pullHeader.onDownBefore(scrollY);
                break;
            case DOWN_AFTER:
                if (pullHeader != null)
                    pullHeader.onDownAfter(scrollY);
                break;
            case REFRESH_SCROLLING:
                if (pullHeader != null)
                    pullHeader.onRefreshScrolling(scrollY);
                break;
            case REFRESH_DOING:
                if (pullHeader != null) {
                    pullHeader.onRefreshDoing(scrollY);
                }
                if (listener != null)
                    listener.onRefresh();
                break;
            case REFRESH_COMPLETE_SCROLLING:
                if (pullHeader != null)
                    pullHeader.onRefreshCompleteScrolling(scrollY, isRefreshSuccess);
                break;
            case REFRESH_CANCEL_SCROLLING:
                if (pullHeader != null)
                    pullHeader.onRefreshCancelScrolling(scrollY);
                break;
            //上拉加载更多
            case UP_BEFORE:
                pullFooter.onUpBefore(scrollY);
                break;
            case UP_AFTER:
                pullFooter.onUpAfter(scrollY);
                break;
            case LOADMORE_SCROLLING:
                pullFooter.onLoadScrolling(scrollY);
                break;
            case LOADMORE_DOING:
                pullFooter.onLoadDoing(scrollY);
                listener.onLoadMore();
                break;
            case LOADMORE_COMPLETE_SCROLLING:
                pullFooter.onLoadCompleteScrolling(scrollY, isLoadSuccess);
                break;
            case LOADMORE_CANCEL_SCROLLING:
                pullFooter.onLoadCancelScrolling(scrollY);
                break;
        }

    }

    //默认状态
    private void onDefault() {
        isRefreshSuccess = false;
        isLoadSuccess = false;
        isIng = false;
    }

    //滚动到默认状态
    private void scrolltoDefaultStatus(final PullStatus startStatus) {
        int start = getScrollY();
        int end = 0;
        performAnim(start, end, new AnimListener() {
            @Override
            public void onDoing() {
                updateStatus(startStatus);
            }

            @Override
            public void onEnd() {
                updateStatus(DEFAULT);
                setVisivable();

            }
        });
    }

    //执行动画
    private void performAnim(int start, int end, final AnimListener listener) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.setDuration(SCROLL_TIME).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                scrollTo(0, value);
                postInvalidate();
                listener.onDoing();
            }
        });

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                listener.onEnd();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    interface AnimListener {
        void onDoing();

        void onEnd();
    }

    //停止刷新
    public void stopRefresh(boolean isSuccess) {
        isRefreshSuccess = isSuccess;
        scrolltoDefaultStatus(REFRESH_COMPLETE_SCROLLING);
    }

    //停止加载更多
    public void stopLoadMore(boolean isSuccess) {
        isLoadSuccess = isSuccess;
        scrolltoDefaultStatus(PullStatus.LOADMORE_COMPLETE_SCROLLING);
    }

    public PullHeader getPullHeader() {
        return pullHeader;
    }

    public void setPullHeader(PullHeader pullHeader) {
        this.pullHeader = pullHeader;
    }

    public PullFooter getPullFooter() {
        return pullFooter;
    }

    public void setPullFooter(PullFooter pullFooter) {
        this.pullFooter = pullFooter;
    }

    public abstract void setGone();

    public abstract void setVisivable();
}
