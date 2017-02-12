package com.bb.hbx.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.bb.hbx.bean.HomePageInfo;



public class HomePageInfoDatabaseBuilder extends DatabaseBuilder<HomePageInfo> {
    @Override
    public HomePageInfo build(Cursor query) {

        int columnLoop = query.getColumnIndex("loop");
        int columnShowTime = query.getColumnIndex("showTime");
        int columnIataCodeVersion = query.getColumnIndex("iataCodeVersion");
        int columnAreaVersion = query.getColumnIndex("areaVersion");
        HomePageInfo homePageInfo = new HomePageInfo();
        homePageInfo.setLoop(query.getString(columnLoop));
        homePageInfo.setShowTime(query.getString(columnShowTime));
        homePageInfo.setIataCodeVersion(query.getString(columnIataCodeVersion));
        homePageInfo.setAreaVersion(query.getString(columnAreaVersion));

        return homePageInfo;
    }

    @Override
    public ContentValues deconstruct(HomePageInfo info) {
        ContentValues values = new ContentValues();
        values.put("id", 1);
        values.put("loop", info.getLoop());
        values.put("showTime", info.getShowTime());
        values.put("iataCodeVersion", info.getIataCodeVersion());
        values.put("areaVersion", info.getAreaVersion());
        return values;
    }
}
