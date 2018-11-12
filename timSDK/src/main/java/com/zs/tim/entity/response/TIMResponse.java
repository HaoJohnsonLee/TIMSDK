package com.zs.tim.entity.response;


import com.alibaba.fastjson.annotation.JSONField;

/**
 * TIM base response
 */
public class TIMResponse {
    @JSONField(name = "ActionStatus")
    private String actionStatus;
    @JSONField(name = "ErrorInfo")
    private String errorInfo;
    @JSONField(name = "ErrorCode")
    private int errorCode;

    public String getActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(String actionStatus) {
        this.actionStatus = actionStatus;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
