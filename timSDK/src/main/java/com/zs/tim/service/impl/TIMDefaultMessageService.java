package com.zs.tim.service.impl;

import com.zs.tim.ConfigStorage;
import com.zs.tim.service.TIMAccountService;
import com.zs.tim.service.TIMMessageService;

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


}
