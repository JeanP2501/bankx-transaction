package com.bankx.transactions_service.api.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateTxRequest {
	
	@NotBlank(message = "El número de cuenta es requerido")
	private String accountNumber; 
	
	@NotBlank
    @Pattern(regexp = "^(CREDIT|DEBIT)$", message = "El tipo debe ser CREDIT o DEBIT")
	private String type; // CREDIT/DEBIT
	
	@NotNull(message = "La cantidad es requerida")
	@DecimalMin("0.01")
	private BigDecimal amount; 

}
