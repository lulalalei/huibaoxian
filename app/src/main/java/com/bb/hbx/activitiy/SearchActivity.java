package com.bb.hbx.activitiy;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.BannerBean;
import com.bb.hbx.bean.ModleItem;
import com.bb.hbx.bean.SearchTitleBean;
import com.bb.hbx.provide.BannerProvide;
import com.bb.hbx.provide.ModleItemProvide;
import com.bb.hbx.provide.SearchTitleProvide;
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


    @BindView(R.id.tv_back)
    TextView tv_back;

    @BindView(R.id.rl_view)
    RecyclerView rl_view;

    private List<Item> items;


    private MultiTypeAdapter adapter;

    @Override
    public int getLayoutId() {
        // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }


        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();
        adapter.register(SearchTitleBean.class, new SearchTitleProvide());


    }

    @Override
    public void initListener() {
        tv_back.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        items = new ArrayList<>();
        items.add(new SearchTitleBean());

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
}
