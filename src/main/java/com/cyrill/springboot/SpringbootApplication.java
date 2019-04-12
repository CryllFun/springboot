package com.cyrill.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cyrill.springboot.dao.mapper.donation")//(注解方式)对mapper包进行扫描,或者直接在 Mapper 类上面添加注解@Mapper
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}

