package com.bb.hbx.fragment;

;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bb.hbx.R;
import com.bb.hbx.activitiy.SearchActivity;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.base.m.HomeModle;
import com.bb.hbx.base.p.HomePresenter;
import com.bb.hbx.base.v.HomeContract;
import com.bb.hbx.bean.BKItem;
import com.bb.hbx.bean.BannerBean;
import com.bb.hbx.bean.BobaoItem;
import com.bb.hbx.bean.HomePageInfo;
import com.bb.hbx.bean.JxItem;
import com.bb.hbx.bean.ProductItem;
import com.bb.hbx.bean.ProductListBean;
import com.bb.hbx.bean.Special;
import com.bb.hbx.provide.BKItemProvide;
import com.bb.hbx.provide.BKchildItemProvide;
import com.bb.hbx.provide.BannerProvide;
import com.bb.hbx.provide.BobaoProvide;
import com.bb.hbx.provide.JxItemProvide;
import com.bb.hbx.provide.ModleItemProvide;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.widget.multitype.MultiTypeAdapter;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by Administrator on 2016/12/20.
 */

public class HomeFragment extends BaseFragment<HomePresenter, HomeModle> implements HomeContract.View, View.OnClickListener {


    @BindView(R.id.lin_bg)
    LinearLayout rel_tool;

    @BindView(R.id.lin_search)
    LinearLayout lin_search;


    @BindView(R.id.list)
    RecyclerView rc_list;

    private GridLayoutManager layoutManager;

    private MultiTypeAdapter adapter;

    private float mDistanceY;

    private float endOffset;


    private BannerProvide bannerProvide;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        rel_tool.getBackground().mutate().setAlpha(0);//toolbar透明度初始化为0
        layoutManager = new GridLayoutManager(getActivity(), 5);


        layoutManager.setSpanSizeLookup(mPresenter.getSpanSizeLookup());
        rc_list.setLayoutManager(layoutManager);

        endOffset = getResources().getDimensionPixelOffset(R.dimen.y500) -
                rel_tool.getHeight();
        rc_list.addOnScrollListener(new RecyclerView.OnScrollListener() {


            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                //滑动的距离
                mDistanceY += dy;

                if (mDistanceY == 0) {
                    rel_tool.getBackground().mutate().setAlpha(0);
                } else if (mDistanceY > 0 && mDistanceY < endOffset) {
                    float precent = mDistanceY / endOffset;
                    int alpha = Math.round(precent * 255);
                    rel_tool.getBackground().mutate().setAlpha(alpha);
                    if (alpha > 125) {
                        lin_search.setBackgroundResource(R.drawable.shape_alpha_a6);
                    } else {
                        lin_search.setBackgroundResource(R.drawable.shape_alpha_white);
                    }
                } else if (mDistanceY >= endOffset) {
                    rel_tool.getBackground().mutate().setAlpha(255);

                }

            }
        });

        lin_search.setOnClickListener(this);


    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();
        bannerProvide = new BannerProvide();
        adapter.register(BannerBean.class, bannerProvide);
        adapter.register(ProductItem.class, new ModleItemProvide());
        adapter.register(BobaoItem.class, new BobaoProvide());
        adapter.register(BKItem.class, new BKItemProvide());
        adapter.register(ProductListBean.class, new BKchildItemProvide(getActivity()));
        adapter.register(Special.class, new JxItemProvide(getActivity()));
        rc_list.setAdapter(adapter);


//        b = new BannerBean();
//        items = new ArrayList<>();
//        items.add(b);

//        items.add(new ModleItem(R.drawable.chexian, "车险"));
//        items.add(new ModleItem(R.drawable.renshouxian, "人寿险"));
//        items.add(new ModleItem(R.drawable.jiankangxian, "健康险"));
//        items.add(new ModleItem(R.drawable.yiwaixian, "意外险"));
//        items.add(new ModleItem(R.drawable.caichanxian, "财产险"));
//
//        List<String> list1 = new ArrayList<>();
//        list1.add("今天是星期一" + 111);
//        list1.add("今天是星期二" + 222);
//        list1.add("今天是星期三" + 333);
//        list1.add("今天是星期四" + 444);
//        items.add(new BobaoItem(list1));
//
//        items.add(new BKItem(R.drawable.baokuantuijian));
//
//        BKchildItem item = new BKchildItem();
//        item.setRedId(R.drawable.holder);
//        item.setSafe_name("健康保险");
//        item.setSafe_detail("超值保险/全国通赔1");
//        item.setSafe_price("￥2300");
//        item.setSafe_add("推广费1");
//        items.add(item);
//
//        item = new BKchildItem();
//        item.setRedId(R.drawable.holder);
//        item.setSafe_name("社会保险");
//        item.setSafe_detail("超值保险/全国通赔2");
//        item.setSafe_price("￥2400");
//        item.setSafe_add("推广费2");
//        items.add(item);
//
//        item = new BKchildItem();
//        item.setRedId(R.drawable.holder);
//        item.setSafe_name("社会保险1");
//        item.setSafe_detail("超值保险/全国通赔3");
//        item.setSafe_price("￥2500");
//        item.setSafe_add("推广费3");
//        items.add(item);
//
//        item = new BKchildItem();
//        item.setRedId(R.drawable.holder);
//        item.setSafe_name("社会保险2");
//        item.setSafe_detail("超值保险/全国通赔4");
//        item.setSafe_price("￥2600");
//        item.setSafe_add("推广费4");
//        items.add(item);
//
//        item = new BKchildItem();
//        item.setRedId(R.drawable.holder);
//        item.setSafe_name("社会保险3");
//        item.setSafe_detail("超值保险/全国通赔4");
//        item.setSafe_price("￥2600");
//        item.setSafe_add("推广费4");
//        items.add(item);
//
//        item = new BKchildItem();
//        item.setRedId(R.drawable.holder);
//        item.setSafe_name("社会保险4");
//        item.setSafe_detail("超值保险/全国通赔4");
//        item.setSafe_price("￥2600");
//        item.setSafe_add("推广费4");
//        item.setLine(false);
//        items.add(item);
//        items.add(new BKItem(R.drawable.jingxuanzhuanti));
//
//
//        List<SafeKind_Item> its = new ArrayList<>();
//        SafeKind_Item safeKind_item = new SafeKind_Item("家庭意外保险1", "买5W赔10w", "￥3000", R.drawable.holder);
//        its.add(safeKind_item);
//        SafeKind_Item safeKind_item1 = new SafeKind_Item("家庭意外保险2", "买5W赔10w", "￥3000", R.drawable.holder);
//        its.add(safeKind_item1);
//
//
//       JxItem jxItem = new JxItem(R.drawable.holder, its);
//
//
//        List<JxItem> jxItems = new ArrayList<>();
//        jxItems.add(jxItem);
//        jxItems.add(jxItem);
//
//
//        items.addAll(jxItems);
//        adapter.setItems(items);


        mPresenter.getHomePageInfo();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lin_search:
                AppManager.getInstance().showActivity(SearchActivity.class, null);
                break;
        }
    }

    @Override
    public void setAutuoBanner(boolean isAuto) {
        bannerProvide.setmAutoPlayAble(isAuto);
    }

    @Override
    public void getfreshListData(List<Item> items) {
        adapter.setItems(items);
        adapter.notifyDataSetChanged();


    }


}
