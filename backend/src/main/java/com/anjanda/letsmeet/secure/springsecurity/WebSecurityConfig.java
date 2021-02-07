package com.anjanda.letsmeet.secure.springsecurity;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 
 * @Date : 2021. 2. 8.
 * @Team : AnJanDa
 * @author : 김지현
 * @deploy : 김동빈
 * @Project : 레쓰밋 :: backend
 * @Function : SpringBoot SecurityConfig
 * @Description : 시큐리티 설정 (REST API 서버 사용하기 위한 설정)
 *	- 정확히 말하자면, 인증에 필요한 기능을 제공해주는 JwtServiceImpl를 통해 인증을 수행하는 로직을 구현
 *	- 토큰 유효한지 확인 후 회원정보를 조회 및 인증 객체를 생성해 프레임워크에 전달하는 간단한 로직입니다.
 */

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/* 정적 자원에 대해서는 Security 설정 하지 않음 */
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
	}
	
	/* Security 설정 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.csrf()					// 개발 편의성을 위해 CSRF 프로텍션 비활성화
				.disable()
			.httpBasic()			// Http 기본 인증 비활성화
				.disable()
			.formLogin()			// 로그인 폼 변경 유무
//				.disable()
				.loginPage("/login")
				.failureForwardUrl("/login") // 로그인 실패시, 다시 로그인화면
				.permitAll()
				.and()
			.sessionManagement()			// stateless한 세션 정책 설정
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
			.authorizeRequests()	// 리소스별 허용 범위 설정 => 루트와 main, 마이페이지 요청에 대해서 요청 허용
				.antMatchers("/", "/main", "/user/mypage/**") 
					.permitAll()
				.anyRequest()		// 나머지 경로는 사용자 인증이 된 요청에 대해서만 요청 허용
					.authenticated()	
//					.permitAll()	// 위에꺼 안쓰고 이거 쓰면, 나머지 요청에 대해 로그인 요구하지않는다는 것
				.and()
			.logout()				// 로그아웃
				.permitAll()
//				.and()
//			.exceptionHandling()	// 인증 오류 발생시, 처리를 위한 핸들러 추가
//				.authenticationEntryPoint(new RestAuthenticationEntryPoint());
			;
		
		/* 토큰 인증 필터 추가 */
		http.addFilterBefore(new TokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	

}
