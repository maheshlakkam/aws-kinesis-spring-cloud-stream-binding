package com.demo.kinesis.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.demo.kinesis.consumer.KinesesConsumer;

@Component
@EnableBinding(Source.class)
public class KinesProducer {
	Logger logger = LoggerFactory.getLogger(KinesesConsumer.class);
	@Autowired
	private Source source;

	@Scheduled(fixedDelay = 3000L)
	public void produce() {
		source.output().send(MessageBuilder.withPayload("Test Message...").build());
		logger.info("Message has been Sent to Kinesis");
	}

}
