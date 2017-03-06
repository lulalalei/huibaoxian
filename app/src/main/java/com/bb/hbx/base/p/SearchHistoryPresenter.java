package com.bb.hbx.base.p;

import android.os.AsyncTask;

import com.bb.hbx.api.PostCallback;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.base.v.BaseView;
import com.bb.hbx.base.v.SearchHistoryContract;
import com.bb.hbx.bean.Hotkey;
import com.bb.hbx.bean.LishiSearchBean;
import com.bb.hbx.bean.SearchTitleBean;
import com.bb.hbx.bean.SearchTitleBean2;
import com.bb.hbx.widget.BaseAsyncTask;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.bb.hbx.R.id.lin;
import static com.bb.hbx.R.id.tv;

/**
 * Created by fancl .
 * 搜索页 P
 */

public class SearchHistoryPresenter extends SearchHistoryContract.Presenter {


    private PostCallback postCallback;
    private static final int PAGE_SIZE = 8;//

    private int PAGE_INDEX = 1;//

    private List<Item> items;

    @Override
    public void onAttached() {
        items = new LinkedList<>();
        items.add(new SearchTitleBean());
        postCallback = new PostCallback<SearchHistoryContract.View>(mView) {
            @Override
            public void successCallback(Result_Api api) {
                if (api.getOutput() instanceof Hotkey) {
                    Hotkey hotkey = (Hotkey) api.getOutput();
                    if (hotkey.getKeyList() != null && !hotkey.getKeyList().isEmpty()) {
                        items.addAll(hotkey.getKeyList());
                    }
                    items.add(new SearchTitleBean2());
                    mView.notfiy();
                    getHistoryList();
                }
            }

            @Override
            public void failCallback() {


            }
        };

        mModel.getHotKeys(PAGE_INDEX, PAGE_SIZE, postCallback);

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

    @Override
    public List<Item> getList() {
        return items;
    }

    @Override
    public void deleteAll() {
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            if (item instanceof LishiSearchBean) {
                it.remove();
            }
        }
        new DeleteAllLishi(false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        mView.notfiy();
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
            items.addAll(lists);
            mView.notfiy();
        }
    }

    private class DeleteAllLishi extends BaseAsyncTask<Void, Void> {


        public DeleteAllLishi(boolean mEnddismiss) {
            super(mView, mEnddismiss);
        }

        @Override
        public Void doInBackground(Void... params) {
            mModel.deleteAll();
            return null;
        }

        @Override
        public void doStuffWithResult(Void aVoid) {

        }


    }
}
