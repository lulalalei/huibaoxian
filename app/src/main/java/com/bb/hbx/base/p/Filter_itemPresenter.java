package com.bb.hbx.base.p;


import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.FilterContract;
import com.bb.hbx.base.v.Filter_ItemContract;
import com.bb.hbx.bean.TypeModel;


/**
 * Created by fancl.
 */

public class Filter_itemPresenter extends Filter_ItemContract.Presenter {


    private PostCallback postCallback = new PostCallback<Filter_ItemContract.View>(mView) {


        @Override
        public void successCallback(Result_Api api) {

            if (api.getOutput() instanceof TypeModel) {


            }
        }

        @Override
        public void failCallback() {

        }
    };


    @Override
    public void onAttached() {
        //mModel.getProductType("0", postCallback);
    }

}
