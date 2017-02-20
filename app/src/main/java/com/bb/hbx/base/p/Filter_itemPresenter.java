package com.bb.hbx.base.p;


import android.support.v7.widget.GridLayoutManager;

import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.Filter_ItemContract;
import com.bb.hbx.bean.FilterBean;
import com.bb.hbx.bean.Filter_tileItem;
import com.bb.hbx.bean.Insurer;
import com.bb.hbx.bean.Product;
import com.bb.hbx.bean.ProductItem;
import com.bb.hbx.bean.TypeModel;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by fancl.
 */

public class Filter_itemPresenter extends Filter_ItemContract.Presenter {

    private List<Item> items = new LinkedList<>();

    private List<Insurer> insurers;


    private PostCallback postCallback = new PostCallback<Filter_ItemContract.View>(mView) {


        @Override
        public void successCallback(Result_Api api) {

            if (api.getOutput() instanceof FilterBean) {
                FilterBean bean = (FilterBean) api.getOutput();
                insurers = bean.getInsurerList();
                if (insurers == null || insurers.isEmpty()) {
                    return;
                }

                //insurers.addAll(insurers);
                Filter_tileItem item = new Filter_tileItem();
                item.setName("公司类型");
                if (insurers.size() > 8) {
                    item.setVisiber(true);
                    items.add(item);
                    items.addAll(insurers.subList(0, 8));
                } else {
                    item.setVisiber(false);
                    items.add(item);
                    items.addAll(insurers);
                }
                mView.notfiy();
                mView.stopRefresh();
            }
        }

        @Override
        public void failCallback() {
            mView.stopRefresh();
        }
    };

    public void openMore() {
        items.removeAll(insurers.subList(0, 8));
        items.addAll(insurers);
        mView.notfiy();
    }

    public void closeMore() {
        items.removeAll(insurers);
        items.addAll(insurers.subList(0, 8));
        mView.notfiy();
    }


    @Override
    public void onAttached() {

    }

    @Override
    public void getInsurers(TypeModel model, String type) {
        items.clear();
        mModel.getInsurers("0", "", type, postCallback);
    }

    @Override
    public List<Item> getList() {
        return items;
    }

}
