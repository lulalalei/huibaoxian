package com.bb.hbx.base.p;


import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.HomeContract;
import com.bb.hbx.base.v.MallContract;
import com.bb.hbx.bean.BannerBean;
import com.bb.hbx.bean.BobaoItem;
import com.bb.hbx.bean.HomePageInfo;
import com.bb.hbx.bean.TypeModel;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

import static com.baidu.location.h.j.m;

/**
 * Created by fancl.
 */

public class MallPresenter extends MallContract.Presenter {


    private PostCallback postCallback = new PostCallback<MallContract.View>(mView) {


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
