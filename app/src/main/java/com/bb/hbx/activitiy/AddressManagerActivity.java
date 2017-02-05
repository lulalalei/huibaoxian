package com.bb.hbx.activitiy;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;

import com.bb.hbx.R;
import com.bb.hbx.adapter.MyAddressManagerAdapter;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.Consignees;
import com.bb.hbx.bean.DeleteConsignee;
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

    boolean syncUser=false;
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
        showConsigneesList();
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
        adapter.setOnMyItemDeleteClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(final int position) {
                if (position!=selectedPosition)
                {
                    if (cneeTotalList.size()>0)
                    {
                        AlertDialog.Builder dialog = new AlertDialog.Builder(AddressManagerActivity.this);
                        dialog.setTitle("确认要删除改地址吗?");
                        dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String cneeId = cneeTotalList.get(position).getCneeId();
                                if (!TextUtils.isEmpty(cneeId))
                                {
                                    ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
                                    Call call=service.delConsignee(userId,cneeId);
                                    call.enqueue(new Callback() {
                                        @Override
                                        public void onResponse(Call call, Response response) {
                                            Result_Api body = (Result_Api) response.body();
                                            DeleteConsignee deleteConsignee = (DeleteConsignee) body.getOutput();
                                            int count = deleteConsignee.getCount();
                                            cneeTotalList.remove(position);
                                            adapter.notifyItemRemoved(position);
                                            showTip("删除成功!");
                                        }

                                        @Override
                                        public void onFailure(Call call, Throwable t) {
                                            showTip("删除失败!");
                                        }
                                    });
                                }
                                else
                                {
                                    showTip("请求参数异常!");
                                }
                            }
                        });
                        dialog.setNegativeButton("取消",null);
                        dialog.show();

                    }
                }
            }
        });
        adapter.setOnMyItemEditClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(int position) {
                //showTip("编辑");
                if (cneeTotalList.size()>0)
                {
                    Intent intent = new Intent(AddressManagerActivity.this, ModifyAddressActivity.class);
                    Consignees.CneeListBean bean = cneeTotalList.get(position);
                    String cneeName = bean.getCneeName();
                    String mobile = bean.getMobile();
                    String areaCode = bean.getAreaCode();
                    String city = bean.getCity();
                    String address = bean.getAddress();
                    String defaultFlag = bean.getDefaultFlag();
                    String cneeId = bean.getCneeId();
                    intent.putExtra("cneeName",cneeName);
                    intent.putExtra("mobile",mobile);
                    intent.putExtra("areaCode",areaCode);
                    intent.putExtra("city",city);
                    intent.putExtra("address",address);
                    intent.putExtra("defaultFlag",defaultFlag);
                    intent.putExtra("userId",userId);
                    intent.putExtra("cneeId",cneeId);
                    startActivity(intent);
                }
                else
                {
                    showTip("信息获取异常");
                }
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showConsigneesList();
    }

    private void showConsigneesList() {
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
                    cneeTotalList.clear();
                    cneeTotalList.addAll(cneeList);
                }
                else
                {
                    syncUser=true;
                }
                adapter.setPrePosition(selectedPosition);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                showTip("服务器异常!");
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
                intent.putExtra("userId",userId);
                intent.putExtra("syncUser",syncUser);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
