package com.training.userservice.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import brave.Tracing;
import brave.http.HttpTracing;
import brave.spring.web.TracingClientHttpRequestInterceptor;
 

@Configuration
public class RestTemplateConfig {

	@Bean
	HttpTracing initHttpTracing(Tracing tracing) {
		return HttpTracing.newBuilder(tracing).build();
		
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate initRestTemplate(HttpTracing httptracing) {
		return new RestTemplateBuilder()
				.interceptors(TracingClientHttpRequestInterceptor.create(httptracing))
				.build();
	}
	
}
