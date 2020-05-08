package com.example.ws.utils;

import com.example.ws.interceptor.ClientLoginInterceptor;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class WebServiceUtils {

    private static final String USER_NAME = "admin";
    private static final String PASS_WORD = "123456";

    public static Object[] callService(String wsdlUrl, String operationName) {
        Client client = JaxWsDynamicClientFactory.newInstance().createClient(wsdlUrl);
        client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        try {
            return client.invoke(operationName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object[] callService(String wsdlUrl, String operationName, Object... params) {
        Client client = JaxWsDynamicClientFactory.newInstance().createClient(wsdlUrl);
        client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        try {
            return client.invoke(operationName, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
