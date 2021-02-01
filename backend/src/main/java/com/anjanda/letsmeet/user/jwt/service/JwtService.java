package com.anjanda.letsmeet.user.jwt.service;

import java.sql.Date;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.anjanda.letsmeet.repository.dto.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @Date 2021. 1. 25.
 * @Team AnJanDa
 * @author 개발자명
 * @Project : Test
 * @Function : jwt 토큰 생성
 * @Description : 
 * 	- JWT 토큰을 사용하기 위해선, pom.xml에 jwt 관련 라이브러리 받아와야함.
 *	- 유효기간 60분이며 암호화처리됨
 *	- greeting은 없애도됨..(그냥 로그인성공했을 시, 확인하고자 greeting 에 값 넣어준 것)
 *
 */

@Component
public class JwtService {

	/* 암호화 설정을 위한 임의 문자열 변수 */
	private String signature = "LetsMeetSign";

	/* 로그인 성공시, 사용자 정보를 기반으로 JWT Token을 생성하여 반환 */
	public String create(User user) {
		JwtBuilder jwtBuilder = Jwts.builder();
		jwtBuilder.setHeaderParam("typ", "JWT"); // 헤더설정 => 토큰의 타입으로 고정 값 ???
		jwtBuilder.setSubject("로그인 토큰")	// 토큰의 제목 설정
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 유효기간 설정 : 60분
				.claim("user", user).claim("greeting", user.getuEmail() + "님 반갑습니다."); // 담고싶은 정보 설정 => .claim으로 정보 계속 담기 가능
	
		jwtBuilder.signWith(SignatureAlgorithm.HS256, signature.getBytes());	// 토큰 암호화 처리
	
		String jwt = jwtBuilder.compact();	// 마지막 직렬화 처리
		return jwt;
	}

	/* 제대로 생성되어 전달받은 토큰 확인 => 문제가 존재한다면, RuntimeException 처리 */
	public void checkValid(String jwt) {
		Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwt);
	}

	/* JWT 토큰을 분석해서 필요한 정보를 반환 */
	public Map<String, Object> get(String jwt) {
		Jws<Claims> claims = null;	// claims는 Map의 구현체로 활용
		try {
			claims = Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwt);
		} catch(final Exception e) {
			throw new RuntimeException();
		}
		return claims.getBody();
	}
}