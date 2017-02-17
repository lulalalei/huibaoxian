package com.bb.hbx.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/14.
 */

public class ClassName {
    private String className="";

    private List<Benefit>benefitList;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Benefit> getBenefitList() {
        return benefitList;
    }

    public void setBenefitList(List<Benefit> benefitList) {
        this.benefitList = benefitList;
    }
}
