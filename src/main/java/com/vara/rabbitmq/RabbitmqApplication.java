package com.vara.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Override
	public void run(String... args) throws Exception {
		//rabbitTemplate.convertAndSend("Hello World - RabbitMQ 1st Message");// defualt exchange
		//rabbitTemplate.convertAndSend("TestExchange","testRouting", "Hello from using TextEchange");
		SimpleMessage simpleMessage= new SimpleMessage();
		simpleMessage.setName("FirstMessage");
		simpleMessage.setDescription("simple description");
	//	rabbitTemplate.convertAndSend("TestExchange","testRouting",simpleMessage);
		rabbitTemplate.convertAndSend("MyTopicExchange","topic",simpleMessage);// you can make a call from another application also
	}
}
