package com.bb.hbx.base.p;

import com.bb.hbx.base.v.SquareContract;

//import static android.support.v7.widget.StaggeredGridLayoutManager.TAG;

/**
 * Created by fancl.
 */

public class SquarePresenter extends SquareContract.Presenter {


    @Override
    public void onAttached() {
       // mModel.initparameter();
    }

    @Override
    public void setDate(int type) {
//        mModel.getIntertlistTasks(type, new BaseModel.LoadTasksCallback() {
//            @Override
//            public <T> void onTasksLoaded(T t) {
//                mView.setList(t);
//            }
//
//            @Override
//            public void onDataNotAvailable() {
//
//            }
//        });

    }

    @Override
    public void freshData() {

    }

    @Override
    public void loadmore() {

    }
}
