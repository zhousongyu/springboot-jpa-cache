package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootMultiDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMultiDatasourceApplication.class, args);
	}
}
