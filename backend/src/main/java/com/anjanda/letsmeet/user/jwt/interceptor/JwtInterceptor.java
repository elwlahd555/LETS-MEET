package com.anjanda.letsmeet.user.jwt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.anjanda.letsmeet.user.jwt.service.JwtService;

/**
 * 
 * @Date 2021. 1. 25.
 * @Team AnJanDa
 * @author 개발자명
 * @Project : Test
 * @Function : jwt의 인터셉터
 * @Description
 * 	- 쉽게말해, 클라이언트에서 서버로의 요청을 보내는 과정에 있어, 인터셉터가 중간에 요청을 가로채서 해당 정보의 어떠한 작업을 처리하는 과정
 * 	- 정상 작업 완료시, 서버로 보냄
 * 	- 정사 작업 실패시, 클라이언트로 돌려보냄
 *
 */

@Component
public class JwtInterceptor implements HandlerInterceptor {

	/* jwt서비스 객체 불러오기 */
	@Autowired
	private JwtService jwtService;

	/* 인터셉터 메소드 실행 => 요청의 토큰값 체킹 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	
		if(request.getMethod().contentEquals("OPTIONS")) {
			return true;
		}
		else {	// CRUD (get, post, put, delete) 받아왔다면, 요청에서 헤더로 값 받아오기
			String token = request.getHeader("auth-token");	// 헤더로 받은 auth-token 값 받기 (유효한 토큰 받아내기)
			if(token != null && token.length() > 0) {
				jwtService.checkValid(token);
				return true;
			}
		else {
			throw new RuntimeException("인증 토큰이 만료되었습니다.");
		}
	}
}


}