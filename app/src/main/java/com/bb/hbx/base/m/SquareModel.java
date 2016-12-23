package com.bb.hbx.base.m;

import com.bb.hbx.base.v.SquareContract;

/**
 * Created by Administrator on 2016/12/5.
 */

public class SquareModel implements SquareContract.Model {


//    private SquareLocalDataSource localdataSource;
//
//    private SquareRemoteDataSource remoteDataSource;
//
//
//    private void getTasksFromRemoteDataSource(@NonNull final LoadTasksCallback callback) {
//
//        remoteDataSource.getTasks(new LoadTasksCallback() {
//            @Override
//            public <T> void onTasksLoaded(T t) {
//                callback.onTasksLoaded(t);
//            }
//
//            @Override
//            public void onDataNotAvailable() {
//
//            }
//        });
//    }
//
//
//    @Override
//    public void initparameter() {
//        localdataSource = SquareLocalDataSource.getInstance(MyApplication.getAppContext());
//        remoteDataSource = SquareRemoteDataSource.getInstance();
//    }
//
//    @Override
//    public void getIntertlistTasks(int pageType, @NonNull LoadTasksCallback callback) {
//        if (pageType == Constants.PAGE_BKTJ)
//            getTasksFromRemoteDataSource(callback);
//        else if (pageType == Constants.PAGE_YXHD)
//            getSecondTasksFromRemoteDataSource(callback);
//        else
//            getTasksFromRemoteDataSource(callback);
//    }
//
//    private void getSecondTasksFromRemoteDataSource(@NonNull final LoadTasksCallback callback) {
//
//        localdataSource.getTasks(new LoadTasksCallback() {
//            @Override
//            public <T> void onTasksLoaded(T t) {
//                callback.onTasksLoaded(t);
//            }
//
//            @Override
//            public void onDataNotAvailable() {
//
//            }
//        });
//
//    }
}
