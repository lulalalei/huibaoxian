package com.bb.hbx.activitiy;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.adapter.MySettlementAdapter;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.MySettlementBean;

import java.util.ArrayList;
import java.util.Calendar;

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
    ScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    GridLayoutManager manager;

    ArrayList<MySettlementBean> totalList=new ArrayList<>();
    MySettlementAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_settlement;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        menu_iv.setOnClickListener(this);
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
        adapter = new MySettlementAdapter(totalList, this);
        recyclerView.setAdapter(adapter);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String startTime=year+"-"+(month+1)+"-"+(day-15);
        String endTime=year+"-"+month+"-"+(day-15);
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getAcctSettSumList(MyApplication.user.getUserId(),"20",endTime,startTime,"1","10","0");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
        for (int i = 0; i < 16; i++) {
            String date="今天:"+i;
            String time="12.:"+i/10+i%10;
            String title="驾乘人员意外伤害保险:"+i;
            String number="保单号:"+i;
            String price=20+i+"";
            MySettlementBean bean = new MySettlementBean(date, time, title, number, price);
            totalList.add(bean);
        }
        adapter.notifyDataSetChanged();
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
