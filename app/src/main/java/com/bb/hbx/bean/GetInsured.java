package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/14.
 */

public class GetInsured {

    /**
     * output : {"insuredList":[{"birthday":"","email":"","gender":"","idNo":"3303","idType":"1","insurantDesc":"","insuredAbbr":"al","insuredAddress":"","insuredEname":"aliang","insuredId":"5","insuredName":"阿亮","mobile":"15735920000","occupation":"","relation":""},{"birthday":"","email":"","gender":"","idNo":"1110","idType":"1","insurantDesc":"","insuredAbbr":"all","insuredAddress":"","insuredEname":"aliaoliao","insuredId":"3","insuredName":"啊聊聊","mobile":"15735920000","occupation":"","relation":""},{"birthday":"","email":"","gender":"","idNo":"3304","idType":"1","insurantDesc":"","insuredAbbr":"alb","insuredAddress":"","insuredEname":"alibin","insuredId":"6","insuredName":"阿里斌","mobile":"15735920000","occupation":"","relation":""},{"birthday":"","email":"","gender":"","idNo":"11101","idType":"1","insurantDesc":"","insuredAbbr":"bl","insuredAddress":"","insuredEname":"bingle","insuredId":"4","insuredName":"病了","mobile":"15735920000","occupation":"","relation":""},{"birthday":"","email":"","gender":"","idNo":"33032411","idType":"1","insurantDesc":"","insuredAbbr":"hl","insuredAddress":"","insuredEname":"halou","insuredId":"8","insuredName":"哈喽","mobile":"15735920000","occupation":"","relation":""},{"birthday":"20170214","email":"456789@qq.com","gender":"1","idNo":"330621199192876543","idType":"1","insurantDesc":"cscd","insuredAbbr":"djsc","insuredAddress":"1","insuredEname":"sjd","insuredId":"2","insuredName":"cdss","mobile":"15158125676","occupation":"职业代码","relation":"11"},{"birthday":"","email":"","gender":"","idNo":"33032419","idType":"1","insurantDesc":"","insuredAbbr":"wy","insuredAddress":"","insuredEname":"wangyan，","insuredId":"7","insuredName":"王艳，","mobile":"15735920000","occupation":"","relation":""}],"pageSize":"7","totalCount":"7"}
     * respCode : 000000
     * respMsg : 获取常用保险人成功
     * success : true
     */

        /**
         * insuredList : [{"birthday":"","email":"","gender":"","idNo":"3303","idType":"1","insurantDesc":"","insuredAbbr":"al","insuredAddress":"","insuredEname":"aliang","insuredId":"5","insuredName":"阿亮","mobile":"15735920000","occupation":"","relation":""},{"birthday":"","email":"","gender":"","idNo":"1110","idType":"1","insurantDesc":"","insuredAbbr":"all","insuredAddress":"","insuredEname":"aliaoliao","insuredId":"3","insuredName":"啊聊聊","mobile":"15735920000","occupation":"","relation":""},{"birthday":"","email":"","gender":"","idNo":"3304","idType":"1","insurantDesc":"","insuredAbbr":"alb","insuredAddress":"","insuredEname":"alibin","insuredId":"6","insuredName":"阿里斌","mobile":"15735920000","occupation":"","relation":""},{"birthday":"","email":"","gender":"","idNo":"11101","idType":"1","insurantDesc":"","insuredAbbr":"bl","insuredAddress":"","insuredEname":"bingle","insuredId":"4","insuredName":"病了","mobile":"15735920000","occupation":"","relation":""},{"birthday":"","email":"","gender":"","idNo":"33032411","idType":"1","insurantDesc":"","insuredAbbr":"hl","insuredAddress":"","insuredEname":"halou","insuredId":"8","insuredName":"哈喽","mobile":"15735920000","occupation":"","relation":""},{"birthday":"20170214","email":"456789@qq.com","gender":"1","idNo":"330621199192876543","idType":"1","insurantDesc":"cscd","insuredAbbr":"djsc","insuredAddress":"1","insuredEname":"sjd","insuredId":"2","insuredName":"cdss","mobile":"15158125676","occupation":"职业代码","relation":"11"},{"birthday":"","email":"","gender":"","idNo":"33032419","idType":"1","insurantDesc":"","insuredAbbr":"wy","insuredAddress":"","insuredEname":"wangyan，","insuredId":"7","insuredName":"王艳，","mobile":"15735920000","occupation":"","relation":""}]
         * pageSize : 7
         * totalCount : 7
         */

        private String pageSize;
        private String totalCount;
        private List<InsuredListBean> insuredList;

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

        public List<InsuredListBean> getInsuredList() {
            return insuredList;
        }

        public void setInsuredList(List<InsuredListBean> insuredList) {
            this.insuredList = insuredList;
        }

        public static class InsuredListBean {
            /**
             * birthday :
             * email :
             * gender :
             * idNo : 3303
             * idType : 1
             * insurantDesc :
             * insuredAbbr : al
             * insuredAddress :
             * insuredEname : aliang
             * insuredId : 5
             * insuredName : 阿亮
             * mobile : 15735920000
             * occupation :
             * relation :
             */

            private String birthday;
            private String email;
            private String gender;
            private String idNo;
            private String idType;
            private String insurantDesc;
            private String insuredAbbr;
            private String insuredAddress;
            private String insuredEname;
            private String insuredId;
            private String insuredName;
            private String mobile;
            private String occupation;
            private String relation;

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getIdNo() {
                return idNo;
            }

            public void setIdNo(String idNo) {
                this.idNo = idNo;
            }

            public String getIdType() {
                return idType;
            }

            public void setIdType(String idType) {
                this.idType = idType;
            }

            public String getInsurantDesc() {
                return insurantDesc;
            }

            public void setInsurantDesc(String insurantDesc) {
                this.insurantDesc = insurantDesc;
            }

            public String getInsuredAbbr() {
                return insuredAbbr;
            }

            public void setInsuredAbbr(String insuredAbbr) {
                this.insuredAbbr = insuredAbbr;
            }

            public String getInsuredAddress() {
                return insuredAddress;
            }

            public void setInsuredAddress(String insuredAddress) {
                this.insuredAddress = insuredAddress;
            }

            public String getInsuredEname() {
                return insuredEname;
            }

            public void setInsuredEname(String insuredEname) {
                this.insuredEname = insuredEname;
            }

            public String getInsuredId() {
                return insuredId;
            }

            public void setInsuredId(String insuredId) {
                this.insuredId = insuredId;
            }

            public String getInsuredName() {
                return insuredName;
            }

            public void setInsuredName(String insuredName) {
                this.insuredName = insuredName;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getOccupation() {
                return occupation;
            }

            public void setOccupation(String occupation) {
                this.occupation = occupation;
            }

            public String getRelation() {
                return relation;
            }

            public void setRelation(String relation) {
                this.relation = relation;
            }
        }
}
