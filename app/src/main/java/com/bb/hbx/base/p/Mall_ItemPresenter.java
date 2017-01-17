package com.bb.hbx.base.p;


import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.MallContract;
import com.bb.hbx.base.v.Mall_ItemContract;
import com.bb.hbx.bean.ProductBean;
import com.bb.hbx.bean.RequestProduct;
import com.bb.hbx.bean.TypeModel;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fancl.
 */

public class Mall_ItemPresenter extends Mall_ItemContract.Presenter {


    private List<Item> items = new ArrayList<>();

    private static final int PAGE_SIZE = 10;//

    private int PAGE_INDEX = 1;//

    private RequestProduct rp;

    private PostCallback postCallback;

    private boolean isAlready = false;


    @Override
    public void onAttached() {
        postCallback = new PostCallback<Mall_ItemContract.View>(mView) {

            @Override
            public void successCallback(Result_Api api) {
                if (api.getOutput() instanceof ProductBean) {
                    ProductBean bean = (ProductBean) api.getOutput();
                    isAlready = true;
                    items.addAll(bean.getProductList());
                    mView.notfiy();
                }
            }

            @Override
            public void failCallback() {

            }
        };
        rp = new RequestProduct();
        rp.setPageIndex(PAGE_INDEX);
        rp.setPageSize(PAGE_SIZE);
        rp.setProductType(Integer.valueOf(mView.getTypeModel().getTypeId()));

    }


    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public List<Item> getList() {
        return items;
    }

    @Override
    public void getProducts() {
        if (isAlready) {
            mView.notfiy();
        } else {
            mModel.getProducts(rp, postCallback);
        }
    }


}
