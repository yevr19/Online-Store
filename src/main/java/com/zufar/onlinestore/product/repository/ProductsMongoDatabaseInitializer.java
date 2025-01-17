package com.zufar.onlinestore.product.repository;

import com.zufar.onlinestore.product.dto.PriceDto;
import com.zufar.onlinestore.product.entity.ProductInfo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class ProductsMongoDatabaseInitializer {

	@Bean
	CommandLineRunner commandLineRunner(ProductInfoRepository repository) {
		return strings -> {
			repository.save(
					new ProductInfo(
							1,
							"Product1",
							new PriceDto(BigDecimal.valueOf(256.73), "GB"),
							"Category1"));
			repository.save(
					new ProductInfo(
							2,
							"Product2",
							new PriceDto(BigDecimal.valueOf(312.56), "GB"),
							"Category1"));
			repository.save(
					new ProductInfo(
							3,
							"Product3",
							new PriceDto(BigDecimal.valueOf(123.67), "GB"),
							"Category2"));
			repository.save(
					new ProductInfo(
							4,
							"Product4",
							new PriceDto(BigDecimal.valueOf(223.456), "GB"),
							"Category2"));
		};
	}
}
