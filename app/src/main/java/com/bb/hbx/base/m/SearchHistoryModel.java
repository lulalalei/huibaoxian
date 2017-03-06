package com.bb.hbx.base.m;

import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.v.BaseView;
import com.bb.hbx.base.v.SearchHistoryContract;
import com.bb.hbx.bean.LishiSearchBean;
import com.bb.hbx.db.DatabaseImpl;
import com.bb.hbx.widget.BaseAsyncTask;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by fancl 搜索的 model.
 */

public class SearchHistoryModel implements SearchHistoryContract.Model {


    private DatabaseImpl impl;

    private ApiService service;

    public SearchHistoryModel() {
        impl = DatabaseImpl.getInstance();
        service = RetrofitFactory.getINSTANCE().create(ApiService.class);
    }

    //获取历史搜索 (异步)
    @Override
    public List<LishiSearchBean> getHistoryList() {
        return impl.getListHis();
    }

    @Override
    public void addHistoryBean(LishiSearchBean bean) {
        impl.addHistory(bean);
    }

    @Override
    public void deleteHistoryBean(LishiSearchBean bean) {
        impl.deleteHistory(bean);
    }

    @Override
    public void deleteAll() {
        impl.deleteAllHis();
    }

    @Override
    public void getHotKeys(int pageIndex, int pageSize, Callback callback) {
        Call call = service.getHotKeys(pageIndex, pageSize);
        call.enqueue(callback);
    }


}
