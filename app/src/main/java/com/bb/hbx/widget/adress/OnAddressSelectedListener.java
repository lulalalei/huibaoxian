package com.bb.hbx.widget.adress;


import com.bb.hbx.base.City;
import com.bb.hbx.base.County;
import com.bb.hbx.base.Province;
import com.bb.hbx.base.Street;

public interface OnAddressSelectedListener {
    void onAddressSelected(Province province, City city, County county, Street street);
}
