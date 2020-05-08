package com.example.ws.config;

import com.example.ws.service.WsTestService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WsConfig {

    private final WsTestService wsTestService;

    @Autowired
    public WsConfig(WsTestService wsTestService) {
        this.wsTestService = wsTestService;
    }

    @Bean(name = "cxfServlet")
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/webservice/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean(name = "wsTestServiceEndPoint")
    public Endpoint wsTestServiceEndPoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), wsTestService);
        endpoint.publish("/test");
        return endpoint;
    }
}
