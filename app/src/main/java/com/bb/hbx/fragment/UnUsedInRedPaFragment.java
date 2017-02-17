package com.bb.hbx.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.adapter.MyUnUsedInRedPAdapter;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**点击 我的--红包 后显示的 未使用页面
 * Created by Administrator on 2016/12/27.
 */

public class UnUsedInRedPaFragment extends BaseFragment {

    Context mContext;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    String path="https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
    ArrayList<String> list=new ArrayList<>();
    GridLayoutManager manager;
    MyUnUsedInRedPAdapter adapter;

    int pageIndex=1;
    private static UnUsedInRedPaFragment fragment;
    public static UnUsedInRedPaFragment getInstance()
    {
        if (fragment==null)
        {
            fragment=new UnUsedInRedPaFragment();
        }
        return fragment;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_unused_inredp_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        manager = new GridLayoutManager(mContext, 1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        adapter = new MyUnUsedInRedPAdapter(mContext, list);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        if (list!=null&&list.size()>0)
        {
            list.clear();
        }
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getCouponList(MyApplication.user.getUserId(),"1","1","10");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
        for (int i = 0; i < 10; i++) {
            list.add(path);
        }
        adapter.notifyDataSetChanged();
    }

}
