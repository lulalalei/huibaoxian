package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.cans.Can;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/9.
 */

public class PresentInsuContentFragment extends BaseFragment{

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
                if (CanReceiveInPreInsuFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.presentInsuFragmentList.get(Can.preFragmentPositionInPresentInsu))
                            .show(CanReceiveInPreInsuFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,CanReceiveInPreInsuFragment.getInstance()).commit();
                }
                break;
            case 1:
                if (HasUsedInPreInsuFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.presentInsuFragmentList.get(Can.preFragmentPositionInPresentInsu))
                            .show(HasUsedInPreInsuFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,HasUsedInPreInsuFragment.getInstance()).commit();
                }
                break;
            case 2:
                if (OutofDateInPreInsuFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.presentInsuFragmentList.get(Can.preFragmentPositionInPresentInsu))
                            .show(OutofDateInPreInsuFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,OutofDateInPreInsuFragment.getInstance()).commit();
                }
                break;
            default:
                break;
        }
        Can.preFragmentPositionInPresentInsu=position;
    }
}
