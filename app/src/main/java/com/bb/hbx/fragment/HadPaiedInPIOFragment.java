package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyHadPaiedInPIOAdapter;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.MyPIOederBean;

import java.util.ArrayList;

import butterknife.BindView;

/**我的--个险订单--中的 有效fragment 模块
 * Created by Administrator on 2016/12/26.
 */

public class HadPaiedInPIOFragment extends BaseFragment{

    @BindView(R.id.listView)
    ListView listView;

    ArrayList<MyPIOederBean> totalList=new ArrayList<>();
    Context mContext;
    MyHadPaiedInPIOAdapter myHadPaiedInPIOAdapter;
    private static HadPaiedInPIOFragment fragment;
    public static HadPaiedInPIOFragment getInstance()
    {
        if (fragment==null)
        {
            fragment=new HadPaiedInPIOFragment();
        }
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_all_inpio_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        for (int i = 0; i < 16; i++) {
            String title="户外运动保险计划:"+i;
            String number="订单号:"+i;
            String theInsured="被保险人:android,"+i;
            String insuranceHolder="投保人:ios,"+i;
            String time="保险期间:"+i;
            String state="待支付";
            MyPIOederBean bean = new MyPIOederBean(title, number, theInsured, insuranceHolder, time, state);
            totalList.add(bean);
        }
        myHadPaiedInPIOAdapter = new MyHadPaiedInPIOAdapter(totalList, mContext);
        listView.setAdapter(myHadPaiedInPIOAdapter);
    }
}
