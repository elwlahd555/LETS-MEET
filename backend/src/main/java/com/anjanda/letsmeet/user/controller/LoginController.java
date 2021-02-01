package com.anjanda.letsmeet.user.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anjanda.letsmeet.repository.dto.User;
import com.anjanda.letsmeet.user.jwt.JwtService;
import com.anjanda.letsmeet.user.service.UserService;

/**
 * 
 * @Date : 2021. 2. 1.
 * @Team : AnJanDa
 * @author : 개발자명
 * @Project : 레쓰밋 :: backend
 * @Function : 로그인 관련 컨트롤러
 * @Description 
 *	유저 관련된 것이지만, 로그인만 따로 처리해줄 필요성을 느껴 컨트롤러 부분만 뺌..(유저 컨트롤에 넣어도 되긴 함)
 */

@CrossOrigin(origins = { "*" }, maxAge = 6000)	// 이건 왜쓰지..
@RestController
@RequestMapping("/user")
public class LoginController {

	/* jwt 객체 불러오기 */
	@Autowired
	private JwtService jwtService;
	
	/* 유저 서비스 객체 불러오기 */
	@Autowired
	private UserService service;
	
	/* 로그인 */
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response, HttpSession session) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		User check = service.login(user);
		
		if(check != null) {
			String token = jwtService.create(check);
			
			// 파라미터 1번째 것은 FE 대로 따라가기..
			resultMap.put("auth-token", token);
			resultMap.put("uEmail", check.getuEmail()); 
			resultMap.put("uName", check.getuName());
			resultMap.put("uDefaultLat", check.getuDefaultLat());
			resultMap.put("uDefaultLng", check.getuDefaultLng());
			
			return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
		}
		resultMap.put("message", "로그인에 실패하였습니다.");
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.NO_CONTENT);
	}
}


// 우리 동빈이가 한 세션 로그인 컨트롤러!!!!!!
/*
package com.anjanda.letsmeet.login.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anjanda.letsmeet.login.service.LoginService;
import com.anjanda.letsmeet.repository.dto.User;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@GetMapping("/login")
	public void login(Model model) {
		model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 로그인 해주세요");
	}

	@PostMapping("/login")
	public String service(@RequestParam Map<String, String> map, HttpSession session, HttpServletResponse response,
			Model model) throws Exception {
		try {
			User user = loginService.login(map);
			if (user != null) { // 유저 정보가 왔을 경우
				session.setAttribute("userinfo", user);
				System.out.println(user.getuEmail());
				Cookie cookie = new Cookie("user_id", user.getuEmail());
				cookie.setPath("/");
				if ("saveok".equals(map.get("idsave"))) { // id저장 하면
					cookie.setMaxAge(60 * 60 * 24 * 365 * 50); // 단위가 초이기 때문에 초*분*시간*일*년을 하면 최대 ~년간 저장 된다.(윤년 고려 안함)
				} else {
					cookie.setMaxAge(0); // 저장 안하면 쿠키 저장 안함(0초간 저장)
				}
				response.addCookie(cookie);
			} else { // 유저 정보가 오지 않았으면 로그인 화면으로 리다이렉트
				return "redirect:login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
			return "error/loginError"; // 로그인 중 문제가 발생했으니 로그인 에러로 이동 (로그인 에러 페이지 따로 만들어야함)
		}
		return "redirect:/main"; // 메인으로 리다이렉트 보낸다.
	}

}

 */
