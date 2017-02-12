package com.bb.hbx.base.p;

import com.bb.hbx.MyApplication;
import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.ProductDetailContract;
import com.bb.hbx.base.v.WelcomeContract;
import com.bb.hbx.bean.ProductDetail;
import com.bb.hbx.bean.User;
import com.bb.hbx.bean.VersionInfo;
import com.bb.hbx.utils.AppUtils;




/**
 * Created by fancl.
 */

public class WelcomePresenter extends WelcomeContract.Presenter {


    private PostCallback postCallback;

    @Override
    public void onAttached() {
        postCallback = new PostCallback<WelcomeContract.View>(mView) {
            @Override
            public void successCallback(Result_Api api) {

                if (api.getOutput() instanceof VersionInfo) {
                    VersionInfo info = (VersionInfo) api.getOutput();
                    mView.setVersionInfo(info);
                }

            }

            @Override
            public void failCallback() {
                VersionInfo info = new VersionInfo();
                info.setIataCodeVersion(AppUtils.getAppVersionName(MyApplication.getAppContext()));
                info.setLoop(0);
                info.setShowTime("" + System.currentTimeMillis());
                mView.setVersionInfo(info);

            }
        };


    }


    @Override
    public void settingUser() {
        User user = mModel.settingUser();
        mView.settingUser(user);
    }

    @Override
    public void getClientCtlInfo(String userId) {
        mModel.getClientCtlInfo(userId, postCallback);
    }
}
