package com.citi.mongodb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket api() {
	 System.out.println("test...");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.citi.mongodb.controller"))
               // .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
        
    }
 
 private ApiInfo metaData() {
	 
	 ApiInfo apiInfo = new ApiInfo("Mongo REST API", 
			 "", "1.0", "Terms of service URL", "", "", "");
	 return apiInfo;
	 
 }
}