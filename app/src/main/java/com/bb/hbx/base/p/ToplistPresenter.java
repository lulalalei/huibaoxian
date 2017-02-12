package com.bb.hbx.base.p;

import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;

import com.bb.hbx.base.v.TopicListContract;
import com.bb.hbx.emus.DataLoadDirection;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fancl.
 */

public class ToplistPresenter extends TopicListContract.Presenter {

    private List<Item> items = new ArrayList<>();
    private static final int PAGE_SIZE = 10;//
    private int PAGE_INDEX = 1;//
    private int loadType = DataLoadDirection.Refresh;
    private boolean isloadmore = true;//是否还有更多
    private PostCallback postCallback;


    @Override
    public void onAttached() {
        postCallback = new PostCallback<TopicListContract.View>(mView) {

            @Override
            public void successCallback(Result_Api api) {

            }

            @Override
            public void failCallback() {

            }
        };

    }


    @Override
    public List<Item> getList() {
        return items;
    }


    @Override
    public void getSpecials(int type) {
        loadType = type;
        if (loadType == DataLoadDirection.Refresh) {
            PAGE_INDEX = 1;
            mModel.getSpecials(PAGE_INDEX, PAGE_SIZE, postCallback);
        } else {
            if (isloadmore) {
                PAGE_INDEX++;
                mModel.getSpecials(PAGE_INDEX, PAGE_SIZE, postCallback);
            } else {
                mView.showMsg("没有数据啦...");
                mView.stopLoadMore();

            }

        }
    }
}
