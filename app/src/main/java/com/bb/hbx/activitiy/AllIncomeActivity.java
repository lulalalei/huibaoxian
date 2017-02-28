package com.bb.hbx.activitiy;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.adapter.MyAllIncomeAdapter;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.Account;
import com.bb.hbx.bean.GetTotalIncomeBean;
import com.bb.hbx.interfaces.OnItemClickListener;
import com.bb.hbx.utils.TimeUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllIncomeActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.scrollView)
    PullToRefreshScrollView scrollView;
    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.allIncome_tv)
    TextView allIncome_tv;
    GridLayoutManager manager;

    ArrayList<GetTotalIncomeBean.TotalIncomeListBean> totalList=new ArrayList<>();
    MyAllIncomeAdapter adapter;

    String currentTime="";
    String startTime="";
    int pageIndex=1;
    @Override
    public int getLayoutId() {
        return R.layout.activity_all_income;
    }

    @Override
    public void initView() {
        //showScore();
    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        scrollView.setMode(PullToRefreshBase.Mode.BOTH);
        scrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageIndex=1;
                showTotalIncomeList(pageIndex,startTime,currentTime);
                //showAccount();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageIndex++;
                showTotalIncomeList(pageIndex,startTime,currentTime);
            }
        });
    }

    @Override
    public void initdata() {
        manager = new GridLayoutManager(this, 1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(manager);
        adapter=new MyAllIncomeAdapter(totalList,this);
        recyclerView.setAdapter(adapter);
        currentTime= TimeUtils.getCurrentTime();//2017-02-27
        String[] timeBuf = currentTime.split("-");
        String singleYearCurrent = timeBuf[0];//2017
        String singleMonthCurrent = timeBuf[1];//02
        String singleDayCurrent = timeBuf[2];//24
        int singleYearCurrentInt = Integer.parseInt(singleYearCurrent);//2017
        int singleMonthCurrentInt = Integer.parseInt(singleMonthCurrent);//2
        int singleDayCurrentInt = Integer.parseInt(singleDayCurrent);//24
        int singleYearStartInt=singleYearCurrentInt;
        int singleMonthStartInt=0;
        for (int i = 1; i <=6; i++) {
            if (singleMonthCurrentInt==1)
            {
                singleMonthStartInt=12;
                singleMonthCurrentInt=12;
                singleYearStartInt=singleYearCurrentInt-1;
            }
            else
            {
                singleMonthStartInt=singleMonthCurrentInt--;
            }
        }
        startTime=singleYearStartInt+"-"+(singleMonthStartInt/10)+(singleMonthStartInt%10)+"-"+"01";
        showTotalIncomeList(pageIndex,startTime,currentTime);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(int position) {
                //Toast.makeText(AllIncomeActivity.this,"点击事件:"+position,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AllIncomeActivity.this, SpecialMonthActivity.class);
                intent.putExtra("specialMonth",totalList.get(position).getTradeTime());
                startActivity(intent);
            }
        });
    }

    private void showTotalIncomeList(final int pageIndex, String startTime, String currentTime) {
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getTotalIncome(MyApplication.user.getUserId(),"20",startTime,currentTime,pageIndex+"","10");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Result_Api body = (Result_Api) response.body();
                if (body!=null)
                {
                    GetTotalIncomeBean incomeBean = (GetTotalIncomeBean) body.getOutput();
                    if (incomeBean!=null)
                    {
                        if (pageIndex==1)
                        {
                            totalList.clear();
                        }
                        totalList.addAll(incomeBean.getTotalIncomeList());
                        String totalAmount = incomeBean.getTotalAmount();
                        int totalAmountInt=0;
                        if (!TextUtils.isEmpty(totalAmount))
                        {
                            totalAmountInt = Integer.parseInt(totalAmount);
                        }
                        allIncome_tv.setText(TextUtils.isEmpty(totalAmount)?"0.00":(totalAmountInt/100)+"."+(totalAmountInt/10%10)+(totalAmountInt%10));
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

    private void showScore() {
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getAccount(MyApplication.user.getUserId(),"20");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Result_Api body = (Result_Api) response.body();
                if (body!=null)
                {
                    Account account = (Account) body.getOutput();
                    if (account!=null)
                    {
                        String acctSum = account.getAcctSum();
                        int acctSumInt=0;
                        if (!TextUtils.isEmpty(acctSum))
                        {
                            acctSumInt = Integer.parseInt(acctSum);
                        }
                        allIncome_tv.setText(TextUtils.isEmpty(acctSum)?"0.00":(acctSumInt/100)+"."+(acctSumInt/10%10)+(acctSumInt%10));
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            default:
                break;
        }
    }
}
