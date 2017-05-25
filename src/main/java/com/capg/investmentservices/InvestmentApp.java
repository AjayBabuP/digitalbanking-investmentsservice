package com.capg.investmentservices;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class InvestmentApp extends SpringBootServletInitializer {

	private static Logger log = Logger.getLogger(InvestmentApp.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InvestmentApp.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(InvestmentApp.class, args);
	}
}