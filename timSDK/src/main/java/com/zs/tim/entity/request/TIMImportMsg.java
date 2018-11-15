package com.zs.tim.entity.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.zs.tim.entity.pojo.Msg.MsgBody;

import java.util.List;

public class TIMImportMsg {

    /**
     * syncFromOldSystem : 1:实时消息导入，消息加入未读计数;2:历史消息导入，消息不计入未读。
     * from_Account : 消息发送方帐号
     * to_Account : 消息接收方帐号。
     * msgRandom : 消息随机数
     * msgTimeStamp : 消息时间戳
     * msgBody : 消息内容(本条消息包括两种消息元素，一个文本和一个表情)
     */
    @JSONField(name = "SyncFromOldSystem")
    private int syncFromOldSystem;
    @JSONField(name = "from_Account")
    private String from_Account;
    @JSONField(name = "to_Account")
    private String to_Account;
    @JSONField(name = "msgRandom")
    private int msgRandom;
    @JSONField(name = "msgTimeStamp")
    private int msgTimeStamp;
    @JSONField(name = "MsgBody")
    private List<MsgBody> msgBodies;

    public List<MsgBody> getMsgBodies() {
        return msgBodies;
    }
    public void setMsgBodies(List<MsgBody> msgBodies) {
        this.msgBodies = msgBodies;
    }

    public int getSyncFromOldSystem() {
        return syncFromOldSystem;
    }

    public void setSyncFromOldSystem(int syncFromOldSystem) {
        this.syncFromOldSystem = syncFromOldSystem;
    }

    public String getFrom_Account() {
        return from_Account;
    }

    public void setFrom_Account(String from_Account) {
        this.from_Account = from_Account;
    }

    public String getTo_Account() {
        return to_Account;
    }

    public void setTo_Account(String to_Account) {
        this.to_Account = to_Account;
    }

    public int getMsgRandom() {
        return msgRandom;
    }

    public void setMsgRandom(int msgRandom) {
        this.msgRandom = msgRandom;
    }

    public int getMsgTimeStamp() {
        return msgTimeStamp;
    }

    public void setMsgTimeStamp(int msgTimeStamp) {
        this.msgTimeStamp = msgTimeStamp;
    }


}
