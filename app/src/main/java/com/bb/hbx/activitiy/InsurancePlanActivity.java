package com.bb.hbx.activitiy;

import android.support.v4.view.ViewPager;

import com.bb.hbx.R;
import com.bb.hbx.adapter.CardPagerAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.BannerBean;
import com.bb.hbx.utils.ShadowTransformer;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/15.
 */

public class InsurancePlanActivity extends BaseActivity {


    @BindView(R.id.vp_tb)
    ViewPager vp_tb;

    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;

    private List<Item> mlist = new ArrayList<>();

    @Override
    public int getLayoutId() {
        initState();
        return R.layout.activit_insuranceplan;
    }

    @Override
    public void initView() {
        for (int i = 0; i < 3; i++) {
            Item item = new BannerBean();
            mlist.add(item);
        }

        mCardAdapter = new CardPagerAdapter(this, mlist);
        mCardShadowTransformer = new ShadowTransformer(vp_tb, mCardAdapter);
        mCardShadowTransformer.setCanAlpha(true);
        mCardAdapter.setTransformer(mCardShadowTransformer);
        // mCardShadowTransformer.setCanScale(true);

        vp_tb.setAdapter(mCardAdapter);
        mCardAdapter.setPager(vp_tb);
        vp_tb.setPageTransformer(false, mCardShadowTransformer);
        mCardShadowTransformer.setAlpha(0.6f, true);
        mCardShadowTransformer.setScale(0.1f,true);

        vp_tb.setCurrentItem(3);


    }

    @Override
    public void initListener() {

    }

    @Override
    public void initdata() {

    }
}
