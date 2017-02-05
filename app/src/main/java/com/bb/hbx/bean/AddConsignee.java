package com.bb.hbx.bean;

/**
 * Created by Administrator on 2017/1/24.
 */

public class AddConsignee {

    /**
     * output : {"cneeId":1,"count":""}
     * respCode : 000000
     * respMsg : 新增用户收货人列表成功
     * success : true
     */

        /**
         * cneeId : 1
         * count :
         */

        private int cneeId;
        private String count;

        public int getCneeId() {
            return cneeId;
        }

        public void setCneeId(int cneeId) {
            this.cneeId = cneeId;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }
}
