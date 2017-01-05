package com.bb.hbx.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bb.hbx.sqlite.MySqlite;

/**
 * Created by Administrator on 2017/1/5.
 */

public class MyUsersSqlite {

    public static MySqlite help;
    public static SQLiteDatabase db;
    public static void initUsersdb(Context context)
    {
        help= new MySqlite(context, "usersdb");
        db = help.getReadableDatabase();
    }
}
