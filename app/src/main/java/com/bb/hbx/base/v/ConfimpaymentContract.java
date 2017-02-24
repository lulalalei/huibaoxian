package com.bb.hbx.base.v;

import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.bean.PayDetail;
import com.bb.hbx.bean.TradeDetail;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/9.
 */

public interface ConfimpaymentContract {


    interface Model extends BaseModel {


        void getPaySign(PayDetail request, Callback callback);

    }


    interface View extends BaseView {


    }

    abstract class Presenter extends BasePresenter<ConfimpaymentContract.Model, ConfimpaymentContract.View> {

       public abstract void getPaySign(PayDetail request);
    }
}
