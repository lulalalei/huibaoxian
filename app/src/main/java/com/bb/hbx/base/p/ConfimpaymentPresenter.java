package com.bb.hbx.base.p;

import com.bb.hbx.MyApplication;
import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.ConfimpaymentContract;
import com.bb.hbx.base.v.PolicydetailsContract;
import com.bb.hbx.bean.PayDetail;
import com.bb.hbx.bean.PaySign;
import com.bb.hbx.bean.TradeDetail;
import com.bb.hbx.utils.ZfbUtils;

import retrofit2.Callback;

import static android.view.View.Z;
import static com.bb.hbx.R.drawable.my;

/**
 * Created by fancl.
 */

public class ConfimpaymentPresenter extends ConfimpaymentContract.Presenter {


    private PostCallback postCallback;

    private String payPassword = "";


    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public String getPayPassword() {
        return payPassword;
    }

    @Override
    public void onAttached() {
        postCallback = new PostCallback<ConfimpaymentContract.View>(mView) {

            @Override
            public void successCallback(Result_Api api) {

                if (api.getOutput() instanceof PaySign) {
                    PaySign paySign = (PaySign) api.getOutput();
                    ZfbUtils.getInstance().startPay(paySign);
                } else {//
                    mView.dissDialog();
                }


            }

            @Override
            public void failCallback() {

            }
        };


    }


    @Override
    public void getPaySign(PayDetail detail) {
        mModel.getPaySign(detail, postCallback);
    }

    @Override
    public boolean isdialogshowisdialogshow() {
        return payPassword.isEmpty() ? true : false;
    }

    @Override
    public void verifyPayPwd(String payPwd) {
        mModel.verifyPayPwd(MyApplication.user.getUserId(), payPwd, postCallback);
    }


}
