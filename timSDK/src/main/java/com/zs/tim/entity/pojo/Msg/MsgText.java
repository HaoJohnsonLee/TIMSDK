package com.zs.tim.entity.pojo.Msg;

import com.alibaba.fastjson.annotation.JSONField;

public class MsgText implements MsgBody{

    /**
     * msgType : TIMTextElem
     * msgContent : 消息内容
     */
    @JSONField(name = "MsgType")
    private static final String msgType="TIMTextElem";
    @JSONField(name = "MsgContent")
    private MsgContentBean msgContent;

    public MsgText(MsgContentBean msgContent) {
        this.msgContent = msgContent;
    }

    public MsgText() {
    }

    public String getMsgType() {
        return msgType;
    }

    public MsgContentBean getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(MsgContentBean msgContent) {
        this.msgContent = msgContent;
    }

    public static class MsgContentBean {
        /**
         * text : 文本内容
         */
        @JSONField(name = "Text")
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
