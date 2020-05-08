package com.example.ws.utils;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class WebServiceUtils {

    public static Object[] callService(String wsdlUrl, String operationName) {
        Client client = JaxWsDynamicClientFactory.newInstance().createClient(wsdlUrl);
        try {
            return client.invoke(operationName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object[] callService(String wsdlUrl, String operationName, Object... params) {
        Client client = JaxWsDynamicClientFactory.newInstance().createClient(wsdlUrl);
        try {
            return client.invoke(operationName, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
