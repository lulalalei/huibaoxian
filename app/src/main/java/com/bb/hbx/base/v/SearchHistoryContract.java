package com.bb.hbx.base.v;

import com.bb.hbx.activitiy.login.LoginContract;
import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.bean.LishiSearchBean;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

import retrofit2.Callback;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Administrator on 2016/12/20.
 */

public interface SearchHistoryContract {


    interface Model extends BaseModel {

        //历史搜索
        List<LishiSearchBean> getHistoryList();

        void addHistoryBean(LishiSearchBean bean);

        //删掉一个
        void deleteHistoryBean(LishiSearchBean bean);

        void deleteAll();

        void getHotKeys(int pageIndex, int pageSize, Callback callback);

    }

    interface View extends BaseView {

        //历史搜索
        void getHistoryList(List<LishiSearchBean> lists);

        void notfiy();


    }

    abstract class Presenter extends BasePresenter<Model, View> {

        //历史搜索
        public abstract void getHistoryList();

        //添加
        public abstract void addHistoryBean(LishiSearchBean bean);

        //删掉一个
        public abstract void deleteBean(LishiSearchBean bean);

        public abstract List<Item> getList();

        public abstract  void deleteAll();
    }
}
