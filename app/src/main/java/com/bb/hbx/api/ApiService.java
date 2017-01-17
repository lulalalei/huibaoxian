package com.bb.hbx.api;

import com.bb.hbx.bean.HomePageInfo;
import com.bb.hbx.bean.MessageCodeBean;
import com.bb.hbx.bean.ProductBean;
import com.bb.hbx.bean.RequestProduct;
import com.bb.hbx.bean.TypeModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static com.baidu.location.h.j.m;

/**
 * Created by fancl.
 * 服务器接口
 */

public interface ApiService {

    //获取验证码
    @FormUrlEncoded
    @POST("api.do?method=getVerifyCode&type=post")
    Call<Result_Api<MessageCodeBean>> getVerifyCode(@Field("codeType") String codeType
            , @Field("mobile") String mobile, @Field("bizType") String bizType);


    //获取首页数据
    @FormUrlEncoded
    @POST("api.do?method=getHomePageInfo&type=post")
    Call<Result_Api<HomePageInfo>> getHomePageInfo(@Field("userId") String userId);

    //获取保险分类列表
    @FormUrlEncoded
    @POST("api.do?method=getProductType&type=post")
    Call<Result_Api<TypeModel>> getProductType(@Field("parentId") String parentId);


    //获取系统搜索热词
    @FormUrlEncoded
    @POST("api.do?method=getHotKeys&type=post")
    Call<String> getHotKeys(@Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    //获取产品列表

    @POST("api.do?method=getProducts&type=post")
    Call<Result_Api<ProductBean>> getProducts(@Body RequestProduct product);

}
