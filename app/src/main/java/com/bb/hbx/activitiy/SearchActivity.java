package com.bb.hbx.activitiy;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.BKItem;
import com.bb.hbx.bean.BannerBean;
import com.bb.hbx.bean.BobaoItem;
import com.bb.hbx.bean.HotSearchBean;
import com.bb.hbx.bean.ModleItem;
import com.bb.hbx.bean.SearchTitleBean;
import com.bb.hbx.bean.SearchTitleBean2;
import com.bb.hbx.provide.BannerProvide;
import com.bb.hbx.provide.HotSearchProvide;
import com.bb.hbx.provide.LishiSearchProvide;
import com.bb.hbx.provide.ModleItemProvide;
import com.bb.hbx.provide.SearchTitleProvide;
import com.bb.hbx.provide.SearchTitleProvide2;
import com.bb.hbx.widget.multitype.MultiTypeAdapter;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.KITKAT;
import static android.view.Window.FEATURE_NO_TITLE;
import static android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
import static android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;

/**
 * Created by Administrator on 2016/12/26.
 */

public class SearchActivity extends BaseActivity implements View.OnClickListener {


    private final String TAG=SearchActivity.class.getSimpleName();

    @BindView(R.id.tv_back)
    TextView tv_back;

    @BindView(R.id.rl_view)
    RecyclerView rl_view;

    private List<Item> items;


    private MultiTypeAdapter adapter;

    @Override
    public int getLayoutId() {

        return R.layout.activity_search;
    }

    @Override
    public void initView() {


        final GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Item item = items.get(position);

                if (item instanceof SearchTitleBean) {
                    return 4;
                } else if (item instanceof HotSearchBean) {
                    return 1;
                }
                return 5;
            }
        };
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        rl_view.setLayoutManager(layoutManager);
        //rl_view.addItemDecoration(new SpaceItemDecoration());


        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();
        adapter.register(SearchTitleBean.class, new SearchTitleProvide());
        adapter.register(HotSearchBean.class, new HotSearchProvide());
        adapter.register(SearchTitleBean2.class, new SearchTitleProvide2());
        adapter.register(HotSearchBean.class, new LishiSearchProvide());
        rl_view.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        tv_back.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        items = new ArrayList<>();
        items.add(new SearchTitleBean());

        for (int i = 0; i < 8; i++) {
            if(i%2==0) {
                items.add(new HotSearchBean("汇保险"));
            }else {
                items.add(new HotSearchBean("健康人寿"));
            }
        }

        adapter.setItems(items);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;
        }

    }


    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {


        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {


            int pos = parent.getChildAdapterPosition(view);

            if (items.get(pos) instanceof HotSearchBean) {
                outRect.top = getResources().getDimensionPixelOffset(R.dimen.y26);
                outRect.bottom = 0;

                outRect.right = 0;

                outRect.left = (MyApplication.widthPixels - (4 * getResources().getDimensionPixelOffset(R.dimen.x160)
                        + 2 * getResources().getDimensionPixelOffset(R.dimen.x36))) / 3;


                if (pos > 0 && (pos - 1) / 4 == 0) {
                    outRect.top = getResources().getDimensionPixelOffset(R.dimen.y36);
                }

                if (pos > 0 && (pos - 1) / 4 == 1) {
                    outRect.bottom = getResources().getDimensionPixelOffset(R.dimen.y36);
                }

                if (pos > 0 && (pos - 1) % 4 == 0) {
                    outRect.left = getResources().getDimensionPixelOffset(R.dimen.x36);
                }

                if (pos > 0 && (pos - 1) % 4 == 3) {
                    outRect.right = getResources().getDimensionPixelOffset(R.dimen.x36);
                }

                Log.i(TAG,"left:"+outRect.left);
                Log.i(TAG,"right:"+outRect.right);

            }


        }


    }
}
