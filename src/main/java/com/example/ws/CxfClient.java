package com.example.ws;

import com.alibaba.fastjson.JSONObject;
import com.example.ws.utils.WebServiceUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CxfClient {

    private final static String wsdlUrl = "http://127.0.0.1:8080/webservice/test?wsdl";

    public static void main(String[] args) {
        Object[] result1 = WebServiceUtils.callService(wsdlUrl, "userCall");
        log.info("callService result is {}", JSONObject.toJSON(result1));
        Object[] result2 = WebServiceUtils.callService(wsdlUrl, "getUserName", "赵铁柱");
        log.info("callService result is {}", JSONObject.toJSON(result2));
    }
}
