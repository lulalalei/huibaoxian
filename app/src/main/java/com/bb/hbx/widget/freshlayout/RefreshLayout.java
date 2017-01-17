package com.bb.hbx.widget.freshlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import static com.baidu.location.h.j.v;

/**
 * Created by Administrator on 2016/12/16.
 */

public class RefreshLayout extends PullLayout {

    private View view;

    public RefreshLayout(Context context) {
        super(context);
    }

    public RefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setGone() {
        if(view!=null){
            view.setVisibility(View.GONE);
        }
    }

    @Override
    public void setVisivable() {
        if(view!=null){
            view.setVisibility(View.VISIBLE);
        }
    }


    public void setNeedLoadMore(boolean needLoadMore) {
        isNeedLoadMore = needLoadMore;
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }
    public void init() {
        HeaderView header = new HeaderView(getContext());
        FooterView footer = new FooterView(getContext());

        addHeader(header);
        addFooter(footer);

        setPullHeader(header);
        setPullFooter(footer);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
