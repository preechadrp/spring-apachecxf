package com.example.soap.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService
public interface HelloService {

	@WebMethod
	@WebResult(name = "response")
	HelloResponse sayHello(
			@WebParam(name = "authHeader", header = true) AuthHeader authHeader, //ตัดออกและใช้ Interceptor แทนก็ได้จะเป็นที่นิยมกว่าเพราะเกี่ยวกับความปลอดภัย
			@WebParam(name = "request") HelloRequest request)
			throws BusinessFault;
}