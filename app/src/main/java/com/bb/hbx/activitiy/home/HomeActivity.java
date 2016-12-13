package com.bb.hbx.activitiy.home;

import android.content.Context;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.adapter.ListAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.BKItem;
import com.bb.hbx.bean.BKchildItem;
import com.bb.hbx.bean.BannerBean;
import com.bb.hbx.bean.BobaoItem;
import com.bb.hbx.bean.ModleItem;
import com.bb.hbx.provide.BKItemProvide;
import com.bb.hbx.provide.BKchildItemProvide;
import com.bb.hbx.provide.BannerProvide;
import com.bb.hbx.provide.BobaoProvide;
import com.bb.hbx.provide.ModleItemProvide;
import com.bb.hbx.widget.TitleListview;
import com.bb.hbx.widget.multitype.MultiTypeAdapter;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


import butterknife.BindView;
import butterknife.internal.Utils;

/**
 * Created by Administrator on 2016/12/12.
 */

public class HomeActivity extends BaseActivity {


    List<Item> items;

    @BindView(R.id.list)
    RecyclerView rc_list;

    private MultiTypeAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 5);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Item item = items.get(position);

               if(item instanceof BannerBean){
                   return 5;
               }else if(item instanceof ModleItem){
                   return 1;
               }else if(item instanceof BobaoItem){
                   return 5;
               }else if(item instanceof BKItem) {
                   return 5;
               }
                return 5;
            }
        };
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        rc_list.setLayoutManager(layoutManager);

    }

    @Override
    public void initdata() {
        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();
        adapter.register(BannerBean.class, new BannerProvide());
        adapter.register(ModleItem.class, new ModleItemProvide());
        adapter.register(BobaoItem.class, new BobaoProvide());
        adapter.register(BKItem.class, new BKItemProvide());
        adapter.register(BKchildItem.class, new BKchildItemProvide());
        rc_list.setAdapter(adapter);
        BannerBean b = new BannerBean();
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.holder);
        list.add(R.drawable.holder);
        list.add(R.drawable.holder);
        list.add(R.drawable.holder);
        list.add(R.drawable.holder);
        list.add(R.drawable.holder);
        b.setList(list);
        items = new ArrayList<>();
        items.add(b);
        items.add(new ModleItem(R.mipmap.ic_launcher, "1"));
        items.add(new ModleItem(R.mipmap.ic_launcher, "2"));
        items.add(new ModleItem(R.mipmap.ic_launcher, "3"));
        items.add(new ModleItem(R.mipmap.ic_launcher, "4"));
        items.add(new ModleItem(R.mipmap.ic_launcher, "5"));

        List<String>list1=new ArrayList<>();
        list1.add("今天是星期一"+111);
        list1.add("今天是星期二"+222);
        list1.add("今天是星期三"+333);
        list1.add("今天是星期四"+444);
        items.add(new BobaoItem(list1));
        items.add(new BKItem());

        BKchildItem item=new BKchildItem();
        item.setRedId(R.drawable.holder);
        item.setSafe_name("健康保险");
        item.setSafe_detail("超值保险/全国通赔1");
        item.setSafe_price("￥2300");
        item.setSafe_add("推广费1");
        items.add(item);

        item=new BKchildItem();
        item.setRedId(R.drawable.holder);
        item.setSafe_name("社会保险");
        item.setSafe_detail("超值保险/全国通赔2");
        item.setSafe_price("￥2400");
        item.setSafe_add("推广费2");
        items.add(item);

        item=new BKchildItem();
        item.setRedId(R.drawable.holder);
        item.setSafe_name("社会保险1");
        item.setSafe_detail("超值保险/全国通赔3");
        item.setSafe_price("￥2500");
        item.setSafe_add("推广费3");
        items.add(item);

        item=new BKchildItem();
        item.setRedId(R.drawable.holder);
        item.setSafe_name("社会保险2");
        item.setSafe_detail("超值保险/全国通赔4");
        item.setSafe_price("￥2600");
        item.setSafe_add("推广费4");
        items.add(item);

        item=new BKchildItem();
        item.setRedId(R.drawable.holder);
        item.setSafe_name("社会保险3");
        item.setSafe_detail("超值保险/全国通赔4");
        item.setSafe_price("￥2600");
        item.setSafe_add("推广费4");
        items.add(item);

        item=new BKchildItem();
        item.setRedId(R.drawable.holder);
        item.setSafe_name("社会保险4");
        item.setSafe_detail("超值保险/全国通赔4");
        item.setSafe_price("￥2600");
        item.setSafe_add("推广费4");
        items.add(item);
        items.add(new BKItem());
        adapter.setItems(items);


    }


}
