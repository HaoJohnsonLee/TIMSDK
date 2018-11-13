import com.alibaba.fastjson.JSONObject;
import com.zs.tim.ConfigStorage;
import com.zs.tim.entity.pojo.Msg.MsgBody;
import com.zs.tim.entity.pojo.Msg.MsgText;
import com.zs.tim.entity.request.BatchSendMsg;
import com.zs.tim.entity.request.SendMsg;
import com.zs.tim.entity.request.TIMAccount;
import com.zs.tim.entity.response.TIMBatchSendMsgResponse;
import com.zs.tim.entity.response.TIMResponse;
import com.zs.tim.exception.JTIMException;
import com.zs.tim.exception.RequestException;
import com.zs.tim.service.TIMService;
import com.zs.tim.service.impl.TIMDefaultService;
import com.zs.tim.utils.RequestUtil;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEntry extends TestCase {
    /**
     * 生成配置信息config
     */
    ConfigStorage config;

    {
        long appid = 1400160879;
        String priStr = "-----BEGIN PRIVATE KEY-----\n" +
                "MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgN5HsKDjizYsxxQhX\n" +
                "h9spfMMFkAhxW8yBvI7xjDPez7OhRANCAAT9m63ZE3t7QBEmzG8OnZBgYRa4xlg0\n" +
                "1JJa6yw/MrKNSPJJqumU1nmkIBu3iCpph7yzB7LgKBphAnXbMByjkPP7\n" +
                "-----END PRIVATE KEY-----";
        String identifier = "admin";
        config = new ConfigStorage();
        config.setIdentifier(identifier);
        config.setSdkappid(appid);
        config.setPriStr(priStr);
    }

    /**
     * 测试工具类
     * @throws RequestException
     */
    public void testRequestUtils() throws RequestException {
        String uri = "http://v.juhe.cn/weather/index";
        Map<String, String> params = new HashMap<>();
        params.put("cityname","武汉");
        params.put("key","9b58bfecfc853a7d5e8796f0ffe79704");
        JSONObject result = RequestUtil.doGet(uri, params);
        System.out.println(result.toJSONString());

    }

    /**
     * 测试TIMDefaultAccountService.importAccount()方法
     * @throws JTIMException
     */
    public void testImportAccount() throws JTIMException {
        TIMAccount account = new TIMAccount();
        account.setFaceUrl("url");
        account.setIdentifier("asdfrewgterwga");
        account.setNick("test_first");

        TIMService timService = new TIMDefaultService(config);
        TIMResponse response = timService.getTIMAccountService().importAccount(account);

        System.out.println(JSONObject.toJSONString(response));
    }

    /**
     * 测试TIMDefaultAccountService.kick()方法
     * @throws JTIMException
     */
    public void testKick() throws JTIMException{
        //TIMAccountService timAccountService =TIMDefaultAccountService.getTIMAccountService(config);
        //TIMResponse timResponse = timAccountService.kick("uihi");

        TIMService timService=new TIMDefaultService(config);
        TIMResponse timResponse=timService.getTIMAccountService().kick("abcd");

        System.out.println(JSONObject.toJSONString(timResponse));

    }


    /**
     * 测试TIMDefaultMessageService.sendMsg()方法
     */
    public void testSendMsg(){
        TIMService timService=new TIMDefaultService(config);
        SendMsg sendMsg=new SendMsg();
        List<MsgBody> msgBodies=new ArrayList<>();
        MsgBody msgBody=new MsgText();
        MsgText.MsgContentBean msgContentBean=new MsgText.MsgContentBean();
        msgContentBean.setText("this is a test");
        ((MsgText) msgBody).setMsgContent(msgContentBean);
        msgBodies.add(msgBody);

        sendMsg.setSyncOtherMachine(1);
        sendMsg.setTo_Account("lumotuwe2");
        sendMsg.setMsgLifeTime(60);
        sendMsg.setMsgRandom(1287657);
        sendMsg.setMsgTimeStamp(5454457);
        sendMsg.setMsgBodies(msgBodies);
        TIMResponse timResponse=null;
        try {
            timResponse=timService.getTIMMessageService().sendMsg(sendMsg);
        } catch (JTIMException e) {
            e.printStackTrace();
        }
        System.out.println(JSONObject.toJSONString(timResponse));
    }

    /**
     * 测试测试TIMDefaultMessageService.BatchSendMsg
     * @throws JTIMException
     */
    public void testBatchSendMsg() throws JTIMException{
        TIMService timService=new TIMDefaultService(config);
        BatchSendMsg batchSendMsg=new BatchSendMsg();
        batchSendMsg.setFrom_Account("admin");
        List<String> list=new ArrayList<>();
        list.add("lilei");
        list.add("haaha");

        List<MsgBody> msgBodies=new ArrayList<>();
        MsgBody msgBody=new MsgText();
        MsgText.MsgContentBean msgContentBean=new MsgText.MsgContentBean();
        msgContentBean.setText("this is a test");
        ((MsgText) msgBody).setMsgContent(msgContentBean);

        msgBodies.add(msgBody);
        batchSendMsg.setTo_Account(list);
        batchSendMsg.setMsgBody(msgBodies);

        TIMBatchSendMsgResponse timBatchSendMsgResponse=timService.getTIMMessageService().batchSendMsg(batchSendMsg);

        System.out.println(JSONObject.toJSONString(timBatchSendMsgResponse));

    }
}
