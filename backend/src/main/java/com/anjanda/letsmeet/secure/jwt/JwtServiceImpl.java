package com.anjanda.letsmeet.secure.jwt;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.h2.util.StringUtils;
import org.springframework.stereotype.Component;

import com.anjanda.letsmeet.repository.dto.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * 
 * @Date : 2021. 2. 1.
 * @Team : AnJanDa
 * @author : 김지현
 * @Project : 레쓰밋 :: backend
 * @Function : JWT 서비스
 * @Description : JWT 토큰 생성 및 암호화 처리 후, 메소드 선언
 *	
 */

@Component
public class JwtServiceImpl implements JwtService {
	
	/* 암호화 설정을 위한 임의 문자열 변수 */
	private String signature = "LetsMeet";
	
	/* 로그인 성공 시, 사용자 정보를 기반으로 JWT Token 생성 및 반환 */
	@Override
	public String create(User user) {
		System.out.println("토큰 생성");
		JwtBuilder jwtBuilder = Jwts.builder();
		jwtBuilder.setHeaderParam("typ",  "JWT");	// 헤더 설정 => 토큰의 타입으로 고정 값 역할
		jwtBuilder.setSubject("로그인 토큰") 			// 해당 토큰의 제목 설정
			.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))	// 해당 토큰의 유효기간 60분
			.claim("user", user).claim("Welcome", user.getuName() + "님 반갑습니다.");	// 담고싶은 정보 claim으로 추가 가능
		
		jwtBuilder.signWith(SignatureAlgorithm.HS256, signature.getBytes());		// 토큰 암호화 처리
		
		String jwt = jwtBuilder.compact();	// 마지막 직렬화 처리
		return jwt;
	}
	
	/* 생성되어 전달받은 토큰 확인 처리 => 토큰 문제 발생 시, RuntimeException 처리된다 */
	@Override
	public boolean checkValid(String jwt) {
		if(!StringUtils.isNullOrEmpty(jwt)) {
			try {
				Jwts.parser().setSigningKey(signature).parseClaimsJws(jwt);
				return true;
			} catch (MalformedJwtException e) {
            	e.printStackTrace();
            } catch (ExpiredJwtException e) {
            	e.printStackTrace();
            } catch (UnsupportedJwtException e) {
            	e.printStackTrace();
            } catch (IllegalArgumentException e) {
            	e.printStackTrace();
            }
		}
		return false;
	}
	
	/* JWT Token 분석해서 필요한 정보 반환하기 */
	@Override
	public int get(String jwt) {
		Claims claims = Jwts.parser().setSigningKey(signature).parseClaimsJws(jwt).getBody();
		return Integer.parseInt(claims.getSubject());
	}

	/* http 요청을 파라미터로 받아 토큰 반환 */
	@Override
	public String parseTokenString(HttpServletRequest request) {
		String parsingToken = request.getHeader("Authorization");
		if (parsingToken != null && parsingToken.startsWith("Parsing ")) {
			return parsingToken.substring(8);
		}
		return null;

	}

}
