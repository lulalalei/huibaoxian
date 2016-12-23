package com.bb.hbx.local;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by fancl
 */

public interface TasksDataSource<T> {

    interface LoadTasksCallback {

        <T> void onTasksLoaded(T t);

        void onDataNotAvailable();
    }


    void getData(@NonNull LoadTasksCallback callback);

    void getloadmore(int taskId, @NonNull LoadTasksCallback callback);

}
