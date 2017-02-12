package com.bb.hbx.db;

import android.content.ContentValues;
import android.database.Cursor;

import com.bb.hbx.bean.AdBean;
import com.bb.hbx.bean.XhbMsg;


public class XhbMsgDatabaseBuilder extends DatabaseBuilder<XhbMsg> {
    @Override
    public XhbMsg build(Cursor query) {
        int columnMsgContent = query.getColumnIndex("msgContent");
        int columnMsgId = query.getColumnIndex("msgId");
        int columnMsgLink = query.getColumnIndex("msgLink");
        int columnMsgTime = query.getColumnIndex("msgTime");

        int columnMsgTitle = query.getColumnIndex("msgTitle");
        int columnMsgType = query.getColumnIndex("msgType");
        int columnSts = query.getColumnIndex("sts");
        XhbMsg xhbMsg = new XhbMsg();
        xhbMsg.setMsgContent(query.getString(columnMsgContent));
        xhbMsg.setMsgId(query.getString(columnMsgId));
        xhbMsg.setMsgLink(query.getString(columnMsgLink));
        xhbMsg.setMsgTime(query.getString(columnMsgTime));
        xhbMsg.setMsgTitle(query.getString(columnMsgTitle));
        xhbMsg.setMsgType(query.getString(columnMsgType));
        xhbMsg.setSts(query.getInt(columnSts));
        return xhbMsg;
    }

    @Override
    public ContentValues deconstruct(XhbMsg info) {
        ContentValues values = new ContentValues();
        values.put("msgContent", info.getMsgContent());
        values.put("msgId", info.getMsgId());
        values.put("msgLink", info.getMsgLink());
        values.put("msgTime", info.getMsgTime());
        values.put("msgTitle", info.getMsgTitle());
        values.put("msgType", info.getMsgType());
        values.put("sts", info.getSts());

        return values;
    }
}
