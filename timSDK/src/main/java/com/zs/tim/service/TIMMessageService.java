package com.zs.tim.service;


import com.zs.tim.entity.request.TIMBatchSendMsg;
import com.zs.tim.entity.request.TIMGetHistory;
import com.zs.tim.entity.request.TIMImportMsg;
import com.zs.tim.entity.request.TIMSendMsg;
import com.zs.tim.entity.response.TIMBatchSendMsgResponse;
import com.zs.tim.entity.response.TIMGetHistoryResponse;
import com.zs.tim.entity.response.TIMResponse;
import com.zs.tim.entity.response.TIMSendMsgResponse;
import com.zs.tim.exception.JTIMException;

/**
 * 对应 消息推送、单聊消息、全局禁言管理、数据下载、脏字管理
 */
public interface TIMMessageService {
    /**单发单聊消息
     *功能:管理员向帐号发消息，接收方看到消息发送者是管理员；
     *       管理员指定某一账户向其他账户发消息，接收方看到发送者不是管理员，而是管理员指定的帐号。
     * @param timSendMsg 请求包
     * @return TIMSendMsgResponse 应答包
     */
    TIMSendMsgResponse sendMsg(TIMSendMsg timSendMsg) throws JTIMException;

    /**
     *批量发单聊消息
     * @param timBatchSendMsg 请求包
     * @return TIMBatchSendMsgResponse 应答包
     * @throws JTIMException
     */
    TIMBatchSendMsgResponse batchSendMsg(TIMBatchSendMsg timBatchSendMsg) throws JTIMException;

    /**
     *导入单聊消息
     * @param timImportMsg 请求包
     * @return TIMResponse应答包
     * @throws JTIMException
     */
    TIMResponse importMsg(TIMImportMsg timImportMsg) throws JTIMException;

    /**
     *数据下载/消息记录下载
     * @param timGetHistory
     * @return TIMGetHistoryResponse 应答包
     * @throws JTIMException
     */
    TIMGetHistoryResponse getHistory(TIMGetHistory timGetHistory) throws JTIMException;

    TIMSendMsgResponse sendTextMsg(String to, String content) throws JTIMException;
}
