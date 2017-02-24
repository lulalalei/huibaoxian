package com.bb.hbx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.onClick;
import static com.bb.hbx.R.drawable.check;
import static com.bb.hbx.R.drawable.on;
import static com.bb.hbx.utils.ShareSPUtils.mContext;

/**
 * Created by Administrator on 2017/1/20.
 */

public class ItemLayout extends LinearLayout {


    @BindView(R.id.tv_type)
    TextView tv_type;

    @BindView(R.id.iv_last)
    ImageView iv_last;

    @BindView(R.id.et_comm)
    EditText et_comm;

    @BindView(R.id.tv_comm)
    TextView tv_comm;


    private String left_name = "";//左边的标题

    private boolean isEdit;

    private String hint = "";

    private String text = "";

    private boolean isright_icon;

    private int right_icon;

    private int right_butIcon;


    private Context mContext;

    //-------------

    private boolean isOpen = true;

    private boolean isCheck;

    OnBtnListener listener;


    public void setListener(OnBtnListener listener) {
        this.listener = listener;
    }

    public ItemLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.ItemLayout, defStyleAttr, 0);

        left_name = a.getString(R.styleable.ItemLayout_left_name);
        isEdit = a.getBoolean(R.styleable.ItemLayout_isEdit, false);
        hint = a.getString(R.styleable.ItemLayout_hint);
        text = a.getString(R.styleable.ItemLayout_text);
        isright_icon = a.getBoolean(R.styleable.ItemLayout_isright_icon, false);
        right_icon = a.getResourceId(R.styleable.ItemLayout_right_icon, -1);
        right_butIcon = a.getResourceId(R.styleable.ItemLayout_right_butIcon, -1);
        isCheck = a.getBoolean(R.styleable.ItemLayout_isCheck, false);
        init();

    }

    private void init() {
        this.setOrientation(VERTICAL);
        View view = LayoutInflater.from(mContext).inflate(R.layout.line_item, this, false);
        addView(view);
        ButterKnife.bind(this);

        iv_last.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                iv_last.setImageResource(right_butIcon);
                if (listener != null) {
                    listener.onClick();
                }

            }
        });

        initData();
    }

    private void initData() {
        tv_type.setText(left_name);
        if (isEdit) {
            et_comm.setVisibility(View.VISIBLE);
        } else {
            tv_comm.setVisibility(View.VISIBLE);
        }

        et_comm.setHint(hint);
        tv_comm.setText(text);

        if (isright_icon) {
            iv_last.setImageResource(right_icon);
        }

    }

    public void setText(String text) {
        this.text = text;
        tv_comm.setText(text);
    }

    public void setdownImageResource() {
        iv_last.setImageResource(right_icon);
    }


    public String getEtValue() {
        return et_comm.getText().toString().trim();
    }


    public String getTextValue() {
        return tv_comm.getText().toString().trim();
    }

    public interface OnBtnListener {

        void onClick();
    }


}
