package com.anjanda.letsmeet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.anjanda.letsmeet.user.jwt.interceptor.JwtInterceptor;
/**
 * 
 * @Date 2021. 1. 26.
 * @Team AnJanDa
 * @author 김지현
 * @Project : Test - init 및 jwt 설치
 * @Function : init
 * @Description :
 * 	- 시작 시, 로그인과 관련된 jwt 토큰 설정하기 위한 객체 불러오기 + 시작
 *
 */

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	/* JWT 인터셉터 객체 불러오기 */
	@Autowired
	private JwtInterceptor jwtInterceptor;
	
	/* JWT 인터셉터 설치 : 인터셉터 적용할 경로와 제외할 경로 설정 :: 로그인화면때, 회원정보부를때 ,비번찾기할 땐 필요없으므로 exclude처리 */
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor).addPathPatterns("/user/**")
											.excludePathPatterns(Arrays.asList("/user/login", "/user", "/user/check/**", "user/forgot/**"));
	}
	
	/* 전역의 Cors Origin 처리 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("*")
			.allowedHeaders("*")
			.exposedHeaders("auth-token");
	}
}
