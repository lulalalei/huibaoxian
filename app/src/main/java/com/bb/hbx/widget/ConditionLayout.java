package com.bb.hbx.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bb.hbx.R;

import butterknife.BindView;
import butterknife.ButterKnife;


import static android.R.attr.type;
import static com.bb.hbx.widget.ConditionLayout.STATE.FILTER;
import static com.bb.hbx.widget.ConditionLayout.STATE.PRICE_DOWN;
import static com.bb.hbx.widget.ConditionLayout.STATE.PRICE_NULL;
import static com.bb.hbx.widget.ConditionLayout.STATE.PRICE_UP;
import static com.bb.hbx.widget.ConditionLayout.STATE.SALE_DOWN;
import static com.bb.hbx.widget.ConditionLayout.STATE.SALE_NULL;
import static com.bb.hbx.widget.ConditionLayout.STATE.SALE_UP;

/**
 * 筛选条件
 * Created by fancl on 2016/12/22.
 */

public class ConditionLayout extends LinearLayout implements View.OnClickListener {


    @BindView(R.id.lin_l1)
    LinearLayout lin_l1;

    @BindView(R.id.lin_l2)
    LinearLayout lin_l2;

    @BindView(R.id.lin_l3)
    LinearLayout lin_l3;


    @BindView(R.id.img_i1)
    ImageView img_i1;

    @BindView(R.id.img_i2)
    ImageView img_i2;

    @BindView(R.id.img_i3)
    ImageView img_i3;


    @BindView(R.id.tv_t1)
    TextView tv_t1;

    @BindView(R.id.tv_t2)
    TextView tv_t2;

    @BindView(R.id.tv_t3)
    TextView tv_t3;


    private int[] price_resIds = {R.drawable.paixu_xia, R.drawable.paixu_shang};


    private int[] sale_resIds = {R.drawable.paixu_xia, R.drawable.paixu_shang};

    private STATE[] price_state = {STATE.PRICE_DOWN, STATE.PRICE_UP, STATE.PRICE_NULL};

    private STATE[] allState;

    private int typeS = 0;

    private ConditionListener listener;


    private Context mContext;

    public ConditionListener getListener() {
        return listener;
    }

    public void setListener(ConditionListener listener) {
        this.listener = listener;
    }

    public ConditionLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    public ConditionLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ConditionLayout(Context context) {
        this(context, null, 0);
    }

    private void initView() {
        View view = View.inflate(ConditionLayout.this.getContext(), R.layout.condition, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        addView(view, lp);
        ButterKnife.bind(this);
        lin_l1.setOnClickListener(this);
        lin_l2.setOnClickListener(this);
        lin_l3.setOnClickListener(this);
        allState = STATE.values();

        stateUi(allState[typeS]);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lin_l1:
                if (typeS >= 3)
                    typeS = 1;
                else {
                    typeS++;
                }
                stateUi(allState[typeS]);
                //listener.priceListener(type);
                break;
            case R.id.lin_l2:

                if (typeS >= 3 && typeS < 6) {
                    typeS++;
                } else {
                    typeS = 4;
                }
                stateUi(allState[typeS]);
                //listener.saleListener(type);
                break;
            case R.id.lin_l3:
                //listener.filterListener(type);
                break;
        }
    }

    private interface ConditionListener {

        void priceListener(int operat);

        void saleListener(int operat);

        void filterListener(int operat);
    }


    private void stateUi(STATE state) {

        img_i1.setVisibility(View.INVISIBLE);
        img_i2.setVisibility(View.INVISIBLE);
        tv_t1.setTextAppearance(mContext, R.style.TextAppear_Theme_A4_Size14);
        tv_t2.setTextAppearance(mContext, R.style.TextAppear_Theme_A4_Size14);


        if (state == PRICE_NULL) {
            img_i1.setVisibility(View.INVISIBLE);
            tv_t1.setTextAppearance(mContext, R.style.TextAppear_Theme_A4_Size14);
        } else if (state == PRICE_DOWN) {
            img_i1.setVisibility(View.VISIBLE);
            img_i1.setImageResource(price_resIds[0]);
            tv_t1.setTextAppearance(mContext, R.style.TextAppear_Theme_A1_Size14);
        } else if (state == PRICE_UP) {
            img_i1.setVisibility(View.VISIBLE);
            img_i1.setImageResource(price_resIds[1]);
            tv_t1.setTextAppearance(mContext, R.style.TextAppear_Theme_A1_Size14);
        } else if (state == SALE_NULL) {
            img_i2.setVisibility(View.INVISIBLE);
            tv_t2.setTextAppearance(mContext, R.style.TextAppear_Theme_A4_Size14);
        } else if (state == SALE_DOWN) {
            img_i2.setVisibility(View.VISIBLE);
            img_i2.setImageResource(sale_resIds[0]);
            tv_t2.setTextAppearance(mContext, R.style.TextAppear_Theme_A1_Size14);
        } else if (state == SALE_UP) {
            img_i2.setVisibility(View.VISIBLE);
            img_i2.setImageResource(sale_resIds[1]);
            tv_t2.setTextAppearance(mContext, R.style.TextAppear_Theme_A1_Size14);
        } else if (state == FILTER) {

        }


    }


    public int getTypeS() {
        return typeS;
    }

    public void setTypeS(int typeS) {
        this.typeS = typeS % allState.length;
        stateUi(allState[typeS]);

    }

    enum STATE {

        DEFAULT,

        PRICE_DOWN,
        PRICE_UP,
        PRICE_NULL,


        SALE_DOWN,
        SALE_UP,
        SALE_NULL,


        FILTER;


    }

}
