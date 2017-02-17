package com.bb.hbx.base.v;

import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.bean.TypeModel;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/9.
 */

public interface Filter_ItemContract {


    interface Model extends BaseModel {




    }


    interface View extends BaseView {




    }

    abstract class Presenter extends BasePresenter<Filter_ItemContract.Model, Filter_ItemContract.View> {


    }
}
