package com.example.ws.service;

import com.example.ws.domain.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://impl.service.ws.example.com")
public interface WsTestService {

    @WebMethod
    List<User> userCall();

    @WebMethod
    @WebResult(name = "String")
    String getUserName(@WebParam(name = "name") String name);

}
