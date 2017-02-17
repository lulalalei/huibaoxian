package com.bb.hbx.base.v;

import android.support.v7.widget.GridLayoutManager;

import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.bean.ProductDetail;
import com.bb.hbx.bean.ProductParamDetail;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/9.
 */

public interface ProductDetailContract {


    interface Model extends BaseModel {

        void getProductDetail(String productId, Callback callback);



    }


    interface View extends BaseView {

        void setProductDetail(ProductParamDetail detail);

    }

    abstract class Presenter extends BasePresenter<ProductDetailContract.Model, ProductDetailContract.View> {

        public abstract void getProductDetail(String productId);

    }
}
