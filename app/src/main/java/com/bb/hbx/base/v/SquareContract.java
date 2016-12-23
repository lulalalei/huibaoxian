package com.bb.hbx.base.v;

import android.support.annotation.NonNull;

import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.bean.SquareBean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */

public interface SquareContract {


    interface Model extends BaseModel {




    }

    interface View extends BaseView {

        <T> void setList(T t);

        <T> void addList(T t);

    }

    abstract class Presenter extends BasePresenter<Model, View> {


        public abstract void setDate(int type);

        public abstract void freshData();

        public abstract void loadmore();


    }
}
