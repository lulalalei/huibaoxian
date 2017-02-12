package com.bb.hbx.db;

import android.content.ContentValues;
import android.database.Cursor;

import com.bb.hbx.bean.AdBean;


public class AdbeanDatabaseBuilder extends DatabaseBuilder<AdBean> {
    @Override
    public AdBean build(Cursor query) {
        int columnAdLink = query.getColumnIndex("adLink");
        int columnAdURL = query.getColumnIndex("adURL");
        AdBean adBean = new AdBean();
        adBean.setAdLink(query.getString(columnAdLink));
        adBean.setAdURL(query.getString(columnAdURL));
        return adBean;
    }

    @Override
    public ContentValues deconstruct(AdBean info) {
        ContentValues values = new ContentValues();
        values.put("adLink", info.getAdLink());
        values.put("adURL", info.getAdURL());
        return values;
    }
}
