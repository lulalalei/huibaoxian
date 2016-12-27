package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.cans.Can;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/12/26.
 */

public class PIOrderContentFragment extends BaseFragment{

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
        int position = bundle.getInt("position",-1);
        switch (position)
        {
            case 0:
                if (AllInPIOFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.pIOFragmentList.get(Can.preFragmentPositionInPIO))
                            .show(AllInPIOFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,AllInPIOFragment.getInstance()).commit();
                }

                break;
            case 1:
                if (UnPayInPIOFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.pIOFragmentList.get(Can.preFragmentPositionInPIO))
                            .show(UnPayInPIOFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,UnPayInPIOFragment.getInstance()).commit();
                }
                break;
            case 2:
                if (HadPaiedInPIOFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.pIOFragmentList.get(Can.preFragmentPositionInPIO))
                            .show(HadPaiedInPIOFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,HadPaiedInPIOFragment.getInstance()).commit();
                }
                break;
            case 3:
                if (UnEfficientInPIOFragment.getInstance().isAdded())
                {
                    getChildFragmentManager().beginTransaction().hide(Can.pIOFragmentList.get(Can.preFragmentPositionInPIO))
                            .show(UnEfficientInPIOFragment.getInstance()).commit();
                }
                else
                {
                    getChildFragmentManager().beginTransaction().add(R.id.content_layout,UnEfficientInPIOFragment.getInstance()).commit();
                }
                break;
            default:
                break;
        }
        Can.preFragmentPositionInPIO =position;
    }
}
