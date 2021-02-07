package com.anjanda.letsmeet.secure.springsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	/*  */
	public void addViewControllers(ViewControllerRegistry registry) {
		// 아래의 내용 계속 추가해서 매핑과 뷰이름 연결해야함.
		registry.addViewController("/").setViewName("main"); 
		registry.addViewController("/login").setViewName("login"); 
		
		
	}
}
