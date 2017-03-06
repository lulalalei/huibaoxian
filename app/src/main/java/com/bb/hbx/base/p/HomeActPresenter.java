package com.bb.hbx.base.p;


import android.support.v7.widget.GridLayoutManager;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.HomeActContract;
import com.bb.hbx.base.v.HomeContract;
import com.bb.hbx.bean.BKItem;
import com.bb.hbx.bean.BannerBean;
import com.bb.hbx.bean.BobaoItem;
import com.bb.hbx.bean.MsgInfo;
import com.bb.hbx.bean.ProductItem;
import com.bb.hbx.bean.ProductListBean;
import com.bb.hbx.bean.Special;
import com.bb.hbx.utils.Constants;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fancl.
 */

public class HomeActPresenter extends HomeActContract.Presenter {


    private PostCallback postCallback;


    @Override
    public void onAttached() {

        postCallback = new PostCallback<HomeActContract.View>(mView, false) {

            @Override
            public void successCallback(Result_Api api) {

                if (api.isSuccess()) {
                    mView.updateViewWithCToBTip();
                }

            }

            @Override
            public void failCallback() {
                mView.updateViewWithCToBTip();
            }
        };


    }


    @Override
    public void hasUpgradeRight() {
        mModel.hasUpgradeRight(MyApplication.user.getUserId(), postCallback);
    }

    @Override
    public void updateUpgradeB() {
        mModel.updateUpgradeB(MyApplication.user.getUserId(), new PostCallback() {
            @Override
            public void successCallback(Result_Api api) {
                if (api.isSuccess()) {

                }
            }

            @Override
            public void failCallback() {

            }
        });
    }
}
