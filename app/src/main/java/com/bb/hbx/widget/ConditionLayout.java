package com.bb.hbx.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bb.hbx.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bb.hbx.widget.ConditionLayout.STATE.FILTER;
import static com.bb.hbx.widget.ConditionLayout.STATE.PRICE_DOWN;
import static com.bb.hbx.widget.ConditionLayout.STATE.PRICE_NULL;
import static com.bb.hbx.widget.ConditionLayout.STATE.PRICE_UP;
import static com.bb.hbx.widget.ConditionLayout.STATE.SALE_DOWN;
import static com.bb.hbx.widget.ConditionLayout.STATE.SALE_NULL;
import static com.bb.hbx.widget.ConditionLayout.STATE.SALE_UP;

/**
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


    private int[] price_resIds = {R.drawable.grid_icon, R.drawable.center_icon};

    private int[] sale_resIds = {R.drawable.grid_icon, R.drawable.center_icon};

    private STATE[] price_state = {STATE.PRICE_NULL, STATE.PRICE_DOWN, STATE.PRICE_UP};


    private int type;



    private ConditionListener listener;


    public ConditionListener getListener() {
        return listener;
    }

    public void setListener(ConditionListener listener) {
        this.listener = listener;
    }

    public ConditionLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ConditionLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ConditionLayout(Context context) {
        super(context);
    }

    private void initView() {
        View view = View.inflate(ConditionLayout.this.getContext(), R.layout.condition, null);
        addView(view);
        ButterKnife.bind(this);
        lin_l1.setOnClickListener(this);
        lin_l2.setOnClickListener(this);
        lin_l3.setOnClickListener(this);
        stateUi(STATE.DEFAULT);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lin_l1:

                listener.priceListener(type);
                break;
            case R.id.lin_l2:
                listener.saleListener(type);
                break;
            case R.id.lin_l3:
                listener.filterListener(type);
                break;
        }
    }

    private interface ConditionListener {

        void priceListener(int operat);

        void saleListener(int operat);

        void filterListener(int operat);
    }


    private void stateUi(STATE state) {

        img_i1.setImageResource(-1);
        img_i2.setImageResource(-1);
        img_i3.setImageResource(-1);

        if (state == PRICE_NULL) {
            img_i1.setImageResource(-1);
        } else if (state == PRICE_DOWN) {
            img_i1.setImageResource(price_resIds[0]);
        } else if (state == PRICE_UP) {
            img_i1.setImageResource(price_resIds[1]);
        } else if (state == SALE_NULL) {
            img_i2.setImageResource(-1);
        } else if (state == SALE_DOWN) {
            img_i2.setImageResource(sale_resIds[0]);
        } else if (state == SALE_UP) {
            img_i2.setImageResource(sale_resIds[1]);
        } else if (state == FILTER) {

        } else {
            img_i1.setImageResource(-1);
            img_i2.setImageResource(-1);
            img_i3.setImageResource(-1);
        }


    }


    enum STATE {

        DEFAULT,

        PRICE_NULL,
        PRICE_DOWN,
        PRICE_UP,

        SALE_NULL,
        SALE_DOWN,
        SALE_UP,


        FILTER,


    }

}
