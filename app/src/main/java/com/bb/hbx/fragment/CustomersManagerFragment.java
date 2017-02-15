package com.bb.hbx.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.activitiy.AddContactActivity;
import com.bb.hbx.activitiy.MyCustomActivity;
import com.bb.hbx.adapter.ContactAdapter;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.ContactBean;
import com.bb.hbx.bean.GetInsured;
import com.bb.hbx.bean.InsuredInfolBean;
import com.bb.hbx.decoration.TitleItemDecoration;
import com.bb.hbx.interfaces.OnItemClickListener;
import com.bb.hbx.widget.IndexBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/8.
 */

public class CustomersManagerFragment extends BaseFragment implements View.OnClickListener{

    private static final String TAG = "zxt";
    @BindView(R.id.rv)
    RecyclerView mRv;
    private ContactAdapter mAdapter;
    private LinearLayoutManager mManager;
    private List<ContactBean> mDatas=new ArrayList<>();

    private TitleItemDecoration mDecoration;

    /**
     * 右侧边栏导航区域
     */
    @BindView(R.id.indexBar)
    IndexBar mIndexBar;

    /**
     * 显示指示器DialogText
     */
    @BindView(R.id.tvSideBarHint)
    TextView mTvSideBarHint;
    @BindView(R.id.fromContacts_tv)
    TextView fromContacts_tv;
    @BindView(R.id.fromManual_tv)
    TextView fromManual_tv;
    private Context mContext;

    int pageSize;
    int totalCount;
    List<GetInsured.InsuredListBean> insuredList;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_custommanager_layout;
    }

    @Override
    public void initView() {
        fromContacts_tv.setOnClickListener(this);
        fromManual_tv.setOnClickListener(this);
    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        mRv.setLayoutManager(mManager = new LinearLayoutManager(mContext));
        //initDatas();
        //initDatas(getResources().getStringArray(R.array.provinces));注了这
        mRv.setAdapter(mAdapter = new ContactAdapter(mContext, mDatas));
        //mRv.addItemDecoration(mDecoration = new TitleItemDecoration(mContext, mDatas));
        //如果add两个，那么按照先后顺序，依次渲染。
        //mRv.addItemDecoration(new TitleItemDecoration2(this,mDatas));
        //mRv.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL_LIST));

        //使用indexBar
        //mTvSideBarHint = (TextView) findViewById(R.id.tvSideBarHint);//HintTextView
        //mIndexBar = (IndexBar) findViewById(R.id.indexBar);//IndexBar
        //改了这
        /*mIndexBar.setmPressedShowTextView(mTvSideBarHint)//设置HintTextView
                .setNeedRealIndex(true)//设置需要真实的索引
                .setmLayoutManager(mManager)//设置RecyclerView的LayoutManager
                .setmSourceDatas(mDatas);//设置数据源*/

        /*private String birthday;
    private String email;
    private String gender;
    private String idNo;
    private String idType;
    private String insurantDesc;
    private String insuredAbbr;
    private String insuredAddress;
    private String insuredEname;
    private String insuredId;
    private String insuredName;
    private String mobile;
    private String occupation;
    private String relation;*/
        mAdapter.setOnMyItemClickListener(new OnItemClickListener() {
            @Override
            public void onMyItemClickListener(int position) {
                for (int i = 0; i < mDatas.size(); i++) {
                    if (mDatas.get(position).getCity().equals(insuredList.get(i).getInsuredName()))
                    {
                        position=i;
                        break;
                    }
                }
                Intent intent = new Intent(mContext, MyCustomActivity.class);
                String birthday = insuredList.get(position).getBirthday();
                String email = insuredList.get(position).getEmail();
                String gender = insuredList.get(position).getGender();
                String idNo = insuredList.get(position).getIdNo();
                String idType = insuredList.get(position).getIdType();
                String insurantDesc = insuredList.get(position).getInsurantDesc();
                String insuredAbbr = insuredList.get(position).getInsuredAbbr();
                String insuredAddress = insuredList.get(position).getInsuredAddress();
                String insuredEname = insuredList.get(position).getInsuredEname();
                String insuredId = insuredList.get(position).getInsuredId();
                String insuredName = insuredList.get(position).getInsuredName();
                String mobile = insuredList.get(position).getMobile();
                String occupation = insuredList.get(position).getOccupation();
                String relation = insuredList.get(position).getRelation();
                InsuredInfolBean insuredInfolBean = new InsuredInfolBean(birthday,email,gender,idNo,idType,insurantDesc,insuredAbbr,insuredAddress,
                                                                            insuredEname,insuredId,insuredName,mobile,occupation,relation);
                Bundle bundle = new Bundle();
                bundle.putParcelable("insuredInfolBean",insuredInfolBean);
                intent.putExtra("insuredInfolBean",bundle);
                startActivity(intent);
            }
        });
    }
    private void initDatas(String[] data) {
        mDatas.clear();
        //注了这
        //mDatas = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            ContactBean contactBean = new ContactBean();
            contactBean.setCity(data[i]);//设置城市名称
            mDatas.add(contactBean);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getInsuredList();
    }

    private void getInsuredList() {
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getInsured(MyApplication.user.getUserId(),MyApplication.user.getMobile(),"1","10");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Result_Api body = (Result_Api) response.body();
                GetInsured bean = (GetInsured) body.getOutput();
                if (bean!=null)
                {
                    String pageSize = bean.getPageSize();
                    String totalCount = bean.getTotalCount();
                    insuredList = bean.getInsuredList();
                    int listSize = insuredList.size();
                    String [] nameData=new String[listSize];
                    for (int i = 0; i < listSize; i++) {
                        nameData[i]=insuredList.get(i).getInsuredName();
                    }
                    if (listSize>0)
                    {
                        initDatas(nameData);
                        mAdapter.notifyDataSetChanged();
                        mIndexBar.setmPressedShowTextView(mTvSideBarHint)//设置HintTextView
                                .setNeedRealIndex(true)//设置需要真实的索引
                                .setmLayoutManager(mManager)//设置RecyclerView的LayoutManager
                                .setmSourceDatas(mDatas);//设置数据源
                        mIndexBar.invalidate();
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
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.fromContacts_tv:
                //showTip("通讯录导入");
                Toast.makeText(mContext,"通讯录导入",Toast.LENGTH_SHORT).show();
                break;
            case R.id.fromManual_tv:
                //showTip("手动添加");
                //Toast.makeText(mContext,"手动添加",Toast.LENGTH_SHORT).show();
                intent.setClass(mContext, AddContactActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
