package com.bb.hbx.base.p;


import com.bb.hbx.activitiy.login.LoginContract;
import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.HomeContract;

/**
 * Created by Administrator on 2017/1/9.
 */

public class HomePresenter extends HomeContract.Presenter {


    private int topicListPageIndex = 1;

    private int topicListPageSize = 10;


    @Override
    public void onAttached() {

    }


    @Override
    public void getTopicList() {
        mModel.getTopicList(topicListPageIndex, topicListPageSize, new PostCallback<HomeContract.View>(mView) {
            @Override
            public void successCallback(Result_Api api) {

            }

            @Override
            public void failCallback() {

            }
        });
    }
}
