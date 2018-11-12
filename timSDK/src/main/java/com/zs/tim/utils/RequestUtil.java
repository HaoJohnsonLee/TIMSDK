package com.zs.tim.utils;

import com.alibaba.fastjson.JSONObject;
import com.zs.tim.ConfigStorage;
import com.zs.tim.exception.JTIMException;
import com.zs.tim.exception.RequestException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Map;



@SuppressWarnings("Duplicates")
public class RequestUtil {
    private static CloseableHttpClient client;
    static {
        client = HttpClients.createDefault();
    }



    public static JSONObject doPost(JSONObject body, String uri, Map<String,String> params) throws RequestException {
        // 构造请求实体
        HttpPost request = new HttpPost();
        request.setHeader("Content-type", "application/json; charset=utf-8");
        request.setHeader("Connection", "Close");
        if(StringUtils.isBlank(uri)) throw new RequestException("");
        // 注入请求实体
        StringEntity entity = new StringEntity(body.toJSONString(), Charset.forName("UTF-8"));
        request.setEntity(entity);
        // 注入请求参数
        StringBuffer sb = new StringBuffer(uri);
        if(params!=null && params.size() > 0){
            boolean hasPre = false;
            sb.append('?');
            for(String key : params.keySet()){
                if(hasPre)sb.append('&');
                sb.append(key).append('=').append(params.get(key));
                hasPre = true;
            }
        }
        try {
            request.setURI(new URI(sb.toString()));
        } catch (URISyntaxException e) {
            throw new RequestException("URI格式错误");
        }
        CloseableHttpResponse response = null;
        try {
            response = client.execute(request);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                InputStream is = response.getEntity().getContent();
                String content = IOUtils.toString(is, Charset.forName("UTF-8"));
                return JSONObject.parseObject(content);
            }
        } catch (IOException e) {
            throw new RequestException("请求服务器失败");
        }finally {
            if(response!=null){
                try {
                    response.close();
                } catch (IOException ignored) {}
            }
        }
        throw new RequestException("请求服务器失败");

    }


    public static JSONObject doGet(String uri, Map<String,String> params) throws RequestException {
        HttpGet get = new HttpGet();
        // 注入请求参数
        StringBuffer sb = new StringBuffer(uri);
        if(params!=null && params.size() > 0){
            boolean hasPre = false;
            sb.append('?');
            for(String key : params.keySet()){
                if(hasPre)sb.append('&');
                sb.append(key).append('=').append(params.get(key));
                hasPre = true;
            }
        }
        try {
            get.setURI(new URI(sb.toString()));
        } catch (URISyntaxException e) {
            throw new RequestException("URI格式错误");
        }
        CloseableHttpResponse response = null;
        try {
            response = client.execute(get);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                InputStream is = response.getEntity().getContent();
                String content = IOUtils.toString(is, Charset.forName("UTF-8"));
                return JSONObject.parseObject(content);
            }
        } catch (IOException e) {
            throw new RequestException("请求服务器失败");
        }finally {
            if(response!=null){
                try {
                    response.close();
                } catch (IOException ignored) {}
            }
        }
        throw new RequestException("请求服务器失败");

    }


    public static JSONObject doPost(JSONObject body, String uri, ConfigStorage config) throws JTIMException {
        return doPost(body, uri, config.getParams());

    }

    public static JSONObject doGet(String uri, ConfigStorage configStorage) throws JTIMException {
        return doGet(uri, configStorage.getParams());
    }


    public static <T> T doPost(JSONObject body, String uri, ConfigStorage config, Class<T> clazz) throws JTIMException {
        return doPost(body, uri, config).toJavaObject(clazz);
    }
}
