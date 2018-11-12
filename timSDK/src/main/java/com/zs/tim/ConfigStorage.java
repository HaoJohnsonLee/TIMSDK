package com.zs.tim;


import com.tls.tls_sigature.tls_sigature;
import com.zs.tim.exception.JTIMException;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 腾讯云信配置实体
 */
public class ConfigStorage {

    private String ver = "v4";
    /** 必填*/
    private long sdkappid;
    private String contenttype = "json";
    /** 必填*/
    private String identifier;
    private String usersig;
    private String random;
    private tls_sigature.GenTLSSignatureResult genTLSSignatureResult;
    private boolean isChecked = false;
    private Map<String, String> params;

    /** 必填 私钥*/
    private String priStr;

    public void check() {
        if (sdkappid == 0)
            isChecked = false;
        else
            isChecked = StringUtils.isNoneBlank(String.valueOf(sdkappid), identifier, getUsersig());

    }

    public boolean isChecked() {
        return isChecked;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public long getSdkappid() {
        return sdkappid;
    }

    public void setSdkappid(long sdkappid) {
        this.sdkappid = sdkappid;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getUsersig() {
        if (genTLSSignatureResult == null) {
            genTLSSignatureResult = tls_sigature.GenTLSSignatureEx(sdkappid, identifier, priStr);
        }
        this.usersig = genTLSSignatureResult.urlSig;
        return usersig;
    }


    public String getRandom() {
        Random random = new Random();
        return this.random = String.valueOf(Math.abs(random.nextInt()));
    }

    /**
     * 全局在此检查设置情况
     *
     * @return this -> map
     * @throws JTIMException if some key params is null
     */
    public Map<String, String> getParams() throws JTIMException {
        if (!isChecked) {
            check();
        }
        if (isChecked) {
            params = new HashMap<>();
            params.put("sdkappid", String.valueOf(getSdkappid()));
            params.put("contenttype", getContenttype());
            params.put("identifier", getIdentifier());
            params.put("usersig", getUsersig());
            params.put("random", getRandom());

        } else {
            throw new JTIMException("请检查ConfigStorage");
        }
        return params;
    }

    public void setPriStr(String priStr) {
        this.priStr = priStr;
    }
}

