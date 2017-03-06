package com.bb.hbx.base.v;

import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.bean.TradeDetail;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/9.
 */

public interface OrderdetailsCarContract {


    interface Model extends BaseModel {


        void getTradeDetail(String userId, String tradeId, String detailId, String classType,Callback callback);

    }


    interface View extends BaseView {


        void getTradeDetail(TradeDetail detail);
    }

    abstract class Presenter extends BasePresenter<OrderdetailsCarContract.Model, OrderdetailsCarContract.View> {

        public abstract void getTradeDetail(String tradeId, String detailId,String classType);


    }
}
