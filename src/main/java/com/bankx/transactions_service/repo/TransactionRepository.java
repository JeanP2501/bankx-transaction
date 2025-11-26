package com.bankx.transactions_service.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bankx.transactions_service.domain.Transaction;

import reactor.core.publisher.Flux;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
	
	Flux<Transaction> findByAccountIdOrderByTimestampDesc(String accountId);
	
}