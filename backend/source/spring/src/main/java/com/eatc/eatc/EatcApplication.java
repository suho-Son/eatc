package com.eatc.eatc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.eatc.eatc.mapper")  // ✅ 정확한 패키지로 수정!
@SpringBootApplication
public class EatcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EatcApplication.class, args);
	}

}
