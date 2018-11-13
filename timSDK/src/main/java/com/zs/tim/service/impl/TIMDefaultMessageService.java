package com.zs.tim.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zs.tim.ConfigStorage;
import com.zs.tim.Constant;
import com.zs.tim.entity.request.BatchSendMsg;
import com.zs.tim.entity.request.SendMsg;
import com.zs.tim.entity.response.TIMBatchSendMsgResponse;
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
    public TIMSendMsgResponse sendMsg(SendMsg sendMsg) throws JTIMException {
        return RequestUtil.doPost((JSONObject) JSON.toJSON(sendMsg), Constant.URLs.SENDMSG,config,TIMSendMsgResponse.class);
    }

    @Override
    public TIMBatchSendMsgResponse batchSendMsg(BatchSendMsg batchSendMsg) throws JTIMException {
        return RequestUtil.doPost((JSONObject)JSON.toJSON(batchSendMsg),Constant.URLs.BATCHSENDMSG,config,TIMBatchSendMsgResponse.class);
    }
}
