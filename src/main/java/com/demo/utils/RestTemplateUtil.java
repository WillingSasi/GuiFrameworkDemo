package com.demo.utils;

import com.demo.config.LogInit;
import com.google.gson.JsonObject;
import  com.google.gson.JsonParser;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.demo.utils.Constant.CAPPAuthorization;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class RestTemplateUtil {
    private Logger logger = LogInit.getInstance();
    public static final String RESPONSE_STATUS = "status";
    public static final String RESPONSE_TOKEN = "token";
    public static final String RESPONSE_IDCARDTOKEN = "idCardToken";
    public static final String RESPONSE_CONTENT = "response";
    public static final String RESPONSE_SESSIONTOKEN = "sessionToken";

    public JsonObject doGet(String url) {
        logger.info("URL:{}", url);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JsonObject> responseEntity = restTemplate.getForEntity(url, JsonObject.class);
        serverIsRight(responseEntity);   //判断服务器返回状态码
        return responseEntity.getBody();
    }

    public Map<String, Object> doPostJson(JsonObject param, String url,HttpHeaders headers) {
        logger.info("URL:{}", url);
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> returnData = new HashMap<String, Object>();
        //设置提交json格式数据
        HttpEntity<String> request = new HttpEntity<String>(param.toString(), headers);
        //访问lm模块接口时，如果不做处理，报：unable to find valid certification path to requested target
        try {
            SSLUtil.turnOffSslChecking();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, request, String.class);
        serverIsRight(responseEntity);  //判断服务器返回状态码

        JsonObject returnBody = new JsonParser().parse(responseEntity.getBody()).getAsJsonObject();

        returnData.put("header",responseEntity.getHeaders().toSingleValueMap());
        returnData.put("body",returnBody);
        return returnData;
    }

    public Map<String, Object> doPostForm( MultiValueMap<String, String> map, String url,HttpHeaders headers)
    {
        logger.info("URL:{}", url);
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> returnData = new HashMap<String, Object>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//        ResponseEntity<JsonObject> responseEntity = restTemplate.postForEntity(url, request, JsonObject.class);
       //访问lm模块接口时，如果不做处理，报：unable to find valid certification path to requested target
        try {
            SSLUtil.turnOffSslChecking();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, request, String.class);
        serverIsRight(responseEntity);  //判断服务器返回状态码
        JsonObject returnBody = new JsonParser().parse(responseEntity.getBody()).getAsJsonObject();

        returnData.put("header",responseEntity.getHeaders().toSingleValueMap());
        returnData.put("body",returnBody);

        return returnData;
    }

    public void serverIsRight(ResponseEntity responseEntity) {
        if (responseEntity.getStatusCodeValue() == 200) {
            logger.info("服务器请求成功：" + responseEntity.getStatusCodeValue());
        } else {
            logger.info("服务器请求异常：" + responseEntity.getStatusCodeValue());
        }
    }
}
