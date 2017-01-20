package com.bb.hbx.api;

import com.bb.hbx.bean.HomePageInfo;
import com.bb.hbx.bean.MessageCodeBean;
import com.bb.hbx.bean.ProductBean;
import com.bb.hbx.bean.RequestProduct;
import com.bb.hbx.bean.TypeModel;
import com.bb.hbx.bean.User;
import com.bb.hbx.bean.UserInfo;
import com.bb.hbx.bean.UserRegist;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

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

    //验证码校验
    @FormUrlEncoded
    @POST("api.do?method=verifyCode&type=post")
    Call<Result_Api> verifyCode(@Field("codeType") String codeType
            , @Field("verifyCode") String verifyCode, @Field("bizType") String bizType);

    //用户注册
    @FormUrlEncoded
    @POST("api.do?method=regUser&type=post")
    Call<Result_Api<UserRegist>> regUser(@Field("userName") String userName
            , @Field("loginPwd") String loginPwd, @Field("smsCode") String smsCode);


    //短信登录
    @FormUrlEncoded
    @POST("api.do?method=login&type=post")
    Call<Result_Api<User>> loginSms(@Field("userName") String userName, @Field("smsCode") String smsCode, @Field("loginType") String loginType);

    //密码登录
    @FormUrlEncoded
    @POST("api.do?method=login&type=post")
    Call<Result_Api<User>> login(@Field("userName") String userName, @Field("loginPwd") String loginPwd, @Field("loginType") String loginType);

    //忘记密码------待测
    @FormUrlEncoded
    @POST("api.do?method=forgetLoginPwd&type=post")
    Call<String> forgetLoginPwd(@Field("mobile") String mobile, @Field("newPwd") String newPwd, @Field("resetType") String resetType,@Field("smsCode") String smsCode);

    //我的首页
    @FormUrlEncoded
    @POST("api.do?method=getUserInfo&type=post")
    Call<Result_Api<UserInfo>> getUserInfo(@Header("sessionId") String sessionId, @Field("userId") String userId);

    //修改用户信息,nickName
    @FormUrlEncoded
    @POST("api.do?method=updateUserInfo&type=post")
    Call<Result_Api> updateUserInfo(@Field("userId") String userId, @Field("nickName") String nickName);

    //修改用户信息,性别
    @FormUrlEncoded
    @POST("api.do?method=updateUserInfo&type=post")
    Call<Result_Api> updateUserInfoSex(@Field("userId") String userId, @Field("gender") String gender);

    //修改用户信息,邮箱地址-----待测
    @FormUrlEncoded
    @POST("api.do?method=updateUserInfo&type=post")
    Call<Result_Api> updateUserInfoEmail(@Field("userId") String userId,@Field("email") String email);

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


    //获取消息列表
    @FormUrlEncoded
    @POST("api.do?method=getMsgs&type=post")
    Call<Result_Api<String>> getMsgs(@Field("userId") String userId, @Field("msgType") String msgType,
                                                   @Field("sts") String sts, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

}
