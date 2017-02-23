package com.bb.hbx.base.p;

import android.os.Bundle;

import com.bb.hbx.activitiy.ConfirmpaymentActivity;
import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.ProductDetailContract;
import com.bb.hbx.bean.PayDetail;
import com.bb.hbx.bean.ProdectDetalRequest;
import com.bb.hbx.bean.ProductDetail;
import com.bb.hbx.bean.ProductParamDetail;
import com.bb.hbx.utils.AppManager;


/**
 * Created by fancl.
 */

public class ProductDetailPresenter extends ProductDetailContract.Presenter {


    private PostCallback postCallback;

    @Override
    public void onAttached() {

        postCallback = new PostCallback<ProductDetailContract.View>(mView) {
            @Override
            public void successCallback(Result_Api api) {

                if (api.getOutput() instanceof ProductParamDetail) {

                    ProductParamDetail detail = (ProductParamDetail) api.getOutput();
                    if (detail != null) {
                        mView.setProductDetail(detail);
                    }
                } else if (api.getOutput() instanceof PayDetail) {

                    PayDetail detail = (PayDetail) api.getOutput();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("content", detail);
                    AppManager.getInstance().showActivity(ConfirmpaymentActivity.class, bundle);
                }

            }

            @Override
            public void failCallback() {

            }
        };


    }


    @Override
    public void getProductDetail(String productId) {
        mModel.getProductDetail(productId, postCallback);
    }

    @Override
    public void applyTrade(ProdectDetalRequest request) {
        mModel.applyTrade(request, postCallback);
    }
}
