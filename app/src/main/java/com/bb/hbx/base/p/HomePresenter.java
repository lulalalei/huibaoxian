package com.bb.hbx.base.p;


import android.support.v7.widget.GridLayoutManager;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.HomeContract;
import com.bb.hbx.bean.BKItem;
import com.bb.hbx.bean.BannerBean;
import com.bb.hbx.bean.BobaoItem;
import com.bb.hbx.bean.HomePageInfo;
import com.bb.hbx.bean.ProductItem;
import com.bb.hbx.bean.ProductListBean;
import com.bb.hbx.bean.Special;
import com.bb.hbx.utils.Constants;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fancl.
 */

public class HomePresenter extends HomeContract.Presenter {


    private List<Item> items;

    private BannerBean bannerBean;

    private int topicListPageIndex = 1;

    private int topicListPageSize = 10;

    private PostCallback postCallback;


    @Override
    public void onAttached() {
        items = new ArrayList<>();
        postCallback = new PostCallback<HomeContract.View>(mView) {

            @Override
            public void successCallback(Result_Api api) {
                mView.stopRefresh();
                if (api.getOutput() instanceof HomePageInfo) {
                    HomePageInfo info = (HomePageInfo) api.getOutput();
                    mView.setAutuoBanner("1".equals(info.getLoop()) ? true : false);
                    dealWith(info);

                }
            }

            @Override
            public void failCallback() {
                mView.stopRefresh();
            }
        };

    }


    private void dealWith(HomePageInfo info) {


        items.clear();

        //banner
        bannerBean = new BannerBean();
        bannerBean.setList(info.getAds());
        items.add(bannerBean);

        //险种Item
        if (info.getProductType() == null && info.getProductType().isEmpty()) {
            //// TODO: 2017/1/13
        } else {
            items.addAll(info.getProductType());
        }

        //小汇报
        if (MyApplication.user.getIsBClient()) {
            BobaoItem bobaoItem = new BobaoItem();
            bobaoItem.setList(info.getXhbMsgList());
            items.add(bobaoItem);
        }

        //爆款推荐专题
        items.add(new BKItem(R.drawable.baokuantuijian));


        //爆款推荐的产品
        List<Special> specialList = info.getSpecialList();
        List<Special> jxLists = new ArrayList<>();
        for (Special special : specialList) {
            if (special.getSpecialType() == Constants.BKTJ) {
                List<ProductListBean> beanList = special.getProductList();
                beanList.get(beanList.size() - 1).setLine(false);
                items.addAll(beanList);
            } else {
                jxLists.add(special);
            }
        }

        //精选专题
        items.add(new BKItem(R.drawable.jingxuanzhuanti));
        items.addAll(jxLists);
        mView.getfreshListData(items);


    }


    @Override
    public void getHomePageInfo() {
        mModel.getHomePageInfo("0", postCallback);
    }

    @Override
    public void getMsgs() {
        mModel.getMsgs(MyApplication.user.getUserId(), "1", "1", 1, 99, postCallback);
    }


    @Override
    public GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Item item = items.get(position);
                if (item instanceof ProductItem) {
                    return 1;
                }
                return 5;
            }
        };
        return spanSizeLookup;
    }
}
