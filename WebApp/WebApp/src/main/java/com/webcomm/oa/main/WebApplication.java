package com.webcomm.oa.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
@ComponentScan(basePackages = { "com.webcomm.oa.controller", 
								"com.webcomm.oa.service"
								})
@EnableJpaRepositories(basePackages = {"com.webcomm.oa.repository"})
@EntityScan(basePackages = {"com.webcomm.oa.domain"})
@EnableTransactionManagement
public class WebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
