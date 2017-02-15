package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.cans.Can;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/12.
 */

public class MyCustomContentFragment extends BaseFragment{

    Context mContext;
    @BindView(R.id.content_layout)
    LinearLayout content_layout;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_piorder_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        int position = bundle.getInt("position", -1);
        switch (position)
        {
            case 0:
                if (OrderRecordInMyCustomFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.myCustomFragmentList.get(Can.preFragmentPositionInMyCustom))
                            .show(OrderRecordInMyCustomFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,OrderRecordInMyCustomFragment.getInstance()).commit();
                }
                break;
            case 1:
                if (PresentRecordInMyCustomFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.myCustomFragmentList.get(Can.preFragmentPositionInMyCustom))
                            .show(PresentRecordInMyCustomFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,PresentRecordInMyCustomFragment.getInstance()).commit();
                }
                break;
            case 2:
                if (CustomInfoInMyCustomFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.myCustomFragmentList.get(Can.preFragmentPositionInMyCustom))
                            .show(CustomInfoInMyCustomFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,CustomInfoInMyCustomFragment.getInstance()).commit();
                }
                break;
            default:
                break;
        }
        Can.preFragmentPositionInMyCustom=position;
    }
}
