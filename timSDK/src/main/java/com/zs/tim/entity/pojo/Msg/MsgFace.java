package com.zs.tim.entity.pojo.Msg;

import com.alibaba.fastjson.annotation.JSONField;

public class MsgFace implements MsgBody {

    /**
     * msgType : TIMFaceElem
     * MsgContent : 表情内容
     */
    @JSONField(name="MsgType")
    private static final String msgType="TIMFaceElem";
    @JSONField(name = "MsgContent")
    private MsgContentBean msgContent;

    public MsgFace(MsgContentBean msgContent) {
        this.msgContent = msgContent;
    }

    public MsgFace() {
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
         * index : 表情索引，用户自定义。
         * data : 额外数据
         */
        @JSONField(name = "Index")
        private int index;
        @JSONField(name = "Data")
        private String data;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
