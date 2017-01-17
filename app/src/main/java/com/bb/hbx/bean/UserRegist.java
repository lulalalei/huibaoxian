package com.bb.hbx.bean;

/**
 * Created by Administrator on 2017/1/16.
 */

public class UserRegist {


    /**
     * output : {"sessionId":"748023ffb600f92183cc133a359e0089","userId":"1"}
     * respCode : 000000
     * respMsg : 注册成功
     * success : true
     */

        /**
         * sessionId : 748023ffb600f92183cc133a359e0089
         * userId : 1
         */

        private String sessionId;
        private String userId;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
}
