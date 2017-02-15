package com.bb.hbx.utils;


import android.util.Log;

import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.bb.hbx.MyApplication;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.bean.OssBean;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/10.
 */
public class STSGetter extends OSSFederationCredentialProvider {

    private String endpoint="";

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public STSGetter() {

    }


    public OSSFederationToken getFederationToken() {
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getOssToken(MyApplication.user.getUserId());
        Response response=null;
        try {
            response= call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

            Result_Api body = (Result_Api) response.body();
            OssBean ossBean = (OssBean) body.getOutput();
            String accessKeyId = ossBean.getAccessKeyId();
            String accessKeySecret = ossBean.getAccessKeySecret();
            String securityToken = ossBean.getSecurityToken();
            String expiration = ossBean.getExpiration();
            endpoint = ossBean.getEndpoint();
             Log.i("fancl",accessKeyId+"==="+accessKeySecret+"==="+securityToken+"==="+expiration+"==="+endpoint);
            return new OSSFederationToken(accessKeyId, accessKeySecret, securityToken, expiration);

    }
}
