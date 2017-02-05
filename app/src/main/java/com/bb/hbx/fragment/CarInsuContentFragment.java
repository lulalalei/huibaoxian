package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.cans.Can;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/1/23.
 */

public class CarInsuContentFragment extends BaseFragment{

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
                if (AllInCarInsuFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.carIOFragmentList.get(Can.preFragmentPositionInCIO))
                            .show(AllInCarInsuFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,AllInCarInsuFragment.getInstance()).commit();
                }
                break;
            case 1:
                if (UnderSendInCarInsuFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.carIOFragmentList.get(Can.preFragmentPositionInCIO))
                            .show(UnderSendInCarInsuFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,UnderSendInCarInsuFragment.getInstance()).commit();
                }
                break;
            case 2:
                if (HadSentInCarInsuFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.carIOFragmentList.get(Can.preFragmentPositionInCIO))
                            .show(HadSentInCarInsuFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,HadSentInCarInsuFragment.getInstance()).commit();
                }
                break;
            case 3:
                if (HadStopInCarInsuFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.carIOFragmentList.get(Can.preFragmentPositionInCIO))
                            .show(HadStopInCarInsuFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,HadStopInCarInsuFragment.getInstance()).commit();
                }
                break;
            default:
                break;
        }
        Can.preFragmentPositionInCIO=position;
    }
}
