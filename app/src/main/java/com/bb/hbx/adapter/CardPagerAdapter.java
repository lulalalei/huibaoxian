package com.bb.hbx.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bb.hbx.R;
import com.bb.hbx.utils.ShadowTransformer;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.bb.hbx.R.id.cardView;


public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private ShadowTransformer transformer;

    private List<CardView> mViews;
    public Context mContext;

    public List<Item> mData;
    private float mBaseElevation;

    private ViewPager pager;

    public ViewPager getPager() {
        return pager;
    }

    public void setPager(ViewPager pager) {
        this.pager = pager;
    }

    public CardPagerAdapter(Context context, List<Item> list) {
        mContext = context;
        mViews = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            mViews.add(null);
        }
        this.mData = list;
    }

    public ShadowTransformer getTransformer() {
        return transformer;
    }

    public void setTransformer(ShadowTransformer transformer) {
        this.transformer = transformer;
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position % mData.size());
    }

    @Override
    public int getRealCount() {
        return mData.size();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        Log.i("fancl", "position:" + position);
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.layout_insure_add, container, false);
        container.addView(view);

        CardView cardView = (CardView) view.findViewById(R.id.cardView);




        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) mOnItemClickListener.onClick(position);
            }
        });
        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position % mData.size(), cardView);

        //final Item item=mData.get(position);
//        mIcon.setImageResource(item.getImg());
//        mName.setText(item.getName());
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }

    OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
