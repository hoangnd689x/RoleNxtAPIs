package com.orgchart.orgchart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author YOG1HC
 *
 */
@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.orgchart.orgchart.controller", "com.orgchart.orgchart"})
@CrossOrigin(origins="http://localhost:4200")
@EnableSwagger2
public class OrgchartApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(OrgchartApplication.class, args);
	}

	   @Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.orgchart.orgchart")).build();
	   }
}
