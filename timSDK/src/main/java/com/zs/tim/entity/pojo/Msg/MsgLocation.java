package com.zs.tim.entity.pojo.Msg;

import com.alibaba.fastjson.annotation.JSONField;

public class MsgLocation implements MsgBody{

    /**
     * msgType : TIMLocationElem
     * msgContent : 地理位置消息内容
     */
    @JSONField(name = "MsgType")
    private static final String msgType="TIMLocationElem";
    @JSONField(name = "MsgContent")
    private MsgContentBean msgContent;

    public MsgLocation(MsgContentBean msgContent) {
        this.msgContent = msgContent;
    }

    public MsgLocation() {
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
         * desc : 地理位置描述信息。
         * latitude : 经度
         * longitude : 纬度
         */
        @JSONField(name = "Desc")
        private String desc;
        @JSONField(name = "Latitude")
        private double latitude;
        @JSONField(name = "Longitude")
        private double longitude;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }
}
