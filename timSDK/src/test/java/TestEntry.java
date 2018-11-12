import com.alibaba.fastjson.JSONObject;
import com.zs.tim.ConfigStorage;
import com.zs.tim.entity.TIMAccount;
import com.zs.tim.entity.TIMResponse;
import com.zs.tim.exception.JTIMException;
import com.zs.tim.exception.RequestException;
import com.zs.tim.service.TIMService;
import com.zs.tim.service.impl.TIMDefaultService;
import com.zs.tim.utils.RequestUtil;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class TestEntry extends TestCase {




    public void testRequestUtils() throws RequestException {
        String uri = "http://v.juhe.cn/weather/index";
        Map<String, String> params = new HashMap<>();
        params.put("cityname","武汉");
        params.put("key","9b58bfecfc853a7d5e8796f0ffe79704");
        JSONObject result = RequestUtil.doGet(uri, params);
        System.out.println(result.toJSONString());

    }

    public void testTimeServices() throws JTIMException {
        long appid = 1400160879;
        String priStr = "-----BEGIN PRIVATE KEY-----\n" +
                "MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgN5HsKDjizYsxxQhX\n" +
                "h9spfMMFkAhxW8yBvI7xjDPez7OhRANCAAT9m63ZE3t7QBEmzG8OnZBgYRa4xlg0\n" +
                "1JJa6yw/MrKNSPJJqumU1nmkIBu3iCpph7yzB7LgKBphAnXbMByjkPP7\n" +
                "-----END PRIVATE KEY-----";
        String identifier = "admin";
        ConfigStorage config = new ConfigStorage();

        config.setIdentifier(identifier);
        config.setSdkappid(appid);
        config.setPriStr(priStr);



        TIMService timService = new TIMDefaultService(config);
        TIMAccount account = new TIMAccount();

        account.setFaceUrl("url");
        account.setIdentifier("asdfrewgterwga");
        account.setNick("test_first");

        TIMResponse response = timService.getTIMAccountService().importAccount(account);


        System.out.println(JSONObject.toJSONString(response));
    }
}
