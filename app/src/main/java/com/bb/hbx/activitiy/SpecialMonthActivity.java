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
import com.bb.hbx.adapter.MySpecialMonthAdapter;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.GetTotalIncomeDetail;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpecialMonthActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.scrollView)
    PullToRefreshScrollView scrollView;
    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.title_tv)
    TextView title_tv;
    @BindView(R.id.allIncome_tv)
    TextView allIncome_tv;
    GridLayoutManager manager;

    List<GetTotalIncomeDetail.TotalIncomeListBean> totalList=new ArrayList<>();
    MySpecialMonthAdapter adapter;
    String specialMonth;
    String endTime="";
    String startTime="";
    int pageIndex=1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_special_month;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        specialMonth = intent.getStringExtra("specialMonth");
        String[] split = specialMonth.split("[年月]");//2017年2月
        String year = split[0];//2017
        String month = split[1];//2
        title_tv.setText(month+"月账单");
        String endDay="";
        int yearInt = Integer.parseInt(year);
        int monthInt = Integer.parseInt(month);
        switch (monthInt)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                endDay="31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                endDay="30";
                break;
            case 2:
                if (yearInt%400==0||(yearInt%4==0&&yearInt%100!=0))//闰年
                {
                    endDay="29";
                }
                else
                {
                    endDay="28";
                }
                default:
                    break;
        }
        startTime=year+"-"+month+"-"+"01";
        endTime=year+"-"+month+"-"+endDay;
        //String date=year+month;
        /*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(ca.getTime());*/
        //Toast.makeText(this,"time:"+date,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        scrollView.setMode(PullToRefreshBase.Mode.BOTH);
        scrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageIndex=1;
                showTotalIncomeList(pageIndex,startTime,endTime);
                //showAccount();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageIndex++;
                showTotalIncomeList(pageIndex,startTime,endTime);
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
        adapter = new MySpecialMonthAdapter(totalList, this);
        recyclerView.setAdapter(adapter);
        showTotalIncomeList(pageIndex,startTime,endTime);
        /*for (int i = 0; i < 4; i++) {
            list.add("i");
        }*/
        //adapter.notifyDataSetChanged();
    }

    private void showTotalIncomeList(final int pageIndex, String startTime, String endTime) {
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getTotalIncomeDetail(MyApplication.user.getUserId(),"20",startTime,endTime,pageIndex+"","10");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Result_Api body = (Result_Api) response.body();
                if (body!=null)
                {
                    GetTotalIncomeDetail detailBean = (GetTotalIncomeDetail) body.getOutput();
                    String totalAmount = detailBean.getTotalAmount();
                    int totalAmountInt=0;
                    if (!TextUtils.isEmpty(totalAmount))
                    {
                        totalAmountInt = Integer.parseInt(totalAmount);
                    }
                    allIncome_tv.setText(TextUtils.isEmpty(totalAmount)?"0.00":(totalAmountInt/100)+"."+(totalAmountInt/10%10)+(totalAmountInt%10));
                    //List<GetTotalIncomeDetail.TotalIncomeListBean> totalIncomeList = detailBean.getTotalIncomeList();
                    if (pageIndex==1)
                    {
                        totalList.clear();
                    }
                    totalList.addAll(detailBean.getTotalIncomeList());
                    adapter.notifyDataSetChanged();
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
