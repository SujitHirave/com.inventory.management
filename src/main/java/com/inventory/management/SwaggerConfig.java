package com.inventory.management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;
import java.util.List;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final Logger LOG = LoggerFactory.getLogger(SwaggerConfig.class);
	
//	private static final String BASIC_AUTH = "basicAuth";
//    private static final String BEARER_AUTH = "Bearer";
// 

	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	      .apiInfo(apiInfo())
	      .securityContexts(Arrays.asList(securityContext()))
	      .securitySchemes(Arrays.asList(apiKey()))
	      .select()
	      .apis(RequestHandlerSelectors.any())
	      .paths(PathSelectors.any())
	      .build();
	}

	@Bean
	SecurityContext securityContext() { 
	    return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
	}

	 List<SecurityReference> defaultAuth() { 
	    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
	    authorizationScopes[0] = authorizationScope; 
	    return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
	}

	private ApiKey apiKey() {
	    return new ApiKey("JWT", "Authorization", "header");
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "My REST API",
	      "Some custom description of API.",
	      "1.0",
	      "Terms of service",
	      new Contact("sumit", "com.inventory.management", "sumit@gmail.com"),
	      "License of API",
	      "API license URL",
	      Collections.emptyList());
	}

//	@Bean
//	public Docket api() {
//		LOG.info("Docket api");
//		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any()).build();
//	}

}

