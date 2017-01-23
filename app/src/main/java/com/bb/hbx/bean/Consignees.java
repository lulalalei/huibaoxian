package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/20.
 */

public class Consignees {

    /**
     * output : {"cneeList":[{"address":"北京","areaCode":"110100","city":"bjs","cneeId":"103","cneeName":"hwatu","defaultFlag":"0","mobile":"18668162222"},{"address":"火星11","areaCode":"333333","city":"","cneeId":"102","cneeName":"李四1","defaultFlag":"1","mobile":"222222222"}],"pageSize":"2","totalCount":"2"}
     * respCode : 000000
     * respMsg : 获取用户收货人列表成功
     * success : true
     */

        /**
         * cneeList : [{"address":"北京","areaCode":"110100","city":"bjs","cneeId":"103","cneeName":"hwatu","defaultFlag":"0","mobile":"18668162222"},{"address":"火星11","areaCode":"333333","city":"","cneeId":"102","cneeName":"李四1","defaultFlag":"1","mobile":"222222222"}]
         * pageSize : 2
         * totalCount : 2
         */

        private String pageSize;
        private String totalCount;
        private List<CneeListBean> cneeList;

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public List<CneeListBean> getCneeList() {
            return cneeList;
        }

        public void setCneeList(List<CneeListBean> cneeList) {
            this.cneeList = cneeList;
        }

        public static class CneeListBean {
            /**
             * address : 北京
             * areaCode : 110100
             * city : bjs
             * cneeId : 103
             * cneeName : hwatu
             * defaultFlag : 0
             * mobile : 18668162222
             */

            private String address;
            private String areaCode;
            private String city;
            private String cneeId;
            private String cneeName;
            private String defaultFlag;
            private String mobile;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getAreaCode() {
                return areaCode;
            }

            public void setAreaCode(String areaCode) {
                this.areaCode = areaCode;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCneeId() {
                return cneeId;
            }

            public void setCneeId(String cneeId) {
                this.cneeId = cneeId;
            }

            public String getCneeName() {
                return cneeName;
            }

            public void setCneeName(String cneeName) {
                this.cneeName = cneeName;
            }

            public String getDefaultFlag() {
                return defaultFlag;
            }

            public void setDefaultFlag(String defaultFlag) {
                this.defaultFlag = defaultFlag;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }
        }
}
