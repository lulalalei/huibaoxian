package com.bb.hbx.bean;

import com.bb.hbx.widget.multitype.data.Item;

/**
 * Created by Administrator on 2017/2/20.
 */

public class Insurer implements Item {

    /**
     * businessDesc :
     * commisionDesc :
     * insurerId : 8
     * insurerIntro :
     * insurerLevel : 1
     * insurerLogo : http://img.51hbx.com/resource/images/product/1486975205945.jpeg
     * insurerName : 测试1111
     * insurerNickname :
     * insurerTels : 010-88888888
     * insurerType : 10
     */

    private String businessDesc;
    private String commisionDesc;
    private int insurerId;
    private String insurerIntro;
    private int insurerLevel;
    private String insurerLogo;
    private String insurerName;
    private String insurerNickname;
    private String insurerTels;
    private int insurerType;

    public String getBusinessDesc() {
        return businessDesc;
    }

    public void setBusinessDesc(String businessDesc) {
        this.businessDesc = businessDesc;
    }

    public String getCommisionDesc() {
        return commisionDesc;
    }

    public void setCommisionDesc(String commisionDesc) {
        this.commisionDesc = commisionDesc;
    }

    public int getInsurerId() {
        return insurerId;
    }

    public void setInsurerId(int insurerId) {
        this.insurerId = insurerId;
    }

    public String getInsurerIntro() {
        return insurerIntro;
    }

    public void setInsurerIntro(String insurerIntro) {
        this.insurerIntro = insurerIntro;
    }

    public int getInsurerLevel() {
        return insurerLevel;
    }

    public void setInsurerLevel(int insurerLevel) {
        this.insurerLevel = insurerLevel;
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

    public String getInsurerNickname() {
        return insurerNickname;
    }

    public void setInsurerNickname(String insurerNickname) {
        this.insurerNickname = insurerNickname;
    }

    public String getInsurerTels() {
        return insurerTels;
    }

    public void setInsurerTels(String insurerTels) {
        this.insurerTels = insurerTels;
    }

    public int getInsurerType() {
        return insurerType;
    }

    public void setInsurerType(int insurerType) {
        this.insurerType = insurerType;
    }
}
