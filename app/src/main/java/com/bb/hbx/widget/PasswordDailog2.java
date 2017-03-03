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
import com.bb.hbx.utils.AppManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by fancl.
 */

public class PasswordDailog2 extends BaseDialog implements
        View.OnClickListener {


    private Unbinder unbinder;

    private Context mContext;


    @BindView(R.id.iv_back)
    ImageView iv_back;

    @BindView(R.id.et_psd)
    EditText et_psd;


    @BindView(R.id.tv_forgetpsd)
    TextView tv_forgetpsd;

    //private ConfimpaymentContract.View view;

    public String password = "";

    public String getPassword() {
        return password;
    }


    /**
     * @param context 上下文
     */
    public PasswordDailog2(Context context/*, ConfimpaymentContract.View view*/) {
        super(context, R.layout.passworddialog2);
        mContext = context;
        //this.view = view;

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
        iv_back.setOnClickListener(this);
        tv_forgetpsd.setOnClickListener(this);
        et_psd.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if (!TextUtils.isEmpty(et_psd.getText())) {
                        password = et_psd.getText().toString().trim();
                        //view.getverifyPayPwd(password);
                    }
                }
                return true;
            }
        });
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
            case R.id.iv_back:
                this.dismiss();
                break;
            case R.id.tv_forgetpsd:
                AppManager.getInstance().showActivity(CheckIdentifyInForgerActivity.class, null);
                break;

        }
    }


}
