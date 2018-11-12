package com.zs.tim.service.impl;

import com.zs.tim.ConfigStorage;
import com.zs.tim.service.TIMAccountService;
import com.zs.tim.service.TIMMessageService;
import com.zs.tim.service.TIMService;


/**
 * 最好确保单例存在
 */
public class TIMDefaultService implements TIMService {

    /**
     * 全局唯一即可
     */
    private ConfigStorage config;

    private TIMAccountService timAccountService;

    public TIMDefaultService(ConfigStorage config){
        this.config = config;
    }
    @Override
    public TIMAccountService getTIMAccountService() {
        if(timAccountService == null)
            timAccountService = TIMDefaultAccountService.getTIMAccountService(config);
        return timAccountService;
    }

    @Override
    public TIMMessageService getTIMMessageService() {
        return null;
    }


}
