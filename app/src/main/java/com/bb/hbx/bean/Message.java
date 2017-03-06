package com.bb.hbx.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/1/23.
 */

@Entity
public class Message {


    /**
     * msgContent : 恭喜周伟亮下单成功获得100万元返利
     * msgId : 4
     * msgLink :
     * msgTime : 20170121173832
     * msgTitle : 系统消息
     * msgType : 1
     * sts : 1
     */

    @Id(autoincrement = true)
    long id;
    private String msgContent;
    private String msgId;
    private String msgLink;
    private String msgTime;
    private String msgTitle;
    private String msgType;
    private int sts;

    @Keep
    public Message(long id, String msgContent, String msgId, String msgLink, String msgTime, String msgTitle, String msgType, int sts) {
        this.id = id;
        this.msgContent = msgContent;
        this.msgId = msgId;
        this.msgLink = msgLink;
        this.msgTime = msgTime;
        this.msgTitle = msgTitle;
        this.msgType = msgType;
        this.sts = sts;
    }

    @Generated(hash = 637306882)
    public Message() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgLink() {
        return msgLink;
    }

    public void setMsgLink(String msgLink) {
        this.msgLink = msgLink;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public int getSts() {
        return sts;
    }

    public void setSts(int sts) {
        this.sts = sts;
    }
}
