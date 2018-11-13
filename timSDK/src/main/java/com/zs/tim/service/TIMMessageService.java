package com.zs.tim.service;


import com.zs.tim.entity.request.BatchSendMsg;
import com.zs.tim.entity.request.SendMsg;
import com.zs.tim.entity.response.TIMBatchSendMsgResponse;
import com.zs.tim.entity.response.TIMSendMsgResponse;
import com.zs.tim.exception.JTIMException;

/**
 * 对应 消息推送、单聊消息、全局禁言管理、数据下载、脏字管理
 */
public interface TIMMessageService {
    /**单发单聊消息
     *功能:管理员向帐号发消息，接收方看到消息发送者是管理员；
     *       管理员指定某一账户向其他账户发消息，接收方看到发送者不是管理员，而是管理员指定的帐号。
     * @param sendMsg 请求包
     * @return TIMSendMsgResponse 应答包
     */
    TIMSendMsgResponse sendMsg(SendMsg sendMsg) throws JTIMException;
    TIMBatchSendMsgResponse batchSendMsg(BatchSendMsg batchSendMsg) throws JTIMException;
}
