package com.agilisium.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses=UserRepository.class)
@EnableSwagger2
public class AgilisiumApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgilisiumApplication.class, args);
	}
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.agilisium.app.web.rest.resource")).build();
	}

}
