package com.bb.hbx.base.v;

import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.bean.TypeModel;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/9.
 */

public interface Filter_ItemContract {


    interface Model extends BaseModel {

        void getInsurers(String parentId, String insurerId, String insurerType, Callback callback);

    }


    interface View extends BaseView {

        void notfiy();

        void stopRefresh();

    }

    abstract class Presenter extends BasePresenter<Filter_ItemContract.Model, Filter_ItemContract.View> {

        public abstract void getInsurers(TypeModel model, String type);

        public abstract List<Item> getList();

        public abstract void openMore();

        public abstract void closeMore();

    }
}
