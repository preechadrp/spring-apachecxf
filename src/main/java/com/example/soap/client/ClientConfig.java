package com.example.soap.client;

import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.soap.service.HelloService;

@Configuration
public class ClientConfig {

	@Bean
	HelloService helloServiceClient() {

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		factory.setServiceClass(HelloService.class);

		factory.setAddress("http://localhost:8080/ws/hello");

		// log request
		factory.getInInterceptors().add(new LoggingInInterceptor());
		// log response
		factory.getOutInterceptors().add(new LoggingOutInterceptor());

		return (HelloService) factory.create();
	}
}