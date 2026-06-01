package com.example.soap.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.soap.service.AuthInterceptor;
import com.example.soap.service.HelloServiceImpl;

@Configuration
public class CxfConfig {

	@Bean
	jakarta.xml.ws.Endpoint helloEndpoint(
			Bus bus,
			HelloServiceImpl service) {

		EndpointImpl endpoint = new EndpointImpl(bus, service);

		endpoint.publish("/hello");

		endpoint.getInInterceptors().add(new AuthInterceptor());

		return endpoint;
	}

}