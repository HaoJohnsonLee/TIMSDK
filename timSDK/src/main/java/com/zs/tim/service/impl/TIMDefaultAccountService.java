package com.zs.tim.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zs.tim.ConfigStorage;
import com.zs.tim.Constant;
import com.zs.tim.entity.TIMAccount;
import com.zs.tim.entity.TIMMultiImportResponse;
import com.zs.tim.entity.TIMResponse;
import com.zs.tim.exception.JTIMException;
import com.zs.tim.service.TIMAccountService;
import com.zs.tim.utils.RequestUtil;

import java.util.List;

public class TIMDefaultAccountService implements TIMAccountService {

    private ConfigStorage config;
    private volatile static TIMDefaultAccountService instance;
    private TIMDefaultAccountService(ConfigStorage config){
        this.config = config;
    }
    public static TIMAccountService getTIMAccountService(ConfigStorage config){
        if(instance == null){
            synchronized (TIMDefaultAccountService.class){
                if(instance == null)
                    instance = new TIMDefaultAccountService(config);
            }
        }
        return instance;
    }

    @Override
    public TIMResponse importAccount(TIMAccount account) throws JTIMException {
        return RequestUtil.doPost((JSONObject) JSON.toJSON(account), Constant.URLs.ACCOUNT_IMPORT, config, TIMResponse.class);
    }

    @Override
    public TIMMultiImportResponse multiImportAccounts(List<String> accountIds) throws JTIMException {
        JSONObject json = new JSONObject();
        json.put("Accounts", accountIds);
        return RequestUtil.doPost(json, Constant.URLs.MULTIACCOUNT_INPORT, config, TIMMultiImportResponse.class);
    }


}
