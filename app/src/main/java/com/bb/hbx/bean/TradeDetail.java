package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */

public class TradeDetail {


    /**
     * applicant : 唐僧
     * applicantIdNo : 41234123
     * applicantMobile : 532523523
     * claimsURL :
     * classId : 210001
     * discountAmount : -2000
     * endTime : 20170131201755
     * insureAmount : null
     * insuredList : [{"benList":[{"benId":"1","benName":"测试","idNo":"330621198903134672","idType":"1","mobile":"13989857704","relation":""}],"birthday":"20170222143949","detailId":"1","email":"","gender":"男","idNo":"330621198903134672","idType":"1","insureCount":0,"insuredId":"1","insuredName":"","insuredNamePinyin":"","mobile":"","policyURL":""}]
     * insurerId : 1
     * insurerLogo :
     * insurerName : 人保财险
     * orderURL : http://ebao.seaway.net.cn:18100/product_details.html#productDetails/100
     * payAmount : 2000
     * paymentList : []
     * policyId :
     * productId : 100
     * productName : 航空意外保障
     * productProp : 0
     * sex : 1
     * startTime : 20170112201752
     * sts : 20
     * sumAmount : 1000
     * sumPremium : 0
     * tradeAmount : 0
     * tradeId : 20170112194801003
     * tradePeriod : 1个月;1年
     * tradePremium : 0
     * tradeTime : 20170114201749
     * typeList : []
     * userId :
     */

    private String applicant;
    private String applicantIdNo;
    private String applicantMobile;
    private String claimsURL;
    private String classId;
    private String discountAmount;
    private String endTime;
    private String insureAmount;
    private String insurerTels;
    private String insurerId;
    private String insurerLogo;
    private String insurerName;
    private String orderURL;
    private String payAmount;
    private String policyId;
    private String productId;
    private String productName;
    private int applicantType;
    private int productProp;
    private String sex;
    private String startTime;
    private int sts;
    private String sumAmount;
    private String sumPremium;
    private String tradeAmount;
    private String tradeId;
    private String tradePeriod;
    private String tradePremium;
    private String tradeTime;
    private String userId;
    private List<InsuredListBean> insuredList;
    private List<InsuredListBean.Payment> paymentList;
    private List<TradeDetailType> typeList;

    public String getInsurerTels() {
        return insurerTels;
    }

    public void setInsurerTels(String insurerTels) {
        this.insurerTels = insurerTels;
    }

    public int getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(int applicantType) {
        this.applicantType = applicantType;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplicantIdNo() {
        return applicantIdNo;
    }

    public void setApplicantIdNo(String applicantIdNo) {
        this.applicantIdNo = applicantIdNo;
    }

    public String getApplicantMobile() {
        return applicantMobile;
    }

    public void setApplicantMobile(String applicantMobile) {
        this.applicantMobile = applicantMobile;
    }

    public String getClaimsURL() {
        return claimsURL;
    }

    public void setClaimsURL(String claimsURL) {
        this.claimsURL = claimsURL;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getInsureAmount() {
        return insureAmount;
    }

    public void setInsureAmount(String insureAmount) {
        this.insureAmount = insureAmount;
    }

    public String getInsurerId() {
        return insurerId;
    }

    public void setInsurerId(String insurerId) {
        this.insurerId = insurerId;
    }

    public String getInsurerLogo() {
        return insurerLogo;
    }

    public void setInsurerLogo(String insurerLogo) {
        this.insurerLogo = insurerLogo;
    }

    public String getInsurerName() {
        return insurerName;
    }

    public void setInsurerName(String insurerName) {
        this.insurerName = insurerName;
    }

    public String getOrderURL() {
        return orderURL;
    }

    public void setOrderURL(String orderURL) {
        this.orderURL = orderURL;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductProp() {
        return productProp;
    }

    public void setProductProp(int productProp) {
        this.productProp = productProp;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getSts() {
        return sts;
    }

    public void setSts(int sts) {
        this.sts = sts;
    }

    public String getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(String sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(String sumPremium) {
        this.sumPremium = sumPremium;
    }

    public String getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(String tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getTradePeriod() {
        return tradePeriod;
    }

    public void setTradePeriod(String tradePeriod) {
        this.tradePeriod = tradePeriod;
    }

    public String getTradePremium() {
        return tradePremium;
    }

    public void setTradePremium(String tradePremium) {
        this.tradePremium = tradePremium;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<InsuredListBean> getInsuredList() {
        return insuredList;
    }

    public void setInsuredList(List<InsuredListBean> insuredList) {
        this.insuredList = insuredList;
    }

    public List<InsuredListBean.Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<InsuredListBean.Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<TradeDetailType> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<TradeDetailType> typeList) {
        this.typeList = typeList;
    }

    public static class InsuredListBean {
        /**
         * benList : [{"benId":"1","benName":"测试","idNo":"330621198903134672","idType":"1","mobile":"13989857704","relation":""}]
         * birthday : 20170222143949
         * detailId : 1
         * email :
         * gender : 男
         * idNo : 330621198903134672
         * idType : 1
         * insureCount : 0
         * insuredId : 1
         * insuredName :
         * insuredNamePinyin :
         * mobile :
         * policyURL :
         */

        //"carInfo":{"cityName":"杭州","engineNo":"123123","fuelType":"","licenseNo":"浙12345","noLicenseFlag":0,"registerDate":"20170221000000","specialCarDate":"20170228000000","specialCarFlag":1,"vehicleFrameNo":"12345","vehicleModel":"宝马"},"detailId":"156"
        private String birthday;
        private CarInfoBean carInfo;
        private String detailId;
        private String email;
        private String gender;
        private String idNo;
        private String idType;
        private int insureCount;
        private String insuredId;
        private String insuredName;
        private String insuredNamePinyin;
        private String mobile;
        private String policyURL;
        private int relation;
        private List<BenListBean> benList;

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getDetailId() {
            return detailId;
        }

        public CarInfoBean getCarInfo() {
            return carInfo;
        }

        public void setCarInfo(CarInfoBean carInfo) {
            this.carInfo = carInfo;
        }

        public void setDetailId(String detailId) {
            this.detailId = detailId;
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

        public int getInsureCount() {
            return insureCount;
        }

        public void setInsureCount(int insureCount) {
            this.insureCount = insureCount;
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

        public String getInsuredNamePinyin() {
            return insuredNamePinyin;
        }

        public void setInsuredNamePinyin(String insuredNamePinyin) {
            this.insuredNamePinyin = insuredNamePinyin;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPolicyURL() {
            return policyURL;
        }

        public void setPolicyURL(String policyURL) {
            this.policyURL = policyURL;
        }

        public List<BenListBean> getBenList() {
            return benList;
        }

        public void setBenList(List<BenListBean> benList) {
            this.benList = benList;
        }

        public int getRelation() {
            return relation;
        }

        public void setRelation(int relation) {
            this.relation = relation;
        }

        public static class CarInfoBean {
            /**
             * cityName : 杭州
             * engineNo : 123123
             * fuelType :
             * licenseNo : 浙12345
             * noLicenseFlag : 0
             * registerDate : 20170221000000
             * specialCarDate : 20170228000000
             * specialCarFlag : 1
             * vehicleFrameNo : 12345
             * vehicleModel : 宝马
             */

            private String cityName;
            private String engineNo;
            private String fuelType;
            private String licenseNo;
            private int noLicenseFlag;
            private String registerDate;
            private String specialCarDate;
            private int specialCarFlag;
            private String vehicleFrameNo;
            private String vehicleModel;

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getEngineNo() {
                return engineNo;
            }

            public void setEngineNo(String engineNo) {
                this.engineNo = engineNo;
            }

            public String getFuelType() {
                return fuelType;
            }

            public void setFuelType(String fuelType) {
                this.fuelType = fuelType;
            }

            public String getLicenseNo() {
                return licenseNo;
            }

            public void setLicenseNo(String licenseNo) {
                this.licenseNo = licenseNo;
            }

            public int getNoLicenseFlag() {
                return noLicenseFlag;
            }

            public void setNoLicenseFlag(int noLicenseFlag) {
                this.noLicenseFlag = noLicenseFlag;
            }

            public String getRegisterDate() {
                return registerDate;
            }

            public void setRegisterDate(String registerDate) {
                this.registerDate = registerDate;
            }

            public String getSpecialCarDate() {
                return specialCarDate;
            }

            public void setSpecialCarDate(String specialCarDate) {
                this.specialCarDate = specialCarDate;
            }

            public int getSpecialCarFlag() {
                return specialCarFlag;
            }

            public void setSpecialCarFlag(int specialCarFlag) {
                this.specialCarFlag = specialCarFlag;
            }

            public String getVehicleFrameNo() {
                return vehicleFrameNo;
            }

            public void setVehicleFrameNo(String vehicleFrameNo) {
                this.vehicleFrameNo = vehicleFrameNo;
            }

            public String getVehicleModel() {
                return vehicleModel;
            }

            public void setVehicleModel(String vehicleModel) {
                this.vehicleModel = vehicleModel;
            }
        }

        public static class BenListBean {
            /**
             * benId : 1
             * benName : 测试
             * idNo : 330621198903134672
             * idType : 1
             * mobile : 13989857704
             * relation :
             */

            private String benId;
            private String benName;
            private String idNo;
            private String idType;
            private String mobile;
            private String relation;

            public String getBenId() {
                return benId;
            }

            public void setBenId(String benId) {
                this.benId = benId;
            }

            public String getBenName() {
                return benName;
            }

            public void setBenName(String benName) {
                this.benName = benName;
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

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getRelation() {
                return relation;
            }

            public void setRelation(String relation) {
                this.relation = relation;
            }
        }

        public static class Payment {
            private String benId;
            private String paymentName;
            private String payTime;
            private String payAmount;
            private String refundTime;
            private String refundOrganization;
            private String refundAccount;

            public String getBenId() {
                return benId;
            }

            public void setBenId(String benId) {
                this.benId = benId;
            }

            public String getRefundAccount() {
                return refundAccount;
            }

            public void setRefundAccount(String refundAccount) {
                this.refundAccount = refundAccount;
            }

            public String getRefundOrganization() {
                return refundOrganization;
            }

            public void setRefundOrganization(String refundOrganization) {
                this.refundOrganization = refundOrganization;
            }

            public String getRefundTime() {
                return refundTime;
            }

            public void setRefundTime(String refundTime) {
                this.refundTime = refundTime;
            }

            public String getPayTime() {
                return payTime;
            }

            public void setPayTime(String payTime) {
                this.payTime = payTime;
            }

            public String getPayAmount() {
                return payAmount;
            }

            public void setPayAmount(String payAmount) {
                this.payAmount = payAmount;
            }

            public String getPaymentName() {
                return paymentName;
            }

            public void setPaymentName(String paymentName) {
                this.paymentName = paymentName;
            }
        }
    }



}
