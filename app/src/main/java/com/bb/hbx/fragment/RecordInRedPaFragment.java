package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.activitiy.RedPacketActivity;
import com.bb.hbx.adapter.MyRecordInRedPAdapter;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.GetUserCouponsListBean;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/12/27.
 */

public class RecordInRedPaFragment extends BaseFragment{

    Context mContext;
    @BindView(R.id.scrollView)
    PullToRefreshScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<GetUserCouponsListBean.CouponListBean> list=new ArrayList<>();
    GridLayoutManager manager;
    MyRecordInRedPAdapter adapter;

    int pageIndex=1;
    private static RecordInRedPaFragment fragment;
    public static RecordInRedPaFragment getInstance()
    {
        if (fragment==null)
        {
            fragment=new RecordInRedPaFragment();
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
        return R.layout.fragment_record_inredp_layout;
    }

    @Override
    public void initView() {
        scrollView.setMode(PullToRefreshBase.Mode.BOTH);
        scrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageIndex=1;
                showCouponsList(pageIndex);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageIndex++;
                showCouponsList(pageIndex);
            }
        });
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
        adapter = new MyRecordInRedPAdapter(mContext, list);
        recyclerView.setAdapter(adapter);
        if (list!=null&&list.size()>0)
        {
            list.clear();
        }
        showCouponsList(pageIndex);
    }

    private void showCouponsList(final int pageIndex) {
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getUserCouponsList(MyApplication.user.getUserId(),"2","0",pageIndex+"","10");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Result_Api body = (Result_Api) response.body();
                if (body!=null)
                {
                    GetUserCouponsListBean bean = (GetUserCouponsListBean) body.getOutput();
                    if (bean!=null)
                    {
                        //List<GetUserCouponsListBean.CouponListBean> couponList = bean.getCouponList();
                        if (pageIndex==1)
                        {
                            list.clear();
                        }
                        list.addAll(bean.getCouponList());
                        adapter.notifyDataSetChanged();
                        RedPacketActivity.resetLabRecord(mContext,bean.getTotalCount());
                    }
                }
                if (scrollView.isRefreshing())
                {
                    scrollView.onRefreshComplete();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
}
