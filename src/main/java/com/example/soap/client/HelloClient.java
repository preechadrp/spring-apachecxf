
package com.example.soap.client;

import org.springframework.stereotype.Component;

import com.example.soap.service.AuthHeader;
import com.example.soap.service.BusinessFault;
import com.example.soap.service.HelloRequest;
import com.example.soap.service.HelloResponse;
import com.example.soap.service.HelloService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HelloClient {

	private final HelloService helloServiceClient;

	public HelloClient(
			HelloService helloServiceClient) {

		this.helloServiceClient = helloServiceClient;
	}

    public void testCall() throws Exception {

        AuthHeader header = new AuthHeader();
        header.setUserId("john");
        header.setToken("abc123");

		HelloRequest request = new HelloRequest();
		request.setName("Preecha");
		//request.setName(null);//test Fault

		HelloResponse response = null;
		try {

			response = helloServiceClient.sayHello(header, request);
			log.info("response.getMessage() = {}", response.getMessage());

		} catch (BusinessFault e) {
			System.out.println(e.getFaultInfo().getErrorCode());
			System.out.println(e.getFaultInfo().getErrorMessage());
		}

    }
}