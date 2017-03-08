package com.bb.hbx.interfaces;


import com.bb.hbx.bean.Area;


public interface OnAreaSelectedListener {

    //省
    void onAreaProvinceSelected(Area province);

    //市
    void onAreaCitySelected(Area city);
}
