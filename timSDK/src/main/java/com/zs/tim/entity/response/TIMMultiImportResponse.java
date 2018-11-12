package com.zs.tim.entity.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.zs.tim.entity.response.TIMResponse;

import java.util.List;

public class TIMMultiImportResponse extends TIMResponse {

    @JSONField(name = "FailAccounts")
    private List<String> failAccounts;

    public List<String> getFailAccounts() {
        return failAccounts;
    }

    public void setFailAccounts(List<String> failAccounts) {
        this.failAccounts = failAccounts;
    }
}
