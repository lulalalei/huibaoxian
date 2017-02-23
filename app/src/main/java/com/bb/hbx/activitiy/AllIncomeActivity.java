package com.bb.hbx.activitiy;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.adapter.MyAllIncomeAdapter;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.Account;
import com.bb.hbx.bean.MyAllIncomeBean;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllIncomeActivity extends BaseActivity implements View.OnClickListener{

    /*@BindView(R.id.scrollView)
    PullToRefreshScrollView scrollView;*/
    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.allIncome_tv)
    TextView allIncome_tv;
    GridLayoutManager manager;

    ArrayList<MyAllIncomeBean> totalList=new ArrayList<>();
    MyAllIncomeAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_all_income;
    }

    @Override
    public void initView() {
        showScore();
    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
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
        for (int i = 3; i < 9; i++) {
            String date="2016年"+i+"月";
            String money=100*i+"";
            MyAllIncomeBean bean = new MyAllIncomeBean(date, money);
            totalList.add(bean);
        }
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(int position) {
                Toast.makeText(AllIncomeActivity.this,"点击事件:"+position,Toast.LENGTH_SHORT).show();
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
