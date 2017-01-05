package com.bb.hbx.base.m;

import com.bb.hbx.base.v.BaseView;
import com.bb.hbx.base.v.SearchHistoryContract;
import com.bb.hbx.bean.LishiSearchBean;
import com.bb.hbx.db.DatabaseImpl;
import com.bb.hbx.widget.BaseAsyncTask;

import java.util.List;

/**
 * Created by fancl 搜索的 model.
 */

public class SearchHistoryModel implements SearchHistoryContract.Model {


    private DatabaseImpl impl;


    public SearchHistoryModel() {
        impl = DatabaseImpl.getInstance();
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


}
