package com.anjanda.letsmeet.secure.jwt;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.anjanda.letsmeet.repository.dto.User;

public interface JwtService {

	/* 로그인 성공 시, 사용자 정보를 기반으로 JWT Token 생성 및 반환 */ // issue 메소드와 동일
	String create(User user);

	/* 생성되어 전달받은 토큰 확인 처리 => 토큰 문제 발생 시, RuntimeException 처리된다 */ // validateToken 메소드와 동일
	boolean checkValid(String jwt);

	/* JWT Token 분석해서 필요한 정보 반환하기 */	//  토큰을 파라미터로 받아 uNo 반환하는 것과 동일.. getTokenOwnerNo...
	int get(String jwt);
	
	/* http 요청을 파라미터로 받아 토큰 반환 */
    String parseTokenString(HttpServletRequest request);

}