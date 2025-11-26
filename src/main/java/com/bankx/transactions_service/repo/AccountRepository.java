package com.bankx.transactions_service.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bankx.transactions_service.domain.Account;

import reactor.core.publisher.Mono;

public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
	
	Mono<Account> findByNumber(String number);
	
}
