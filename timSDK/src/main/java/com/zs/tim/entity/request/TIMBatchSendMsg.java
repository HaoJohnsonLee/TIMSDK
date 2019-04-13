package com.zs.tim.entity.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.zs.tim.entity.pojo.Msg.MsgBody;

import java.util.List;

public class TIMBatchSendMsg {

    /**
     * syncOtherMachine : 消息同步
     * from_Account : 管理员指定消息发送方帐号
     * to_Account : 消息接收方用户 identifier。
     * msgRandom : 消息随机数
     * msgBody : TIM 消息
     * offlinePushInfo : 离线推送信息配置
     */
    @JSONField(name = "SyncOtherMachine")
    private int syncOtherMachine;
    @JSONField(name = "From_Account")
    private String from_Account;
    @JSONField(name = "MsgRandom")
    private int msgRandom;
    @JSONField(name = "OfflinePushInfo")
    private OfflinePushInfoBean offlinePushInfo;
    @JSONField(name = "To_Account")
    private List<String> to_Account;
    @JSONField(name = "MsgBody")
    private List<MsgBody> msgBody;

    public List<MsgBody> getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(List<MsgBody> msgBody) {
        this.msgBody = msgBody;
    }

    public int getSyncOtherMachine() {
        return syncOtherMachine;
    }

    public void setSyncOtherMachine(int syncOtherMachine) {
        this.syncOtherMachine = syncOtherMachine;
    }

    public String getFrom_Account() {
        return from_Account;
    }

    public void setFrom_Account(String from_Account) {
        this.from_Account = from_Account;
    }

    public int getMsgRandom() {
        return msgRandom;
    }

    public void setMsgRandom(int msgRandom) {
        this.msgRandom = msgRandom;
    }

    public OfflinePushInfoBean getOfflinePushInfo() {
        return offlinePushInfo;
    }

    public void setOfflinePushInfo(OfflinePushInfoBean offlinePushInfo) {
        this.offlinePushInfo = offlinePushInfo;
    }

    public List<String> getTo_Account() {
        return to_Account;
    }

    public void setTo_Account(List<String> to_Account) {
        this.to_Account = to_Account;
    }


    public static class OfflinePushInfoBean {
        /**
         * pushFlag : 0
         * desc : 离线推送内容
         * ext : 这是透传的内容
         * androidInfo : {"sound":"android.mp3"}
         * apnsInfo : {"sound":"apns.mp3","badgeMode":1,"title":"apns title","subTitle":"apns subtitle","image":"www.image.com"}
         */
        @JSONField(name = "PushFlag")
        private int pushFlag;
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
             * sound : android.mp3
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
             * sound : apns.mp3
             * badgeMode : 1
             * title : apns title
             * subTitle : apns subtitle
             * image : www.image.com
             */
            @JSONField(name = "Sound")
            private String sound;
            @JSONField(name = "BadgeMode")
            private int badgeMode;
            @JSONField(name = "Title")
            private String title;
            @JSONField(name = "SubTitle")
            private String subTitle;
            @JSONField(name = "Image")
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
