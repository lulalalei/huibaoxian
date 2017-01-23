package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/21.
 */

public class AreasListBean {

    /**
     * output : {"areaList":[{"areaId":"110000","areaName":"bjs","fullName":"11"},{"areaId":"110100","areaName":"bjs","fullName":"20"}]}
     */
        private List<AreaListBean> areaList;

        public List<AreaListBean> getAreaList() {
            return areaList;
        }

        public void setAreaList(List<AreaListBean> areaList) {
            this.areaList = areaList;
        }

        public static class AreaListBean {
            /**
             * areaId : 110000
             * areaName : bjs
             * fullName : 11
             */

            private String areaId;
            private String areaName;
            private String fullName;

            public String getAreaId() {
                return areaId;
            }

            public void setAreaId(String areaId) {
                this.areaId = areaId;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }

            public String getFullName() {
                return fullName;
            }

            public void setFullName(String fullName) {
                this.fullName = fullName;
            }
        }
}
