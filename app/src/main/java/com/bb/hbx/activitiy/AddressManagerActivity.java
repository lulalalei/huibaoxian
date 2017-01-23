package com.bb.hbx.activitiy;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyAddressManagerAdapter;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.Consignees;
import com.bb.hbx.interfaces.OnItemClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddressManagerActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.bottom_layout)
    RelativeLayout bottom_layout;

    GridLayoutManager manager;
    MyAddressManagerAdapter adapter;

    List<Consignees.CneeListBean> cneeTotalList=new ArrayList<>();
    HashMap<Integer,String> mapSelect=new HashMap<>();
    int selectedPosition=0;

    Intent intentFromPersonInfo;
    String userId;
    int pageIndex=1;
    int pageSize=10;

    @Override
    public int getLayoutId() {
        return R.layout.activity_address_manager;
    }

    @Override
    public void initView() {
        intentFromPersonInfo = getIntent();
        userId = intentFromPersonInfo.getStringExtra("userId");
        manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);
        adapter=new MyAddressManagerAdapter(cneeTotalList,AddressManagerActivity.this,mapSelect);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        bottom_layout.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getConsignees(userId,pageIndex+"",pageSize+"");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Result_Api body = (Result_Api) response.body();
                Consignees consignees = (Consignees) body.getOutput();
                List<Consignees.CneeListBean> cneeList = consignees.getCneeList();
                if (cneeList.size()>0)
                {
                    for (int i = 0; i < cneeList.size(); i++) {
                        mapSelect.put(i,cneeList.get(i).getDefaultFlag());
                        if ("1".equals(cneeList.get(i).getDefaultFlag()))
                        {
                            selectedPosition=i;
                        }
                    }
                    cneeTotalList.addAll(cneeList);
                }
                adapter.setPrePosition(selectedPosition);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                showTip("服务器异常!");
            }
        });

       adapter.setOnMyItemClickListener(new OnItemClickListener() {
           @Override
           public void onMyItemClickListener(int position) {
               String cneeId = cneeTotalList.get(position).getCneeId();
               String cneeName = cneeTotalList.get(position).getCneeName();
               String mobile = cneeTotalList.get(position).getMobile();
               String areaCode = cneeTotalList.get(position).getAreaCode();
               String address = cneeTotalList.get(position).getAddress();
               ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
               Call call=service.updateConsignee(userId,cneeId,cneeName,mobile,areaCode,address,"1");
               call.enqueue(new Callback() {
                   @Override
                   public void onResponse(Call call, Response response) {

                   }

                   @Override
                   public void onFailure(Call call, Throwable t) {
                        showTip("修改收货人信息失败!");
                   }
               });
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
            case R.id.bottom_layout:
                Intent intent = new Intent(this,BuildNewAddressActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
