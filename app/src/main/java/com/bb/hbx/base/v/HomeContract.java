package com.bb.hbx.base.v;

import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/9.
 */

public interface HomeContract {


    interface Model extends BaseModel {

        //专题列表
        void getTopicList(int pageIndex, int pageSize, Callback callback);

    }


    interface View extends BaseView {


    }

    abstract class Presenter extends BasePresenter<HomeContract.Model, HomeContract.View> {

        public  abstract void getTopicList();

    }
}
