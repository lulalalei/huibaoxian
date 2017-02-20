package com.bb.hbx.api;

import com.bb.hbx.base.m.ActivitModel;
import com.bb.hbx.bean.Account;
import com.bb.hbx.bean.ActivitBean;
import com.bb.hbx.bean.ActivitInfo;
import com.bb.hbx.bean.AddConsignee;
import com.bb.hbx.bean.AddInsured;
import com.bb.hbx.bean.AreasListBean;
import com.bb.hbx.bean.BannerBean;
import com.bb.hbx.bean.BobaoItem;
import com.bb.hbx.bean.Consignees;
import com.bb.hbx.bean.DeleteConsignee;
import com.bb.hbx.bean.FilterBean;
import com.bb.hbx.bean.GetInsured;
import com.bb.hbx.bean.HomePageInfo;
import com.bb.hbx.bean.MessageCodeBean;
import com.bb.hbx.bean.MsgInfo;
import com.bb.hbx.bean.OssBean;
import com.bb.hbx.bean.ProdectDetalRequest;
import com.bb.hbx.bean.ProductBean;
import com.bb.hbx.bean.ProductDetail;
import com.bb.hbx.bean.ProductItem;
import com.bb.hbx.bean.ProductParamDetail;
import com.bb.hbx.bean.RecommendBean;
import com.bb.hbx.bean.RequestProduct;
import com.bb.hbx.bean.Special;
import com.bb.hbx.bean.TopicBean;
import com.bb.hbx.bean.TypeModel;
import com.bb.hbx.bean.UpdateConsignee;
import com.bb.hbx.bean.UpdateInsured;
import com.bb.hbx.bean.User;
import com.bb.hbx.bean.UserInfo;
import com.bb.hbx.bean.UserRegist;
import com.bb.hbx.bean.VersionInfo;

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
    Call<String> forgetLoginPwd(@Field("mobile") String mobile, @Field("newPwd") String newPwd, @Field("resetType") String resetType, @Field("smsCode") String smsCode);

    //我的首页
    @FormUrlEncoded
    @POST("api.do?method=getUserInfo&type=post")
    Call<Result_Api<UserInfo>> getUserInfo(@Header("sessionId") String sessionId, @Field("userId") String userId);

    //查询账户信息
    @FormUrlEncoded
    @POST("api.do?method=getAccount&type=post")
    Call<Result_Api<Account>> getAccount(@Field("userId") String userId);

    //修改用户信息,nickName
    @FormUrlEncoded
    @POST("api.do?method=updateUserInfo&type=post")
    Call<Result_Api> updateUserInfo(@Field("userId") String userId, @Field("nickName") String nickName);

    //修改用户信息,性别
    @FormUrlEncoded
    @POST("api.do?method=updateUserInfo&type=post")
    Call<Result_Api> updateUserInfoSex(@Field("userId") String userId, @Field("gender") String gender);

    //修改用户信息,邮箱地址
    @FormUrlEncoded
    @POST("api.do?method=updateUserInfo&type=post")
    Call<Result_Api> updateUserInfoEmail(@Field("userId") String userId, @Field("email") String email);

    //获取收货人信息
    @FormUrlEncoded
    @POST("api.do?method=getConsignees&type=post")
    Call<Result_Api<Consignees>> getConsignees(@Field("userId") String userId, @Field("pageIndex") String pageIndex, @Field("pageSize") String pageSize);

    //修改收货人信息
    @FormUrlEncoded
    @POST("api.do?method=updateConsignee&type=post")
    Call<Result_Api<UpdateConsignee>> updateConsignee(@Field("userId") String userId, @Field("cneeId") String cneeId, @Field("cneeName") String cneeName,
                                                      @Field("mobile") String mobile, @Field("areaCode") String areaCode, @Field("address") String address,
                                                      @Field("defaultFlag") String defaultFlag);

    //新增收货人信息
    @FormUrlEncoded
    @POST("api.do?method=addConsignee&type=post")
    Call<Result_Api<AddConsignee>> addConsignee(@Field("userId") String userId, @Field("cneeName") String cneeName, @Field("mobile") String mobile,
                                                @Field("areaCode") String areaCode, @Field("areaId") String areaId, @Field("address") String address,
                                                @Field("syncUser") String syncUser, @Field("defaultFlag") String defaultFlag);

    //删除收货人信息
    @FormUrlEncoded
    @POST("api.do?method=delConsignee&type=post")
    Call<Result_Api<DeleteConsignee>> delConsignee(@Field("userId") String userId, @Field("cneeId") String cneeId);

    //获取地区信息
    @FormUrlEncoded
    @POST("api.do?method=getAreaList&type=post")
    Call<Result_Api<AreasListBean>> getAreaList(@Field("findAllFlag") boolean findAllFlag);

    //添加银行卡
    @FormUrlEncoded
    @POST("api.do?method=bindingBankCard&type=post")
    Call<Result_Api> bindingBankCard(@Field("accountName") String accountName, @Field("bankName") String bankName,
                                     @Field("cardNo") String cardNo, @Field("userId") String userId);

    //提现
    @FormUrlEncoded
    @POST("api.do?method=applyCash&type=post")
    Call<Result_Api> applyCash(@Field("userId") String userId, @Field("cashAmount") String cashAmount, @Field("accountName") String accountName,
                               @Field("bankName") String bankName, @Field("cashIp") String cashIp);

    //设置,修改支付密码
    @FormUrlEncoded
    @POST("api.do?method=updatePayPassword&type=post")
    Call<Result_Api> updatePayPassword(@Field("payPassword") String payPassword, @Field("userId") String userId);

    //上传用户头像,阿里云
    @FormUrlEncoded
    @POST("api.do?method=getOssToken&type=post")
    Call<Result_Api<OssBean>> getOssToken(@Field("userId") String userId);

    //获取常用保险联系人--已测,接口返回数据待修改
    @FormUrlEncoded
    @POST("api.do?method=getInsured&type=post")
    Call<Result_Api<GetInsured>> getInsured(@Field("userId") String userId, @Field("mobile") String mobile,
                                            @Field("pageIndex") String pageIndex, @Field("pageSize") String pageSize);

    //新增常用保险联系人--已测,
    @FormUrlEncoded
    @POST("api.do?method=addInsured&type=post")
    Call<Result_Api<AddInsured>> addInsured(@Field("userId") String userId, @Field("insuredName") String insuredName, @Field("mobile") String mobile,
                                            @Field("idType") String idType, @Field("idNo") String idNo);

    //修改常用保险联系人--已测
    @FormUrlEncoded
    @POST("api.do?method=updateInsured&type=post")
    Call<Result_Api<UpdateInsured>> updateInsured(@Field("userId") String userId, @Field("insuredId") String insuredId, @Field("insuredName") String insuredName,
                                                  @Field("mobile") String mobile, @Field("idType") String idType, @Field("idNo") String idNo);

    //删除常用保险联系人--已测
    @FormUrlEncoded
    @POST("api.do?method=delInsured&type=post")
    Call<Result_Api<UpdateInsured>> delInsured(@Field("userId") String userId, @Field("insuredId") String insuredId);

    //获取我的红包记录列表--待测
    @FormUrlEncoded
    @POST("api.do?method=getCouponList&type=post")
    Call<String> getCouponList(@Field("userId") String userId, @Field("sts") String sts,
                               @Field("pageIndex") String pageIndex,@Field("pageSize") String pageSize);


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
    Call<Result_Api<MsgInfo>> getMsgs(@Field("userId") String userId, @Field("msgType") String msgType,
                                      @Field("sts") String sts, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    //获取产品详情
    @FormUrlEncoded
    @POST("api.do?method=getProductDetail&type=post")
    Call<Result_Api<ProductParamDetail>> getProductDetail(@Field("productId") String productId);

    //获取专题列表
    @FormUrlEncoded
    @POST("api.do?method=getSpecials&type=post")
    Call<Result_Api<TopicBean>> getSpecials(@Field("pageIndex") int pageIndex);


    //版本信息获取
    @FormUrlEncoded
    @POST("api.do?method=getClientCtlInfo&type=post")
    Call<Result_Api<VersionInfo>> getClientCtlInfo(@Field("userId") String userId);

    //版本信息获取
    @FormUrlEncoded
    @POST("api.do?method=getStartUpImgs&type=post")
    Call<Result_Api<String>> getStartUpImgs();


    //获取Banner

    @POST("api.do?method=getBannerInfo&type=post")
    Call<Result_Api<BannerBean>> getBannerInfo();


    //获取小汇报消息列表
    @POST("api.do?method=getXhbMessageInfo&type=post")
    Call<Result_Api<BobaoItem>> getXhbMessageInfo();


    //获取首页分类

    @POST("api.do?method=getHomePageProductType&type=post")
    Call<Result_Api<ProductItem>> getHomePageProductType();

    //获取首页专题列表
    @POST("api.do?method=getHomePageProductList&type=post")
    Call<Result_Api<Special>> getHomePageProductList();

    //获取未读消息条数
    @FormUrlEncoded
    @POST("api.do?method=getUnReadMessageCount&type=post")
    Call<Result_Api<MsgInfo>> getUnReadMessageCount(@Field("userId") String userId);

    //获取未读消息条数
    @FormUrlEncoded
    @POST("api.do?method=getAdsList&type=post")
    Call<Result_Api<ActivitInfo>> getAdsList(@Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);


    //爆款推荐
    @FormUrlEncoded
    @POST("api.do?method=getSpecialProductList&type=post")
    Call<Result_Api<RecommendBean>> getSpecialProductList(@Field("pageIndex") int pageIndex);

    //获取产品列表

    @POST("api.do?method=applyTrade&type=post")
    Call<Result_Api<ProductBean>> applyTrade(@Body ProdectDetalRequest request);


    //获取保险公司列表
    @FormUrlEncoded
    @POST("api.do?method=getInsurers&type=post")
    Call<Result_Api<FilterBean>> getInsurers(@Field("parentId") String parentId, @Field("insurerId") String insurerId,
                                             @Field("insurerType") String insurerType);


}
