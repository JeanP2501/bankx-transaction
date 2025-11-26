package com.bankx.transactions_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bankx.transactions_service.domain.Transaction;

import reactor.core.publisher.Sinks;

@Configuration
class SinkConfig {
	
	@Bean
	public Sinks.Many<Transaction> txSink() {
		return Sinks.many().multicast().onBackpressureBuffer();
	}

}
