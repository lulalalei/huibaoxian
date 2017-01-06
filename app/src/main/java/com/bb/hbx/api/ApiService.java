package com.bb.hbx.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by fancl.
 * 服务器接口
 */

public interface ApiService {



//
//    @FormUrlEncoded
//    @POST("api.do")
//    Call<String> getVerifyCode(@Field("codeType") String codeType,
//                                   @Field("mobile") String mobile, @Field("bizType") String bizType,@Field("method") String method,@Field("type") String type );



    @FormUrlEncoded
    @POST("api.do?method=getVerifyCode&type=post")
    Call<String> getVerifyCode(@Field("input") String input,@Field("sign") String sign);

}
