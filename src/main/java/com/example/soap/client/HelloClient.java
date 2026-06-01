
package com.example.soap.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.stereotype.Component;

import com.example.soap.service.AuthHeader;
import com.example.soap.service.HelloRequest;
import com.example.soap.service.HelloService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HelloClient {

    public void testCall() throws Exception {

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		factory.setServiceClass(HelloService.class);

		factory.setAddress("http://localhost:8080/ws/hello");

		HelloService client = (HelloService) factory.create();

        AuthHeader header = new AuthHeader();
        header.setUserId("john");
        header.setToken("abc123");

		HelloRequest request = new HelloRequest();
		request.setName("Preecha");
		//request.setName(null);//test Fault

		var response = client.sayHello(
                        header,
                        request);

		log.info("response.getMessage() = {}", response.getMessage());

    }
}