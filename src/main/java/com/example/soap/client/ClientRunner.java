package com.example.soap.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClientRunner implements CommandLineRunner {

	private final HelloClient helloClient;

	public ClientRunner(HelloClient helloClient) {

		this.helloClient = helloClient;
	}

	@Override
	public void run(String... args) throws Exception {

		Thread.sleep(3000);
		helloClient.testCall();
	}
}