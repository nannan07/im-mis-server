package com.allmsi.mis.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Resource
	CacheInstenceSubclass cacheInstenceSubclass;

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
		InterceptorRegistration interceptorRegistration = registry
				.addInterceptor(new LoginInterceptor(cacheInstenceSubclass));
		interceptorRegistration.excludePathPatterns("/login", "/logout");
		interceptorRegistration.addPathPatterns("/**");
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
	}
	
}
