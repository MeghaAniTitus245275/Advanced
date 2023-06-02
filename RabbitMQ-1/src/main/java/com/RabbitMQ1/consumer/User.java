package com.RabbitMQ1.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.RabbitMQ1.config.Messagingconfig;
import com.RabbitMQ1.dto.OrderStatus;

@Component
public class User {
	
	@RabbitListener(queues=Messagingconfig.QUEUE)
	public void consumeMessageFromQueue(OrderStatus orderStatus)
	{
		System.out.println("Message received from queue: "+orderStatus);
	}

}
