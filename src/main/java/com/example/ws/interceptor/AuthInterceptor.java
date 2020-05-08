package com.example.ws.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.NodeList;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

@Slf4j
public class AuthInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
    private SAAJInInterceptor saa = new SAAJInInterceptor();
    private static final String USER_NAME = "admin";
    private static final String USER_PASSWORD = "123456";

    public AuthInterceptor() {
        super(Phase.PRE_PROTOCOL);
        getAfter().add(SAAJInInterceptor.class.getName());
    }

    @Override
    public void handleMessage(SoapMessage soapMessage) throws Fault {
        SOAPMessage message = soapMessage.getContent(SOAPMessage.class);
        if (message == null) {
            saa.handleMessage(soapMessage);
            message = soapMessage.getContent(SOAPMessage.class);
        }
        SOAPHeader header = null;
        try {
            header = message.getSOAPHeader();
        } catch (SOAPException e) {
            log.error("getSOAPHeader error:{}", e.getMessage(), e);
            e.printStackTrace();
        }
        if (header == null) {
            throw new Fault(new IllegalAccessException("找不到Header, 无法验证用户信息"));
        }
        NodeList username = header.getElementsByTagName("username");
        NodeList password = header.getElementsByTagName("password");
        if (username.getLength() < 1) {
            throw new Fault(new IllegalAccessException("未找到username"));
        }
        if (password.getLength() < 1) {
            throw new Fault(new IllegalAccessException("未找到password"));
        }
        String userName = username.item(0).getTextContent().trim();
        String passWord = password.item(0).getTextContent().trim();
        if (USER_NAME.equals(userName) && USER_PASSWORD.equals(passWord)) {
            log.debug("admin auth success");
        } else {
            SOAPException soapException = new SOAPException("认证错误");
            log.debug("admin auth failed");
            throw new Fault(soapException);
        }
    }
}
