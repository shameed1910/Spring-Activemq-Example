package com.test.messaging.activemqexample.resource.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@EnableJms
@Configuration
public class Config {
	
	@Value("${activemq.broker-url}")
	public String brokerurl;
	
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("sample.queue");
	}
	
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory(){
		ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(brokerurl);;
		return connectionFactory;
		
	}
	
	@Bean
	public JmsTemplate jmsTemplate(){
		return new JmsTemplate(activeMQConnectionFactory());
	}

}
