package com.bb.hbx.db;

import android.content.ContentValues;
import android.database.Cursor;

import com.bb.hbx.bean.ProductItem;
import com.bb.hbx.bean.Special;


public class SpecialDatabaseBuilder extends DatabaseBuilder<Special> {
    @Override
    public Special build(Cursor query) {

        int columnEndTime = query.getColumnIndex("endTime");
        int columnProductCount = query.getColumnIndex("productCount");
        int columnSpecialContent = query.getColumnIndex("specialContent");
        int columnSpecialId = query.getColumnIndex("specialId");
        int columnSpecialIntro = query.getColumnIndex("specialIntro");
        int columnSpecialLogo = query.getColumnIndex("specialLogo");
        int columnSpecialName = query.getColumnIndex("specialName");
        int columnSpecialType = query.getColumnIndex("specialType");
        int columnSpecialUrl = query.getColumnIndex("specialUrl");
        int columnStartTime = query.getColumnIndex("startTime");

        Special special = new Special();
        special.setEndTime(query.getString(columnEndTime));
        special.setProductCount(query.getString(columnProductCount));
        special.setSpecialContent(query.getString(columnSpecialContent));
        special.setSpecialId(query.getString(columnSpecialId));
        special.setSpecialIntro(query.getString(columnSpecialIntro));
        special.setSpecialLogo(query.getString(columnSpecialLogo));
        special.setSpecialName(query.getString(columnSpecialName));
        special.setSpecialType(query.getInt(columnSpecialType));
        special.setSpecialUrl(query.getString(columnSpecialUrl));
        special.setStartTime(query.getString(columnStartTime));

        return special;
    }

    @Override
    public ContentValues deconstruct(Special info) {
        ContentValues values = new ContentValues();
        values.put("endTime", info.getEndTime());
        values.put("productCount", info.getProductCount());
        values.put("specialContent", info.getSpecialContent());
        values.put("specialId", info.getSpecialId());
        values.put("specialIntro", info.getSpecialIntro());
        values.put("specialLogo", info.getSpecialLogo());
        values.put("specialName", info.getSpecialName());
        values.put("specialType", info.getSpecialType());
        values.put("specialUrl", info.getSpecialUrl());
        values.put("startTime", info.getStartTime());

        return values;
    }
}
