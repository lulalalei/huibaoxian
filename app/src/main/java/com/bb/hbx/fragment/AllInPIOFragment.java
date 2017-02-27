package com.bb.hbx.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.activitiy.PerOrderDetailActivity;
import com.bb.hbx.adapter.MyAllInPIOAdapter;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.MyPIOederBean;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/12/26.
 */

public class AllInPIOFragment extends BaseFragment{

    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    GridLayoutManager manager;
    ArrayList<MyPIOederBean> totalList=new ArrayList<>();
    Context mContext;

    int pageIndex=1;
    MyAllInPIOAdapter myAllInPIOAdapter;
    private static AllInPIOFragment fragment;
    public static AllInPIOFragment getInstance()
    {
        if (fragment==null)
        {
            fragment=new AllInPIOFragment();
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
        manager = new GridLayoutManager(mContext, 1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(manager);
        myAllInPIOAdapter = new MyAllInPIOAdapter(totalList, mContext);
        recyclerView.setAdapter(myAllInPIOAdapter);
        if (totalList!=null&&totalList.size()>0)
        {
            totalList.clear();
        }
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getPolicies(MyApplication.user.getUserId(),"0","1","10");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
        for (int i = 0; i < 16; i++) {
            String title="户外运动保险计划:"+i;
            String number="订单号:"+i;
            String theInsured="被保险人:android,"+i;
            String insuranceHolder="投保人:ios,"+i;
            String time="保险期间:"+i;
            String state="全部";
            MyPIOederBean bean = new MyPIOederBean(title, number, theInsured, insuranceHolder, time, state);
            totalList.add(bean);
        }
        myAllInPIOAdapter.notifyDataSetChanged();
        myAllInPIOAdapter.setOnMyItemClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(int position) {
                //showTip("position:"+position);
                Intent intent = new Intent(mContext, PerOrderDetailActivity.class);
                startActivity(intent);
            }
        });
        //listView.setAdapter(myAllInPIOAdapter);

    }
}
