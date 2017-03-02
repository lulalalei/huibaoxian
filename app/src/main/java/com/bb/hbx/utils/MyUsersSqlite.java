package com.bb.hbx.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bb.hbx.db.DatabaseImpl;

/**
 * Created by Administrator on 2017/1/5.
 */

public class MyUsersSqlite {

    //public static MySqlite help;
    public static DatabaseImpl help;
    public static SQLiteDatabase db;
    public static void initUsersdb(Context context)
    {
        help = DatabaseImpl.getInstance();
        db = help.getReadableDatabase();

    }
}
