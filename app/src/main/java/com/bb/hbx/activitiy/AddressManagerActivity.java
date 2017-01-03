package com.bb.hbx.activitiy;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyAddressManagerAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.AddressBean;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;

public class AddressManagerActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_iv)
    ImageView back_iv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.bottom_layout)
    RelativeLayout bottom_layout;

    GridLayoutManager manager;
    MyAddressManagerAdapter adapter;
    ArrayList<AddressBean> totalList=new ArrayList<>();
    HashMap<Integer,Boolean> map=new HashMap<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_address_manager;
    }

    @Override
    public void initView() {
        manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);
       /* adapter = new MyAddressManagerAdapter(totalList, this);
        recyclerView.setAdapter(adapter);*/
    }

    @Override
    public void initListener() {
        back_iv.setOnClickListener(this);
        bottom_layout.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        for (int i = 0; i < 10; i++) {
            boolean isSelected=false;
            map.put(i,false);//默认都未被选中
            String name="android:"+i;
            String phone="1570000000"+i;
            String address="浙江省杭州市西湖区学院路28号德力西大厦3号楼2层浙江保保科技有限公司:"+i;
            AddressBean bean = new AddressBean(isSelected, name, phone, address);
            totalList.add(bean);
        }
        adapter=new MyAddressManagerAdapter(totalList,this,map);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_iv:
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
