package com.bb.hbx.activitiy.home;

import android.content.Context;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.adapter.ListAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.widget.TitleListview;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


import butterknife.BindView;
import butterknife.internal.Utils;

/**
 * Created by Administrator on 2016/12/12.
 */

public class HomeActivity extends BaseActivity {


    @BindView(R.id.lv_content)
    TitleListview lv_content;

    private ListAdapter adapter;

    private List<String> list;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {


    }

    @Override
    public void initdata() {
        list = getList();
        adapter = new ListAdapter(this, list);
        lv_content.setAdapter(adapter);

        lv_content.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showTip(list.get(position % list.size()));
            }
        });

    }


    /**
     * 获取数据
     */
    public List<String> getList() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i) + "简单的广播播报");
        }
        return list;
    }


}
