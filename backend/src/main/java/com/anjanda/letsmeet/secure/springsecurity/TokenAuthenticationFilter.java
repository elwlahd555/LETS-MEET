package com.anjanda.letsmeet.secure.springsecurity;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.anjanda.letsmeet.repository.dto.User;
import com.anjanda.letsmeet.secure.jwt.JwtService;
import com.anjanda.letsmeet.user.service.UserService;

/**
 * 
 * @Date : 2021. 2. 8.
 * @Team : AnJanDa
 * @author : 김지현
 * @deploy : 김동빈
 * @Project : 레쓰밋 :: backend
 * @Function : Spring Security 인증 절차 추가하기
 * @Description : 실제 인증 수행하는 검사기 + 인증 절차 추가
 *
 */

public class TokenAuthenticationFilter extends OncePerRequestFilter {
	
	/* Jwt 서비스 객체 불러오기 */
	@Autowired
	private JwtService jwtService;
	
	/* 유저 서비스 객체 불러오기 */
	@Autowired
	private UserService userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String token = jwtService.parseTokenString(request);	// http에서 토큰 받아오기
		
		if(jwtService.checkValid(token)) {
			int uNoInToken = jwtService.get(token);
            try {
                User user = (User) userService.selectUserByUNo(uNoInToken);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,
                        user.getuPassword());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (UsernameNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
				e.printStackTrace();
			}
        filterChain.doFilter(request, response);
		}
	}
}
