package com.bb.hbx.base.v;

import android.support.v7.widget.GridLayoutManager;

import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.bean.HomePageInfo;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/9.
 */

public interface HomeContract {


    interface Model extends BaseModel {


        void getMsgs(String userId, String msgType, String sts, int pageIndex, int pageSize,
                     Callback callback);


        void getBannerInfo(Callback callback);

        void getXhbMessageInfo(Callback callback);

        void getHomePageProductType(Callback callback);

        void getHomePageProductList(Callback callback);

        void getUnReadMessageCount(String userId, Callback callback);

    }


    interface View extends BaseView {

        void getfreshListData(List<Item> items);

        void notfiy();

        void stopRefresh();

        void setMsgCount(int count);


    }

    abstract class Presenter extends BasePresenter<HomeContract.Model, HomeContract.View> {


        public abstract void getHomePageInfo();

        public abstract void getMsgs();

        public abstract List<Item> getListItems();


        public abstract GridLayoutManager.SpanSizeLookup getSpanSizeLookup();
    }
}
