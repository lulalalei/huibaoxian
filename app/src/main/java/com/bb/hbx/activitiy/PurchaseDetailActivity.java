package com.bb.hbx.activitiy;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyCustomInfoInDetailAdapter;
import com.bb.hbx.adapter.MyInsuranceItemInDetailAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.MyCustomInfoInDetailBean;
import com.bb.hbx.bean.MyInsuranceItemInDetailBean;

import java.util.ArrayList;

import butterknife.BindView;

public class PurchaseDetailActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_iv)
    ImageView back_iv;
    @BindView(R.id.collect_iv)
    ImageView collect_iv;
    @BindView(R.id.banner_iv)
    ImageView banner_iv;
    @BindView(R.id.commit_tv)
    TextView commit_tv;

    @BindView(R.id.insuranceItem_recyclerView)
    RecyclerView insuranceItem_recyclerView;
    @BindView(R.id.customInfo_recyclerView)
    RecyclerView customInfo_recyclerView;
    @BindView(R.id.share_layout)
    RelativeLayout share_layout;
    @BindView(R.id.custom_layout)
    RelativeLayout custom_layout;
    @BindView(R.id.insurance_layout)
    RelativeLayout insurance_layout;
    @BindView(R.id.askMoney_layout)
    RelativeLayout askMoney_layout;
    @BindView(R.id.issue_layout)
    RelativeLayout issue_layout;
    @BindView(R.id.case_layout)
    RelativeLayout case_layout;

    GridLayoutManager managerInsuranceItem;
    GridLayoutManager managerCustomInfo;
    MyInsuranceItemInDetailAdapter itemInDetailAdapter;
    MyCustomInfoInDetailAdapter customInfoInDetailAdapter;
    ArrayList<MyInsuranceItemInDetailBean> totalInsuranceItemList=new ArrayList<>();
    ArrayList<MyCustomInfoInDetailBean> totalCustomInfoList=new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_purchase_detail;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_iv.setOnClickListener(this);
        collect_iv.setOnClickListener(this);
        banner_iv.setOnClickListener(this);
        custom_layout.setOnClickListener(this);
        insurance_layout.setOnClickListener(this);
        askMoney_layout.setOnClickListener(this);
        issue_layout.setOnClickListener(this);
        case_layout.setOnClickListener(this);
        share_layout.setOnClickListener(this);
        commit_tv.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        managerInsuranceItem=new GridLayoutManager(this,1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        managerCustomInfo=new GridLayoutManager(this,1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        for (int i = 0; i < 3; i++) {
            String title="银行卡盗刷:"+i;
            String price=(i+1)*10+"万";
            MyInsuranceItemInDetailBean itemInDetailBean = new MyInsuranceItemInDetailBean(title, price);
            totalInsuranceItemList.add(itemInDetailBean);
        }
        for (int i = 0; i < 5; i++) {
            String type=i+"";
            String title="投保年龄:0-"+i+"岁";
            String content="0-"+i+"岁";
            MyCustomInfoInDetailBean customInfoInDetailBean = new MyCustomInfoInDetailBean(type, title, content);
            totalCustomInfoList.add(customInfoInDetailBean);
        }
        insuranceItem_recyclerView.setLayoutManager(managerInsuranceItem);
        customInfo_recyclerView.setLayoutManager(managerCustomInfo);
        customInfoInDetailAdapter = new MyCustomInfoInDetailAdapter(totalCustomInfoList, this);
        itemInDetailAdapter = new MyInsuranceItemInDetailAdapter(totalInsuranceItemList, this);
        insuranceItem_recyclerView.setAdapter(itemInDetailAdapter);
        customInfo_recyclerView.setAdapter(customInfoInDetailAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_iv:
                finish();
                break;
            case R.id.collect_iv:
                Toast.makeText(this,"collect",Toast.LENGTH_SHORT).show();
                break;
            case R.id.banner_iv:
                break;
            case R.id.case_layout:
                Toast.makeText(this,"案例分析",Toast.LENGTH_SHORT).show();
                break;
            case R.id.issue_layout:
                Toast.makeText(this,"常见问题",Toast.LENGTH_SHORT).show();
                break;
            case R.id.askMoney_layout:
                Toast.makeText(this,"理赔流程",Toast.LENGTH_SHORT).show();
                break;
            case R.id.insurance_layout:
                Toast.makeText(this,"保险条款",Toast.LENGTH_SHORT).show();
                break;
            case R.id.custom_layout:
                Toast.makeText(this,"投保须知",Toast.LENGTH_SHORT).show();
                break;
            case R.id.share_layout:
                Toast.makeText(this,"分享",Toast.LENGTH_SHORT).show();
                break;
            case R.id.commit_tv:
                Toast.makeText(this,"我要投保",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
