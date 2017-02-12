package com.bb.hbx.base.m;

import android.content.ContentValues;
import android.database.Cursor;

import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.v.WelcomeContract;
import com.bb.hbx.bean.User;
import com.bb.hbx.utils.MyUsersSqlite;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Administrator on 2017/1/13.
 */

public class WelcomeModel implements WelcomeContract.Model {


    private ApiService service;


    public WelcomeModel() {
        service = RetrofitFactory.getINSTANCE().create(ApiService.class);
    }


    @Override
    public void getClientCtlInfo(String userId, Callback callback) {

        Call call = service.getClientCtlInfo(userId);
        call.enqueue(callback);
    }

    @Override
    public User settingUser() {
        User user=new User();
        //boolean hasLogined = ShareSPUtils.sp.getBoolean("hasLogined", false);
        Cursor cursor = MyUsersSqlite.db.rawQuery("select * from userstb where currentUser = ?", new String[]{"currentUser"});
        if (cursor != null) {
            if (!cursor.moveToNext())//没有数据,则首次使用,初始化部分数据
            {
                ContentValues values = new ContentValues();
                values.put("currentUser", "currentUser");
                values.put("hasLogined", "false");//默认false,未登录
                values.put("isBClient", false);//默认false
                values.put("sessionId", "");
                values.put("userId", "");
                values.put("gender", "0");//默认为0
                long flag = MyUsersSqlite.db.insert("userstb", null, values);
                //Toast.makeText(this,"插入新用户成功:"+flag,Toast.LENGTH_SHORT).show();
                values.clear();

                user.setUserId("");
                user.setSessionId("");
                user.setIsBClient(false);
            } else {
                String hasLogined = cursor.getString(cursor.getColumnIndex("hasLogined"));
                if (hasLogined.equals("true"))//首次登陆后,数据会被刷新
                {
                    String userId = cursor.getString(cursor.getColumnIndex("userId"));
                    String sessionId = cursor.getString(cursor.getColumnIndex("sessionId"));
                    String isBClient = cursor.getString(cursor.getColumnIndex("isBClient"));
                    user.setUserId(userId);
                    user.setSessionId(sessionId);
                    user.setIsBClient(isBClient.equals("true") ? true : false);
                } else {
                    user.setUserId("");
                    user.setSessionId("");
                    user.setIsBClient(false);
                }
            }
        }
        return user;
    }
}
