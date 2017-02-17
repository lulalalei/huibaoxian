package com.bb.hbx.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/14.
 */

public class TypeModel implements Serializable{


    /**
     * count : 0
     * typeId : 210001
     * typeList : []
     * typeName : 航空意外险
     */

    private String count;
    private String typeId;
    private String typeName;
    private List<TypeModel> typeList;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<TypeModel> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<TypeModel> typeList) {
        this.typeList = typeList;
    }
}
