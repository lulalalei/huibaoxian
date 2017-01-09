package com.bb.hbx.api;

import com.bb.hbx.bean.MessageCodeBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by fancl.
 * 服务器接口
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("api.do?method=getVerifyCode&type=post")
    Call<Result_Api<MessageCodeBean>> getVerifyCode(@Field("codeType") String codeType
            , @Field("mobile") String mobile, @Field("bizType") String bizType);


    @FormUrlEncoded
    @POST("api.do?method=getSpecials&type=post")
    Call<String> getSpecials(@Field("pageIndex") int pageIndex
            , @Field("pageSize") int pageSize);



}
