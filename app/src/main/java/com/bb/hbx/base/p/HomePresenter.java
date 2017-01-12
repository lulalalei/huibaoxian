package com.bb.hbx.base.p;


import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.HomeContract;
import com.bb.hbx.bean.HomePageInfo;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Administrator on 2017/1/9.
 */

public class HomePresenter extends HomeContract.Presenter {


    private int topicListPageIndex = 1;

    private int topicListPageSize = 10;

    private PostCallback postCallback = new PostCallback<HomeContract.View>(mView) {


        @Override
        public void successCallback(Result_Api api) {

            if (api.getOutput() instanceof HomePageInfo) {
                mView.setHomepageInfoData((HomePageInfo) api.getOutput());
            }
        }

        @Override
        public void failCallback() {

        }
    };


    @Override
    public void onAttached() {

    }


    @Override
    public void getHomePageInfo() {
        mModel.getHomePageInfo("", postCallback);
    }

    @Override
    public void getTopicList() {
        mModel.getTopicList(topicListPageIndex, topicListPageSize, postCallback);
    }
}
