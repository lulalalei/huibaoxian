package com.bb.hbx.base.p;

import android.os.AsyncTask;

import com.bb.hbx.base.v.BaseView;
import com.bb.hbx.base.v.SearchHistoryContract;
import com.bb.hbx.bean.LishiSearchBean;
import com.bb.hbx.widget.BaseAsyncTask;

import java.util.List;

/**
 * Created by fancl .
 */

public class SearchHistoryPresenter extends SearchHistoryContract.Presenter {


    @Override
    public void onAttached() {

    }


    @Override
    public void getHistoryList() {
        new SearchHisTask(false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void addHistoryBean(LishiSearchBean bean) {
        mModel.addHistoryBean(bean);
    }


    @Override
    public void deleteBean(LishiSearchBean bean) {
        mModel.deleteHistoryBean(bean);
    }


    private class SearchHisTask extends BaseAsyncTask<Void, List<LishiSearchBean>> {


        public SearchHisTask(boolean mEnddismiss) {
            super(mView, mEnddismiss);
        }

        @Override
        public List<LishiSearchBean> doInBackground(Void... params) {
            return mModel.getHistoryList();
        }

        @Override
        public void doStuffWithResult(List<LishiSearchBean> lists) {
            mView.getHistoryList(lists);
        }
    }
}
