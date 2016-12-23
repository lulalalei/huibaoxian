package com.bb.hbx.widget;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bb.hbx.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fancl 自定义底部导航条.
 */

public class BottomBar extends LinearLayout implements View.OnClickListener {


    private Context mContext;

    private ChangeListener listener;


    private int currentTab = -1;

    @BindView(R.id.tab1)
    LinearLayout tab1;

    @BindView(R.id.tab2)
    LinearLayout tab2;

    @BindView(R.id.tab4)
    LinearLayout tab4;

    @BindView(R.id.tab5)
    LinearLayout tab5;


    @BindView(R.id.ivTab1)
    ImageView ivTab1;
    @BindView(R.id.tvTab1)
    TextView tvTab1;


    @BindView(R.id.ivTab2)
    ImageView ivTab2;
    @BindView(R.id.tvTab2)
    TextView tvTab2;

    @BindView(R.id.ivTab4)
    ImageView ivTab4;
    @BindView(R.id.tvTab4)
    TextView tvTab4;

    @BindView(R.id.ivTab5)
    ImageView ivTab5;
    @BindView(R.id.tvTab5)
    TextView tvTab5;


    public BottomBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public BottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    public BottomBar(Context context) {
        this(context, null, 0);
    }

    private void initView() {
       // View bar = View.inflate(mContext, R.layout.bottom_bar, this);

        LinearLayout bar = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.bottom_bar,null);
        LinearLayout.LayoutParams lp= new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        addView(bar,lp);
        ButterKnife.bind(this);
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab4.setOnClickListener(this);
        tab5.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab1:
                changeTab(0);
                break;
            case R.id.tab2:
                changeTab(1);
                break;
            case R.id.tab4:
                changeTab(2);
                break;
            case R.id.tab5:
                changeTab(3);
                break;

        }
    }

    private void setbottombcdefail() {
        ivTab1.setImageResource(R.drawable.day_icon);
        ivTab2.setImageResource(R.drawable.grid_icon);
        ivTab4.setImageResource(R.drawable.center_icon);
        ivTab5.setImageResource(R.drawable.center_icon);
//        tvTab1.setTextAppearance(this, R.style.TextAppear_Theme_cb6_Size12);
//        tvTab2.setTextAppearance(this, R.style.TextAppear_Theme_cb6_Size12);
//        tvTab4.setTextAppearance(this, R.style.TextAppear_Theme_cb6_Size12);
//        tvTab5.setTextAppearance(this, R.style.TextAppear_Theme_cb6_Size12);

    }


    public void changeTab(int tab) {
        if (currentTab != tab) {
            setbottombcdefail();
            switch (tab) {
                case 0:
//                    ivTab1.setImageResource(R.drawable.day1_icon);
//                    tvTab1.setTextAppearance(this, R.style.TextAppear_Theme_crn0_Size12);
                    break;
                case 1:
//                    ivTab2.setImageResource(R.drawable.grid1_icon);
//                    tvTab2.setTextAppearance(this, R.style.TextAppear_Theme_crn0_Size12);
                    break;
                case 2:
//                    ivTab4.setImageResource(R.drawable.center1_icon);
//                    tvTab4.setTextAppearance(this, R.style.TextAppear_Theme_crn0_Size12);
                    break;

                case 3:
//                    ivTab5.setImageResource(R.drawable.center1_icon);
//                    tvTab5.setTextAppearance(this, R.style.TextAppear_Theme_crn0_Size12);
                    break;


                default:
                    break;
            }
            if (listener != null) {
                listener.changeTab2(tab);

            }
            currentTab = tab;
        }
    }


    public interface ChangeListener {

        void changeTab2(int tab);

    }

    public ChangeListener getListener() {
        return listener;
    }

    public void setListener(ChangeListener listener) {
        this.listener = listener;
    }


}
