package com.bb.hbx.db;

import android.content.ContentValues;
import android.database.Cursor;

import com.bb.hbx.bean.HomePageInfo;
import com.bb.hbx.bean.ProductItem;


public class ProductItemDatabaseBuilder extends DatabaseBuilder<ProductItem> {
    @Override
    public ProductItem build(Cursor query) {

        int columnInsurerTypeId = query.getColumnIndex("insurerTypeId");
        int columnInsurerTypeLogo = query.getColumnIndex("insurerTypeLogo");
        int columnInsurerTypeName = query.getColumnIndex("insurerTypeName");
        int columnInsurerTypeUrl = query.getColumnIndex("insurerTypeUrl");

        ProductItem productItem = new ProductItem();

        productItem.setInsurerTypeId(query.getString(columnInsurerTypeId));
        productItem.setInsurerTypeLogo(query.getString(columnInsurerTypeLogo));
        productItem.setInsurerTypeName(query.getString(columnInsurerTypeName));
        productItem.setInsurerTypeUrl(query.getString(columnInsurerTypeUrl));

        return productItem;
    }

    @Override
    public ContentValues deconstruct(ProductItem info) {
        ContentValues values = new ContentValues();
        values.put("insurerTypeId", info.getInsurerTypeId());
        values.put("insurerTypeLogo", info.getInsurerTypeLogo());
        values.put("insurerTypeName", info.getInsurerTypeName());
        values.put("insurerTypeUrl", info.getInsurerTypeUrl());
        return values;
    }
}
