package com.zufar.onlinestore.transacton.converter;

import com.zufar.onlinestore.transacton.dto.TransactionRequest;
import com.zufar.onlinestore.transacton.dto.PurchaseTransactionDto;
import com.zufar.onlinestore.product.ProductsSumCalculator;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseTransactionDtoConverter {
	private final ProductsSumCalculator productsSumCalculator;

	public PurchaseTransactionDto convert(final TransactionRequest request) {
		BigDecimal totalSum = productsSumCalculator.calculate(request.getProducts());

		return PurchaseTransactionDto.builder()
				.transactionId(UUID.randomUUID())
				.customerId(request.getCustomerId())
				.totalSum(totalSum)
				.createdAt(LocalDateTime.now())
				.build();
	}
}
