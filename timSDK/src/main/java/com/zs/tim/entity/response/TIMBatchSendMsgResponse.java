package com.zs.tim.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class TIMBatchSendMsgResponse {

    /**
     * actionStatus : 请求处理的结果
     * errorInfo :错误信息
     * errorList : 发消息失败列表
     */
    @JSONField(name = "ActionStatus")
    private String actionStatus;
    @JSONField(name = "ErrorInfo")
    private String errorInfo;
    @JSONField(name = "ErrorList")
    private List<ErrorListBean> errorList;

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

    public List<ErrorListBean> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<ErrorListBean> errorList) {
        this.errorList = errorList;
    }

    public static class ErrorListBean {
        /**
         * To_Account : 发送消息失败的帐号
         * ErrorCode : 发送失败的错误码。
         */
        @JSONField(name = "To_Account")
        private String to_Account;
        @JSONField(name = "ErrorCode")
        private int errorCode;

        public String getTo_Account() {
            return to_Account;
        }

        public void setTo_Account(String to_Account) {
            this.to_Account = to_Account;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }
    }
}
