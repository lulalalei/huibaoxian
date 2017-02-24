package com.bb.hbx.base.p;

import com.bb.hbx.MyApplication;
import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.ConfimpaymentContract;
import com.bb.hbx.base.v.PolicydetailsContract;
import com.bb.hbx.bean.PayDetail;
import com.bb.hbx.bean.TradeDetail;

/**
 * Created by fancl.
 */

public class ConfimpaymentPresenter extends ConfimpaymentContract.Presenter {


    private PostCallback postCallback;


    @Override
    public void onAttached() {
        postCallback = new PostCallback<ConfimpaymentContract.View>(mView) {

            @Override
            public void successCallback(Result_Api api) {

                if (api.getOutput() instanceof TradeDetail) {



                }


            }

            @Override
            public void failCallback() {

            }
        };


    }


    @Override
    public void getPaySign(PayDetail request) {
        mModel.getPaySign(request,postCallback);
    }
}
