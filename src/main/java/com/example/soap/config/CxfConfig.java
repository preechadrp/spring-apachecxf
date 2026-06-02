package com.example.soap.config;

import org.apache.cxf.Bus;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.example.soap.service.AuthInterceptor;
import com.example.soap.service.HelloServiceImpl;

@Configuration
public class CxfConfig {

	@Bean
	@DependsOn(Bus.DEFAULT_BUS_ID)
	jakarta.xml.ws.Endpoint helloEndpoint(
			Bus bus,
			HelloServiceImpl service) {

		EndpointImpl endpoint = new EndpointImpl(bus, service);

		endpoint.publish("/hello");

		endpoint.getInInterceptors().add(new AuthInterceptor());

		// log request
		endpoint.getInInterceptors().add(new LoggingInInterceptor());
		// log response
		endpoint.getOutInterceptors().add(new LoggingOutInterceptor());

		return endpoint;
	}

}