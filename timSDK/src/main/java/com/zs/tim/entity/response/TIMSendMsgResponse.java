package com.zs.tim.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

public class TIMSendMsgResponse extends TIMResponse{
    @JSONField(name="MsgTime")
    String msgTime;

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }
}
