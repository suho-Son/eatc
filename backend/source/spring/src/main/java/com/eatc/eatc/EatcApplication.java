package com.eatc.eatc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("${mybatis.mapper-scan}")
@SpringBootApplication
public class EatcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EatcApplication.class, args);
	}

}
