package com.example.ws.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.ws.utils.WebServiceUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    private final static String wsdlUrl = "http://127.0.0.1:8080/webservice/test?wsdl";

    @RequestMapping(value = "ws/{operationName}")
    public Object testWebService(@PathVariable("operationName") String operationName, String param) {
        Object[] result;
        if (param == null || param.length() < 1) {
            result = WebServiceUtils.callService(wsdlUrl, operationName);
        } else {
            result = WebServiceUtils.callService(wsdlUrl, operationName, param);
        }
        log.info("callService result is {}", JSONArray.toJSON(result));
        return result;
    }
}
