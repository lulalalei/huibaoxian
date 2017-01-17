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


        void getHomePageInfo(String userId, Callback callback);



    }


    interface View extends BaseView {


        void setAutuoBanner(boolean isAuto);

        void getfreshListData(List<Item> items);

        void stopRefresh();



    }

    abstract class Presenter extends BasePresenter<HomeContract.Model, HomeContract.View> {


        public abstract void getHomePageInfo();



        public abstract  GridLayoutManager.SpanSizeLookup getSpanSizeLookup();
    }
}
