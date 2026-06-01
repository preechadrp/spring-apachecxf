package com.example.soap.service;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthInterceptor extends AbstractSoapInterceptor {

	public AuthInterceptor() {
		super(Phase.PRE_PROTOCOL);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		List<org.apache.cxf.headers.Header> headers = message.getHeaders();

		//== ตรวจ class
		for (var h : headers) {
			log.info("QName={}", h.getName());
			log.info("Class={}", h.getObject().getClass());
		}

		//== อ่านแบบตรงๆ
		org.w3c.dom.Element element = (org.w3c.dom.Element) headers.getFirst().getObject();

		String userId = element.getElementsByTagName("userId").item(0).getTextContent();
		String token = element.getElementsByTagName("token").item(0).getTextContent();

		log.info("userId = {}", userId);
		log.info("token = {}", token);

	}
}