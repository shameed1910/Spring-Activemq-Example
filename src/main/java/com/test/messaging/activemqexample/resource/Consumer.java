package com.test.messaging.activemqexample.resource;

import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	@JmsListener(destination="sample.queue")
	public void listen(String message){
		
		System.out.println("Recieved message::"  +message);
	}

}
