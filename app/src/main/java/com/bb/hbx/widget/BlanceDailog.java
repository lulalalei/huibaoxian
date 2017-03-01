package com.bb.hbx.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.hbx.BaseDialog;
import com.bb.hbx.R;
import com.bb.hbx.activitiy.CheckIdentifyInForgerActivity;
import com.bb.hbx.activitiy.SetPayPwdActivity;
import com.bb.hbx.base.v.ConfimpaymentContract;
import com.bb.hbx.utils.AppManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.bb.hbx.R.id.iv_back;


/**
 * Created by fancl.
 */

public class BlanceDailog extends BaseDialog implements
        View.OnClickListener {


    private Unbinder unbinder;

    private Context mContext;


    @BindView(R.id.tv_cancel)
    TextView tv_cancel;
    @BindView(R.id.tv_setting)
    TextView tv_setting;


    /**
     * @param context 上下文
     */
    public BlanceDailog(Context context) {
        super(context, R.layout.blancedialog);
        mContext = context;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unbinder = ButterKnife.bind(this);
        init();


    }

    private void init() {
        setAnimation(R.style.Animation_Bottom_Dialog);
        setGravity(Gravity.CENTER);
        tv_cancel.setOnClickListener(this);
        tv_setting.setOnClickListener(this);

    }

    @Override
    protected int dialogWidth() {
        DisplayMetrics metric = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay()
                .getMetrics(metric);
        return metric.widthPixels - 2 * mContext.getResources().getDimensionPixelOffset(R.dimen.x46);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                this.dismiss();
                break;
            case R.id.tv_setting:
                AppManager.getInstance().showActivity(SetPayPwdActivity.class, null);
                this.dismiss();
                break;

        }
    }


}
