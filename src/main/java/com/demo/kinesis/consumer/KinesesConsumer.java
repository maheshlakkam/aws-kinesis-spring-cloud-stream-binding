package com.demo.kinesis.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class KinesesConsumer {

	Logger logger = LoggerFactory.getLogger(KinesesConsumer.class);

	@StreamListener("input")
	public void input(String messages) {
		logger.info("Message is:{}", messages);
		logger.info("Message has been consumed..");
	}

}
