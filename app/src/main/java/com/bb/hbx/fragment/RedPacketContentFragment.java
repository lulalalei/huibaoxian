package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.cans.Can;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/27.
 */

public class RedPacketContentFragment extends BaseFragment {

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
                if (UnUsedInRedPaFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.redPFragmentList.get(Can.preFragmentPositionInRedP))
                            .show(UnUsedInRedPaFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,UnUsedInRedPaFragment.getInstance()).commit();
                }
                break;
            case 1:
                if (RecordInRedPaFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.redPFragmentList.get(Can.preFragmentPositionInRedP))
                            .show(RecordInRedPaFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,RecordInRedPaFragment.getInstance()).commit();
                }
                break;
            case 2:
                if (UnEfficientInRedPaFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.redPFragmentList.get(Can.preFragmentPositionInRedP))
                            .show(UnEfficientInRedPaFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,UnEfficientInRedPaFragment.getInstance()).commit();
                }
                break;
            default:
                break;
        }
        Can.preFragmentPositionInRedP=position;
    }
}
