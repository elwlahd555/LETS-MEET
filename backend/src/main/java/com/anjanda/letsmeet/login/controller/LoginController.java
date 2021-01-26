package com.anjanda.letsmeet.login.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anjanda.letsmeet.login.service.LoginService;
import com.anjanda.letsmeet.repository.dto.User;

@Controller
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
