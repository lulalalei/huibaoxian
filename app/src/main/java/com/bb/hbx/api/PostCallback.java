package com.bb.hbx.api;

import android.util.Log;


import com.bb.hbx.base.v.BaseView;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/12/2.
 */

public abstract class PostCallback<V extends BaseView, T> implements Callback<Result_Api> {


    private final static String TAG = PostCallback.class.getSimpleName();

    private final static String ERROR_DATA = "获取数据异常";
    private final static String NET_ERROR = "请检查网络是否正常";

    private V view;

    private Class<T> clazz;

    public PostCallback(V view) {
        this.view = view;
        if (this.getClass().getGenericSuperclass() instanceof ParameterizedType) {
            clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];

        }

    }


    public abstract void successCallback(Result_Api api);

    public abstract void failCallback();


//    @Override
//    public void onResponse(Call<Result_Api<T>> call, Response<Result_Api<T>> response) {
//        Log.i(TAG,"onResponse");
//        view.dissmissLoading();
//        Result_Api api=response.body();
//
//
//
//                new Gson().fromJson(api.getData().toString(),clazz);
//
//
//        if(api!=null && api.getCode()==1){
//            successCallback(api);
//        }else
//            view.showTip(ERROR_DATA);
//
//    }
//
//    @Override
//    public void onFailure(Call<Result_Api<T>> call, Throwable t) {
//        view.dissmissLoading();
//        view.showTip(NET_ERROR);
//        failCallback();
//    }


    @Override
    public void onResponse(Call<Result_Api> call, Response<Result_Api> response) {
        Log.i(TAG, "response.code():"+response.code()+"%%%%%%%"+response.message());

        view.dissmissLoading();
        Result_Api api = response.body();
        if(api != null ) {
            if (api.getCode() == 1) {
                if (api.getData() != null) {
                    T t = new Gson().fromJson(api.getData().toString(), clazz);
                    api.setData(t);
                }
                successCallback(api);
            } else
                view.showMsg(api.getMsg());
        }else

            view.showMsg(ERROR_DATA);


    }

    @Override
    public void onFailure(Call<Result_Api> call, Throwable t) {
        view.dissmissLoading();
        view.showMsg(NET_ERROR);
        failCallback();
    }
}
