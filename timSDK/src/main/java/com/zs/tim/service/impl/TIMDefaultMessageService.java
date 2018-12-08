package com.zs.tim.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zs.tim.ConfigStorage;
import com.zs.tim.Constant;
import com.zs.tim.entity.request.TIMBatchSendMsg;
import com.zs.tim.entity.request.TIMGetHistory;
import com.zs.tim.entity.request.TIMImportMsg;
import com.zs.tim.entity.request.TIMSendMsg;
import com.zs.tim.entity.response.TIMBatchSendMsgResponse;
import com.zs.tim.entity.response.TIMGetHistoryResponse;
import com.zs.tim.entity.response.TIMResponse;
import com.zs.tim.entity.response.TIMSendMsgResponse;
import com.zs.tim.exception.JTIMException;
import com.zs.tim.service.TIMMessageService;
import com.zs.tim.utils.RequestUtil;

public class TIMDefaultMessageService implements TIMMessageService{
    private ConfigStorage config;
    private volatile static TIMDefaultMessageService instance;
    private TIMDefaultMessageService(ConfigStorage config){
        this.config = config;
    }
    public static TIMMessageService getTIMMessageService(ConfigStorage config){
        if(instance == null){
            synchronized (TIMDefaultMessageService.class){
                if(instance == null)
                    instance = new TIMDefaultMessageService(config);
            }
        }
        return  instance;
    }


    @Override
    public TIMSendMsgResponse sendMsg(TIMSendMsg timSendMsg) throws JTIMException {
        return RequestUtil.doPost((JSONObject) JSON.toJSON(timSendMsg), Constant.URLs.SENDMSG,config,TIMSendMsgResponse.class);
    }

    @Override
    public TIMBatchSendMsgResponse batchSendMsg(TIMBatchSendMsg timBatchSendMsg) throws JTIMException {
        return RequestUtil.doPost((JSONObject)JSON.toJSON(timBatchSendMsg),Constant.URLs.BATCHSENDMSG,config,TIMBatchSendMsgResponse.class);
    }

    @Override
    public TIMResponse importMsg(TIMImportMsg timImportMsg) throws JTIMException {
        return RequestUtil.doPost((JSONObject)JSON.toJSON(timImportMsg),Constant.URLs.IMPORTMSG,config,TIMResponse.class);
    }

    @Override
    public TIMGetHistoryResponse getHistory(TIMGetHistory timGetHistory) throws JTIMException {
        return RequestUtil.doPost((JSONObject)JSON.toJSON(timGetHistory),Constant.URLs.GET_HISTORY,config,TIMGetHistoryResponse.class);
    }
}
