package com.anjanda.letsmeet.user.jwt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 
 * @Date : 2021. 2. 1.
 * @Team : AnJanDa
 * @author : 개발자명
 * @Project : 레쓰밋 :: backend
 * @Function : JWT 토큰 사용을 위한 인터셉터
 * @Description : 올바른 토큰인지 체킹하는 인터셉터 (인터셉터 말 그대로, 로그인 정보를 백엔드 들어가기 전 토큰화하는 것이다)
 *
 */

@Component
public class JwtInterceptor implements HandlerInterceptor {
	
	/* JWT 서비스 객체 불러오기 */
	@Autowired
	private JwtService jwtService;
	
	/* 인터셉터 메소드 실행. 요청의 토큰값 체킹(서비스의 check메소드 활용) */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("토큰생성에 들어옴");
		// TODO Auto-generated method stub
		if (request.getMethod().contentEquals("OPTIONS")) {
			return true;
		}
		else {
			String token = request.getHeader("auth-token");
			if (token != null && token.length() > 0) {
				jwtService.checkValid(token);
				return true;
			}
			else {
				throw new RuntimeException("인증 토큰이 만료되었습니다.");
			}
		}
	}
}
