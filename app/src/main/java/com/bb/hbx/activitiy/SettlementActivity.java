package com.bb.hbx.activitiy;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.adapter.MySettlementAdapter;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.Account;
import com.bb.hbx.bean.GetAcctSettSumBean;
import com.bb.hbx.utils.TimeUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
* 点击 我的--我的资产--结算中 显示的页面*/
public class SettlementActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.menu_iv)
    ImageView menu_iv;

    @BindView(R.id.scrollView)
    PullToRefreshScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.settlement_tv)
    TextView settlement_tv;
    GridLayoutManager manager;

    List<GetAcctSettSumBean.SettSumListBean> totalList=new ArrayList<>();
    MySettlementAdapter adapter;

    String currentTime="";
    String startTime="";
    int pageIndex=1;
    @Override
    public int getLayoutId() {
        return R.layout.activity_settlement;
    }

    @Override
    public void initView() {
        //showAccount();
    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        menu_iv.setOnClickListener(this);
        scrollView.setMode(PullToRefreshBase.Mode.BOTH);
        scrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageIndex=1;
                showSettlementList(pageIndex,startTime,currentTime);
                //showAccount();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageIndex++;
                showSettlementList(pageIndex,startTime,currentTime);
            }
        });
    }

    @Override
    public void initdata() {
        long monthFirstDay = TimeUtils.getMonthFirstDay();
        String dateToString = TimeUtils.getDateNoHourToString(monthFirstDay);//得到当前月初时间  2017-02-01
        currentTime = TimeUtils.getCurrentTime();//2017-02-24
        long currentLogTime = TimeUtils.getStringToDateHaveSecondAndSpace(currentTime+" 00:00:00");
        String[] timeBuf = currentTime.split("-");
        String singleYearCurrent = timeBuf[0];//2017
        String singleMonthCurrent = timeBuf[1];//02
        String singleDayCurrent = timeBuf[2];//24
        int singleYearCurrentInt = Integer.parseInt(singleYearCurrent);//2017
        int singleMonthCurrentInt = Integer.parseInt(singleMonthCurrent);//2
        int singleDayCurrentInt = Integer.parseInt(singleDayCurrent);//24
        int singleYearStartInt=0;
        int singleMonthStartInt=0;
        //int singleDayStartInt=1;
        if (singleMonthCurrentInt==1)
        {
            singleMonthStartInt=12;
            singleYearStartInt=singleYearCurrentInt-1;
        }
        else
        {
            singleMonthStartInt=singleMonthCurrentInt-1;
            singleYearStartInt=singleYearCurrentInt;
        }
        startTime=singleYearStartInt+"-"+(singleMonthStartInt/10)+(singleMonthStartInt%10)+"-"+"01";
        manager = new GridLayoutManager(this, 1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(manager);
        adapter = new MySettlementAdapter(totalList,this,currentLogTime,singleMonthCurrent);
        recyclerView.setAdapter(adapter);
        /*Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        //String startTime=year+"-"+(month+1)+"-"+(day-15);
        String endTime=year+"-"+month+"-"+(day-15);*/
        showSettlementList(pageIndex,startTime,currentTime);

    }

    private void showAccount() {
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
                        String acctSettSum = account.getAcctSettSum();//结算中
                        int acctSettSumInt=0;
                        if (!TextUtils.isEmpty(acctSettSum))
                        {
                            acctSettSumInt = Integer.parseInt(acctSettSum);
                        }
                        settlement_tv.setText(TextUtils.isEmpty(acctSettSum)?"0.00":(acctSettSumInt/100)+"."+(acctSettSumInt/10%10)+(acctSettSumInt%10));
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }

    private void showSettlementList(final int pageIndex, String startTime, String currentTime) {
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getAcctSettSumList(MyApplication.user.getUserId(),"20",startTime,currentTime,pageIndex+"","10","0");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Result_Api body = (Result_Api) response.body();
                if (body!=null)
                {
                    GetAcctSettSumBean bean = (GetAcctSettSumBean) body.getOutput();
                    if (bean!=null)
                    {
                        String totalAmount = bean.getTotalAmount();
                        int totalAmountInt=0;
                        if (!TextUtils.isEmpty(totalAmount))
                        {
                            totalAmountInt = Integer.parseInt(totalAmount);
                        }
                        settlement_tv.setText(TextUtils.isEmpty(totalAmount)?"0.00":(totalAmountInt/100)+"."+(totalAmountInt/10%10)+(totalAmountInt%10));
                        //List<GetAcctSettSumBean.SettSumListBean> settSumList = bean.getSettSumList();
                        if (pageIndex==1)
                        {
                            totalList.clear();
                        }
                        totalList.addAll(bean.getSettSumList());
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

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        scrollView.scrollTo(0,0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            case R.id.menu_iv:
                Toast.makeText(this,"菜单",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
