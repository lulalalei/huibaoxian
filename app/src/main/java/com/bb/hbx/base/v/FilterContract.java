package com.bb.hbx.base.v;

import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.bean.TypeModel;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/9.
 */

public interface FilterContract {


    interface Model extends BaseModel {

        void getProductType(String parentId, Callback callback);


    }


    interface View extends BaseView {

        void initTitle(List<TypeModel> models);


    }

    abstract class Presenter extends BasePresenter<FilterContract.Model, FilterContract.View> {


    }
}
