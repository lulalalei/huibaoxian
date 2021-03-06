package com.bb.hbx.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ScrollView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.activitiy.InfoActivity;
import com.bb.hbx.adapter.MySystemInfoAdapter;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.Message;
import com.bb.hbx.bean.MsgInfo;
import com.bb.hbx.db.MyDBManagerSystemInfo;
import com.bb.hbx.interfaces.OnItemChangeStateClickListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/17.
 */

public class SystemInfoFragment extends BaseFragment{

    @BindView(R.id.scrollView)
    PullToRefreshScrollView scrollView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Context mContext;
    List<Message> totalList=new ArrayList<>();
    GridLayoutManager manager;
    MySystemInfoAdapter adapter;
    SystemInfoReceiver systemInfoReceiver;
    int pageIndex=1;
    int unReadCount;
    int totalCount;
    int realsystemInfoCount;
    int haveReadCount;
    MyDBManagerSystemInfo myDBManagerSystemInfo;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_systeminfo_layout;
    }

    @Override
    public void initView() {
        myDBManagerSystemInfo = new MyDBManagerSystemInfo(mContext);

        initReceiver();

        scrollView.setMode(PullToRefreshBase.Mode.BOTH);
        scrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageIndex=1;
                showMsgList(pageIndex);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageIndex++;
                showMsgList(pageIndex);
            }
        });
    }

    private void initReceiver() {
        systemInfoReceiver = new SystemInfoReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.myinfo");
        mContext.registerReceiver(systemInfoReceiver,filter);
    }

    @Override
    protected void initdate(Bundle savedInstanceState) {
        manager = new GridLayoutManager(mContext, 1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        adapter = new MySystemInfoAdapter(mContext, totalList,myDBManagerSystemInfo);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        showMsgList(pageIndex);
        adapter.setOnMyItemClickListener(new OnItemChangeStateClickListener() {
            @Override
            public void onMyItemChangeStateClickListener(int position, View view) {
                if (((Integer)position)==view.getTag())
                {
                    //作为已读消息插入数据库
                    Message mess = totalList.get(position);
                    mess.setSts(2);
                    myDBManagerSystemInfo.insertObject(mess);
                    //view.setVisibility(View.GONE);
                    if (unReadCount>0)
                    {
                        unReadCount--;
                    }
                    InfoActivity.resetLabSystem(unReadCount);
                    view.setBackgroundResource(R.drawable.shape_circle_white);
                    totalList.get(position).setSts(2);
                    adapter.notifyItemChanged(position);
                    //Toast.makeText(mContext,"position:"+position,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showMsgList(final int pageIndex) {
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getMsgsUser(MyApplication.user.getUserId(),"1","0",pageIndex+"");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Result_Api body = (Result_Api) response.body();
                MsgInfo bean = (MsgInfo) body.getOutput();
                if (bean!=null)
                {
                    totalCount = bean.getTotalCount();
                    haveReadCount = myDBManagerSystemInfo.queryAll();
                    //List<Message> msgList = bean.getMsgList();
                    if (pageIndex==1)
                    {
                        totalList.clear();
                    }
                    unReadCount = totalCount-haveReadCount;
                    InfoActivity.resetLabSystem(unReadCount);
                    totalList.addAll(bean.getMsgList());
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
    public void onDestroyView() {
        super.onDestroyView();
        mContext.unregisterReceiver(systemInfoReceiver);
        myDBManagerSystemInfo.closeDaoSession();
    }

    class SystemInfoReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            for (int i = 0; i < totalList.size(); i++) {
                //totalList.get(i).setSts(2);
                Message mess = totalList.get(i);
                mess.setSts(2);
                myDBManagerSystemInfo.insertObject(mess);
            }
            adapter.notifyDataSetChanged();
            unReadCount = 0;
            InfoActivity.resetLabSystem(unReadCount);
        }
    }
}
