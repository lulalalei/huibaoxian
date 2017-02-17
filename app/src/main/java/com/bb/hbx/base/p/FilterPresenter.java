package com.bb.hbx.base.p;


import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.FilterContract;
import com.bb.hbx.base.v.MallContract;
import com.bb.hbx.bean.TypeModel;


/**
 * Created by fancl.
 */

public class FilterPresenter extends FilterContract.Presenter {


    private PostCallback postCallback = new PostCallback<FilterContract.View>(mView) {


        @Override
        public void successCallback(Result_Api api) {

            if (api.getOutput() instanceof TypeModel) {
                TypeModel model = (TypeModel) api.getOutput();
                if (model.getTypeList() != null && model.getTypeList().size() > 0) {
                    mView.initTitle(model.getTypeList());
                }

            }
        }

        @Override
        public void failCallback() {

        }
    };


    @Override
    public void onAttached() {
        mModel.getProductType("0", postCallback);
    }

}
