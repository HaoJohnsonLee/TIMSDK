package com.zs.tim.entity.pojo.Msg;

import com.alibaba.fastjson.annotation.JSONField;

public class MsgCustom implements MsgBody {

    /**
     * msgType : TIMCustomElem
     * msgContent : 自定义消息元素内容
     */
    @JSONField(name = "MsgType")
    private static final String msgType="TIMCustomElem";
    @JSONField(name = "MsgContent")
    private MsgContentBean msgContent;

    public MsgCustom(MsgContentBean msgContent) {
        this.msgContent = msgContent;
    }

    public MsgCustom() {
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
         * data : 自定义消息数据。 不作为APNS的payload中字段下发，
         *          故从payload中无法获取Data字段。
         * desc : 自定义消息描述信息
         * ext : 扩展字段
         * sound : 自定义APNS推送铃音
         */
        @JSONField(name = "Data")
        private String data;
        @JSONField(name = "Desc")
        private String desc;
        @JSONField(name = "Ext")
        private String ext;
        @JSONField(name = "Sound")
        private String sound;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public String getSound() {
            return sound;
        }

        public void setSound(String sound) {
            this.sound = sound;
        }
    }
}
