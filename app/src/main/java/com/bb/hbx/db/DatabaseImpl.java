package com.bb.hbx.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bb.hbx.MyApplication;
import com.bb.hbx.bean.LishiSearchBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/3.
 */

public class DatabaseImpl extends SQLiteOpenHelper implements Database {


    private static DatabaseImpl helper;

    private static final String DB_NAME = "db_huibx.db";

    private static final String TABLE_SEARCH_HISTORY = "db_search_history";

    private static final int version = 1;


    private DatabaseImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public static synchronized DatabaseImpl getInstance() {
        if (helper == null) {
            helper = new DatabaseImpl(MyApplication.getAppContext(), DB_NAME, null, version);//数据库名称为create_db。
        }
        return helper;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS " +
                TABLE_SEARCH_HISTORY +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR" + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    @Override
    public void addHistory(LishiSearchBean bean) {

        SQLiteDatabase db = getWritableDatabase();
        if (db == null) return;
        ContentValues values = new ContentValues();
        values.put("name", bean.getName());
        String[] whereArgs = {bean.getName()};
        int row_count = db.update(TABLE_SEARCH_HISTORY, values, "name=?", whereArgs);
        if (row_count == 0) {
            db.insert(TABLE_SEARCH_HISTORY, null, values);
        }

        db.close();
    }

    @Override
    public void deleteHistory(LishiSearchBean bean) {
        SQLiteDatabase db = getWritableDatabase();
        if (db == null) return;
        String[] whereArgs = {bean.getName()};
        db.delete(TABLE_SEARCH_HISTORY, "name=?", whereArgs);
        db.close();
    }

    @Override
    public void deleteAllHis() {
        SQLiteDatabase db = getWritableDatabase();
        if (db == null) return;
        db.delete(TABLE_SEARCH_HISTORY, null, null);
        db.close();
    }

    @Override
    public List<LishiSearchBean> getListHis() {
        List<LishiSearchBean> infos = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        if (db == null) return infos;
        Cursor cursor = db.query(TABLE_SEARCH_HISTORY, null, null, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                LishiSearchBean bean = new LishiSearchBean(cursor.getString(cursor.getColumnIndex("name")));
                infos.add(bean);

            }
        }
        cursor.close();
        db.close();
        return infos;
    }
}
