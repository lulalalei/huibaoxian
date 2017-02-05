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

public class MyOrderContentFragment extends BaseFragment{

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
                if (AllInMyOrderFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.myOrderFragmentList.get(Can.preFragmentPositionInMyOrder))
                            .show(AllInMyOrderFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,AllInMyOrderFragment.getInstance()).commit();
                }
                break;
            case 1:
                if (UnderPayInMyOrderFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.myOrderFragmentList.get(Can.preFragmentPositionInMyOrder))
                            .show(UnderPayInMyOrderFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,UnderPayInMyOrderFragment.getInstance()).commit();
                }
                break;
            case 2:
                if (HasFinishedInMyOrderFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.myOrderFragmentList.get(Can.preFragmentPositionInMyOrder))
                            .show(HasFinishedInMyOrderFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,HasFinishedInMyOrderFragment.getInstance()).commit();
                }
                break;
            default:
                break;
        }
        Can.preFragmentPositionInMyOrder=position;
    }
}
