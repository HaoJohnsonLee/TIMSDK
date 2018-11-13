package com.zs.tim.entity.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.zs.tim.entity.pojo.Msg.MsgBody;

import java.util.List;

public class SendMsg {

    /**
     * syncOtherMachine : 若不希望将消息同步至 From_Account，则 SyncOtherMachine 填写 2。
     *                    若希望将消息同步至 From_Account，则 SyncOtherMachine 填写 1。
     *                    若不填写默认情况下会将消息存 From_Account 漫游
     * to_Account : 消息发送方帐号
     * msgLifeTime : 消息离线保存时长
     * msgRandom : 消息随机数
     * msgTimeStamp : 消息时间戳
     * msgBodies:MsgBody中所填写字段是消息内容，支持一条消息中包括多种消息元素类
     * OfflinePushInfo:离线推送
     */
    @JSONField(name = "SyncOtherMachine")
    private int syncOtherMachine;
    @JSONField(name = "To_Account")
    private String to_Account;
    @JSONField(name = "MsgLifeTime")
    private int msgLifeTime;
    @JSONField(name = "MsgRandom")
    private int msgRandom;
    @JSONField(name = "MsgTimeStamp")
    private int msgTimeStamp;
    @JSONField(name = "MsgBody")
    private List<MsgBody> msgBodies;
    @JSONField(name = "OfflinePushInfo")
    private OfflinePushInfoBean offlinePushInfo;


    public List<MsgBody> getMsgBodies() {
        return msgBodies;
    }

    public void setMsgBodies(List<MsgBody> msgBodies) {
        this.msgBodies = msgBodies;
    }


    public int getSyncOtherMachine() {
        return syncOtherMachine;
    }

    public void setSyncOtherMachine(int syncOtherMachine) {
        this.syncOtherMachine = syncOtherMachine;
    }

    public String getTo_Account() {
        return to_Account;
    }

    public void setTo_Account(String to_Account) {
        this.to_Account = to_Account;
    }

    public int getMsgLifeTime() {
        return msgLifeTime;
    }

    public void setMsgLifeTime(int msgLifeTime) {
        this.msgLifeTime = msgLifeTime;
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

    public OfflinePushInfoBean getOfflinePushInfo() {
        return offlinePushInfo;
    }

    public void setOfflinePushInfo(OfflinePushInfoBean offlinePushInfo) {
        this.offlinePushInfo = offlinePushInfo;
    }

    public static class OfflinePushInfoBean {
        /**
         * PushFlag : 0表示推送，1表示不离线推送。
         * Title : 离线推送标题
         * Desc : 离线推送内容
         * Ext : 离线推送透传内容
         * AndroidInfo : {"Sound":"android.mp3"}
         * ApnsInfo : {"Sound":"apns.mp3","BadgeMode":1,"Title":"apns title","SubTitle":"apns subtitle","Image":"www.image.com"}
         */
        @JSONField(name = "PushFlag")
        private int pushFlag;
        @JSONField(name = "Title")
        private String title;
        @JSONField(name = "Desc")
        private String desc;
        @JSONField(name = "Ext")
        private String ext;
        @JSONField(name = "AndroidInfo")
        private AndroidInfoBean androidInfo;
        @JSONField(name = "ApnsInfo")
        private ApnsInfoBean apnsInfo;

        public int getPushFlag() {
            return pushFlag;
        }

        public void setPushFlag(int pushFlag) {
            this.pushFlag = pushFlag;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public AndroidInfoBean getAndroidInfo() {
            return androidInfo;
        }

        public void setAndroidInfo(AndroidInfoBean androidInfo) {
            this.androidInfo = androidInfo;
        }

        public ApnsInfoBean getApnsInfo() {
            return apnsInfo;
        }

        public void setApnsInfo(ApnsInfoBean apnsInfo) {
            this.apnsInfo = apnsInfo;
        }

        public static class AndroidInfoBean {
            /**
             * Sound : 离线推送声音文件路径。
             */
            @JSONField(name = "Sound")
            private String sound;

            public String getSound() {
                return sound;
            }

            public void setSound(String sound) {
                this.sound = sound;
            }
        }

        public static class ApnsInfoBean {
            /**
             * Sound : 离线推送声音文件路径
             * BadgeMode : 这个字段缺省或者为 0 表示需要计数，为 1 表示本条消息不需要计数，即右上角图标数字不增加
             * Title : 标识apns推送的标题
             * SubTitle : 标识apns推送的子标题
             * Image : 标识apns携带的图片地址
             */
            @JSONField(name = "Sound")
            private String sound;
            @JSONField(name = "Sound")
            private int badgeMode;
            @JSONField(name = "Sound")
            private String title;
            @JSONField(name = "Sound")
            private String subTitle;
            @JSONField(name = "Sound")
            private String image;

            public String getSound() {
                return sound;
            }

            public void setSound(String sound) {
                this.sound = sound;
            }

            public int getBadgeMode() {
                return badgeMode;
            }

            public void setBadgeMode(int badgeMode) {
                this.badgeMode = badgeMode;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(String subTitle) {
                this.subTitle = subTitle;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
    }
}
