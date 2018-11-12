package com.zs.tim.entity;


import com.alibaba.fastjson.annotation.JSONField;

/**
 * tim 账户
 * 对接tencent
 */
public class TIMAccount {
    /**
     * 系统内唯一id 双方
     */
    @JSONField(name = "Identifier")
    private String identifier;
    /**
     * tencent -》 昵称
     */
    @JSONField(name = "Nick")
    private String nick;

    /**
     * tencent -》头像链接
     */
    @JSONField(name = "FaceUrl")
    private String faceUrl;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }
}
