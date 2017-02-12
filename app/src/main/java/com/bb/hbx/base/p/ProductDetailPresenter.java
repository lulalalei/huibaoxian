package com.bb.hbx.base.p;

import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.ProductDetailContract;
import com.bb.hbx.bean.ProductDetail;


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

                if (api.getOutput() instanceof ProductDetail) {

                    ProductDetail detail = (ProductDetail) api.getOutput();
                    if (detail != null) {
                        mView.setProductDetail(detail);
                    }
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
}
