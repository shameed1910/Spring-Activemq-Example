package com.test.messaging.activemqexample.resource;

import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.xml.ws.RespectBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/publish")
public class Producer {
	
	@Autowired
	private JmsTemplate jmsTemplate;
		
	
	@Autowired
	private Queue queue;
	
	@GetMapping("/{message}")
	public String publishMessage(@PathVariable("message") final String message){
		
		
		jmsTemplate.convertAndSend(queue,message);
		return message;
		
	}
	

}
