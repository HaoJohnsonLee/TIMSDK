package com.zs.tim.entity.request;

import com.alibaba.fastjson.annotation.JSONField;

public class TIMGetHistory {

    /**
     * ChatType : 消息类型，C2C:单发消息 Group:群组消息。
     * MsgTime : 2015120121需要下载的时间段,2015120121 表示获取 2015 年 12 月 1 日 21:00~21:59 的消息的下载地址
     */
    @JSONField(name = "ChatType")
    private String chatType;
    @JSONField(name = "MsgTime")
    private String msgTime;

    public TIMGetHistory(String chatType, String msgTime) {
        this.chatType = chatType;
        this.msgTime = msgTime;
    }

    public TIMGetHistory() {
    }

    public String getChatType() {
        return chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }
}
