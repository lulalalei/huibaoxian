package com.bb.hbx.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.activitiy.OrderdetailsCarActivity;
import com.bb.hbx.activitiy.PolicydetailsActivity;
import com.bb.hbx.adapter.MyAllInMyOrderAdapter;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.GetTradesBean;
import com.bb.hbx.interfaces.OnItemClickListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/1/23.
 */

public class AllInMyOrderFragment extends BaseFragment{

    Context mContext;
    @BindView(R.id.scrollView)
    PullToRefreshScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    String path="https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
    List<GetTradesBean.TradeListBean> list=new ArrayList<>();
    GridLayoutManager manager;
    MyAllInMyOrderAdapter adapter;

    int pageIndex=1;
    private static AllInMyOrderFragment fragment;
    public static AllInMyOrderFragment getInstance()
    {
        if (fragment==null)
        {
            fragment=new AllInMyOrderFragment();
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
        return R.layout.fragment_all_inmyorder_layout;
    }

    @Override
    public void initView() {
        scrollView.setMode(PullToRefreshBase.Mode.BOTH);
        scrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageIndex=1;
                showTradesList(pageIndex);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageIndex++;
                showTradesList(pageIndex);
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
        adapter = new MyAllInMyOrderAdapter(mContext, list);
        recyclerView.setAdapter(adapter);
        if (list!=null&&list.size()>0)
        {
            list.clear();
        }
        showTradesList(pageIndex);
        //adapter.notifyDataSetChanged();
        adapter.setOnMyItemClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(int position) {
                Intent intent = new Intent();
                String tradeId = list.get(position).getTradeId();
                int classType = list.get(position).getClassType();
                if (1==classType)
                {
                    intent.setClass(mContext, OrderdetailsCarActivity.class);
                }
                else
                {
                    intent.setClass(mContext, PolicydetailsActivity.class);
                }
                Bundle bundle = new Bundle();
                bundle.putString("tradeId",tradeId);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void showTradesList(final int pageIndex) {
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getTrades(MyApplication.user.getUserId(),"0",pageIndex+"","10");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Result_Api body = (Result_Api) response.body();
                if (body!=null)
                {
                    GetTradesBean bean = (GetTradesBean) body.getOutput();
                    if (bean!=null)
                    {
                        //List<GetTradesBean.TradeListBean> tradeList = bean.getTradeList();
                        if (pageIndex==1)
                        {
                            list.clear();
                        }
                        list.addAll(bean.getTradeList());
                        adapter.notifyDataSetChanged();
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
