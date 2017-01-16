package com.bb.hbx.bean;

/**
 * Created by fancl.
 * 用户
 */

public class User {


    private String userId;

    //0: 未登录,默认 10:C类用户, 20:B类用户
    private int userType ;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
