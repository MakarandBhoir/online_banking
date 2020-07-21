package com.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.bank.service,com.bank.dao,com.bank")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	@Override
    public void addCorsMappings(CorsRegistry registry) {
       
        registry.addMapping("/**")
        .allowedOrigins("http://localhost:4200")
        .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
        .allowedHeaders("*")
        .allowCredentials(false).maxAge(3600);
    }
}
