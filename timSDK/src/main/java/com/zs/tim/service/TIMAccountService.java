package com.zs.tim.service;

import com.zs.tim.entity.request.TIMAccount;

import com.zs.tim.entity.response.TIMMultiImportResponse;
import com.zs.tim.entity.response.TIMResponse;
import com.zs.tim.exception.JTIMException;

import java.util.List;


/**
 * 对应账号管理、资料管理、在线状态、群组管理、关系链管理
 */
public interface TIMAccountService {



    String getUserSig(String identifier);

    /**
     * 独立模式 导入账户
     * @param account tencent im 账户
     * @return account imported
     */
    TIMResponse importAccount(TIMAccount account) throws JTIMException;


    /**
     * 批量导入账号
     * @param accountIds 账户ids ，每个id保证32字节以内
     * @return TIMMultiImportResponse
     * @throws JTIMException if request occurred errors
     */
    TIMMultiImportResponse multiImportAccounts(List<String> accountIds) throws JTIMException;

    /**
     *将应用帐号的登录态（比如UserSig）失效，支持一次失效一个帐号
     * @param identifier 用户名
     * @return TIMResponse
     * @throws JTIMException
     */
    TIMResponse kick(String identifier) throws JTIMException;

}
