package com.example.soap.service;

import jakarta.xml.ws.WebFault;

@WebFault(name = "BusinessFault")
public class BusinessFault extends Exception {

	private static final long serialVersionUID = 1L;

	private final BusinessFaultInfo faultInfo;

	public BusinessFault(String message,
			BusinessFaultInfo faultInfo) {

		super(message);
		this.faultInfo = faultInfo;
	}

	public BusinessFaultInfo getFaultInfo() {
		return faultInfo;
	}
}