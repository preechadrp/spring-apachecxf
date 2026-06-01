package com.example.soap.service;

import org.springframework.stereotype.Service;

import jakarta.jws.WebService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@WebService(serviceName = "HelloService", endpointInterface = "com.example.soap.service.HelloService")
public class HelloServiceImpl implements HelloService {

	@Override
	public HelloResponse sayHello(
			AuthHeader authHeader,
			HelloRequest request)
			throws BusinessFault {

		if (request.getName() == null) {
			throw new BusinessFault(
					"Name is required",
					new BusinessFaultInfo("ERR001", "Name is required"));
		}

		log.info("userId : {}", authHeader.getUserId());
		log.info("token : {}", authHeader.getToken());

		HelloResponse resp = new HelloResponse();
		resp.setMessage(request.getName());

		return resp;
	}
}