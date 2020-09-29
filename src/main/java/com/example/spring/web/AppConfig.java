package com.example.spring.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
@ComponentScan("com.example.spring.resttemplate")
public class AppConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}




/*
===If using spring-web v3.x(3.0.2.RELEASE)===
@Bean
public RestTemplate restTemplate() {
	RestTemplate restTemplate = new RestTemplate();
	MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
	converter.setObjectMapper(new ObjectMapper());
	restTemplate.getMessageConverters().add(converter);
	return restTemplate;
}

===Also add below dependency===
<dependency>
	<groupId>org.codehaus.jackson</groupId>
	<artifactId>jackson-mapper-asl</artifactId>
	<version>1.9.13</version>
</dependency>
*/
