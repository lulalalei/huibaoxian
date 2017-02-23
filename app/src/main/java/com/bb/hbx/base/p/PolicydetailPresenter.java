package com.bb.hbx.base.p;

import com.bb.hbx.MyApplication;
import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.ActivitContract;
import com.bb.hbx.base.v.PolicydetailsContract;
import com.bb.hbx.bean.ActivitInfo;
import com.bb.hbx.bean.TradeDetail;
import com.bb.hbx.emus.DataLoadDirection;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fancl.
 */

public class PolicydetailPresenter extends PolicydetailsContract.Presenter {


    private PostCallback postCallback;


    @Override
    public void onAttached() {
        postCallback = new PostCallback<PolicydetailsContract.View>(mView) {

            @Override
            public void successCallback(Result_Api api) {

                if (api.getOutput() instanceof TradeDetail) {

                    mView.getTradeDetail((TradeDetail) api.getOutput());

                }


            }

            @Override
            public void failCallback() {

            }
        };


    }


    @Override
    public void getTradeDetail(String tradeId, String detailId) {
        mModel.getTradeDetail(MyApplication.user.getUserId(), tradeId, detailId, postCallback);
    }
}
