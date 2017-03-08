package com.bb.hbx.base.p;




import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.HomeActContract;


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
