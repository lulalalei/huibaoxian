package com.bb.hbx.base.v;

import android.support.v7.widget.GridLayoutManager;

import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/9.
 */

public interface HomeActContract {


    interface Model extends BaseModel {


        void hasUpgradeRight(String userId, Callback callback);

    }


    interface View extends BaseView {


    }

    abstract class Presenter extends BasePresenter<HomeActContract.Model, HomeActContract.View> {


        public abstract void hasUpgradeRight();
    }
}
