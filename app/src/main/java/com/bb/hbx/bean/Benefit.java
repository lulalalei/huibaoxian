package com.bb.hbx.bean;

/**
 * Created by Administrator on 2017/2/14.
 */

public class Benefit {


    /**
     * benefitName : 意外身故及伤残
     * insuredAmount : 600,000
     * sortCode :
     */

    private String benefitName;
    private String insuredAmount;
    private String sortCode;

    public String getBenefitName() {
        return benefitName;
    }

    public void setBenefitName(String benefitName) {
        this.benefitName = benefitName;
    }

    public String getInsuredAmount() {
        return insuredAmount;
    }

    public void setInsuredAmount(String insuredAmount) {
        this.insuredAmount = insuredAmount;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }
}
