package com.bankx.transactions_service.legacy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskRuleRepository extends JpaRepository<RiskRule, Long> {
	
	Optional<RiskRule> findFirstByCurrency(String currency);

}
